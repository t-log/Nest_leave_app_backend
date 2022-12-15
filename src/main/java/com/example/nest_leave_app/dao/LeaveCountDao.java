package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.LeaveApplication;
import com.example.nest_leave_app.model.LeaveCount;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {
//    @Modifying
//    @Transactional
//    @Query(value ="UPDATE counts SET casual_leave_count=20-:diffCount WHERE emp_code=:empCode",nativeQuery = true)
//    void updateCasualLeave(@Param("diffCount") Integer diffCount,@Param("empCode")Integer empCode);
//
//    @Modifying
//    @Transactional
//    @Query(value ="UPDATE counts SET sick_leave_count=7-:diffCount WHERE emp_code=:empCode",nativeQuery = true)
//    void updateSickLeave(@Param("diffCount") Integer diffCount,@Param("empCode")Integer empCode);
//
//    @Modifying
//    @Transactional
//    @Query(value ="UPDATE counts SET special_leave_count=3-:diffCount WHERE emp_code=:empCode",nativeQuery = true)
//    void updateSpecialLeave(@Param("diffCount") Integer diffCount,@Param("empCode")Integer empCode);

    @Query(value ="SELECT `id`, `casual_leave_count`, `emp_code`, `sick_leave_count`, `special_leave_count`, `year` FROM `counts` WHERE emp_code=:empCode" ,nativeQuery = true)
    LeaveCount getEmpObject(@Param("empCode") Integer empCode);

//    @Query(value ="SELECT `id`, `casual_leave_count`, `emp_code`, `sick_leave_count`, `special_leave_count`, `year` FROM `counts` WHERE `emp_code`=:empCode" ,nativeQuery = true)
//    LeaveCount remainingLeaves(@Param("empCode") Integer empCode);
}
