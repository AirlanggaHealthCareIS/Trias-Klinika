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
import java.util.List;
import trias.klinika.api.entitas.ListPembayaranEntitas;
import trias.klinika.api.sevice.ListPembayaranService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author Sahirul
 */
public class QueryListPembayaran extends UnicastRemoteObject implements ListPembayaranService {
    public QueryListPembayaran() throws RemoteException {
        
    }

    @Override
    public List<ListPembayaranEntitas> getBayar() throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        
        Statement statement = null;
        
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT r.tgl_pemeriksaan, r.id_pemeriksaan, d.nama_dokter, p.nama_pasien, b.id_pembayaran, b.biaya_dokter, b.jumlah_pembayaran FROM pemeriksaan as r, dokter as d, pasien as p, pembayaran as b WHERE r.id_dokter=d.id_dokter and r.id_pasien=p.id_pasien and r.id_pembayaran=b.id_pembayaran and r.tgl_pemeriksaan >= \"2015-03-10\" ");
            
            List<ListPembayaranEntitas> list = new ArrayList<ListPembayaranEntitas>();
            
            while(result.next()){
                ListPembayaranEntitas listPembayaranEntitas = new ListPembayaranEntitas();
                listPembayaranEntitas.setnamaPasien(result.getString("nama_pasien"));
                listPembayaranEntitas.setnamaDokter(result.getString("nama_dokter"));
                listPembayaranEntitas.setbiayaDokter(result.getInt("biaya_dokter"));
//                listPembayaranEntitas.setbiayaTindakan(result.getInt("nama_dokter"));
//                listPembayaranEntitas.setbiayaKonsultasi(result.getInt("nama_dokter"));
                listPembayaranEntitas.settotalBayar(result.getInt("jumlah_pembayaran"));
                listPembayaranEntitas.setidPemeriksaan(result.getString("id_pemeriksaan"));
                
                
                list.add(listPembayaranEntitas);
    
            }
            
            return list;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        
        
    }
    public ListPembayaranEntitas getdatadetail(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            
            ResultSet result = statement.executeQuery("SELECT r.id_pemeriksaan, b.biaya_dokter, b.jumlah_pembayaran FROM pemeriksaan as r, dokter as d, pasien as p, pembayaran as b WHERE r.id_dokter=d.id_dokter and r.id_pasien=p.id_pasien and r.id_pembayaran=b.id_pembayaran and r.id_pemeriksaan = '"+id+"' ");
            
            
            ListPembayaranEntitas listpembayaranentitas = new ListPembayaranEntitas();
            result.first();
                listpembayaranentitas.setbiayaDokter(result.getInt("biaya_dokter"));
                listpembayaranentitas.settotalBayar(result.getInt("jumlah_pembayaran"));
            
                
                

            result.close();
            
            return listpembayaranentitas;
            
        } catch (SQLException exception) {
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
    public List<ListPembayaranEntitas> getTelat() throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        
        Statement statement = null;
        
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT r.tgl_pemeriksaan, r.id_pemeriksaan, d.nama_dokter, p.nama_pasien, b.id_pembayaran, b.biaya_dokter, b.jumlah_pembayaran FROM pemeriksaan as r, dokter as d, pasien as p, pembayaran as b WHERE r.id_dokter=d.id_dokter and r.id_pasien=p.id_pasien and r.id_pembayaran=b.id_pembayaran and r.tgl_pemeriksaan < \"2015-03-10\"   ");
            
            List<ListPembayaranEntitas> list = new ArrayList<ListPembayaranEntitas>();
            
            while(result.next()){
                ListPembayaranEntitas listPembayaranEntitas = new ListPembayaranEntitas();
                listPembayaranEntitas.setnamaPasien(result.getString("nama_pasien"));
                listPembayaranEntitas.setnamaDokter(result.getString("nama_dokter"));
                listPembayaranEntitas.setbiayaDokter(result.getInt("biaya_dokter"));
//                listPembayaranEntitas.setbiayaTindakan(result.getInt("nama_dokter"));
//                listPembayaranEntitas.setbiayaKonsultasi(result.getInt("nama_dokter"));
                listPembayaranEntitas.settotalBayar(result.getInt("jumlah_pembayaran"));
                listPembayaranEntitas.setidPemeriksaan(result.getString("id_pemeriksaan"));
                listPembayaranEntitas.settglPemeriksaan(result.getString("tgl_pemeriksaan"));
                
                list.add(listPembayaranEntitas);
    
            }
            
            return list;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        
        
    }
    
    
}
