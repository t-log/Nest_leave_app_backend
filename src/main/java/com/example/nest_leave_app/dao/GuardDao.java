package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.Employee;
import com.example.nest_leave_app.model.SecurityGuard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.security.Guard;
import java.util.List;

public interface GuardDao extends CrudRepository<SecurityGuard,Integer> {

    @Query(value ="SELECT * FROM `guards` WHERE `email`=:email AND `password`=:password" ,nativeQuery = true)
    List<SecurityGuard> validateGuard(@Param("email") String email, @Param("password") String password);

    @Query(value ="SELECT * FROM `guards` WHERE `emp_code`=:id" ,nativeQuery = true)
    List<SecurityGuard> searchGuard(@Param("id") Integer id);
}
