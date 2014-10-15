/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import components.DataBase;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Admin {

    DataBase db;

    public Admin() {
        db = new DataBase();
    }

    public void cargarEstado(JComboBox[] cbo, JTable t) {
        try {
            String sql = "SELECT * FROM estado";
            ResultSet rs = db.consulta(sql);
            DefaultTableModel model = (DefaultTableModel) t.getModel();

            while (rs.next()) {
                int id = rs.getInt("id_estado");
                String des = rs.getString("descripcion");
                for (int i = 0; i < cbo.length; i++) {
                    cbo[i].addItem(des);
                }

                model.addRow(new Object[]{id, des});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.cerrarConsulta();

    }

    public void agregarEstado(JTextField t) {
        if(t.getText().isEmpty()){
            JOptionPane.showMessageDialog(t, "Debe colocar alguna descripcion");
        }else{
            String sql = "INSERT INTO estado(descripcion) VALUES('" + t.getText() + "');";
            
            System.out.println(sql);
            db.ejecutar(sql);
            
            t.setText("");
        }
    }
}
