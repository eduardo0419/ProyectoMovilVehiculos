package com.edudev.proyectomovilvehiculos.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.ui.activity.RegistroActivity;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class RegistroPieDetalleFragment extends Fragment implements View.OnClickListener {


    View view;
    FragmentManager fm;

    Button btn_atras;
    Button btn_grabar;

    MaterialBetterSpinner materialBetterSpinner;

    public RegistroPieDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registro_pie_detalle, container, false);
        fm=getActivity().getSupportFragmentManager();

        String[] opciones = getResources().getStringArray(R.array.array_situacion);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, opciones);

        materialBetterSpinner=(MaterialBetterSpinner)view.findViewById(R.id.txt_situacion);
        materialBetterSpinner.setAdapter(adapter);

        btn_atras=(Button)view.findViewById(R.id.btn_atras);
        btn_grabar=(Button)view.findViewById(R.id.btn_grabar);

        btn_atras.setOnClickListener(this);
        btn_grabar.setOnClickListener(this);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_siguiente:
                break;
            case R.id.btn_atras:
                transicionFragmentAtras();
                break;
        }
    }

    private void transicionFragmentAtras() {
        fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleTablaFragment()).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }
}
