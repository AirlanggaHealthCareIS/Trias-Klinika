/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.entitas.ResepEntity;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.api.entitas.RincianResep;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.client.tabell.TabelResep;
/**
 *
 * @author User
 */
public class input_resep extends javax.swing.JInternalFrame {
    private ServiceResep SR;
    private String[] isi;
    private TabelResep TR = new TabelResep();
    private Object ID_Apotek;

    /**
     * Creates new form input_resep
     */
    public input_resep(ServiceResep SR) throws RemoteException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NoResep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IDPasien = new javax.swing.JTextField();
        IDDokter = new javax.swing.JTextField();
        apotek = new javax.swing.JLabel();
        ID_Apoteker = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        obat = new javax.swing.JComboBox();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        kirimapoteker = new javax.swing.JButton();
        kirimreservasi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1147, 557));
        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().setLayout(null);

        jLabel2.setText("NO Resep ");

        NoResep.setEditable(false);
        NoResep.setText("01");

        jLabel3.setText("ID Pasien");

        jLabel5.setText("ID Dokter");

        IDPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDPasienActionPerformed(evt);
            }
        });

        apotek.setText("ID Apoteker");

        ID_Apoteker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_ApotekerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoResep, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(IDDokter)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(apotek))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDPasien)
                            .addComponent(ID_Apoteker))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NoResep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(apotek)
                    .addComponent(ID_Apoteker, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IDPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(82, 119, 426, 190);

        jLabel9.setText("Obat");

        jLabel11.setText("Jumlah");

        jLabel12.setText("Keterangan/ Aturan pakai");

        obat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Obat" }));
        obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obatActionPerformed(evt);
            }
        });

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/add.png"))); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(obat, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambah)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambah)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(610, 119, 447, 190);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "ID Obat", "Nama Obat", "Jumlah Terpenuhi", "Satuan Jenis", "Harga", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(82, 315, 975, 91);

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/delete.png"))); // NOI18N
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(82, 424, 99, 33);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(958, 0, 0, 0);

        kirimapoteker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kirim.png"))); // NOI18N
        kirimapoteker.setText("KIRIM KE APOTEKER");
        kirimapoteker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimapotekerActionPerformed(evt);
            }
        });
        getContentPane().add(kirimapoteker);
        kirimapoteker.setBounds(881, 424, 176, 33);

        kirimreservasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kirim.png"))); // NOI18N
        kirimreservasi.setText("KIRIM KE RESERVASI");
        kirimreservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimreservasiActionPerformed(evt);
            }
        });
        getContentPane().add(kirimreservasi);
        kirimreservasi.setBounds(881, 468, 176, 33);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/resepj.png"))); // NOI18N
        jLabel7.setText("RESEP");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 210, 108);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(703, 20, 0, 0);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(924, 10, 160, 90);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/J-IntFrameDokter.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-20, 0, 1140, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obatActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
     if (obat.getSelectedItem()== "Pilih Obat"){
            JOptionPane.showMessageDialog(this, "Pilih Obat Dahulu");
            
        }
        else{
            
               ResepEntity RE = new ResepEntity();
               RE.setID_obat(obat.getSelectedItem().toString().substring(0, 6));
               RE.setnama_obat(obat.getName());
               RE.setnama_obat(obat.getSelectedItem().toString().substring(6));
              
         try {
             RE.setharga(SR.getdetail(RE).getharga());
         } catch (RemoteException ex) {
             Logger.getLogger(input_resep.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             RE.setsatuan_jenis(SR.getdetail(RE).getsatuan_jenis());
         } catch (RemoteException ex) {
             Logger.getLogger(input_resep.class.getName()).log(Level.SEVERE, null, ex);
         }
               
               TR.insert(RE);
               try {
                   SR.Save(RE);    
                   } catch (RemoteException | SQLException ex) {
                        Logger.getLogger(input_resep.class.getName()).log(Level.SEVERE, null, ex);
               }}
    }//GEN-LAST:event_tambahActionPerformed

    private void kirimapotekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimapotekerActionPerformed
        int opsi = JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (opsi == 0){
            ResepEntity RE = new ResepEntity();
           
            RE.setID_apotek(ID_Apoteker.getText());
            RE.setID_pasien(IDPasien.getText());
            
            try{
                
                SR.Save(RE);
                
                for(int i=1;i<=TR.getRowCount();i++){
                    
                }
                JOptionPane.showMessageDialog(null, "Data Berhasil Terkirim ","Sukses",JOptionPane.OK_OPTION);
            } catch (RemoteException | SQLException ex) {
            Logger.getLogger(input_resep.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
        else{
             this.setVisible(true);
             
                     }
    }//GEN-LAST:event_kirimapotekerActionPerformed

    private void kirimreservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimreservasiActionPerformed
        JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);// TODO add your handling code here:
    }//GEN-LAST:event_kirimreservasiActionPerformed

    private void Dropdown() throws RemoteException{
    isi = SR.obat(isi);
    
    for (int i=0;i<isi.length;i++){
        obat.addItem(isi[i]);
    }
    
}
    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int i = table.getSelectedRow();
        if(i == -1){
            return;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void ID_ApotekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_ApotekerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_ApotekerActionPerformed

    private void IDPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDPasienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDDokter;
    private javax.swing.JTextField IDPasien;
    private javax.swing.JTextField ID_Apoteker;
    private javax.swing.JTextField NoResep;
    private javax.swing.JLabel apotek;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton kirimapoteker;
    private javax.swing.JButton kirimreservasi;
    private javax.swing.JComboBox obat;
    private javax.swing.JTable table;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
