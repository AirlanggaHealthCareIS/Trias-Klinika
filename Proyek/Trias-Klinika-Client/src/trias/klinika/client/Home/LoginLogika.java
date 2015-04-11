/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.Home;

import trias.klinika.api.sevice.LoginService;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.client.dokter.Menu_Dokter;
import trias.klinika.client.reservasi.Menu_Reservasi;
import trias.klinika.client.apotek.Menu_Apotek;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Faz
 */
public class LoginLogika {
    
    private String [] pesan = {"Sistem Error","User Belum Terdaftar","Password Salah","Login Sukses"};
    private int indeks = 0;
    private String ip;
    private Registry registry;
    private LoginService service;
    
    public void Awal() throws RemoteException, NotBoundException {
        ip = JOptionPane.showInputDialog("Masukkan IP Address: ");
        registry = LocateRegistry.getRegistry(ip,4444);
        service = (LoginService) registry.lookup("service");
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
        LoginEntitas users = new LoginEntitas();
        users.setusername(username);
        users.setpassword(password);
        String sebagai = username.substring(0, 1);
        if (null != sebagai) switch (sebagai) {
            case "D":
                users.setsebagai("dokter");
                users.setfielduser("id_dokter");
                users.setfieldpass("password_dokter");
                break;
            case "R":
                users.setsebagai("reservasi");
                users.setfielduser("id_reservasi");
                users.setfieldpass("password_reservasi");
                break;
            case "A":
                users.setsebagai("apotek");
                users.setfielduser("id_apotek");
                users.setfieldpass("password_apotek");
                break;
        }
        try {
            indeks = service.CheckPassword(users);
            if (indeks == 3) {
                pesan[indeks] = users.getsebagai();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginLogika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pesan[indeks];
    }
    
    public void Eksekusi (String users) {
        if (null != users) switch (users) {
            case "dokter":{
                Menu_Dokter menu = new Menu_Dokter();
                menu.setTitle(ip);
                menu.setLocation(500, 200);
                menu.setVisible(true);
                break;
            }
            case "reservasi":{
                Menu_Reservasi menu = new Menu_Reservasi();
                menu.setTitle(ip);
                menu.setLocation(500, 200);
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
}
