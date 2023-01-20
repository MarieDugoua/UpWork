package com.ynov.upwork.model;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Employee {
    String id;
    String name;
    Boolean isWorking;
    Timestamp date;
    ArrayList<Record> records;

    public Employee() {
    }

    public static Employee fromJson(JSONObject object) throws JSONException {
        Employee employee = new Employee();
        employee.setId(object.getString("id"));
        employee.setName(object.getString("name"));
        employee.setIsWorking(object.getBoolean("isWorking"));
        JSONArray jsonArray = object.getJSONArray("records");
        ArrayList<Record> records = new ArrayList<>();
        for (int j = 0; j < jsonArray.length(); j++) {
            JSONObject timestamp = jsonArray.getJSONObject(j);
            Date date = new Date(timestamp.getInt("timestamp") * 1000L);
            records.add(new Record(date));
        }
        employee.setRecords(records);
        return employee;
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

    public ArrayList<Record> getRecords() {return records;}

    public void setRecords(ArrayList<Record> records) {this.records = records;}

    @NonNull
    @Override
    public String toString() {
        return "id:" + getId() + " name:" + getName() + " isWorking:" + getIsWorking().toString();
    }
}
