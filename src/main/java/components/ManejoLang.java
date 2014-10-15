/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import org.languagetool.JLanguageTool;
import org.languagetool.language.Spanish;
import org.languagetool.rules.RuleMatch;

/**
 *
 * @author user
 */
public class ManejoLang {

    Boolean tErrores;
    private JLanguageTool langT;

    public ManejoLang() {
        tErrores = true;
    }

    public void setTieneErrores(Boolean b) {
        tErrores=b;
    }

    public boolean getTieneErrores() {
        return tErrores;
    }

   
public String palabrasParaItem(String sin) throws IOException, BadLocationException {

        langT = new JLanguageTool(new Spanish());
        langT.activateDefaultPatternRules();
        List<RuleMatch> matches = null;
        StringBuilder acum = new StringBuilder("");
        try {
            matches = langT.check(sin);
            for (RuleMatch match : matches) {

                acum.append("" + match.getSuggestedReplacements() + "\n ");

                tErrores = true;
                acum.toString();
            }
            if (matches.isEmpty()) {
                tErrores = false;
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return acum.toString();

    }


    public void corregirArea(JTextArea sin, JTextArea cor) throws IOException, BadLocationException {
        cor.setText("");
        int p0, p1;
        //sin.setHighlighter(null);
        Highlighter highlighter = sin.getHighlighter();

        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        Highlighter.HighlightPainter painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        //HighlightPainter painter3 = new DefaultHighlighter.DefaultHighlightPainter(Color.WHITE);
        //highlighter.addHighlight(0, sin.getText().length(), painter3);
        highlighter.removeAllHighlights();
        langT = new JLanguageTool(new Spanish());
        langT.activateDefaultPatternRules();
        List<RuleMatch> matches = null;
        StringBuilder acum = new StringBuilder("");
        try {
            matches = langT.check(sin.getText());
            for (RuleMatch match : matches) {

                acum.append("Error en la linea " + match.getLine() + ", Columna " + match.getColumn() + ": ");
                acum.append(" Contexto(");
                int aux = match.getToPos() - match.getFromPos();
                acum.append(sin.getText(match.getFromPos(), aux) + ")");
                acum.append(match.getMessage());
                acum.append(" Corrección Sugerida: " + match.getSuggestedReplacements() + "\n ");
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
                tErrores = true;
                cor.setText(acum.toString());
            }
            if (matches.isEmpty()) {
                tErrores = false;
                cor.setText("No hay errores");
                
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }


}
