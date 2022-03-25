package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.source.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import org.springframework.core.Ordered;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:21 下午
 * @since 1.0
 */
public interface Stage extends Comparable<Stage>, Ordered {

    String name();

    StageResource resource();

    Executor getExecutor();
}
