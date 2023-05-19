/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Itinerarios;

/**
 * Interfaz con los métodos DAO de itinerarios
 * @author Samuel Vega
 */
public interface IItinerariosDAO {
    
    /**
     * Encuentra un itinerario por su ID
     * @param id ID del itinerario
     * @return Itinerario con ID coincidente
     */
    Itinerarios consultar(ObjectId id);
    
    /**
     * Inserta un itinerario
     * @param itinerario Itinerario a insertar
     */
    void insertar(Itinerarios itinerario);
    
    /**
     * Elimina un itinerario
     * @param id ID del itinerario
     */
    void eliminar(ObjectId id);
    
    /**
     * Encuentra a todos los itinerarios
     * @return Una lista con todos los itinerarios
     */
    List<Itinerarios> consultar();
}
