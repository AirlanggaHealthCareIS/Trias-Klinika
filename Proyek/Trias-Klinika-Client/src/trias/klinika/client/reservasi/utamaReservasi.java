package trias.klinika.client.reservasi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.*;
import trias.klinika.api.sevice.DokterService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.api.sevice.ListPembayaranService;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.api.sevice.AntreanServis;
import trias.klinika.api.sevice.LaporanDataObatKeluarService;
import trias.klinika.api.sevice.laporankeuanganReservasiService;
import trias.klinika.client.Home.Login;
import trias.klinika.client.tabel.TabelDokter;
import trias.klinika.client.Home.Splash;

/**
 *
 * @author Lenovo
 */
public class utamaReservasi extends javax.swing.JFrame {
    
    String localhost;
    private TabelDokter tabeldokter = new TabelDokter();
    Registry registry;
    final  PendaftaranService service2;
    final  ListPembayaranService service12;
    final  AntreanServis service3;
    final  ListPetugasService service5;
    final laporankeuanganReservasiService service9_a_1;
    final LaporanDataObatKeluarService service9_c_2;
    TriasKlinika_Pendaftaran daft;
    Antrean Ant;
    intro introw;
    TriasKlinika_ListPembayaran LP;
    laporanKeuanganReservasi KR ;
    TriasKlinika_LaporanDataObatKeluar LDOK ;
    
    private LaporanDataObatKeluarService LDOKS;
    private ListPembayaranService LPS;
    private AntreanServis AS;
    private PendaftaranService PS;
    private String[] isi;
    LoginEntitas LE;
    private JInternalFrame internalFrame0 = new JInternalFrame("Frame Itro");
    private JInternalFrame internalFrame1 = new JInternalFrame("Frame Antrean");
    private JInternalFrame internalFrame2 = new JInternalFrame("Frame Pendaftaran");
    private JInternalFrame internalFrame3 = new JInternalFrame("Frame List Pembayaran");
    private JInternalFrame internalFrame4 = new JInternalFrame("Laporan Pasien");
    private JInternalFrame internalFrame5 = new JInternalFrame ("laporan Reservasi");
    private JInternalFrame internalFrame6 = new JInternalFrame ("Laporan Obat Keluar");
    
    Login login;
    
    boolean move_left = true;
    public Clip clip;
    public String ruta="/suara/";
    
    /**
     * Creates new form Utama
     * @param LE
     * @param login
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    
    public utamaReservasi(LoginEntitas LE, Login login)throws RemoteException,NotBoundException {
        new Splash().Awal();
        this.LE = LE;
        this.login = login;
        initComponents();
        localhost = this.login.getTitle();
        registry = LocateRegistry.getRegistry(localhost, 4444);
        service2 = (PendaftaranService)registry.lookup("service2");
        service12 = (ListPembayaranService)registry.lookup("service12");
        service3 = (AntreanServis)registry.lookup("service3");
        service5 = (ListPetugasService)registry.lookup("service5"); 
        service9_a_1 = (laporankeuanganReservasiService)registry.lookup("service9_a_1");
        service9_c_2 = (LaporanDataObatKeluarService)registry.lookup("service9_c_2");
        KR = new laporanKeuanganReservasi (service9_a_1,this);
        LDOK = new TriasKlinika_LaporanDataObatKeluar (service9_c_2,this);
//        daft = new TriasKlinika_Pendaftaran(service2, LE);
        Ant = new Antrean(service5,service3,this);
        LP = new TriasKlinika_ListPembayaran(service12);
        introw = new intro();
        internal_frame();
        nama.setText("SELAMAT DATANG "+LE.getnamauser().toUpperCase());
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
        ImageIcon ico = new ImageIcon("src/image/imin.png");
        setIconImage(ico.getImage());
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        java.util.Timer timer = new java.util.Timer();
        TimerTask task =  new TimerTask(){
            
            public void run()
            {
                   if(move_left==true)
                   {
                       nama.setLocation(nama.getLocation().x-5, nama.getLocation().y);
                       if(nama.getLocation().x<0)
                       {
                           move_left = false;
                       }
                   }
                   else if(move_left==false)
                   {
                       nama.setLocation(nama.getLocation().x+5, nama.getLocation().y);
                       if(nama.getLocation().x>1366)
                       {
                           move_left = true;
                       }
                   }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);
 
 
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension frameSize = getSize();
//        setLocation(
//        (screenSize.width - frameSize.width) / 2,
//        (screenSize.height - frameSize.height) / 2);
   
//        
    }
    
    public void sonido(String archivo)
    {
//        JOptionPane.showMessageDialog(null, "hai bro");
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
            clip.start();
        }catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        reservasi = new javax.swing.JToggleButton();
        LaporanObatKeluar = new javax.swing.JButton();
        nama = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);

        jButton1.setText("Antrean");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pendaftaran");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("List Pembayaran");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Laporan Pasien");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        reservasi.setText("Laporan Reservasi");
        reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasiActionPerformed(evt);
            }
        });

        LaporanObatKeluar.setText("Laporan Obat Keluar");
        LaporanObatKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanObatKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LaporanObatKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reservasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LaporanObatKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        nama.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 204));
        nama.setText("jLabel1");

        jDesktopPane2.setMinimumSize(new java.awt.Dimension(1147, 557));

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nama)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(nama)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Laporan Pasien");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame4.setSelected(true);
            sonido("LYNC_joinedconference");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame3.setSelected(true);
            sonido("LYNC_joinedconference");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame2.setSelected(true);
            sonido("LYNC_joinedconference");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame1.setSelected(true);
            sonido("LYNC_joinedconference");
            Ant.jTextField1.setText(LE.getusername());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            login.getService5().Ubah_Status_Logout(LE);
            sonido("LYNC_joinedconference");
            login.kirim(new pesan("logout", login.getUsers().getnamauser(), login.getUsers().getusername(), "Server"));
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

private void reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasiActionPerformed
// TODO add your handling code here:
        try {
            internalFrame5.setSelected(true);
            sonido("LYNC_joinedconference");
        
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
                                             
}//GEN-LAST:event_reservasiActionPerformed

    private void LaporanObatKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanObatKeluarActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame6.setSelected(true);
            sonido("LYNC_joinedconference");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_LaporanObatKeluarActionPerformed
    public void internal_frame (){
        
        internalFrame0.add(introw.getContentPane());
        internalFrame0.pack();
        internalFrame0.setSize(1146,577);
        internalFrame0.setVisible(true);
        jDesktopPane2.add(internalFrame0);
        BasicInternalFrameUI ui0 = (BasicInternalFrameUI)internalFrame0.getUI();
        Container north0 = (Container)ui0.getNorthPane();
        north0.remove(0);
        north0.validate();
        north0.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame0.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame0.getUI()).getNorthPane().removeMouseListener(listener);
        }
     
        internalFrame2.add(daft.getContentPane());
        internalFrame2.pack();
        internalFrame2.setSize(1146,577);
        internalFrame2.setVisible(true);
        jDesktopPane2.add(internalFrame2);
        BasicInternalFrameUI ui2 = (BasicInternalFrameUI)internalFrame2.getUI();
        Container north2 = (Container)ui2.getNorthPane();
        north2.remove(0);
        north2.validate();
        north2.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
        }
           
        internalFrame1.add(Ant.getContentPane());
        internalFrame1.pack();
        internalFrame1.setSize(1146,577);
        internalFrame1.setVisible(true);
        jDesktopPane2.add(internalFrame1);
        BasicInternalFrameUI ui1 = (BasicInternalFrameUI)internalFrame1.getUI();
        Container north1 = (Container)ui1.getNorthPane();
        north1.remove(0);
        north1.validate();
        north1.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
        }
        
        internalFrame3.add(LP.getContentPane());
        internalFrame3.pack();
        internalFrame3.setSize(1146,577);
        internalFrame3.setVisible(true);
        jDesktopPane2.add(internalFrame3);
        BasicInternalFrameUI ui3 = (BasicInternalFrameUI)internalFrame3.getUI();
        Container north3 = (Container)ui3.getNorthPane();
        north3.remove(0);
        north3.validate();
        north3.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame3.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame3.getUI()).getNorthPane().removeMouseListener(listener);
        }
        internalFrame4.add(Ant.getContentPane());
        internalFrame4.pack();
        internalFrame4.setSize(1146,577);
        internalFrame4.setVisible(true);
        jDesktopPane2.add(internalFrame4);
        BasicInternalFrameUI ui4 = (BasicInternalFrameUI)internalFrame4.getUI();
        Container north4 = (Container)ui4.getNorthPane();
        north1.remove(0);
        north1.validate();
        north1.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame4.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame4.getUI()).getNorthPane().removeMouseListener(listener);
        }
        internalFrame5.add(KR.getContentPane());
        internalFrame5.pack();
        internalFrame5.setSize(1146,577);
        internalFrame5.setVisible(true);
        jDesktopPane2.add(internalFrame5);
        BasicInternalFrameUI ui5 = (BasicInternalFrameUI)internalFrame5.getUI();
        Container north5 = (Container)ui3.getNorthPane();
        north3.remove(0);
        north3.validate();
        north3.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame5.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame5.getUI()).getNorthPane().removeMouseListener(listener);
  
    }
        internalFrame6.add(LDOK.getContentPane());
        internalFrame6.pack();
        internalFrame6.setSize(1146,577);
        internalFrame6.setVisible(true);
        jDesktopPane2.add(internalFrame6);
        BasicInternalFrameUI ui6 = (BasicInternalFrameUI)internalFrame6.getUI();
        Container north6 = (Container)ui6.getNorthPane();
        north1.remove(0);
        north1.validate();
        north1.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame6.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame6.getUI()).getNorthPane().removeMouseListener(listener);
        }
    }
   public void updatelist (String Id, String Nama) {
        JOptionPane.showMessageDialog(null, Nama+" Sudah Aktif dan Siap Menerima Pasien");
        try {
            Ant.tabeldokter.insert(service5.AmbilData(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatelogout (String Id, String Nama) {
        JOptionPane.showMessageDialog(null, Nama+" Telah melakukan Logout");
        try {
            Ant.tabeldokter.delete(service5.AmbilData(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatelist2 (String Id, String Nama){
        JOptionPane.showMessageDialog(null, Id+" Masuk ke Daftar Tagihan");
        try {
            LP.TLP.insert(service12.AmbilData(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LaporanObatKeluar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama;
    private javax.swing.JToggleButton reservasi;
    // End of variables declaration//GEN-END:variables
}
