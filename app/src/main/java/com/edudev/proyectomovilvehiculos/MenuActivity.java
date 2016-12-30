package com.edudev.proyectomovilvehiculos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    FloatingActionButton btn_agregar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
}
