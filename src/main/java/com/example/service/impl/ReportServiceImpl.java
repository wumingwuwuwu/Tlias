package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import com.example.pojo.StudentCountOption;
import com.example.pojo.JobOption;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 统计各个职位的员工人数
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        // 封装数据
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public StudentCountOption getStudentCountData() {
        List<Map<String, Object>> maps = studentMapper.countStuNumData();

        List<Object> dataList = maps.stream().map(dataMap -> dataMap.get("cname")).toList();

        List<Object> classList = maps.stream().map(dataMap -> dataMap.get("scount")).toList();
        return new StudentCountOption(classList,dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentEduData() {
        return studentMapper.countStuEduData();
    }
}
