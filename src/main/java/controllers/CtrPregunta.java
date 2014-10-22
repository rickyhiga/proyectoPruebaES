/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.IAtributos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import model.ModelPregunta;

/**
 *
 * @author user
 */
public class CtrPregunta implements IAtributos {

    ModelPregunta p;

    public CtrPregunta(String base) {
        p = new ModelPregunta(base);
    }

    @Override
    public int insertar(String[] values) {
        String[] columnas = new String[1];
        columnas[0] = "descripcion";

        p.insertar("pregunta", columnas, values);
        try {
            return p.getMaxId("pregunta", "id_preg");
        } catch (SQLException ex) {
            Logger.getLogger(CtrEstado.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public void cargarCombo(JComboBox[] cbo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarTabla(JTable t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
