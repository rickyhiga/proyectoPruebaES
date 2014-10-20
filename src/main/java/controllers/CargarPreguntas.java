/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import clases.DataBase;
import clases.ManejoLang;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 *
 * @author user
 */
public class CargarPreguntas {
   ManejoLang m = new ManejoLang();
   DataBase db=new DataBase();
    public void corregir(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {
        
        m.corregirArea(sin, cor);
    }
    public boolean getHayErrores(){
        return m.getTieneErrores();
    }
    public void setHayErrores(boolean b){
        m.setTieneErrores(b);
    }
    public boolean cargarPregunta(JTextArea pre, JTextArea res){
       boolean b=false;
        try {
           StringBuilder pr=new StringBuilder("INSERT INTO pregunta(descripcion) VALUES('" );
           pr.append(pre.getText());
           pr.append("');");
           db.ejecutar(pr.toString());
           StringBuilder num=new StringBuilder("select MAX(id_preg) as id from pregunta;");
           ResultSet rs=db.consulta(num.toString());
           int id=0;
           while(rs.next()){
               id=rs.getInt("id");
           }
           
           db.cerrarConsulta();
           System.out.println("id="+id);
           StringBuilder r=new StringBuilder("INSERT INTO respuesta(descripcion, id_preg) VALUES('" );
           r.append(res.getText());
           r.append("', ");
           r.append(id);
           r.append(");");
           db.ejecutar(r.toString());
           b=true;
           
       } catch (SQLException ex) {
           Logger.getLogger(CargarPreguntas.class.getName()).log(Level.SEVERE, null, ex);
           b=false;
       }
       return b;
    }
    
}
