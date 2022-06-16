package com.adg.inventario.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adg.inventario.Entitys.Usuario;

import java.util.ArrayList;

public class daoUsuario {
    SQLiteDatabase cx;
    ArrayList<Usuario> lista=null;

    Usuario u;
    Context ct;
    String nombreBD = "BDInventario.db";
    String tabla = "create table if not exists usuario(id integer primary key autoincrement, usuario text, clave text,nombre text, apellidos text)";


    public daoUsuario(Context c) {
        this.ct = c;
        cx = c.openOrCreateDatabase(nombreBD,Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(tabla);
    }

    public boolean insert(Usuario u) {
        ContentValues contenedor=new ContentValues();
        contenedor.put("usuario",u.getUsuario());
        contenedor.put("clave",u.getClave());
        contenedor.put("nombre",u.getNombre());
        contenedor.put("apellidos",u.getApellidos());

        return (cx.insert("usuario",null,contenedor))>0;
    }

    public boolean delete(Usuario u) {
        return true;
    }

    public boolean update(Usuario u) {
        return true;
    }

    public ArrayList<Usuario> shows() {
        //lista.clear();
        Cursor cursor=cx.rawQuery("select * from usuario",null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                lista.add(new Usuario(cursor.getInt(0),
                                        cursor.getString(1),
                                    cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            }while(cursor.moveToNext());
        }
        return lista;
    }

    public Usuario show(int posicion) {
        Cursor cursor=cx.rawQuery("select * from usuario",null);
        cursor.moveToPosition(posicion);
        u=new Usuario(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
        return u;
    }

    public int Login(String u, String p){
        int a=0;
        Cursor cursor=cx.rawQuery("select * from usuario",null);
        if (cursor!=null && cursor.moveToFirst()){
            do{
                if (cursor.getString(1).equals(u) && cursor.getString(2).equals(p)){
                    a++;
                }
            }while(cursor.moveToNext());
        }
        return a;
    }

    public Usuario getUsuario(String u, String p){
        lista=shows();

        for (Usuario us:lista){
            if (us.getUsuario().equals(u) && us.getClave().equals(p)){
                return us;
            }
        }
        return null;
    }
}
