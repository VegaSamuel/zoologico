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
 * Contiene los atributos de una guía
 * @author Samuel Vega
 */
public class Guias {
    private ObjectId id;
    private String nombre;
    private Direccion direccion;
    private Integer telefono;
    private Date fechaIngreso;
    private List<Itinerarios> itinerarios;

    //Constructor por emisión
    public Guias() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre del guía
     * @param direccion Direción del guía
     * @param telefono Teléfono del guía
     * @param fechaIngreso Fecha en que ingreso el guía
     * @param itinerarios Itinerarios que ha realizado el guía
     */
    public Guias(String nombre, Direccion direccion, Integer telefono, Date fechaIngreso, List<Itinerarios> itinerarios) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.itinerarios = itinerarios;
    }

    /**
     * Regresa el ID del guía
     * @return El ID del guía
     */
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Itinerarios> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerarios> itinerarios) {
        this.itinerarios = itinerarios;
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Guias other = (Guias) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Guias{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso + ", itinerarios=" + itinerarios + '}';
    }

}
