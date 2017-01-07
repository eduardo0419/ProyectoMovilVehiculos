package com.edudev.proyectomovilvehiculos.io.response;

import com.edudev.proyectomovilvehiculos.io.model.Registro;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pc on 06/01/2017.
 */

public class ListarResponse {
    @SerializedName("registros")
    private
    ArrayList<Registro> registros;

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
}
