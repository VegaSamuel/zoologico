/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.main;


import org.itson.control.Control;
import org.itson.presentacion.MainWindow;

/**
 * Esta clase es la principal que se encarga solamente de iniciar el programa.
 * @author Samuel Vega
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control c = new Control();
        
        c.IngresarDatos();
        
        MainWindow main = new MainWindow();
        
        main.setVisible(true);
    }
    
}
