package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     */
    public void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工id删除员工工作经历信息
     */
    void deleteByEmpIds(List<Integer> ids);
}