package com.edudev.proyectomovilvehiculos.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edudev.proyectomovilvehiculos.Global;
import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.io.RegistroVehicularApiAdapter;
import com.edudev.proyectomovilvehiculos.io.response.ListarResponse;
import com.edudev.proyectomovilvehiculos.ui.adapter.AdapterRegistro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements Callback<ListarResponse> {

    FloatingActionButton btn_agregar;
    Context context;

    LinearLayout container_buscar;
    ProgressDialog progressDialog=null;
    RecyclerView recyclerView;
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

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        llamarRegistros();
    }

    private void llamarRegistros() {
        progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Cargando registros");
        progressDialog.show();
        Call<ListarResponse> call= RegistroVehicularApiAdapter.getApiService().getListar(Global.getUsuarioFromShared(this,"id_usuario"));
        call.enqueue(this);
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

    @Override
    public void onResponse(Call<ListarResponse> call, Response<ListarResponse> response) {
        if (response.isSuccessful()) {
            ListarResponse listar= response.body();
            if(!listar.getRegistros().get(0).isError()){

                progressDialog.dismiss();
                AdapterRegistro adap=new AdapterRegistro(listar.getRegistros(),context);
                recyclerView.setAdapter(adap);

            }else{
                progressDialog.dismiss();
                Toast.makeText(this,"No existen registros de vehiculos",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onFailure(Call<ListarResponse> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(this,"Error de conexion",Toast.LENGTH_SHORT).show();
    }
}
