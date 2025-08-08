package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        Integer empCount = deptMapper.getCountByClazzId(id);
        if (empCount > 0) {
            throw new RuntimeException("部门下有员工，不能删除");
        }

        deptMapper.deleteById(id);
    }

    @Override
    public void save(Dept dept) {
        // 设置创建时间、更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 保存
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        // 设置更新时间
        dept.setUpdateTime(LocalDateTime.now());
        // 更新
        deptMapper.update(dept);
    }
}