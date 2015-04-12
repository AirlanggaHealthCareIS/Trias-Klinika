/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * History_RekamMedis.java
 *
 * Created on Mar 28, 2015, 2:22:41 PM
 */
package trias.klinika.client.dokter;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.client.tabel.tabelrekammedis;
import trias.klinika.api.entitas.rekammedisEntyty;

/**
 *
 * @author Acer
 */
public class History_RekamMedis extends javax.swing.JFrame {
    serviceRekam sr;
    private tabelrekammedis rm = new tabelrekammedis();
    
    
    /** Creates new form History_RekamMedis */
    public History_RekamMedis(serviceRekam sr, String Id) {
        this.sr = sr;
        try {
            rm.setData(this.sr.getdatarekam(Id));
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
        initComponents();
        history.setModel(rm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        detail = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 0, 51));
        setEnabled(false);
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setUndecorated(true);

        history.setFont(new java.awt.Font("Times New Roman", 0, 12));
        history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_rekam", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(history);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Pictures\\11119885_1044200968941754_593227732_n.jpg")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel4.setText("HISTORY REKAM MEDIS");

        detail.setFont(new java.awt.Font("Times New Roman", 0, 12));
        detail.setText("DETAIL");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(detail)
                        .addGap(119, 119, 119))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addGap(59, 59, 59)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(detail)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel4)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
    if (history.getSelectedRow() == -1){
          JOptionPane.showMessageDialog(this, "Pilih History Rekam Medis yang ingin dilihat terlebih dahulu");
    }
    else {
        int row = history.getSelectedRow();
        rekammedisEntyty re = rm.get(row);
        detail_rekam_medis drm = null;
            try {
                drm = new detail_rekam_medis(sr,re.getId_rekam());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        drm.setTitle(this.getTitle());
      drm.setLocation(500, 200);
       drm.setVisible(true);
       this.dispose();
    }
}//GEN-LAST:event_detailActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detail;
    private javax.swing.JTable history;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}