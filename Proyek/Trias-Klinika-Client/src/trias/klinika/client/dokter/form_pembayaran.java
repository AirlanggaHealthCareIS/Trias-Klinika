/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import trias.klinika.api.entitas.PembayaranEntitas;
import trias.klinika.api.entitas.RincianPembayaran;
import trias.klinika.api.sevice.pembayaranService;
import trias.klinika.client.tabel.tabelPembayaran;
import trias.klinika.api.entitas.RincianPembayaranEntitas;
/**
 *
 * @author ICUN
 */
public class form_pembayaran extends javax.swing.JInternalFrame {
    private pembayaranService ps ;
    private String[] isi;
    private int harga = 0;
    private int totalHarga = 0;
    private tabelPembayaran tp = new tabelPembayaran();
    String tanggalinsertnow = "";
    String d;
    boolean a = true;
    String idia = "";

    /**
     * Creates new form form_pembayaran
     */
    
    public String plusone (Date tgl, String a){
      DateFormat dateFormats = new SimpleDateFormat("dd");
        Date dates=Calendar.getInstance().getTime();
        
         a= dateFormats.format(tgl);
        int aa = Integer.parseInt(a)+1;
        a  =  ""+aa;
        
    return a;}
    
    private String autoInc(DefaultTableModel model, int kolom){
        int x = 0;
        for(int i = 0; i<model.getRowCount(); i++){
            if(Integer.parseInt((String)model.getValueAt(i,kolom)) > x){
                x = Integer.parseInt((String)model.getValueAt(i,kolom));
            }
        }
        x = x+1;
        return (""+x);
    }
    public form_pembayaran(pembayaranService ps) throws RemoteException {
        this.ps = ps;
        
        initComponents();
        Dropdown();
        tabel.setModel(tp);
              
        
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date=Calendar.getInstance().getTime();
        
        DateFormat MonthFormat = new SimpleDateFormat("MM");
        Date Month=Calendar.getInstance().getTime();
        
        DateFormat YearFormat = new SimpleDateFormat("yyyy");
        Date Year=Calendar.getInstance().getTime();
        tgl.setText(dateFormat.format(date)+"-"+MonthFormat.format(Month)+"-"+YearFormat.format(Year));
        tanggalinsertnow = YearFormat.format(Year)+"-"+MonthFormat.format(Month)+"-"+dateFormat.format(date);
        
        d = ps.d(d);
        String b = Integer.toString((Integer.parseInt(d.substring(1,5)))+1); //memisahkan angka D dengan 0001
     //menambahkan angka belakang    
        for (int i = b.length(); i < 4; i++ ) {
            b = "0" + b;
        } 
        d = d.substring(0, 1) + b;
        nomert.setText(d);
        
        idia = ps.ID(idia);
        id.setText(idia);
        


        
    }
    public void setPembayaranDate() throws RemoteException{ 
        
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date=Calendar.getInstance().getTime();
        
        DateFormat MonthFormat = new SimpleDateFormat("MM");
        Date Month=Calendar.getInstance().getTime();
        
        DateFormat YearFormat = new SimpleDateFormat("yyyy");
        Date Year=Calendar.getInstance().getTime();
        
         tgl.setText(dateFormat.format(date)+"-"+MonthFormat.format(Month)+"-"+YearFormat.format(Year));
         tanggalinsertnow = YearFormat.format(Year)+"-"+MonthFormat.format(Month)+"-"+dateFormat.format(date);
        
        String temp =""; 
        temp =  plusone(date, temp);
        PembayaranEntitas PE = null;
        
         ps.Save(PE);
         
         
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        biayadok = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tgl = new javax.swing.JTextField();
        hapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nomert = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        obat = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().setLayout(null);

        total.setEditable(false);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        getContentPane().add(total);
        total.setBounds(910, 400, 200, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Biaya Dokter");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 350, 150, 28);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Rp.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 410, 30, 20);

        biayadok.setEditable(false);
        biayadok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                biayadokMouseClicked(evt);
            }
        });
        biayadok.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                biayadokInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        biayadok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayadokActionPerformed(evt);
            }
        });
        getContentPane().add(biayadok);
        biayadok.setBounds(820, 350, 296, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kirim.png"))); // NOI18N
        jButton3.setText("Kirim");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(990, 470, 110, 50);

        tgl.setEditable(false);
        getContentPane().add(tgl);
        tgl.setBounds(10, 110, 140, 30);

        hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/delete.png"))); // NOI18N
        hapus.setText("Hapus Obat");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(20, 320, 150, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\trias.jpg")); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(980, 0, 154, 90);

        nomert.setEditable(false);
        nomert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomertActionPerformed(evt);
            }
        });
        getContentPane().add(nomert);
        nomert.setBounds(960, 120, 163, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Form Pembayaran");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 20, 300, 42);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("ID Pasien");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(840, 150, 70, 17);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 92, 1111, 2);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Nomer transaksi");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(840, 120, 110, 17);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tindakan", "Biaya"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 1111, 91);

        id.setEditable(false);
        id.setText("P0001");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id);
        id.setBounds(960, 150, 163, 20);

        obat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        obat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Obat" }));
        obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obatActionPerformed(evt);
            }
        });
        getContentPane().add(obat);
        obat.setBounds(40, 170, 160, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("TOTAL BIAYA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 410, 130, 17);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/+.png"))); // NOI18N
        jButton1.setText("Tambah Obat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 160, 140, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/J-IntFrameDokter.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1130, 570);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/obat.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(6, 154, 40, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void biayadokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biayadokMouseClicked
        if (a == false){
            totalHarga = totalHarga-Integer.parseInt(biayadok.getText());
            biayadok.setText("");
            a = true;
            total.setText(Integer.toString(totalHarga));
        }
        biayadok.setEditable(true);
    }//GEN-LAST:event_biayadokMouseClicked

    private void biayadokInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_biayadokInputMethodTextChanged
//        totalHarga = totalHarga+Integer.parseInt(biayadok.getText());
//        total.setText(Integer.toString(totalHarga));
    }//GEN-LAST:event_biayadokInputMethodTextChanged

    private void biayadokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayadokActionPerformed

        if (a == true){
            tambahharga(totalHarga,Integer.parseInt(biayadok.getText())); 
//            totalHarga = totalHarga+Integer.parseInt(biayadok.getText());
//            total.setText(Integer.toString(totalHarga));
            a = false;
            biayadok.setEditable(false);
        }

    }//GEN-LAST:event_biayadokActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //JOptionPane.showConfirmDialog(null, "Apakah Biaya Sudah Benar ?","Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        int opsi = JOptionPane.showConfirmDialog(this, "Apakah Biaya Sudah Benar ?","Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opsi == 0){
            PembayaranEntitas PE = new PembayaranEntitas();
            
            PE.setPembayaran(Integer.parseInt(nomert.getText()),Integer.parseInt(biayadok.getText()),Integer.parseInt(total.getText()));
            
//            PE.setnomer_transaksi(Integer.parseInt(nomert.getText()));
//            PE.setBIAYA_DOKTER(Integer.parseInt(biayadok.getText()));
//            PE.setTOTAL_BIAYA(Integer.parseInt(total.getText()));

            try {

                ps.Save(PE);

                for(int i=1;i<=tp.getRowCount();i++){
                    RincianPembayaranEntitas RPE = new RincianPembayaranEntitas();
                    
            RPE.setRincianPembayaran(i,Integer.parseInt(nomert.getText()),tp.getValueAt((i-1),0).toString());
//                    RPE.setID_RINCIAN_PEMBAYARAN(i);
//                    RPE.setID_PEMBAYARAN(Integer.parseInt(nomert.getText()));
//                    RPE.setID_OBAT_DOKTER(tp.getValueAt((i-1), 0).toString());
                    ps.save(RPE);

                }

                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan dan Terkirim ","Sukses",JOptionPane.OK_OPTION);

            } catch (RemoteException ex) {
                Logger.getLogger(form_pembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            this.setVisible(true);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int row = tabel.getSelectedRow();
        if(row == -1){
            return;
        }
        totalHarga = totalHarga -Integer.parseInt(tabel.getValueAt(row, 2).toString()) ;
        tp.delete(row);

        total.setText(Integer.toString(totalHarga));

    }//GEN-LAST:event_hapusActionPerformed

    private void nomertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomertActionPerformed

    private void obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obatActionPerformed

    }//GEN-LAST:event_obatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (obat.getSelectedItem()== "Pilih Obat"){
            JOptionPane.showMessageDialog(this, "Pilih Obat Dahulu");

        }
        else{
            RincianPembayaran RP = new RincianPembayaran();
            RP = isirincian(RP);
            tp.insert(RP);
            tambahharga(totalHarga, RP.getHARGA_OBAT());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void Dropdown() throws RemoteException{
    isi = ps.obat(isi);
    
    for (int i=0;i<isi.length;i++){
        obat.addItem(isi[i]);
    }
    
}
    
    private void tambahharga(int a, int b){
        totalHarga = a+b;
        total.setText(Integer.toString(totalHarga));
    }
    
    private RincianPembayaran isirincian(RincianPembayaran RP) {
        RP.setID_OBAT(obat.getSelectedItem().toString().substring(0, 6));
        String a = obat.getSelectedItem().toString();
        RP.setNAMA_OBAT(obat.getSelectedItem().toString().substring(5));

            try {
                RP.setHARGA_OBAT(ps.biaya(harga, RP.getID_OBAT()));
            } catch (RemoteException ex) {
                Logger.getLogger(form_pembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
            return RP;
    }
    public void ID (String idp) throws RemoteException {
        idp = ps.ID(idp);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField biayadok;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomert;
    private javax.swing.JComboBox obat;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tgl;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
