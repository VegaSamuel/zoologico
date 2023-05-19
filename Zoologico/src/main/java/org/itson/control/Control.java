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
import org.itson.dominio.Zonas;
import org.itson.implementaciones.CuidadoresDAO;
import org.itson.implementaciones.EspeciesDAO;
import org.itson.implementaciones.HabitatsDAO;
import org.itson.implementaciones.ZonasDAO;
import org.itson.interfaces.ICuidadoresDAO;
import org.itson.interfaces.IEspeciesDAO;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.interfaces.IZonasDAO;
import org.itson.presentacion.ConstantesGUI;
import org.itson.presentacion.RegistrarEspecie;
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
    List<Habitats> habitats = new ArrayList<>();
    List<Cuidadores> cuidadores = new ArrayList<>();
    List<Zonas> zonas = new ArrayList<>();
    
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
        
        if(db.getCollection("Zonas").countDocuments() == 0) {
            //Insertando zonas
            List<Especies> es = new ArrayList<>();
            Zonas zona1 = new Zonas("Norte", 20d, es);
            Zonas zona2 = new Zonas("Sur", 16d, es);
            Zonas zona3 = new Zonas("Este", 15.2d, es);
            Zonas zona4 = new Zonas("Oeste", 12.5d, es);
            
            IZonasDAO zDAO = new ZonasDAO();
            
            zDAO.insertar(zona1);
            zDAO.insertar(zona2);
            zDAO.insertar(zona3);
            zDAO.insertar(zona4);
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
        if(climas.isEmpty()) {
            for(Document document: dc) {
                climas.add(document.getString("nombre"));
            }
        }
        
        if(vegetacion.isEmpty()) {
            for(Document document: dv) {
                vegetacion.add(document.getString("nombre"));
            }
        }
        
        if(continentes.isEmpty()) {
            for(Document document: dco) {
                continentes.add(document.getString("nombre"));
            }
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
     * Recupera los datos necesarios para registrar una especie
     * @param frame Ventana que ocupa el método
     * @return Verdadero si se pudo recuperar, Falso en caso contrario.
     */
    public boolean recuperarDatosRegistroEspecie(JFrame frame) {
        //Recibe los datos desde la base de datos
        FindIterable<Document> dh = db.getCollection("Habitats").find();
        FindIterable<Document> dc = db.getCollection("Cuidadores").find();
        FindIterable<Document> dz = db.getCollection("Zonas").find();
        
        IHabitatsDAO hDAO = new HabitatsDAO();
        ICuidadoresDAO cDAO = new CuidadoresDAO();
        IZonasDAO zDAO = new ZonasDAO();
        
        //Llena las listas
        if(habitats.isEmpty()) {
            for(Document document: dh) {
                habitats.add(hDAO.consultar(document.getObjectId("_id")));
            }
        }
        
        if(cuidadores.isEmpty()) {
            for(Document document: dc) {
                cuidadores.add(cDAO.consultar(document.getObjectId("_id")));
            }
        }
        
        if(zonas.isEmpty()) {
            for(Document document: dz) {
                zonas.add(zDAO.consultar(document.getObjectId("_id")));
            }
        }
        
        //Verifica habitats
        if(habitats.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún hábitat registrado en el sistema", "No hay hábitats!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Verifica cuidadores
        if(cuidadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún cuidador registrado en el sistema", "No hay cuidadores!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Verifica zonas
        if(zonas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ninguna zona registrada en el sistema", "No hay zonas!!", JOptionPane.ERROR_MESSAGE);
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
        IHabitatsDAO hDAO = new HabitatsDAO();
        StringBuffer respuesta = new StringBuffer();
        Habitats habitat = new Habitats();
        RegistrarHabitat registrarHabitat;
        DefaultComboBoxModel<String> listaClimas;
        DefaultComboBoxModel<String> listaVegetacion;
        DefaultComboBoxModel<String> listaContinentes;
        
        String nombre = JOptionPane.showInputDialog(frame, "Nombre del hábitat: ", "Registrar hábitat", JOptionPane.QUESTION_MESSAGE).toLowerCase();
        
        if(nombre == null)
            return false;
        
        Document d = db.getCollection("Habitats").find(Filters.eq(ce.NOMBRE, nombre)).first();
        
        listaClimas = conv.comboBoxClimas(climas);
        listaVegetacion = conv.comboBoxVegetacion(vegetacion);
        listaContinentes = conv.comboBoxContinentes(continentes);
        
        if(d != null) {
            JOptionPane.showMessageDialog(frame, "Ese hábitat ya existe", "Hábitat existente!!", JOptionPane.ERROR_MESSAGE);
            
            habitat = hDAO.consultar(d.getObjectId("_id"));
            
            registrarHabitat = new RegistrarHabitat(frame, true, ConstantesGUI.DESPLEGAR, habitat, listaClimas, listaVegetacion, listaContinentes, respuesta);
            
            return false;
        }
        
        habitat.setNombre(nombre);
        
        registrarHabitat = new RegistrarHabitat(frame, true, ConstantesGUI.AGREGAR, habitat, listaClimas, listaVegetacion, listaContinentes, respuesta);
        
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))
            return false;
        
        hDAO.insertar(habitat);
        
        JOptionPane.showMessageDialog(frame, "Hábitat registrado correctamente.", "Registro completado.", JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
    
    /**
     * Registra una especie
     * @param frame Ventana que lo solicita
     * @return True si ya existe, False en caso contrario
     */
    public boolean registrarEspecie(JFrame frame) {
        IEspeciesDAO eDAO = new EspeciesDAO();
        StringBuffer respuesta = new StringBuffer();
        Especies especie = new Especies();
        RegistrarEspecie registrarEspecie;
        DefaultComboBoxModel<Cuidadores> listaCuidadores;
        DefaultComboBoxModel<Habitats> listaHabitats;
        DefaultComboBoxModel<Zonas> listaZonas;
        
        String nombre = JOptionPane.showInputDialog(frame, "Nombre de la especie: ", "Registrar especie", JOptionPane.QUESTION_MESSAGE).toLowerCase();
        
        if(nombre == null)
            return false;
        
        Document d = db.getCollection("Especies").find(Filters.eq("nombre", nombre)).first();
        
        listaCuidadores = conv.comboBoxCuidadores(cuidadores);
        listaHabitats = conv.comboBoxHabitats(habitats);
        listaZonas = conv.comboBoxZonas(zonas);
        
        if(d != null) {
            JOptionPane.showMessageDialog(frame, "Esta especie ya existe", "Especie existente!!", JOptionPane.ERROR_MESSAGE);
            
            especie = eDAO.consultar(d.getObjectId("_id"));
            
            registrarEspecie = new RegistrarEspecie(frame, true, ConstantesGUI.DESPLEGAR, especie, listaCuidadores, listaHabitats, listaZonas, respuesta);
            
            return false;
        }
        
        especie.setNombre(nombre);
        
        registrarEspecie = new RegistrarEspecie(frame, true, ConstantesGUI.AGREGAR, especie, listaCuidadores, listaHabitats, listaZonas, respuesta);
        
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))
            return false;
        
        eDAO.insertar(especie);
        
        JOptionPane.showMessageDialog(frame, "Hábitat registrado correctamente.", "Registro completado.", JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
}
