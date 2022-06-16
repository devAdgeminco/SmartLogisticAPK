package com.adg.inventario.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.adg.inventario.Dao.daoUsuario;
import com.adg.inventario.Entitys.Usuario;
import com.adg.inventario.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class aUsuario extends BaseAdapter {
    ArrayList<Usuario> lista;
    daoUsuario dao;
    Usuario u;
    Activity a;

    public aUsuario(Activity a, ArrayList<Usuario> lista/*, daoUsuario dao*/){
        this.lista = lista;
        this.a = a;
        //this.dao=dao;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Usuario getItem(int i) {
        u=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        u=lista.get(i);
        return u.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v!=null){
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.usuario,null);
        }
        u=lista.get(i);

        TextView usuario = (TextView) v.findViewById(R.id.txtUsuario);
        TextView password = (TextView) v.findViewById(R.id.txtPassword);
        TextView nombres = (TextView) v.findViewById(R.id.txtNombres);
        TextView apellidos = (TextView) v.findViewById(R.id.txtApellidos);
        Button editar = (Button) v.findViewById(R.id.editar);
        Button eliminar = (Button) v.findViewById(R.id.eliminar);

        usuario.setText(u.getUsuario());
        password.setText(u.getClave());
        nombres.setText(u.getNombre());
        apellidos.setText(u.getApellidos());

        editar.setTag(i);
        eliminar.setTag(i);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return null;
    }


}
