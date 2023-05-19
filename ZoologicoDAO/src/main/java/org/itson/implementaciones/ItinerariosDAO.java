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
import org.itson.dominio.Guias;
import org.itson.dominio.Itinerarios;
import org.itson.dominio.Zonas;
import org.itson.interfaces.IItinerariosDAO;

/**
 * Implementa las funciones DAO de los itinerarios
 * @author Samuel Vega
 */
public class ItinerariosDAO implements IItinerariosDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();
    
    /**
     * Encuentra un itinerario por su ID
     * @param id ID del itinerario
     * @return Itinerario con ID coincidente
     */
    @Override
    public Itinerarios consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Itinerarios itinerario = new Itinerarios();
        
        Document d = db.getCollection("Itinerarios").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            itinerario.setId(d.getObjectId("_id"));
            itinerario.setNombre(d.getString(ce.NOMBRE));
            itinerario.setDuracion(d.getInteger(ce.DURACION));
            itinerario.setLongitud(d.getDouble(ce.LONGITUD));
            itinerario.setMaxVisitanteAutorizados(d.getInteger(ce.VISITANTES));
            itinerario.setNumEspeciesDistintas(d.getInteger(ce.NESPECIES));
            itinerario.setGuia(new Guias((Document) d.get(ce.GUIA)));
            itinerario.setZonas((List<Zonas>) d.get(ce.ZONAS));
        }
        
        return itinerario;
    }

    /**
     * Inserta un itinerario
     * @param itinerario Itinerario a insertar
     */
    @Override
    public void insertar(Itinerarios itinerario) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document();
        
        d.append(ce.NOMBRE, itinerario.getNombre())
         .append(ce.DURACION, itinerario.getDuracion())
         .append(ce.LONGITUD, itinerario.getLongitud())
         .append(ce.VISITANTES, itinerario.getMaxVisitanteAutorizados())
         .append(ce.NESPECIES, itinerario.getNumEspeciesDistintas())
         .append(ce.GUIA, itinerario.getGuia())
         .append(ce.ZONAS, itinerario.getZonas());
        
        db.getCollection("Itinerarios").insertOne(d);
    }

    /**
     * Elimina un itinerario
     * @param id ID del itinerario
     */
    @Override
    public void eliminar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document("_id", id);
        
        DeleteResult result = db.getCollection("Itinearios").deleteOne(d);
        
        if(result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Itinerario eliminado existosamente.", "Eliminación existosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Encuentra a todos los itinerarios
     * @return Una lista con todos los itinerarios
     */
    @Override
    public List<Itinerarios> consultar() {
        MongoDatabase db = ConexionDB.getInstance();
        List<Itinerarios> itinerarios = new ArrayList<>();
        
        FindIterable<Document> documents = db.getCollection("Itinerarios").find();
        
        for(Document document: documents) {
            itinerarios.add((Itinerarios) consultar(document.getObjectId("_id")));
        }
        
        return itinerarios;
    }
    
}
