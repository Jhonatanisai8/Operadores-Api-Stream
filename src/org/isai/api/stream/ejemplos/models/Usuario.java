package org.isai.api.stream.ejemplos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    
    private String nombre;
    private String apellido;
    private Integer id;
    private List<Factura> facturas;
    
    private static int ultimoId;
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = ++ultimoId;
        this.facturas = new ArrayList<>();
    }
    
    public List<Factura> getFacturas() {
        return facturas;
    }
    
    public void addFacuras(Factura f) {
        this.facturas.add(f);
        //este mismo usuario
        f.setUsuario(this);
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.apellido);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }
    
}
