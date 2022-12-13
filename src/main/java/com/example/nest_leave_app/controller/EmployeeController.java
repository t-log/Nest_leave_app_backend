package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.EmployeeDao;
import com.example.nest_leave_app.dao.LeaveApplicationDao;
import com.example.nest_leave_app.dao.LeaveCountDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao edao;

    @Autowired
    private LeaveCountDao leaveCountDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
    public String addEmployee(@RequestBody Employee e)
    {
        edao.save(e);
        LeaveCount l=new LeaveCount();
        l.setSickLeaveCount(7);
        l.setSpecialLeaveCount(3);
        l.setCasualLeaveCount(20);
        l.setEmpCode(e.getId());
        leaveCountDao.save(l);

        return "{\"status\":\"success\"}";
    }
    public String addLeaveCount(@RequestBody Employee e)
    {
        edao.save(e);
        return "{\"status\":\"success\"}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view")
    public List<Employee> viewEmployee()
    {
        return (List<Employee>) edao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemp",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody Employee e)
    {
        edao.deleteEmployee(e.getId());
        return "{\"status\":\"success\"}";
    }

}
