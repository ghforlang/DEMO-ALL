package com.edu.nbu.cn.beancopy;

import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;

import java.util.Objects;

public class SimpleBeanConverter {

    public static SimpleBeanDTO convertToDTO(SimpleBean bean){
        if(Objects.isNull(bean)){
            return null;
        }

        SimpleBeanDTO dto = new SimpleBeanDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setUuid(bean.getUuid());
        return dto;
    }

}
