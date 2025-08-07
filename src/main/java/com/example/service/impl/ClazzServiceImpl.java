package com.example.service.impl;

import com.example.mapper.ClazzMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 班级分页查询
     */
    @Override
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.list(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) list;
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 查询所有老师
     */
    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    /**
     * 保存班级信息
     */
    @Override
    public void save(Clazz clazz) {
        clazzMapper.insert(clazz);
    }

    /**
     * 根据id查询班级信息
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    /**
     * 根据id修改班级信息
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 根据id删除班级信息
     */
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

}
