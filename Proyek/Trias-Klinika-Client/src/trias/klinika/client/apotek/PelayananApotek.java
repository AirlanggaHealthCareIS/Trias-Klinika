/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.apotek;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.text.*;
import java.awt.print.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trias.klinika.api.entitas.PelayananApotekEntitas;
import trias.klinika.api.entitas.PelayananApotekResepEntitas;
import trias.klinika.api.sevice.PelayananApotekService;
import trias.klinika.client.tabel.TabelPelayananApotek;
import trias.klinika.client.tabel.TabelPelayananApotekResep;

public final class PelayananApotek extends javax.swing.JInternalFrame {
    int a;
    private PelayananApotekService PAS;
    public TabelPelayananApotek TPA = new  TabelPelayananApotek();
    private TabelPelayananApotekResep TPAR = new TabelPelayananApotekResep();
    private PelayananApotekEntitas PAE= new PelayananApotekEntitas();
    private List<PelayananApotekEntitas> list = new ArrayList<>();
    private String [] isi;
    private String ID_PEMERIKSAAN;
    private int ID_RESEP;
    private String NAMA_PASIEN;
    private String NAMA_DOKTER;
    private String ID_OBAT;
    private int baris;
    
    
 public PelayananApotek( final PelayananApotekService PAS) throws RemoteException {
        this.PAS = PAS;
//        try {
//            list = this.PAS.getDokters();
//            TPA.setData(list);
//        } catch (RemoteException exception) {
//            exception.printStackTrace();
//        }
        initComponents();
   tabelkanan.setModel(TPA);

//             TPA.setData(this.PAS.getDokters());
//
//        tabelkanan.setModel(TPA);
//        tabelkanan.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
//            public void valueChanged(ListSelectionEvent e) {
//                String namaPasien;
//                String id_resep ;
//                String namaDokter;
//                
//                int row = tabelkanan.getSelectedRow();
//                if (row != -1) {
//                    baris = row;
//                    PelayananApotekEntitas PAE = TPA.get(row);
////                     tabelkiri.setModel(TPAR);
//                    try {
//                        PAE = PAS.getresepbaru(PAE.getID_OBAT());
//                        tabelkiri.setModel(TPAR);
//                    } catch (RemoteException ex) {
//                        Logger.getLogger(PelayananApotek.class.getName()).log(Level.SEVERE, null, ex);
//                    
                    
//                    namaPasien = PAE.getNAMA_PASIEN();
//                    id_resep = PAE.getID_RESEP();
//                    namaDokter = PAE.getNAMA_DOKTER();
//                    
//                   PAE.setNAMA_DOKTER(namaDokter);
//                   PAE.setID_RESEP(id_resep);
//                  PAE.setNAMA_PASIEN(namaPasien);
//                    }  }
//            }
//            });
 
// public PelayananApotek() {
//        initComponents();
 //awal();
 }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkanan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkiri = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1147, 570));
        setPreferredSize(new java.awt.Dimension(1147, 570));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Pelayanan Apotek");

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\DOCUMEN IIS\\6 MSTERI SEMESTER\\Pengembangan Sistem Informasi\\Untitled-2.png")); // NOI18N

        tabelkanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Pemeriksaan", "ID Resep", "Nama Pasien", "Nama Dokter"
            }
        ));
        tabelkanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkananMouseClicked(evt);
            }
        });
        tabelkanan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelkananComponentShown(evt);
            }
        });
        tabelkanan.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabelkananComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkanan);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        print.setIcon(new javax.swing.ImageIcon("D:\\DOCUMEN IIS\\6 MSTERI SEMESTER\\Pengembangan Sistem Informasi\\1428831065_common_printer_print_-24.png")); // NOI18N
        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        tabelkiri.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelkiri);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tabel List Resep Masuk");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(print)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       MessageFormat header = new MessageFormat ("Report Print");
      MessageFormat footer = new MessageFormat ("Laporan Keuangan Apotek");
      try { 
          tabelkiri.print(JTable.PrintMode.NORMAL, header, footer);
      }catch (java.awt.print.PrinterException e){
          System.err.format("Tidak bisa di print %s%n",e.getMessage());
    }
    }//GEN-LAST:event_printActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        list.remove(baris);
        TPA.setData(list);
        tabelkanan.setModel(TPA);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelkananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkananMouseClicked
        int row = tabelkanan.rowAtPoint(evt.getPoint());
        PelayananApotekEntitas PARE = new PelayananApotekEntitas ();
        try {            
            PARE = PAS.getpelayananapotek(TPA.get(row).getID_RESEP());
        } catch (RemoteException ex) {
            Logger.getLogger(PelayananApotek.class.getName()).log(Level.SEVERE, null, ex);
        }

            Object selectedObj = tabelkanan.getValueAt(row, 0);

                try {
                TPAR.setData(this.PAS.getresepbaru(""+selectedObj));
            } catch (RemoteException ex) {
                Logger.getLogger(PelayananApotek.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabelkiri.setModel(TPAR);
    }//GEN-LAST:event_tabelkananMouseClicked

    private void tabelkananComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelkananComponentShown
      awal();
    }//GEN-LAST:event_tabelkananComponentShown

    private void tabelkananComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabelkananComponentAdded
        awal();        
    }//GEN-LAST:event_tabelkananComponentAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print;
    private javax.swing.JTable tabelkanan;
    private javax.swing.JTable tabelkiri;
    // End of variables declaration//GEN-END:variables

public void awal() {
        try{
             TPA.setData(this.PAS.getDokters());
             System.out.println("unyu 3");
        }catch(RemoteException exception){
             exception.printStackTrace();
            System.out.println("unyu 2");
         }
        tabelkanan.setModel(TPA);
        System.out.println("unyu 1");
    }

}
