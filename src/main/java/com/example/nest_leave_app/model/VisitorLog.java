package com.example.nest_leave_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs_visitor")
public class VisitorLog {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String purpose;
    private String whomToMeet;
    private String entryTime;
    private String exitTime;

    public VisitorLog() {
    }
    public VisitorLog(int id, String name, String purpose, String whomToMeet, String entryTime, String exitTime) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.whomToMeet = whomToMeet;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWhomToMeet() {
        return whomToMeet;
    }

    public void setWhomToMeet(String whomToMeet) {
        this.whomToMeet = whomToMeet;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
