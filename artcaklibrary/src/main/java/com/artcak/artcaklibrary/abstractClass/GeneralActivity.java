package com.artcak.artcaklibrary.abstractClass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.artcak.artcaklibrary.apis.GeneralApi;
import com.artcak.artcaklibrary.tools.Tools;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeneralActivity extends AppCompatActivity {
    protected Retrofit retrofit;
    protected Gson gson;
    protected Tools tools;
    protected GeneralApi generalApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new GsonBuilder().create();
        createRetrofit();
        generalApi = retrofit.create(GeneralApi.class);
        tools = new Tools(this);
    }

    protected void createRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
