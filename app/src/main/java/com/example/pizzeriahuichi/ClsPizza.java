package com.example.pizzeriahuichi;

import java.io.Serializable;

public class ClsPizza implements Serializable {

    private String nombre;
    private String precio;
    private String info;
    private int foto;

    public ClsPizza(String nombre, String info, String precio, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
