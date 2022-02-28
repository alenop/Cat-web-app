package com.atelier.CatWebApp.utils;


import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class CustomOkhttpClient {

    @Bean
    public OkHttpClient defaultOkHttpClient() {
        return new OkHttpClient();
    }

}
