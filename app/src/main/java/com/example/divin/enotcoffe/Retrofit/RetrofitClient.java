package com.example.divin.enotcoffe.Retrofit;

import retrofit2.Retrofit;

public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getInstance() {
        if (ourInstance == null){
            //ourInstance = new Retrofit().baseUrl().
        }
        return ourInstance;
    }

    private RetrofitClient() { }
}
