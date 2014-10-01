/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import components.ManejoLang;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 *
 * @author user
 */
public class CargarPreguntas {
   ManejoLang m = new ManejoLang();
    public void corregir(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {
        
        m.corregirArea(sin, cor);
    }
    public boolean getHayErrores(){
        return m.getTieneErrores();
    }
}
