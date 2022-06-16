package com.adg.inventario.Entitys;

public class Usuario {

    int id;
    String usuario;
    String clave;
    String nombre;
    String apellidos;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, String nombre, String apellidos) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Usuario(int id, String usuario, String clave, String nombre, String apellidos) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
