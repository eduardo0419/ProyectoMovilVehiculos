package com.edudev.proyectomovilvehiculos.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edudev.proyectomovilvehiculos.Global;
import com.edudev.proyectomovilvehiculos.R;

public class MenuActivity extends AppCompatActivity {

    FloatingActionButton btn_agregar;
    Context context;

    LinearLayout container_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toast.makeText(this,"Bienvenido "+ Global.getNombreUsuarioFromShared(this,"nombre_p"),Toast.LENGTH_SHORT).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Inventario de vehiculos");
        setSupportActionBar(toolbar);

        container_buscar=(LinearLayout)findViewById(R.id.container_buscar);

        context=getApplicationContext();

        btn_agregar =(FloatingActionButton)findViewById(R.id.btn_agregar_registro);
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_search:
                visibilidadMenuBar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void visibilidadMenuBar() {
        if (container_buscar.getVisibility()==View.GONE){
            container_buscar.setVisibility(View.VISIBLE);
        }else{
            container_buscar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Global.clearUsuarioShared(this);
        }
        return super.onKeyDown(keyCode, event);
    }
}
