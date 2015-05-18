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
    
    String localhost = this.getTitle();
    private TabelDokter tabeldokter = new TabelDokter();
    Registry registry = LocateRegistry.getRegistry(localhost, 4444);
    final  PendaftaranService service2 = (PendaftaranService)registry.lookup("service2");
    final  ListPembayaranService service12 = (ListPembayaranService)registry.lookup("service12");
    final  AntreanServis service3 = (AntreanServis)registry.lookup("service3");
    final  ListPetugasService service5 = (ListPetugasService)registry.lookup("service5");
        
    TriasKlinika_Pendaftaran daft = new TriasKlinika_Pendaftaran(service2);
    Antrean Ant = new Antrean(service5,service3);
   
    TriasKlinika_ListPembayaran LP = new TriasKlinika_ListPembayaran(service12);
    
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
    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        try {
//        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//        SwingUtilities.updateComponentTreeUI(new Utama());
//        } catch (Exception e){
// 
//        }
//        new Utama().setVisible(true);
//    }
    
    public utamaReservasi(LoginEntitas LE, Login login)throws RemoteException,NotBoundException {
        new Splash().Awal();
        this.LE = LE;
        this.login = login;
        initComponents();
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
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        logout = new javax.swing.JButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        nama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);

        jDesktopPane2.setMinimumSize(new java.awt.Dimension(1147, 557));

        jToggleButton1.setText("Antrean");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Pendaftaran");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("List Pembayaran");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Laporan Pasien");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToggleButton4.getAccessibleContext().setAccessibleName("Laporan Pasien");

        nama.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nama.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Laporan Pasien");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try{    
            internalFrame2.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("syeemangat choy");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try{
            internalFrame1.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        try {
            internalFrame3.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            login.getService5().Ubah_Status_Logout(LE);
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        try{
            internalFrame4.setSelected(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed
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
            Ant.getTabel().insert(service5.AmbilData(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatelogout (String Id, String Nama) {
        JOptionPane.showMessageDialog(null, Nama+" Telah melakukan Logout");
        try {
            Ant.getTabel().delete(service5.AmbilData(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(utamaReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama;
    // End of variables declaration//GEN-END:variables
}
