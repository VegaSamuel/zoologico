/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Especies;

/**
 * Interfaz con los métodos DAO de cuidadores
 * @author Samuel Vega
 */
public interface IEspeciesDAO {
    
    /**
     * Encuentra una especie por su id
     * @param id ID de la especie
     * @return Especie con ID coincidente
     */
    Especies consultar(ObjectId id);
    
    /**
     * Inserta una especie
     * @param especie Especie a insertar
     */
    void insertar(Especies especie);
    
    /**
     * Elimina una especie
     * @param id ID de la especie
     */
    void eliminar(ObjectId id);
    
    /**
     * Encuentra a todos las especies
     * @return Una lista con todos las especies
     */
    List<Especies> consultar();
}
