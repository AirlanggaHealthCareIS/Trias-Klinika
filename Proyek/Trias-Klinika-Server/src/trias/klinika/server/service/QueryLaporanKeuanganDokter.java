/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import trias.klinika.api.entitas.LaporanKeuanganDokterEntitas;
import trias.klinika.api.sevice.LaporanKeuanganDokterService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author Satria
 */
public class QueryLaporanKeuanganDokter extends UnicastRemoteObject implements LaporanKeuanganDokterService{
    LaporanKeuanganDokterEntitas LKDE = new LaporanKeuanganDokterEntitas();
    public QueryLaporanKeuanganDokter ()throws RemoteException{
    }
    
    public List<LaporanKeuanganDokterEntitas> getDataLaporan(String tgl_mulai, String tgl_sampai, String id_dokter) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
           ("SELECT P.ID_PEMERIKSAAN, P.TGL_PEMERIKSAAN, PA.NAMA_PASIEN, PE.JUMLAH_PEMBAYARAN FROM PEMERIKSAAN as P, PASIEN as PA, PEMBAYARAN as PE where P.ID_PEMBAYARAN = PE.ID_PEMBAYARAN AND P.ID_PASIEN = PA.ID_PASIEN AND P.TGL_PEMERIKSAAN >= '"+tgl_mulai+"' AND TGL_PEMERIKSAAN <= '"+tgl_sampai+"' AND ID_DOKTER = '"+id_dokter+"'");
            
            List<LaporanKeuanganDokterEntitas> list = new ArrayList<LaporanKeuanganDokterEntitas>();
            
            while(result.next()){
                LaporanKeuanganDokterEntitas LKDE = new LaporanKeuanganDokterEntitas();
  //              LKDE.setDataLaporan(result.getString("ID_PEMERIKSAAN"), result.getString("TGL_PEMERIKSAAN"), result.getString("NAMA_PASIEN"), result.getInt("JUMLAH_PEMBAYARAN"));
                
                list.add(LKDE);
            }
            
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
