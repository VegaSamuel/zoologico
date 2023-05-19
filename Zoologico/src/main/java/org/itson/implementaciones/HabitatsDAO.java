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
import org.itson.control.ConstantesEtiquetas;
import org.itson.dominio.Habitats;
import org.itson.interfaces.IHabitatsDAO;

/**
 * Implementa las funciones DAO de los hábitats
 * @author Samuel Vega
 */
public class HabitatsDAO implements IHabitatsDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();

    /**
     * Encuentra un hábitat por su ID
     * @param id ID del cuidador
     * @return Hábitat con ID coincidente
     */
    @Override
    public Habitats consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Habitats habitat = new Habitats();
        
        Document d = db.getCollection("Habitats").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            habitat.setId(d.getObjectId("_id"));
            habitat.setNombre(d.getString(ce.NOMBRE));
            habitat.setClima(d.getString(ce.CLIMA));
            habitat.setTipoVegetacion(d.getString(ce.VEGETACION));
            habitat.setContinente((List<String>) d.get(ce.CONTINENTES));
        }
        
        return habitat;
    }

    /**
     * Inserta un hábitat
     * @param habitat Hábitat a insertar
     */
    @Override
    public void insertar(Habitats habitat) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document();
        
        d.append(ce.NOMBRE, habitat.getNombre())
         .append(ce.CLIMA, habitat.getClima())
         .append(ce.VEGETACION, habitat.getTipoVegetacion())
         .append(ce.CONTINENTES, habitat.getContinente());
        
        db.getCollection("Habitats").insertOne(d);
    }

    /**
     * Elimina un hábitat
     * @param id ID del hábitat
     */
    @Override
    public void eliminar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Document d = new Document("_id", id);
        
        DeleteResult result = db.getCollection("Habitats").deleteOne(d);
        
        if(result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Hábitat eliminado existosamente.", "Eliminación existosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
