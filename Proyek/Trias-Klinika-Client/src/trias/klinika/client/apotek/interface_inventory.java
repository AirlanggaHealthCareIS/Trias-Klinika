/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.apotek;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.tabel.tabelInventoryObatApotek;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.client.apotek.interface_input;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import trias.klinika.client.apotek.interface_notif_input;
/**
 *
 * @author Azmil
 */
public class interface_inventory extends javax.swing.JFrame {
   
   // int a;
    
    private InventoryObatApotekService IOAS;
    private String [] isi;
    private tabelInventoryObatApotek tioa = new tabelInventoryObatApotek();
    interface_notif_input notif;

    /**
     * Creates new form interface_inventory
     */
    public interface_inventory(InventoryObatApotekService IOAS) throws RemoteException {
        this.IOAS = IOAS;
        try{
            tioa.setData(this.IOAS.getobat());
        }
        catch (RemoteException exception){
            exception.printStackTrace();
        }
        initComponents();
        notif = new interface_notif_input(IOAS);
        table_obat.setModel(tioa);
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
        jLabel2 = new javax.swing.JLabel();
        cekkritis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_obat = new javax.swing.JTable();
        back = new javax.swing.JButton();
        Input = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        kadaluarsa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("INVENTORY OBAT");

        cekkritis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cekkritis.setForeground(new java.awt.Color(0, 0, 204));
        cekkritis.setText("Cek Kritis");
        cekkritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkritisActionPerformed(evt);
            }
        });

        table_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_obat);

        back.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        Input.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Input.setForeground(new java.awt.Color(0, 0, 255));
        Input.setText("Input");
        Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 0, 255));
        delete.setText("Delete");

        update.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        update.setForeground(new java.awt.Color(51, 0, 255));
        update.setText("Update");

        kadaluarsa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kadaluarsa.setForeground(new java.awt.Color(0, 0, 255));
        kadaluarsa.setText("Cek Kadaluarsa");

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Kuliah\\1.jpg")); // NOI18N

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(Input)
                        .addGap(69, 69, 69)
                        .addComponent(delete)
                        .addGap(74, 74, 74)
                        .addComponent(update)
                        .addGap(226, 226, 226)
                        .addComponent(back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cekkritis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kadaluarsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(cekkritis)
                        .addGap(76, 76, 76)
                        .addComponent(kadaluarsa)
                        .addGap(78, 78, 78)
                        .addComponent(refresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Input)
                    .addComponent(delete)
                    .addComponent(update)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputActionPerformed
        notif.setTitle(this.getTitle());
        notif.setLocation(500, 200);
        notif.setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_InputActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void cekkritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkritisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkritisActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       
// TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Input;
    private javax.swing.JButton back;
    private javax.swing.JButton cekkritis;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kadaluarsa;
    private javax.swing.JButton refresh;
    private javax.swing.JTable table_obat;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
