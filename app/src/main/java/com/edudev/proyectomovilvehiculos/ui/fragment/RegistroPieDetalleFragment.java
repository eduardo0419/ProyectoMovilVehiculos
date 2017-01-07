package com.edudev.proyectomovilvehiculos.ui.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edudev.proyectomovilvehiculos.Global;
import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.io.RegistroVehicularApiAdapter;
import com.edudev.proyectomovilvehiculos.io.response.RegistroResponse;
import com.edudev.proyectomovilvehiculos.ui.activity.MenuActivity;
import com.edudev.proyectomovilvehiculos.ui.activity.RegistroActivity;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistroPieDetalleFragment extends Fragment implements View.OnClickListener, Callback<RegistroResponse> {


    View view;
    FragmentManager fm;

    Button btn_atras;
    Button btn_grabar;

    EditText txt_pie_cod_patronato;
    EditText txt_pie_modelo;
    EditText txt_pie_radio_base;
    EditText txt_pie_soat;
    EditText txt_pie_vigencia;
    EditText txt_pie_cia_seguros;
    EditText txt_pie_polizas;
    EditText txt_pie_rev_tecnica;
    EditText txt_pie_observacion;

    ArrayList<String> cabecera;
    ArrayList<String> detalle;
    ArrayList<String> tabla;
    ArrayList<String> pie;

    MaterialBetterSpinner materialBetterSpinner;
   ProgressDialog progressDialog=null;
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

         txt_pie_cod_patronato=(EditText)view.findViewById(R.id.txt_pie_cod_patronato);
         txt_pie_modelo=(EditText)view.findViewById(R.id.txt_pie_modelo);
         txt_pie_radio_base=(EditText)view.findViewById(R.id.txt_pie_radio_base);
         txt_pie_soat=(EditText)view.findViewById(R.id.txt_pie_soat);
         txt_pie_vigencia=(EditText)view.findViewById(R.id.txt_pie_vigencia);
         txt_pie_cia_seguros=(EditText)view.findViewById(R.id.txt_pie_cia_seguros);
         txt_pie_polizas=(EditText)view.findViewById(R.id.txt_pie_polizas);
         txt_pie_rev_tecnica=(EditText)view.findViewById(R.id.txt_pie_rev_tecnica);
         txt_pie_observacion=(EditText)view.findViewById(R.id.txt_pie_observacion);

        Bundle bundle = this.getArguments();

        cabecera=bundle.getStringArrayList("cabecera");
        detalle=bundle.getStringArrayList("Detalle");
        tabla=bundle.getStringArrayList("Tabla");
        pie=bundle.getStringArrayList("Pie");

        if (pie.get(0)!="0"){
            txt_pie_cod_patronato.setText(pie.get(1));
            txt_pie_modelo.setText(pie.get(2));
            txt_pie_radio_base.setText(pie.get(3));
            txt_pie_soat.setText(pie.get(4));
            txt_pie_vigencia.setText(pie.get(5));
            txt_pie_cia_seguros.setText(pie.get(6));
            txt_pie_polizas.setText(pie.get(7));
            txt_pie_rev_tecnica.setText(pie.get(8));
            txt_pie_observacion.setText(pie.get(10));
            materialBetterSpinner.setText(pie.get(9));
        }

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
            case R.id.btn_grabar:
                registrar();
                break;
            case R.id.btn_atras:
                transicionFragmentAtras();
                break;
        }
    }

    private void transicionFragmentAtras() {
        Bundle bundle=new Bundle();
        ArrayList<String> pie=new ArrayList<String>();

        pie.add("1");
        pie.add(txt_pie_cod_patronato.getText().toString());
        pie.add(txt_pie_modelo.getText().toString());
        pie.add(txt_pie_radio_base.getText().toString());
        pie.add(txt_pie_soat.getText().toString());
        pie.add(txt_pie_vigencia.getText().toString());
        pie.add(txt_pie_cia_seguros.getText().toString());
        pie.add(txt_pie_polizas.getText().toString());
        pie.add(txt_pie_rev_tecnica.getText().toString());
        pie.add(materialBetterSpinner.getText().toString());
        pie.add(txt_pie_observacion.getText().toString());


        bundle.putStringArrayList("cabecera",cabecera);
        bundle.putStringArrayList("Detalle",detalle);
        bundle.putStringArrayList("Tabla",tabla);
        bundle.putStringArrayList("Pie",pie);

        RegistroCabeceraDetalleTablaFragment registroCabeceraDetalleTablaFragment=new RegistroCabeceraDetalleTablaFragment();
        registroCabeceraDetalleTablaFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.container_form,registroCabeceraDetalleTablaFragment).commit();
        ((RegistroActivity)getActivity()).posicionarScroll();
    }

    private void registrar(){
        ArrayList<String> pies=new ArrayList<String>();

        pies.add(txt_pie_cod_patronato.getText().toString());
        pies.add(txt_pie_modelo.getText().toString());
        pies.add(txt_pie_radio_base.getText().toString());
        pies.add(txt_pie_soat.getText().toString());
        pies.add(txt_pie_vigencia.getText().toString());
        pies.add(txt_pie_cia_seguros.getText().toString());
        pies.add(txt_pie_polizas.getText().toString());
        pies.add(txt_pie_rev_tecnica.getText().toString());
        pies.add(materialBetterSpinner.getText().toString());
        pies.add(txt_pie_observacion.getText().toString());


        progressDialog= ProgressDialog.show(getContext(),"Registrando","Espere por favor...");
        Call<RegistroResponse> call= RegistroVehicularApiAdapter.getApiService().setRegistro(cabecera,detalle,tabla,pies, Global.getUsuarioFromShared(getActivity(),"id_usuario"));
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
        if (response.isSuccessful()) {
            RegistroResponse registroResponse= response.body();
            if(!registroResponse.isError()){
                progressDialog.dismiss();
                Intent intent1=new Intent(getContext(),MenuActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            }else{
                progressDialog.dismiss();
                Toast.makeText(getContext(),"Error de envio del registro",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onFailure(Call<RegistroResponse> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(getContext(),"Error de conexion",Toast.LENGTH_LONG).show();
    }
}
