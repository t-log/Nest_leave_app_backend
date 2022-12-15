package com.example.nest_leave_app.controller;

import com.example.nest_leave_app.dao.GuardDao;
import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveCount;
import com.example.nest_leave_app.model.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Guard;
import java.util.HashMap;
import java.util.List;

@RestController
public class GuardController {

    @Autowired
    private GuardDao gdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addguard",consumes = "application/json",produces = "application/json")
    public String addGuard(@RequestBody SecurityGuard g)
    {
        gdao.save(g);
        return "{\"status\":\"success\"}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewguard")
    public List<SecurityGuard> viewEmployee()
    {
        return (List<SecurityGuard>) gdao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginguard",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> guardValidate(@RequestBody SecurityGuard g){

        List<SecurityGuard> checkData = (List<SecurityGuard>) gdao.validateGuard(g.getEmail(),g.getPassword());
        System.out.println(checkData);
        HashMap<String,String> hashmap= new HashMap<>();
        if(checkData.size()==0){
            hashmap.put("status","failed");
            hashmap.put("message","guard does not exist");
        }
        else{
            int empCode=checkData.get(0).getEmpCode();
            hashmap.put("empCode",String.valueOf(empCode));
            hashmap.put("status","success");
            hashmap.put("message","guard exists");
        }
        return hashmap;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchguard",consumes = "application/json",produces = "application/json")
    public List<SecurityGuard> searchEmployee(@RequestBody SecurityGuard g)
    {
        return (List<SecurityGuard>) gdao.searchGuard(g.getEmpCode());
    }
}
