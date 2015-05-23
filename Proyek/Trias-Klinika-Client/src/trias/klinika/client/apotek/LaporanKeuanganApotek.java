
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

    int a;
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
        tabel.setVisible(false);
        Tahun.setEnabled(false);
        Bulan.setEnabled(false);
        Tanggal.setEnabled(false);
        CekTahun();
        CekBulan();
        CekTanggal();
        
       }
    
    public LaporanKeuanganApotek() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        lkeuangan = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Tahun = new javax.swing.JComboBox();
        Bulan = new javax.swing.JComboBox();
        Tanggal = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1145, 557));
        setPreferredSize(new java.awt.Dimension(1145, 557));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("LAPORAN KEUANGAN APOTEK");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Total Harga", "Total Pendapatan", ""
            }
        ));
        jScrollPane1.setViewportView(tabel);

        lkeuangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Tahunan", "Bulanan", "Harian" }));
        lkeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lkeuanganActionPerformed(evt);
            }
        });

        jLabel2.setText("Jenis        =");

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\DOCUMEN IIS\\6 MSTERI SEMESTER\\Pengembangan Sistem Informasi\\1428831065_common_printer_print_-24.png")); // NOI18N
        jButton1.setText("Cetak");

        Tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tahun" }));
        Tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TahunActionPerformed(evt);
            }
        });

        Bulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bulan" }));

        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanggal" }));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\DOCUMEN IIS\\6 MSTERI SEMESTER\\Pengembangan Sistem Informasi\\Untitled-2.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(494, 494, 494))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lkeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lkeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lkeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lkeuanganActionPerformed
      
         if(lkeuangan.getSelectedItem().toString()=="Tahunan"){
             Tahun.setVisible(true);
             tabel.setVisible(true);
            reset();
            a = 0;
            Tahun.setEnabled(true);}
        
         else if(lkeuangan.getSelectedItem().toString()=="Bulanan"){
            Bulan.setVisible(true);
            tabel.setVisible(true);
             reset();
        a=1;
        Tahun.setEnabled(true);
        Bulan.setEnabled(true);}
        
         else if(lkeuangan.getSelectedItem().toString()=="Harian"){
            Tanggal.setVisible(true);
            tabel.setVisible(true);
             reset();
            a=2;
            Tahun.setEnabled(true);
            Bulan.setEnabled(true);
            Tanggal.setEnabled(true); }
        
       else if(lkeuangan.getSelectedItem().toString()=="Pilih"){
            reset();
           
        }
                
       
        
        
        
        //  if (lkeuangan.getSelectedItem()== "Harian"){
       //     tabelKeuangan.setVisible(true);
        //    try {
        //        TLKA.setData(this.LKS.getlkeuangan());
         //   } catch (RemoteException exception) {
         //   }
          //  tabelKeuangan.setModel(TLKA);

    //    }
   //
   //     }
        
   
           
//}
            
        
    }//GEN-LAST:event_lkeuanganActionPerformed

    public void reset(){
            Tahun.setEnabled(false);
            Bulan.setEnabled(false);
            Tanggal.setEnabled(false);}
    
    
    public void CekTahun() throws RemoteException{
       
            isi = LKS.Tahun(isi);
        
    
        for (int i=0;i<isi.length;i++){
            Tahun.addItem(isi[i]);} }

    
    public void CekBulan() throws RemoteException{
        isi = LKS.Bulan(isi);
    
        for (int i=0;i<isi.length;i++){
            Bulan.addItem(isi[i]);} }
    
    public void CekTanggal () throws RemoteException{
        isi = LKS.Tanggal (isi);
    
        for (int i=0;i<isi.length;i++){
            Tanggal.addItem(isi[i]);} }
            
    private void TahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TahunActionPerformed
    
        
    }//GEN-LAST:event_TahunActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Bulan;
    private javax.swing.JComboBox Tahun;
    private javax.swing.JComboBox Tanggal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox lkeuangan;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
