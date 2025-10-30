package com.ytooo.service;

import com.ytooo.pojo.Emp;
import com.ytooo.pojo.EmpQueryParam;
import com.ytooo.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                         LocalDate begin, LocalDate end);
}
