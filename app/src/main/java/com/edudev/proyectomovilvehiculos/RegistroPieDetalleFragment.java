package com.edudev.proyectomovilvehiculos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class RegistroPieDetalleFragment extends Fragment {


    View view;

    MaterialBetterSpinner materialBetterSpinner;

    public RegistroPieDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registro_pie_detalle, container, false);

        String[] opciones = getResources().getStringArray(R.array.array_situacion);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, opciones);

        materialBetterSpinner=(MaterialBetterSpinner)view.findViewById(R.id.txt_situacion);
        materialBetterSpinner.setAdapter(adapter);

        ((RegistroActivity)getActivity()).encenderBotonGrabar();
        return view;
    }

    @Override
    public void onDestroyView() {
        ((RegistroActivity)getActivity()).apagarBotonGrabar();
        super.onDestroyView();
    }
}
