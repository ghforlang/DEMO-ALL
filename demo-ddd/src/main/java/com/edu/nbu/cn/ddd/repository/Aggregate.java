package com.edu.nbu.cn.ddd.repository;


// 聚合根marker接口
public interface Aggregate<ID extends Identifier> extends Entity<ID> {
}
