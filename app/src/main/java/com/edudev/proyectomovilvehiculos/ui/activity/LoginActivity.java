package com.edudev.proyectomovilvehiculos.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edudev.proyectomovilvehiculos.Global;
import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.io.RegistroVehicularApiAdapter;
import com.edudev.proyectomovilvehiculos.io.response.SessionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Callback<SessionResponse> {

    Button btn_login,btn_soporte;
    EditText txt_usuario,txt_clave;
    ProgressDialog progressDialog;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context=this;

        txt_usuario=(EditText)findViewById(R.id.txt_usuario);
        txt_clave=(EditText)findViewById(R.id.txt_password);

        btn_login=(Button)findViewById(R.id.btn_login);
        btn_soporte=(Button)findViewById(R.id.btn_soporte);

        btn_login.setOnClickListener(this);
        btn_soporte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_soporte:
                break;
        }
    }

    private void login() {
        progressDialog=ProgressDialog.show(context,"Autentificando","Espere por favor...");
        Call<SessionResponse> call= RegistroVehicularApiAdapter.getApiService().getLogin(txt_usuario.getText().toString(),txt_clave.getText().toString());
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
        if (response.isSuccessful()) {
            SessionResponse sessionResponse= response.body();
            if(!sessionResponse.isError()){
                Global.setUsuarioShared(this,"id_usuario",sessionResponse.getDni());
                Global.setNombreUsuarioShared(this,"nombre_p",sessionResponse.getNombre());
                progressDialog.dismiss();
                Intent intent1=new Intent(this,MenuActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            }else{
                progressDialog.dismiss();
                Toast.makeText(this,"Usuario y/o contraseña incorrecta",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onFailure(Call<SessionResponse> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(this,"No hay conexion con el servidor",Toast.LENGTH_LONG).show();
    }
}
