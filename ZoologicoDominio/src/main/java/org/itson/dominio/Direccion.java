/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import org.bson.Document;

/**
 * Contiene los atributos de una dirección
 * @author Samuel Vega
 */
public class Direccion {
    private String calle;
    private String colonia;
    private String nCasa;

    //Constructor por omisión
    public Direccion() {}

    /**
     * Constructor que inicializa los atributos de la clase, excepto el ID
     * @param calle Calle de la dirección
     * @param colonia Colonia de la dirección
     * @param nCasa Número de casa de la dirección
     */
    public Direccion(String calle, String colonia, String nCasa) {
        this.calle = calle;
        this.colonia = colonia;
        this.nCasa = nCasa;
    }
    
    /**
     * Constructor que recibe un documento e inicializa los atributos de la clase con el documento
     * @param document Documento con datos de Dirección
     */
    public Direccion(Document document) {
        this.calle = document.getString("calle");
        this.colonia = document.getString("colonia");
        this.nCasa = document.getString("numero casa");
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
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", colonia=" + colonia + ", nCasa=" + nCasa + '}';
    }

}
