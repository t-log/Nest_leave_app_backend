package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.LeaveApplicationDao;
import com.example.nest_leave_app.dao.LeaveCountDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveApplicationController{

    @Autowired
    LeaveApplicationDao lveapldao;

    @Autowired
    LeaveCountDao leaveCountDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> update(@RequestBody LeaveApplication la)
    {
        HashMap<String,String> hashmap= new HashMap<>();
        lveapldao.save(la);
        hashmap.put("status","success");
        hashmap.put("leaveId",String.valueOf(la.getId()));
        return hashmap;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leavestatus",consumes = "application/json",produces = "application/json")
    public List<LeaveApplication> leaveStatus(@RequestBody LeaveApplication la)
    {
        return (List<LeaveApplication>) lveapldao.leaveStatus(la.getEmpCode());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallleaves")
    public List<Map<String,String>> viewAllLeaves()
    {
        return (List<Map<String,String>>) lveapldao.viewAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/decide",consumes = "application/json",produces = "application/json")
    public String leaveDecide(@RequestBody LeaveApplication la)
    {
        if(la.getStatus()==2)
        {
            HashMap<String,String> hashmap= new HashMap<>();
            String start=la.getFromDate();
            String end=la.getToDate();
            int daysDifference=daysBetweenDates(start,end);
            System.out.println("Total days of absence:"+daysDifference);

            int empC=la.getEmpCode();
            LeaveCount lc = leaveCountDao.getEmpObject(empC);  //to get the count object of the corresponding leave application
            System.out.println("The empCode of corresponding Leave Application from counts table:"+lc.getEmpCode());
            System.out.println(la.getLeaveType());

            if(la.getLeaveType().equals("Sick"))
            {
                if(daysDifference<=lc.getSickLeaveCount())
                {
                    lc.setSickLeaveCount(lc.getSickLeaveCount()-daysDifference);
                    leaveCountDao.save(lc);
                }
                else
                {
                    System.out.println("Sick leaves exhausted");
                    hashmap.put("status", "failed");
                }
            }
            else if(la.getLeaveType().equals("Special"))
            {
                if(daysDifference<=lc.getSpecialLeaveCount())
                {
                    lc.setSpecialLeaveCount(lc.getSpecialLeaveCount()-daysDifference);
                    leaveCountDao.save(lc);
                }
                else
                {
                    System.out.println("Special leaves exhausted");
                    hashmap.put("status", "failed");
                }
            }
            else
            {
                System.out.println(lc.getCasualLeaveCount());
                System.out.println("Inside casual condition");
                if(daysDifference<=lc.getCasualLeaveCount())
                {
                    lc.setCasualLeaveCount(lc.getCasualLeaveCount()-daysDifference);
                    leaveCountDao.save(lc);
                }
                else
                {
                    System.out.println("Casual leaves exhausted");
                    hashmap.put("status", "failed");
                }
            }
//            lveapldao.decide(la.getEmpCode(), la.getStatus());
//            return "{\"status\":\"success\"}";
        }

            lveapldao.decide(la.getEmpCode(), la.getStatus(),la.getId());
            return "{\"status\":\"success\"}";


    }
    public int daysBetweenDates(String data1,String data2)
    {
        LocalDate dt1 = LocalDate.parse(data1);
        LocalDate dt2 = LocalDate.parse(data2);
        return  Math.abs((int) ChronoUnit.DAYS.between(dt1,dt2));
    }


}
