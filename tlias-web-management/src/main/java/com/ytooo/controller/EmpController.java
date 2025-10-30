package com.ytooo.controller;


import com.ytooo.pojo.Emp;
import com.ytooo.pojo.EmpQueryParam;
import com.ytooo.pojo.PageResult;
import com.ytooo.pojo.Result;
import com.ytooo.service.DeptService;
import com.ytooo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(value = "page", defaultValue = "1",required = false)Integer page,
//                       @RequestParam(value = "pageSize", defaultValue = "10",required = false)Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("进行分页查询：page:{}, pagesize:{}, name:{}, gender:{}, begin:{}, end:{}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("进行分页查询：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }
}
