package com.example.mapper;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 分页查询
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 查询所有老师
     */
    List<Clazz> findAll();

    /**
     * 新增
     */
    void insert(Clazz clazz);
}
