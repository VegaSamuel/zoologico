/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.bson.types.ObjectId;
import org.itson.dominio.Cuidadores;

/**
 * Interfaz con los métodos DAO de cuidadores
 * @author Samuel Vega
 */
public interface ICuidadoresDAO {
    
    /**
     * Encuentra un cuidador por su ID
     * @param id ID del cuidador
     * @return Cuidador con ID coincidente
     */
    Cuidadores consultar(ObjectId id);
    
    /**
     * Inserta un cuidador
     * @param cuidadores Cuidador a insertar
     */
    void insertar(Cuidadores cuidadores);
    
    /**
     * Elimina un cuidador
     * @param cuidadores Cuidador a eliminar
     */
    void eliminar(Cuidadores cuidadores);
}
