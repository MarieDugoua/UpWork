package com.ynov.upwork.utils;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.ListEmployee;

import java.util.ArrayList;

public interface ApiCallBackEmployeeById {
    void onSuccess(ArrayList<Employee> employee);
    void onError();
}
