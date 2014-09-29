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

/**
 *
 * @author user
 */
public class EditorTexto {

    private JLanguageTool langT;
    private String acu = "";

    public void corregir(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {
        cor.setText("");
        int p0, p1;
        //sin.setHighlighter(null);
        Highlighter highlighter = sin.getHighlighter();

        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        HighlightPainter painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        //HighlightPainter painter3 = new DefaultHighlighter.DefaultHighlightPainter(Color.WHITE);
        //highlighter.addHighlight(0, sin.getText().length(), painter3);
        highlighter.removeAllHighlights();
        langT = new JLanguageTool(new Spanish());
        langT.activateDefaultPatternRules();
        List<RuleMatch> matches;
        try {
            matches = langT.check(sin.getText());
            for (RuleMatch match : matches) {              

                p0 = match.getFromPos();
                p1 = match.getToPos();
                if (match.getShortMessage().equalsIgnoreCase("Error de ortografía")) {
                    highlighter.addHighlight(p0, p1, painter);
                    sin.append(" ");
                    //highlighter.changeHighlight(painter, p0, p1);

                } else {
                    highlighter.addHighlight(p0, p1, painter2);
                    sin.append(" ");
                }

            }
            cor.setText(acu);

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public int corregirPregunta(JTextArea sin) throws IOException, BadLocationException {
        int p0, p1,insertar = 0;
        Highlighter highlighter = sin.getHighlighter();

        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        HighlightPainter painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        //HighlightPainter painter3 = new DefaultHighlighter.DefaultHighlightPainter(Color.WHITE);
        //highlighter.addHighlight(0, sin.getText().length(), painter3);
        highlighter.removeAllHighlights();
        langT = new JLanguageTool(new Spanish());
        langT.activateDefaultPatternRules();
        List<RuleMatch> matches;
        try {
            matches = langT.check(sin.getText());
            for (RuleMatch match : matches) {

                acu += " Error en la línea "
                        + match.getLine() + ", columna "
                        + match.getColumn() + ": ";
                acu += " Contexto(";
                int aux = match.getToPos() - match.getFromPos();
                acu += sin.getText(match.getFromPos(), aux) + ")";

                acu += match.getMessage()
                        + (" Corrección Sugerida: " + match.getSuggestedReplacements() + "\n ");

                p0 = match.getFromPos();
                p1 = match.getToPos();
                if (match.getShortMessage().equalsIgnoreCase("Error de ortografía")) {
                    highlighter.addHighlight(p0, p1, painter);
                    sin.append(" ");
                    //highlighter.changeHighlight(painter, p0, p1);

                } else {
                    highlighter.addHighlight(p0, p1, painter2);
                    sin.append(" ");
                }

            }
            if (!matches.isEmpty()) {
                insertar=1;
            }
            

        } catch (IOException ex) {
            System.out.println(ex);
        }
        
return insertar;
    }

}
