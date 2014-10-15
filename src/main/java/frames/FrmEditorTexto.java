/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import components.DocumentSizeFilter;
import components.LeerPregunta;
import controllers.EditorTexto;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.BadLocationException;
import static org.apache.commons.lang.StringUtils.split;
//import components.DocumentSizeFilter;

/**
 *
 * @author user
 */
public class FrmEditorTexto extends javax.swing.JFrame {

    /**
     * Creates new form EditorTexto
     */
    private int max = 20;
    private DefaultStyledDocument doc;

    public FrmEditorTexto() throws IOException {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        doc = new DefaultStyledDocument();
        doc.setDocumentFilter(new DocumentSizeFilter(max));
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCount();
            }
        });
        txtAreaRespuesta.setDocument(doc);

        updateCount();

        setLocationRelativeTo(null);
        pack();
        LeerPregunta lp = new LeerPregunta();
        try {
            lblPregunta.setText(lp.Pregunta());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        //txtFieldPregunta.setEditable(false);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRespuesta = new javax.swing.JTextArea();
        btnSiguiente = new javax.swing.JButton();
        btnCorregir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCaracRest = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaCorreccion = new javax.swing.JTextArea();
        btnAgEx = new javax.swing.JButton();
        lblNumeroPregunta = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAreaRespuesta.setColumns(20);
        txtAreaRespuesta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtAreaRespuesta.setLineWrap(true);
        txtAreaRespuesta.setRows(5);
        txtAreaRespuesta.setText("Escriba un texto aquí. LanguageTool le ayudará a afrentar algunas dificultades propias de la escritura. \nSe a hecho un esfuerzo para detectar errores tipográficos, ortograficos y incluso gramaticales. También algunos errores de estilo, a grosso modo.");
        txtAreaRespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAreaRespuestaMouseClicked(evt);
            }
        });
        txtAreaRespuesta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                none(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(txtAreaRespuesta);

        btnSiguiente.setText("Siguiente");

        btnCorregir.setText("Corregir");
        btnCorregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Recuerda que la respuesta no debe poseer errores ortográficos ni sintácticos.");

        lblCaracRest.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCaracRest.setForeground(new java.awt.Color(0, 0, 204));
        lblCaracRest.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCaracRest.setText("140");

        jLabel4.setText("Caracteres Restantes");

        txtAreaCorreccion.setColumns(20);
        txtAreaCorreccion.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        txtAreaCorreccion.setRows(5);
        txtAreaCorreccion.setEnabled(false);
        jScrollPane2.setViewportView(txtAreaCorreccion);

        btnAgEx.setText("Agregar Excepción");
        btnAgEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgExActionPerformed(evt);
            }
        });

        lblNumeroPregunta.setText("1");

        lblPregunta.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgEx, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaracRest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCorregir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumeroPregunta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPregunta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroPregunta)
                    .addComponent(lblPregunta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnCorregir)
                    .addComponent(lblCaracRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgEx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorregirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregirActionPerformed
        try {
            EditorTexto et = new EditorTexto();
            et.corregir(txtAreaRespuesta, txtAreaCorreccion);
        } catch (IOException ex) {
            Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCorregirActionPerformed

    private void btnAgExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgExActionPerformed
        FrmAgregarExcepcion ae = new FrmAgregarExcepcion();
        ae.show();
        ae.setLocationRelativeTo(null);
//        ae.setPadre(this);
    }//GEN-LAST:event_btnAgExActionPerformed
    int i = 0;
    private void txtAreaRespuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAreaRespuestaMouseClicked
        Robot bot;

        int mask = InputEvent.BUTTON1_MASK;

        if (SwingUtilities.isRightMouseButton(evt)) {
            try {
                System.out.println("click derecho");
                bot = new Robot();

                bot.mousePress(mask);
                bot.delay(1);
                bot.mouseRelease(mask);
                bot.mousePress(mask);
                bot.delay(1);
                bot.mouseRelease(mask);

            } catch (AWTException ex) {
                Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            i++;
            System.out.println("click izquierdo" + i);
            if (i == 2) {
                int inicioPalabra = txtAreaRespuesta.getCaret().getMark();
                int finPalabra = txtAreaRespuesta.getCaret().getDot();
                int cantidadCaracteres = finPalabra - inicioPalabra;
                int cursorX = evt.getXOnScreen();
                int cursorY = evt.getYOnScreen();

                try {
                    Mostrar(inicioPalabra, cantidadCaracteres, cursorX, cursorY);
                } catch (BadLocationException ex) {
                    Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
                i = 0;

            }

        }


    }//GEN-LAST:event_txtAreaRespuestaMouseClicked

    private void none(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

//    public void closeChild(){
//        ae.dispose();
//    }
     public void Mostrar(int inicioPalabra, int LargoPalabra, int x, int y) throws BadLocationException, IOException {

        final int posI = inicioPalabra, posF = LargoPalabra, finalPalabra = posI + posF;
        EditorTexto ed = new EditorTexto();

        final JPopupMenu popup = new JPopupMenu();

        for (final String retval : ed.palabrasParaItem(doc.getText(posI, posF)).split("[^A-Za-z_0-9]")) {

            if ("".equals(ed.palabrasParaItem(doc.getText(posI, posF)))) {

            } else {
                final JMenuItem item = new JMenuItem(retval);
                item.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        try {

                            doc.replace(posI, posF, retval.toString(), null);

                            popup.setVisible(false);

                        } catch (BadLocationException ex) {
                            Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                popup.add(item);
            }

        }
        if (ed.palabrasParaItem(doc.getText(posI, posF)) != "") {
            popup.setVisible(true);

            popup.setLocation(x, y);
            popup.getMouseListeners();
        }

    }

    private void updateCount() {

        lblCaracRest.setText(Integer.toString(max - doc.getLength()));
    }

  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmEditorTexto().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgEx;
    private javax.swing.JButton btnCorregir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCaracRest;
    private javax.swing.JLabel lblNumeroPregunta;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JTextArea txtAreaCorreccion;
    private javax.swing.JTextArea txtAreaRespuesta;
    // End of variables declaration//GEN-END:variables
}
