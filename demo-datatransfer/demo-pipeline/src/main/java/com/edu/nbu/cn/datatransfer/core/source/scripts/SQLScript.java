package com.edu.nbu.cn.datatransfer.core.source.scripts;

import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/8-4:20 PM
 * @since 1.0
 */
public class SQLScript implements Script{

    private String fileName;

    private boolean absolutePath;

    public SQLScript(String fileName, boolean absolutePath) {
        this.fileName = fileName;
        this.absolutePath = absolutePath;
    }

    public SQLScript(String fileName) {
        this.fileName = fileName;
        this.absolutePath = false;
    }


    @Override
    public ScriptType type() {
        return ScriptType.SQL;
    }

    @Override
    public String filePath() {
        return this.fileName;
    }

    public boolean absolutePath() {
        return absolutePath;
    }

    public static SQLScript of(String fileName){
        return new SQLScript(fileName);
    }

    public static SQLScript[] of(String ... scriptNames){
        List<SQLScript> scripts = new ArrayList<>();
        for(String scriptName : scriptNames){
            scripts.add(of(scriptName));
        }
        return scripts.toArray(new SQLScript[]{});
    }
}
