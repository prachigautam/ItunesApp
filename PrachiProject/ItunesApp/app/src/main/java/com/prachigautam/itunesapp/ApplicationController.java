package com.prachigautam.itunesapp;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amar on 03-03-2017.
 */

public class ApplicationController extends MultiDexApplication {
    Context context;
    public static Retrofit retrofit;
    public static ExecutorService executorService;

    @Override
    public void onCreate() {
        super.onCreate();
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        // createing okhttpclient object
        OkHttpClient okhttpBulider = new OkHttpClient.Builder()
                .connectTimeout(600, TimeUnit.SECONDS)
                .readTimeout(600, TimeUnit.SECONDS)
                .build();


        // create a retrofitBuilder object
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)                         // set Base url (Endpoint)
                .client(okhttpBulider)                                   // adding the okhttp clint in retrofit object
                .addConverterFactory(GsonConverterFactory.create());

        // adding converter factory in retofit object

        // createing retrofit object using retrofitbuilder object
        retrofit = builder.build();
    }


}
