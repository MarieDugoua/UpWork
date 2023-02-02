package com.ynov.upwork.utils;

import com.ynov.upwork.model.ListEmployee;

import java.util.ArrayList;

public interface ApiCallBackEmployee {
    void onSuccess(ArrayList<ListEmployee> listEmployees);
    void onError();
}
