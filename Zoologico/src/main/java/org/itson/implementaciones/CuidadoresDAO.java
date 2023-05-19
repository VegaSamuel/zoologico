/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.database.ConexionDB;
import org.itson.database.ConstantesEtiquetas;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Direccion;
import org.itson.dominio.Especies;
import org.itson.interfaces.ICuidadoresDAO;

/**
 * Implementa las funciones DAO de los cuidadores
 * @author Samuel Vega
 */
public class CuidadoresDAO implements ICuidadoresDAO {
    ConstantesEtiquetas ce = new ConstantesEtiquetas();
    
    @Override
    public Cuidadores consultar(ObjectId id) {
        MongoDatabase db = ConexionDB.getInstance();
        Cuidadores cuidador = new Cuidadores();
        
        Document d = db.getCollection("Cuidadores").find(Filters.eq("_id", id)).first();
        
        if(d != null) {
            cuidador.setId(d.getObjectId("_id"));
            cuidador.setNombre(d.getString(ce.NOMBRE));
            //cuidador.setDireccion((Direccion) d.get(ce.DIRECCION));
            cuidador.setTelefono(d.getString(ce.TELEFONO));
            cuidador.setFechaIngreso(d.getDate(ce.FECHA_INGRESO));
            //cuidador.addEspecies((Especies) d.get(ce.ESPECIES));
        }
        
        return cuidador;
    }

    @Override
    public void insertar(Cuidadores cuidador) {
        MongoDatabase db = ConexionDB.getInstance();
        
        Document d = new Document();
        
        d.append(ce.NOMBRE, cuidador.getNombre())
         .append(ce.DIRECCION, new Document(ce.CALLE, cuidador.getDireccion().getCalle())
                                    .append(ce.COLONIA, cuidador.getDireccion().getColonia())
                                    .append(ce.NUMERO_CASA, cuidador.getDireccion().getnCasa()))
         .append(ce.TELEFONO, cuidador.getTelefono())
         .append(ce.FECHA_INGRESO, cuidador.getFechaIngreso())
         .append(ce.ESPECIES, cuidador.getEspecies());
        
        db.getCollection("Cuidadores").insertOne(d);
    }

    @Override
    public void eliminar(Cuidadores cuidador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
