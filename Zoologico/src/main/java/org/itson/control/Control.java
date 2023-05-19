/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.itson.database.ConexionDB;
import org.itson.database.ConstantesEtiquetas;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Direccion;
import org.itson.dominio.Especies;
import org.itson.dominio.Habitats;
import org.itson.implementaciones.CuidadoresDAO;
import org.itson.implementaciones.HabitatsDAO;
import org.itson.interfaces.ICuidadoresDAO;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.presentacion.ConstantesGUI;
import org.itson.presentacion.RegistrarHabitat;

/**
 * Lleva un control de ciertos aspectos
 * @author Samuel Vega
 */
public class Control {
    MongoDatabase db = ConexionDB.getInstance();
    ConstantesEtiquetas ce = new ConstantesEtiquetas();
    Conversiones conv = new Conversiones();
    
    //Crea listas
    List<String> climas = new ArrayList<>();
    List<String> vegetacion = new ArrayList<>();
    List<String> continentes = new ArrayList<>();
    
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
    
    /**
     * Registra un hábitat
     * @param frame Ventana que lo solicita
     * @return True si ya existe, False en caso contrario
     */
    public boolean registrarHabitat(JFrame frame) {
        StringBuffer respuesta = new StringBuffer();
        Habitats habitat = new Habitats();
        RegistrarHabitat registrarHabitat;
        DefaultComboBoxModel<String> listaClimas;
        DefaultComboBoxModel<String> listaVegetacion;
        DefaultComboBoxModel<String> listaContinentes;
        
        String nombre = JOptionPane.showInputDialog(frame, "Nombre del hábitat: ", "Registrar hábitat", JOptionPane.QUESTION_MESSAGE);
        
        Document d = db.getCollection("Habitats").find(Filters.eq(ce.NOMBRE, nombre)).first();
        
        if(d != null) {
            JOptionPane.showMessageDialog(frame, "Ese hábitat ya existe", "Hábitat existente!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        listaClimas = conv.comboBoxClimas(climas);
        listaVegetacion = conv.comboBoxVegetacion(vegetacion);
        listaContinentes = conv.comboBoxContinentes(continentes);
        
        habitat.setNombre(nombre);
        
        registrarHabitat = new RegistrarHabitat(frame, true, habitat, listaClimas, listaVegetacion, listaContinentes, respuesta);
        
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))
            return false;
        
        IHabitatsDAO hDAO = new HabitatsDAO();
        
        hDAO.insertar(habitat);
        
        JOptionPane.showMessageDialog(frame, "Hábitat registrado correctamente.", "Registro completado.", JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
}
