/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.itson.dominio.Habitats;

/**
 * Pantalla para registrar un hábitat
 * @author Samuel Vega
 */
public class RegistrarHabitat extends javax.swing.JDialog {
    private int operacion;
    private Habitats habitat;
    private DefaultComboBoxModel<String> listaClimas;
    private DefaultComboBoxModel<String> listaVegetacion;
    private DefaultComboBoxModel<String> listaContinentes;
    private StringBuffer respuesta;
    
    /**
     * Crea una ventana para registrar un hábitat
     * @param parent Ventana que la solicita
     * @param modal Definir si se enfoca o no esta ventana
     * @param operacion Lo que se quiere hacer con la pantalla
     * @param habitat Hábitat sobre el que se actuará
     * @param listaClimas Lista de climas
     * @param listaVegetacion Lista de tipos de vegetación
     * @param listaContinentes Lista de continentes
     * @param respuesta Respuesta de la ventana
     */
    public RegistrarHabitat(java.awt.Frame parent, boolean modal, int operacion, Habitats habitat, DefaultComboBoxModel listaClimas, DefaultComboBoxModel listaVegetacion, DefaultComboBoxModel listaContinentes, StringBuffer respuesta) {
        super(parent, modal);
        this.operacion = operacion;
        this.habitat = habitat;
        this.listaClimas = listaClimas;
        this.listaVegetacion = listaVegetacion;
        this.listaContinentes = listaContinentes;
        this.respuesta = respuesta;
        
        initComponents();
        
        if(operacion == ConstantesGUI.AGREGAR) {
            txtNombre.setText(habitat.getNombre());
            txtNombre.setEditable(false);
        }
        
        if(operacion == ConstantesGUI.DESPLEGAR) {
            txtNombre.setText(habitat.getNombre());
            cbxClima.setSelectedItem(habitat.getClima());
            cbxVegetacion.setSelectedItem(habitat.getTipoVegetacion());
            cbxContinentes.setSelectedItem(habitat.getContinente().get(0));
            txtNombre.setEditable(false);
            cbxClima.setEnabled(false);
            cbxVegetacion.setEnabled(false);
            cbxContinentes.setEnabled(false);
            
            btnRegistrar.setEnabled(false);
            btnCancelar.setText("Volver");
        }
        
        respuesta.append(ConstantesGUI.CANCELAR);
        centraCuadroDialogo(parent);
        setVisible(true);
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

        lblNombre = new javax.swing.JLabel();
        lblClima = new javax.swing.JLabel();
        lblVegetacion = new javax.swing.JLabel();
        lblContinentes = new javax.swing.JLabel();
        cbxVegetacion = new javax.swing.JComboBox<>();
        cbxClima = new javax.swing.JComboBox<>();
        cbxContinentes = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Hábitat");

        lblNombre.setText("Nombre");

        lblClima.setText("Clima");

        lblVegetacion.setText("Tipo de vegetación");

        lblContinentes.setText("Continentes");

        cbxVegetacion.setModel(listaVegetacion);

        cbxClima.setModel(listaClimas);

        cbxContinentes.setModel(listaContinentes);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVegetacion)
                            .addComponent(lblNombre)
                            .addComponent(lblClima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContinentes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxVegetacion, 0, 118, Short.MAX_VALUE)
                            .addComponent(cbxClima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxContinentes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClima)
                    .addComponent(cbxClima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVegetacion)
                    .addComponent(cbxVegetacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContinentes)
                    .addComponent(cbxContinentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(operacion == ConstantesGUI.AGREGAR) {
            habitat.setClima((String) cbxClima.getSelectedItem());
            habitat.setTipoVegetacion((String) cbxVegetacion.getSelectedItem());
            habitat.setContinente((List<String>) Arrays.asList((String) cbxContinentes.getSelectedItem()));
        }
        
        respuesta.delete(0, respuesta.length());
        respuesta.append(ConstantesGUI.ACEPTAR);
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxClima;
    private javax.swing.JComboBox<String> cbxContinentes;
    private javax.swing.JComboBox<String> cbxVegetacion;
    private javax.swing.JLabel lblClima;
    private javax.swing.JLabel lblContinentes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblVegetacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
