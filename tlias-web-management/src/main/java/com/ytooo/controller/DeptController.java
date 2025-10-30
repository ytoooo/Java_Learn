package com.ytooo.controller;

import com.sun.net.httpserver.HttpServer;
import com.ytooo.pojo.Dept;
import com.ytooo.pojo.Result;
import com.ytooo.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;


//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
//        System.out.println("查询所有部门数据");
        log.info("查询所有部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//       String idStr =  request.getParameter("id");
//       int id = Integer.parseInt(idStr);
//       System.out.println("根据相应的id删除信息" + id);
//       return Result.success();
//    }
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id",required = false)  Integer dept_id) {
//       System.out.println("根据相应的id删除信息" + dept_id);
//       return Result.success();
//    }
    @DeleteMapping
    public Result delete(Integer id) {
//        System.out.println("根据相应的id删除信息" + id);
        log.info("根据相应的id删除信息{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门" + dept);
        log.info("新增部门{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    //路径参数
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id")Integer id) {
        System.out.println("所查询的布恩id为" + id);
        log.info("所查询的布恩id为{}", id);
        Dept dept = deptService.getInfoById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改疏忽信息" + dept);
        log.info("修改部门信息{}", dept);
        deptService.update(dept);
        return Result.success();
    }

}
