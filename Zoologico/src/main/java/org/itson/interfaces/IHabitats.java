/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.bson.types.ObjectId;
import org.itson.dominio.Habitats;

/**
 * Interfaz con los métodos DAO de cuidadores
 * @author Samuel Vega
 */
public interface IHabitats {
    
    /**
     * Encuentra un hábitat por su ID
     * @param id ID del cuidador
     * @return Hábitat con ID coincidente
     */
    Habitats consultar(ObjectId id);
    
    /**
     * Inserta un hábitat
     * @param habitat Hábitat a insertar
     */
    void insertar(Habitats habitat);
    
    /**
     * Elimina un hábitat
     * @param id ID del hábitat
     */
    void eliminar(ObjectId id);
}
