/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.test.InventoriObatDokter;

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
import trias.klinika.api.entitas.InventoriObatDokterEntitas;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.InventoriObatDokterService;
import trias.klinika.client.Home.Login;
import trias.klinika.client.dokter.Inventori_Obat_Dokter;
import trias.klinika.client.dokter.UtamaDokter;
import trias.klinika.client.tabel.tabelinventoriobtdokter;

/**
 *
 * @author iqbal
 */
public class scenario_1_Pengurangan_obat {
    
    private String ip;
    private Registry registry;
    private InventoriObatDokterService service13;
    private InventoriObatDokterEntitas dokter = new InventoriObatDokterEntitas();
    
    public scenario_1_Pengurangan_obat() throws RemoteException, NotBoundException {
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
    public void testsettambahOBlama () throws RemoteException, NotBoundException{
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service13 = (InventoriObatDokterService) registry.lookup("service13");
        System.out.println("pengurangan sukses");
        Login LO = new Login();
        LoginEntitas LE = new LoginEntitas();
        UtamaDokter UD = new UtamaDokter(LE, LO);
        Inventori_Obat_Dokter interfacetambah = new Inventori_Obat_Dokter (service13, UD);
        interfacetambah.setpengurangan();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}