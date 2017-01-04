package com.edudev.proyectomovilvehiculos.io;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroVehicularApiAdapter {

    private static RegistroVehicularApiService API_SERVICE;

    public static RegistroVehicularApiService getApiService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "http://redemnorte.pe/SistemaInventarios/api/apiVehiculo/";
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    //.client(httpClient.build()) // <-- using the log level
                    .build();
            API_SERVICE = retrofit.create(RegistroVehicularApiService.class);
        }

        return API_SERVICE;
    }

}