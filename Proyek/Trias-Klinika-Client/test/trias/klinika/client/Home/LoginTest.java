/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.Home;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.pesan.pesan;

/**
 *
 * @author Faz
 */
public class LoginTest {
    
    public LoginTest() {
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
     * Test of Awal method, of class Login.
     */
    @Test
    public void testAwal() throws Exception {
        System.out.println("Awal");
        Login instance = new Login();
        instance.Awal();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTanggal method, of class Login.
     */
    @Test
    public void testSetTanggal() {
        System.out.println("setTanggal");
        Login instance = new Login();
        Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("dd/MM/yyyy");
        String expResult = kal.format(skrg);
        String result = instance.setTanggal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setJam method, of class Login.
     */
    @Test
    public void testSetJam() {
        System.out.println("setJam");
        Date jam = null;
        Login instance = new Login();
        jam = new Date();
        String expResult = jam.getHours()+":"+jam.getMinutes()+":"+jam.getSeconds();
        String result = instance.setJam(jam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Cek method, of class Login.
     */
    @Test
    public void testCek() {
        System.out.println("Cek");
        String username = "D0001";
        String password = "lima";
        Login instance = new Login();
        String expResult = "Sukses";
        String result = instance.Cek(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Proses method, of class Login.
     */
    @Test
    public void testProses() {
        System.out.println("Proses");
        String username = "D0001";
        String password = "lima";
        Login instance = new Login();
        String expResult = "Login Sukses";
        String result = instance.Proses(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of koneksi method, of class Login.
     */
    @Test
    public void testKoneksi() {
        System.out.println("koneksi");
        Login instance = new Login();
        instance.koneksi();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of kirim method, of class Login.
     */
    @Test
    public void testKirim() {
        System.out.println("kirim");
        pesan msg = new pesan("update", "D0001", "dr. Ponco Birowo", "Reservasi");
        Login instance = new Login();
        instance.kirim(msg);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Eksekusi method, of class Login.
     */
    @Test
    public void testEksekusi() throws Exception {
        System.out.println("Eksekusi");
        LoginEntitas users = new LoginEntitas();
        users.setsebagai("dokter");
        users.setfielduser("id_dokter");
        users.setfieldpass("password_dokter");
        users.setfieldstatus("status_dokter");
        users.setfieldnama("nama_dokter");
        users.setusername("D0001");
        users.setpassword("lima");
        Login instance = new Login();
        instance.Eksekusi(users);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Login.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class Login.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Login instance = new Login();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
