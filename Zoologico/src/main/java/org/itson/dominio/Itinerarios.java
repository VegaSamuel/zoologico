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
 * Contiene los atributos de un itinerario
 * @author Samuel Vega
 */
public class Itinerarios {
    private ObjectId id;
    private Integer duracion;
    private Double longitud;
    private Integer maxVisitanteAutorizados;
    private Integer numEspeciesDistintas;
    private Guias guia;
    private List<Zonas> zonas;

    //Constructor por emisión
    public Itinerarios() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param duracion Duración en minutos
     * @param longitud Longitud del recorrido en metros
     * @param maxVisitanteAutorizados Número máximo de vistantes autorizados
     * @param numEspeciesDistintas Número de especies que están dentro del recorrido
     * @param guia Guía encargado del recorrido
     * @param zonas Zonas por las que pasará el recorrido
     */
    public Itinerarios(Integer duracion, Double longitud, Integer maxVisitanteAutorizados, Integer numEspeciesDistintas, Guias guia, List<Zonas> zonas) {
        this.id = new ObjectId();
        this.duracion = duracion;
        this.longitud = longitud;
        this.maxVisitanteAutorizados = maxVisitanteAutorizados;
        this.numEspeciesDistintas = numEspeciesDistintas;
        this.guia = guia;
        this.zonas = zonas;
    }

    public Itinerarios(Document document) {
        this.duracion = document.getInteger("duracion");
        this.longitud = document.getDouble("longitud");
        this.maxVisitanteAutorizados = document.getInteger("maxVisitantesAutorizados");
        this.numEspeciesDistintas = document.getInteger("numEspeciesDistintas");
        this.guia = new Guias((Document) document.get("guia"));
        this.zonas = (List<Zonas>) document.get("zonas");
    }

    /**
     * Regresa el ID de un recorrido
     * @return El ID de un recorrido
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Define el ID del recorrido
     * @param id ID del recorrido
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa la duración en minutos de un recorrido
     * @return La duración en minutos de un recorrido
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * Define la duración en minutos de un recorrido 
     * @param duracion Duración en minutos de un recorrido
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * Regresa la longitud en metros de un recorrido
     * @return La longitud en metros de un recorrido
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * Define la longitud en metros de un recorrido
     * @param longitud Longitud en metros de un recorrido
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * Regresa el número máximo de visitantes autorizados para un recorrido
     * @return El número máximo de visitantes autorizados para un recorrido
     */
    public Integer getMaxVisitanteAutorizados() {
        return maxVisitanteAutorizados;
    }

    /**
     * Define el número máximo de visitantes autorizados para un recorrido
     * @param maxVisitanteAutorizados Número máximo de visitantes autorizados para un recorrido
     */
    public void setMaxVisitanteAutorizados(Integer maxVisitanteAutorizados) {
        this.maxVisitanteAutorizados = maxVisitanteAutorizados;
    }

    /**
     * Regresa el número de especies distintas dentro del recorrido
     * @return El número de especies distintas dentro del recorrido
     */
    public Integer getNumEspeciesDistintas() {
        return numEspeciesDistintas;
    }

    /**
     * Define el número de especies distintas dentro del recorrido
     * @param numEspeciesDistintas Número de especies distintas dentro del recorrido
     */
    public void setNumEspeciesDistintas(Integer numEspeciesDistintas) {
        this.numEspeciesDistintas = numEspeciesDistintas;
    }

    /**
     * Regresa el guía encargado del recorrido
     * @return El guía encargado del recorrido
     */
    public Guias getGuia() {
        return guia;
    }

    /**
     * Define el guía que se encargará del recorrido
     * @param guia Guía que se encargará del recorrido
     */
    public void setGuia(Guias guia) {
        this.guia = guia;
    }

    /**
     * Regresa las zonas por las que pasará el recorrido
     * @return Las zonas por las que pasará el recorrido
     */
    public List<Zonas> getZonas() {
        return zonas;
    }

    /**
     * Define las zonas por las que pasará el recorrido
     * @param zonas Zonas por las que pasará el recorrido
     */
    public void setZonas(List<Zonas> zonas) {
        this.zonas = zonas;
    }

    /**
     * Regresa el codigo hash de un objeto de esta clase
     * @return El codigo hash de un objeto de esta clase
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Itinerarios other = (Itinerarios) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Regresa una cadena que muestra los datos del objeto de la clase
     * @return Una cadena que muestra los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Itinerarios{" + "id=" + id + ", duracion=" + duracion + ", longitud=" + longitud + ", maxVisitanteAutorizados=" + maxVisitanteAutorizados + ", numEspeciesDistintas=" + numEspeciesDistintas + ", guia=" + guia + '}';
    }

}
