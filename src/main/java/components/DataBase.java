/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DataBase {

    Connection c;
    Statement stmt;
    String archivo = "jdbc:sqlite:C:\\Users\\user\\Documents\\RickyFacu\\2014\\Investigacion\\es\\test.db";

    public DataBase() {
        this.c = null;
        this.stmt = null;
    }

    public DataBase(Connection c, Statement stmt) {
        this.c = c;
        this.stmt = stmt;
    }

    public ResultSet consulta(String sql) {
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(archivo);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        System.out.println("Operation done successfully");
        return rs;
    }

    public void cerrarConsulta() {
        try {
            stmt.close();
            c.commit();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejecutar(String sql) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(archivo);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
