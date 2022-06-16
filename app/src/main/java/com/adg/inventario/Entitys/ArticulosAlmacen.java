package com.adg.inventario.Entitys;

public class ArticulosAlmacen {
    int id;
    String codigo;
    String descripcion;
    String almacen;
    Integer cantidad;

    public ArticulosAlmacen(int id, String codigo, String descripcion, String almacen, Integer cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.almacen = almacen;
        this.cantidad = cantidad;
    }

    public ArticulosAlmacen(String codigo, String descripcion, String almacen, Integer cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.almacen = almacen;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
