package com.edu.nbu.cn.synctask.domain.repository.impl;

import com.edu.nbu.cn.synctask.domain.entity.AsyncLog;
import com.edu.nbu.cn.synctask.domain.repository.AsyncLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:05 PM
 * @since 1.0
 */
@Repository
public class AsyncLogDaoImpl implements AsyncLogDao {

    @Autowired
    private JdbcTemplate asyncJdbcTemplate;

    @Override
    public void save(AsyncLog asyncLog) {
        String sql = "insert into async_log(async_id, error_data, create_time) values (?, ?, ?)";
        asyncJdbcTemplate.update(sql, asyncLog.getAsyncId(), asyncLog.getErrorData(), asyncLog.getCreateTime());
    }

    @Override
    public void delete(Long asyncId) {
        String sql = "delete from async_log where async_id = ?";
        asyncJdbcTemplate.update(sql, asyncId);
    }

    @Override
    public String getErrorData(Long asyncId) {
        String sql = "select error_data from async_log where async_id = ? order by id desc limit 1";
        return asyncJdbcTemplate.queryForObject(sql, String.class, asyncId);
    }
}
