package com.adg.inventario.Views.Usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.adg.inventario.Adapter.aAdapter;
import com.adg.inventario.Adapter.aUsuario;
import com.adg.inventario.Dao.daoUsuario;
import com.adg.inventario.Entitys.Usuario;
import com.adg.inventario.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListUsuario extends AppCompatActivity {
    daoUsuario dao;
    aUsuario adapter;
    ArrayList<Usuario> lista=null;
    Usuario u;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_usuario);
        list = (ListView) findViewById(R.id.listUsuarios);
        /*dao=new daoUsuario(this);
        lista=dao.shows();
        adapter=new aUsuario(this,lista,dao);



        Button agregar = (Button) findViewById(R.id.btnAgregar);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Dialogo para ver lista previo de registro
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Dialogo de agregar
                Dialog dialogo = new Dialog(ListUsuario.this);
                dialogo.setTitle("Nuevo Registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.usuario);
                dialogo.show();

                EditText nombres=(EditText) dialogo.findViewById(R.id.txtNombres);
                EditText apellidos=(EditText) dialogo.findViewById(R.id.txtApellidos);
                EditText usuario=(EditText) dialogo.findViewById(R.id.txtUsuario);
                EditText clave=(EditText) dialogo.findViewById(R.id.txtPassword);

                Button guardar=(Button) dialogo.findViewById(R.id.btnAgregar);
                Button cancelar=(Button) dialogo.findViewById(R.id.btnCancelar);

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            u=new Usuario(nombres.getText().toString(),
                                        apellidos.getText().toString(),
                                        usuario.getText().toString(),
                                        clave.getText().toString()
                                    );

                            dao.insert(u);
                            adapter.notifyDataSetChanged();
                            dialogo.dismiss();

                        }catch (Exception e){
                            Toast.makeText(getApplication(),"ERROR",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogo.dismiss();
                    }
                });
            }
        });*/
    }

    public void CargarDatos(View view) throws IOException {
        ArrayList<Usuario> listString = new ArrayList<Usuario>();
        String linea;
        InputStream is = this.getResources().openRawResource(R.raw.usuarios);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is!=null){
            while ((linea=reader.readLine())!=null){
                Usuario u = new Usuario();
                u.setId(Integer.parseInt(linea.split(";")[0]));
                u.setUsuario(linea.split(";")[1]);
                u.setClave(linea.split(";")[2]);
                u.setNombre(linea.split(";")[3]);
                u.setApellidos(linea.split(";")[4]);

                listString.add(u);
            }
        }
        is.close();
        Toast.makeText(this,"Carga:"+listString.size(),Toast.LENGTH_LONG).show();

        aAdapter adapter=new aAdapter(this,listString);

        list.setAdapter(adapter);
    }
}