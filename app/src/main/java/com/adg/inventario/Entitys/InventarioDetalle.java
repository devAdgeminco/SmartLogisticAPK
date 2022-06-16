package com.adg.inventario.Entitys;

public class InventarioDetalle {
    int id;
    int idInventario;
    String codigoProducto;
    String descProducto;
    String sustento;
    int cantidadAlmacen;
    int cantidadInventario;

    public InventarioDetalle() {

    }

    public InventarioDetalle(int id, int idInventario, String codigoProducto, String descProducto, String sustento, int cantidadAlmacen, int cantidadInventario) {
        this.id = id;
        this.idInventario = idInventario;
        this.codigoProducto = codigoProducto;
        this.descProducto = descProducto;
        this.sustento = sustento;
        this.cantidadAlmacen = cantidadAlmacen;
        this.cantidadInventario = cantidadInventario;
    }

    public InventarioDetalle(int idInventario, String codigoProducto, String descProducto, String sustento, int cantidadAlmacen, int cantidadInventario) {
        this.idInventario = idInventario;
        this.codigoProducto = codigoProducto;
        this.descProducto = descProducto;
        this.sustento = sustento;
        this.cantidadAlmacen = cantidadAlmacen;
        this.cantidadInventario = cantidadInventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public int getCantidadAlmacen() {
        return cantidadAlmacen;
    }

    public void setCantidadAlmacen(int cantidadAlmacen) {
        this.cantidadAlmacen = cantidadAlmacen;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }
}
