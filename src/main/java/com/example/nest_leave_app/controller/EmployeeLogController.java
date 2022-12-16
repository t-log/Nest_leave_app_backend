package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.EmployeeLogDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.EmployeeLog;
import com.example.nest_leave_app.model.LeaveCount;
import com.example.nest_leave_app.model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeLogController {

    @Autowired
    EmployeeLogDao employeeLogDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemplog",consumes = "application/json",produces = "application/json")
    public String addEmployeeLog(@RequestBody EmployeeLog elog)
    {
//        HashMap<String,String> hashmap = new HashMap<String,String>();
        ArrayList<Integer> empsNotOnLeave= employeeLogDao.checkIfEmpOnLeave(elog.getDate());
        if(empsNotOnLeave.contains(elog.getEmpCode()))
        {
            employeeLogDao.save(elog);
            return "{\"status\":\"success\"}";
        }
        else
        {
            return "{\"status\":\"failed\"}";
        }

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemplogexit",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody EmployeeLog elog)
    {
        employeeLogDao.updateExitLog(elog.getEmpCode(),elog.getExitTime());
        return "{\"status\":\"success\"}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewemplog")
    public List<Map<String,String>> viewEmployee()
    {
        return (List<Map<String,String>>) employeeLogDao.getLogWithEmpName();
    }
}
