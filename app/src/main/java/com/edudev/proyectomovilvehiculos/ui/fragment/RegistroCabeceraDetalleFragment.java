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


public class RegistroCabeceraDetalleFragment extends Fragment implements View.OnClickListener {

    View view;
    FragmentManager fm;



    Button btn_siguiente;
    Button btn_atras;

    EditText txt_codigoAnterior;
    EditText txt_codigoIdentificacion;
    EditText txt_descripción;
    EditText txt_marca;
    EditText txt_modelo;
    EditText txt_placa;
    EditText txt_color;
    EditText txt_estado;
    EditText txt_tipo;
    EditText txt_anioFabricacion;
    EditText txt_serieMotor;
    EditText txt_serieChasis;
    EditText txt_combustible;
    EditText txt_numAsientos;
    EditText txt_numTarjetaPropiedad;
    EditText txt_razonSocial;


    ArrayList<String> cabecera;
    ArrayList<String> detalle;
    ArrayList<String> tabla;
    ArrayList<String> pie;

    public RegistroCabeceraDetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_registro_cabecera_detalle, container, false);

        Bundle bundle=this.getArguments();
        cabecera=bundle.getStringArrayList("cabecera");
        detalle=bundle.getStringArrayList("Detalle");
        tabla=bundle.getStringArrayList("Tabla");
        pie=bundle.getStringArrayList("Pie");


        txt_codigoAnterior=(EditText)view.findViewById(R.id.txt_codigoAnterior);
        txt_codigoIdentificacion=(EditText)view.findViewById(R.id.txt_codigoIdentificacion);
        txt_descripción=(EditText)view.findViewById(R.id.txt_descripción);
        txt_marca=(EditText)view.findViewById(R.id.txt_marca);
        txt_modelo=(EditText)view.findViewById(R.id.txt_modelo);
        txt_placa=(EditText)view.findViewById(R.id.txt_placa);
        txt_color=(EditText)view.findViewById(R.id.txt_color);
        txt_estado=(EditText)view.findViewById(R.id.txt_estado);
        txt_tipo=(EditText)view.findViewById(R.id.txt_tipo);
        txt_anioFabricacion=(EditText)view.findViewById(R.id.txt_anioFabricacion);
        txt_serieMotor=(EditText)view.findViewById(R.id.txt_serieMotor);
        txt_serieChasis=(EditText)view.findViewById(R.id.txt_serieChasis);
        txt_combustible=(EditText)view.findViewById(R.id.txt_combustible);
        txt_numAsientos=(EditText)view.findViewById(R.id.txt_numAsientos);
        txt_numTarjetaPropiedad=(EditText)view.findViewById(R.id.txt_numTarjetaPropiedad);
        txt_razonSocial=(EditText)view.findViewById(R.id.txt_razonSocial);


        if (detalle.get(0)!="0"){
            txt_codigoAnterior.setText(detalle.get(1));
            txt_codigoIdentificacion.setText(detalle.get(2));
            txt_descripción.setText(detalle.get(3));
            txt_marca.setText(detalle.get(4));
            txt_modelo.setText(detalle.get(5));
            txt_placa.setText(detalle.get(6));
            txt_color.setText(detalle.get(7));
            txt_estado.setText(detalle.get(8));
            txt_tipo.setText(detalle.get(9));
            txt_anioFabricacion.setText(detalle.get(10));
            txt_serieMotor.setText(detalle.get(11));
            txt_serieChasis.setText(detalle.get(12));
            txt_combustible.setText(detalle.get(13));
            txt_numAsientos.setText(detalle.get(14));
            txt_numTarjetaPropiedad.setText(detalle.get(15));
            txt_razonSocial.setText(detalle.get(16));
        }



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

        Bundle bundle=new Bundle();

        ArrayList<String> detalle=new ArrayList<String>();

        detalle.add("1");
        detalle.add(txt_codigoAnterior.getText().toString());
        detalle.add(txt_codigoIdentificacion.getText().toString());
        detalle.add(txt_descripción.getText().toString());
        detalle.add(txt_marca.getText().toString());
        detalle.add(txt_modelo.getText().toString());
        detalle.add(txt_placa.getText().toString());
        detalle.add(txt_color.getText().toString());
        detalle.add(txt_estado.getText().toString());
        detalle.add(txt_tipo.getText().toString());
        detalle.add(txt_anioFabricacion.getText().toString());
        detalle.add(txt_serieMotor.getText().toString());
        detalle.add(txt_serieChasis.getText().toString());
        detalle.add(txt_combustible.getText().toString());
        detalle.add(txt_numAsientos.getText().toString());
        detalle.add(txt_numTarjetaPropiedad.getText().toString());
        detalle.add(txt_razonSocial.getText().toString());

        bundle.putStringArrayList("cabecera",cabecera);
        bundle.putStringArrayList("Detalle",detalle);
        bundle.putStringArrayList("Tabla",tabla);
        bundle.putStringArrayList("Pie",pie);

        RegistroCabeceraFragment registroCabeceraFragment=new RegistroCabeceraFragment();
        registroCabeceraFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.container_form,registroCabeceraFragment).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }

    private void transicionFragmentSiguiente() {
        Bundle bundle=new Bundle();

        ArrayList<String> detalle=new ArrayList<String>();

        detalle.add("1");
        detalle.add(txt_codigoAnterior.getText().toString());
        detalle.add(txt_codigoIdentificacion.getText().toString());
        detalle.add(txt_descripción.getText().toString());
        detalle.add(txt_marca.getText().toString());
        detalle.add(txt_modelo.getText().toString());
        detalle.add(txt_placa.getText().toString());
        detalle.add(txt_color.getText().toString());
        detalle.add(txt_estado.getText().toString());
        detalle.add(txt_tipo.getText().toString());
        detalle.add(txt_anioFabricacion.getText().toString());
        detalle.add(txt_serieMotor.getText().toString());
        detalle.add(txt_serieChasis.getText().toString());
        detalle.add(txt_combustible.getText().toString());
        detalle.add(txt_numAsientos.getText().toString());
        detalle.add(txt_numTarjetaPropiedad.getText().toString());
        detalle.add(txt_razonSocial.getText().toString());

        bundle.putStringArrayList("cabecera",cabecera);
        bundle.putStringArrayList("Detalle",detalle);
        bundle.putStringArrayList("Tabla",tabla);
        bundle.putStringArrayList("Pie",pie);

        RegistroCabeceraDetalleTablaFragment registroCabeceraDetalleTablaFragment=new RegistroCabeceraDetalleTablaFragment();
        registroCabeceraDetalleTablaFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.container_form,registroCabeceraDetalleTablaFragment).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }
}
