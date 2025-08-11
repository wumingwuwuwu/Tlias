package com.example.service.impl;

import com.example.mapper.OperateLogMapper;
import com.example.pojo.LogQueryParam;
import com.example.pojo.OperateLog;
import com.example.pojo.PageResult;
import com.example.service.LogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(LogQueryParam log) {
        PageHelper.startPage(log.getPage(), log.getPageSize());
        List<OperateLog> operateLogList = operateLogMapper.findAll(log);
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;
        return new PageResult<OperateLog>(p.getTotal(), p.getResult());
    }

}
