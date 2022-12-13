package com.example.nest_leave_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "counts")
public class LeaveCount {
    @Id
    @GeneratedValue
    private int id;
    private int empCode;
    private String year;
    private String sickLeaveCount;
    private String casualLeaveCount;
    private String specialLeaveCount;


}
