/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public interface IAtributos {
    public int insertar(String[] values);
    public void cargarCombo(JComboBox[] cbo);
    public void cargarTabla(JTable t);
}
