/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.Home;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.LoginService;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.client.apotek.Menu_Apotek;
import trias.klinika.client.dokter.Menu_Dokter;
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
    private LoginEntitas users = new LoginEntitas();
    public ObjectInputStream readC;
    public ObjectOutputStream writeC;
    public Thread clientThread;
    Socket client;
    ServerSocket server;
    int port = 2013;
    Date jam;
    String cek;

    /**
     * Creates new form Login
     */
    
    public Login() {
        try {
            Awal();
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
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        user.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        user.setText("Username");
        jPanel1.add(user);
        user.setBounds(10, 90, 60, 30);

        pass.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        pass.setText("Password");
        jPanel1.add(pass);
        pass.setBounds(10, 130, 60, 30);
        jPanel1.add(username);
        username.setBounds(70, 90, 140, 30);
        jPanel1.add(password);
        password.setBounds(70, 130, 140, 30);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(70, 170, 90, 30);

        logo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo.png"))); // NOI18N
        jPanel1.add(logo);
        logo.setBounds(60, 0, 150, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        cek = Cek(username.getText(), password.getText());
        if (!"Sukses".equals(cek)) {
            JOptionPane.showMessageDialog(this, cek);
        }
        else {
            cek = Proses(username.getText(), password.getText());
            if (!"dokter".equals(cek) & !"reservasi".equals(cek) & !"apotek".equals(cek)) {
                JOptionPane.showMessageDialog(this, cek);
            }
            else {
                koneksi();
                clientThread = new Thread(this);
                clientThread.start();
                kirim(new pesan("login", users.getusername(), "loginIsi", "SERVER"));
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    public void Awal() throws RemoteException, NotBoundException {
        ip = JOptionPane.showInputDialog("Masukkan IP Address: ");
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        service5 = (ListPetugasService) registry.lookup("service5");
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
        if ("".equals(username)) {
            a = "Masukkan Username Dahulu";
        }
        else if ("".equals(password)) {
            a = "Masukkan Password Dahulu";
        }
        else {
            a = "Sukses";
        }
        return a;
    }
    
    public String Proses (String username, String password) {
        users.setusername(username);
        users.setpassword(password);
        String sebagai = username.substring(0, 1);
        if (null != sebagai) switch (sebagai) {
            case "D":
                users.setsebagai("dokter");
                users.setfielduser("id_dokter");
                users.setfieldpass("password_dokter");
                users.setfieldstatus("status_dokter");
                users.setfieldnama("nama_dokter");
                break;
            case "R":
                users.setsebagai("reservasi");
                users.setfielduser("id_reservasi");
                users.setfieldpass("password_reservasi");
                users.setfieldstatus("status_reservasi");
                users.setfieldnama("nama_reservasi");
                break;
            case "A":
                users.setsebagai("apotek");
                users.setfielduser("id_apotek");
                users.setfieldpass("password_apotek");
                users.setfieldstatus("status_apotek");
                users.setfieldnama("nama_apotek");
                break;
        }
        try {
            indeks = service1.CheckPassword(users);
            if (indeks == 3) {
                pesan[indeks] = users.getsebagai();
            }
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
    
    public void Eksekusi (String cek , LoginEntitas users) throws RemoteException, NotBoundException {
        if (null != cek) switch (cek) {
            case "dokter":{
                Menu_Dokter menu = new Menu_Dokter(cek);
                menu.setTitle(ip);
                menu.setLocation(500, 200);
                menu.setVisible(true);
                break;
            }
            case "reservasi":{
//                Menu_Reservasi menu = new Menu_Reservasi();
//                menu.setTitle(ip);
//                menu.setLocation(500, 200);
//                menu.setVisible(true);
                utamaReservasi menu = new utamaReservasi(this.users);
                menu.setTitle(ip);
                menu.setVisible(true);
                break;
            }
            case "apotek":{
                Menu_Apotek menu = new Menu_Apotek();
                menu.setTitle(ip);
                menu.setLocation(500, 200);
                menu.setVisible(true);
                break;
            }
        }
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login loginform;
                loginform = new Login();
                loginform.setLocation(500, 200);
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
                if(msg.tipe.equals("pesan")){
                    
                }
                else if (msg.tipe.equals("login")) {
                    users = service1.getNama(users);
                    JOptionPane.showMessageDialog(this, users.getnamauser()+" Berhasil Login pada "+setTanggal()+" "+setJam(jam));
                    try {
                        Eksekusi(cek , users);
                    } catch (RemoteException | NotBoundException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    service5.Ubah_Status_Login(users);
                    this.dispose();
                }
                else if (msg.tipe.equals("signup")) {
                    JOptionPane.showMessageDialog(this, "Username ini Telah dipakai Login di Tempat Lain");
                }
                
                else if (msg.tipe.equals("newuser")) {
                }
            }
            catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel user;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
