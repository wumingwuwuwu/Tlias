package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //@PostMapping


    /**
     * 修改学生信息
     */
    //@PutMapping


    /**
     * 学生违纪处理 /violation
     */
    //@PutMapping("/violation")


    /**
     * 批量删除学生信息
     * @param ids
     */
    //@DeleteMapping


    /**
     * 根据id获取学生信息
     * @param id
     */
    //@GetMapping("/{id}")


}
