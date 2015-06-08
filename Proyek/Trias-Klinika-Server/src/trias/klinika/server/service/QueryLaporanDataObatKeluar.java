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
           ("SELECT p.tgl_pemeriksaan, rr.id_obat_keluar, o.nama_obat, rr.jumlah_obat, r.id_resep FROM `rincian_resep` as rr, `pemeriksaan` as p, `obat` as o, `resep` as r WHERE p.id_resep = r.id_resep AND r.id_resep = rr.id_resep AND rr.id_obat_keluar = o.id_obat AND r.status_resep = \"0\" AND P.TGL_PEMERIKSAAN >= '"+tgl_mulai+"' AND p.TGL_PEMERIKSAAN <= '"+tgl_sampai+"' ORDER BY p.TGL_PEMERIKSAAN");
            
            List<LaporanDataObatKeluarEntitas> list = new ArrayList<LaporanDataObatKeluarEntitas>();
            
            while(result.next()){
                LaporanDataObatKeluarEntitas LDOK = new LaporanDataObatKeluarEntitas();
                LDOK.setDataLaporan(result.getString("TGL_PEMERIKSAAN"), result.getString("id_obat_keluar"), result.getString("nama_obat"), result.getInt("jumlah_obat"), result.getString("id_resep"));
                
                list.add(LDOK);
            }
            
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
    
    @Override
    public String[] DropdownTahun(String[] tahun) throws RemoteException {
        int TahunMulai;
        int TahunTerakhir;
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT TGL_PEMERIKSAAN FROM PEMERIKSAAN ORDER BY TGL_PEMERIKSAAN ASC ");
            result.first();
            TahunMulai = Integer.parseInt(result.getString("TGL_PEMERIKSAAN").substring(0,4));
            System.out.println(TahunMulai);
            result.last();
            TahunTerakhir = Integer.parseInt(result.getString("TGL_PEMERIKSAAN").substring(0, 4));
            System.out.println(TahunTerakhir);
            result.close();
            if(TahunTerakhir == TahunMulai ){
                tahun = new String [1];
                tahun [0] = Integer.toString(TahunMulai);
            }
            else {
                System.out.println("jancok");
            tahun = new String [(TahunTerakhir - TahunMulai)+ 1];
            for (int i=0;i<tahun.length;i++){
                tahun [i] = Integer.toString(TahunMulai + i);
            }
            }
            
            result.close();
            return tahun;
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
        }
    @Override
    public String[] DropdownBulan(String[] bulan, String tahun) throws RemoteException {
        int BulanMulai;
        int BulanTerakhir;
        Statement statement = null;
        System.out.println(tahun);
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT TGL_PEMERIKSAAN FROM PEMERIKSAAN WHERE TGL_PEMERIKSAAN LIKE '"+tahun+"%' ORDER BY TGL_PEMERIKSAAN ASC ");
            result.first();
            BulanMulai = Integer.parseInt(result.getString("TGL_PEMERIKSAAN").substring(5, 7));
            System.out.println(BulanMulai);
            result.last();
            BulanTerakhir = Integer.parseInt(result.getString("TGL_PEMERIKSAAN").substring(5, 7));
            System.out.println(BulanTerakhir);
            result.close();
            if(BulanTerakhir == BulanMulai ){
                bulan = new String [1];
                bulan [0] = Integer.toString(BulanMulai);
            }
            else {
            bulan = new String [(BulanTerakhir - BulanMulai)+ 1];
            for (int i=0;i<bulan.length;i++){
                bulan [i] = Integer.toString(BulanMulai + i);
            }
            }
            
            
            return bulan;
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
        }
}
