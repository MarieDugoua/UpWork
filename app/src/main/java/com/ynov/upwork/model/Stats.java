package com.ynov.upwork.model;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Stats {
    String workHours;
    String numberOfEmployees;
    String averageWorkedHoursByEmployee;
    String hoursWorkedByDay;
    ArrayList<Record> records;

    public Stats() {
    }

    public static Stats fromJson(JSONObject object) throws JSONException {
        Stats stats = new Stats();
        stats.setWorkHours(object.getString("workHours"));
        stats.setNumberOfEmployees(object.getString("numberOfEmployees"));
        stats.setAverageWorkedHoursByEmployee(object.getString("averageWorkedHoursByEmployee"));
        stats.setHoursWorkedByDay(object.getString("hoursWorkedByDay"));

        JSONArray jsonArray = object.getJSONArray("records");
        ArrayList<Record> records = new ArrayList<>();
        for (int j = 0; j < jsonArray.length(); j++) {
            JSONObject timestamp = jsonArray.getJSONObject(j);
            Date date = new Date(timestamp.getInt("timestamp") * 1000L);
            records.add(new Record(date));
        }
        stats.setRecords(records);
        return stats;
    }

    public String getHoursWorkedByDay() {return hoursWorkedByDay;}
    public void setHoursWorkedByDay(String hoursWorkedByDay) {this.hoursWorkedByDay = hoursWorkedByDay;}
    public String getAverageWorkedHoursByEmployee() {return averageWorkedHoursByEmployee;}
    public void setAverageWorkedHoursByEmployee(String averageWorkedHoursByEmployee) {this.averageWorkedHoursByEmployee = averageWorkedHoursByEmployee;}
    public String getNumberOfEmployees() {return numberOfEmployees;}
    public void setNumberOfEmployees(String numberOfEmployees) {this.numberOfEmployees = numberOfEmployees;}
    public String getWorkHours() {return workHours;}
    public void setWorkHours(String workHours) {this.workHours = workHours;}
    public ArrayList<Record> getRecords() {return records;}
    public void setRecords(ArrayList<Record> records) {this.records = records;}

    @NonNull
    @Override
    public String toString() {
        return
                "workHours:" + getWorkHours() +
                " numberOfEmployees:" + getNumberOfEmployees() +
                " averageWorkedHoursByEmployee:" + getAverageWorkedHoursByEmployee() +
                " hoursWorkedByDay:" + getHoursWorkedByDay();
    }
}
