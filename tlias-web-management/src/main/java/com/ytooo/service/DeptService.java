package com.ytooo.service;

import com.ytooo.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getInfoById(Integer id);

    void update(Dept dept);
}
