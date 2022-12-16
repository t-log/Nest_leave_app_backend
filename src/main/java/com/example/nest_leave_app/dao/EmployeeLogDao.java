package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.EmployeeLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeLogDao extends CrudRepository<EmployeeLog,Integer> {
    @Modifying
    @Transactional
    @Query(value ="UPDATE `logs_employee` SET `exit_time`=:exitTime WHERE `emp_code`=:empCode" ,nativeQuery = true)
    void updateExitLog(@Param("empCode") Integer empCode,@Param("exitTime") String exitTime);

    @Query(value ="SELECT l.`id`, l.`date`, l.`emp_code`, l.`entry_time`, l.`exit_time`, e.`name` FROM `logs_employee` l JOIN employees e on l.emp_code=e.id" ,nativeQuery = true)
    List<Map<String,String>> getLogWithEmpName();

    @Query(value ="SELECT `id` FROM `employees` WHERE `id` NOT IN (SELECT `emp_code` FROM `leaves` WHERE :todaysDate BETWEEN `from_date` AND `to_date` and status=2)" ,nativeQuery = true)
    ArrayList<Integer> checkIfEmpOnLeave(@Param ("todaysDate") String todaysDate);
}
