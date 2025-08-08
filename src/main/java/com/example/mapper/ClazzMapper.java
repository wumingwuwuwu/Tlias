package com.example.mapper;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 分页查询
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 查询所有老师
     */
    List<Clazz> findAll();

    /**
     * 新增
     */
    void insert(Clazz clazz);

    /**
     * 根据id查询班级
     */
    Clazz getById(Integer id);

    /**
     * 根据id修改班级
     */
    void update(Clazz clazz);

    /**
     * 根据id删除班级
     */
    void deleteById(Integer id);

    /**
     * 根据班级id查询班级人数
     */
    Integer studentCountByClazzId(Integer id);
}
