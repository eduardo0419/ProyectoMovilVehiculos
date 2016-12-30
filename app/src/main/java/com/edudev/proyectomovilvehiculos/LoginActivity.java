package com.edudev.proyectomovilvehiculos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login,btn_soporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        Intent intent =new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}
