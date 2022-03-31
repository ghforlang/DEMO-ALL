package com.edu.nbu.cn.datatransfer.db.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:30 AM
 * @since 1.0
 */
@Component
public class SQLScriptRunnerWrapper extends ScriptRunner {

    public SQLScriptRunnerWrapper(Connection connection) {
        super(connection);
        setErrorLogWriter(null);
        setLogWriter(null);
    }

    public String executeSQLScript(File file,boolean absolutePath) throws IOException {
        if(absolutePath){
            this.runScript(new InputStreamReader( new FileInputStream(file)));
        }else{
            this.runScript(Resources.getResourceAsReader(file.getName()));
        }
        return "success";
    }

}
