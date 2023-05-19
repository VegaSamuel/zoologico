/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Direccion;
import org.itson.dominio.Especies;
import org.itson.implementaciones.CuidadoresDAO;
import org.itson.interfaces.ICuidadoresDAO;

/**
 * Esta clase es la principal que se encarga solamente de iniciar el programa.
 * @author Samuel Vega
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectId id = new ObjectId("6466f3f2d9f20116a942da16");
        
        List<Especies> es = new ArrayList<>();
        
        Cuidadores c = new Cuidadores("Carlos", new Direccion("Santa Clara", "Queti", "12345"), "64423547678", new Date(), es);
        
        ICuidadoresDAO cDAO = new CuidadoresDAO();
        
        cDAO.insertar(c);
        
//        System.out.println(cDAO.consultar(id));
        
//        cDAO.eliminar(id);
    }
    
}
