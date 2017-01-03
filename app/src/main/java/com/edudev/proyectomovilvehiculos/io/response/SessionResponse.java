package com.edudev.proyectomovilvehiculos.io.response;


public class SessionResponse {


    private String nombre;
    private String dni;
    private boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

}
