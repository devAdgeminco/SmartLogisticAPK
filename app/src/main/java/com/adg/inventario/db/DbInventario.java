package com.adg.inventario.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.adg.inventario.Entitys.ArticulosAlmacen;
import com.adg.inventario.Entitys.Inventario;
import com.adg.inventario.Entitys.InventarioDetalle;

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

    public ArrayList<Inventario> mostrarInventario() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Inventario> listaInventario = new ArrayList<Inventario>();
        Inventario inventario;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_INVENTARIO, null);

        if (cursor.moveToFirst()) {
            do {
                inventario = new Inventario();
                inventario.setId(cursor.getInt(0));
                inventario.setDescripcion(cursor.getString(1));
                inventario.setFecha(cursor.getString(2));
                inventario.setAlmacen(cursor.getString(3));
                listaInventario.add(inventario);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return listaInventario;
    }

    public ArrayList<InventarioDetalle> mostrarInventarioDetalle(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<InventarioDetalle> listaInventarioDetalle = new ArrayList<InventarioDetalle>();
        InventarioDetalle inventarioDetalle;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_INVENTARIO_DETALLE + " WHERE idInventario=" + id, null);

        if (cursor.moveToFirst()) {
            do {
                inventarioDetalle = new InventarioDetalle();
                inventarioDetalle.setId(cursor.getInt(0));
                inventarioDetalle.setIdInventario(cursor.getInt(1));
                inventarioDetalle.setCodigoProducto(cursor.getString(2));
                inventarioDetalle.setDescProducto(cursor.getString(3));
                inventarioDetalle.setSustento(cursor.getString(4));
                inventarioDetalle.setCantidadAlmacen(cursor.getInt(5));
                inventarioDetalle.setCantidadInventario(cursor.getInt(6));

                listaInventarioDetalle.add(inventarioDetalle);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return listaInventarioDetalle;
    }

    public ArrayList<ArticulosAlmacen> mostrarArticulos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<ArticulosAlmacen> listaArticulos = new ArrayList<ArticulosAlmacen>();
        ArticulosAlmacen articulos;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_ARTICULOS, null);

        if (cursor.moveToFirst()) {
            do {
                articulos = new ArticulosAlmacen();
                articulos.setId(cursor.getInt(0));
                articulos.setCodigo(cursor.getString(1));
                articulos.setDescripcion(cursor.getString(2));
                articulos.setAlmacen(cursor.getString(3));
                articulos.setCantidad(cursor.getInt(3));
                listaArticulos.add(articulos);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return listaArticulos;
    }

    public ArticulosAlmacen verArticulo(String cogido) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArticulosAlmacen articuloAlmacen = null;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_ARTICULOS + " WHERE codigo = '" + cogido + "' LIMIT 1", null);

        if (cursor.moveToFirst()) {
            articuloAlmacen = new ArticulosAlmacen();
            articuloAlmacen.setId(cursor.getInt(0));
            articuloAlmacen.setCodigo(cursor.getString(1));
            articuloAlmacen.setDescripcion(cursor.getString(2));
            articuloAlmacen.setAlmacen(cursor.getString(3));
            articuloAlmacen.setCantidad(cursor.getInt(4));
        }

        cursor.close();

        return articuloAlmacen;
    }

    public boolean editarCantidadInventarioDetalle(int id, int cantidad) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_INVENTARIO_DETALLE + " SET cantidad = " + cantidad + " WHERE id='" + id + "' ");
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
