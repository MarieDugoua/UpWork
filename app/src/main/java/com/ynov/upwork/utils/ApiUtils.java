package com.ynov.upwork.utils;

import android.util.Log;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.ListEmployee;
import com.ynov.upwork.model.Stats;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ApiUtils {

    public static void getEmployees(ApiCallBackEmployee callBack) {
        new Thread(() -> {
            ArrayList<ListEmployee> listEmployees = new ArrayList<>();
            JSONArray array;
            API api = API.getInstance();
            try {
                array = new JSONArray(api.getEmployees());
            } catch (Exception e) {
                e.printStackTrace();
                callBack.onError();
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                try {
                    listEmployees.add(ListEmployee.fromJson(array.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ApiUtils::get", listEmployees.toString());
            callBack.onSuccess(listEmployees);
        }).start();
    }

    public static void getEmployeeById(ApiCallBackEmployeeById callBack, Integer id) {
        new Thread(() -> {
            ArrayList<Employee> employee = new ArrayList<>();
            JSONArray array;
            API api = API.getInstance();
            try {
                array = new JSONArray(api.getEmployeeById(id));
            } catch (Exception e) {
                e.printStackTrace();
                callBack.onError();
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                try {
                    employee.add(Employee.fromJson(array.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ApiUtils::get", employee.toString());
            callBack.onSuccess(employee);
        }).start();
    }

    public static void getStats(ApiCallBackStats callBack) {
        new Thread(() -> {
            ArrayList<Stats> stats = new ArrayList<>();
            JSONArray array;
            API api = API.getInstance();
            try {
                array = new JSONArray(api.getEmployees());
            } catch (Exception e) {
                e.printStackTrace();
                callBack.onError();
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                try {
                    stats.add(Stats.fromJson(array.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ApiUtils::get", stats.toString());
            callBack.onSuccess(stats);
        }).start();
    }
}
