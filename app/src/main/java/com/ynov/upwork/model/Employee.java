package com.ynov.upwork.model;

import java.sql.Timestamp;

public class Employee {
    String id;
    String name;
    Boolean isWorking;
    Timestamp date;

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsWorking() {return isWorking;}

    public void setIsWorking(Boolean isWorking) {this.isWorking = isWorking;}

    public Timestamp getDate() {return date;}

    public void setDate(Timestamp date) {this.date = date;}

}
