/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Contiene los atributos de un hábitat
 * @author Samuel Vega
 */
public class Habitats {
    private ObjectId id;
    private String nombre;
    private String clima;
    private String tipoVegetacion;
    private List<String> continente;

    //Constructor por omisión
    public Habitats() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre del hábitat
     * @param clima Clima del hábitat
     * @param tipoVegetacion Tipo de vegetación del hábitat
     * @param continente Continente al que pertenece el hábitat
     */
    public Habitats(String nombre, String clima, String tipoVegetacion, List<String> continente) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
        this.continente = continente;
    }

    /**
     * Constructor que inicializa los atributos de la clase con un documento
     * @param document Documento con datos de un habitat
     */
    public Habitats(Document document) {
        this.nombre = document.getString("nombre");
        this.clima = document.getString("clima");
        this.tipoVegetacion = document.getString("tipoVegetacion");
        this.continente = (List<String>) document.get("continentes");
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

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTipoVegetacion() {
        return tipoVegetacion;
    }

    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }

    public List<String> getContinente() {
        return continente;
    }

    public void setContinente(List<String> continente) {
        this.continente = continente;
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
        final Habitats other = (Habitats) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Habitats{" + "id=" + id + ", nombre=" + nombre + ", clima=" + clima + ", tipoVegetacion=" + tipoVegetacion + ", continente=" + continente + '}';
    }

}
