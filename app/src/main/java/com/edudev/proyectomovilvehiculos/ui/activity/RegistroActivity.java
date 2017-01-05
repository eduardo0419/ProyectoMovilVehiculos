package com.edudev.proyectomovilvehiculos.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.ui.fragment.RegistroCabeceraFragment;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    FragmentManager fm;

    ScrollView scrollView;

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

        ArrayList<String> array=new ArrayList<>();
        array.add("0");

        Bundle bundle=new Bundle();
        bundle.putStringArrayList("cabecera",array);
        bundle.putStringArrayList("Detalle",array);
        bundle.putStringArrayList("Tabla",array);
        bundle.putStringArrayList("Pie",array);

        RegistroCabeceraFragment registroCabeceraFragment=new RegistroCabeceraFragment();
        registroCabeceraFragment.setArguments(bundle);

        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container_form,registroCabeceraFragment).commit();

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
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent intent = new Intent(activi, MenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        alert = builder.create();
        alert.show();
    }




    public void posicionarScroll(){
        scrollView.scrollTo(0,0);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            cancelarRegistro();
        }
        return super.onKeyDown(keyCode, event);
    }
}
