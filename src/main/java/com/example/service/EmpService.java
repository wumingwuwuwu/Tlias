package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.LoginInfo;
import com.example.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

//    List<Emp> list();

    /**
     * 分页查询
     * @param empQueryParam
     * @return
     */
    PageResult page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 员工信息查询
     * @param id
     * @return
     */
    Emp getInfo(Integer id);

    /**
     * 员工信息更新
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    LoginInfo login(Emp emp);
}
