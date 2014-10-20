/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import clases.DataBase;
import clases.Estado;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Access;

/**
 *
 * @author user
 */
public class Admin {

    DataBase db;
    Access a;

    public Admin() {
        db = new DataBase();
        a = new Access("test.db");
        a.openConnection();
    }

    public void cargarEstado(JComboBox[] cbo, JTable t) throws SQLException {

        ArrayList<Estado> estados = a.selectEstado();
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        for (int i = 0; i < estados.size(); i++) {
            estados.get(i);
            int id = estados.get(i).getId_estado();
            String des = estados.get(i).getDescripcion();
            for (JComboBox cbo1 : cbo) {
                cbo1.addItem(des);
            }

            model.addRow(new Object[]{id, des});
        }

    }

    public void agregarEstado(JTextField t) {

        if (t.getText().isEmpty()) {
            JOptionPane.showMessageDialog(t, "Debe colocar alguna descripcion");
        } else {
            String[] columnas = new String[1];
            columnas[0] = "id_estado";

            String[] values = new String[1];
            values[0] = t.getText();
            a.insertar("estado", columnas, values);
            t.setText("");
        }
    }
}
