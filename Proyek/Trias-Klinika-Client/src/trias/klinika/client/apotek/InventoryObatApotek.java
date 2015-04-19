/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.apotek;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.tabel.tabelInventoryObatApotek;

/**
 *
 * @author Azmil
 */
public class InventoryObatApotek extends javax.swing.JInternalFrame {
    int z;
    private InventoryObatApotekService IOAS;
    private String [] isi;
    private tabelInventoryObatApotek tioa = new tabelInventoryObatApotek();
//    private String [] jenis;
//    private String [] spesialis;

    /**
     * Creates new form InventoryObatApotek
     */
    public InventoryObatApotek(InventoryObatApotekService IOAS) throws RemoteException {
        
        this.IOAS = IOAS;
        try{
            tioa.setData(this.IOAS.getobat());
        }
        catch (RemoteException exception){
            exception.printStackTrace();
        }
        initComponents();
        Dropdown();
        table_obat.setModel(tioa);
        table_obat.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged (ListSelectionEvent e){
                int row = table_obat.getSelectedRow();
                if (row != -1) {
                    InventoryObatApotekEntitas IOAE = tioa.get(row);                    
                    id_obat.setText(IOAE.getIdObat());
                    nama_obat.setText(IOAE.getNamaObat());
                    id_obat.setText(IOAE.getIdObat());
                    qty.setText(Integer.toString(IOAE.getQty()));
                    harga.setText(Integer.toString(IOAE.getHargaObat()));
                    deskripsi.setText(IOAE.getDeskripsi());        
                    }
            }
        });
        Dropdown();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kadaluarsa = new javax.swing.JButton();
        tabel = new javax.swing.JScrollPane();
        table_obat = new javax.swing.JTable();
        cekkritis = new javax.swing.JButton();
        input = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        id_obat = new javax.swing.JTextField();
        nama_obat = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        tgl_masuk = new com.toedter.calendar.JDateChooser();
        masa_pakai = new com.toedter.calendar.JDateChooser();
        harga = new javax.swing.JTextField();
        deskripsi = new javax.swing.JTextField();
        jenis_obat = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(1146, 577));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("INVENTORY OBAT");

        kadaluarsa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kadaluarsa.setForeground(new java.awt.Color(0, 0, 255));
        kadaluarsa.setText("Cek Kadaluarsa");

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
        tabel.setViewportView(table_obat);

        cekkritis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cekkritis.setForeground(new java.awt.Color(0, 0, 204));
        cekkritis.setText("Cek Kritis");
        cekkritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkritisActionPerformed(evt);
            }
        });

        input.setText("Input");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        back.setText("Back");

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel3.setText("Id_Obat");

        jLabel4.setText("Nama Obat");

        jLabel6.setText("Jenis Obat");

        jLabel7.setText("Quantity");

        jLabel8.setText("Tanggal Masuk");

        jLabel9.setText("Masa Pakai");

        jLabel10.setText("Spesialisasi");

        jLabel5.setText("Harga Obat");

        jLabel11.setText("Deskripsi Obat");

        id_obat.setEnabled(false);
        id_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_obatActionPerformed(evt);
            }
        });

        nama_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_obatActionPerformed(evt);
            }
        });

        jenis_obat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jenis_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis_obatActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deskripsi))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(id_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jenis_obat, javax.swing.GroupLayout.Alignment.TRAILING, 0, 225, Short.MAX_VALUE)
                                    .addComponent(nama_obat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(qty))))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harga)
                            .addComponent(masa_pakai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nama_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jenis_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tgl_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(masa_pakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tabel, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cekkritis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kadaluarsa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1481, 1481, 1481))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(cekkritis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kadaluarsa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input)
                        .addGap(15, 15, 15)
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update)
                        .addGap(15, 15, 15)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(448, 448, 448))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cekkritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkritisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkritisActionPerformed

    private void id_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_obatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_obatActionPerformed

    private void nama_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_obatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_obatActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            int row = table_obat.getSelectedRow();
            if(row == -1){
                return;
            }
            refresh();
            JOptionPane.showMessageDialog(this, "Proses Penghapusan obat berhasil");
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        // TODO add your handling code here:
          InventoryObatApotekEntitas IOAE = new InventoryObatApotekEntitas ();
          //PreparedStatement statement = new PreparedStatement();
          
          JOptionPane.showMessageDialog(this, "Proses Update Obat Berhasil");
          refresh();
    }//GEN-LAST:event_updateActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);    
        if(nama_obat.getText()==""|qty.getText()==""|harga.getText()==""|tgl_masuk.getDate()==null|masa_pakai.getDate()==null|deskripsi.getText()==""){
            JOptionPane.showMessageDialog(this, "Salah Satu Data Belum di Isi");
        }
        else{
            InventoryObatApotekEntitas IOAE = new InventoryObatApotekEntitas();
            IOAE.setIdObat(id_obat.getText());
            IOAE.setNamaObat(nama_obat.getText());
            IOAE.setQty(Integer.parseInt(qty.getText()));
            IOAE.setTglMasuk(tgl_masuk.getDate().toString());
            IOAE.setMasaPakai(masa_pakai.getDate().toString());
            IOAE.setDeskripsi(deskripsi.toString());
            IOAE.setRuangObat("Apotek");
            
            tioa.insert(IOAE);
            try{
                IOAS.insertObatBaru(IOAE);
            }
            catch (RemoteException ex){
                Logger.getLogger(interface_input.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            }
// TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        id_obat.setText("");
        nama_obat.setText("");
        qty.setText("");
        harga.setText("");
        deskripsi.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void jenis_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis_obatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenis_obatActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        JOptionPane.showConfirmDialog(null, "Apakah resep yang dimasukan sudah benar?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(qty.getText()==""|tgl_masuk.getDate()==null|masa_pakai.getDate()==null){
            JOptionPane.showMessageDialog(this, "Salah Satu Data Belum di Isi");
        }
        else{
            InventoryObatApotekEntitas IOAE = new InventoryObatApotekEntitas();

            IOAE.setQty(Integer.parseInt(qty.getText()));
            IOAE.setTglMasuk(tgl_masuk.getDate().toString());
            IOAE.setMasaPakai(masa_pakai.getDate().toString());
            IOAE.setRuangObat("Apotek");
            
            tioa.tambah(IOAE);
            try{
                IOAS.tambahObat(IOAE);
            }
            catch (RemoteException ex){
                Logger.getLogger(interface_input.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            }
// TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed
    private void refresh (){
        try {
            List<InventoryObatApotekEntitas> list = IOAS.getobat();
            tioa.setData(list);
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    }
    private void Dropdown () throws RemoteException{
        isi = IOAS.DropdownJenis(isi);
        isi = IOAS.DropdownSpesialis(isi);
        for (int i=0;i<isi.length;i++){
            jenis_obat.addItem(isi[i]);
            jComboBox1.addItem(isi[i]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cekkritis;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JTextField deskripsi;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField id_obat;
    private javax.swing.JButton input;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jenis_obat;
    private javax.swing.JButton kadaluarsa;
    private com.toedter.calendar.JDateChooser masa_pakai;
    private javax.swing.JTextField nama_obat;
    private javax.swing.JTextField qty;
    private javax.swing.JScrollPane tabel;
    private javax.swing.JTable table_obat;
    private javax.swing.JButton tambah;
    private com.toedter.calendar.JDateChooser tgl_masuk;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
