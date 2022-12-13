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
    private int sickLeaveCount;
    private int casualLeaveCount;
    private int specialLeaveCount;


    public LeaveCount() {
    }

    public LeaveCount(int id, int empCode, String year, int sickLeaveCount, int casualLeaveCount, int specialLeaveCount) {
        this.id = id;
        this.empCode = empCode;
        this.year = year;
        this.sickLeaveCount = sickLeaveCount;
        this.casualLeaveCount = casualLeaveCount;
        this.specialLeaveCount = specialLeaveCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSickLeaveCount() {
        return sickLeaveCount;
    }

    public void setSickLeaveCount(int sickLeaveCount) {
        this.sickLeaveCount = sickLeaveCount;
    }

    public int getCasualLeaveCount() {
        return casualLeaveCount;
    }

    public void setCasualLeaveCount(int casualLeaveCount) {
        this.casualLeaveCount = casualLeaveCount;
    }

    public int getSpecialLeaveCount() {
        return specialLeaveCount;
    }

    public void setSpecialLeaveCount(int specialLeaveCount) {
        this.specialLeaveCount = specialLeaveCount;
    }
}
