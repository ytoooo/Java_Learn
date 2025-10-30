package com.ytooo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ytooo.mapper.EmpExprMapper;
import com.ytooo.mapper.EmpMapper;
import com.ytooo.pojo.Emp;
import com.ytooo.pojo.EmpExpr;
import com.ytooo.pojo.EmpQueryParam;
import com.ytooo.pojo.PageResult;
import com.ytooo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@Service
//public class EmpServiceImpl implements EmpService {
//    @Autowired
//    EmpMapper empMapper;
//
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Integer sum =  empMapper.count();
//        int start = (page - 1) * pageSize;
//        List<Emp>pages  = empMapper.page(start, pageSize);
//        return new PageResult<Emp>(sum, pages);
//    }
//}

// 基于PageHelper进行分页查询
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    EmpExprMapper empExprMapper;

//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                                LocalDate begin, LocalDate end) {
//
//        PageHelper.startPage(page, pageSize);
//
//        List<Emp> empList = empMapper.page(name, gender, begin, end);
//
//        PageInfo<Emp> p = new PageInfo<>(empList);
//        return new  PageResult<Emp>(p.getTotal(), p.getList());
//    }


    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> empList = empMapper.page(empQueryParam);

        PageInfo<Emp> p = new PageInfo<>(empList);
        return new  PageResult<Emp>(p.getTotal(), p.getList());
    }

    /*
    * 新增员工基本信息
    */
    //事务管理 默认出现运行时异常才会回滚 RunTimeExceptions
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
//        int a = 1 / 0;
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr ->{
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }
}
