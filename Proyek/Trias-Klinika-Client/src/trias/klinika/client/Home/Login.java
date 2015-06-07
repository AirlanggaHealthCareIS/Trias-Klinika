/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.Home;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.LoginService;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.api.sevice.laporankeuanganReservasiService;
import trias.klinika.client.apotek.UtamaApotek;
import trias.klinika.client.dokter.UtamaDokter;
import trias.klinika.client.reservasi.utamaReservasi;

/**
 *
 * @author Faz
 */
public class Login extends javax.swing.JFrame implements Runnable {
    
    private String [] pesan = {"Sistem Error","User Belum Terdaftar","Password Salah","Login Sukses"};
    private int indeks = 0;
    private String ip;
    private Registry registry;
    private LoginService service1;
    private ListPetugasService service5;
    private laporankeuanganReservasiService service9_a_1;
    private LoginEntitas users = new LoginEntitas();
    private ObjectInputStream readC;
    private ObjectOutputStream writeC;
    private Thread clientThread;
    private UtamaDokter menudokter;
    private utamaReservasi menureservasi;
    private UtamaApotek menuapotek;
    private Socket client;
    private int port = 2013;
    private Date jam;
    private String cek;
   
   

    /**
     * Creates new form Login
     */
    
    public Login() {
        try {
            Awal();
            Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
            setSize(dim);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        judul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(null);

        user.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("Username");
        jPanel1.add(user);
        user.setBounds(390, 390, 110, 30);

        pass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setText("Password");
        jPanel1.add(pass);
        pass.setBounds(390, 450, 100, 30);

        username.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(username);
        username.setBounds(500, 390, 180, 30);

        password.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(password);
        password.setBounds(500, 450, 180, 30);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(720, 410, 70, 50);

        judul.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setText("Login");
        jPanel1.add(judul);
        judul.setBounds(270, 310, 120, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/doctor.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 370, 130, 140);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/22.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 50, 810, 380);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/BG login.jpg"))); // NOI18N
        jLabel3.setText("  ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1370, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        cek = Cek(username.getText(), password.getText());
        sonido("LYNC_joinedconference");
        if (!"Sukses".equals(cek)) {
            PopUpPesan(cek);
        }
        else {
            cek = Proses(username.getText(), password.getText());
            if (!"Login Sukses".equals(cek)) {
                PopUpPesan(cek);
            }
            else {
                try {
                    users = service1.getNama(users);
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                koneksi();
                clientThread = new Thread(this);
                clientThread.start();
                kirim(new pesan("login", users.getusername(), users.getnamauser(), "SERVER"));
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    public void Awal() throws RemoteException, NotBoundException {
        ip = JOptionPane.showInputDialog("Masukkan IP Address: ");
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        service5 = (ListPetugasService) registry.lookup("service5");
        service9_a_1 = (laporankeuanganReservasiService) registry.lookup("service9_a_1");
        this.setTitle(ip);
    }
    
    public String setTanggal () {
        Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("dd/MM/yyyy");
        return kal.format(skrg);
    }
    
    public String setJam (Date jam) {
        jam = new Date();
        return jam.getHours()+":"+jam.getMinutes()+":"+jam.getSeconds();
    }
    
    public String Cek(String username, String password) {
        String a;
        if ("".equals(username) & "".equals(password)) {
            a = "Masukkan Username dan Password Terlebih Dahulu";
        }
        else if ("".equals(username)) {
            a = "Masukkan Username Terlebih Dahulu";
        }
        else if ("".equals(password)) {
            a = "Masukkan Password Terlebih Dahulu";
        }
        else {
            a = "Sukses";
        }
        return a;
    }
    
    public String Proses (String username, String password) {
        String sebagai = username.substring(0, 1);
        if (null != sebagai) switch (sebagai) {
            case "D":
                users.SetData(username, password, "dokter", "id_dokter", "password_dokter", "status_dokter", "nama_dokter");
                break;
            case "R":
                users.SetData(username, password, "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
                break;
            case "A":
                users.SetData(username, password, "apotek", "id_apotek", "password_apotek", "status_apotek", "nama_apotek");
                break;
            default :
                users.SetData(username, password, null, null, null, null, null);
        }
        try {
            indeks = service1.CheckPassword(users);
        } catch (RemoteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pesan[indeks];
    }
    
    public void koneksi() {
        try {
            client = new Socket(ip, port);
            writeC = new ObjectOutputStream(client.getOutputStream());
            writeC.flush();
            readC = new ObjectInputStream(client.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kirim (pesan msg) {
        try {
            writeC.writeObject(msg);
            writeC.flush();
            System.out.println("Outgoing : "+msg.toString());
        } 
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void Eksekusi (LoginEntitas users) throws RemoteException, NotBoundException {
        if (null != users.getsebagai()) switch (users.getsebagai()) {
            case "dokter":{
                menudokter = new UtamaDokter(users, this);
                menudokter.setVisible(true);
                menudokter.NotifStokObatDokterKritis();
                break;
            }
            case "reservasi":{
                menureservasi = new utamaReservasi(users, this);
                menureservasi.setVisible(true);
                break;
            }
            case "apotek":{
                menuapotek = new UtamaApotek(users, this);
                menuapotek.setVisible(true);
                menuapotek.NotifObatExpired();
                break;
            }
        }
    }
    
    public void PopUpPesan (String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    public ObjectInputStream getOIS() {
        return readC;
    }
    public ObjectOutputStream getOUS() {
        return writeC;
    }
    public Thread getThread() {
        return clientThread;
    }
    
    public LoginEntitas getUsers() {
        return users;
    }
    
    public ListPetugasService getService5() {
        return service5;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login loginform;
                loginform = new Login();
                loginform.setVisible(true);
            }
        });
    }
    
    @Override
    public void run() {
        while (true) {
            try{
                pesan msg = null;
                try {
                    msg = (pesan) readC.readObject();
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                switch (msg.tipe) {
                    case "login":
                        PopUpPesan(users.getnamauser()+" Berhasil Login pada "+setTanggal()+" "+setJam(jam));
                        this.setVisible(false);
                        try {
                            Eksekusi(users);
                        } catch (RemoteException | NotBoundException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                        service5.Ubah_Status_Login(users);
                        kirim(new pesan("updatelist", users.getnamauser(), users.getusername(), "Reservasi"));
                        break;
                    case "sudahsign":
                        PopUpPesan("Username ini Telah dipakai Login di Tempat Lain");
                        break;
                    case "updatelist":
                        menureservasi.updatelist(msg.isi, msg.pengirim);
                        break;
                    case "logout":
                        menureservasi.updatelogout(msg.isi, msg.pengirim);
                        break;
                    case "Pembayaran":
                        menureservasi.updatelist2(msg.isi, msg.pengirim);
                        break;
                    case "KirimIDPemeriksaanImin":
                        menudokter.kirimanAntreanImin(msg.isi, msg.pengirim);
                        break;
//                    case "Resep":
//                        menuapotek.kirimobat(msg.isi, msg.pengirim);
                }
            }
            catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel judul;
    private javax.swing.JButton login;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel user;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

     public Clip clip;
    public String ruta="/suara/";
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
}
