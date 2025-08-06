package com.example.service;

import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public interface ClazzService {

    /**
     * 分页查询
     */
    PageResult page(ClazzQueryParam clazzQueryParam);
}
