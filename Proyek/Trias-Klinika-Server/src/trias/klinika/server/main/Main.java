/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.main;

import trias.klinika.server.service.QueryLogin;
import trias.klinika.server.service.QueryPembayaran;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author FazBam
 */
public class Main {
    
        public static void main(String[] args) throws RemoteException {
            
        Registry server = LocateRegistry.createRegistry(4444);

        QueryLogin queryLogin = new QueryLogin() {};
        QueryPembayaran queryPembayaran = new QueryPembayaran() {};

        server.rebind("service", queryLogin);
        server.rebind("service1", queryPembayaran);

        System.out.println("Server berhasil berjalan");
    }
}
