package com.atelier.CatWebApp.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

@Configuration
public class CustomOkhttpClient {

    @Bean
    public OkHttpClient defaultOkHttpClient() {
        return new OkHttpClient();
    }

}
