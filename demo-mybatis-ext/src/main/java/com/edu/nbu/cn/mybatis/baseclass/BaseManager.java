package com.edu.nbu.cn.mybatis.baseclass;

import com.edu.nbu.cn.mybatis.plugins.Page;
import com.edu.nbu.cn.mybatis.plugins.Pagin;
import com.edu.nbu.cn.mybatis.utils.MyCollectionUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public abstract class BaseManager<Model> implements IBaseManager<Model>{
    protected Log logger = LogFactory.getLog(this.getClass());

    /**
     * getBaseMapper
     *
     * @return
     */
    protected abstract Object getBaseMapper();

    /**
     * newExample
     *
     * @return
     */
    protected abstract Object newExample();

    @SuppressWarnings("unchecked")
    @Override
    public void findByPagin(Pagin<Model> pagin) {
        Object exmaple = newExample();
        if (StringUtils.isNotEmpty((String) pagin.getCondition("order"))) {
            invoke(exmaple, "setOrderByClause", pagin.getCondition("order") + " " + pagin.getCondition("orderType"));
        } else {
            invoke(exmaple, "setOrderByClause", "id desc");
        }

        invoke(exmaple, "setPage", new Page(pagin.getFromRow(), pagin.getPageSize()));
        try {
            paginToExample(pagin, exmaple);
            pagin.setResultList((List<Model>) invoke(getBaseMapper(), "selectByExample", exmaple));
            pagin.setTotalRows((Integer) invoke(getBaseMapper(), "countByExample", exmaple));
        } catch (Exception e) {
            logger.error("findByPagin Exception", e);
        }
    }

    /**
     * paginToExample
     *
     * @param pagin
     * @param exmaple
     */
    protected abstract void paginToExample(Pagin<Model> pagin, Object exmaple);

    @Override
    public Integer deleteByIds(Model record, Long[] ids) {
        return deleteByIds(record, Arrays.asList(ids));
    }

    @Override
    public Integer deleteByIds(Model record, List<Long> ids) {
        Integer result = 0;
        if (CollectionUtils.isNotEmpty(ids)) {
            Object example = newExample();
            Object criteria = invoke(example, "createCriteria");
            invoke(criteria, "andIdIn", ids, List.class);
            result = (Integer) invoke(getBaseMapper(), "deleteByExample", new Object[]{record, example});
        }
        return result;
    }

    @Override
    public Integer deleteById(Model record, long id) {
        return (Integer) invoke(getBaseMapper(), "deleteByPrimaryKey", new Object[]{record, id});
    }

    @SuppressWarnings("unchecked")
    @Override
    public Model findById(Long id) {
        return (Model) invoke(getBaseMapper(), "selectByPrimaryKey", id);
    }

    @Override
    public void save(Model model) {

        Object object;
        try {
            object = PropertyUtils.getSimpleProperty(model, "id");
        } catch (Exception ex10) {
            throw new RuntimeException(ex10.getMessage(), ex10);
        }

        if (object != null) {
            invoke(getBaseMapper(), "updateByPrimaryKeySelective", model);
        } else {
            invoke(getBaseMapper(), "insertSelective", model);
        }
    }

    @Override
    public List<Model> findByIds(Long[] ids) {
        List<Model> result = null;
        if (ids != null && ids.length > 0) {
            findByIds(Arrays.asList(ids));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Model> findByIds(List<Long> ids) {
        List<Model> result = null;
        if (ids != null && ids.size() > 0) {
            Object example = newExample();
            invoke(invoke(example, "createCriteria"), "andIdIn", ids, List.class);
            result = (List<Model>) invoke(getBaseMapper(), "selectByExample", example);
        }
        return result;
    }

    @Override
    public int batchInsert(Collection<Model> records) {
        int count = 0;
        if (records != null && records.size() > 0) {
            if (MethodUtils.getAccessibleMethod(getBaseMapper().getClass(), "insertBatch", List.class) != null) {
                int maxBatchSize = 300;
                if (records.size() > maxBatchSize) {
                    int batchCount = (records.size() + maxBatchSize - 1) / maxBatchSize;
                    if (!(records instanceof List)) {
                        records = new ArrayList<Model>(records);
                    }

                    for (int i = 0; i < batchCount; i++) {
                        List<Model> temp = MyCollectionUtils.copyList((List<Model>) records, maxBatchSize * i, maxBatchSize * i + maxBatchSize);
                        logger.info(String.format("开始批量插入%d条数据", temp.size()));
                        count += (Integer) invoke(getBaseMapper(), "insertBatch", temp, List.class);
                    }
                } else {
                    logger.info(String.format("开始批量插入%d条数据", records.size()));
                    count = (Integer) invoke(getBaseMapper(), "insertBatch", records, List.class);
                }
            } else {
                for (Model record : records) {
                    count += (Integer) invoke(getBaseMapper(), "insertSelective", record);
                }
            }
        }
        return count;
    }

    @Override
    public int batchUpdate(Collection<Model> records) {
        int count = 0;
        if (records != null && records.size() > 0) {
            if (MethodUtils.getAccessibleMethod(getBaseMapper().getClass(), "updateBatch", List.class) != null) {
                int maxBatchSize = 300;
                if (records.size() > maxBatchSize) {
                    int batchCount = (records.size() + maxBatchSize - 1) / maxBatchSize;
                    if (!(records instanceof List)) {
                        records = new ArrayList<Model>(records);
                    }

                    for (int i = 0; i < batchCount; i++) {
                        List<Model> temp = MyCollectionUtils.copyList((List<Model>) records, maxBatchSize * i, maxBatchSize * i + maxBatchSize);
                        logger.info(String.format("开始批量更新%d条数据", temp.size()));
                        count += (Integer) invoke(getBaseMapper(), "updateBatch", temp, List.class);
                    }
                } else {
                    logger.info(String.format("开始批量更新%d条数据", records.size()));
                    count = (Integer) invoke(getBaseMapper(), "updateBatch", records, List.class);
                }
            } else {
                throw new IllegalArgumentException("找不到updateBatch方法");
            }
        }
        return count;
    }

    @Override
    public int batchUpdateSelective(Collection<Model> records, Class<Model> clazz) {
        int count = 0;
        if (records != null && records.size() > 0) {
            if (MethodUtils.getAccessibleMethod(getBaseMapper().getClass(), "updateByPrimaryKeySelective", clazz) != null) {
                logger.info(String.format("开始批量更新%d条数据", records.size()));
                for (Model record : records) {
                    count += (Integer) invoke(getBaseMapper(), "updateByPrimaryKeySelective", record, clazz);
                }
            } else {
                throw new IllegalArgumentException("找不到updateByPrimaryKeySelective方法");
            }
        }
        return count;
    }

    private Object invoke(Object object, String methodName, Object arg) {
        return invoke(object, methodName, new Object[]{arg});
    }

    private Object invoke(Object object, String methodName, Object[] arg) {
        try {
            return MethodUtils.invokeExactMethod(object, methodName, arg);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new UnsupportedOperationException("invoke " + methodName + " error", e);
        }
    }

    /**
     * 对于方法中定义的参数为父类或者接口的，需要指定参数类型，否则会找不到方法
     *
     * @param object
     * @param methodName
     * @param arg
     * @param clazz
     * @return
     */
    private Object invoke(Object object, String methodName, Object arg, @SuppressWarnings("rawtypes") Class clazz) {
        try {
            return MethodUtils.invokeExactMethod(object, methodName, new Object[]{arg}, new Class[]{clazz});
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new UnsupportedOperationException("invoke " + methodName + " error", e);
        }
    }

    private Object invoke(Object object, String methodName) {
        try {
            return MethodUtils.invokeExactMethod(object, methodName, new Object[0], new Class[0]);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new UnsupportedOperationException("invoke " + methodName + " error", e);
        }
    }
}
