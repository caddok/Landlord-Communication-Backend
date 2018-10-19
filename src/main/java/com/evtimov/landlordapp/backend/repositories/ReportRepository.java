package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {

    private final SessionFactory sessionFactory;


    @Autowired
    public ReportRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Report createReport(Report report) {
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            session.save(report);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return report;
    }

    public Report updateReportStatus(int reportId, Report model){
        Report reportToChange = null;
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            reportToChange = session.get(Report.class, reportId);

            //update report

            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return reportToChange;
    }


    // we don't need it, because we will use place.getAllReports().stream() from Place class
    public List<Report> getAllResolvedReports(int id){
        return null;
    }

    // we don't need it, because we will use place.getAllReports().stream() from Place class
    public List<Report> getAllUnresolvedReports(int id){
        return null;
    }

    // we don't need it, because we will use place.getAllReports()
    public Report getReportById(int id) {
        return null;
    }

    // we don't need it, because we will use place.getAllReports()
    private List<Report> getAllReportsByPlaceId(int id) {
        return null;
    }
}
