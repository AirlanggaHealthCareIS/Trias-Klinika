package trias.klinika.client.reservasi;






import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.EntitasPendaftaran;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.entitas.PemeriksaanEntitas;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.client.tabel.TabelPasienKecil;

/**
 *
 * @author Satria
 */
public class TriasKlinika_Pendaftaran extends javax.swing.JInternalFrame {

    /**
     * Creates new form TriasKlinika_Pendaftaran
     */
    
    
    private PendaftaranService PS;
    private String[] isi;
    private Object golongan_darah;
    private TabelPasienKecil TPK = new TabelPasienKecil();
    String aipasien;
    String aipemeriksaan;
    String cek;
    int na;
    private LoginEntitas LE;
    private EntitasPendaftaran EP;
    public TriasKlinika_Pendaftaran(PendaftaranService PS, LoginEntitas LE)throws RemoteException {
        this.PS = PS;
        this.LE = LE;
        this.TPK = TPK;
        auto_increment_pasien();
        auto_increment_pemeriksaan();
        initComponents();
        id_reservasi.setText(LE.getusername());
        id_pasien.setText(aipasien);
        id_pemeriksaan.setText(aipemeriksaan);
        tgl_pemeriksaan.setText(setTanggal());
        TPK.setData(this.PS.getDataPasien());
        tabel_anak.setModel(TPK);
        
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

        jLabel5 = new javax.swing.JLabel();
        id_pemeriksaan = new javax.swing.JTextField();
        tombol_simpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cetak_id_card = new javax.swing.JCheckBox();
        no_antrian = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        gol_darah = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        id_pasien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tombol_keluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama_pasien = new javax.swing.JTextField();
        alamat_pasien = new javax.swing.JTextField();
        no_telp_pasien = new javax.swing.JTextField();
        pilih_dokter = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id_reservasi = new javax.swing.JTextField();
        tgl_lahir_pasien = new com.toedter.calendar.JDateChooser();
        tgl_pemeriksaan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        no_ktp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_anak = new javax.swing.JTable();
        jenis_pasien = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        nama_pasien_kecil = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(1147, 557));
        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().setLayout(null);

        jLabel5.setText("Pilih Dokter");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(820, 160, 60, 30);

        id_pemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pemeriksaanActionPerformed(evt);
            }
        });
        getContentPane().add(id_pemeriksaan);
        id_pemeriksaan.setBounds(940, 60, 100, 30);

        tombol_simpan.setText("Simpan");
        tombol_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_simpan);
        tombol_simpan.setBounds(850, 460, 100, 40);

        jLabel10.setText("Nomor Antrian");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(820, 210, 80, 30);

        cetak_id_card.setText("Cetak ID Card");
        cetak_id_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak_id_cardActionPerformed(evt);
            }
        });
        getContentPane().add(cetak_id_card);
        cetak_id_card.setBounds(870, 400, 110, 40);
        getContentPane().add(no_antrian);
        no_antrian.setBounds(940, 210, 100, 30);

        jLabel11.setText("Tanggal Pemeriksaan");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(820, 110, 110, 30);

        gol_darah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Golongan", "O", "AB", "A", "B" }));
        gol_darah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gol_darahActionPerformed(evt);
            }
        });
        getContentPane().add(gol_darah);
        gol_darah.setBounds(630, 380, 120, 30);

        jLabel7.setText("Golongan Darah");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 380, 77, 30);

        id_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pasienActionPerformed(evt);
            }
        });
        getContentPane().add(id_pasien);
        id_pasien.setBounds(630, 70, 118, 30);

        jLabel8.setText("ID Pasien");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(520, 70, 70, 30);

        tombol_keluar.setText("Keluar");
        tombol_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_keluar);
        tombol_keluar.setBounds(980, 460, 90, 40);

        jLabel1.setText("Nama Pasien ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 170, 70, 30);

        jLabel2.setText("Tanggal Lahir");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 320, 64, 30);

        jLabel3.setText("Nomor Telepon");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(520, 270, 72, 30);

        jLabel4.setText("Alamat ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 220, 36, 30);

        nama_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pasienActionPerformed(evt);
            }
        });
        getContentPane().add(nama_pasien);
        nama_pasien.setBounds(630, 170, 118, 30);
        getContentPane().add(alamat_pasien);
        alamat_pasien.setBounds(630, 220, 118, 30);
        getContentPane().add(no_telp_pasien);
        no_telp_pasien.setBounds(630, 270, 118, 30);

        pilih_dokter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Dokter" }));
        pilih_dokter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pilih_dokterItemStateChanged(evt);
            }
        });
        pilih_dokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_dokterActionPerformed(evt);
            }
        });
        getContentPane().add(pilih_dokter);
        pilih_dokter.setBounds(940, 160, 150, 30);

        jLabel6.setText("ID Pemeriksaan");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(820, 60, 80, 30);

        jLabel9.setText("ID Reservasi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 20, 70, 30);

        id_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_reservasiActionPerformed(evt);
            }
        });
        getContentPane().add(id_reservasi);
        id_reservasi.setBounds(110, 20, 90, 30);
        getContentPane().add(tgl_lahir_pasien);
        tgl_lahir_pasien.setBounds(630, 320, 120, 30);

        tgl_pemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_pemeriksaanActionPerformed(evt);
            }
        });
        getContentPane().add(tgl_pemeriksaan);
        tgl_pemeriksaan.setBounds(940, 110, 100, 30);

        jLabel12.setText("Nomor KTP");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(520, 120, 90, 30);

        no_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_ktpActionPerformed(evt);
            }
        });
        getContentPane().add(no_ktp);
        no_ktp.setBounds(630, 120, 120, 30);

        tabel_anak.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Pasien", "Alamat Pasien"
            }
        ));
        jScrollPane1.setViewportView(tabel_anak);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 452, 420);

        jenis_pasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kategori" }));
        getContentPane().add(jenis_pasien);
        jenis_pasien.setBounds(630, 20, 120, 30);

        jLabel13.setText("Kategori");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(520, 20, 70, 30);

        nama_pasien_kecil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_pasien_kecilKeyPressed(evt);
            }
        });
        getContentPane().add(nama_pasien_kecil);
        nama_pasien_kecil.setBounds(340, 20, 90, 30);

        jLabel14.setText("Mancari Pasien");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(250, 20, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_pemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pemeriksaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_pemeriksaanActionPerformed

    private void tombol_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_simpanActionPerformed
        // TODO add your handling code here:

        if (pilih_dokter.getSelectedItem()== "Pilih Dokter"){
            JOptionPane.showMessageDialog(this, "Harus pilih dokter");
        }
        else {
            cek = Cek(nama_pasien.getText(), tgl_lahir_pasien.getDate().toString(), no_telp_pasien.getText(), alamat_pasien.getText(), gol_darah.getSelectedItem().toString());
            if (!"Sukses".equals(cek)) {
            JOptionPane.showMessageDialog(this, cek);
        }
        else{EntitasPendaftaran EP = new EntitasPendaftaran();
            PemeriksaanEntitas PE = new PemeriksaanEntitas();
            Date date = new Date(tgl_lahir_pasien.getDate().getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_lahir_pasien = sdf.format(date);
            EP.setDataPasien(id_pasien.getText(), nama_pasien.getText(), tgl_lahir_pasien, no_telp_pasien.getText(), alamat_pasien.getText(), gol_darah.getSelectedItem().toString(), jenis_pasien.getSelectedItem().toString(), no_ktp.getText());
            
            
            
//            PE.setDataPemeriksaan(id_pemeriksaan.getText(), id_reservasi.getText(), id_pasien.getText(), pilih_dokter.getSelectedItem().toString().substring(0, 5), tgl_pemeriksaan.getText(), no_antrian.getText());

            try {
                PS.Save(EP, PE);
            } catch (RemoteException ex) {
                Logger.getLogger(TriasKlinika_Pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Data tersimpan");
        }
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

    private void nama_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_pasienActionPerformed

    private void pilih_dokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_dokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilih_dokterActionPerformed

    private void id_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_reservasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_reservasiActionPerformed

    private void pilih_dokterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pilih_dokterItemStateChanged
        // TODO add your handling code here:
       if (pilih_dokter.getSelectedItem()!= "Pilih Dokter"){
           
           try {
               na = PS.nomor_antrian(na, tgl_pemeriksaan.toString(), pilih_dokter.getSelectedItem().toString().substring(0, 5));
                       } catch (RemoteException ex) {
               Logger.getLogger(TriasKlinika_Pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
           }
           no_antrian.setText(Integer.toString(na));
       } 
    }//GEN-LAST:event_pilih_dokterItemStateChanged

    private void tgl_pemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_pemeriksaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_pemeriksaanActionPerformed

    private void no_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_ktpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_ktpActionPerformed

    private void nama_pasien_kecilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_pasien_kecilKeyPressed
        // TODO add your handling code here:
       
        if(nama_pasien_kecil.getText()== ""){
           try {
               TPK.setData(PS.getDataPasien());
           } catch (RemoteException ex) {
               Logger.getLogger(TriasKlinika_Pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
           }
           tabel_anak.setModel(TPK);
       } 
       else {
           try {
                TPK.setData(PS.search_nama(nama_pasien_kecil.getText()));
                tabel_anak.setModel(TPK);
            } catch (RemoteException ex) {
                Logger.getLogger(TriasKlinika_Pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            }
       } 
             
    }//GEN-LAST:event_nama_pasien_kecilKeyPressed
    private void Dropdown() throws RemoteException{
    isi = PS.pilih_dokter(isi);
    
    for (int i=0;i<isi.length;i++){
        pilih_dokter.addItem(isi[i]);
    }
    }
    
    private void auto_increment_pasien () throws RemoteException { 
       aipasien = PS.auto_increment_pasien(aipasien);
    }
    private void auto_increment_pemeriksaan () throws RemoteException { 
       aipemeriksaan = PS.auto_increment_pemeriksaan(aipemeriksaan);
    }
    private void nomor_antrian(int na, String tgl, String id_dokter) throws RemoteException{
       na = PS.nomor_antrian(na, tgl, id_dokter);
    }
    
    public String setTanggal () {
        Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("dd/MM/yyyy");
        return kal.format(skrg);
    }
    public String Cek(String nama_pasien, String alamat_pasien, String tgl_lahir_pasien, String no_telp_pasien, String gol_darah) {
        String a;
        if ("".equals(nama_pasien)) {
            a = "Masukkan Nama Pasien Terlebih Dahulu";
        }
        else if ("".equals(alamat_pasien)) {
            a = "Masukkan Alamat Pasien Terlebih Dahulu";
        }
        else if ("".equals(tgl_lahir_pasien)) {
            a = "Masukkan Tanggal Lahir Terlebih Dahulu";
        }
        else if ("".equals(no_telp_pasien)) {
            a = "Masukkan No telepon Terlebih Dahulu";
        }
        else if ("".equals(gol_darah)) {
            a = "Pilih Golongan Darah Terlebih Dahulu";
        }
        else {
            a = "Sukses";
        }
        return a;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_pasien;
    private javax.swing.JCheckBox cetak_id_card;
    private javax.swing.JComboBox gol_darah;
    private javax.swing.JTextField id_pasien;
    private javax.swing.JTextField id_pemeriksaan;
    public javax.swing.JTextField id_reservasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jenis_pasien;
    private javax.swing.JTextField nama_pasien;
    private javax.swing.JTextField nama_pasien_kecil;
    private javax.swing.JTextField no_antrian;
    private javax.swing.JTextField no_ktp;
    private javax.swing.JTextField no_telp_pasien;
    private javax.swing.JComboBox pilih_dokter;
    private javax.swing.JTable tabel_anak;
    private com.toedter.calendar.JDateChooser tgl_lahir_pasien;
    private javax.swing.JTextField tgl_pemeriksaan;
    private javax.swing.JButton tombol_keluar;
    private javax.swing.JButton tombol_simpan;
    // End of variables declaration//GEN-END:variables
}
