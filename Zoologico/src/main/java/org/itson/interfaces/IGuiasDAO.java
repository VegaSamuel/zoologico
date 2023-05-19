/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.bson.types.ObjectId;
import org.itson.dominio.Guias;

/**
 * Interfaz con los métodos DAO de guias
 * @author Samuel Vega
 */
public interface IGuiasDAO {
    
    /**
     * Encuentra un guia por su ID
     * @param id ID del cuidador
     * @return Guia con ID coincidente
     */
    Guias consultar(ObjectId id);
    
    /**
     * Inserta un guia
     * @param guia Guia a insertar
     */
    void insertar(Guias guia);
    
    /**
     * Elimina un guia
     * @param id ID del guia
     */
    void eliminar(ObjectId id);
}
