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
import model.ModelRespuesta;

/**
 *
 * @author user
 */
public class CtrRespuesta implements IAtributos {

    ModelRespuesta res;

    public CtrRespuesta(String db) {
        res = new ModelRespuesta(db);
    }

    @Override
    public int insertar(String[] values) {
        String[] colum = new String[2];

        colum[0] = "descripcion";
        colum[1] = "id_preg";
        res.insertar("respuesta", colum, values);
        try {
            return res.getMaxId("respuesta", "id_res");
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
