package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.VisitorLogDao;
import com.example.nest_leave_app.model.EmployeeLog;
import com.example.nest_leave_app.model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.logging.Handler;

@RestController
public class VisitorLogController {
    @Autowired
    private VisitorLogDao visitorLogDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addvisitorlog",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addVisitorLog(@RequestBody VisitorLog vlog)
    {
        HashMap<String,String > hashmap = new HashMap<String,String>();
        visitorLogDao.save(vlog);
        hashmap.put("status","success");
        hashmap.put("visitorId",String.valueOf(vlog.getId()));
        return hashmap;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addvisitorexit",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> exitLogVisitor(@RequestBody VisitorLog vlog)
    {
        HashMap<String,String> hashmap = new HashMap<String,String>();
        visitorLogDao.updateExitLogVisitor(vlog.getId(),vlog.getExitTime());
        hashmap.put("status","success");
        return hashmap;
    }
}
