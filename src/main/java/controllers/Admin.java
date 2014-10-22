/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import clases.DataBase;
import clases.Estado;
import config.Config;
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

    
    String base=Config.dbPath;
    CtrEstado es;

    public Admin() {
        //a = new Access("test.db");
        es=new CtrEstado(base);

    }
    //QUE NO DEPENDA DE LA INTERFAZ cargarEstados
    public void cargarEstado(JComboBox[] cbo, JTable t) throws SQLException {
        
        es.cargarCombo(cbo);
        es.cargarTabla(t);

    }

    public boolean agregarEstado(JTextField t) {
        if (t.getText().isEmpty()) {

            return false;
        } else {
            String[] values=new String[1];
            values[0]=t.getText();
            es.insertar(values);
            return true;
        }
    }
}
