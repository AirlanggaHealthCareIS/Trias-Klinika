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
public class Scenario_2_Login_Sukses_Reservasi {
    private String ip;
    private Registry registry;
    private LoginService service1;
    private LoginEntitas users = new LoginEntitas();
    
    public Scenario_2_Login_Sukses_Reservasi() throws RemoteException, NotBoundException {
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
        String username = "R0001";
        String password = "cantik";
        Login instance = new Login();
        String expResult = "Sukses";
        String result = instance.Cek(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of SetData method, of class LoginEntitas.
     */
    @Test
    public void testSetData() {
        System.out.println("SetData");
        users.SetData("R0001", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        String expResult = "R0001";
        String result = users.getusername();
        assertEquals(expResult, result);
        expResult = "cantik";
        result = users.getpassword();
        assertEquals(expResult, result);
        expResult = "reservasi";
        result = users.getsebagai();
        assertEquals(expResult, result);
        expResult = "id_reservasi";
        result = users.getfielduser();
        assertEquals(expResult, result);
        expResult = "password_reservasi";
        result = users.getfieldpass();
        assertEquals(expResult, result);
        expResult = "status_reservasi";
        result = users.getfieldstatus();
        assertEquals(expResult, result);
        expResult = "nama_reservasi";
        result = users.getfieldnama();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Proses method, of class Login.
     */
    @Test
    public void testProses() {
        System.out.println("Proses");
        String username = "R0001";
        String password = "cantik";
        Login instance = new Login();
        String expResult = "Login Sukses";
        String result = instance.Proses(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CheckPassword method, of class LoginService.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testCheckPassword() throws RemoteException, NotBoundException {
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        System.out.println("CheckPassword");
        users.SetData("R0001", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        int expResult = 3;
        int result = service1.CheckPassword(users);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNama method, of class LoginService.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testgetNama() throws RemoteException, NotBoundException {
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        System.out.println("getNama");
        users.SetData("R0001", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        users = service1.getNama(users);
        String expResult = "Chusnul";
        String result = users.getnamauser();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setnamauser method, of class LoginEntitas.
     */
    @Test
    public void testsetnamauser() {
        System.out.println("setnamauser");
        users.setnamauser("Chusnul");
        String expResult = "Chusnul";
        String result = users.getnamauser();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Eksekusi method, of class Login.
     */
    @Test
    public void testEksekusi() throws Exception {
        System.out.println("Eksekusi");
        users.SetData("R0001", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        Login instance = new Login();
        instance.Eksekusi(users);
        String expResult = "reservasi";
        String result = users.getsebagai();
        assertEquals(expResult, result);
    }
}
