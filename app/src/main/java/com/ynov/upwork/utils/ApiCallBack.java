package com.ynov.upwork.utils;

import com.ynov.upwork.model.Employee;

import java.util.ArrayList;

public interface ApiCallBack {
    void onSuccess(ArrayList<Employee> employees);
    void onError();
}
