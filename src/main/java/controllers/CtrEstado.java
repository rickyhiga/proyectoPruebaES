/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import clases.Estado;
import interfaces.IAtributos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ModelEstado;

/**
 *
 * @author user
 */
public class CtrEstado implements IAtributos {

    ModelEstado m;

    CtrEstado(String base) {
        m = new ModelEstado(base);
    }
    //Recibir un combo y un vector con cadena
    //Definir cargarCombos llamaria a cargarCombo individuales(control, de donde saco los datos) 
    @Override
    public void cargarCombo(JComboBox[] cbo) {
        for (JComboBox cbo1 : cbo) {

            cbo1.removeAllItems();
        }
        
        ArrayList<Estado> estados;
        try {
            estados = m.selectEstado();
            for (int i = 0; i < estados.size(); i++) {
                estados.get(i);
                String des = estados.get(i).getDescripcion();
                for (JComboBox cbo1 : cbo) {

                    cbo1.addItem(des);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrEstado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void cargarTabla(JTable t) {
        ArrayList<Estado> estados;
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try {
            estados = m.selectEstado();
            for (int i = 0; i < estados.size(); i++) {
                estados.get(i);
                int id = estados.get(i).getId_estado();
                String des = estados.get(i).getDescripcion();
                model.addRow(new Object[]{id, des});

            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrEstado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void insertar(JTextField t) {
//        String[] columnas = new String[1];
//        columnas[0] = "descripcion";
//
//        String[] values = new String[1];
//        values[0] = t.getText();
//        m.insertar("estado", columnas, values);
//        t.setText("");
//    }

    @Override
    public int insertar(String[] values) {
        String[] columnas = new String[1];
        columnas[0] = "descripcion";

        m.insertar("estado", columnas, values);
        try {
            return m.getMaxId("estado", "id_estado");
        } catch (SQLException ex) {
            Logger.getLogger(CtrEstado.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
