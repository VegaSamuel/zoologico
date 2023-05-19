/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 * Define las conversiones de los comboboxes y tablas
 * @author Samuel Vega
 */
public class Conversiones {
    
    public DefaultComboBoxModel<String> comboBoxClimas(List<String> listaClimas) {
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaClimas != null) {
            for(int i=0; i < listaClimas.size(); i++) {
                defaultComboBoxModel.addElement(listaClimas.get(i));
            }
            return defaultComboBoxModel;
        }
        
        return null;
    }
    
    public DefaultComboBoxModel<String> comboBoxVegetacion(List<String> listaVegetacion) {
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaVegetacion != null) {
            for(int i=0; i < listaVegetacion.size(); i++) {
                defaultComboBoxModel.addElement(listaVegetacion.get(i));
            }
            return defaultComboBoxModel;
        }
        
        return null;
    }
    
    public DefaultComboBoxModel<String> comboBoxContinentes(List<String> listaContinentes) {
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaContinentes != null) {
            for(int i=0; i < listaContinentes.size(); i++) {
                defaultComboBoxModel.addElement(listaContinentes.get(i));
            }
            return defaultComboBoxModel;
        }
        
        return null;
    }
}
