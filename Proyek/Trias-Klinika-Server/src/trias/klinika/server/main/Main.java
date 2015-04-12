/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import trias.klinika.server.service.QueryInventoriObatDokter;
import trias.klinika.server.service.QueryInventoryObatApotek;
import trias.klinika.server.service.QueryLogin;
import trias.klinika.server.service.QueryPembayaran;
import trias.klinika.server.service.QueryPendaftaran;
import trias.klinika.server.service.queryRekammedis;
import trias.klinika.server.service.QueryListPembayaran;
/**
 *
 * @author FazBam
 */
public class Main {
    
        public static void main(String[] args) throws RemoteException {
            
        Registry server = LocateRegistry.createRegistry(4444);

        QueryLogin queryLogin = new QueryLogin() {};
        QueryPembayaran queryPembayaran = new QueryPembayaran() {};
        QueryInventoriObatDokter queryInventoriObatDokter = new QueryInventoriObatDokter(){};
        queryRekammedis QueryRekamMedis = new queryRekammedis (){};
        QueryInventoryObatApotek queryobatapotek = new QueryInventoryObatApotek (){};
        QueryPendaftaran querypendaftaran = new QueryPendaftaran (){};
        QueryListPembayaran querylistpembayaran = new QueryListPembayaran(){};

        server.rebind("service", queryLogin);
        server.rebind("service1", queryPembayaran);
        server.rebind("service2", queryInventoriObatDokter);
        server.rebind("service3", QueryRekamMedis);
        server.rebind("service4", queryobatapotek);
        server.rebind("service5", querypendaftaran);
        server.rebind("service6", querylistpembayaran);

        System.out.println("Server berhasil berjalan");
    }
}
