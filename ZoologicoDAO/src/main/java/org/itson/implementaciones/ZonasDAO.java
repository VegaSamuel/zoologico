/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.database.ConexionDB;
import org.itson.database.ConstantesEtiquetas;
import org.itson.dominio.Especies;
import org.itson.dominio.Zonas;
import org.itson.interfaces.IZonasDAO;

/**
 * Implementa las funciones DAO de las zonas
 * @author Samuel Vega
 */
public class ZonasDAO implements IZonasDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();
    
    /**
     * Encuentra una zona por su id
     * @param id ID de la zona
     * @return Zona con ID coincidente
     */
    @Override
    public Zonas consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Zonas zona = new Zonas();
        
        Document d = db.getCollection("Zonas").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            zona.setId(d.getObjectId("_id"));
            zona.setNombre(d.getString(ce.NOMBRE));
            zona.setExtension(d.getDouble(ce.EXTENSION));
            zona.setEspecies((List<Especies>) d.get(ce.ESPECIES));
        }
        
        return zona;
    }

    /**
     * Inserta una zona
     * @param zona Zona a insertar
     */
    @Override
    public void insertar(Zonas zona) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document();
        
        d.append(ce.NOMBRE, zona.getNombre())
         .append(ce.EXTENSION, zona.getExtension())
         .append(ce.ESPECIES, zona.getEspecies());
        
        db.getCollection("Zonas").insertOne(d);
    }

    /**
     * Elimina una zona
     * @param id ID de la zona
     */
    @Override
    public void eliminar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document("_id", id);
        
        DeleteResult result = db.getCollection("Zonas").deleteOne(d);
        
        if(result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Zona eliminado existosamente.", "Eliminación existosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Encuentra a todos las zonas
     * @return Una lista con todos las zonas
     */
    @Override
    public List<Zonas> consultar() {
        MongoDatabase db = ConexionDB.getInstance();
        List<Zonas> zonas = new ArrayList<>();
        
        FindIterable<Document> documents = db.getCollection("Zonas").find();
        
        for(Document document: documents) {
            zonas.add((Zonas) consultar(document.getObjectId("_id")));
        }
        
        return zonas;
    }
}
