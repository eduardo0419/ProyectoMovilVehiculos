package com.edudev.proyectomovilvehiculos.io;


import com.edudev.proyectomovilvehiculos.io.response.ListarResponse;
import com.edudev.proyectomovilvehiculos.io.response.RegistroResponse;
import com.edudev.proyectomovilvehiculos.io.response.SessionResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegistroVehicularApiService {

    @GET("login.php")
    Call<SessionResponse> getLogin(@Query("dni") String dni, @Query("clave") String password);

    @GET("registro.php")
    Call<RegistroResponse> setRegistro(@Query("cabeceraHoja[]") ArrayList<String> cabeceraHoja,@Query("detalle[]") ArrayList<String> detalle,@Query("tabla[]") ArrayList<String> tabla,@Query("pie[]") ArrayList<String> pie,@Query("dni") String dni );

    @GET("listar.php")
    Call<ListarResponse> getListar(@Query("dni") String dni);


}