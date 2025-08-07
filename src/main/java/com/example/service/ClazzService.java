package com.example.service;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;

import java.util.List;


public interface ClazzService {

    /**
     * 分页查询
     */
    PageResult page(ClazzQueryParam clazzQueryParam);

    /**
     * 查询所有班级
     */
    List<Clazz> findAll();

    /**
     * 保存班级信息
     */
    void save(Clazz clazz);

    /**
     * 根据id查询班级信息
     */
    Clazz getById(Integer id);

    /**
     * 更新班级信息
     */
    void update(Clazz clazz);

    /**
     * 根据id删除班级信息
     */
    void deleteById(Integer id);
}
