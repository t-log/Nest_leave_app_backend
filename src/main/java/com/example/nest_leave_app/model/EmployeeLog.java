package com.example.nest_leave_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs_employee")
public class EmployeeLog {
    @Id
    @GeneratedValue
    private int id;
    private int empCode;
    private String date;
    private String entryTime;
    private String exitTime;
}
