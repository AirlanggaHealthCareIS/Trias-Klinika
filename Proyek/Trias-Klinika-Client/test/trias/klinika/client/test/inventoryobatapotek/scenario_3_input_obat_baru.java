/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.test.inventoryobatapotek;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.apotek.InventoryObatApotek;
import trias.klinika.client.tabel.tabelInventoryObatApotek;

/**
 *
 * @author Azmil
 */
public class scenario_3_input_obat_baru {
    private String ip;
    private Registry registry;
    private InventoryObatApotekService service10;
    private InventoryObatApotekEntitas users = new InventoryObatApotekEntitas();
    
    public scenario_3_input_obat_baru() throws RemoteException, NotBoundException{
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
    @Test
    public void testSetData() {
        System.out.println("SetData");
        users.setIdObat("O0001");
        String expResult = "O0001";
        String result = users.getIdObat();
        assertEquals (expResult, result);
        users.setIdSpesialis("S0001");
        expResult = "S0001";
        result = users.getIdSpesialis();
        assertEquals(expResult, result);
        users.setIdJenisObat("J0001");
        expResult = "J0001";
        result = users.getIdJenisObat();
        assertEquals(expResult, result);
        users.setNamaObat("pulvis");
        expResult = "pulvis";
        result = users.getNamaObat();
        assertEquals(expResult, result);
        users.setHargaObat(12000);
        expResult = "12000";
        int hasil = users.getHargaObat();
        assertEquals(expResult, hasil);
        users.setDeskripsi("untuk penggunaan obat keluar");
        expResult ="untuk penggunaan obat keluar";
        result = users.getDeskripsi();
        assertEquals(expResult, result);
        users.setQty(12);
        expResult ="12";
        hasil = users.getQty();
        assertEquals (expResult, hasil);
        users.setIdDetailObat(1);
        expResult = "1";
        hasil = users.getIdDetailObat();
        assertEquals(expResult, hasil);
        users.setTglMasuk("2015-04-01");
        expResult = "2015-04-01";
        result = users.getTglMasuk();
        assertEquals (expResult, result);
        users.setMasaPakai("2020-12-11");
        expResult = "2020-12-11";
        result = users.getMasaPakai();
        assertEquals(expResult, result);
        users.setRuangObat("apotek");
        expResult = "apotek";
        result = users.getRuangObat();
        assertEquals(expResult, result);
        
       
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
