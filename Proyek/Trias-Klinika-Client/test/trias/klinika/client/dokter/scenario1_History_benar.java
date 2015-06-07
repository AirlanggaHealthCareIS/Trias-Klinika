/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

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
import trias.klinika.api.entitas.rekammedisEntyty;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.client.dokter.rekammedis;
import trias.klinika.client.tabel.tabelrekammedis;
/**
 *
 * @author Acer
 */
public class scenario1_History_benar {
    private String ip;
    private Registry registry;
    private serviceRekam service6;
    private rekammedisEntyty rekam = new rekammedisEntyty();
    public scenario1_History_benar()throws RemoteException, NotBoundException {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setHistory method, of class rekammedis.
     */
    @Test
    public void testSetHistory() throws RemoteException, NotBoundException{
        ip = "127.0.0.1";
        registry = LocateRegistry.getRegistry(ip,4444);
        service6 = (serviceRekam) registry.lookup("service6");
        System.out.println(" ");    
//        rekammedis interfaceRekammedis = new rekammedis (service6);
//        
//        interfaceRekammedis.setHistory();
//        
    }

    
}
