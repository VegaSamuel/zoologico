/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.itson.dominio.Cuidadores;
import org.itson.dominio.Guias;
import org.itson.dominio.Habitats;
import org.itson.dominio.Zonas;

/**
 * Define las conversiones de los comboboxes y tablas
 * @author Samuel Vega
 */
public class Conversiones {
    
    //Definidores de modelo de Combo Box necesarios
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
    
    public DefaultComboBoxModel<Cuidadores> comboBoxCuidadores(List<Cuidadores> listaCuidadores) {
        DefaultComboBoxModel<Cuidadores> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaCuidadores != null) {
            for(int i=0; i < listaCuidadores.size(); i++) {
                defaultComboBoxModel.addElement(listaCuidadores.get(i));
            }
            return defaultComboBoxModel;
        }
                
        return null;
    }
    
    public DefaultComboBoxModel<Habitats> comboBoxHabitats(List<Habitats> listaHabitats) {
        DefaultComboBoxModel<Habitats> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaHabitats != null) {
            for(int i=0; i < listaHabitats.size(); i++) {
                defaultComboBoxModel.addElement(listaHabitats.get(i));
            }
            return defaultComboBoxModel;
        }
                
        return null;
    }
    
    public DefaultComboBoxModel<Zonas> comboBoxZonas(List<Zonas> listaZonas) {
        DefaultComboBoxModel<Zonas> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaZonas != null) {
            for(int i=0; i < listaZonas.size(); i++) {
                defaultComboBoxModel.addElement(listaZonas.get(i));
            }
            return defaultComboBoxModel;
        }
                
        return null;
    }
    
    public DefaultComboBoxModel<Guias> comboBoxGuias(List<Guias> listaGuias) {
        DefaultComboBoxModel<Guias> defaultComboBoxModel = new DefaultComboBoxModel();
        
        if(listaGuias != null) {
            for(int i=0; i < listaGuias.size(); i++) {
                defaultComboBoxModel.addElement(listaGuias.get(i));
            }
            return defaultComboBoxModel;
        }
                
        return null;
    }
}
