/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Clase que conecta a la base de datos
 * @author Samuel Vega
 */
public class ConexionDB {
    private static MongoDatabase conexionDB;
    
    //Constructor por omisión
    private ConexionDB() {
        
    }
    
    /**
     * Regresa una conexión a la base de datos
     * @return Una conexión a la base de datos.
     */
    public static MongoDatabase getInstance() {
        if(conexionDB == null) {
            MongoClient mc = MongoClients.create("mongodb://localhost:27017");
            conexionDB = mc.getDatabase("zoologico");
            return conexionDB;
        }
        return conexionDB;
    }
}
