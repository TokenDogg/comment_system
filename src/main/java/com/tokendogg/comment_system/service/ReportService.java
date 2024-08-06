package com.tokendogg.comment_system.service;

import com.tokendogg.comment_system.entity.Report;
import com.tokendogg.comment_system.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    public Report addNewReport(Report report){
        reportMapper.addNewReport(report);
        return report;
    }


}
