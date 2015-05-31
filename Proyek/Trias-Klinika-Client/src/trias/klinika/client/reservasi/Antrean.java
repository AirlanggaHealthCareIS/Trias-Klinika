
package trias.klinika.client.reservasi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.PasienEntity;
import trias.klinika.api.sevice.AntreanServis;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.client.tabel.TabelDokter;
import trias.klinika.client.tabel.TabelPasien;
import trias.klinika.api.entitas.PemeriksaanEntitas;
public class Antrean extends javax.swing.JInternalFrame {

    public TabelDokter tabeldokter = new TabelDokter();
    public TabelPasien tabelpasien = new TabelPasien();
    private AntreanServis AS;
    private String[] isi;
    private ListPetugasService LPS;
    public PemeriksaanEntitas PE = new PemeriksaanEntitas();
    public List<PasienEntity> list;
    private Object connection;
    private boolean sama = false;
    
    public Antrean(ListPetugasService LPS, AntreanServis AS)throws RemoteException {

        setTanggal(jLabel1);
        list = new ArrayList<>();
        this.LPS=LPS;
        this.AS=AS;
        initComponents();
        tabeldokter.setData(LPS.AmbilDokterOnline());
        tabelkanan.setModel(tabeldokter);
        tomboltambah.setEnabled(false);
        PilihDokter.setEnabled(false);
        imin.setVisible(false);
        kirim.setEnabled(false);
        reset.setEnabled(false);
        tabelkiri.setEnabled(false);
        
    }

         private void initiateComboBox1(){
        PilihDokter.removeAllItems();
             List<Dokter> pd;
        pd = tabeldokter.getDataDokter();
        tomboltambah.setEnabled(true);
            for(int i = 0; i<pd.size();i++){                
               PilihDokter.addItem(pd.get(i).getnama_dokter().toUpperCase());
            }
    
    }

         private void initiateComboBox2(){      
        PilihIDPasien.removeAllItems();
        List<PasienEntity> pe;
        PilihDokter.setEnabled(true);
        try {
            pe = AS.getPasienEntitys();
            for(int i = 0; i<pe.size();i++){                
               PilihIDPasien.addItem(pe.get(i).getid_pasien());         
            }            
        } catch (RemoteException ex) {
        }
    
    }
         
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkiri = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        PilihDokter = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkanan = new javax.swing.JTable();
        PilihIDPasien = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        imin = new javax.swing.JTextField();
        tomboltambah = new javax.swing.JButton();
        kirim = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        input = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1147, 557));
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

        tabelkiri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No Antrean", "ID Pasien", "ID Dokter"
            }
        ));
        tabelkiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkiriMouseClicked(evt);
            }
        });
        tabelkiri.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelkiriComponentShown(evt);
            }
        });
        tabelkiri.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabelkiriComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkiri);

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

        tabelkanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelkanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkananMouseClicked(evt);
            }
        });
        tabelkanan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelkananComponentShown(evt);
            }
        });
        tabelkanan.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabelkananComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(tabelkanan);

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

        imin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iminActionPerformed(evt);
            }
        });

        tomboltambah.setText("Tambah ke Antrean");
        tomboltambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboltambahActionPerformed(evt);
            }
        });

        kirim.setText("Kirim ID ke Dokter");
        kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimActionPerformed(evt);
            }
        });

        reset.setText("Reset ID Pasien");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        input.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        input.setForeground(new java.awt.Color(102, 102, 102));
        input.setText("Input ID Pasien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PilihIDPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PilihDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tomboltambah)
                        .addGap(18, 18, 18)
                        .addComponent(kirim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(imin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(356, 356, 356))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tomboltambah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PilihDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PilihIDPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kirim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        awal();
        ListAntrean();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        awal();
        ListAntrean();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        awal();
        ListAntrean();
    }//GEN-LAST:event_formComponentShown

    private void tabelkananComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelkananComponentShown
        // TODO add your handling code here:
         awal();
    }//GEN-LAST:event_tabelkananComponentShown

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        awal();
        ListAntrean();
    }//GEN-LAST:event_formComponentAdded

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        awal();
        ListAntrean();
    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        kirim.setEnabled(false);
        reset.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void tabelkananComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabelkananComponentAdded
        awal();
        System.out.println("imin part 8");
    }//GEN-LAST:event_tabelkananComponentAdded

    private void tabelkananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkananMouseClicked
 
        int row = tabelkanan.rowAtPoint(evt.getPoint());
        PasienEntity paen = new PasienEntity ();
        try {            
            paen = AS.getpasienkanan(tabeldokter.get(row).getid_dokter());
        } catch (RemoteException ex) {
            Logger.getLogger(Antrean.class.getName()).log(Level.SEVERE, null, ex);
        }

            Object selectedObj = tabelkanan.getValueAt(row, 0);

                try {
                tabelpasien.setData(this.AS.getpasienkiri(""+selectedObj,imin.getText()));
            } catch (RemoteException ex) {
                Logger.getLogger(Antrean.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabelkiri.setModel(tabelpasien);
            kirim.setEnabled(false);
            reset.setEnabled(false);
            tabelkiri.setEnabled(true);
           
    }//GEN-LAST:event_tabelkananMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void PilihDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihDokterActionPerformed

    }//GEN-LAST:event_PilihDokterActionPerformed

    private void PilihDokterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PilihDokterFocusGained

    }//GEN-LAST:event_PilihDokterFocusGained

    private void PilihDokterPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_PilihDokterPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        initiateComboBox1();

    }//GEN-LAST:event_PilihDokterPopupMenuWillBecomeVisible

    private void PilihIDPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihIDPasienActionPerformed

    }//GEN-LAST:event_PilihIDPasienActionPerformed

    private void PilihIDPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PilihIDPasienFocusGained

    }//GEN-LAST:event_PilihIDPasienFocusGained

    private void PilihIDPasienPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_PilihIDPasienPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        initiateComboBox2();
    }//GEN-LAST:event_PilihIDPasienPopupMenuWillBecomeVisible

    private void tabelkiriComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelkiriComponentShown
        ListAntrean();
    }//GEN-LAST:event_tabelkiriComponentShown

    private void tabelkiriComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabelkiriComponentAdded
        ListAntrean();
    }//GEN-LAST:event_tabelkiriComponentAdded

    private void tabelkiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkiriMouseClicked
        // TODO add your handling code here:
        kirim.setEnabled(true);
        reset.setEnabled(true);
    }//GEN-LAST:event_tabelkiriMouseClicked

    private void tomboltambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboltambahActionPerformed
        // TODO add your handling code here:
        sama = false;
        Dokter d =new Dokter();
        int id_dokter=0;
        kirim.setEnabled(false);
        reset.setEnabled(false);
//        try {
//            if(input.getText()==AS.getIDPasien()){
//                
//            }
//            String idpas = PilihIDPasien.getItemAt(PilihIDPasien.getSelectedIndex()).toString();
//            String iddok = tabeldokter.getDataDokter().get(PilihDokter.getSelectedIndex()-1).getid_dokter();
//            List<PemeriksaanEntitas> pemeriksaan = AS.getpasienkiri(iddok, imin.getText());
//            
//            for (int i = 0; i < pemeriksaan.size(); i++) {
//                if(pemeriksaan.get(i).getID_PASIEN().toString().equals(idpas)){
//                    sama = true;
//                    System.out.println(idpas);
//                }
//            }
//            if (sama) {
////                JOptionPane.showMessageDialog(null, "ID Pasien "+ idpas +" sudah ada di tabel antrean");
//                JOptionPane.showMessageDialog(null, "ID Pasien "+ idpas +" sudah ada di tabel antrean", "ERROR", JOptionPane.OK_OPTION);
//            }
//            
//            else if(!sama){
//                String ID = null;
//            int bayar=0;
//            PemeriksaanEntitas a = new PemeriksaanEntitas();
//            int c = AS.getPemeriksaans().size()+1;
//            ID = "PE000"+c;
//            int antri=0;
//            antri =  AS.nomorAntrean(antri, imin.getText(), tabeldokter.getDataDokter().get(PilihDokter.getSelectedIndex()-1).getid_dokter());
//            bayar = AS.getPemeriksaans().size();
//            
//            a.setID_PEMERIKSAAAN(ID);
//            a.setID_RESERVASI("R0001");
//            a.setID_PASIEN(idpas);
//            a.setID_DOKTER(iddok);
//            a.setTGL_PEMERIKSAAN(imin.getText());
//            a.setNO_ANTRIAN(antri);
//            
//            AS.insertPemeriksaan(a);
//
//            JOptionPane.showMessageDialog(null, "ID Pasien "+ idpas +"berhasil ditambahkan ke tabel antrean");
//                        refresh();
//            }
//            
//        } catch (RemoteException ex) {
//            Logger.getLogger(Antrean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_tomboltambahActionPerformed

    private void iminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iminActionPerformed

    private void kirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kirimActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    public void awal() {
        try{
             tabeldokter.setData(this.AS.getDokters());
             System.out.println("unyu 3");
        }catch(RemoteException exception){
             exception.printStackTrace();
            System.out.println("unyu 2");
         }
        tabelkanan.setModel(tabeldokter);
        System.out.println("unyu 1");
    }
    
    public void ListAntrean() {
        try{
             tabelpasien.setData(this.AS.getPemeriksaans());
             System.out.println("aa");
        }catch(RemoteException exception){
             exception.printStackTrace();
            System.out.println("bb");
         }
        tabelkiri.setModel(tabelpasien);
        System.out.println("cc");
    }
    
    private void refresh (){
        try {
            int antri=0;
            List<PemeriksaanEntitas> list = AS.buatRefreshing(imin.getText(), tabeldokter.getDataDokter().get(PilihDokter.getSelectedIndex()-1).getid_dokter());
            tabelpasien.setData(list);
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox PilihDokter;
    private javax.swing.JComboBox PilihIDPasien;
    private javax.swing.JTextField imin;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kirim;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabelkanan;
    private javax.swing.JTable tabelkiri;
    private javax.swing.JButton tomboltambah;
    // End of variables declaration//GEN-END:variables
public void setJam(final JLabel tampilJam) {
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Calendar cal = new GregorianCalendar();
        String nolJam = "";
        String nolMenit = "";
        String nolDetik = "";
        String nolTanggal = "";
        String nolBulan = "";
        String nolTahun = "";
        
        // Membuat Date
        Date dt = new Date();
        
        // Mengambil nilai JAM, MENIT, dan DETIK Sekarang
        int nilaiJam = dt.getHours();
        int nilaiMenit = dt.getMinutes();
        int nilaiDetik = dt.getSeconds();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH);
        int nilaiTahun = cal.get(Calendar.YEAR);
        
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilaiJam <= 9) {
          // Tambahkan "0" didepannya
          nolJam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilaiMenit <= 9) {
          // Tambahkan "0" didepannya
          nolMenit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilaiDetik <= 9) {
          // Tambahkan "0" didepannya
          nolDetik = "0";
        }
        if (nilaiTanggal<10){
            nolTanggal="0";
        }
        if ((nilaiBulan+1)<10){
            nolBulan="0";
        }
        if (nilaiTahun<10){
            nolTahun="0";
        }
        
        // Membuat String JAM, MENIT, DETIK
        String jam = nolJam + Integer.toString(nilaiJam);
        String menit = nolMenit + Integer.toString(nilaiMenit);
        String detik = nolDetik + Integer.toString(nilaiDetik);
        String tanggal = nolTanggal + Integer.toString(nilaiTanggal);
        String bulan = nolBulan + Integer.toString(nilaiBulan+1);
        String tahun = nolTahun + Integer.toString(nilaiTahun);
        
        // Menampilkan pada Layar
        tampilJam.setText(jam+":"+menit+":"+detik);
      }
      
    };
    // Timer
    new Timer(1000, taskPerformer).start();
    }

public void setTanggal(final JLabel tampilTanggal) {
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Calendar cal = new GregorianCalendar();
        String nolJam = "";
        String nolMenit = "";
        String nolDetik = "";
        String nolTanggal = "";
        String nolBulan = "";
        String nolTahun = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilai JAM, MENIT, dan DETIK Sekarang
        int nilaiJam = dt.getHours();
        int nilaiMenit = dt.getMinutes();
        int nilaiDetik = dt.getSeconds();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH);
        int nilaiTahun = cal.get(Calendar.YEAR);
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilaiJam <= 9) {
          // Tambahkan "0" didepannya
          nolJam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilaiMenit <= 9) {
          // Tambahkan "0" didepannya
          nolMenit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilaiDetik <= 9) {
          // Tambahkan "0" didepannya
          nolDetik = "0";
        }
        if (nilaiTanggal<10){
            nolTanggal="0";
        }
        if ((nilaiBulan+1)<10){
            nolBulan="0";
        }
        if (nilaiTahun<10){
            nolTahun="0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nolJam + Integer.toString(nilaiJam);
        String menit = nolMenit + Integer.toString(nilaiMenit);
        String detik = nolDetik + Integer.toString(nilaiDetik);
        String tanggal = nolTanggal + Integer.toString(nilaiTanggal);
        String bulan = nolBulan + Integer.toString(nilaiBulan+1);
        String tahun = nolTahun + Integer.toString(nilaiTahun);
        // Menampilkan pada Layar
//        tampilTanggal.setText(tanggal+"-"+bulan+"-"+tahun);
        imin.setText(tahun+"-"+bulan+"-"+tanggal);
//        imin.setEnabled(false);
      }
      
    };
    // Timer
    new Timer(1000, taskPerformer).start();
    }
}
