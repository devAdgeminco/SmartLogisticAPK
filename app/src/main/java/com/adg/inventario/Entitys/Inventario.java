package com.adg.inventario.Entitys;

public class Inventario {


    int id;
    String descripcion;
    String fecha;
    String almacen;

    public Inventario() {
    }

    public Inventario(int id, String descripcion, String fecha, String almacen) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.almacen = almacen;
    }
    public Inventario(String descripcion, String fecha, String almacen) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.almacen = almacen;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

}
