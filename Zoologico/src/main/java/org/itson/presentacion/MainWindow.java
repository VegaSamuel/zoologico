/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.itson.control.Control;

/**
 * Ventana Principal
 * @author Samuel Vega
 */
public class MainWindow extends javax.swing.JFrame {
    Control control = new Control();
    
    /**
     * Creates new form Main
     */
    public MainWindow() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        menuOpcionRegistrarHabitat = new javax.swing.JMenuItem();
        menuOpcionRegistrarEspecie = new javax.swing.JMenuItem();
        menuOpcionRegistrarItinerario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuOpcionSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Zoológico");

        menuOpciones.setText("Opciones");

        menuOpcionRegistrarHabitat.setText("Registrar Hábitat");
        menuOpcionRegistrarHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcionRegistrarHabitatActionPerformed(evt);
            }
        });
        menuOpciones.add(menuOpcionRegistrarHabitat);

        menuOpcionRegistrarEspecie.setText("Registrar Especie");
        menuOpcionRegistrarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcionRegistrarEspecieActionPerformed(evt);
            }
        });
        menuOpciones.add(menuOpcionRegistrarEspecie);

        menuOpcionRegistrarItinerario.setText("Registrar Itinerario");
        menuOpciones.add(menuOpcionRegistrarItinerario);
        menuOpciones.add(jSeparator1);

        menuOpcionSalir.setText("Salir");
        menuOpcionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcionSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(menuOpcionSalir);

        jMenuBar1.add(menuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuOpcionSalirActionPerformed

    private void menuOpcionRegistrarHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionRegistrarHabitatActionPerformed
        if(control.recuperarDatosRegistroHabitat(this)) {
            control.registrarHabitat(this);
        }
    }//GEN-LAST:event_menuOpcionRegistrarHabitatActionPerformed

    private void menuOpcionRegistrarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionRegistrarEspecieActionPerformed
        RegistrarEspecie re = new RegistrarEspecie();
        re.setVisible(true);
    }//GEN-LAST:event_menuOpcionRegistrarEspecieActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuOpcionRegistrarEspecie;
    private javax.swing.JMenuItem menuOpcionRegistrarHabitat;
    private javax.swing.JMenuItem menuOpcionRegistrarItinerario;
    private javax.swing.JMenuItem menuOpcionSalir;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables
}
