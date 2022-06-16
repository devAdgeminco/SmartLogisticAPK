package com.adg.inventario.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adg.inventario.Entitys.Usuario;
import com.adg.inventario.R;

import java.util.ArrayList;


public class aAdapter extends ArrayAdapter<Usuario> {
    public aAdapter(Context context, ArrayList<Usuario> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Usuario user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_usuario, parent, false);
        }
        // Lookup view for data population
        TextView usuario = (TextView) convertView.findViewById(R.id.txtUsuario);
        TextView pswd = (TextView) convertView.findViewById(R.id.txtPassword);
        TextView nombre = (TextView) convertView.findViewById(R.id.txtNombres);
        TextView apellidos = (TextView) convertView.findViewById(R.id.txtApellidos);
        // Populate the data into the template view using the data object
        usuario.setText(user.getUsuario());
        pswd.setText(user.getClave());
        nombre.setText(user.getNombre());
        apellidos.setText(user.getApellidos());
        // Return the completed view to render on screen
        return convertView;
    }
}