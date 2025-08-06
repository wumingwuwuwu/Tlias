package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门信息
     */
    List<Dept> findAll();

    /**
     * 删除指定部门信息
     */
    void deleteById(Integer id);

    /**
     * 保存新增部门信息
     */
    void save(Dept dept);

    /**
     * 根据id查询部门信息
     */
    Dept getById(Integer id);

    /**
     * 更新部门信息
     */
    void update(Dept dept);
}
