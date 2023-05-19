/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.DefaultComboBoxModel;
import org.itson.dominio.Habitats;

/**
 * Pantalla para registrar un hábitat
 * @author Samuel Vega
 */
public class RegistrarHabitat extends javax.swing.JDialog {
    private Habitats habitat;
    private DefaultComboBoxModel<String> listaClimas;
    private DefaultComboBoxModel<String> listaVegetacion;
    private DefaultComboBoxModel<String> listaContinentes;
    
    /**
     * Crea una ventana para registrar un hábitat
     * @param parent Ventana que la solicita
     * @param modal Definir si se enfoca o no esta ventana
     * @param habitat Hábitat sobre el que se actuará
     * @param listaClimas Lista de climas
     * @param listaVegetacion Lista de tipos de vegetación
     * @param listaContinentes Lista de continentes
     * @param respuesta Respuesta de la ventana
     */
    public RegistrarHabitat(java.awt.Frame parent, boolean modal, Habitats habitat, DefaultComboBoxModel listaClimas, DefaultComboBoxModel listaVegetacion, DefaultComboBoxModel listaContinentes, StringBuffer respuesta) {
        super(parent, modal);
        
        
        initComponents();
        centraCuadroDialogo(parent);
        setVisible(true);
    }
    
    private void centraCuadroDialogo(java.awt.Frame parent){
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        
        Dimension dlgSize = getPreferredSize();
        
        setLocation( (frameSize.width - dlgSize.width) / 2 + loc.x,
                     (frameSize.height - dlgSize.height) / 2 + loc.y);
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
        setTitle("Registrar Hábitat");

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
