package com.edudev.proyectomovilvehiculos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class RegistroPieDetalleFragment extends Fragment {


    View view;

    public RegistroPieDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registro_pie_detalle, container, false);
        return view;
    }

}
