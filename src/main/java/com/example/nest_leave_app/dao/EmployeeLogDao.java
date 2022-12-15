package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.EmployeeLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeLogDao extends CrudRepository<EmployeeLog,Integer> {
    @Modifying
    @Transactional
    @Query(value ="UPDATE `logs_employee` SET `exit_time`=:exitTime WHERE `emp_code`=:empCode" ,nativeQuery = true)
    void updateExitLog(@Param("empCode") Integer empCode,@Param("exitTime") String exitTime);
}
