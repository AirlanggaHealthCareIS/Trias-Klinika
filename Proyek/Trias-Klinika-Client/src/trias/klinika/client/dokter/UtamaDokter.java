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
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.InventoriObatDokterService;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.api.sevice.ListPembayaranService;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.client.tabel.tabelrekammedis;
import trias.klinika.client.dokter.datapasien;
import trias.klinika.client.tabel.TabelDokter;
import trias.klinika.api.sevice.pembayaranService;
import trias.klinika.client.dokter.form_pembayaran;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.client.dokter.input_resep;
/**
 *
 * @author Lenovo
 */
public class UtamaDokter extends javax.swing.JFrame {
    
    String localhost = this.getTitle();
    Registry registry = LocateRegistry.getRegistry(localhost, 4444);
    final  InventoriObatDokterService service13 = (InventoriObatDokterService)registry.lookup("service13");
    final  pembayaranService service4 = (pembayaranService)registry.lookup("service4");
    final serviceRekam service6 = (serviceRekam)registry.lookup("service6");
    final ServiceResep service7 = (ServiceResep)registry.lookup("service7");
    Inventori_Obat_Dokter iod = new Inventori_Obat_Dokter(service13);
    form_pembayaran fp = new form_pembayaran(service4);
    datapasien sr = new datapasien(service6);
    input_resep ir = new input_resep(service7);
    private InventoriObatDokterService IODS;
    private pembayaranService FP;
    private serviceRekam SR;
    private ServiceResep IR;
    private String[] isi;
    LoginEntitas LE;
    
    
    /**
     * Creates new form Utama
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
    
    public UtamaDokter(LoginEntitas LE)throws RemoteException,NotBoundException {
        this.LE = LE;
        initComponents();
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
        jToggleButton4 = new javax.swing.JToggleButton();
        nama = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 557));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 557));

        jDesktopPane2.setMinimumSize(new java.awt.Dimension(1147, 557));

        jToggleButton1.setText("Inventori Obat Dokter");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Pembayaran");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Rekam Medis");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Resep");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        // TODO add your handling code here:
        try
        {
//        Kecil satu = new Kecil();
//        Besar dua = new Besar();
//        jDesktopPane1.add(imin);
//        imin.setVisible(true);
//            Pe.setTitle(this.getTitle());
//            Pe.setVisible(true);
            System.out.println("1 haha .. cemingut ^_^");
//           Antrean satu = new Antrean(DS);
            System.out.println("1.1");
           JInternalFrame internalFrame1 = new JInternalFrame("Frame Inventori Obat Dokter");
            System.out.println("1.2");
           internalFrame1.add(iod.getContentPane());
            System.out.println("1.3");
           internalFrame1.pack();
            System.out.println("1.4");
           internalFrame1.setSize(1146,577);
            System.out.println("1.5");
           internalFrame1.setVisible(true);
            System.out.println("1.6");
            
//            JComboBox JCB = new JComboBox();
//            isi = DS.Dropdowndokter(isi);
//        for (int i=0;i<isi.length;i++){
//            JCB.addItem(isi[i]);
//        }
           jDesktopPane2.add(internalFrame1);
//           internalFrame1.setClosable(true);
            System.out.println("2");
           BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame1.getUI();
           Container north = (Container)ui.getNorthPane();
           north.remove(0);
           north.validate();
           north.repaint();
            System.out.println("3");
           for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
        }
         internalFrame1.setSelected(true);
      
        }   
        catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
          System.out.println("syeemangat choy");
      }  
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        try
        {
            //        Kecil satu = new Kecil();
            //        Besar dua = new Besar();
            //        jDesktopPane1.add(imin);
            //        imin.setVisible(true);
            //            Pe.setTitle(this.getTitle());
            //            Pe.setVisible(true);
            System.out.println("1 haha .. cemingut ^_^");
            //           Antrean satu = new Antrean(DS);
            System.out.println("1.1");
            JInternalFrame internalFrame2 = new JInternalFrame("Frame Pembayaran");
            System.out.println("1.2");
            internalFrame2.add(fp.getContentPane());
            System.out.println("1.3");
            internalFrame2.pack();
            System.out.println("1.4");
            internalFrame2.setSize(1146,577);
            System.out.println("1.5");
            internalFrame2.setVisible(true);
            System.out.println("1.6");

            //            JComboBox JCB = new JComboBox();
            //            isi = DS.Dropdowndokter(isi);
            //        for (int i=0;i<isi.length;i++){
                //            JCB.addItem(isi[i]);
                //        }
            jDesktopPane2.add(internalFrame2);
            //           internalFrame1.setClosable(true);
            System.out.println("2");
            BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame2.getUI();
            Container north = (Container)ui.getNorthPane();
            north.remove(0);
            north.validate();
            north.repaint();
            System.out.println("3");
            for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
                ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
            }
            internalFrame2.setSelected(true);

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("syeemangat choy");
        }
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
// TODO add your handling code here:
    try
        {
            //        Kecil satu = new Kecil();
            //        Besar dua = new Besar();
            //        jDesktopPane1.add(imin);
            //        imin.setVisible(true);
            //            Pe.setTitle(this.getTitle());
            //            Pe.setVisible(true);
            System.out.println("1 haha .. cemingut ^_^");
            //           Antrean satu = new Antrean(DS);
            System.out.println("1.1");
            JInternalFrame internalFrame2 = new JInternalFrame("Data Pasien");
            System.out.println("1.2");
            internalFrame2.add(sr.getContentPane());
            System.out.println("1.3");
            internalFrame2.pack();
            System.out.println("1.4");
            internalFrame2.setSize(1146,577);
            System.out.println("1.5");
            internalFrame2.setVisible(true);
            System.out.println("1.6");

            //            JComboBox JCB = new JComboBox();
            //            isi = DS.Dropdowndokter(isi);
            //        for (int i=0;i<isi.length;i++){
                //            JCB.addItem(isi[i]);
                //        }
            jDesktopPane2.add(internalFrame2);
            //           internalFrame1.setClosable(true);
            System.out.println("2");
            BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame2.getUI();
            Container north = (Container)ui.getNorthPane();
            north.remove(0);
            north.validate();
            north.repaint();
            System.out.println("3");
            for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
                ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
            }
            internalFrame2.setSelected(true);

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("syeemangat choy");
        }
}//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        try
        {
            //        Kecil satu = new Kecil();
            //        Besar dua = new Besar();
            //        jDesktopPane1.add(imin);
            //        imin.setVisible(true);
            //            Pe.setTitle(this.getTitle());
            //            Pe.setVisible(true);
            System.out.println("1 haha .. cemingut ^_^");
            //           Antrean satu = new Antrean(DS);
            System.out.println("1.1");
            JInternalFrame internalFrame2 = new JInternalFrame("Frame Pembayaran");
            System.out.println("1.2");
            internalFrame2.add(ir.getContentPane());
            System.out.println("1.3");
            internalFrame2.pack();
            System.out.println("1.4");
            internalFrame2.setSize(1146,577);
            System.out.println("1.5");
            internalFrame2.setVisible(true);
            System.out.println("1.6");

            //            JComboBox JCB = new JComboBox();
            //            isi = DS.Dropdowndokter(isi);
            //        for (int i=0;i<isi.length;i++){
                //            JCB.addItem(isi[i]);
                //        }
            jDesktopPane2.add(internalFrame2);
            //           internalFrame1.setClosable(true);
            System.out.println("2");
            BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame2.getUI();
            Container north = (Container)ui.getNorthPane();
            north.remove(0);
            north.validate();
            north.repaint();
            System.out.println("3");
            for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
                ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
            }
            internalFrame2.setSelected(true);

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("syeemangat choy");
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel nama;
    // End of variables declaration//GEN-END:variables
}
