/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;
import trias.klinika.api.entitas.laporan_keuangan_reservasiEntity;
import trias.klinika.api.entitas.rekammedisEntyty;
import trias.klinika.api.sevice.laporankeuanganReservasiService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Acer
 */
public class QueryLaporanKeuanganReservasi extends UnicastRemoteObject implements laporankeuanganReservasiService{

    public QueryLaporanKeuanganReservasi() throws RemoteException {
       
   }
    
    
    
    @Override
    public List<laporan_keuangan_reservasiEntity> getlaporan() throws RemoteException {
       System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

            try {
                statement =  Koneksidatabase.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT d.ID_DOKTER, d.NAMA_DOKTER, p.BIAYA_DOKTER FROM dokter AS d, pembayaran AS p WHERE r.ID_RESEP = p.ID_RESEP");
            
            List<laporan_keuangan_reservasiEntity> list = new ArrayList<laporan_keuangan_reservasiEntity>();
while(result.next()){
                laporan_keuangan_reservasiEntity laporanKeuanganReservasi = new laporan_keuangan_reservasiEntity();
                laporanKeuanganReservasi.setid_dokter(result.getString("ID_DOKTER"));
                laporanKeuanganReservasi.setnama_dokter(result.getString("NAMA_DOKTER"));
                laporanKeuanganReservasi.setjumlah(result.getInt("BIAYA_DOKTER"));
                
                list.add(laporanKeuanganReservasi);
            }

            result.close();
            
            return list;
            } catch (SQLException ex) {
                ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @Override
    public laporan_keuangan_reservasiEntity getdata(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<laporan_keuangan_reservasiEntity> getdatarekam(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public rekammedisEntyty getdatadetail(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ok(rekammedisEntyty rekammedisEntyty) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
