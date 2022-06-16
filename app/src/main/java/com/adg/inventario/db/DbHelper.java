package com.adg.inventario.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "BDInventario.db";
    public static final String TABLE_INVENTARIO = "t_inventario";
    public static final String TABLE_INVENTARIO_DETALLE = "t_inventario_detalle";
    public static final String TABLE_ARTICULOS = "t_articulosalmacen";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_INVENTARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descripcion TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "almacen INT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_INVENTARIO_DETALLE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idInventario INTEGER," +
                "codigoProducto INTEGER," +
                "descProducto TEXT NOT NULL," +
                "sustento TEXT NOT NULL," +
                "cantidadAlmacen INT," +
                "cantidadInventario INT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ARTICULOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "almacen TEXT NOT NULL," +
                "cantidad INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_INVENTARIO);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_INVENTARIO_DETALLE);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ARTICULOS);
        onCreate(sqLiteDatabase);

    }
}
