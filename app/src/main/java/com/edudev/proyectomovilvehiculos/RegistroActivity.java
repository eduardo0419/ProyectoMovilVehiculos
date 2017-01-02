package com.edudev.proyectomovilvehiculos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fm;

    ScrollView scrollView;

    Button btn_siguiente;
    Button btn_atras;
    Button btn_grabar;

    LinearLayout controlPrincipal;

    AlertDialog alert = null;
    Activity activi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        activi=this;
        scrollView=(ScrollView)findViewById(R.id.scrollRegistro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_regitro);
        toolbar.setTitle("Nuevo registro de automovil");
        setSupportActionBar(toolbar);

        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraFragment()).commit();

        controlPrincipal =(LinearLayout)findViewById(R.id.control_principal);

        btn_siguiente=(Button)findViewById(R.id.btn_siguiente);
        btn_atras=(Button)findViewById(R.id.btn_atras);
        btn_grabar=(Button)findViewById(R.id.btn_grabar);

        btn_siguiente.setOnClickListener(this);
        btn_atras.setOnClickListener(this);
        btn_grabar.setOnClickListener(this);

        btn_atras.setVisibility(View.INVISIBLE);
        posicionarScroll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.clear_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_clear:
                cancelarRegistro();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void cancelarRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activi);
        builder.setMessage("Desea cancelar el registro del automovil?")
                .setCancelable(false)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent intent = new Intent(activi, MenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        alert = builder.create();
        alert.show();
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
            btn_atras.setVisibility(View.VISIBLE);
        }
    }

    public void transicionFragmentAtras(){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_form);
        if (currentFragment.getClass().getName()== RegistroCabeceraDetalleFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraFragment()).commit();
            btn_atras.setVisibility(View.INVISIBLE);
        }
        if (currentFragment.getClass().getName()== RegistroCabeceraDetalleTablaFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleFragment()).commit();
            encenderControlPrincipal();
        }
        if (currentFragment.getClass().getName()== RegistroPieDetalleFragment.class.getName()) {
            fm.beginTransaction().replace(R.id.container_form,new RegistroCabeceraDetalleTablaFragment()).commit();
            apagarControlPrincipal();
            apagarBotonGrabar();
        }

    }

    public void apagarControlPrincipal(){
        controlPrincipal.setVisibility(View.GONE);
    }

    public void encenderControlPrincipal(){
        controlPrincipal.setVisibility(View.VISIBLE);
    }

    public void posicionarScroll(){
        scrollView.scrollTo(0,0);
    }

    public void encenderBotonGrabar(){
        btn_grabar.setVisibility(View.VISIBLE);
        btn_siguiente.setVisibility(View.GONE);
    }

    public void apagarBotonGrabar(){
        btn_grabar.setVisibility(View.GONE);
        btn_siguiente.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            cancelarRegistro();
        }
        return super.onKeyDown(keyCode, event);
    }
}
