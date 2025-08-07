package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;


public interface StudentService {

    /**
     * 分页获取所有学生信息
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);


    /**
     * 新增学生信息
     */
    void save(Student student);

    /**
     * 根据id获取学生信息
     */
    Student getById(Integer id);

    /**
     * 修改学生信息
     */
    void update(Student student);
}
