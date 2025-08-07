package com.example.controller;

import com.example.pojo.StudentCountOption;
import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 获取班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getClassNumData() {
        log.info("获取班级人数统计");
        StudentCountOption studentCountOption= reportService.getStudentCountData();
        return Result.success(studentCountOption);
    }

    /**
     * 统计各个学历的人数
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentEduData() {
        log.info("获取学员学历统计");
        List<Map<String,Object>> eduList= reportService.getStudentEduData();
        return Result.success(eduList);
    }
}
