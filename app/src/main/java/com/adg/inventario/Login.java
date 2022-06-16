package com.adg.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adg.inventario.Views.Inventario.Administrador.Administracion;
import com.adg.inventario.Views.Inventario.Inventarista.Menu;
import com.adg.inventario.Views.Usuario.ListUsuario;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText user =(EditText)findViewById(R.id.txtUsuarioLogin);
        EditText pswd =(EditText)findViewById(R.id.txtClaveLogin);

        Button btnLogin=(Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.getText().toString().equals("admin")){
                    Intent i =new Intent(Login.this, Administracion.class);
                    startActivity(i);
                }
                if (user.getText().toString().equals("logistica")){
                    Intent i =new Intent(Login.this, Menu.class);
                    startActivity(i);
                }
                if (user.getText().toString().equals("contabilidad")){
                    Intent i =new Intent(Login.this, com.adg.inventario.Views.Inventario.Contabilidad.Menu.class);
                    startActivity(i);
                }

            }
        });

    }
}