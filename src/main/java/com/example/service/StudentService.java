package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;


public interface StudentService {

    /**
     * 分页获取所有学生信息
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);


    void save(Student student);
}
