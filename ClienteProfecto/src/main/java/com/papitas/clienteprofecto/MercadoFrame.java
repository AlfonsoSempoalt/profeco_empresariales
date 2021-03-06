/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.clienteprofecto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class MercadoFrame extends javax.swing.JFrame {
    private List<Sancion> sanciones;
    private DefaultTableModel modelo;
    /**
     * Creates new form ProfecoFrame
     */
    public MercadoFrame() {
        initComponents();
        this.setupComponents();
    }
    
    private void setupComponents(){
        this.setLocationRelativeTo(null);
        this.actualizar();
        
    }
    
    private void actualizar(){
        System.out.println("actualiza");
                this.generarTabla();
        HttpURLConnection connection;
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("http://localhost:8080/profeco/comercio");
            connection = (HttpURLConnection)url.openConnection();
            
            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            System.out.println(status);
            
            if(status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            
            while((line = reader.readLine()) != null){
                responseContent.append(line);
            }
            reader.close();
            String respuesta = responseContent.toString();
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<List<Sancion>>() {}.getType();
            this.sanciones = gson.fromJson(respuesta, type);
            this.cargarTabla();
        } catch (MalformedURLException ex ) {
            ex.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void generarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Asunto");
        modelo.addColumn("Descripci??n");
        modelo.addColumn("Castigos");
        modelo.addColumn("Multa");
        modelo.addColumn("Comercio");
        this.jtProductos.setModel(modelo);
    }
    
    private void cargarTabla(){
        this.generarTabla();
        String[] campos = new String[5];
        for(Sancion p : this.sanciones){
            campos[0] = p.getCabecera();
            campos[1] = p.getDescripcion();
            campos[2] = p.getCastigos();
            campos[3] = Double.toString(p.getMulta());
            campos[4] = p.getComercio();
            this.modelo.addRow(campos);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jbActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(317, 70));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sanciones");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(153, 0, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Asunto", "Descripcoin", "Castigos", "Multa"
            }
        ));
        jScrollPane1.setViewportView(jtProductos);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 510, 190));

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        this.actualizar();
    }//GEN-LAST:event_jbActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(MercadoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MercadoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MercadoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MercadoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MercadoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
}
