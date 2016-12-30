package com.edudev.proyectomovilvehiculos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fm;

    Button btn_siguiente;
    Button btn_atras;

    LinearLayout controlPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        

        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraFragment()).commit();

        controlPrincipal =(LinearLayout)findViewById(R.id.control_principal);

        btn_siguiente=(Button)findViewById(R.id.btn_siguiente);
        btn_atras=(Button)findViewById(R.id.btn_atras);


        btn_siguiente.setOnClickListener(this);
        btn_atras.setOnClickListener(this);

        btn_atras.setEnabled(false);
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

    public void transicionFragmentSiguiente() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_form);

        if (currentFragment.getClass().getName()== RegistroCabeceraDetalleFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleTablaFragment()).commit();
            apagarControlPrincipal();
        }
        if (currentFragment.getClass().getName()== RegistroCabeceraFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleFragment()).commit();
            btn_atras.setEnabled(true);
        }
    }

    public void transicionFragmentAtras(){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_form);
        if (currentFragment.getClass().getName()== RegistroCabeceraDetalleFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraFragment()).commit();
            btn_atras.setEnabled(false);
        }
        if (currentFragment.getClass().getName()== RegistroCabeceraDetalleTablaFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleFragment()).commit();
            encenderControlPrincipal();
        }
    }

    public void apagarControlPrincipal(){
        controlPrincipal.setVisibility(View.GONE);
    }

    public void encenderControlPrincipal(){
        controlPrincipal.setVisibility(View.VISIBLE);
    }

}
