package com.edu.nbu.cn.mybatis.plugins;


import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.util.messages.Messages;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class CodeGeneratorPlugin extends PluginAdapter {
    private static String FULLY_QUALIFIED_PAGE = "com.edu.nbu.cn.mybatis.plugins.Page";
    private static String XMLFILE_POSTFIX = "Ext";
    private static String JAVAFILE_POTFIX = "Ext";
    private static String ANNOTATION_RESOURCE = "org.apache.ibatis.annotations.Mapper";
    private static String XSL_BASE_PATH = "/generator/xsl";
    private static Set<String> BASE_MODEL_FIELDS_SET = new HashSet();
    private static Set<String> BASE_MODEL_METHODS_SET = new HashSet();

    /**
     * 是否生成manager<br/>
     * -Dmybatis.generator.myPlugins.manager=true<br/>
     * 默认为true
     */
    private static Boolean generateManager = Boolean.valueOf(System.getProperty("mybatis.generator.myPlugins.manager", "true"));
    /**
     * 是否生成controller<br/>
     * -Dmybatis.generator.myPlugins.controller=true<br/>
     * 默认为true
     */
    private static Boolean generateContropller = Boolean.valueOf(System.getProperty("mybatis.generator.myPlugins.controller", "true"));

    public CodeGeneratorPlugin() {
    }

    public static void main(String[] args) {
        String config = CodeGeneratorPlugin.class.getClassLoader().getResource("generatorConfig.xml").getFile();
        String[] arg = {"-configfile", config};
        ShellRunner.main(arg);
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        ((Field) topLevelClass.getFields().get(0)).setInitializationString("\"id asc\"");
        this.addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        FullyQualifiedJavaType page = new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE);
        topLevelClass.addImportedType(page);
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(page);
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(page, name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(page);
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * 逻辑删除时，需要将过滤条件与isDeleted='n'用and连接
     *
     * @param element
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement trimElement = new XmlElement("trim");
        trimElement.addAttribute(new Attribute("prefix", "and (("));
        trimElement.addAttribute(new Attribute("prefixOverrides", "("));
        trimElement.addAttribute(new Attribute("suffix", "))"));
        trimElement.addAttribute(new Attribute("suffixOverrides", ")"));
        XmlElement whereElement = (XmlElement) element.getElements().get(5);
        trimElement.addElement((Element) whereElement.getElements().get(0));
        whereElement.getElements().remove(0);
        whereElement.addElement(trimElement);

        TextElement isDeletedElement = new TextElement("and is_deleted = 0");
        whereElement.addElement(isDeletedElement);

        return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
    }

    private void addBatchInsertMethod(Interface interfaze, IntrospectedTable introspectedTable) {
        TreeSet importedTypes = new TreeSet();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        Method ibsmethod = new Method();
        ibsmethod.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();
        ibsmethod.setReturnType(ibsreturnType);
        ibsmethod.setName("insertBatch");
        FullyQualifiedJavaType paramType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType paramListType;
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            paramListType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        } else {
            if (!introspectedTable.getRules().generatePrimaryKeyClass()) {
                throw new RuntimeException(Messages.getString("RuntimeError.12"));
            }

            paramListType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
        }

        paramType.addTypeArgument(paramListType);
        ibsmethod.addParameter(new Parameter(paramType, "records"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(ibsmethod);
    }

    public void addBatchInsertXml(XmlElement element, IntrospectedTable introspectedTable) {
        List columns = introspectedTable.getAllColumns();
        String incrementField = introspectedTable.getTableConfiguration().getGeneratedKey().getColumn();
        if (incrementField != null) {
            incrementField = incrementField.toUpperCase();
        }

        StringBuilder dbcolumnsName = new StringBuilder();
        StringBuilder javaPropertyAndDbType = new StringBuilder();
        Iterator tableName = columns.iterator();

        while (tableName.hasNext()) {
            IntrospectedColumn insertBatchElement = (IntrospectedColumn) tableName.next();
            String trim1Element = insertBatchElement.getActualColumnName();
            if (!trim1Element.toUpperCase().equals(incrementField)) {
                dbcolumnsName.append("`" + trim1Element + "`,");
                javaPropertyAndDbType.append("#{item." + insertBatchElement.getJavaProperty() + ",jdbcType=" + insertBatchElement.getJdbcTypeName() + "},");
            }
        }

        String tableName1 = introspectedTable.getTableConfiguration().getTableName();
        XmlElement insertBatchElement1 = new XmlElement("insert");
        this.context.getCommentGenerator().addComment(insertBatchElement1);
        insertBatchElement1.addAttribute(new Attribute("id", "insertBatch"));
        insertBatchElement1.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        insertBatchElement1.addAttribute(new Attribute("useGeneratedKeys", "true"));
        insertBatchElement1.addAttribute(new Attribute("keyProperty", "id"));

        insertBatchElement1.addElement(new TextElement("insert into " + tableName1));
        XmlElement trim1Element1 = new XmlElement("trim");
        trim1Element1.addAttribute(new Attribute("prefix", "("));
        trim1Element1.addAttribute(new Attribute("suffix", ")"));
        trim1Element1.addAttribute(new Attribute("suffixOverrides", ","));
        trim1Element1.addElement(new TextElement(dbcolumnsName.toString()));
        insertBatchElement1.addElement(trim1Element1);
        insertBatchElement1.addElement(new TextElement("values"));
        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "list"));
        foreachElement.addAttribute(new Attribute("index", "index"));
        foreachElement.addAttribute(new Attribute("item", "item"));
        foreachElement.addAttribute(new Attribute("separator", ","));
        foreachElement.addElement(new TextElement("("));
        XmlElement trim2Element = new XmlElement("trim");
        trim2Element.addAttribute(new Attribute("suffixOverrides", ","));
        trim2Element.addElement(new TextElement(javaPropertyAndDbType.toString()));
        foreachElement.addElement(trim2Element);
        foreachElement.addElement(new TextElement(")"));
        insertBatchElement1.addElement(foreachElement);
        element.addElement(insertBatchElement1);
    }

    private void addBatchUpdateMethod(Interface interfaze, IntrospectedTable introspectedTable) {
        TreeSet importedTypes = new TreeSet();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        Method ibsmethod = new Method();
        ibsmethod.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();
        ibsmethod.setReturnType(ibsreturnType);
        ibsmethod.setName("updateBatch");
        FullyQualifiedJavaType paramType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType paramListType;
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            paramListType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        } else {
            if (!introspectedTable.getRules().generatePrimaryKeyClass()) {
                throw new RuntimeException(Messages.getString("RuntimeError.12"));
            }

            paramListType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
        }

        paramType.addTypeArgument(paramListType);
        ibsmethod.addParameter(new Parameter(paramType, "records"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(ibsmethod);
    }

    public void addBatchUpdateXml(XmlElement element, IntrospectedTable introspectedTable) {
        List columns = introspectedTable.getAllColumns();
        String incrementField = introspectedTable.getTableConfiguration().getGeneratedKey().getColumn();
        XmlElement insertBatchElement = new XmlElement("update");
        this.context.getCommentGenerator().addComment(insertBatchElement);
        insertBatchElement.addAttribute(new Attribute("id", "updateBatch"));
        insertBatchElement.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "list"));
        foreachElement.addAttribute(new Attribute("index", "index"));
        foreachElement.addAttribute(new Attribute("item", "item"));
        foreachElement.addAttribute(new Attribute("separator", ";"));
        foreachElement.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        XmlElement setElement = new XmlElement("set");
        Iterator var8 = columns.iterator();

        while (true) {
            IntrospectedColumn introspectedColumn;
            String columnName;
            do {
                if (!var8.hasNext()) {
                    foreachElement.addElement(setElement);
                    foreachElement.addElement(new TextElement("where " + incrementField + " = #{item." + incrementField + "}"));
                    customWhereSqlForPrimaryKey(foreachElement);
                    insertBatchElement.addElement(foreachElement);
                    element.addElement(insertBatchElement);
                    return;
                }

                introspectedColumn = (IntrospectedColumn) var8.next();
                columnName = introspectedColumn.getActualColumnName();
            }
            while (incrementField != null && incrementField.toUpperCase().equals(columnName.toUpperCase()));

            setElement.addElement(new TextElement("`" + columnName + "` = #{item." + introspectedColumn.getJavaProperty() + ",jdbcType=" + introspectedColumn.getJdbcTypeName() + "},"));
        }
    }

    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        customWhereSqlForPrimaryKey(element);
        return super.sqlMapSelectByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement pageStart = new XmlElement("include");
        pageStart.addAttribute(new Attribute("refid", "MysqlDialectPrefix"));
        element.getElements().add(10, pageStart);

        XmlElement isNotNullElement = new XmlElement("include");
        isNotNullElement.addAttribute(new Attribute("refid", "MysqlDialectSuffix"));
        element.getElements().add(isNotNullElement);
        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement pageStart = new XmlElement("include");
        pageStart.addAttribute(new Attribute("refid", "MysqlDialectPrefix"));
        element.getElements().add(8, pageStart);

        XmlElement isNotNullElement = new XmlElement("include");
        isNotNullElement.addAttribute(new Attribute("refid", "MysqlDialectSuffix"));
        element.getElements().add(isNotNullElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        customWhereSqlForPrimaryKey(element);
        return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        customWhereSqlForPrimaryKey(element);
        return super.sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        customWhereSqlForPrimaryKey(element);
        return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapUpdateByExampleSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.setName("update");
        int replaceInd = -1;
        for (int i = 0; i < element.getAttributes().size(); i++) {
            Attribute attr = element.getAttributes().get(i);
            if ("parameterType".equals(attr.getName())) {
                replaceInd = i;
                break;
            }
        }
        if (replaceInd >= 0) {
            element.getAttributes().remove(replaceInd);
            element.getAttributes().add(replaceInd, new Attribute("parameterType", "map"));
        }
        List<Element> removeElement = new ArrayList<>();
        for (int i = 5; i < element.getElements().size(); i++) {
            removeElement.add(element.getElements().get(i));

        }
        element.getElements().removeAll(removeElement);
        element.getElements().add(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime() + " set is_deleted = 1,gmt_modified=current_timestamp " + "where " + "id = #{id,jdbcType=BIGINT}"));

        customWhereSqlForPrimaryKey(element);

        return super.sqlMapDeleteByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    /**
     * 逻辑删除时，需要替换删除接口，新增record参数传入修改人修改时间
     *
     * @param method
     * @param interfaze
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));

        method.getParameters().get(0).addAnnotation("@Param(\"id\")");

        Parameter model = new Parameter(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()), "record");
        model.addAnnotation("@Param(\"record\")");
        method.addParameter(0, model);

        return super.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.setName("update");
        int replaceInd = -1;
        for (int i = 0; i < element.getAttributes().size(); i++) {
            Attribute attr = element.getAttributes().get(i);
            if ("parameterType".equals(attr.getName())) {
                replaceInd = i;
                break;
            }
        }
        if (replaceInd >= 0) {
            element.getAttributes().remove(replaceInd);
            element.getAttributes().add(replaceInd, new Attribute("parameterType", "map"));
        }
        List<Element> removeElement = new ArrayList<>();
        for (int i = 5; i < element.getElements().size(); i++) {
            removeElement.add(element.getElements().get(i));

        }
        element.getElements().removeAll(removeElement);
        element.getElements().add(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime() + " set is_deleted = 1,gmt_modified=current_timestamp " + ""));

        XmlElement includeElement = new XmlElement("include");
        includeElement.addAttribute(new Attribute("refid", "Update_By_Example_Where_Clause"));
        XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "_parameter != null"));
        ifElement.addElement(includeElement);
        element.addElement(ifElement);

        return super.sqlMapDeleteByExampleElementGenerated(element, introspectedTable);
    }

    /**
     * 逻辑删除时，需要替换删除接口，新增record参数传入修改人修改时间
     *
     * @param method
     * @param interfaze
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));

        method.getParameters().get(0).addAnnotation("@Param(\"example\")");

        Parameter model = new Parameter(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()), "record");
        model.addAnnotation("@Param(\"record\")");
        method.addParameter(0, model);

        return super.clientDeleteByExampleMethodGenerated(method, interfaze, introspectedTable);
    }

    private void addPageSql(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        XmlElement paginationPrefixElement = new XmlElement("sql");
        this.context.getCommentGenerator().addComment(paginationPrefixElement);
        paginationPrefixElement.addAttribute(new Attribute("id", "MysqlDialectPrefix"));
        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "page != null"));
        pageStart.addElement(new TextElement("from " + tableName + " , ( select id as temp_page_table_id "));
        paginationPrefixElement.addElement(pageStart);
        element.addElement(paginationPrefixElement);
        XmlElement orderByClause = new XmlElement("if");
        orderByClause.addAttribute(new Attribute("test", "orderByClause != null"));
        orderByClause.addElement(new TextElement("order by ${orderByClause}"));
        XmlElement paginationSuffixElement = new XmlElement("sql");
        this.context.getCommentGenerator().addComment(paginationSuffixElement);
        paginationSuffixElement.addAttribute(new Attribute("id", "MysqlDialectSuffix"));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "page != null"));
        pageEnd.addElement(new TextElement("<![CDATA[ limit #{page.offset}, #{page.limit} ) as temp_page_table ]]> where " + tableName + ".id=temp_page_table.temp_page_table_id"));
        pageEnd.addElement(orderByClause);
        paginationSuffixElement.addElement(pageEnd);
        element.addElement(paginationSuffixElement);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();
        this.updateDocumentNameSpace(introspectedTable, parentElement);
        this.addPageSql(parentElement, introspectedTable);
        this.addBatchInsertXml(parentElement, introspectedTable);
        this.addBatchUpdateXml(parentElement, introspectedTable);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addBatchInsertMethod(interfaze, introspectedTable);
        this.addBatchUpdateMethod(interfaze, introspectedTable);
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    private void updateDocumentNameSpace(IntrospectedTable introspectedTable, XmlElement parentElement) {
        Attribute namespaceAttribute = null;
        Iterator var4 = parentElement.getAttributes().iterator();

        while (var4.hasNext()) {
            Attribute attribute = (Attribute) var4.next();
            if ("namespace".equals(attribute.getName())) {
                namespaceAttribute = attribute;
            }
        }

        parentElement.getAttributes().remove(namespaceAttribute);
        parentElement.getAttributes().add(new Attribute("namespace", introspectedTable.getMyBatis3JavaMapperType() + JAVAFILE_POTFIX));
    }

    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
        String[] splitFile = introspectedTable.getMyBatis3XmlMapperFileName().split("\\.");
        String fileNameExt = null;
        if (splitFile[0] != null) {
            fileNameExt = splitFile[0] + XMLFILE_POSTFIX + ".xml";
        }

        if (this.isExistExtFile(this.context.getSqlMapGeneratorConfiguration().getTargetProject(), introspectedTable.getMyBatis3XmlMapperPackage(), fileNameExt)) {
            return super.contextGenerateAdditionalXmlFiles(introspectedTable);
        } else {
            Document document = new Document("-//mybatis.org//DTD Mapper 3.0//EN", "http://mybatis.org/dtd/mybatis-3-mapper.dtd");
            XmlElement root = new XmlElement("mapper");
            document.setRootElement(root);
            String namespace = introspectedTable.getMyBatis3SqlMapNamespace() + XMLFILE_POSTFIX;
            root.addAttribute(new Attribute("namespace", namespace));

            GeneratedXmlFile gxf = new GeneratedXmlFile(document, fileNameExt, introspectedTable.getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), false, this.context.getXmlFormatter());
            ArrayList answer = new ArrayList(1);
            answer.add(gxf);
            return answer;
        }
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType() + JAVAFILE_POTFIX);
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        this.context.getCommentGenerator().addJavaFileComment(interfaze);
        FullyQualifiedJavaType baseInterfaze = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
        interfaze.addSuperInterface(baseInterfaze);
        FullyQualifiedJavaType annotation = new FullyQualifiedJavaType(ANNOTATION_RESOURCE);
        interfaze.addAnnotation("@Mapper");
        interfaze.addImportedType(annotation);
        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(interfaze, this.context.getJavaModelGeneratorConfiguration().getTargetProject(), this.context.getProperty("javaFileEncoding"), this.context.getJavaFormatter());
        ArrayList generatedJavaFiles = new ArrayList(1);
        generatedJavaFile.getFileName();
        generatedJavaFiles.add(generatedJavaFile);
        if (generateManager) {
            generatedJavaFiles.addAll(this.generateManagerJavaFiles(introspectedTable));
        }
        Iterator fileIterator = generatedJavaFiles.iterator();

        while (fileIterator.hasNext()) {
            GeneratedJavaFile temp = (GeneratedJavaFile) fileIterator.next();
            if (this.isExistExtFile(temp.getTargetProject(), temp.getTargetPackage(), temp.getFileName())) {
                fileIterator.remove();
            }
        }
        if (generateContropller) {
            this.generateController(introspectedTable);
        }
        return generatedJavaFiles;
    }

    private boolean isExistExtFile(String targetProject, String targetPackage, String fileName) {
        File project = new File(targetProject);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(targetPackage, ".");

        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(File.separatorChar);
        }

        File directory = new File(project, sb.toString());
        if (!directory.isDirectory()) {
            boolean testFile = directory.mkdirs();
            if (!testFile) {
                return true;
            }
        }

        File testFile1 = new File(directory, fileName);
        return testFile1.exists();
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //给DO增加默认接口
        FullyQualifiedJavaType baseDoType = new FullyQualifiedJavaType("com.edu.nbu.cn.mybatis.baseclass.BaseModel");
        topLevelClass.addImportedType(baseDoType);
        topLevelClass.setSuperClass(baseDoType);

        Iterator fileds = topLevelClass.getFields().iterator();

        while (fileds.hasNext()) {
            Field methods = (Field) fileds.next();
            if (BASE_MODEL_FIELDS_SET.contains(methods.getName())) {
                fileds.remove();
            }
        }

        Iterator methods1 = topLevelClass.getMethods().iterator();

        while (methods1.hasNext()) {
            Method currentMethod = (Method) methods1.next();
            if (BASE_MODEL_METHODS_SET.contains(currentMethod.getName())) {
                methods1.remove();
            }
        }

        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    public List<GeneratedJavaFile> generateManagerJavaFiles(IntrospectedTable introspectedTable) {
        String model = introspectedTable.getBaseRecordType();
        FullyQualifiedJavaType modelType = new FullyQualifiedJavaType(model);
        String managerInterface = model.replaceFirst("dal.model", "manager") + "Manager";
        String managetImpl = model.replaceFirst("dal.model", "manager.impl") + "ManagerImpl";
        FullyQualifiedJavaType managerInterfaceType = new FullyQualifiedJavaType(managerInterface);
        Interface interfaze = new Interface(managerInterfaceType);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType iBaseManager = new FullyQualifiedJavaType("com.edu.nbu.cn.mybatis.baseclass.IBaseManager");
        iBaseManager.addTypeArgument(modelType);
        interfaze.addImportedType(iBaseManager);
        interfaze.addSuperInterface(iBaseManager);
        GeneratedJavaFile interfazeJavaFile = new GeneratedJavaFile(interfaze, this.context.getJavaModelGeneratorConfiguration().getTargetProject(), this.context.getProperty("javaFileEncoding"), this.context.getJavaFormatter());
        TopLevelClass topLevelClass = new TopLevelClass(new FullyQualifiedJavaType(managetImpl));
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        topLevelClass.addAnnotation("@Service");
        topLevelClass.addAnnotation("@Transactional(rollbackFor = Exception.class)");
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Service"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.transaction.annotation.Transactional"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.transaction.annotation.Transactional"));
        FullyQualifiedJavaType baseManager = new FullyQualifiedJavaType("com.edu.nbu.cn.mybatis.baseclass.BaseManager");
        baseManager.addTypeArgument(modelType);
        topLevelClass.addImportedType(baseManager);
        topLevelClass.setSuperClass(baseManager);
        topLevelClass.addImportedType(managerInterfaceType);
        topLevelClass.addSuperInterface(managerInterfaceType);
        FullyQualifiedJavaType mapperType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType() + JAVAFILE_POTFIX);
        String mapperName = mapperType.getShortName();
        mapperName = mapperName.substring(0, 1).toLowerCase() + mapperName.substring(1);
        Field mapper = new Field(mapperName, mapperType);
        topLevelClass.addImportedType(mapperType);
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.Autowired"));
        mapper.addAnnotation("@Autowired");
        mapper.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.addField(mapper);
        Method getBaseMapper = new Method("getBaseMapper");
        getBaseMapper.setVisibility(JavaVisibility.PROTECTED);
        getBaseMapper.setReturnType(new FullyQualifiedJavaType("java.lang.Object"));
        getBaseMapper.addBodyLine("return " + mapperName + ";");
        getBaseMapper.addAnnotation("@Override");
        topLevelClass.addMethod(getBaseMapper);
        Method newExample = new Method("newExample");
        newExample.setVisibility(JavaVisibility.PROTECTED);
        newExample.setReturnType(new FullyQualifiedJavaType("java.lang.Object"));
        FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        String exampleClassName = exampleType.getShortName();
        topLevelClass.addImportedType(exampleType);
        newExample.addBodyLine("return new " + exampleClassName + "();");
        newExample.addAnnotation("@Override");
        topLevelClass.addMethod(newExample);
        Method paginToExample = new Method("paginToExample");
        paginToExample.setVisibility(JavaVisibility.PROTECTED);
        FullyQualifiedJavaType paginType = new FullyQualifiedJavaType("Pagin");
        paginType.addTypeArgument(modelType);
        paginToExample.addParameter(new Parameter(paginType, "pagin"));
        paginToExample.addParameter(new Parameter(new FullyQualifiedJavaType("java.lang.Object"), "example"));
        paginToExample.addAnnotation("@Override");
        paginToExample.addBodyLine("Criteria criteria = ((" + exampleClassName + ") example).createCriteria();");
        paginToExample.addBodyLine("if (pagin.getCondition(\"id\") != null) {");
        paginToExample.addBodyLine("criteria.andIdEqualTo(Long.valueOf((String) pagin.getCondition(\"id\")));");
        paginToExample.addBodyLine("}");
        FullyQualifiedJavaType criteriaType = new FullyQualifiedJavaType(introspectedTable.getExampleType() + ".Criteria");
        topLevelClass.addImportedType(criteriaType);
        topLevelClass.addImportedType(paginType);
        topLevelClass.addMethod(paginToExample);
        GeneratedJavaFile topLevelClassJavaFile = new GeneratedJavaFile(topLevelClass, this.context.getJavaModelGeneratorConfiguration().getTargetProject(), this.context.getProperty("javaFileEncoding"), this.context.getJavaFormatter());
        ArrayList generatedJavaFiles = new ArrayList();
        generatedJavaFiles.add(interfazeJavaFile);
        generatedJavaFiles.add(topLevelClassJavaFile);
        return generatedJavaFiles;
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    public void generateController(IntrospectedTable introspectedTable) {
        try {
            org.w3c.dom.Document ex = this.generateDocument(introspectedTable);
            Map paramMap = this.generateParameters(introspectedTable);
            String modelName = (String) paramMap.get("modelName");
            String controllerPath = ((String) paramMap.get("controllerPackage")).replace(".", "/");
            String controllerXslIn = XSL_BASE_PATH + "/Controller.xsl";
            String controllerJavaOut = String.format("src/main/java/%s/%sController.java", new Object[]{controllerPath, modelName});
            this.generateCodeFile(ex, controllerXslIn, controllerJavaOut, paramMap);
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }

    private Map<String, String> generateParameters(IntrospectedTable introspectedTable) {
        HashMap parameters = new HashMap();
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        String modelName = (String) this.generateTableJavaMap().get(tableName);
        JavaModelGeneratorConfiguration modelConfig = this.context.getJavaModelGeneratorConfiguration();
        String modelPackage = modelConfig.getTargetPackage();
        String managerPackage = modelPackage.replaceFirst("dal.model", "manager");
        String controllerPackage = managerPackage.replaceFirst("manager", "controller.rpc");
        parameters.put("modelName", modelName);
        parameters.put("modelPackage", modelPackage);
        parameters.put("managerPackage", managerPackage);
        parameters.put("controllerPackage", controllerPackage);
        return parameters;
    }

    private Map<String, String> generateTableJavaMap() {
        HashMap map = new HashMap();
        List tableConfigurations = this.context.getTableConfigurations();
        Iterator var3 = tableConfigurations.iterator();

        while (var3.hasNext()) {
            TableConfiguration tableConfiguration = (TableConfiguration) var3.next();
            String domainName = tableConfiguration.getDomainObjectName();
            String tableName = tableConfiguration.getTableName();
            map.put(tableName, domainName);
        }

        return map;
    }

    private org.w3c.dom.Document generateDocument(IntrospectedTable introspectedTable) throws ParserConfigurationException {
        org.w3c.dom.Document document = null;
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        String modelName = (String) this.generateTableJavaMap().get(tableName);
        ArrayList columnList = new ArrayList();
        List columns = introspectedTable.getAllColumns();
        Iterator factory = columns.iterator();

        while (factory.hasNext()) {
            IntrospectedColumn builder = (IntrospectedColumn) factory.next();
            ColumnData models = new ColumnData();
            models.setDbName(builder.getActualColumnName());
            models.setDbType(builder.getJdbcTypeName());
            models.setJavaName(builder.getJavaProperty());
            models.setJavaType((String) ColumnData.TYPE_MAPPINGS.get(builder.getJdbcTypeName().toLowerCase()));
            columnList.add(models);
        }

        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder1 = factory1.newDocumentBuilder();
        document = builder1.newDocument();
        org.w3c.dom.Element models1 = document.createElement("models");
        document.appendChild(models1);
        org.w3c.dom.Element model = document.createElement("model");
        models1.appendChild(model);
        model.setAttribute("name", modelName);
        String fname = modelName.substring(0, 1).toLowerCase() + modelName.substring(1, modelName.length());
        model.setAttribute("fname", fname);
        model.setAttribute("cname", tableName);
        org.w3c.dom.Element properties = document.createElement("properties");
        model.appendChild(properties);
        Iterator var12 = columnList.iterator();

        while (var12.hasNext()) {
            ColumnData column = (ColumnData) var12.next();
            if (!"id".equalsIgnoreCase(column.getJavaName())) {
                org.w3c.dom.Element property = document.createElement("property");
                properties.appendChild(property);
                property.setAttribute("name", column.getJavaName());
                property.setAttribute("cname", column.getDbName());
                property.setAttribute("type", column.getJavaType());
            }
        }

        return document;
    }

    private void generateCodeFile(org.w3c.dom.Document document, String xsltFileName, String outputFileName, Map<String, String> parameters) throws IOException, TransformerException {
        StreamSource styleSource = new StreamSource(this.getClass().getResourceAsStream(xsltFileName));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(styleSource);
        if (!(new File(outputFileName)).exists()) {
            this.generateTransform(document, parameters, outputFileName, transformer);
        }

    }

    private void generateTransform(org.w3c.dom.Document document, Map<String, String> parameters, String outputFileName, Transformer transformer) throws TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {
        if (parameters != null) {
            Iterator out = parameters.entrySet().iterator();

            while (out.hasNext()) {
                Map.Entry outputFile = (Map.Entry) out.next();
                transformer.setParameter((String) outputFile.getKey(), outputFile.getValue());
            }
        }

        File out1 = new File(outputFileName);
        if (!out1.getParentFile().exists()) {
            boolean success = out1.getParentFile().mkdirs();
        }

        File outputFile1 = new File(outputFileName);
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream(outputFile1));
        transformer.transform(source, result);
    }

    private void customWhereSqlForPrimaryKey(XmlElement element) {
        TextElement text = new TextElement("and is_deleted = 0");
        element.addElement(text);
    }
}
