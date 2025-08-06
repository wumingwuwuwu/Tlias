package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT id, name, create_time, update_time from dept")
    List<Dept> findAll();

    @Delete("DELETE FROM dept WHERE id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("SELECT id, name, create_time, update_time from dept WHERE id=#{id}")
    Dept getById(Integer id);

    @Update("UPDATE dept SET name=#{name},update_time=#{updateTime} WHERE id=#{id}")
    void update(Dept dept);
}