/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.swing.JTextArea;

import org.languagetool.JLanguageTool;
import javax.swing.text.BadLocationException;
import components.*;
import java.util.List;

/**
 *
 * @author user
 */
public class EditorTexto {

    private JLanguageTool langT;
    private String acu = "";

    public void corregir(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {
        ManejoLang m = new ManejoLang();
        m.corregirArea(sin, cor);
    }

    public String palabrasParaItem(String sin) throws IOException, BadLocationException {
        ManejoLang n = new ManejoLang();
        return n.palabrasParaItem(sin);
    }
}
