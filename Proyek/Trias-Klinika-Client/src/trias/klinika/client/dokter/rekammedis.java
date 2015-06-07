/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * rekammedis.java
 *
 * Created on Apr 26, 2015, 12:42:56 PM
 */
package trias.klinika.client.dokter;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.api.entitas.PasienEntity;
//import trias.klinika.client.dokter.rekam_medis;
import trias.klinika.api.entitas.rekammedisEntyty;
import trias.klinika.client.tabel.tabelrekammedis;
import trias.klinika.api.entitas.rekammedisEntyty;

/**
 *
 * @author Acer
 */
public class rekammedis extends javax.swing.JInternalFrame {
private serviceRekam sr;
private UtamaDokter UD;
private tabelrekammedis rm = new tabelrekammedis();
rekammedisEntyty rekammedisEntity = new rekammedisEntyty ();
String airekam;
String IDpasienkirim = "";
private PasienEntity pe = new PasienEntity();

    /** Creates new form rekammedis */
    public rekammedis(serviceRekam sr, UtamaDokter UD) throws RemoteException {
        this.sr = sr;
        this.UD = UD;
        
        initComponents();
       
    }

    public void awal (){
        try {
            pe = sr.getdata(ID.getText());
           nama.setText(pe.getNama());
           tanggalLahir.setText(pe.getTanggalLahir());
           alamat.setText(pe.getAlamat());
           noTlp.setText(pe.getNoTLP());
           gol.setText(pe.getGolDarah());
           ID.setEditable(false);
           nama.setEditable(false);
           tanggalLahir.setEditable(false);
           alamat.setEditable(false);
           noTlp.setEditable(false);
           gol.setEditable(false);
      
           try {
               rm.setData(this.sr.getdatarekam(ID.getText(),UD.IDpemeriksaan.getText()));
           } catch (RemoteException exception) {
               exception.printStackTrace();
           }
           history.setModel(rm);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        noTlp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tanggalLahir = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JTable();
        detail1 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        catatan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tekanan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        irm = new javax.swing.JTextField();
        keluhan = new javax.swing.JTextField();
        alergi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rekammedis = new javax.swing.JLabel();
        diagnosa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tindakan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().setLayout(null);

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        getContentPane().add(ID);
        ID.setBounds(110, 110, 180, 30);
        getContentPane().add(alamat);
        alamat.setBounds(110, 230, 180, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("No Telepon       =");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 280, 90, 14);
        getContentPane().add(noTlp);
        noTlp.setBounds(110, 270, 180, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("Gol. Darah         =");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 320, 87, 14);
        getContentPane().add(gol);
        gol.setBounds(110, 310, 180, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal Lahir     =");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 200, 87, 14);

        jTextField7.setEditable(false);
        jTextField7.setText("12 Januari 2015");
        getContentPane().add(jTextField7);
        jTextField7.setBounds(10, 60, 134, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Alamat               =");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 240, 100, 14);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("ID                       =");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 114, 89, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Nama                  =");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 160, 89, 14);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("DATA PASIEN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 177, 40);
        getContentPane().add(tanggalLahir);
        tanggalLahir.setBounds(110, 190, 180, 30);

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(110, 150, 180, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("HISTORY REKAM MEDIS");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 370, 470, 42);

        history.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 440, 375, 91);

        detail1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        detail1.setText("DETAIL");
        detail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detail1ActionPerformed(evt);
            }
        });
        getContentPane().add(detail1);
        detail1.setBounds(490, 460, 77, 23);

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(640, 410, 86, 37);

        jLabel9.setText("Catatan Lain    :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(920, 380, 77, 14);

        jLabel10.setText("Alergi Obat     :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(920, 130, 117, 14);

        catatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catatanActionPerformed(evt);
            }
        });
        getContentPane().add(catatan);
        catatan.setBounds(920, 400, 190, 97);

        jLabel11.setText("Tindakan            :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(590, 260, 110, 14);
        getContentPane().add(tekanan);
        tekanan.setBounds(920, 80, 186, 40);

        jLabel12.setText("Keluhan              :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(590, 130, 94, 14);

        irm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irmActionPerformed(evt);
            }
        });
        getContentPane().add(irm);
        irm.setBounds(590, 80, 190, 40);

        keluhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluhanActionPerformed(evt);
            }
        });
        getContentPane().add(keluhan);
        keluhan.setBounds(590, 150, 200, 100);

        alergi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alergiActionPerformed(evt);
            }
        });
        getContentPane().add(alergi);
        alergi.setBounds(920, 150, 186, 100);

        jLabel13.setText("Tekanan Darah   :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(920, 60, 130, 14);

        rekammedis.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rekammedis.setText("REKAM MEDIS PASIEN");
        getContentPane().add(rekammedis);
        rekammedis.setBounds(695, 11, 295, 41);

        diagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosaActionPerformed(evt);
            }
        });
        getContentPane().add(diagnosa);
        diagnosa.setBounds(920, 280, 186, 90);

        jLabel15.setText("Id Rekam Medis  :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(590, 60, 140, 14);
        getContentPane().add(tindakan);
        tindakan.setBounds(590, 280, 200, 90);

        jLabel16.setText("Diagnosa                 :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(920, 260, 99, 14);

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(490, 500, 80, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/J-IntFrameDokter.png"))); // NOI18N
        jLabel17.setMaximumSize(new java.awt.Dimension(1147, 557));
        jLabel17.setMinimumSize(new java.awt.Dimension(1147, 557));
        jLabel17.setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().add(jLabel17);
        jLabel17.setBounds(0, 150, 1147, 557);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_IDActionPerformed

private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_namaActionPerformed

private void detail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detail1ActionPerformed
  if(history.getSelectedRow()==-1){
        setCekData1();
    } 
    else{
        setHistory();
    }
}//GEN-LAST:event_detail1ActionPerformed

private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
// TODO add your handling code here:
    boolean isi = false;
    if(CheckNumber(tekanan.getText())&&!tekanan.getText().equals("")){
            isi = true;
        }
    if(isi){
        if(irm.getText().isEmpty()|diagnosa.getText().isEmpty()|keluhan.getText().isEmpty()|alergi.getText().isEmpty()|tindakan.getText().isEmpty()|tekanan.getText().isEmpty()|catatan.getText().isEmpty()){
        setCekdata2();
        }        
        else{
            setSimpan();
        }
    }
    else if (!isi){
        if(irm.getText().isEmpty()|diagnosa.getText().isEmpty()|keluhan.getText().isEmpty()|alergi.getText().isEmpty()|tindakan.getText().isEmpty()|tekanan.getText().isEmpty()|catatan.getText().isEmpty()){
        setCekdata2();
        } 
            tekanan.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "isi field merah degan inputan angka");
        }
}//GEN-LAST:event_saveActionPerformed

private void catatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catatanActionPerformed
// TODO add your handling code here:  
}//GEN-LAST:event_catatanActionPerformed

private void keluhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluhanActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_keluhanActionPerformed

private void alergiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alergiActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_alergiActionPerformed

private void diagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_diagnosaActionPerformed

private void irmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irmActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_irmActionPerformed

private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
// TODO add your handling code here:
      setReset();
        try {
            ai_rekammedis ();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        irm.setText(airekam);
  
      
}//GEN-LAST:event_resetActionPerformed
public void setHistory (){
        int row = history.getSelectedRow();
        rekammedisEntyty re = new rekammedisEntyty ();
            try {
                re = sr.getdatadetail(rm.get(row).getId_rekam());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        irm.setText(rm.get(row).getId_rekam());
        diagnosa.setText(re.getDiagnosa());
        keluhan.setText(re.getKeluhan());
        alergi.setText(re.getAlergi());
        tindakan.setText(re.getTindakan());
        tekanan.setText(Integer.toString(re.getTekanan_darah()));
        catatan.setText(re.getCatatan_lain());

    save.setEnabled(false);
}
public void setCekData1(){
  if (history.getSelectedRow()== -1){
    JOptionPane.showMessageDialog(this, "Pilih History Rekam Medis yang ingin dilihat terlebih dahulu");  
  }
      
}
public void setReset(){
     irm.setText("");
        diagnosa.setText("");
        keluhan.setText("");
        tindakan.setText("");
        tekanan.setText("");
        alergi.setText("");
        catatan.setText("");
        rekammedis.setEnabled(true);
        save.setEnabled(true);
}
public void setCekdata2(){
   if(irm.getText().isEmpty()|diagnosa.getText().isEmpty()|keluhan.getText().isEmpty()|alergi.getText().isEmpty()|tindakan.getText().isEmpty()|tekanan.getText().isEmpty()|catatan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Data belum di isi lengkap");
        } 
}
public void setSimpan(){
//     if(irm.getText().isEmpty()|diagnosa.getText().isEmpty()|keluhan.getText().isEmpty()|alergi.getText().isEmpty()|tindakan.getText().isEmpty()|tekanan.getText().isEmpty()|catatan.getText().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Data belum di isi lengkap");
//        }
//        else {
            rekammedisEntyty rrm = new rekammedisEntyty();
                rrm.setId_rekam(irm.getText());
                rrm.setDiagnosa(diagnosa.getText());
                rrm.setKeluhan(keluhan.getText());
                rrm.setAlergi(alergi.getText());
                rrm.setTindakan(tindakan.getText());
                rrm.setTekanan_darah(Integer.parseInt(tekanan.getText()));
                rrm.setCatatan_lain(catatan.getText());
            try {
                sr.ok(rrm);
                sr.Update(UD.IDpemeriksaan.getText(), rrm.getId_rekam());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            
        //}
        
        this.dispose();
        irm.setText("");
        diagnosa.setText("");
        keluhan.setText("");
        tindakan.setText("");
        tekanan.setText("");
        alergi.setText("");
        catatan.setText("");
    
}
private boolean CheckNumber(String a){
        char b;
        StringBuffer s;        
        for(int i = 0; i<a.length();i++){
            b = a.charAt(i);                        
            s = new StringBuffer();
            s.append(b);          
            if(!s.toString().equals("1")&&!s.toString().equals("2")&&!s.toString().equals("3")&&!s.toString().equals("4")&&!s.toString().equals("5")&&!s.toString().equals("6")&&!s.toString().equals("7")&&!s.toString().equals("8")&&!s.toString().equals("9")&&!s.toString().equals("0")){               
               return false;
            }            
        }
        return true;
    }
    private void ai_rekammedis () throws RemoteException{
            airekam = sr.ai_rekammedis(airekam);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ID;
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField alergi;
    private javax.swing.JTextField catatan;
    private javax.swing.JButton detail1;
    private javax.swing.JTextField diagnosa;
    private javax.swing.JTextField gol;
    private javax.swing.JTable history;
    private javax.swing.JTextField irm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField keluhan;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField noTlp;
    private javax.swing.JLabel rekammedis;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTextField tanggalLahir;
    private javax.swing.JTextField tekanan;
    private javax.swing.JTextField tindakan;
    // End of variables declaration//GEN-END:variables
}
