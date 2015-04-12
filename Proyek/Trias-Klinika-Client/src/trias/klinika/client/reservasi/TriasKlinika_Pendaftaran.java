package trias.klinika.client.reservasi;


import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.EntitasPendaftaran;
import trias.klinika.api.sevice.PendaftaranService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satria
 */
public class TriasKlinika_Pendaftaran extends javax.swing.JFrame {

    /**
     * Creates new form TriasKlinika_Pendaftaran
     */
    
    int j;
    
    private PendaftaranService PS;
    private String[] isi;
    private Object golongan_darah;
    
    public TriasKlinika_Pendaftaran(PendaftaranService PS)throws RemoteException {
        this.PS = PS;
        
        initComponents();
        Dropdown();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama_pasien = new javax.swing.JTextField();
        alamat_pasien = new javax.swing.JTextField();
        no_telp_pasien = new javax.swing.JTextField();
        pilih_dokter = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tombol_simpan = new javax.swing.JButton();
        cetak_id_card = new javax.swing.JCheckBox();
        tgl_lahir_pasien = new com.toedter.calendar.JDateChooser();
        gol_darah = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        id_pasien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tombol_keluar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(java.awt.Color.cyan);

        jLabel1.setText("Nama ");

        jLabel2.setText("Tanggal Lahir");

        jLabel3.setText("Nomor Telepon");

        jLabel4.setText("Alamat ");

        nama_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pasienActionPerformed(evt);
            }
        });

        pilih_dokter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dr. Sukardi Sp.M.", "Dr. Lazuardi Sp.D." }));
        pilih_dokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_dokterActionPerformed(evt);
            }
        });

        jLabel5.setText("Pilih Dokter");

        tombol_simpan.setText("Simpan");
        tombol_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_simpanActionPerformed(evt);
            }
        });

        cetak_id_card.setText("Cetak ID Card");
        cetak_id_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak_id_cardActionPerformed(evt);
            }
        });

        gol_darah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O", "AB", "A", "B" }));
        gol_darah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gol_darahActionPerformed(evt);
            }
        });

        jLabel7.setText("Golongan Darah");

        id_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pasienActionPerformed(evt);
            }
        });

        jLabel8.setText("ID");

        tombol_keluar.setText("Keluar");
        tombol_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_keluarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Satria\\Desktop\\received_1044200968941754.jpeg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgl_lahir_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(31, 31, 31)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gol_darah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(no_telp_pasien)
                                .addComponent(alamat_pasien)
                                .addComponent(nama_pasien)
                                .addComponent(id_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(pilih_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cetak_id_card)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tombol_simpan)
                        .addGap(18, 18, 18)
                        .addComponent(tombol_keluar)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(id_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pilih_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(nama_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(alamat_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(no_telp_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tgl_lahir_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(gol_darah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(cetak_id_card)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombol_simpan)
                    .addComponent(tombol_keluar))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nama_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_pasienActionPerformed

    private void pilih_dokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_dokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilih_dokterActionPerformed

    private void tombol_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_simpanActionPerformed
        // TODO add your handling code here:
        if (pilih_dokter.getSelectedItem()== "Pilih Dokter"){
            JOptionPane.showMessageDialog(this, "Harus pilih dokter");            
        }
        else{EntitasPendaftaran EP = new EntitasPendaftaran();
             EP.setID_PASIEN(id_pasien.getText().toString());
             EP.setNAMA_PASIEN(nama_pasien.getText().toString());
             EP.setALAMAT_PASIEN(alamat_pasien.getText().toString());
             EP.setTGL_LAHIR_PASIEN(tgl_lahir_pasien.getDate().toString());
             EP.setNO_TELP_PASIEN(no_telp_pasien.getText().toString());
             EP.setGOL_DARAH(gol_darah.getSelectedItem().toString());
        }
    }//GEN-LAST:event_tombol_simpanActionPerformed

    private void cetak_id_cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak_id_cardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetak_id_cardActionPerformed

    private void gol_darahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gol_darahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gol_darahActionPerformed

    private void id_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_pasienActionPerformed

    private void tombol_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombol_keluarActionPerformed

    private void Dropdown() throws RemoteException{
    isi = PS.pilih_dokter(isi);
    
    for (int i=0;i<isi.length;i++){
        pilih_dokter.addItem(isi[i]);
    }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_pasien;
    private javax.swing.JCheckBox cetak_id_card;
    private javax.swing.JComboBox gol_darah;
    private javax.swing.JTextField id_pasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nama_pasien;
    private javax.swing.JTextField no_telp_pasien;
    private javax.swing.JComboBox pilih_dokter;
    private com.toedter.calendar.JDateChooser tgl_lahir_pasien;
    private javax.swing.JButton tombol_keluar;
    private javax.swing.JButton tombol_simpan;
    // End of variables declaration//GEN-END:variables
}
