package com.edu.nbu.cn.datatransfer.core.source.scripts;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/8-4:17 PM
 * @since 1.0
 */
public interface Script {
    ScriptType type();

    String filePath();
}
