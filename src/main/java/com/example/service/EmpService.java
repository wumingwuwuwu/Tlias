package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

//    List<Emp> list();

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
