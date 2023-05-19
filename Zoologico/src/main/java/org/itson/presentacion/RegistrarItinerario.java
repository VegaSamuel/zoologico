/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Pantalla para registrar un itinerario
 * @author Samuel Vega
 */
public class RegistrarItinerario extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarItinerario
     */
    public RegistrarItinerario() {
        initComponents();
        centrarVentana();
    }

    private void centrarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Dimension frameSize = getSize();
        
        if(frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        
        if(frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        
        setLocation((screenSize.width - frameSize.width) / 2, 
                    (screenSize.height - frameSize.height) / 2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
