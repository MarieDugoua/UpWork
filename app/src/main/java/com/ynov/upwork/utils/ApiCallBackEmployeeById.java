package com.ynov.upwork.utils;

import com.ynov.upwork.model.Employee;
import com.ynov.upwork.model.EmployeeResponseAPI;

import java.util.ArrayList;

public interface ApiCallBackEmployeeById {
    void onSuccess(EmployeeResponseAPI employee);
    void onError();
}
