package com.edudev.proyectomovilvehiculos.io;


import com.edudev.proyectomovilvehiculos.io.response.SessionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegistroVehicularApiService {

    @GET("login.php")
    Call<SessionResponse> getLogin(@Query("dni") String dni, @Query("clave") String password);

}