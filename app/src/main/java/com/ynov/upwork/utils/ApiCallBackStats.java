package com.ynov.upwork.utils;

import com.ynov.upwork.model.ListEmployee;
import com.ynov.upwork.model.Stats;

import java.util.ArrayList;

public interface ApiCallBackStats {
    void onSuccess(Stats stats);
    void onError();
}
