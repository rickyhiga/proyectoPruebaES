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
//DBAccessSQLite deberia llamarse
public abstract class Access extends AbstractDB {

    public Access(String dbFile) {
        super.dbPath.append(dbFile);
        super.crearTablas();
    }

    public int getMaxId(String tabla, String clave) throws SQLException{
        StringBuilder st = new StringBuilder("");
        st.append("SELECT MAX(");
        st.append(clave);
        st.append(") AS id FROM ");
        st.append(tabla);
        st.append(" LIMIT 1;");
        super.setQuery(st.toString());
        super.openConnection();
        int i = this.getIntFromQuery();
        super.closeConnection();
        return i;
    }

    private int getIntFromQuery() throws SQLException {

        ResultSet rows = super.getResultsFromQuery();
        int i = -1;
        if (rows.next()) {
            i = rows.getInt(1);
        }
        return i;
    }

    public int getId(String tabla, String clave, String condicion) throws SQLException {

        int id = -1;
        StringBuilder st = new StringBuilder("SELECT ");
        st.append(clave);
        st.append(" AS id FROM ");
        st.append(tabla);
        st.append(" WHERE ");
        st.append(condicion);
        st.append(";");
        super.setQuery(st.toString());
        super.openConnection();
        id = this.getIntFromQuery();
        //id_archivoArchivonombre=('" + nombre + "');";
        super.closeConnection();
        return id;
    }

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
        st.append("VALUES(");
        for (int i = 0; i < values.length; i++) {
            st.append("'");
            st.append(values[i]);
            st.append("'");
            if (i != values.length - 1) {

                st.append(", ");
            }
        }
        st.append(");");
        super.setQuery(st.toString());
        super.openConnection();
        super.executeSingleQuery();
        super.closeConnection();
    }

}
