package com.edu.nbu.cn.ddd.repository;

// entity的marker接口
public interface Entity<ID extends Identifier> extends Identifiable<ID> {
}
