/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.main;

import org.bson.types.ObjectId;
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
        ObjectId id = new ObjectId("64647e635556241ae73bc6d4");
        
        ICuidadoresDAO cDAO = new CuidadoresDAO();
        
        System.out.println(cDAO.consultar(id));
    }
    
}
