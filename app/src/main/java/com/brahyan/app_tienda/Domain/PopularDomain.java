package com.brahyan.app_tienda.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String titulo;
    private double precio;
    private String img;

    private String desc;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PopularDomain(String titulo, double precio, String img, String desc) {
        this.titulo = titulo;
        this.precio = precio;
        this.img = img;
        this.desc = desc;
    }
}
