/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.main;

import java.rmi.Remote;
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
import trias.klinika.server.service.QueryAntrean;
import trias.klinika.server.service.QueryListPetugas;
import trias.klinika.server.service.QueryPasien;
/**
 *
 * @author FazBam
 */
public class Main {
//    private static Remote QueryPasien;
    
        public static void main(String[] args) throws RemoteException {
            
        Registry server = LocateRegistry.createRegistry(4444);

        QueryLogin queryLogin = new QueryLogin() {};
        QueryPembayaran queryPembayaran = new QueryPembayaran() {};
        QueryInventoriObatDokter queryInventoriObatDokter = new QueryInventoriObatDokter(){};
        queryRekammedis QueryRekamMedis = new queryRekammedis (){};
        QueryInventoryObatApotek queryobatapotek = new QueryInventoryObatApotek (){};
        QueryPendaftaran querypendaftaran = new QueryPendaftaran (){};
        QueryListPembayaran querylistpembayaran = new QueryListPembayaran(){};
        QueryAntrean QueryAntrean = new QueryAntrean() {};
        QueryPasien QueryPasien = new QueryPasien(){};
        QueryListPetugas querylistpetugas = new QueryListPetugas(){};

        server.rebind("service1", queryLogin);
        server.rebind("service2", querypendaftaran);
        server.rebind("service3", QueryAntrean);
        server.rebind("service7", QueryPasien);
        server.rebind("service4", queryPembayaran);
        server.rebind("service4.1", querylistpembayaran);
        server.rebind("service5", querylistpetugas);
        server.rebind("service6", QueryRekamMedis);
        server.rebind("service10", queryobatapotek);
        server.rebind("service13", queryInventoriObatDokter);

        System.out.println("Server berhasil berjalan");
    }
}
