/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import clases.DataBase;
import clases.ManejoLang;
import config.Config;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import model.Access;
import model.ModelPregunta;

/**
 *
 * @author user
 */
public class CargarPreguntas {

    ManejoLang m = new ManejoLang();
    DataBase db = new DataBase();

   // ModelPregunta p = new ModelPregunta;
    CtrPregunta preg=new CtrPregunta(Config.dbPath);
    CtrRespuesta resp=new CtrRespuesta(Config.dbPath);
    public void corregir(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {

        m.corregirArea(sin, cor);
    }

    public boolean getHayErrores() {
        return m.getTieneErrores();
    }

    public void setHayErrores(boolean b) {
        m.setTieneErrores(b);
    }

    public void cargarPregunta(JTextArea pre, JTextArea res) throws SQLException {
       
        String[] values = new String[1];
        values[0] = pre.getText();
       int id= preg.insertar(values);
        
       
        String[] val = new String[2];
        val[0]=res.getText();
        
        val[1]= Integer.toString(id);
        int i=resp.insertar(val);
      
    }

}
