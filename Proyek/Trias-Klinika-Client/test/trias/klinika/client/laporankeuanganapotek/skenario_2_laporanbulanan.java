/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.laporankeuanganapotek;

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
import trias.klinika.api.entitas.LaporanKeuanganApotekEntitas;
import trias.klinika.api.sevice.LaporanKeuanganService;
import trias.klinika.client.apotek.LaporanKeuanganApotek;

/**
 *
 * @author TOSHIBA
 */
public class skenario_2_laporanbulanan {
    
    private String ip;
    private Registry registry;
    private LaporanKeuanganService service9_c_1;
    private LaporanKeuanganApotekEntitas apotek = new LaporanKeuanganApotekEntitas();
    
    public skenario_2_laporanbulanan() throws RemoteException, NotBoundException{
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
    public void testTahun () throws RemoteException, NotBoundException{
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service9_c_1 = (LaporanKeuanganService) registry.lookup("service 9_c_1");
        System.out.println("Bulan");        
        LaporanKeuanganApotek laporankeuangan = new LaporanKeuanganApotek (service9_c_1);
        laporankeuangan.CekBulan();
    }
}