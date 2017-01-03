package com.edudev.proyectomovilvehiculos.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.ui.activity.RegistroActivity;
import com.weiwangcn.betterspinner.library.BetterSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroCabeceraDetalleTablaFragment extends Fragment implements View.OnClickListener {


    public RegistroCabeceraDetalleTablaFragment() {
        // Required empty public constructor
    }

    View view;
    FragmentManager fm;

    ArrayAdapter<String> adapter;

    TableLayout tableParteExterior;
    TableLayout tableParteInterior;
    TableLayout tableMotor;
    TableLayout tableHerramientas;
    TableLayout tableMateriales;

    TextView tituloParteExterior;
    TextView tituloParteInterior;
    TextView tituloTablaMotor;
    TextView tituloTablaHerramientas;
    TextView tituloTablaMateriales;

    Button btn_siguiente_tabla;
    Button btn_atras_tabla;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registro_cabecera_detalle_tabla, container, false);

        fm=getActivity().getSupportFragmentManager();

        btn_siguiente_tabla=(Button)view.findViewById(R.id.btn_tabla_siguiente);
        btn_atras_tabla=(Button)view.findViewById(R.id.btn_tabla_atras);

        tituloParteExterior=(TextView)view.findViewById(R.id.text_tabla1);
        tituloParteInterior=(TextView)view.findViewById(R.id.text_tabla2);
        tituloTablaMotor=(TextView)view.findViewById(R.id.text_tabla3);
        tituloTablaHerramientas=(TextView)view.findViewById(R.id.text_tabla4);
        tituloTablaMateriales=(TextView)view.findViewById(R.id.text_tabla5);

        btn_siguiente_tabla.setOnClickListener(this);
        btn_atras_tabla.setOnClickListener(this);

        String[] opciones = getResources().getStringArray(R.array.array_opciones_tablas);

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, opciones);

        tableParteExterior = (TableLayout) view.findViewById(R.id.tabla_parteExterior);
        tableParteInterior = (TableLayout) view.findViewById(R.id.tabla_parteInterior);
        tableMotor =(TableLayout)view.findViewById(R.id.tabla_motor);
        tableHerramientas=(TableLayout)view.findViewById(R.id.tabla_herramientas);
        tableMateriales=(TableLayout)view.findViewById(R.id.tabla_materiales);

        cargarTablaParteExterna();
        cargarTablaParteInterna();
        cargarTablaMotor();
        cargarTablaHerramientas();
        cargarTablaMateriales();


        tituloParteInterior.setVisibility(View.GONE);
        tableParteInterior.setVisibility(View.GONE);

        tituloTablaMotor.setVisibility(View.GONE);
        tableMotor.setVisibility(View.GONE);

        tituloTablaHerramientas.setVisibility(View.GONE);
        tableHerramientas.setVisibility(View.GONE);

        tituloTablaMateriales.setVisibility(View.GONE);
        tableMateriales.setVisibility(View.GONE);

        ((RegistroActivity)getActivity()).posicionarScroll();
        return view;
    }

    public void cargarTablaParteExterna(){
        String[] parteExterna = getResources().getStringArray(R.array.array_parteExterna);

        TableRow cabecera = (TableRow) LayoutInflater.from(getContext()).inflate(R.layout.cabecera_tabla, null);
        tableParteExterior.addView(cabecera);

        for (int i=0;i<parteExterna.length;i++) {

            TableRow fila  = (TableRow)LayoutInflater.from(getContext()).inflate(R.layout.fila_tabla, null);

            EditText input_descrip=(EditText)fila.findViewById(R.id.txt_descri_tabla);
            input_descrip.setText(parteExterna[i]);

            BetterSpinner spinner = (BetterSpinner)fila.findViewById(R.id.spiner_tipo);
            spinner.setAdapter(adapter);

            tableParteExterior.addView(fila);
        }
        tableParteExterior.requestLayout();

    }

    public void cargarTablaParteInterna(){
        String[] parteinterna = getResources().getStringArray(R.array.array_parteInterna);

        TableRow cabecera = (TableRow) LayoutInflater.from(getContext()).inflate(R.layout.cabecera_tabla, null);
        ((EditText)cabecera.findViewById(R.id.txt_titulo_tabla)).setText("PARTE INTERIOR");
        tableParteInterior.addView(cabecera);

        for (int i=0;i<parteinterna.length;i++) {

            TableRow fila  = (TableRow)LayoutInflater.from(getContext()).inflate(R.layout.fila_tabla, null);

            EditText input_descrip=(EditText)fila.findViewById(R.id.txt_descri_tabla);
            input_descrip.setText(parteinterna[i]);


            BetterSpinner spinner = (BetterSpinner)fila.findViewById(R.id.spiner_tipo);
            spinner.setAdapter(adapter);

            tableParteInterior.addView(fila);
        }
        tableParteInterior.requestLayout();

    }

    public void cargarTablaMotor(){
        String[] motor = getResources().getStringArray(R.array.array_motor);

        TableRow cabecera = (TableRow) LayoutInflater.from(getContext()).inflate(R.layout.cabecera_tabla, null);
        ((EditText)cabecera.findViewById(R.id.txt_titulo_tabla)).setText("MOTOR");
        tableMotor.addView(cabecera);

        for (int i=0;i<motor.length;i++) {

            TableRow fila  = (TableRow)LayoutInflater.from(getContext()).inflate(R.layout.fila_tabla, null);

            EditText input_descrip=(EditText)fila.findViewById(R.id.txt_descri_tabla);
            input_descrip.setText(motor[i]);


            BetterSpinner spinner = (BetterSpinner)fila.findViewById(R.id.spiner_tipo);
            spinner.setAdapter(adapter);

            tableMotor.addView(fila);
        }
        tableMotor.requestLayout();
    }

    public void cargarTablaHerramientas(){
        String[] herramientas = getResources().getStringArray(R.array.array_herramientas);

        TableRow cabecera = (TableRow) LayoutInflater.from(getContext()).inflate(R.layout.cabecera_tabla, null);
        ((EditText)cabecera.findViewById(R.id.txt_titulo_tabla)).setText("HERRAMIENTAS");
        tableHerramientas.addView(cabecera);

        for (int i=0;i<herramientas.length;i++) {

            TableRow fila  = (TableRow)LayoutInflater.from(getContext()).inflate(R.layout.fila_tabla, null);

            EditText input_descrip=(EditText)fila.findViewById(R.id.txt_descri_tabla);
            input_descrip.setText(herramientas[i]);


            BetterSpinner spinner = (BetterSpinner)fila.findViewById(R.id.spiner_tipo);
            spinner.setAdapter(adapter);

            tableHerramientas.addView(fila);
        }
        tableHerramientas.requestLayout();
    }

    public void cargarTablaMateriales(){
        String[] materiales = getResources().getStringArray(R.array.array_materiales);

        TableRow cabecera = (TableRow) LayoutInflater.from(getContext()).inflate(R.layout.cabecera_tabla, null);
        ((EditText)cabecera.findViewById(R.id.txt_titulo_tabla)).setText("MATERIALES");
        tableMateriales.addView(cabecera);

        for (int i=0;i<materiales.length;i++) {

            TableRow fila  = (TableRow)LayoutInflater.from(getContext()).inflate(R.layout.fila_tabla, null);

            EditText input_descrip=(EditText)fila.findViewById(R.id.txt_descri_tabla);
            input_descrip.setText(materiales[i]);

            BetterSpinner spinner = (BetterSpinner)fila.findViewById(R.id.spiner_tipo);
            spinner.setAdapter(adapter);

            tableMateriales.addView(fila);
        }
        tableMateriales.requestLayout();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tabla_siguiente:
                cambiarTablaSiguiente();
                ((RegistroActivity)getActivity()).posicionarScroll();
                break;
            case R.id.btn_tabla_atras:
                cambiarTablaAtras();
                ((RegistroActivity)getActivity()).posicionarScroll();
                break;
        }
    }

    private void cambiarTablaSiguiente() {
        if (tableMateriales.getVisibility()==View.VISIBLE) {
            fm=getActivity().getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.container_form,new RegistroPieDetalleFragment()).commit();

        }

        if (tableHerramientas.getVisibility()==View.VISIBLE){
            tituloTablaHerramientas.setVisibility(View.GONE);
            tableHerramientas.setVisibility(View.GONE);

            tituloTablaMateriales.setVisibility(View.VISIBLE);
            tableMateriales.setVisibility(View.VISIBLE);
        }

        if(tableMotor.getVisibility()==View.VISIBLE){
            tituloTablaMotor.setVisibility(View.GONE);
            tableMotor.setVisibility(View.GONE);

            tituloTablaHerramientas.setVisibility(View.VISIBLE);
            tableHerramientas.setVisibility(View.VISIBLE);
        }

        if (tableParteInterior.getVisibility()==View.VISIBLE){
            tituloParteInterior.setVisibility(View.GONE);
            tableParteInterior.setVisibility(View.GONE);

            tituloTablaMotor.setVisibility(View.VISIBLE);
            tableMotor.setVisibility(View.VISIBLE);
        }

        if(tableParteExterior.getVisibility()==View.VISIBLE){
            tituloParteExterior.setVisibility(View.GONE);
            tableParteExterior.setVisibility(View.GONE);

            tituloParteInterior.setVisibility(View.VISIBLE);
            tableParteInterior.setVisibility(View.VISIBLE);
        }
    }

    private void cambiarTablaAtras(){
        if (tableParteExterior.getVisibility()==View.VISIBLE){
            FragmentManager fm=getActivity().getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleFragment()).commit();

        }

        if (tableParteInterior.getVisibility()==View.VISIBLE){
            tituloParteInterior.setVisibility(View.GONE);
            tableParteInterior.setVisibility(View.GONE);

            tituloParteExterior.setVisibility(View.VISIBLE);
            tableParteExterior.setVisibility(View.VISIBLE);

        }

        if (tableMotor.getVisibility()==View.VISIBLE){
            tituloTablaMotor.setVisibility(View.GONE);
            tableMotor.setVisibility(View.GONE);

            tituloParteInterior.setVisibility(View.VISIBLE);
            tableParteInterior.setVisibility(View.VISIBLE);
        }

        if (tableHerramientas.getVisibility()==View.VISIBLE){
            tituloTablaHerramientas.setVisibility(View.GONE);
            tableHerramientas.setVisibility(View.GONE);

            tituloTablaMotor.setVisibility(View.VISIBLE);
            tableMotor.setVisibility(View.VISIBLE);
        }

        if (tableMateriales.getVisibility()==View.VISIBLE){
            tituloTablaMateriales.setVisibility(View.GONE);
            tableMateriales.setVisibility(View.GONE);

            tituloTablaHerramientas.setVisibility(View.VISIBLE);
            tableHerramientas.setVisibility(View.VISIBLE);
        }

    }
}
