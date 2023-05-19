/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.bson.types.ObjectId;
import org.itson.dominio.Zonas;

/**
 * Interfaz con los métodos DAO de zonas
 * @author Samuel Vega
 */
public interface IZonasDAO {
    
    /**
     * Encuentra una zona por su id
     * @param id ID de la zona
     * @return Zona con ID coincidente
     */
    Zonas consultar(ObjectId id);
    
    /**
     * Inserta una zona
     * @param zona Zona a insertar
     */
    void insertar(Zonas zona);
    
    /**
     * Elimina una zona
     * @param id ID de la zona
     */
    void eliminar(ObjectId id);
}
