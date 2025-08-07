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
    /**
     * 分页查询学生信息
     * @param studentQueryParam 学生查询参数，包含页码、每页记录数及其他查询条件
     * @return PageResult<Student> 分页结果，包含总记录数和当前页的学生列表
     */
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //使用PageHelper为后续查询操作设置分页参数（当前页码、每页记录数）
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        //封装结果
        List<Student> studentList = studentMapper.list(studentQueryParam);
        Page<Student> pageResult = (Page<Student>)studentList;
        return new PageResult<Student>(pageResult.getTotal(),pageResult.getResult());
    }

    @Override
    /**
     * 保存学生信息
     * @param student 学生对象，包含学生的基本信息
     */
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    /**
     * 根据ID查询学生信息
     * @param id 学生ID
     * @return Student 学生对象，包含学生的基本信息
     */
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    /**
     * 更新学生信息
     * @param student 学生对象，包含学生的基本信息
     */
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    /**
     * 删除学生信息
     * @param ids 学生ID列表
     */
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

}
