package com.edudev.proyectomovilvehiculos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.BetterSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroCabeceraDetalleTablaFragment extends Fragment implements View.OnClickListener {


    public RegistroCabeceraDetalleTablaFragment() {
        // Required empty public constructor
    }

    View view;

    ArrayAdapter<String> adapter;

    TableLayout tableParteExterior;
    TableLayout tableParteInterior;

    TextView tituloParteExterior;
    TextView tituloParteInterior;

    Button btn_siguiente_tabla;
    Button btn_atras_tabla;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registro_cabecera_detalle_tabla, container, false);

        btn_siguiente_tabla=(Button)view.findViewById(R.id.btn_tabla_siguiente);
        btn_atras_tabla=(Button)view.findViewById(R.id.btn_tabla_atras);

        tituloParteExterior=(TextView)view.findViewById(R.id.text_tabla1);
        tituloParteInterior=(TextView)view.findViewById(R.id.text_tabla2);


        btn_siguiente_tabla.setOnClickListener(this);
        btn_atras_tabla.setOnClickListener(this);

        String[] opciones = getResources().getStringArray(R.array.array_opciones_tablas);

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, opciones);

        tableParteExterior = (TableLayout) view.findViewById(R.id.tabla_parteExterior);
        tableParteInterior = (TableLayout) view.findViewById(R.id.tabla_parteInterior);

        cargarTablaParteExterna();
        cargarTablaParteInterna();


        tituloParteInterior.setVisibility(View.GONE);
        tableParteInterior.setVisibility(View.GONE);




        btn_atras_tabla.setEnabled(false);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tabla_siguiente:
                cambiarTablaSiguiente();
                break;
            case R.id.btn_tabla_atras:
                cambiarTablaAtras();
                break;
        }
    }

    private void cambiarTablaSiguiente() {
        if(tableParteExterior.getVisibility()==View.VISIBLE){
            tituloParteExterior.setVisibility(View.GONE);
            tableParteExterior.setVisibility(View.GONE);

            tituloParteInterior.setVisibility(View.VISIBLE);
            tableParteInterior.setVisibility(View.VISIBLE);

            btn_atras_tabla.setEnabled(true);
        }
    }

    private void cambiarTablaAtras(){
        if (tableParteInterior.getVisibility()==View.VISIBLE){
            tituloParteInterior.setVisibility(View.GONE);
            tableParteInterior.setVisibility(View.GONE);

            tituloParteExterior.setVisibility(View.VISIBLE);
            tableParteExterior.setVisibility(View.VISIBLE);

            btn_atras_tabla.setEnabled(false);
        }
    }
}
