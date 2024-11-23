package com.edu.nbu.cn.boot.ext.imports.use;

import com.edu.nbu.cn.boot.ext.imports.ImportSelectorImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:27 AM
 * @since 1.0
 */
@Import(ImportSelectorImpl.class)
@Configuration
public class ImportSelectorConfiguration {
}
