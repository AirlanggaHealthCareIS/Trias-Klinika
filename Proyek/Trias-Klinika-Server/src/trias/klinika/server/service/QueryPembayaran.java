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
import trias.klinika.api.sevice.pembayaranService;
import trias.klinika.server.utilitas.Koneksidatabase;
import trias.klinika.api.entitas.PembayaranEntitas;
import trias.klinika.api.entitas.RincianPembayaran;

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
    public void Save (PembayaranEntitas PE){
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("INSERT INTO `PEMBAYARAN`(`ID_PEMBAYARAN`, `BIAYA_DOKTER`, `JUMLAH_PEMBAYARAN`) VALUE (["+PE.getnomer_transaksi()+"],["+PE.getBIAYA_DOKTER()+"],["+PE.getTOTAL_BIAYA()+"]");
            
                  
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
    public void save (RincianPembayaran RP,PembayaranEntitas PE, int i){
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("INSERT INTO `RINCIAN_PEMBAYARAN`(`ID_RINCIAN_PEMBAYARAN`, `ID_PEMBAYARAN`, `ID_OBAT_DOKTER`) VALUE (["+i+"],["+PE.getnomer_transaksi()+"],["+RP.getID_OBAT()+"]");
            
                  
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
    public int biaya (int harga, String id){
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

}    
    
