/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import trias.klinika.api.pesan.pesan;
import java.io.*;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;
import java.net.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import trias.klinika.server.service.QueryAntrean;
import trias.klinika.server.service.QueryInventoriObatDokter;
import trias.klinika.server.service.QueryInventoryObatApotek;
import trias.klinika.server.service.QueryLaporanKeuanganDokter;
import trias.klinika.server.service.QueryLaporanKeuanganReservasi;
import trias.klinika.server.service.QueryListPembayaran;
import trias.klinika.server.service.QueryListPetugas;
import trias.klinika.server.service.QueryLogin;
import trias.klinika.server.service.QueryNotifikasiObatExpired;
import trias.klinika.server.service.QueryPembayaran;
import trias.klinika.server.service.QueryPendaftaran;
import trias.klinika.server.service.QueryResep;
import trias.klinika.server.service.queryRekammedis;
import trias.klinika.server.service.queryLaporanKeuanganApotek;
import trias.klinika.server.service.QueryNotifikasiStokObatDokter;

class ServerThread extends Thread { 
	
    public Server serverpesan = null;
    public Socket socket = null;
    public int ID = -1;
    public String username = "";
    public ObjectInputStream streamIn  =  null;
    public ObjectOutputStream streamOut = null;
    

    public ServerThread(Server _server, Socket _socket){  
    	super();
        serverpesan = _server;
        socket = _socket;
        ID     = socket.getPort();
    }
    
    public void send(pesan msg){
        try {
            streamOut.writeObject(msg);
            streamOut.flush();
        } 
        catch (IOException ex) {
            System.out.println("Exception [SocketClient : send(...)]");
        }
    }
    
    public int getID(){  
	    return ID;
    }
   
    @SuppressWarnings("deprecation")
	public void run(){  
        while (true){  
    	    try{
                pesan msg = (pesan) streamIn.readObject();
    	    	serverpesan.handle(ID, msg);
            }
            catch(Exception ioe){  
            	System.out.println(ID + " ERROR reading: " + ioe.getMessage());
                serverpesan.remove(ID);
                stop();
            }
        }
    }
    
    public void open() throws IOException {  
        streamOut = new ObjectOutputStream(socket.getOutputStream());
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream());
    }
    
    public void close() throws IOException {  
    	if (socket != null)    socket.close();
        if (streamIn != null)  streamIn.close();
        if (streamOut != null) streamOut.close();
    }
    
    
}



/**
 *
 * @author fazbam
 */
public class Server extends javax.swing.JFrame implements Runnable {
    public ServerThread clients [];
    public ServerSocket serverpesan = null;
    public Thread       thread = null;
    public int clientCount = 0, port = 2013;
    int penunjuk = 0;
    Date jam;
    
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
    
    private void awal() throws RemoteException{
        Registry server = LocateRegistry.createRegistry(4444);

        QueryLogin queryLogin = new QueryLogin() {};
        QueryPembayaran queryPembayaran = new QueryPembayaran() {};
        QueryInventoriObatDokter queryInventoriObatDokter = new QueryInventoriObatDokter(){};
        queryRekammedis QueryRekamMedis = new queryRekammedis (){};
        QueryInventoryObatApotek queryobatapotek = new QueryInventoryObatApotek (){};
        QueryPendaftaran querypendaftaran = new QueryPendaftaran (){};
        QueryListPembayaran querylistpembayaran = new QueryListPembayaran(){};
        QueryAntrean QueryAntrean = new QueryAntrean() {};
        queryLaporanKeuanganApotek querylaporankeuanganapotek = new queryLaporanKeuanganApotek(){};
        QueryListPetugas querylistpetugas = new QueryListPetugas(){};
        QueryResep queryResep = new QueryResep();
        QueryLaporanKeuanganDokter querylaporankeuangandokter = new QueryLaporanKeuanganDokter() {};
        QueryNotifikasiObatExpired queryNotifikasiObatExpired = new QueryNotifikasiObatExpired() {};
        QueryLaporanKeuanganReservasi queryLaporanKeuanganReservasi = new QueryLaporanKeuanganReservasi();
        QueryNotifikasiStokObatDokter queryNotifikasiStokObatDokter = new QueryNotifikasiStokObatDokter();
        
        server.rebind("service1", queryLogin);
        server.rebind("service2", querypendaftaran);
        server.rebind("service3", QueryAntrean);
        server.rebind("service4", queryPembayaran);
        server.rebind("service5", querylistpetugas);
        server.rebind("service6", QueryRekamMedis);
        server.rebind("service7", queryResep);
        server.rebind("service9_a_1", queryLaporanKeuanganReservasi);
        server.rebind("service9_c_1", querylaporankeuanganapotek);
        server.rebind("service9_b_2", querylaporankeuangandokter);
        server.rebind("service10", queryobatapotek);
        server.rebind("service11_1", queryNotifikasiObatExpired);
        server.rebind("service11_3", queryNotifikasiStokObatDokter);
        server.rebind("service12", querylistpembayaran);
        server.rebind("service13", queryInventoriObatDokter);
        
        System.out.println("Server Berjalan");
        
        clients = new ServerThread [50];
        try{  
	    serverpesan = new ServerSocket(port);
            port = serverpesan.getLocalPort();
	    mulai(); 
        }
	catch(IOException ioe){  
            riwayat.add("Tidak bisa mengakses port : " + port);
	}
    }
    
    public void mulai(){  
    	if (thread == null){  
            thread = new Thread(this); 
	    thread.start();
	}
    }
    
    @SuppressWarnings("deprecation")
    public void berhenti(){  
        if (thread != null){  
            thread.stop(); 
	    thread = null;
	}
    }
    
    private int findClient(int ID){  
    	for (int i = 0; i < clientCount; i++){
        	if (clients[i].getID() == ID){
                    return i;
                }
	}
	return -1;
    }
	
    public synchronized void handle(int ID, pesan msg){
        switch (msg.tipe) {
            case "pesan":
                if(msg.penerima.equals("semua")){
                    Announce("pesan", msg.pengirim, msg.isi);
                }
                else{
                    findUserThread(msg.penerima).send(new pesan(msg.tipe, msg.pengirim, msg.isi, msg.penerima));
                    clients[findClient(ID)].send(new pesan(msg.tipe, msg.pengirim, msg.isi, msg.penerima));
                }   
                break;
            case "login":
                if(findUserThread(msg.pengirim) == null){
                    clients[findClient(ID)].username = msg.pengirim;
                    clients[findClient(ID)].send(new pesan("login", "SERVER", "berhasil", msg.pengirim));
                    riwayat.add(msg.pengirim+" Berhasil login pada "+setTanggal()+" "+setJam(jam));
                }
                else{
                    clients[findClient(ID)].send(new pesan("sudahsign", "SERVER", "gagal", msg.pengirim));
                }   
                break;
            case "updatelist":
                if(msg.isi.substring(0, 1).equals("D")){
                    UpdateList(msg);
                }
                break;
            case "logout":
                if(msg.isi.substring(0, 1).equals("D")){
                    UpdateList(msg);
                }
                hapus(findClient(ID));   
                break;
            case "KirimIDPemeriksaanImin":
                findUserThread(msg.penerima).send(new pesan(msg.tipe, msg.pengirim, msg.isi, msg.penerima));
                clients[findClient(ID)].send(new pesan(msg.tipe, msg.pengirim, msg.isi, msg.penerima));
                break;
            case "Pembayaran":
                UpdateList(msg);
        }
    }
    
    public void UpdateList(pesan msg){
        for(int i=0;i<clientCount;i++){
            if("R".equals(clients[i].username.substring(0, 1))){
                clients[i].send(msg);
            }
        }
    }
    
    public void Announce(String type, String sender, String content){
        pesan msg = new pesan(type, sender, content, "semua");
        for(int i = 0; i < clientCount; i++){
            clients[i].send(msg);
        }
    }
    
    public void SendUserList(String toWhom){
        for(int i = 0; i < clientCount; i++){
            findUserThread(toWhom).send(new pesan("newuser", "SERVER", clients[i].username, toWhom));
        }
    }
    
    public ServerThread findUserThread(String usr){
        for(int i = 0; i < clientCount; i++){
            if(clients[i].username.equals(usr)){
                return clients[i];
            }
        }
        return null;
    }
	
    @SuppressWarnings("deprecation")
    public synchronized void remove(int ID){
    int pos = findClient(ID);
        if (pos >= 0){  
            ServerThread toTerminate = clients[pos];
            riwayat.add("\nMenghapus client thread " + ID + " at " + pos);
	    if (pos < clientCount-1){
                for (int i = pos+1; i < clientCount; i++){
                    clients[i-1] = clients[i];
	        }
	    }
	    clientCount--;
	    try{  
	      	toTerminate.close(); 
	    }
	    catch(IOException ioe){  
	      	riwayat.add("\nError menutup thread: " + ioe); 
	    }
	    toTerminate.stop(); 
	}
    }
    
    public void hapus(int ID){
    int pos = findClient(ID);
        if (pos >= 0){  
            ServerThread toTerminate = clients[pos];
            riwayat.add("\nMenghapus client thread " + ID + " at " + pos);
	    if (pos < clientCount-1){
                for (int i = pos+1; i < clientCount; i++){
                    clients[i-1] = clients[i];
	        }
	    }
	    clientCount--;
	    try{  
	      	toTerminate.close(); 
	    }
	    catch(IOException ioe){  
	      	riwayat.add("\nError menutup thread: " + ioe); 
	    }
	    toTerminate.stop(); 
	}
    }
    
    private void addThread(Socket socket){  
	if (clientCount < clients.length){
	    clients[clientCount] = new ServerThread(this,socket);
	    try{  
	      	clients[clientCount].open(); 
	        clients[clientCount].start();  
	        clientCount++; 
	    }
	    catch(IOException ioe){  
	      	riwayat.add("\nError membuka thread: " + ioe); 
	    } 
	}
	else{
            riwayat.add("\nClient ditolak: maximum " + clients.length + " reached.");
	}
    }
    

    /**
     * Creates new form Server
     */
    public Server() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        judul = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jabatan = new java.awt.Label();
        riwayat = new java.awt.List();
        copyright = new java.awt.Label();
        status = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        judul.setAlignment(java.awt.Label.CENTER);
        judul.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        judul.setForeground(new java.awt.Color(0, 102, 204));
        judul.setText("Trias Klinika");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jabatan.setAlignment(java.awt.Label.CENTER);
        jabatan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jabatan.setText("SERVER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jabatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jabatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        copyright.setAlignment(java.awt.Label.RIGHT);
        copyright.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        copyright.setText("CopyRight 2014");

        status.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        status.setText("on");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(riwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyright, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(status)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status)
                .addGap(6, 6, 6)
                .addComponent(riwayat, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        riwayat.add("Server Aktif "+setTanggal()+" "+setJam(jam));
        sonido("LYNC_joinedconference");
        try {
            this.setTitle(InetAddress.getLocalHost().toString());
        } 
        catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            awal();
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        status.setEnabled(false);
    }//GEN-LAST:event_statusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws RemoteException {
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label copyright;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label jabatan;
    private java.awt.Label judul;
    private java.awt.List riwayat;
    private javax.swing.JToggleButton status;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (thread != null){  
            try{
	        addThread(serverpesan.accept()); 
	    }
	    catch(Exception ioe){ 
                riwayat.add("\nServer accept error: \n");
	    }
        }
    }
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
