/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.WindowConstants;

/**
 *
 * @author user
 */
public class FrmAgregarExcepcion extends javax.swing.JFrame {

    FrmEditorTexto p;

    /**
     * Creates new form FrmAgregarExcepcion
     */
    public FrmAgregarExcepcion() {
        initComponents();
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFieldPalabra = new javax.swing.JTextField();
        cmdAgEx = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Agregar una excepción al diccionario");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Palabra:");

        txtFieldPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPalabraActionPerformed(evt);
            }
        });

        cmdAgEx.setText("Agregar");
        cmdAgEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgExActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldPalabra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(cmdAgEx)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(cmdAgEx)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPalabraActionPerformed

    private void cmdAgExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgExActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "La palabra a agregar es: " + txtFieldPalabra.getText(), "ATENCIÓN", OK_CANCEL_OPTION);
        if (dialogResult == JOptionPane.OK_OPTION) {
            try {
                
                
                BufferedWriter ofile;
                
                ofile = new BufferedWriter(new FileWriter("C:\\Users\\user\\Documents\\RickyFacu\\2014\\Investigacion\\es\\src\\main\\resources\\org\\languagetool\\resource\\es\\hunspell\\ignore.txt", true));
                   ofile.newLine();
                   ofile.append("\n" + txtFieldPalabra.getText());
                
                
                
                ofile.close();
                
//                p.closeChild(this);
            } catch (IOException ex) {
                Logger.getLogger(FrmAgregarExcepcion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdAgExActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FrmAgregarExcepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarExcepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarExcepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarExcepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgregarExcepcion().setVisible(true);
            }
        });
    }

//    private class ExitListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
////              p.closeChild();
//            setVisible(false);
////            dispose();
//        }
//    }

//    public void setPadre(FrmEditorTexto o) {
//        p = o;
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAgEx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtFieldPalabra;
    // End of variables declaration//GEN-END:variables
}