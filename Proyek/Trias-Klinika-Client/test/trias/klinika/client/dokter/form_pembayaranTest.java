/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ICUN
 */
public class form_pembayaranTest {
    
    public form_pembayaranTest() {
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
     * Test of plusone method, of class form_pembayaran.
     */
    @Test
    public void testPlusone() {
        System.out.println("plusone");
        Date tgl = null;
        String a = "";
        form_pembayaran instance = null;
        String expResult = "";
        String result = instance.plusone(tgl, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPembayaranDate method, of class form_pembayaran.
     */
    @Test
    public void testSetPembayaranDate() throws Exception {
        System.out.println("setPembayaranDate");
        form_pembayaran instance = null;
        instance.setPembayaranDate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ID method, of class form_pembayaran.
     */
    @Test
    public void testID() throws Exception {
        System.out.println("ID");
        String idp = "";
        form_pembayaran instance = null;
        instance.ID(idp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
