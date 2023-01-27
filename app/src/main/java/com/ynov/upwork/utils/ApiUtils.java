package com.ynov.upwork.utils;

import android.util.Log;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.ListEmployee;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ApiUtils {

    public static void get(ApiCallBack callBack) {
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

}
