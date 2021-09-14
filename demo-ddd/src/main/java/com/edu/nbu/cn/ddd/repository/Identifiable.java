package com.edu.nbu.cn.ddd.repository;


public interface Identifiable<ID extends Identifier> {
    ID getId();
}
