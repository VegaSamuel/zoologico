/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.DefaultComboBoxModel;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Especies;
import org.itson.dominio.Habitats;
import org.itson.dominio.Zonas;

/**
 * Pantalla para registrar una especie
 * @author Samuel Vega
 */
public class RegistrarEspecie extends javax.swing.JDialog {
    private int operacion;
    private Especies especie;
    private DefaultComboBoxModel<Cuidadores> listaCuidadores;
    private DefaultComboBoxModel<Habitats> listaHabitats;
    private DefaultComboBoxModel<Zonas> listaZonas;
    private StringBuffer respuesta;
    
    
    public RegistrarEspecie(java.awt.Frame parent, boolean modal, int operacion, Especies especie, DefaultComboBoxModel<Cuidadores> listaCuidadores, DefaultComboBoxModel<Habitats> listaHabitats, DefaultComboBoxModel<Zonas> listaZonas, StringBuffer respuesta) {
        super(parent, modal);
        this.operacion = operacion;
        this.especie = especie;
        this.listaCuidadores = listaCuidadores;
        this.listaHabitats = listaHabitats;
        this.listaZonas = listaZonas;
        this.respuesta = respuesta;
        
        initComponents();
        
        centraCuadroDialogo(parent);
    }
    
    /**
     * Centra la ventana conforme a la ventana que solicito esta ventana
     * @param parent Ventana que solicito esta ventana
     */
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
