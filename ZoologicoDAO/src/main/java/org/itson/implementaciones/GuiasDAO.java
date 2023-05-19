/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.database.ConexionDB;
import org.itson.database.ConstantesEtiquetas;
import org.itson.dominio.Direccion;
import org.itson.dominio.Guias;
import org.itson.dominio.Itinerarios;
import org.itson.interfaces.IGuiasDAO;

/**
 * Implementa las funciones DAO de los guías
 * @author Samuel Vega
 */
public class GuiasDAO implements IGuiasDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();

    /**
     * Encuentra un guia por su ID
     * @param id ID del cuidador
     * @return Guia con ID coincidente
     */
    @Override
    public Guias consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Guias guia = new Guias();
        
        Document d = db.getCollection("Guias").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            guia.setId(d.getObjectId("_id"));
            guia.setNombre(d.getString(ce.NOMBRE));
            guia.setDireccion((Direccion) d.get(ce.DIRECCION));
            guia.setTelefono(d.getString(ce.TELEFONO));
            guia.setFechaIngreso(d.getDate(ce.FECHA_INGRESO));
            guia.setItinerarios((List<Itinerarios>) d.get(ce.ITINERARIOS));
        }
        
        return guia;
    }

    /**
     * Inserta un guia
     * @param guia Guia a insertar
     */
    @Override
    public void insertar(Guias guia) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document();
        
        d.append(ce.NOMBRE, guia.getNombre())
         .append(ce.DIRECCION, guia.getDireccion())
         .append(ce.TELEFONO, guia.getTelefono())
         .append(ce.FECHA_INGRESO, guia.getFechaIngreso())
         .append(ce.ITINERARIOS, guia.getItinerarios());
        
        db.getCollection("Guias").insertOne(d);
    }

    /**
     * Elimina un guia
     * @param id ID del guia
     */
    @Override
    public void eliminar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document("_id", id);
        
        DeleteResult result = db.getCollection("Guias").deleteOne(d);
        
        if(result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Guía eliminado existosamente.", "Eliminación existosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
