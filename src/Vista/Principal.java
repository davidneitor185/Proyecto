/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.InfectadoControlador;
import Controlador.PersonaContolador;
import Controlador.RelacionadoControlador;
import Graficos.Grafico;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ChatServer;
import modelo.HiloGraficos;
import modelo.Infectado;
import modelo.InfectadoDAO;
import modelo.PersonaDAO;
import modelo.RelacionadoDAO;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Victor
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form Principal */
    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Grafico grafico=new Grafico();
        
        Runnable r = new HiloGraficos(grafico, this.jDesktopPane1);
        Thread hilo = new Thread(r);
        hilo.start();        
    }
    
        
    
    
    public void agregar(RelacionadoIG vista){
        this.add(vista);    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuChat = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenuItem();
        Server = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid-19 (TODOS MORIREMOS)");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        jMenu1.setText("Programa");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Persona");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Infectado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        menuAyuda.setText("Ayuda");

        menuChat.setText("Chat");

        menuCliente.setText("Cliente");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        menuChat.add(menuCliente);

        Server.setText("Operador");
        Server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerActionPerformed(evt);
            }
        });
        menuChat.add(Server);

        menuAyuda.add(menuChat);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

                                             

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        PersonaIG vista = new PersonaIG();
        PersonaDAO modelo = new PersonaDAO();

        PersonaContolador controlador = new PersonaContolador(modelo, vista);

        int x = (jDesktopPane1.getWidth() / 2) - vista.getWidth() /2;
        int y = (jDesktopPane1.getHeight() / 2) - vista.getHeight() /2;

        if (vista.isShowing()){
            vista.setLocation(x,y);
        }
        else{
            jDesktopPane1.add(vista);
            vista.setLocation(x,y);
            vista.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        String nombre = JOptionPane.showInputDialog(null,"Por favor ingrese su nombre");
        ChatCliente cliente = new ChatCliente (nombre);
        int x = (jDesktopPane1.getWidth() / 2) - cliente.getWidth() /2;
        int y = (jDesktopPane1.getHeight() / 2) - cliente.getHeight() /2;
        
        if (cliente.isShowing()){
            cliente.setLocation(x,y);
        }
        else{
            jDesktopPane1.add(cliente);
            cliente.setLocation(x,y);
            cliente.setVisible(true);
        }
    }//GEN-LAST:event_menuClienteActionPerformed

    private void ServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerActionPerformed
        ChatServer server = new ChatServer(9999);
    }//GEN-LAST:event_ServerActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
                                           
        InfectadoIG vista = new InfectadoIG();
        InfectadoDAO modelo = new InfectadoDAO();

        InfectadoControlador controlador = new InfectadoControlador(modelo, vista);

        int x = (jDesktopPane1.getWidth() / 2) - vista.getWidth() /2;
        int y = (jDesktopPane1.getHeight() / 2) - vista.getHeight() /2;

        if (vista.isShowing()){
            vista.setLocation(x,y);
        }
        else{
            jDesktopPane1.add(vista);
            vista.setLocation(x,y);
            vista.setVisible(true);
        }
        
       
     
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Server;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuChat;
    private javax.swing.JMenuItem menuCliente;
    // End of variables declaration//GEN-END:variables

}
