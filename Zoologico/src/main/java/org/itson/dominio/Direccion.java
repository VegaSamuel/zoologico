/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Contiene los atributos de una dirección
 * @author Samuel Vega
 */
public class Direccion {
    private ObjectId id;
    private String calle;
    private String colonia;
    private String nCasa;

    //Constructor por omisión
    public Direccion() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param calle Calle de la dirección
     * @param colonia Colonia de la dirección
     * @param nCasa Número de casa de la dirección
     */
    public Direccion(String calle, String colonia, String nCasa) {
        this.id = new ObjectId();
        this.calle = calle;
        this.colonia = colonia;
        this.nCasa = nCasa;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getnCasa() {
        return nCasa;
    }

    public void setnCasa(String nCasa) {
        this.nCasa = nCasa;
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Direccion other = (Direccion) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", nCasa=" + nCasa + '}';
    }

}
