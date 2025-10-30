package com.ytooo.mapper;

import com.ytooo.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id} ")
    void deleteById(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})" )
    void insert(Dept dept);

    @Select("SELECT  id, name, create_time, update_time from dept WHERE id = #{id}")
    Dept getById(Integer id);

    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);
}
