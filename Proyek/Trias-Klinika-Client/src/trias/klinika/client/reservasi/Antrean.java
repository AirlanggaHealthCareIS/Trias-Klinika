
package trias.klinika.client.reservasi;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.PasienEntity;
import trias.klinika.api.sevice.AntreanServis;
import trias.klinika.api.sevice.ListPetugasService;
//import trias.klinika.api.sevice.PasienService;
import trias.klinika.client.tabel.TabelDokter;
//import trias.klinika.api.sevice.PemeriksaanService;
//import trias.klinika.api.entitas.Pemeriksaan;

public class Antrean extends javax.swing.JInternalFrame {

    private TabelDokter tabeldokter = new TabelDokter();
    private AntreanServis AS;
    private String[] isi;
    private ListPetugasService LPS;
//    private PemeriksaanService PS;
    
    public Antrean(ListPetugasService LPS, AntreanServis AS)throws RemoteException {

        this.LPS=LPS;
        this.AS=AS;
        initComponents();
        tabeldokter.setData(LPS.AmbilDokterOnline());

         jTable2.setModel(tabeldokter);

    }
         private void initiateComboBox1(){
             System.out.println("skrol 1");
        PilihDokter.removeAllItems();
             System.out.println("skrol 2");
        List<Dokter> pd;
             System.out.println("skrol 3");
        try {
            pd = AS.getDokters();
            System.out.println("skrol 4");
            for(int i = 0; i<pd.size();i++){                
               PilihDokter.addItem(pd.get(i).getnama_dokter().toUpperCase());           
                System.out.println("skrol 5");
            }            
        } catch (RemoteException ex) {
//            Logger.getLogger(Form_tambah_bahan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("skrol 6");
        }
    
    }

         private void initiateComboBox2(){
        PilihIDPasien.removeAllItems();        
        List<PasienEntity> pe;
        try {
            pe = AS.getPasienEntitys();
            for(int i = 0; i<pe.size();i++){                
               PilihIDPasien.addItem(pe.get(i).getid_pasien());         
            }            
        } catch (RemoteException ex) {
            System.out.println("fatich");
//            Logger.getLogger(Form_tambah_bahan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
         
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelantrean = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        PilihDokter = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        TambahAntrean = new javax.swing.JToggleButton();
        PilihIDPasien = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(1146, 577));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        tabelantrean.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "ID Pasien", "Nama", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelantrean);

        jLabel4.setText("List Dokter yang Aktif");

        PilihDokter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  Pilih Dokter" }));
        PilihDokter.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                PilihDokterPopupMenuWillBecomeVisible(evt);
            }
        });
        PilihDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilihDokterActionPerformed(evt);
            }
        });
        PilihDokter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PilihDokterFocusGained(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "1", "2", "3"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable2ComponentShown(evt);
            }
        });
        jTable2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable2ComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        TambahAntrean.setText("Tambah ke Antrean");
        TambahAntrean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahAntreanActionPerformed(evt);
            }
        });

        PilihIDPasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " Pilih ID Pasien" }));
        PilihIDPasien.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                PilihIDPasienPopupMenuWillBecomeVisible(evt);
            }
        });
        PilihIDPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilihIDPasienActionPerformed(evt);
            }
        });
        PilihIDPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PilihIDPasienFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PilihIDPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(PilihDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(TambahAntrean))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PilihDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahAntrean, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(PilihIDPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        awal();
        System.out.println("imin part 1");
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        awal();
        System.out.println("imin part 2");
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        awal();
        System.out.println("imin part 3");
    }//GEN-LAST:event_formComponentShown

    private void jTable2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentShown
        // TODO add your handling code here:
         awal();
         System.out.println("imin part 4");
    }//GEN-LAST:event_jTable2ComponentShown

    private void TambahAntreanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahAntreanActionPerformed
        // TODO add your handling code here:
//       boolean isi1 = false;
//       boolean isi2 = false;
//
//        if(!PilihIDPasien.getItemAt(PilihIDPasien.getSelectedIndex()).toString().equals("Pilih ID Pasien")){
//            isi1 = true;
//        }
//        if(!PilihDokter.getItemAt(PilihDokter.getSelectedIndex()).toString().equals("Pilih Dokter")){
//            isi2 = true;
//        }
//        if(isi1&&isi2)    {
//            
//            String idpas = PilihIDPasien.getItemAt(PilihIDPasien.getSelectedIndex()).toString();
//            String iddok =  PilihDokter.getItemAt(PilihDokter.getSelectedIndex()).toString();
//            try {
//                Dokter d = new Dokter();
//                PasienEntity p = new PasienEntity();
//                d.setid_dokter(iddok);
//                p.setid_pasien(idpas);
//                DoSer.insertDokter(d);
//                PaSer.insertIDPasien(p);
//                Pemeriksaan temp1 = new Pemeriksaan();
////                Dokter temp=DoSer.getLastBahan();
////                PasienEntity temp=PaSer.getLastBahan();
//
//                temp1.setid_pemeriksaan(idpas);
//                temp1.setid_rekam_medis(idpas);
//                temp1.setid_reservasi(idpas);
//                temp1.setid_pasien(idpas);
//                temp1.setid_dokter(iddok);
//                temp1.setid_resep(WIDTH);
//                temp1.setid_pembayaran(WIDTH);
//                temp1.settgl_pemeriksaan(idpas);
//                temp1.setno_antrean(WIDTH);
//                PS.insertPasienDokter(temp1);
////                int opsi = JOptionPane.showConfirmDialog(null, "Data Anda berhasil disimpan. Apakah Anda akan menambahkan data lagi?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
////                if(opsi==0){
////                    refresh();
////                }
////                else{
////                    f.setVisible(true);
////                    this.dispose();
////                }
//            }
//            catch(RemoteException exception){
//                exception.printStackTrace();
//            }
//        }
//        else{
//            if(!isi1){
//                jTextField2.setBackground(Color.red);
//            }
//            if(!isi2){
//                jTextField3.setBackground(Color.red);
//            }
//            if(!isi3){
//                jComboBox1.setBackground(Color.red);
//            }
//            if(!isi4){
//                jComboBox2.setBackground(Color.red);
//            }
//            JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
        System.out.println("imin part 5");
    }//GEN-LAST:event_TambahAntreanActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        awal();
        System.out.println("imin part 6");
    }//GEN-LAST:event_formComponentAdded

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        awal();
        System.out.println("imin part 7");
    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jTable2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable2ComponentAdded
        // TODO add your handling code here:
        awal();
        System.out.println("imin part 8");
    }//GEN-LAST:event_jTable2ComponentAdded

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void PilihDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihDokterActionPerformed
        System.out.println("dokter imin 1");
    }//GEN-LAST:event_PilihDokterActionPerformed

    private void PilihDokterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PilihDokterFocusGained
        // TODO add your handling code here:
        System.out.println("dokter imin 2");
    }//GEN-LAST:event_PilihDokterFocusGained

    private void PilihDokterPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_PilihDokterPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        initiateComboBox1();
        System.out.println("dokter imin 3");
    }//GEN-LAST:event_PilihDokterPopupMenuWillBecomeVisible

    private void PilihIDPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihIDPasienActionPerformed
        // TODO add your handling code here:
        System.out.println("pasien imin 1");
    }//GEN-LAST:event_PilihIDPasienActionPerformed

    private void PilihIDPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PilihIDPasienFocusGained
        // TODO add your handling code here:
        System.out.println("pasien imin 2");
    }//GEN-LAST:event_PilihIDPasienFocusGained

    private void PilihIDPasienPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_PilihIDPasienPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        initiateComboBox2();
        System.out.println("pasien imin 3");
    }//GEN-LAST:event_PilihIDPasienPopupMenuWillBecomeVisible

    public TabelDokter getTabel() {
        return tabeldokter;
    }
    
    public void awal() {
        try{
             tabeldokter.setData(this.AS.getDokters());
             System.out.println("unyu 3");
        }catch(RemoteException exception){
             exception.printStackTrace();
            System.out.println("unyu 2");
         }
        jTable2.setModel(tabeldokter);
        System.out.println("unyu 1");
    }
//    private void Dropdown() throws RemoteException{
//        isi = DoSer.Dropdowndokter(isi);
//    
//        for (int i=0;i<isi.length;i++){
//            jComboBox3.addItem(isi[i]);
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox PilihDokter;
    private javax.swing.JComboBox PilihIDPasien;
    private javax.swing.JToggleButton TambahAntrean;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabelantrean;
    // End of variables declaration//GEN-END:variables
}
