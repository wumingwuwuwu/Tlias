package com.example.mapper;

import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    void violation(Integer id, Integer score);

    @MapKey("clazz_id")
    List<Map<String, Object>> countStuNumData();

    @MapKey("degree_name")
    List<Map<String, Object>> countStuEduData();
}
