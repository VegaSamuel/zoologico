/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.itson.database.ConexionDB;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Direccion;
import org.itson.dominio.Especies;
import org.itson.implementaciones.CuidadoresDAO;
import org.itson.interfaces.ICuidadoresDAO;

/**
 * Lleva un control de ciertos aspectos
 * @author Samuel Vega
 */
public class Control {
    
    /**
     * Inserta datos en la base de datos
     */
    public void IngresarDatos() {
        MongoDatabase db = ConexionDB.getInstance();
        
        System.out.println(db.getCollection("Climas").countDocuments());
        
        if(db.getCollection("Climas").countDocuments() == 0) {
            Document dc1 = new Document("nombre", "tropical");
            Document dc2 = new Document("nombre", "helado");
            Document dc3 = new Document("nombre", "calido");
            
            List<Document> dc = new ArrayList<>();
            
            dc.add(dc1);
            dc.add(dc2);
            dc.add(dc3);
            
            db.getCollection("Climas").insertMany(dc);
            
            List<Especies> es = new ArrayList<>();
            Cuidadores cuidador1 = new Cuidadores("Carlos", new Direccion("Manuel Patruña", "Pinos Altos", "1547"), "6442548798", new Date(), es);
            Cuidadores cuidador2 = new Cuidadores("Arturo", new Direccion("Pinguinos", "Ron Varon", "998A"), "6441548764", new Date(), es);
            Cuidadores cuidador3 = new Cuidadores("Gabriela", new Direccion("Santa Clara", "Los Brillos", "1354"), "6444876547", new Date(), es);
            Cuidadores cuidador4 = new Cuidadores("Ruben", new Direccion("Primos", "Las Luchas", "5487"), "6446478641", new Date(), es);
            
            ICuidadoresDAO cDAO = new CuidadoresDAO();
            
            cDAO.insertar(cuidador1);
            cDAO.insertar(cuidador2);
            cDAO.insertar(cuidador3);
            cDAO.insertar(cuidador4);
        }
    }
}
