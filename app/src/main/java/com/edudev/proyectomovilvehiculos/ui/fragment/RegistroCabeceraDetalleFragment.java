package com.edudev.proyectomovilvehiculos.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.ui.activity.RegistroActivity;


public class RegistroCabeceraDetalleFragment extends Fragment implements View.OnClickListener {

    View view;
    FragmentManager fm;



    Button btn_siguiente;
    Button btn_atras;

    public RegistroCabeceraDetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_registro_cabecera_detalle, container, false);

        fm=getActivity().getSupportFragmentManager();

        btn_siguiente=(Button)view.findViewById(R.id.btn_siguiente);
        btn_atras=(Button)view.findViewById(R.id.btn_atras);

        btn_siguiente.setOnClickListener(this);
        btn_atras.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_siguiente:
                transicionFragmentSiguiente();
                break;
            case R.id.btn_atras:
                transicionFragmentAtras();
                break;
        }
    }

    private void transicionFragmentAtras() {
        fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraFragment()).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }

    private void transicionFragmentSiguiente() {
        fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleTablaFragment()).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }
}
