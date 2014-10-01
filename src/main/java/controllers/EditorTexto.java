/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;

import org.languagetool.JLanguageTool;
import org.languagetool.language.Spanish;
import org.languagetool.rules.RuleMatch;
import java.awt.Color;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import components.*;

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
     
}
