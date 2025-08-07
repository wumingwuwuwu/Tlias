package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 分页获取所有学生信息
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页获取所有学生信息,参数：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 添加学生信息
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学生信息,参数：{}", student);
        studentService.save(student);
        return Result.success();
    }


    /**
     * 修改学生信息
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息,参数：{}", student);
        studentService.update(student);
        return Result.success();
    }


    /**
     * 学生违纪处理 /violation
     */
    //@PutMapping("/violation")


    /**
     * 批量删除学生信息
     * @param ids
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {
        log.info("批量删除学生信息,参数：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }


    /**
     * 根据id获取学生信息
     * @param id
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id获取学生信息,参数：{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }


}
