/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.test.login;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;
import trias.klinika.api.sevice.LoginService;
import trias.klinika.client.Home.Login;

/**
 *
 * @author Faz
 */
public class Scenario_5_Login_Tidak_Sukses_Username_Kosong {
    private String ip;
    private Registry registry;
    private LoginService service1;
    private LoginEntitas users = new LoginEntitas();
    
    public Scenario_5_Login_Tidak_Sukses_Username_Kosong() throws RemoteException, NotBoundException {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek() {
        System.out.println("Cek");
        String username = "";
        String password = "benar";
        Login instance = new Login();
        String expResult = "Masukkan Username Terlebih Dahulu";
        String result = instance.Cek(username, password);
        assertEquals(expResult, result);
    }
}
