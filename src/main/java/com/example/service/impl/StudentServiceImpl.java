package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //使用PageHelper为后续查询操作设置分页参数（当前页码、每页记录数）
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        //封装结果
        List<Student> studentList = studentMapper.list(studentQueryParam);
        Page<Student> pageResult = (Page<Student>)studentList;
        return new PageResult<Student>(pageResult.getTotal(),pageResult.getResult());
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

}
