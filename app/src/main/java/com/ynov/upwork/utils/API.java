package com.ynov.upwork.utils;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class API {
    public static final String BASE_URL = "http://192.168.1.112:3000/api";


    private static API sAPI;
    private final OkHttpClient mHttpClient;


    private API() {
        mHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public static API getInstance() {
        if (sAPI == null) {
            sAPI = new API();
        }
        return sAPI;
    }

    private Response getSynchronous(String path) throws IOException {
        return mHttpClient.newCall(buildGet(path)).execute();
    }

    private Request buildGet(String path) {
        return new Request
                .Builder()
                .url(String.format("%s%s", BASE_URL, path))
                .build();
    }

    public String getEmployees() throws IOException {
        Response listResponse = getSynchronous("/employees");

        if (HttpsURLConnection.HTTP_OK == listResponse.code()) {
            return listResponse.body().string();
        } else {
            return null;
        }
    }

    public String getEmployeeById(String id) throws IOException {
        Response listResponse = getSynchronous("/employee/" + id);

        if (HttpsURLConnection.HTTP_OK == listResponse.code()) {
            return listResponse.body().string();
        } else {
            return null;
        }
    }

    public String getSats() throws IOException {
        Response listResponse = getSynchronous("/statistics");

        if (HttpsURLConnection.HTTP_OK == listResponse.code()) {
            return listResponse.body().string();
        } else {
            return null;
        }
    }
}
