package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询所有的员工及其对应的部门名称
     */
    /*@Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id")
    List<Emp> list();*/

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    Long count();

    /**
     * 查询所有对应上名字性别
     */
    @Select("<script>" +
            "SELECT e.*, d.name as deptName FROM emp e " +
            "LEFT JOIN dept d ON e.dept_id = d.id " +
            "WHERE 1=1 " +
            "<if test='name != null and name != \"\"'>" +
            "  AND e.name LIKE CONCAT('%', #{name}, '%')" +
            "</if>" +
            "<if test='gender != null'>" +
            "  AND e.gender = #{gender}" +
            "</if>" +
            "<if test='begin != null'>" +
            "  AND e.entry_date >= #{begin}" +
            "</if>" +
            "<if test='end != null'>" +
            "  AND e.entry_date &lt;= #{end}" +
            "</if>" +
            " ORDER BY e.update_time DESC" +
            "</script>")
    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);


}

