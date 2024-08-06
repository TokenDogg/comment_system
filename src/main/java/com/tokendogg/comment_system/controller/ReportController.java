package com.tokendogg.comment_system.controller;

import com.tokendogg.comment_system.entity.Report;
import com.tokendogg.comment_system.mapper.ReportMapper;
import com.tokendogg.comment_system.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Report addNewReport(Report report){
        return reportService.addNewReport(report);
    }
}
