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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        iod = new Inventori_Obat_Dokter(service13, this);
        fp = new form_pembayaran(service4);
        sr = new rekammedis(service6);
        ir = new input_resep(service7);
        lkd = new Laporan_keuangan_dokter(service9_b_2, this);
        internal_frame();
        nama.setText(LE.getnamauser());
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
        
        ImageIcon ico = new ImageIcon("src/image/imin.png");
        setIconImage(ico.getImage());
 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        LaporanKeuanganDokter = new javax.swing.JToggleButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
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
        jDesktopPane2.setBounds(155, 0, 1147, 557);

        jToggleButton1.setText("Inventori Obat Dokter");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1);
        jToggleButton1.setBounds(10, 0, 139, 46);

        jToggleButton2.setText("Pembayaran");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2);
        jToggleButton2.setBounds(10, 50, 139, 41);

        jToggleButton3.setText("Rekam Medis");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3);
        jToggleButton3.setBounds(10, 100, 139, 41);

        jToggleButton4.setText("Resep");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton4);
        jToggleButton4.setBounds(10, 150, 139, 41);

        LaporanKeuanganDokter.setText("Laporan");
        LaporanKeuanganDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanKeuanganDokterActionPerformed(evt);
            }
        });
        jPanel1.add(LaporanKeuanganDokter);
        LaporanKeuanganDokter.setBounds(10, 200, 140, 40);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(10, 260, 140, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 560);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 200, 1366, 557);

        nama.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("jLabel1");
        getContentPane().add(nama);
        nama.setBounds(198, 160, 180, 28);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            internalFrame1.setSelected(true);
        } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, ex);
        }  
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            internalFrame2.setSelected(true);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
    try {
        internalFrame3.setSelected(true);
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        try {
            internalFrame4.setSelected(true);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    public void internal_frame() {
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
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            login.getService5().Ubah_Status_Logout(LE);
            login.kirim(new pesan("logout", login.getUsers().getnamauser(), login.getUsers().getusername(), "Reservasi"));
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(UtamaDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void LaporanKeuanganDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanKeuanganDokterActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame5.setSelected(true);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_LaporanKeuanganDokterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton LaporanKeuanganDokter;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama;
    // End of variables declaration//GEN-END:variables
}
