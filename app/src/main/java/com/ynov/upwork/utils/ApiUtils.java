package com.ynov.upwork.utils;

import android.util.Log;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.Record;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ApiUtils {

    public static void get() {
        new Thread(() -> {
            ArrayList<Employee> employees = new ArrayList<>();
            JSONArray array;
            API api = API.getInstance();
            try {
                array = new JSONArray(api.getEmployees());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                try {
                    employees.add(Employee.fromJson(array.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ApiUtils::get", employees.toString());
        }).start();
    }

}
