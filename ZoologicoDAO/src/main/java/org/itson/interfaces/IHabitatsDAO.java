/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitats;

/**
 * Interfaz con los métodos DAO de cuidadores
 * @author Samuel Vega
 */
public interface IHabitatsDAO {
    
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
    
    /**
     * Encuentra a todos los hábitats
     * @return Una lista con todos los hábitats
     */
    List<Habitats> consultar();
}
