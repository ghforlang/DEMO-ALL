package com.edu.nbu.cn.mybatis.model;

import com.edu.nbu.cn.mybatis.baseclass.BaseManager;
import com.edu.nbu.cn.mybatis.mapper.EmployeesMapperExt;
import com.edu.nbu.cn.mybatis.model.EmployeesExample.Criteria;
import com.edu.nbu.cn.mybatis.plugins.Pagin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeesManagerImpl extends BaseManager<EmployeesGenerate> implements EmployeesManager {
    @Autowired
    private EmployeesMapperExt employeesMapperExt;

    @Override
    protected Object getBaseMapper() {
        return employeesMapperExt;
    }

    @Override
    protected Object newExample() {
        return new EmployeesExample();
    }

    @Override
    protected void paginToExample(Pagin<EmployeesGenerate> pagin, Object example) {
        Criteria criteria = ((EmployeesExample) example).createCriteria();
        if (pagin.getCondition("id") != null) {
            criteria.andEmpNoEqualTo(Integer.valueOf((String) pagin.getCondition("id")));
        }
    }
}