package com.ytooo.mapper;


import com.ytooo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /*
    * 批量保存员工的工作经理
    * */
    void insertBatch(List<EmpExpr> exprList);
}
