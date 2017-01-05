package com.edudev.proyectomovilvehiculos.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.ui.activity.RegistroActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroCabeceraFragment extends Fragment implements View.OnClickListener {


    View view;
    FragmentManager fm;

    EditText txt_nuRegistro;
    EditText txt_local;
    EditText txt_ubicacion;
    EditText txt_unidad;
    EditText txt_jefatura;
    EditText txt_dependencia;
    EditText txt_brevete;

    Button btn_siguiente;

    ArrayList<String> cabecera;
    ArrayList<String> detalle;
    ArrayList<String> tabla;
    ArrayList<String> pie;
    public RegistroCabeceraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_registro_cabecera, container, false);

        fm=getActivity().getSupportFragmentManager();

        txt_nuRegistro=(EditText)view.findViewById(R.id.txt_nuRegistro);
        txt_local=(EditText)view.findViewById(R.id.txt_local);
        txt_ubicacion=(EditText)view.findViewById(R.id.txt_ubicacion);
        txt_unidad=(EditText)view.findViewById(R.id.txt_unidad);
        txt_jefatura=(EditText)view.findViewById(R.id.txt_jefatura);
        txt_dependencia=(EditText)view.findViewById(R.id.txt_dependencia);
        txt_brevete=(EditText)view.findViewById(R.id.txt_brevete);

        Bundle bundle = this.getArguments();

        cabecera=bundle.getStringArrayList("cabecera");
        detalle=bundle.getStringArrayList("Detalle");
        tabla=bundle.getStringArrayList("Tabla");
        pie=bundle.getStringArrayList("Pie");

        if (cabecera.get(0)!="0"){
            txt_nuRegistro.setText(cabecera.get(1));
            txt_local.setText(cabecera.get(2));
            txt_ubicacion.setText(cabecera.get(3));
            txt_unidad.setText(cabecera.get(4));
            txt_jefatura.setText(cabecera.get(5));
            txt_dependencia.setText(cabecera.get(6));
            txt_brevete.setText(cabecera.get(7));
        }

        btn_siguiente=(Button)view.findViewById(R.id.btn_siguiente);
        btn_siguiente.setOnClickListener(this);

        ((RegistroActivity)getActivity()).posicionarScroll();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_siguiente:
                if(validate()) {
                    transicionFragmentSiguiente();
                }
                break;
        }
    }

    private void transicionFragmentSiguiente() {

        Bundle bundle=new Bundle();
        ArrayList<String> cabecera=new ArrayList<String>();

        cabecera.add("1");
        cabecera.add(txt_nuRegistro.getText().toString());
        cabecera.add(txt_local.getText().toString());
        cabecera.add(txt_ubicacion.getText().toString());
        cabecera.add(txt_unidad.getText().toString());
        cabecera.add(txt_jefatura.getText().toString());
        cabecera.add(txt_dependencia.getText().toString());
        cabecera.add(txt_brevete.getText().toString());

        bundle.putStringArrayList("cabecera",cabecera);
        bundle.putStringArrayList("Detalle",detalle);
        bundle.putStringArrayList("Tabla",tabla);
        bundle.putStringArrayList("Pie",pie);

        RegistroCabeceraDetalleFragment registroCabeceraDetalleFragment =new RegistroCabeceraDetalleFragment();
        registroCabeceraDetalleFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.container_form,registroCabeceraDetalleFragment).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }

    public boolean validate() {
        boolean valid = true;

        String nuRegistro = txt_nuRegistro.getText().toString();
        String local = txt_local.getText().toString();
        String Ubicacion=txt_ubicacion.getText().toString();
        String UnidaOrga=txt_unidad.getText().toString();
        String Dependencia=txt_dependencia.getText().toString();

        if (nuRegistro.isEmpty()) {
            txt_nuRegistro.setError("No puede dejar vacio este dato");
            valid = false;
        }
        if (local.isEmpty()) {
            txt_local.setError("No puede dejar vacio este dato");
            valid = false;
        }
        if (Ubicacion.isEmpty()) {
            txt_ubicacion.setError("No puede dejar vacio este dato");
            valid = false;
        }
        if (UnidaOrga.isEmpty()) {
            txt_unidad.setError("No puede dejar vacio este dato");
            valid = false;
        }
        if (Dependencia.isEmpty()) {
            txt_dependencia.setError("No puede dejar vacio este dato");
            valid = false;
        }
        return valid;
    }
}
