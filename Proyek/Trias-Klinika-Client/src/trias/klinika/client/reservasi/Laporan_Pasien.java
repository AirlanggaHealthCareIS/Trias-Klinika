/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.reservasi;

/**
 *
 * @author iqbal
 */
public class Laporan_Pasien extends javax.swing.JInternalFrame {
    int a;

    /**
     * Creates new form Laporan_Pasien
     */
    public Laporan_Pasien() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        tahun = new javax.swing.JComboBox();
        grafik = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1147, 557));
        setPreferredSize(new java.awt.Dimension(1147, 557));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/laporan.png"))); // NOI18N
        jLabel1.setText("Laporan Data Pasien");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 980, 100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(980, 0, 150, 100);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Data Grafik ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 100, 70, 14);

        tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Tahun..." }));
        getContentPane().add(tahun);
        tahun.setBounds(10, 410, 88, 20);

        grafik.setText("Lihat Grafiik");
        getContentPane().add(grafik);
        grafik.setBounds(110, 410, 89, 23);

        cetak.setText("Cetak");
        getContentPane().add(cetak);
        cetak.setBounds(220, 390, 61, 49);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/J-IntFrameReservasi.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1130, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void reset(){
        tahun.setEnabled(false);
        grafik.setEnabled(false);
        cetak.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JButton grafik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox tahun;
    // End of variables declaration//GEN-END:variables
}
