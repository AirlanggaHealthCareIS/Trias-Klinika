/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import trias.klinika.client.reservasi.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.*;
import trias.klinika.api.sevice.DokterService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.InventoriObatDokterService;
import trias.klinika.api.sevice.LaporanKeuanganDokterService;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.api.sevice.ListPembayaranService;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.client.tabel.tabelrekammedis;
import trias.klinika.client.dokter.rekammedis;
import trias.klinika.client.tabel.TabelDokter;
import trias.klinika.api.sevice.pembayaranService;
import trias.klinika.client.dokter.form_pembayaran;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.client.Home.Login;
import trias.klinika.client.Home.Splash;
import trias.klinika.client.dokter.input_resep;
import trias.klinika.client.apotek.intro;
import trias.klinika.api.sevice.NotifikasiStokObatDokterService;
import trias.klinika.client.apotek.UtamaApotek;
/**
 *
 * @author Lenovo
 */
public class UtamaDokter extends javax.swing.JFrame {
    
    String localhost;
    Registry registry;
    final  InventoriObatDokterService service13;
    final  pembayaranService service4;
    final serviceRekam service6;
    final ServiceResep service7;
    final LaporanKeuanganDokterService service9_b_2;
    final NotifikasiStokObatDokterService service11_3;
    Inventori_Obat_Dokter iod ;
    form_pembayaran fp;
    rekammedis sr;
    input_resep ir;
    Laporan_keuangan_dokter lkd;
    private InventoriObatDokterService IODS;
    private pembayaranService FP;
    private serviceRekam SR;
    private ServiceResep IR;
    private LaporanKeuanganDokterService LKDS;
    private String[] isi;
    LoginEntitas LE;
    Login login;
    intro introw;
    
    boolean move_left = true;
    public Clip clip;
    public String ruta="/suara/";
    
    private JInternalFrame internalFrame0 = new JInternalFrame("Frame Itro");
    private JInternalFrame internalFrame1 = new JInternalFrame("Frame Inventori Obat Dokter");
    private JInternalFrame internalFrame2 = new JInternalFrame("Frame Pembayaran");
    private JInternalFrame internalFrame3 = new JInternalFrame("Data Pasien");
    private JInternalFrame internalFrame4 = new JInternalFrame("Frame Pembayaran");
    private JInternalFrame internalFrame5 = new JInternalFrame("Laporan Keuangan Dokter");
    
    public UtamaDokter(LoginEntitas LE, Login login)throws RemoteException,NotBoundException {
        new Splash().Awal();
        this.LE = LE;
        this.login = login;
        initComponents();
        localhost = this.login.getTitle();
        registry = LocateRegistry.getRegistry(localhost, 4444);
        service13 = (InventoriObatDokterService)registry.lookup("service13");
        service4 = (pembayaranService)registry.lookup("service4");
        service6 = (serviceRekam)registry.lookup("service6");
        service7 = (ServiceResep)registry.lookup("service7");
        service9_b_2 = (LaporanKeuanganDokterService)registry.lookup("service9_b_2");
        service11_3 = (NotifikasiStokObatDokterService)registry.lookup("service11_3");
        
        introw = new intro();
        iod = new Inventori_Obat_Dokter(service13, this);
        fp = new form_pembayaran(service4, this);
        sr = new rekammedis(service6, this);
        ir = new input_resep(service7, this);
        lkd = new Laporan_keuangan_dokter(service9_b_2, this);
        internal_frame();
        nama.setText("SELAMAT DATANG "+LE.getnamauser().toUpperCase());
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
        IDpemeriksaan.setVisible(true);
        rekamedistombol.setEnabled(false);
        byr.setEnabled(false);
        rsp.setEnabled(false);
        
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
 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        
        if(sr.ID.getText()!=""){
            rekamedistombol.setEnabled(true);
            byr.setEnabled(true);
            rsp.setEnabled(true);
        
        }
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
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        byr = new javax.swing.JButton();
        rekamedistombol = new javax.swing.JButton();
        rsp = new javax.swing.JButton();
        LaporanKeuanganDokter = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        IDpemeriksaan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 557));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 557));
        jPanel1.setLayout(null);

        jDesktopPane2.setMinimumSize(new java.awt.Dimension(1147, 557));
        jPanel1.add(jDesktopPane2);
        jDesktopPane2.setBounds(200, 0, 1147, 557);

        jButton1.setText("Inventory Obat Dokter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 10, 150, 50);

        byr.setText("Pembayaran");
        byr.setEnabled(false);
        byr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byrActionPerformed(evt);
            }
        });
        jPanel1.add(byr);
        byr.setBounds(20, 220, 150, 50);

        rekamedistombol.setText("Rekam Medis");
        rekamedistombol.setEnabled(false);
        rekamedistombol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekamedistombolActionPerformed(evt);
            }
        });
        jPanel1.add(rekamedistombol);
        rekamedistombol.setBounds(20, 80, 150, 50);

        rsp.setText("Resep");
        rsp.setEnabled(false);
        rsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rspActionPerformed(evt);
            }
        });
        jPanel1.add(rsp);
        rsp.setBounds(20, 150, 150, 50);

        LaporanKeuanganDokter.setText("Laporan");
        LaporanKeuanganDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanKeuanganDokterActionPerformed(evt);
            }
        });
        jPanel1.add(LaporanKeuanganDokter);
        LaporanKeuanganDokter.setBounds(20, 290, 150, 50);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(20, 360, 150, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-10, -190, 1390, 740);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 200, 1366, 557);

        nama.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("jLabel1");
        getContentPane().add(nama);
        nama.setBounds(20, 160, 530, 28);

        IDpemeriksaan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        IDpemeriksaan.setForeground(new java.awt.Color(255, 255, 51));
        IDpemeriksaan.setText("Belum ada pasien masuk");
        getContentPane().add(IDpemeriksaan);
        IDpemeriksaan.setBounds(30, 20, 270, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void internal_frame() {
        
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
        
        internalFrame1.add(iod.getContentPane());
        internalFrame1.pack();
        internalFrame1.setSize(1146,577);
        internalFrame1.setVisible(true);
        jDesktopPane2.add(internalFrame1);
        BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame1.getUI();
        Container north = (Container)ui.getNorthPane();
        north.remove(0);
        north.validate();
        north.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
        }
     
        internalFrame2.add(fp.getContentPane());
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
           
        internalFrame3.add(sr.getContentPane());
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
        
        internalFrame4.add(ir.getContentPane());
        internalFrame4.pack();;
        internalFrame4.setSize(1146,577);
        internalFrame4.setVisible(true);
        jDesktopPane2.add(internalFrame4);
        BasicInternalFrameUI ui4 = (BasicInternalFrameUI)internalFrame4.getUI();
        Container north4 = (Container)ui4.getNorthPane();
        north4.remove(0);
        north4.validate();
        north4.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame4.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame4.getUI()).getNorthPane().removeMouseListener(listener);
        }
        
        internalFrame5.add(lkd.getContentPane());
        internalFrame5.pack();;
        internalFrame5.setSize(1146,577);
        internalFrame5.setVisible(true);
        jDesktopPane2.add(internalFrame5);
        BasicInternalFrameUI ui5 = (BasicInternalFrameUI)internalFrame5.getUI();
        Container north5 = (Container)ui4.getNorthPane();
        north5.remove(0);
        north5.validate();
        north5.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame5.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame5.getUI()).getNorthPane().removeMouseListener(listener);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame1.setSelected(true);
            sonido("LYNC_joinedconference");

        } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void byrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byrActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame2.setSelected(true);
            fp.id.setText(IDpemeriksaan.getText());
            sonido("LYNC_joinedconference");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_byrActionPerformed

    private void rekamedistombolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekamedistombolActionPerformed
        // TODO add your handling code here:
        try {
            sr.ID.setText(service6.getIdPasien(IDpemeriksaan.getText()));
            sr.awal();
            internalFrame3.setSelected(true);
            sonido("LYNC_joinedconference");
        } catch(PropertyVetoException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_rekamedistombolActionPerformed

    private void rspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rspActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame4.setSelected(true);
            ir.ID_Pemeriksaan.setText(IDpemeriksaan.getText());
            ir.setIDPasien();
            sonido("LYNC_joinedconference");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_rspActionPerformed

    private void LaporanKeuanganDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanKeuanganDokterActionPerformed
        // TODO add your handling code here:
         try {
            internalFrame5.setSelected(true);
                        sonido("LYNC_joinedconference");

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_LaporanKeuanganDokterActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        try {
            login.getService5().Ubah_Status_Logout(LE);
            sonido("LYNC_joinedconference");
            login.kirim(new pesan("logout", login.getUsers().getnamauser(), login.getUsers().getusername(), "Reservasi"));
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(UtamaDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel IDpemeriksaan;
    private javax.swing.JButton LaporanKeuanganDokter;
    private javax.swing.JButton byr;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama;
    private javax.swing.JButton rekamedistombol;
    private javax.swing.JButton rsp;
    // End of variables declaration//GEN-END:variables
    public void kirimanAntreanImin (String Id, String Nama) {
        JOptionPane.showMessageDialog(null, "Pasien baru siap diperiksa");
            IDpemeriksaan.setText(Id);
            rekamedistombol.setEnabled(true);
    }
    
    public void NotifStokObatDokterKritis() {
    List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
    String [] Id_Obat = new String[0];
    String pesan = "List Obat Yang berada dalam keadaan kritis : \n";
    try {
        Id_Obat = service11_3.StokObatDokter(Id_Obat, service13.Spesialis(LE.getusername()));
        if (!"Tidak Ada Stok Obat Kritis".equals(Id_Obat[0])) {
            for (int i=0;i<Id_Obat.length;i++) {
                list.add(service11_3.getobat(Id_Obat[i], service13.Spesialis(LE.getusername())));
                pesan = pesan + (i+1) + ".  "+list.get(i).getNamaObat()+"   Dengan Sisa Stok = "+list.get(i).getQty()+"\n";
            }
            pesan = pesan + "Silahkan Melakukan Tindakan Atas Hal Ini";
            JOptionPane.showMessageDialog(this, pesan, "Notifikasi Obat Kritis",2);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(UtamaApotek.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SQLException ex) {
            Logger.getLogger(UtamaDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
