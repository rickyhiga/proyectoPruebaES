/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.Estado;
import config.AbstractDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Access extends AbstractDB {

    public Access(String dbFile) {
        super.dbPath.append(dbFile);
        super.crearTablas();
    }

    public int getMaxId(String tabla, String clave) {
        StringBuilder st = new StringBuilder("");
        st.append("SELECT MAX(");
        st.append(clave);
        st.append(") AS id FROM ");
        st.append(tabla);
        st.append(" LIMIT 1;");
        super.setQuery(st.toString());
        return super.getIntFromQuery();
    }

    public int getId(String tabla, String clave, String condicion) {
        int id = -1;
        StringBuilder st = new StringBuilder("SELECT ");
        st.append(clave);
        st.append(" AS id FROM ");
        st.append(tabla);
        st.append(" WHERE ");
        st.append(condicion);
        st.append(";");
        super.setQuery(st.toString());
        id = super.getIntFromQuery();
        //id_archivoArchivonombre=('" + nombre + "');";
        return id;
    }

//    public void insertPoA(String tabla, String valor) {
//        StringBuilder st = new StringBuilder("");
//        st.append("INSERT INTO ");
//        st.append(tabla);
//        st.append("(nombre) VALUES('");
//        st.append(valor);
//        st.append("');");
//        super.setQuery(st.toString());
//        super.executeSingleQuery();
//    }

    @Override
    public void insertar(String tabla, String[] columnas, String[] values) {
        StringBuilder st = new StringBuilder("");
        st.append("INSERT INTO ");
        st.append(tabla);
        st.append("(");
        for (int i = 0; i < columnas.length; i++) {
            st.append(columnas[i]);
            if (i != columnas.length - 1) {
                st.append(", ");
            }
        }
        st.append(") ");
        st.append("VALUES('");
        for (int i = 0; i < values.length; i++) {
            st.append(values[i]);
            if (i != values.length - 1) {
                st.append(", ");
            }
        }
        st.append("');");
        super.setQuery(st.toString());
        super.executeSingleQuery();
    }
    public ArrayList selectEstado() throws SQLException{
        System.out.println("SelectEstado");
        ArrayList<Estado> estados=new ArrayList<>();
        try {
            ResultSet res=null;
            String sql = "SELECT * FROM estado";
            super.setQuery(sql);
            res=super.getResultsFromQuery();
            while (res.next()) {
                int id = res.getInt("id_estado");
                String des = res.getString("descripcion");
                Estado es=new Estado(id, des);
                estados.add(es);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en cargar estado: "+ex.toString());
        }
        
        return estados;
    }
    

}
