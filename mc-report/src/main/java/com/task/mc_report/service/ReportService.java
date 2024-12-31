package com.task.mc_report.service;


import com.task.mc_report.entity.Report;
import com.task.mc_report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public Report getClientReport(Long userId) {
        return reportRepository.findByUserId(userId).orElseThrow(() ->
                new IllegalArgumentException("User with id " + userId + " not found."));
    }

    public Report generateReport(Long userId, int totalTasks, int completedTasks, long totalTimeSpent) {
        Report report = new Report();
        report.setUserId(userId);
        report.setTotalTasks(totalTasks);
        report.setCompletedTasks(completedTasks);
        report.setTotalTimeSpent(totalTimeSpent);

        return reportRepository.save(report);
    }
}
