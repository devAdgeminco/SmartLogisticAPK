package com.adg.inventario.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.adg.inventario.Entitys.ArticulosAlmacen;
import com.cdp.agenda.entidades.Contactos;

import java.util.ArrayList;

public class DbInventario extends DbHelper {

    Context context;

    public DbInventario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarInventario(String descripcion, String fecha, String almacen) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("descripcion", descripcion);
            values.put("fecha", fecha);
            values.put("almacen", almacen);

            id = db.insert(TABLE_INVENTARIO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<ArticulosAlmacen> mostrarInventarioDetalle() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<ArticulosAlmacen> listaArticulos = new ArrayList<>();
        ArticulosAlmacen articulos;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_INVENTARIO + " ORDER BY nombre ASC", null);

        if (cursorContactos.moveToFirst()) {
            do {
                articulos = new ArticulosAlmacen();
                articulos.setId(cursorContactos.getInt(0));
                articulos.setCodigo(cursorContactos.getString(1));
                articulos.setDescripcion(cursorContactos.getString(2));
                articulos.set(cursorContactos.getString(3));
                listaArticulos.add(articulos);
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();

        return listaArticulos;
    }

    public Contactos verContacto(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Contactos contacto = null;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorContactos.moveToFirst()) {
            contacto = new Contactos();
            contacto.setId(cursorContactos.getInt(0));
            contacto.setNombre(cursorContactos.getString(1));
            contacto.setTelefono(cursorContactos.getString(2));
            contacto.setCorreo_electornico(cursorContactos.getString(3));
        }

        cursorContactos.close();

        return contacto;
    }

    public boolean editarContacto(int id, String nombre, String telefono, String correo_electronico) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_CONTACTOS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', correo_electronico = '" + correo_electronico + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarContacto(int id) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_CONTACTOS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
}
