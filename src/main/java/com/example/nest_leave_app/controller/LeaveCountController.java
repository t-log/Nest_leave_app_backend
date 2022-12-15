package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.LeaveCountDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaveCountController {

    @Autowired
    private LeaveCountDao leaveCountDao;

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/remainingleaves",consumes = "application/json",produces = "application/json")
//    public LeaveCount searchEmployee(@RequestBody LeaveCount lc)
//    {
//        return leaveCountDao.remainingLeaves(lc.getEmpCode());
//    }
}
