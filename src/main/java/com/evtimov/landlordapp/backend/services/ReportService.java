package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository repository;

    @Autowired
    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public void createReport(Report report) {
        repository.save(report);
    }

    public void updateReportStatus(Report report){
        repository.save(report);
    }

    public List<Report> getAllResolvedReports(int id){
        List<Report> relevantReports = getAllReportsByPlaceId(id);
        return relevantReports.stream()
                .filter(Report::getIsResolved)
                .collect(Collectors.toList());
    }

    public List<Report> getAllUnresolvedReports(int id){
        List<Report> relevantReports = getAllReportsByPlaceId(id);
        return relevantReports.stream()
                .filter(rp->rp.getIsResolved() == false)
                .collect(Collectors.toList());
    }

    public Optional<Report> getReportById(int id) {
        List<Report> allReports = (List<Report>) repository.findAll();
        return allReports.stream()
                .findFirst()
                .filter(report -> report.getReportID() == id);
    }

    private List<Report> getAllReportsByPlaceId(int id) {
        List<Report> reports = (List<Report>) repository.findAll();
        return reports.stream()
                .filter(report -> report.getPlaceID() == id)
                .collect(Collectors.toList());
    }
}
