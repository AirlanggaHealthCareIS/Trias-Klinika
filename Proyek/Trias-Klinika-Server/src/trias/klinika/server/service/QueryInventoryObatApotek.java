/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.server.service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import trias.klinika.api.sevice.InventoryObatApotekService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author Azmil
 */
public class QueryInventoryObatApotek extends UnicastRemoteObject implements InventoryObatApotekService{
    public QueryInventoryObatApotek() throws RemoteException{
        
    }

    @Override
    public List<InventoryObatApotekEntitas> getobat() throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        Statement statement = null;
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT o.id_obat, o.nama_obat, o.deskripsi_obat, o.harga_obat, do.kuantitas_obat, do.tgl_masuk_obat, do.masa_pakai_obat, jo.nama_jenis_obat FROM obat as o, detail_obat as do, jenis_obat as jo, dibagi as d WHERE do.ruangan_obat = 'Apotek'");
            List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
            while (result.next()){
                InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
                inventory.setNamaObat(result.getString("nama_obat"));
                inventory.setJenisObat(result.getString("nama_jenis_obat"));
                inventory.setQty(result.getInt("kuantitas_obat"));
                inventory.setHargaObat(result.getInt("harga_obat"));
                inventory.setTglMasuk(result.getString("tgl_masuk_obat"));
                inventory.setMasaPakai(result.getString("masa_pakai_obat"));
                inventory.setDeskripsi(result.getString("deskripsi_obat"));
                inventory.setIdObat(result.getString("id_obat"));
                
                list.add(inventory);
            }
            result.close();
            return list;
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

    @Override
    public void insertObatBaru(InventoryObatApotekEntitas inventory) throws RemoteException {
        System.out.println("Dokter melakukan proses insert");
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement("INSERT INTO obat(id_obat, id_spesialis, nama_obat, harga_obat, deskripsi_obat)"+"VALUES (?,?,?,?,?)");
            statement.setString(1, inventory.getIdDetailObat());
            statement.setString(2, inventory.getIdObat());
            statement.setInt(3, inventory.getQty());
            statement.setString(4, inventory.getTglMasuk());
            statement.setString(5, inventory.getMasaPakai());
            statement.setString(6, inventory.getRuangObat());
            statement.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
            }
        }
//To change body of generated methods, choose Tools | Templates.
    }
        PreparedStatement statement2 = null;
        try{
            statement2 = Koneksidatabase.getConnection().prepareStatement("INSERT INTO jenis_obat (id_jenis_obat, nama_jenis_obat)"+"values(?,?)");
            statement2.setString(1, inventory.getIdJenisObat());
            statement2.setString(2, inventory.getJenisObat());
            statement.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
                    
                }
            }
        }
}
    
}