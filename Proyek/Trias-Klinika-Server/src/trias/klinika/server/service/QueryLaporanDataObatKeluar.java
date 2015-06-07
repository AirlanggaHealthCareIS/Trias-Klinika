/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.sevice.LaporanDataObatKeluarService;
import trias.klinika.server.utilitas.Koneksidatabase;
import trias.klinika.api.entitas.LaporanDataObatKeluarEntitas;


/**
 *
 * @author Sahirul
 */
public class QueryLaporanDataObatKeluar extends UnicastRemoteObject implements LaporanDataObatKeluarService{
    LaporanDataObatKeluarEntitas LDOKE = new LaporanDataObatKeluarEntitas();
    public QueryLaporanDataObatKeluar ()throws RemoteException{
    }
    public List<LaporanDataObatKeluarEntitas> getDataLaporan(String tgl_mulai, String tgl_sampai, String id_dokter) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
           ("SELECT p.tgl_pemeriksaan, rr.id_obat_keluar, o.nama_obat, rr.jumlah_obat, r.id_resep FROM `rincian_resep` as rr, `pemeriksaan` as p, `obat` as o, `resep` as r WHERE p.id_resep = r.id_resep AND r.id_resep = rr.id_resep AND rr.id_obat_keluar = o.id_obat AND r.status_resep = \"0\"");
            
            List<LaporanDataObatKeluarEntitas> list = new ArrayList<LaporanDataObatKeluarEntitas>();
            
            while(result.next()){
                LaporanDataObatKeluarEntitas LDOK = new LaporanDataObatKeluarEntitas();
                LDOK.setDataLaporan(result.getString("TGL_PEMERIKSAAN"), result.getString("id_obat_keluar"), result.getString("nama_obat"), result.getInt("jumlah_obat"), result.getString("id_resep"));
                
                list.add(LDOK);
            }
            
            //result.first()
            result.close();
            
            return list;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
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
}
