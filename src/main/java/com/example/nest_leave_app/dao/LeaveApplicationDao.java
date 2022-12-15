package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveApplicationDao extends CrudRepository<LeaveApplication,Integer> {
    @Query(value ="SELECT `id`, `remarks`, `apply_date`, `emp_code`, `from_date`, `leave_type`, `status`, `to_date` FROM `leaves` WHERE `emp_code`=:empCode" ,nativeQuery = true)
    List<LeaveApplication> leaveStatus(@Param("empCode") Integer empCode);

    @Query(value ="SELECT l.`id`, l.`remarks`, l.`apply_date`, l.`emp_code`, l.`from_date`, l.`leave_type`, l.`status`, l.`to_date`,e.`name` FROM `leaves` l JOIN `employees` e WHERE l.`emp_code`=e.`id`" ,nativeQuery = true)
    List<Map<String,String>> viewAll();

//    SELECT l.`id`, l.`remarks`, l.`apply_date`, l.`emp_code`, l.`from_date`, l.`leave_type`, l.`status`, l.`to_date`,e.`name` FROM `leaves` l JOIN `employees` e WHERE l.`emp_code`=e.`id`
//    SELECT `id`, `remarks`, `apply_date`, `emp_code`, `from_date`, `leave_type`, `status`, `to_date` FROM `leaves` WHERE `emp_code`=:empCode

    @Modifying
    @Transactional
    @Query(value ="UPDATE `leaves` SET `status`=:status WHERE `emp_code`=:empCode" ,nativeQuery = true)
    void decide(@Param("empCode") Integer empCode,@Param("status") Integer status);
}
