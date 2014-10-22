/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import clases.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ModelEstado extends Access {

    public ModelEstado(String dbFile) {
        super(dbFile);
    }
    //getEstados
    public ArrayList selectEstado() throws SQLException {

        System.out.println("SelectEstado");
        ArrayList<Estado> estados = new ArrayList<>();
        super.openConnection();
        try {
            ResultSet res = null;
            String sql = "SELECT * FROM estado";
            super.setQuery(sql);
            res = super.getResultsFromQuery();
            while (res.next()) {
                int id = res.getInt("id_estado");
                String des = res.getString("descripcion");
                Estado es = new Estado(id, des);
                estados.add(es);
                //System.out.println(des);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en cargar estado: " + ex.toString());
        } finally {
            super.closeConnection();
        }
        return estados;
    }

    
}
