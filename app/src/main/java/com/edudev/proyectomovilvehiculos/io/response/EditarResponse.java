package com.edudev.proyectomovilvehiculos.io.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pc on 07/01/2017.
 */

public class EditarResponse {
    @SerializedName("cabecera")
    ArrayList<String> cabecera;

    @SerializedName("Detalle")
    ArrayList<String> Detalle;

    @SerializedName("Tabla")
    ArrayList<String> tabla;

    @SerializedName("Pie")
    ArrayList<String> pie;

    public ArrayList<String> getCabecera() {
        return cabecera;
    }

    public void setCabecera(ArrayList<String> cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<String> getDetalle() {
        return Detalle;
    }

    public void setDetalle(ArrayList<String> detalle) {
        Detalle = detalle;
    }

    public ArrayList<String> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<String> tabla) {
        this.tabla = tabla;
    }

    public ArrayList<String> getPie() {
        return pie;
    }

    public void setPie(ArrayList<String> pie) {
        this.pie = pie;
    }
}
