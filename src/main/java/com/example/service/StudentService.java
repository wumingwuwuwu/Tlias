package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;

import java.util.List;


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

    /**
     * 删除学生信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 扣分
     */
    void violation(Integer id, Integer score);
}
