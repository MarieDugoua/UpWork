package com.ynov.upwork.utils;

import android.util.Log;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.EmployeeResponseAPI;
import com.ynov.upwork.model.ListEmployee;
import com.ynov.upwork.model.Stats;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public static void getEmployeeById(ApiCallBackEmployeeById callBack, String id) {
        new Thread(() -> {
            API api = API.getInstance();
            try {
                JSONObject object = new JSONObject(api.getEmployeeById(id));
                EmployeeResponseAPI employeeResponseAPI = EmployeeResponseAPI.fromJson(object);

                Log.d("ApiUtils::getEmployeeById", employeeResponseAPI.toString());
                callBack.onSuccess(employeeResponseAPI);
            } catch (Exception e) {
                e.printStackTrace();
                callBack.onError();
            }
        }).start();
    }

    public static void getStats(ApiCallBackStats callBack) {
        new Thread(() -> {
            API api = API.getInstance();
            try {
                JSONObject object = new JSONObject(api.getSats());
                Log.d("ApiUtils::getStats", object.toString());
                callBack.onSuccess(object);
            } catch (Exception e) {
                e.printStackTrace();
                callBack.onError();
                return;
            }

        }).start();
    }
}
