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
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Especies;
import org.itson.dominio.Habitats;
import org.itson.dominio.Zonas;
import org.itson.interfaces.IEspeciesDAO;

/**
 * Implementa las funciones DAO de las especies
 * @author Samuel Vega
 */
public class EspeciesDAO implements IEspeciesDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();

    /**
     * Encuentra una especie por su id
     * @param id ID de la especie
     * @return Especie con ID coincidente
     */
    @Override
    public Especies consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Especies especie = new Especies();
        
        Document d = db.getCollection("Especies").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            especie.setId(d.getObjectId("_id"));
            especie.setNombre(d.getString(ce.NOMBRE));
            especie.setNombreCientifico(d.getString(ce.NOMBRE_CIENTIFICO));
            especie.setCuidador(new Cuidadores((Document) d.get(ce.CUIDADOR)));
            especie.setHabitat(new Habitats((Document) d.get(ce.HABITAT)));
            especie.setZona(new Zonas((Document) d.get(ce.ZONA)));
        }
        
        return especie;
    }

    /**
     * Inserta una especie
     * @param especie Especie a insertar
     */
    @Override
    public void insertar(Especies especie) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document();
        
        d.append(ce.NOMBRE, especie.getNombre())
         .append(ce.NOMBRE_CIENTIFICO, especie.getNombreCientifico())
         .append(ce.CUIDADOR, especie.getCuidador())
         .append(ce.HABITAT, especie.getHabitat())
         .append(ce.ZONA, especie.getZona());
        
        db.getCollection("Especies").insertOne(d);
    }

    /**
     * Elimina una especie
     * @param id ID de la especie
     */
    @Override
    public void eliminar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document("_id", id);
        
        DeleteResult result = db.getCollection("Especies").deleteOne(d);
        
        if(result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Especie eliminado existosamente.", "Eliminación existosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Encuentra a todos las especies
     * @return Una lista con todos las especies
     */
    @Override
    public List<Especies> consultar() {
        MongoDatabase db = ConexionDB.getInstance();
        List<Especies> especies = new ArrayList<>();
        
        FindIterable<Document> documents = db.getCollection("Especies").find();
        
        for(Document document: documents) {
            especies.add((Especies) consultar(document.getObjectId("_id")));
        }
        
        return especies;
    }
    
}
