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
import trias.klinika.api.sevice.NotifikasiStokObatApotekService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Satria
 */
public class QueryNotifikasiStokObatApotek extends UnicastRemoteObject implements NotifikasiStokObatApotekService{
    public QueryNotifikasiStokObatApotek() throws RemoteException{ 
    }
    public String[] StokObatAokter(String[] IdObat) throws RemoteException, SQLException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select o.ID_OBAT from obat as o , detail_obat as do WHERE do.RUANGAN = 'Apotek' AND do.QTY_OBAT <= 5 AND o.ID_OBAT = do.ID_OBAT");
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
                IdObat[0] = "Tidak Ada Stok Obat Kritis";
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
    public InventoryObatApotekEntitas getobat(String IdObat) throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        Statement statement = null;
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM obat as o, detail_obat as do WHERE o.ID_OBAT = '"+IdObat+"' AND do.QTY_OBAT <= 5 AND o.ID_OBAT = do.ID_OBAT AND Ruangan = 'Apotek'");
            result.first();
            InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
            inventory.setIdObat(result.getString("ID_OBAT"));
            inventory.setIdSpesialis(result.getString("ID_SPESIALIS"));
            inventory.setIdJenisObat(result.getString("ID_JENIS"));
            inventory.setNamaObat(result.getString("NAMA_OBAT"));
            inventory.setHargaObat(result.getInt("HARGA_OBAT"));
            inventory.setDeskripsi(result.getString("DESKRIPSI_OBAT"));
            inventory.setQty(result.getInt("QTY_OBAT"));    
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
