package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.SecurityGuard;
import org.springframework.data.repository.CrudRepository;

import java.security.Guard;

public interface GuardDao extends CrudRepository<SecurityGuard,Integer> {
}
