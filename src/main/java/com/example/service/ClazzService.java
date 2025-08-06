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

    List<Clazz> findAll();

    void save(Clazz clazz);
}
