/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.test.inventoryobatapotek;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.client.apotek.InventoryObatApotek;
import trias.klinika.client.tabel.tabelInventoryObatApotek;

/**
 *
 * @author Azmil
 */
public class scenario_1_pengecekan_stok_masa_kritis {
    private String ip;
    private Registry registry;
    private InventoryObatApotekService service10;
    private InventoryObatApotekEntitas apotek = new InventoryObatApotekEntitas();
    
    public scenario_1_pengecekan_stok_masa_kritis() throws RemoteException, NotBoundException{
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
    public void testsetCekKritis () throws RemoteException, NotBoundException{
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service10 = (InventoryObatApotekService) registry.lookup("service10");
        System.out.println("cek kritis");        
        InventoryObatApotek interfaceObat = new InventoryObatApotek (service10);
        interfaceObat.setCekKritis();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

