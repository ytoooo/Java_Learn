package com.ytooo.mapper;


import com.ytooo.pojo.Emp;
import com.ytooo.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> page(EmpQueryParam empQueryParam);


//    @Select("select count(*) from emp e LEFT JOIN dept d ON e.dept_id = d.id")
//    Integer count();
//
//    @Select("select e.*, d.name as dept_name from emp e LEFT JOIN dept d ON e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    List<Emp> page(int start, Integer pageSize);

    // @Select("select e.*, d.name as dept_name from emp e LEFT JOIN dept d ON e.dept_id = d.id order by e.update_time desc")

    // List<Emp> page(String name, Integer gender, LocalDate begin, LocalDate end);
    /*将主键自增的id传到对象中去*/
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
