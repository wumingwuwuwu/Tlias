package com.example.controller;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("班级分页查询，参数：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result findAll() {
        log.info("查询所有班级");
        return Result.success(clazzService.findAll());
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级，参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }


    /**
     * 根据id查询班级
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询班级，id：{}", id);
        return Result.success(clazzService.getById(id));
    }

    /**
     * 根据id修改班级
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息,参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 根据id删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            log.info("根据id删除班级，id：{}", id);
            clazzService.deleteById(id);
            return Result.success();
        } catch (RuntimeException e) {
            log.error("删除班级异常，id：{}，班级中还有学员不能删除", id);
            return Result.error(e.getMessage());
        }

    }








}
