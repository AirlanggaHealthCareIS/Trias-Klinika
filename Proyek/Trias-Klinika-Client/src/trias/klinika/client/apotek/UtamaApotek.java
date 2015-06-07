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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.tabel.tabelInventoryObatApotek;
import trias.klinika.api.sevice.LaporanKeuanganService;
import trias.klinika.api.sevice.NotifikasiObatExpiredService;
import trias.klinika.client.Home.Login;
import trias.klinika.client.Home.Splash;
import trias.klinika.client.tabel.TabelLaporanKeuanganApotek;
import trias.klinika.client.tabel.TabelPelayananApotek;
import trias.klinika.client.apotek.intro;
import trias.klinika.client.reservasi.utamaReservasi;
import trias.klinika.api.sevice.PelayananApotekService;
/**
 *
 * @author Azmil
 */
public class UtamaApotek extends javax.swing.JFrame {
    String localhost;
    private tabelInventoryObatApotek tabelInventory = new tabelInventoryObatApotek();
    private TabelLaporanKeuanganApotek TLKA = new TabelLaporanKeuanganApotek();
    private TabelPelayananApotek TPA = new TabelPelayananApotek();
    Registry registry;
    final LaporanKeuanganService service9_c_1;
    final InventoryObatApotekService service10;
    final NotifikasiObatExpiredService service11_1;
    final PelayananApotekService service8;
    InventoryObatApotek interfaceObat;
    LaporanKeuanganApotek laporankeuanganapotek;
    PelayananApotek PA;
    private InventoryObatApotekService IOAS;
    private LaporanKeuanganService LKS;
    private PelayananApotekService PAS;
    private JInternalFrame internalFrame0 = new JInternalFrame("Frame Itro");
    private JInternalFrame internalFrame1 = new JInternalFrame("Frame Inventory Obat");
    private JInternalFrame internalFrame2 = new JInternalFrame("Frame Laporan Keuangan obat");
    private JInternalFrame internalFrame3 = new JInternalFrame("Frame Pelayanan Apotek");
    LoginEntitas LE;
    Login login;
    intro introw;
   
    boolean move_left = true;
    public Clip clip;
    public String ruta="/suara/";


    public UtamaApotek(LoginEntitas LE, Login login) throws RemoteException,NotBoundException{
        new Splash().Awal();
        this.LE = LE;
        this.login = login;
        initComponents();
        localhost = this.login.getTitle();
        registry = LocateRegistry.getRegistry(localhost, 4444);
        service10 = (InventoryObatApotekService)registry.lookup("service10");
        service11_1 = (NotifikasiObatExpiredService)registry.lookup("service11_1");
        interfaceObat = new InventoryObatApotek (service10);
        service9_c_1 = (LaporanKeuanganService)registry.lookup("service9_c_1");
        service8 = (PelayananApotekService) registry.lookup("service8");
        PA = new PelayananApotek(service8);
        laporankeuanganapotek = new LaporanKeuanganApotek(service9_c_1);
        introw = new intro();
        internal_frame();
        
        nama1.setText("SELAMAT DATANG "+LE.getnamauser().toUpperCase());
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        setSize(dim);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        java.util.Timer timer = new java.util.Timer();
        TimerTask task =  new TimerTask(){
            
            public void run()
            {
                   if(move_left==true)
                   {
                       nama1.setLocation(nama1.getLocation().x-5, nama1.getLocation().y);
                       if(nama1.getLocation().x<0)
                       {
                           move_left = false;
                       }
                   }
                   else if(move_left==false)
                   {
                       nama1.setLocation(nama1.getLocation().x+5, nama1.getLocation().y);
                       if(nama1.getLocation().x>1366)
                       {
                           move_left = true;
                       }
                   }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);
        
    }
    
    public void sonido(String archivo)
    {
//        JOptionPane.showMessageDialog(null, "hai bro");
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
            clip.start();
        }catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame = new javax.swing.JDesktopPane();
        nama1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        laporankeuangan = new javax.swing.JButton();
        inventory = new javax.swing.JButton();
        pelayanan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1147, 768));
        getContentPane().setLayout(null);

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

        nama1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nama1.setForeground(new java.awt.Color(255, 255, 255));
        nama1.setText("jLabel1");
        getContentPane().add(nama1);
        nama1.setBounds(10, 150, 530, 28);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(20, 410, 180, 40);

        laporankeuangan.setText("Laporan Keuangan Apotek");
        laporankeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporankeuanganActionPerformed(evt);
            }
        });
        getContentPane().add(laporankeuangan);
        laporankeuangan.setBounds(20, 200, 180, 40);

        inventory.setText("Inventory Obat Apotek");
        inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryActionPerformed(evt);
            }
        });
        getContentPane().add(inventory);
        inventory.setBounds(20, 270, 180, 40);

        pelayanan.setText("Pelayanan Apotek");
        pelayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelayananActionPerformed(evt);
            }
        });
        getContentPane().add(pelayanan);
        pelayanan.setBounds(20, 340, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/splash.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-30, -10, 1370, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void laporankeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporankeuanganActionPerformed
        // TODO add your handling code here:
        try{
            internalFrame2.setSelected(true);
            sonido("LYNC_joinedconference");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_laporankeuanganActionPerformed

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
        // TODO add your handling code here:
        try {
           internalFrame1.setSelected(true);
           sonido("LYNC_joinedconference");
       } catch (Exception ex){
           JOptionPane.showMessageDialog(null, ex);        
       }
    }//GEN-LAST:event_inventoryActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        try {
            login.getService5().Ubah_Status_Logout(LE); 
            sonido("LYNC_joinedconference");
            login.kirim(new pesan("logout", login.getUsers().getnamauser(), login.getUsers().getusername(), "Server"));
            login.dispose();
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(UtamaApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void pelayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelayananActionPerformed
        // TODO add your handling code here:
        try {
           internalFrame3.setSelected(true);
           sonido("LYNC_joinedconference");
       } catch (Exception ex){
           JOptionPane.showMessageDialog(null, ex);        
       }
    }//GEN-LAST:event_pelayananActionPerformed

public void internal_frame (){
    
        internalFrame0.add(introw.getContentPane());
        internalFrame0.pack();
        internalFrame0.setSize(1146,577);
        internalFrame0.setVisible(true);
        internalFrame.add(internalFrame0);
        BasicInternalFrameUI ui0 = (BasicInternalFrameUI)internalFrame0.getUI();
        Container north0 = (Container)ui0.getNorthPane();
        north0.remove(0);
        north0.validate();
        north0.repaint();
        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame0.getUI()).getNorthPane().getMouseListeners()){
            ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame0.getUI()).getNorthPane().removeMouseListener(listener);
        }
    
    internalFrame1.add(interfaceObat.getContentPane());
    internalFrame1.pack();
    internalFrame1.setSize(1146,577);
    internalFrame1.setVisible(true);
    internalFrame.add(internalFrame1);
    BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame1.getUI();
    Container north = (Container)ui.getNorthPane();
    north.remove(0);
    north.validate();
    north.repaint();
    for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
    }
           
    internalFrame2.add(laporankeuanganapotek.getContentPane());
    internalFrame2.pack();
    internalFrame2.setSize(1146,577);
    internalFrame2.setVisible(true);
    internalFrame.add(internalFrame2);
    BasicInternalFrameUI ui2 = (BasicInternalFrameUI)internalFrame2.getUI();
    Container north2 = (Container)ui2.getNorthPane();
    north2.remove(0);
    north2.validate();
    north2.repaint();
    for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().getMouseListeners()){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame2.getUI()).getNorthPane().removeMouseListener(listener);
    }
    internalFrame3.add(PA.getContentPane());
    internalFrame3.pack();
    internalFrame3.setSize(1146,577);
    internalFrame3.setVisible(true);
    internalFrame.add(internalFrame3);
    BasicInternalFrameUI ui3 = (BasicInternalFrameUI)internalFrame3.getUI();
    Container north3 = (Container)ui3.getNorthPane();
    north2.remove(0);
    north2.validate();
    north2.repaint();
    for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame3.getUI()).getNorthPane().getMouseListeners()){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame3.getUI()).getNorthPane().removeMouseListener(listener);
    }
}

public void NotifObatExpired() {
    List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
    String [] Id_Obat = new String[0];
    String pesan = "List Obat Yang Terindikasi Kadaluarsa : \n";
    try {
        Id_Obat = service11_1.ObatApotekExpired(Id_Obat, setTanggal());
        if (!"Tidak Ada Obat Expired".equals(Id_Obat[0])) {
            for (int i=0;i<Id_Obat.length;i++) {
                list.add(service11_1.getobat(Id_Obat[i]));
                pesan = pesan + (i+1) + ".  "+list.get(i).getNamaObat()+"   Dengan Sisa Stok = "+list.get(i).getQty()+"\n";
            }
            pesan = pesan + "Silahkan Melakukan Tindakan Atas Hal Ini";
            JOptionPane.showMessageDialog(this, pesan, "Notifikasi Obat Expired",2);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(UtamaApotek.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public String setTanggal () {
        Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("yyyy-MM-dd");
        return kal.format(skrg);
    }
public void kirimObat (String Id, String Nama){
        JOptionPane.showMessageDialog(null, " Masuk Obat!!! "+Nama);
        try {
            
            PA.TPA.insert(service8.getpelayananapotek(Id));
        } catch (RemoteException ex) {
            Logger.getLogger(UtamaApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane internalFrame;
    private javax.swing.JButton inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton laporankeuangan;
    private javax.swing.JButton logout;
    private javax.swing.JLabel nama1;
    private javax.swing.JButton pelayanan;
    // End of variables declaration//GEN-END:variables
}













