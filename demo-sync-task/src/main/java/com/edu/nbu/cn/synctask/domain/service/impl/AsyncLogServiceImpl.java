package com.edu.nbu.cn.synctask.domain.service.impl;

import com.edu.nbu.cn.synctask.domain.entity.AsyncLog;
import com.edu.nbu.cn.synctask.domain.repository.AsyncLogDao;
import com.edu.nbu.cn.synctask.domain.service.AsyncLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:02 PM
 * @since 1.0
 */
@Component
public class AsyncLogServiceImpl implements AsyncLogService {

    @Autowired
    private AsyncLogDao asyncLogDao;

    @Override
    public void save(AsyncLog asyncLog) {
        asyncLog.setCreateTime(new Date());
        asyncLogDao.save(asyncLog);
    }

    @Override
    public void delete(Long asyncId) {
        asyncLogDao.delete(asyncId);
    }

    @Override
    public String getErrorData(Long asyncId) {
        return asyncLogDao.getErrorData(asyncId);
    }
}
