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
    String workedHours;
    String credit;
    String StartHour;
    String EndHour;
    String date;
    ArrayList<Record> records;

    public Employee() {
    }

    public static Employee fromJson(JSONObject object) throws JSONException {
        Employee Employee = new Employee();
        Employee.setId(object.getString("id"));
        Employee.setName(object.getString("name"));
        Employee.setWorkedHours(object.getString("workedHours"));
        Employee.setCredit(object.getString("credit"));
        Employee.setStartHour(object.getString("StartHour"));
        Employee.setEndHour(object.getString("EndHour"));
        Employee.setDate(object.getString("date"));
        JSONArray jsonArray = object.getJSONArray("records");
        ArrayList<Record> records = new ArrayList<>();
        for (int j = 0; j < jsonArray.length(); j++) {
            JSONObject timestamp = jsonArray.getJSONObject(j);
            Date date = new Date(timestamp.getInt("timestamp") * 1000L);
            records.add(new Record(date));
        }
        Employee.setRecords(records);
        return Employee;
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

    public String getWorkedHours() {return workedHours;}

    public void setWorkedHours(String workedHours) {this.workedHours = workedHours;}

    public String getCredit() {return credit;}

    public void setCredit(String credit) {this.credit = credit;}

    public String getStartHour() {return StartHour;}

    public void setStartHour(String startHour) {this.StartHour = startHour;}

    public String getEndHour() {return EndHour;}

    public void setEndHour(String endHour) {this.EndHour = endHour;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public ArrayList<Record> getRecords() {return records;}

    public void setRecords(ArrayList<Record> records) {this.records = records;}

    @NonNull
    @Override
    public String toString(){
        return "name: " + getName() +
                " workedHours: " + getWorkedHours() +
                " credit: " + getCredit() +
                " StartHour: " + getStartHour() +
                " EndHour: " + getEndHour() +
                " date: " + getDate();
    }
}
