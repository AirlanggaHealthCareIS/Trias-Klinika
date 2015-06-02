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
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.NotifikasiObatExpiredService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Faz
 */
public class QueryNotifikasiObatExpired extends UnicastRemoteObject implements NotifikasiObatExpiredService {
    
    public QueryNotifikasiObatExpired() throws RemoteException{ 
    }
    
    @Override
    public String[] ObatApotekExpired(String[] IdObat, String tanggal ) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select ID_OBAT from detail_obat WHERE RUANGAN = 'Apotek' AND datediff ('"+tanggal+"', MASA_PAKAI) <= -5");
            if (result.last() != false) {
                result.last();
                IdObat = new String [result.getRow()];
                result.first();
                for (int i=0;i<IdObat.length;i++){
                    IdObat [i] = result.getString("ID_OBAT");
                    result.next();
                }
                result.close();
            }
            else {
                IdObat = new String [1];
                IdObat[0] = "Tidak Ada Obat Expired";
            }
            return IdObat;
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
    public String[] ObatDokterExpired(String[] IdObat, String tanggal ) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select ID_OBAT from detail_obat WHERE RUANGAN = 'Dokter' AND datediff ('"+tanggal+"', MASA_PAKAI) <= -5");
            if (result.last() != false) {
                result.last();
                IdObat = new String [result.getRow()];
                result.first();
                for (int i=0;i<IdObat.length;i++){
                    IdObat [i] = result.getString("ID_OBAT");
                    result.next();
                }
                result.close();
            }
            else {
                IdObat = new String [1];
                IdObat[0] = "Tidak Ada Obat Expired";
            }
            return IdObat;
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
    public InventoryObatApotekEntitas getobat(String IdObat) throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        Statement statement = null;
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT  * FROM obat WHERE ID_OBAT = '"+IdObat+"'");
            InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
            inventory.setIdObat(result.getString("ID_OBAT"));
            inventory.setIdSpesialis(result.getString("ID_SPESIALIS"));
            inventory.setIdJenisObat(result.getString("ID_JENIS"));
            inventory.setNamaObat(result.getString("NAMA_OBAT"));
            inventory.setHargaObat(result.getInt("HARGA_OBAT"));
            inventory.setDeskripsi(result.getString("DESKRIPSI_OBAT"));
            inventory.setQty(result.getInt("TOTAL_JUMLAH"));    
            return inventory;
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
