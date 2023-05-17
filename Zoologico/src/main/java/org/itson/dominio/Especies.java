/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Contiene los atributos de una especie
 * @author Samuel Vega
 */
public class Especies {
    private ObjectId id;
    private String nombre;
    private String nombreCientifico;
    private Cuidadores cuidador;
    private Habitats habitat;
    private Zonas zona;

    //Constructor por omisión
    public Especies() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre de la especie
     * @param nombreCientifico Nombre científico de la especie
     * @param cuidador Cuidador que se encarga de la especie
     * @param habitat Hábitat al que pertenece la especie
     * @param zona Zona donde se encuentra la especie
     */
    public Especies(String nombre, String nombreCientifico, Cuidadores cuidador, Habitats habitat, Zonas zona) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.cuidador = cuidador;
        this.habitat = habitat;
        this.zona = zona;
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

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public Cuidadores getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidadores cuidador) {
        this.cuidador = cuidador;
    }

    public Habitats getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitats habitat) {
        this.habitat = habitat;
    }

    public Zonas getZona() {
        return zona;
    }

    public void setZona(Zonas zona) {
        this.zona = zona;
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Especies other = (Especies) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nombre=" + nombre + ", nombreCientifico=" + nombreCientifico + ", cuidador=" + cuidador + ", habitat=" + habitat + ", zona=" + zona + '}';
    }

}
