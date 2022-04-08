package com.edu.nbu.cn.datatransfer.core.source;

import com.edu.nbu.cn.datatransfer.core.source.scripts.Script;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:24 下午
 * @since 1.0
 */
public abstract class ScriptStageResource implements StageResource {
    public Script[] getScripts() {
        return scripts;
    }

    protected Script[] scripts;

    public ScriptStageResource(Script[] scripts) {
        this.scripts = scripts;
    }
}
