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
import trias.klinika.api.sevice.pembayaranService;
import trias.klinika.server.utilitas.Koneksidatabase;
import trias.klinika.api.entitas.PembayaranEntitas;
import trias.klinika.api.entitas.RincianPembayaran;
import trias.klinika.api.entitas.RincianPembayaranEntitas;

/**
 *
 * @author ICUN
 */
public class QueryPembayaran extends UnicastRemoteObject implements pembayaranService{
    
    public QueryPembayaran() throws RemoteException {
        
    }
    
    
    
    @Override
    public String[] obat(String [] pk) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT o.ID_OBAT, o.NAMA_OBAT\n" +
                    "FROM OBAT AS o, DETAIL_OBAT AS \n" +
                   "DO WHERE do.RUANGAN_OBAT =  'Ruang 1'");
            
            result.last();
            pk = new String [result.getRow()];
            result.first();

            for (int i=0;i<pk.length;i++){
                pk [i] = result.getString("ID_OBAT")+" - "+result.getString("NAMA_OBAT");
                result.next();
            }

            result.close();
            
            return pk;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return pk;
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
    public void Save (PembayaranEntitas PE)throws RemoteException {
        System.out.println("masukan pembayaran");
       PreparedStatement statement = null;
        
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
            
       "INSERT INTO `PEMBAYARAN`(`ID_PEMBAYARAN`, `BIAYA_DOKTER`, `JUMLAH_PEMBAYARAN`) VALUE ("+PE.getnomer_transaksi()+","+PE.getBIAYA_DOKTER()+","+PE.getTOTAL_BIAYA()+")");
            System.out.println(statement.toString());
            statement.executeUpdate();   
                  
        }catch (SQLException exception) {
            exception.printStackTrace();
            
           
        }finally{
            if(statement != null){
                try{
                   statement.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
        } 
    }
    
    @Override
    public void save (RincianPembayaranEntitas RPE)throws RemoteException{
        System.out.println("masukan detail pembayaran");
        PreparedStatement statement = null;
       
        
        try {
           
            statement = Koneksidatabase.getConnection().prepareStatement(
            
            "INSERT INTO `RINCIAN_PEMBAYARAN`(`ID_RINCIAN_PEMBAYARAN`, `ID_PEMBAYARAN`, `ID_OBAT_DOKTER`) VALUE ("+RPE.getID_RINCIAN_PEMBAYARAN()+","+RPE.getID_PEMBAYARAN()+",'"+RPE.getID_OBAT_DOKTER()+"')");
             System.out.println(statement.toString());
             statement.executeUpdate();   
                  
        }catch (SQLException exception) {
            exception.printStackTrace();
           
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
    public int biaya (int harga, String id)throws RemoteException{
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT HARGA_OBAT FROM OBAT WHERE ID_OBAT = '"+id+"'");
            
            
            
           result.first();
           harga = result.getInt("HARGA_OBAT");
          
        }catch (SQLException exception) {
            exception.printStackTrace();
           
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
    }
        return harga;
        
    }
    
    @Override
    public int d (int id) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Id");

        Statement statement = null;
        try{
           statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
                ("SELECT ID_PEMBAYARAN FROM pembayaran ");
            
            result.last();
            id = result.getInt("ID_PEMBAYARAN");
             
               

        }catch(SQLException exception){
          exception.printStackTrace();
        
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                   exception.printStackTrace();
                }
            }
        }
        return id;
    }
    
    public String ID (String idp) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Id");

        Statement statement = null;
        try{
           statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
                ("select id_pasien from pemeriksaan ");
            
            result.last();
            idp = result.getString("id_pasien");
             
               

        }catch(SQLException exception){
          exception.printStackTrace();
        
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                   exception.printStackTrace();
                }
            }
        }
       return idp; 
}
}
    
    
