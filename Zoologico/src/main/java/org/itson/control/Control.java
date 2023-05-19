/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    MongoDatabase db = ConexionDB.getInstance();
    
    /**
     * Inserta datos en la base de datos
     */
    public void IngresarDatos() {
        if(db.getCollection("Climas").countDocuments() == 0) {
            //Insertando climas
            List<Document> dc = new ArrayList<>();
            
            dc.add(new Document("nombre", "Tropical"));
            dc.add(new Document("nombre", "Helado"));
            dc.add(new Document("nombre", "Calido"));
            
            db.getCollection("Climas").insertMany(dc);
        }
            
        if(db.getCollection("TiposVegetacion").countDocuments() == 0) {
            //Insertando tipos de vegetación
            List<Document> dv = new ArrayList<>();
            
            dv.add(new Document("nombre", "Bosque"));
            dv.add(new Document("nombre", "Selva"));
            dv.add(new Document("nombre", "Desierto"));
            
            db.getCollection("TiposVegetacion").insertMany(dv);           
        }
        
        if(db.getCollection("Continentes").countDocuments() == 0) {
            //Insertando continentes
            List<Document> dco = new ArrayList<>();
            
            dco.add(new Document("nombre", "América"));
            dco.add(new Document("nombre", "Europa"));
            dco.add(new Document("nombre", "África"));
            dco.add(new Document("nombre", "Antártida"));
            dco.add(new Document("nombre", "Oceanía"));
            dco.add(new Document("nombre", "Asia"));
            
            db.getCollection("Continentes").insertMany(dco);
        }
        
        if(db.getCollection("Cuidadores").countDocuments() == 0) {
            //Insertando cuidadores
            List<Especies> es = new ArrayList<>();
            Cuidadores cuidador1 = new Cuidadores("Arturo", new Direccion("Pinguinos", "Ron Varon", "998A"), "6441548764", new Date(), es);
            Cuidadores cuidador2 = new Cuidadores("Gabriela", new Direccion("Santa Clara", "Los Brillos", "1354"), "6444876547", new Date(), es);
            Cuidadores cuidador3 = new Cuidadores("Ruben", new Direccion("Primos", "Las Luchas", "5487"), "6446478641", new Date(), es);
            Cuidadores cuidador4 = new Cuidadores("Angel", new Direccion("Levantados", "Los Helados", "1547"), "6442548798", new Date(), es);
            
            ICuidadoresDAO cDAO = new CuidadoresDAO();
            
            cDAO.insertar(cuidador1);
            cDAO.insertar(cuidador2);
            cDAO.insertar(cuidador3);
            cDAO.insertar(cuidador4);
        }
        
    }
    
    /**
     * Recupera los datos necesarios para registrar un hábitat
     * @param frame Ventana que ocupa el método
     * @return Verdadero si se pudo recuperar, Falso en caso contrario.
     */
    public boolean recuperarDatosRegistroHabitat(JFrame frame) {
        //Crea listas
        List<String> climas = new ArrayList<>();
        List<String> vegetacion = new ArrayList<>();
        List<String> continentes = new ArrayList<>();
        
        //Recibe los datos desde la base de datos
        FindIterable<Document> dc = db.getCollection("Climas").find();
        FindIterable<Document> dv = db.getCollection("TiposVegetacion").find();
        FindIterable<Document> dco = db.getCollection("Continentes").find();
        
        //Llena las listas
        for(Document document: dc) {
            climas.add(document.getString("nombre"));
        }
        
        for(Document document: dv) {
            vegetacion.add(document.getString("nombre"));
        }
        
        for(Document document: dco) {
            continentes.add(document.getString("nombre"));
        }
        
        //Verifica climas
        if(climas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay climas registrados en el sistema.", "No hay climas!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Verifica tipos de vegetación
        if(vegetacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún tipo de vegetación registrada en el sistema", "No hay tipos de vegetación!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Verifica continentes
        if(continentes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún continente registrado en el sistema", "No hay continentes!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
}
