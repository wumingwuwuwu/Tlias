package com.example.service;

import com.example.pojo.StudentCountOption;
import com.example.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计员工各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    StudentCountOption getStudentCountData();

    List<Map<String, Object>> getStudentEduData();
}
