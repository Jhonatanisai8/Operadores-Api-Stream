package org.isai.api.stream.ejemplos.models;

public class Factura {

    private String descripcion;

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
