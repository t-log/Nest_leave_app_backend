package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.EmployeeLogDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.EmployeeLog;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeLogController {

    @Autowired
    EmployeeLogDao employeeLogDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemplog",consumes = "application/json",produces = "application/json")
    public String addEmployeeLog(@RequestBody EmployeeLog elog)
    {
        employeeLogDao.save(elog);
        return "{\"status\":\"success\"}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemplogexit",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody EmployeeLog elog)
    {
        employeeLogDao.updateExitLog(elog.getEmpCode(),elog.getExitTime());
        return "{\"status\":\"success\"}";
    }
}
