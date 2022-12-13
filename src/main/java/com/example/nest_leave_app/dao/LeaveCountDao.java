package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {
    @Query(value ="SELECT * FROM `counts` WHERE `emp_code`=:empCode",nativeQuery = true)
    List<LeaveApplication> updateLeave(@Param("empCode")Integer empCode);
}
