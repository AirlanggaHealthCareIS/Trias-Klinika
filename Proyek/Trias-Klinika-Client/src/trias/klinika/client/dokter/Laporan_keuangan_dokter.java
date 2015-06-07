/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import trias.klinika.api.entitas.LaporanKeuanganDokterEntitas;
import trias.klinika.api.sevice.LaporanKeuanganDokterService;
import trias.klinika.client.tabel.TabelLaporanKeuanganDokter;

/**
 *
 * @author Satria
 */
public class Laporan_keuangan_dokter extends javax.swing.JInternalFrame {
    
    private LaporanKeuanganDokterService LKDS ;
    private TabelLaporanKeuanganDokter TLKD = new TabelLaporanKeuanganDokter();
    private LaporanKeuanganDokterEntitas LKDE = new LaporanKeuanganDokterEntitas();
    private UtamaDokter UD;
    String cek;
    /**
     * Creates new form Laporan_keuangan_dokter
     */
    public Laporan_keuangan_dokter(LaporanKeuanganDokterService LKDS, UtamaDokter UD) throws RemoteException{
        this.LKDS = LKDS;
        this.UD = UD;
        initComponents();
    }

    Laporan_keuangan_dokter(LaporanKeuanganDokterService service9_b_2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tgl_mulai = new com.toedter.calendar.JDateChooser();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_laporan = new javax.swing.JTable();
        lihat_grafik = new javax.swing.JToggleButton();
        Tampikan = new javax.swing.JToggleButton();

        setMaximumSize(new java.awt.Dimension(1147, 557));
        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));

        jLabel1.setText("Mulai");

        jLabel2.setText("Sampai");

        tabel_laporan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_laporan);

        lihat_grafik.setText("Lihat Grafik");
        lihat_grafik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihat_grafikActionPerformed(evt);
            }
        });

        Tampikan.setText("Tampilkan");
        Tampikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TampikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Tampikan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lihat_grafik, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tampikan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lihat_grafik, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TampikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TampikanActionPerformed
       
        cek = Cek(tgl_mulai.getDate().toString(), tgl_sampai.getDate().toString());
        if (!"Sukses".equals(cek)) {
            JOptionPane.showMessageDialog(this, cek);
        }
        else{
            try {
                // TODO add your handling code here:
                TLKD.setData(this.LKDS.getDataLaporan(FormatTanggal(tgl_mulai.getDate()), FormatTanggal(tgl_sampai.getDate()), UD.LE.getusername() ));
            } catch (RemoteException ex) {
                Logger.getLogger(Laporan_keuangan_dokter.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabel_laporan.setModel(TLKD);
        }    
    }//GEN-LAST:event_TampikanActionPerformed

    private void lihat_grafikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihat_grafikActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        String[] tgl_pemeriksaan = new String [TLKD.getRowCount()];
        int[] jumlah_pemasukkan = new int [TLKD.getRowCount()];
        int index = 0;
        for (int i = 0; i < TLKD.getRowCount(); i++) {
            if(i == 0){
                tgl_pemeriksaan[index] = TLKD.get(i).getTGL_PEMERIKSAAN();
                jumlah_pemasukkan[index] = TLKD.get(i).getJUMLAH_PEMASUKKAN();
            }
            else{
                if(tgl_pemeriksaan[index] == TLKD.get(i).getTGL_PEMERIKSAAN()){
                jumlah_pemasukkan [i] = jumlah_pemasukkan [i] + TLKD.get(i).getJUMLAH_PEMASUKKAN();
            }
                else {
                    index++;
                    tgl_pemeriksaan[index] = TLKD.get(i).getTGL_PEMERIKSAAN();
                    jumlah_pemasukkan[index] = TLKD.get(i).getJUMLAH_PEMASUKKAN();
                }    
            }
        }
        for (int i = 0; i<tgl_pemeriksaan.length; i++){
            dataSet.addValue(jumlah_pemasukkan[i], "Jumlah Pemasukkan", tgl_pemeriksaan[i]);
        }
        
        
        JFreeChart chartline = ChartFactory.createBarChart("Laporan Keuangan", "Tanggal", "Jumlah Pemasukkan", dataSet, PlotOrientation.VERTICAL, true, true, true);
        ChartFrame frame = new ChartFrame("Pengguna OS Komputer di Indonesia", chartline);
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_lihat_grafikActionPerformed

    public String FormatTanggal(Date date){
    
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
    }
    public String Cek(String tgl_mulai, String tgl_sampai) {
        String a;
        if ("".equals(tgl_mulai)) {
            a = "Pilih tanggal mulai terlebih dahulu";
        }
        else if ("".equals(tgl_sampai)) {
            a = "Pilih tanggal sampai terlebih dahulu";
        }
        else {
            a = "Sukses";
        }
        return a;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Tampikan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton lihat_grafik;
    private javax.swing.JTable tabel_laporan;
    private com.toedter.calendar.JDateChooser tgl_mulai;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    // End of variables declaration//GEN-END:variables
}
