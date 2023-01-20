package com.ynov.upwork.utils;

import com.ynov.upwork.model.Employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiUtils {

    public static void get() {
        new Thread(() -> {
            ArrayList<Employee> employees = new ArrayList<>();
            JSONArray array = null;
            API api = API.getInstance();
            try {
                JSONObject j = new JSONObject(api.getEmployees());
                array =  j.getJSONArray("records");
            } catch (Exception e) {e.printStackTrace();}
            JSONObject obj = null;
            JSONObject fields = null;
            Employee employee;
            for (int i = 0; i < array.length(); i++) {
                try {
                    obj = array.getJSONObject(i);
                    fields = obj.getJSONObject("fields");
                } catch (JSONException e) {e.printStackTrace(); continue;}
                employee = new Employee();

                try {employee.setId(obj.getString("id"));} catch (JSONException ignored) {}
                try {employee.setName(fields.getString("name"));} catch (JSONException ignored) {}

                employees.add(employee);
            }
        }).start();
    }

}
