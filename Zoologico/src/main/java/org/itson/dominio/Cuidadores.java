/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Contiene los atributos de un cuidador
 * @author Samuel Vega
 */
public class Cuidadores {
    private ObjectId id;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private Date fechaIngreso;
    private List<Especies> especies;

    public Cuidadores() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre del cuidador
     * @param direccion Dirección del cuidador
     * @param telefono Teléfono del cuidador
     * @param fechaIngreso Fecha de ingreso del cuidador
     * @param especies Especies que el cuidador cuida
     */
    public Cuidadores(String nombre, Direccion direccion, String telefono, Date fechaIngreso, List<Especies> especies) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.especies = especies;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Especies> getEspecies() {
        return especies;
    }
    
    public void setEspecies(List<Especies> especies) {
        this.especies = especies;
    }

    public void addEspecies(Especies especie) {
        this.especies.add(especie);
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el objeto parámetro con un objeto de esta clase
     * @param obj Objeto parámetro
     * @return True si es el mismo, False en caso contrario
     */
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
        final Cuidadores other = (Cuidadores) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Cuidadores{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso + ", especies=" + especies + '}';
    }

}
