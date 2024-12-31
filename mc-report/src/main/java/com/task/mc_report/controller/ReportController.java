package com.task.mc_report.controller;

import com.task.mc_report.entity.Report;
import com.task.mc_report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/{userId}")
    public Report getUserReportById(@PathVariable Long userId){
        return reportService.getClientReport(userId);
    }

    @PostMapping
    public Report generateUserReport (@PathVariable Long userId, int totalTasks, int completedTasks, long totalTimeSpent){
        return reportService.generateReport(userId, totalTasks, completedTasks, totalTimeSpent);
    }
}
