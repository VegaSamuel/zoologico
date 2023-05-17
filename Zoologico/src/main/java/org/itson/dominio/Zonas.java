/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Contiene los atributos de una zona
 * @author Samuel Vega
 */
public class Zonas {
    private ObjectId id;
    private String nombre;
    private Double extension;
    private List<Especies> especies;

    //Constructor por omisión
    public Zonas() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre de la zona
     * @param extension Extensión en metros cuadrados de la zona
     * @param especies Especies que están dentro de la zona
     */
    public Zonas(String nombre, Double extension, List<Especies> especies) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.extension = extension;
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

    public Double getExtension() {
        return extension;
    }

    public void setExtension(Double extension) {
        this.extension = extension;
    }

    public List<Especies> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especies> especies) {
        this.especies = especies;
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Zonas other = (Zonas) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Zonas{" + "id=" + id + ", nombre=" + nombre + ", extension=" + extension + ", especies=" + especies + '}';
    }

}
