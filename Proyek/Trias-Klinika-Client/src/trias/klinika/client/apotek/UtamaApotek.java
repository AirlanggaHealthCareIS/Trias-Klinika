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
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.tabel.tabelInventoryObatApotek;
/**
 *
 * @author Azmil
 */
public class UtamaApotek extends javax.swing.JFrame {
String localhost = this.getTitle();
private tabelInventoryObatApotek tabelInventory = new tabelInventoryObatApotek();
Registry registry = LocateRegistry.getRegistry(localhost, 4444);
final InventoryObatApotekService service10 = (InventoryObatApotekService)registry.lookup("servie10");
InventoryObatApotek interfaceObat = new InventoryObatApotek (service10);
private InventoryObatApotekService IOAS;
private JInternalFrame internalFrame1 = new JInternalFrame("Frame Inventory Obat");
    /**
     * Creates new form UtamaApotek
     */
    public UtamaApotek() throws RemoteException,NotBoundException{
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
            System.out.println("sukses ya");
                    
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryActionPerformed

    /**
     * @param args the command line arguments
     */
public void internal_frame (){
        
           internalFrame1.add(interfaceObat.getContentPane());
        
           internalFrame1.pack();
         
           internalFrame1.setSize(1146,577);
         
           internalFrame1.setVisible(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane internalFrame;
    private javax.swing.JButton inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
