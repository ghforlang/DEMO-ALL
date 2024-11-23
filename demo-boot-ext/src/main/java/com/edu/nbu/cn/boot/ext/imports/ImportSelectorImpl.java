package com.edu.nbu.cn.boot.ext.imports;

import com.edu.nbu.cn.boot.ext.imports.model.ImportSelectorBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:15 AM
 * @since 1.0
 */
@Slf4j
public class ImportSelectorImpl implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        log.info("annotationName : {}",importingClassMetadata.getClassName());
        return new String[]{ImportSelectorBean.class.getName()};
    }
}
