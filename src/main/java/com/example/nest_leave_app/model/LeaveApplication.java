package com.example.nest_leave_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaves")
public class LeaveApplication {
    @Id
    @GeneratedValue
    private int id;
    private int empCode;
    private String leaveType;
    private String remarks;
    private String fromDate;
    private String toDate;
    private String applyDate;
    private int status;

    public LeaveApplication() {
    }
    public LeaveApplication(int id, int empCode, String leaveType, String remarks, String fromDate, String toDate, String applyDate, int status) {
        this.id = id;
        this.empCode = empCode;
        this.leaveType = leaveType;
        this.remarks = remarks;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.applyDate = applyDate;
        this.status = status;
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

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
