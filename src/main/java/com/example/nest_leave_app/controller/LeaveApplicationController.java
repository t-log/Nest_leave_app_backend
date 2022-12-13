package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.LeaveApplicationDao;
import com.example.nest_leave_app.dao.LeaveCountDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class LeaveApplicationController{

    @Autowired
    LeaveApplicationDao lveapldao;

    @Autowired
    LeaveCountDao leaveCountDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public String update(@RequestBody LeaveApplication la)
    {
        String start=la.getFromDate();
        String end=la.getToDate();
        int days=daysBetweenDates(start,end);
        System.out.println(days);
        lveapldao.save(la);

        LeaveCount lc = new LeaveCount();
        System.out.println(la.getLeaveType());
        System.out.println(leaveCountDao.updateLeave(la.getEmpCode()));
        if(la.getLeaveType()=="sick")
        {


        }
        else if(la.getLeaveType()=="special")
        {

        }
        else
        {

        }
        return "{\"status\":\"success\"}";
    }
    public int daysBetweenDates(String data1,String data2)
    {
        LocalDate dt1 = LocalDate.parse(data1);
        LocalDate dt2 = LocalDate.parse(data2);
        return  Math.abs((int) ChronoUnit.DAYS.between(dt1,dt2));
    }

}
