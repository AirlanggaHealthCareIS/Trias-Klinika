/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.apotek;
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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.tabel.tabelInventoryObatApotek;
import trias.klinika.api.sevice.LaporanKeuanganService;
import trias.klinika.client.Home.Login;
import trias.klinika.client.Home.Splash;
import trias.klinika.client.tabel.TabelLaporanKeuanganApotek;
/**
 *
 * @author Azmil
 */
public class UtamaApotek extends javax.swing.JFrame {
String localhost = this.getTitle();
private tabelInventoryObatApotek tabelInventory = new tabelInventoryObatApotek();
Registry registry = LocateRegistry.getRegistry(localhost, 4444);
final InventoryObatApotekService service10 = (InventoryObatApotekService)registry.lookup("service10");
InventoryObatApotek interfaceObat = new InventoryObatApotek (service10);
private InventoryObatApotekService IOAS;
private JInternalFrame internalFrame1 = new JInternalFrame("Frame Inventory Obat");

private TabelLaporanKeuanganApotek TLKA = new TabelLaporanKeuanganApotek();
final LaporanKeuanganService service9_c_1 = (LaporanKeuanganService)registry.lookup("service9_c_1");
LaporanKeuanganApotek laporankeuanganapotek = new LaporanKeuanganApotek(service9_c_1);
private LaporanKeuanganService LKS;
private JInternalFrame internalFrame2 = new JInternalFrame("Frame Laporan Keuangan obat");
LoginEntitas LE;
Login login;
   



    public UtamaApotek(LoginEntitas LE, Login login) throws RemoteException,NotBoundException{
        new Splash().Awal();
        this.LE = LE;
        this.login = login;
        initComponents();
        internal_frame ();
        nama.setText(localhost);
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
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

        inventory = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        internalFrame = new javax.swing.JDesktopPane();
        laporankeuangan = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1147, 768));
        getContentPane().setLayout(null);

        inventory.setText("Inventory Obat Apotek");
        inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryActionPerformed(evt);
            }
        });
        getContentPane().add(inventory);
        inventory.setBounds(30, 210, 145, 23);

        nama.setText("APOTEK");
        nama.setEnabled(false);
        getContentPane().add(nama);
        nama.setBounds(330, 10, 120, 30);

        internalFrame.setPreferredSize(new java.awt.Dimension(1147, 570));

        javax.swing.GroupLayout internalFrameLayout = new javax.swing.GroupLayout(internalFrame);
        internalFrame.setLayout(internalFrameLayout);
        internalFrameLayout.setHorizontalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1147, Short.MAX_VALUE)
        );
        internalFrameLayout.setVerticalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(internalFrame);
        internalFrame.setBounds(220, 190, 1147, 570);

        laporankeuangan.setText("Laporan Keuangan Apotek");
        laporankeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporankeuanganActionPerformed(evt);
            }
        });
        getContentPane().add(laporankeuangan);
        laporankeuangan.setBounds(20, 260, 160, 23);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(30, 300, 65, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
       try {
           internalFrame.removeAll();
           internalFrame.add(internalFrame1);
           System.out.println("1");
           BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame1.getUI();
           Container north = (Container)ui.getNorthPane();
            north.remove(0);
            north.validate();
            north.repaint();
            System.out.println("1");
            for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
                ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
            }
            internalFrame1.setSelected(true);
       }
            catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
            System.out.println("semangat ya");
                    
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryActionPerformed

    private void laporankeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporankeuanganActionPerformed
         try
        {
            
            internalFrame.removeAll();
           internalFrame.add(internalFrame2);
           System.out.println("2");
           BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame2.getUI();
           Container north = (Container)ui.getNorthPane();
            north.remove(0);
            north.validate();
            north.repaint();
            System.out.println("2");
            for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
                ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
            }
            internalFrame2.setSelected(true);
       }
            catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
            System.out.println("semangat ya");
        }
    }//GEN-LAST:event_laporankeuanganActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            login.getService5().Ubah_Status_Logout(LE);
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(UtamaApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
public void internal_frame (){
        
           internalFrame1.add(interfaceObat.getContentPane());
        
           internalFrame1.pack();
         
           internalFrame1.setSize(1146,577);
         
           internalFrame1.setVisible(true);
           
           internalFrame2.add(laporankeuanganapotek.getContentPane());
    
           internalFrame2.pack();
      
           internalFrame2.setSize(1146,577);
 
           internalFrame2.setVisible(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane internalFrame;
    private javax.swing.JButton inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton laporankeuangan;
    private javax.swing.JButton logout;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
