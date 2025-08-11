package com.example.controller;

import com.example.anno.LogOperation;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @LogOperation
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
        try {
            log.info("删除部门, id= {}", id);
            deptService.deleteById(id);
            return Result.success();
        } catch (RuntimeException e) {
            log.error("删除部门失败, id= {}，部门下有员工不能删除", id);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增部门
     */
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Dept dept){
        System.out.println("新增部门, dept=" + dept);
        deptService.save(dept);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @LogOperation
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println("根据ID查询, id=" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门, dept=" + dept);
        deptService.update(dept);
        return Result.success();
    }
}