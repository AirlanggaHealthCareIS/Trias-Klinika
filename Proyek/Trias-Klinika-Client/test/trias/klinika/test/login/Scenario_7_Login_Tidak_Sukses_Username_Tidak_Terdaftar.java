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
public class Scenario_7_Login_Tidak_Sukses_Username_Tidak_Terdaftar {
    private String ip;
    private Registry registry;
    private LoginService service1;
    private LoginEntitas users = new LoginEntitas();
    
    public Scenario_7_Login_Tidak_Sukses_Username_Tidak_Terdaftar() throws RemoteException, NotBoundException {
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
     * Username Devadata diindikasi dokter karena huruf depan = D
     */
    
    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek() {
        System.out.println("Cek");
        String username = "Devadata";
        String password = "lima";
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
        users.SetData("Devadata", "lima", "dokter", "id_dokter", "password_dokter", "status_dokter", "nama_dokter");
        String expResult = "Devadata";
        String result = users.getusername();
        assertEquals(expResult, result);
        expResult = "lima";
        result = users.getpassword();
        assertEquals(expResult, result);
        expResult = "dokter";
        result = users.getsebagai();
        assertEquals(expResult, result);
        expResult = "id_dokter";
        result = users.getfielduser();
        assertEquals(expResult, result);
        expResult = "password_dokter";
        result = users.getfieldpass();
        assertEquals(expResult, result);
        expResult = "status_dokter";
        result = users.getfieldstatus();
        assertEquals(expResult, result);
        expResult = "nama_dokter";
        result = users.getfieldnama();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Proses method, of class Login.
     */
    @Test
    public void testProses() {
        System.out.println("Proses");
        String username = "Devadata";
        String password = "lima";
        Login instance = new Login();
        String expResult = "User Belum Terdaftar";
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
        users.SetData("Devadata", "lima", "dokter", "id_dokter", "password_dokter", "status_dokter", "nama_dokter");
        int expResult = 1;
        int result = service1.CheckPassword(users);
        assertEquals(expResult, result);
    }
    
    /**
     * Username Revarata diindikasi reservasi karena huruf depan = R
     */
    
    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek1() {
        System.out.println("Cek 1");
        String username = "Revarata";
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
    public void testSetData1() {
        System.out.println("SetData 1");
        users.SetData("Revarata", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        String expResult = "Revarata";
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
    public void testProses1() {
        System.out.println("Proses 1");
        String username = "Revarata";
        String password = "cantik";
        Login instance = new Login();
        String expResult = "User Belum Terdaftar";
        String result = instance.Proses(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CheckPassword method, of class LoginService.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testCheckPassword1() throws RemoteException, NotBoundException {
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        System.out.println("CheckPassword 1");
        users.SetData("Revarata", "cantik", "reservasi", "id_reservasi", "password_reservasi", "status_reservasi", "nama_reservasi");
        int expResult = 1;
        int result = service1.CheckPassword(users);
        assertEquals(expResult, result);
    }
    
    /**
     * Username Avaata diindikasi apotek karena huruf depan = A
     */
    
    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek2() {
        System.out.println("Cek 2");
        String username = "Avaata";
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
    public void testSetData2() {
        System.out.println("SetData 2");
        users.SetData("Avaata", "cantik", "apotek", "id_apotek", "password_apotek", "status_apotek", "nama_apotek");
        String expResult = "Avaata";
        String result = users.getusername();
        assertEquals(expResult, result);
        expResult = "cantik";
        result = users.getpassword();
        assertEquals(expResult, result);
        expResult = "apotek";
        result = users.getsebagai();
        assertEquals(expResult, result);
        expResult = "id_apotek";
        result = users.getfielduser();
        assertEquals(expResult, result);
        expResult = "password_apotek";
        result = users.getfieldpass();
        assertEquals(expResult, result);
        expResult = "status_apotek";
        result = users.getfieldstatus();
        assertEquals(expResult, result);
        expResult = "nama_apotek";
        result = users.getfieldnama();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Proses method, of class Login.
     */
    @Test
    public void testProses2() {
        System.out.println("Proses 2");
        String username = "Avaata";
        String password = "cantik";
        Login instance = new Login();
        String expResult = "User Belum Terdaftar";
        String result = instance.Proses(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CheckPassword method, of class LoginService.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testCheckPassword2() throws RemoteException, NotBoundException {
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        System.out.println("CheckPassword 2");
        users.SetData("Avaata", "cantik", "apotek", "id_apotek", "password_apotek", "status_apotek", "nama_apotek");
        int expResult = 1;
        int result = service1.CheckPassword(users);
        assertEquals(expResult, result);
    }
    
    /**
     * Username Fefafata tidak diindikasi apapun karena huruf depan bukan D, R, atau A
     */
    
    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek3() {
        System.out.println("Cek 3");
        String username = "Fefafata";
        String password = "ganteng";
        Login instance = new Login();
        String expResult = "Sukses";
        String result = instance.Cek(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of SetData method, of class LoginEntitas.
     */
    @Test
    public void testSetData3() {
        System.out.println("SetData 3");
        users.SetData("Fefafata", "ganteng", null, null, null, null, null);
        String expResult = "Fefafata";
        String result = users.getusername();
        assertEquals(expResult, result);
        expResult = "ganteng";
        result = users.getpassword();
        assertEquals(expResult, result);
        expResult = null;
        result = users.getsebagai();
        assertEquals(expResult, result);
        expResult = null;
        result = users.getfielduser();
        assertEquals(expResult, result);
        expResult = null;
        result = users.getfieldpass();
        assertEquals(expResult, result);
        expResult = null;
        result = users.getfieldstatus();
        assertEquals(expResult, result);
        expResult = null;
        result = users.getfieldnama();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Proses method, of class Login.
     */
    @Test
    public void testProses3() {
        System.out.println("Proses 3");
        String username = "Fefafata";
        String password = "ganteng";
        Login instance = new Login();
        String expResult = "User Belum Terdaftar";
        String result = instance.Proses(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CheckPassword method, of class LoginService.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testCheckPassword3() throws RemoteException, NotBoundException {
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service1 = (LoginService) registry.lookup("service1");
        System.out.println("CheckPassword 3");
        users.SetData("Fefafata", "ganteng", null, null, null, null, null);
        int expResult = 1;
        int result = service1.CheckPassword(users);
        assertEquals(expResult, result);
    }
    
}
