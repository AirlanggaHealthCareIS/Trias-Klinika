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
import java.util.logging.Level;
import java.util.logging.Logger;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.api.sevice.ListPembayaranService;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.api.sevice.AntreanServis;
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
    TriasKlinika_Pendaftaran daft;
    Antrean Ant;
    TriasKlinika_ListPembayaran LP;
    
    private ListPembayaranService LPS;
    private AntreanServis AS;
    private PendaftaranService PS;
    private String[] isi;
    LoginEntitas LE;
    private JInternalFrame internalFrame1 = new JInternalFrame("Frame Antrean");
    private JInternalFrame internalFrame2 = new JInternalFrame("Frame Pendaftaran");
    private JInternalFrame internalFrame3 = new JInternalFrame("Frame List Pembayaran");
    private JInternalFrame internalFrame4 = new JInternalFrame("Laporan Pasien");
    Login login;
    
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
        daft = new TriasKlinika_Pendaftaran(service2, LE);
        Ant = new Antrean(service5,service3);
        LP = new TriasKlinika_ListPembayaran(service12);
        internal_frame();
        nama.setText(LE.getnamauser());
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
        
        ImageIcon ico = new ImageIcon("src/image/imin.png");
        setIconImage(ico.getImage());
 
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension frameSize = getSize();
//        setLocation(
//        (screenSize.width - frameSize.width) / 2,
//        (screenSize.height - frameSize.height) / 2);
   
//        
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(174, 174, 174))
        );

        nama.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
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
                .addGap(8, 8, 8)
                .addComponent(nama)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
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
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            internalFrame3.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame2.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame1.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            login.getService5().Ubah_Status_Logout(LE);
            login.kirim(new pesan("logout", login.getUsers().getnamauser(), login.getUsers().getusername(), "Server"));
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed
    public void internal_frame (){
        
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama;
    // End of variables declaration//GEN-END:variables
}
