package com.edudev.proyectomovilvehiculos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RegistroCabeceraDetalleFragment extends Fragment {

    public RegistroCabeceraDetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_registro_cabecera_detalle, container, false);
    }
}
