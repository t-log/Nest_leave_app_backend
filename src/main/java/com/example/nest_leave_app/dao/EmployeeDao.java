package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.Employee;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Modifying
    @Transactional
    @Query(value ="DELETE FROM `employees` WHERE `emp_code`=:id" ,nativeQuery = true)
    void deleteEmployee(@Param("id") Integer id);


    @Query(value ="SELECT * FROM `employees` WHERE `emp_code`=:id" ,nativeQuery = true)
    List<Employee> search(@Param("id") Integer id);

    @Query(value ="SELECT * FROM `employees` WHERE `email`=:email AND `password`=:password" ,nativeQuery = true)
    List<Employee> validateEmployee(@Param("email") String email,@Param("password") String password);

}
