
package trias.klinika.client.apotek;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.LaporanKeuanganApotekEntitas;
import trias.klinika.api.sevice.LaporanKeuanganService;
import trias.klinika.client.tabel.TabelLaporanKeuanganApotek;


public class LaporanKeuanganApotek extends javax.swing.JInternalFrame {

   private LaporanKeuanganService LKS;
    private String [] isi;
    private String TGL_PEMERIKSAAN;
    private int ID_RESEP;
    private String ID_APOTEK;
    private int TOTAL_HARGA;
    private TabelLaporanKeuanganApotek TLKA = new TabelLaporanKeuanganApotek();
    
    public LaporanKeuanganApotek(LaporanKeuanganService LKS) throws RemoteException {
       this.LKS = LKS;
        initComponents();
        tabelKeuangan.setVisible(false);
     
        
        
    }
    public LaporanKeuanganApotek() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKeuangan = new javax.swing.JTable();
        lkeuangan = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setMinimumSize(new java.awt.Dimension(1145, 557));
        setPreferredSize(new java.awt.Dimension(1145, 557));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("LAPORAN KEUANGAN APOTEKER");

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabelKeuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "iis", "ndut", "cantik", "dibajak :D"
            }
        ));
        jScrollPane1.setViewportView(tabelKeuangan);

        lkeuangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Harian", "Bulanan", "Tahunan" }));
        lkeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lkeuanganActionPerformed(evt);
            }
        });

        jLabel2.setText("Jenis        =");

        jButton1.setText("Cetak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jButton1)
                                .addGap(62, 62, 62)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lkeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(704, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lkeuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lkeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lkeuanganActionPerformed
        if (lkeuangan.getSelectedItem()== "Harian"){
            tabelKeuangan.setVisible(true);
            try {
                TLKA.setData(this.LKS.getlkeuangan());
            } catch (RemoteException exception) {
                exception.printStackTrace();
            }
            tabelKeuangan.setModel(TLKA);

        }
        else if (lkeuangan.getSelectedItem()== "Bulanan") {

        }
    }//GEN-LAST:event_lkeuanganActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox lkeuangan;
    private javax.swing.JTable tabelKeuangan;
    // End of variables declaration//GEN-END:variables
}
