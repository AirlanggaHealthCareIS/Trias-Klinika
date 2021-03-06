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
            ResultSet result = statement.executeQuery("SELECT  do.id_detail, o.id_obat, o.nama_obat, o.deskripsi_obat, o.harga_obat, do.qty_obat, do.tgl_masuk, do.masa_pakai, jo.nama_jenis, s.nama_spesialis FROM obat as o, detail_obat as do, jenis_obat as jo, spesialis as s WHERE do.ruangan = 'Apotek' AND o.id_jenis = jo.id_jenis AND o.id_obat = do.id_obat AND s.id_spesialis = o.id_spesialis");
            List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
            while (result.next()){
                InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
                inventory.setIdObat(result.getString("id_obat"));
                inventory.setNamaObat(result.getString("nama_obat"));
                inventory.setDeskripsi(result.getString("deskripsi_obat"));
                inventory.setHargaObat(result.getInt("harga_obat"));
                inventory.setQty(result.getInt("qty_obat"));
                inventory.setTglMasuk(result.getString("tgl_masuk"));
                inventory.setMasaPakai(result.getString("masa_pakai"));
                inventory.setJenisObat(result.getString("nama_jenis"));
                inventory.setNamaSpesialis(result.getString("nama_spesialis"));
                inventory.setIdDetailObat(result.getInt("id_detail"));
                
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
        System.out.println("Proses Melakukan Penambahan Obat Baru");
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement("INSERT INTO obat ( ID_OBAT, ID_SPESIALIS, NAMA_OBAT, HARGA_OBAT, DESKRIPSI_OBAT, ID_JENIS)"+ "values (?, ?, ?, ?, ?, ?)");
            
            statement.setString(1, inventory.getIdObat());
            statement.setString(2, inventory.getIdSpesialis());
            statement.setString(3, inventory.getNamaObat());
            statement.setInt(4, inventory.getHargaObat());
            statement.setString(5, inventory.getDeskripsi());
            statement.setString(6, inventory.getIdJenisObat());
            System.out.println(statement.toString());
            
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
            statement2 = Koneksidatabase.getConnection().prepareStatement("INSERT INTO detail_obat (ID_DETAIL, ID_OBAT, QTY_OBAT, TGL_MASUK, MASA_PAKAI, RUANGAN)"+ "values (?, ?, ?, ?, ?, ?)");
            statement2.setInt(1, inventory.getIdDetailObat());
            statement2.setString(2, inventory.getIdObat());
            statement2.setInt(3, inventory.getQty());
            statement2.setString(4, inventory.getTglMasuk());
            statement2.setString(5, inventory.getMasaPakai());
            statement2.setString(6, inventory.getRuangObat());
            
            
            statement2.executeUpdate();
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

    @Override
    public void updateObat(InventoryObatApotekEntitas inventory) throws RemoteException {
        System.out.println("Proses Melakukan Update Data Obat");
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement("UPDATE obat SET harga_obat ="+inventory.getHargaObat()+",deskripsi_obat = '"+inventory.getDeskripsi()+"' WHERE id_obat ='"+inventory.getIdObat()+"'");
            
            System.out.println(statement.toString());
            statement.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObat(InventoryObatApotekEntitas inventory) throws RemoteException {
        System.out.println("Proses Melakukan Penghapusan data Obat");
        PreparedStatement statement = null;
        try{
            statement = Koneksidatabase.getConnection().prepareStatement("DELETE FROM detail_obat WHERE id_detail =? AND id_obat =?");
            statement.setInt(1,inventory.getIdDetailObat());
            statement.setString(2,inventory.getIdObat());
            statement.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        finally{
            if(statement != null){
                try {
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
    public void tambahObat(InventoryObatApotekEntitas inventory) throws RemoteException {
        PreparedStatement statement2 = null;
        try{
            statement2 = Koneksidatabase.getConnection().prepareStatement("INSERT INTO detail_obat (ID_DETAIL, ID_OBAT, QTY_OBAT, TGL_MASUK, MASA_PAKAI, RUANGAN)"+ "values (?, ?, ?, ?, ?, ?)");
            statement2.setInt(1, inventory.getIdDetailObat());
            statement2.setString(2, inventory.getIdObat());
            statement2.setInt(3, inventory.getQty());
            statement2.setString(4, inventory.getTglMasuk());
            statement2.setString(5, inventory.getMasaPakai());
            statement2.setString(6, inventory.getRuangObat());
            System.out.println(statement2.toString());
            statement2.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        finally {
            if(statement2 != null){
                try{
                    statement2.close();
                }
                catch (SQLException exception){
                    
                }
            }
        }
                //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] DropdownJenis(String[] jenis) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select * from jenis_obat");
            result.last();
            jenis = new String [result.getRow()];
            result.first();
            
            for (int i=0;i<jenis.length;i++){
                jenis [i] = result.getString("id_jenis")+"-"+result.getString("nama_jenis");
                result.next();
            }
            result.close();
            return jenis;
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
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] DropdownSpesialis(String[] spesialis) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select * from spesialis");
            result.last();
            spesialis = new String [result.getRow()];
            result.first();
            
            for (int i=0;i<spesialis.length;i++){
                spesialis [i] = result.getString("id_spesialis")+"-"+result.getString("nama_spesialis");
                result.next();
            }
            result.close();
            return spesialis;
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
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InventoryObatApotekEntitas> cekKritis() throws RemoteException {
                System.out.println("Client melakukan proses get-all untuk cek kritis");
        Statement statement = null;
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT  o.nama_obat, o.deskripsi_obat, o.harga_obat, do.qty_obat, do.tgl_masuk, do.masa_pakai, jo.nama_jenis, s.nama_spesialis FROM obat as o, detail_obat as do, jenis_obat as jo, spesialis as s WHERE do.ruangan = 'Apotek' AND o.id_jenis = jo.id_jenis AND o.id_obat = do.id_obat AND s.id_spesialis = o.id_spesialis ORDER BY do.masa_pakai");
            List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
            while (result.next()){
                InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
                inventory.setNamaObat(result.getString("nama_obat"));
                inventory.setDeskripsi(result.getString("deskripsi_obat"));
                inventory.setHargaObat(result.getInt("harga_obat"));
                inventory.setQty(result.getInt("qty_obat"));
                inventory.setTglMasuk(result.getString("tgl_masuk"));
                inventory.setMasaPakai(result.getString("masa_pakai"));
                inventory.setJenisObat(result.getString("nama_jenis"));
                inventory.setNamaSpesialis(result.getString("nama_spesialis"));
            
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
    public List<InventoryObatApotekEntitas> cekExpired() throws RemoteException {
        System.out.println("Client melakukan proses get-all untuk cek mendekati expired");
        Statement statement = null;
        try{
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT  o.nama_obat, o.deskripsi_obat, o.harga_obat, do.qty_obat, do.tgl_masuk, do.masa_pakai, jo.nama_jenis, s.nama_spesialis FROM obat as o, detail_obat as do, jenis_obat as jo, spesialis as s WHERE do.ruangan = 'Apotek' AND o.id_jenis = jo.id_jenis AND o.id_obat = do.id_obat AND s.id_spesialis = o.id_spesialis ORDER BY do.masa_pakai");
            List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
            while (result.next()){
                InventoryObatApotekEntitas inventory = new InventoryObatApotekEntitas();
                inventory.setNamaObat(result.getString("nama_obat"));
                inventory.setDeskripsi(result.getString("deskripsi_obat"));
                inventory.setHargaObat(result.getInt("harga_obat"));
                inventory.setQty(result.getInt("qty_obat"));
                inventory.setTglMasuk(result.getString("tgl_masuk"));
                inventory.setMasaPakai(result.getString("masa_pakai"));
                inventory.setJenisObat(result.getString("nama_jenis"));
                inventory.setNamaSpesialis(result.getString("nama_spesialis"));
                
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
    public String auto_increment_idobat(String aiObat) throws RemoteException {
           Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT * FROM OBAT");
            
            if (result.last()== false){
                aiObat = "O0001";
            }
            else {
                result.last();
                aiObat = result.getString("ID_OBAT");
                String b = Integer.toString((Integer.parseInt(aiObat.substring(1,5)))+1); //memisahkan angka D dengan 0001
            //menambahkan angka belakang    
                for (int i = b.length(); i < 4; i++ ) {
                    b = "0" + b;
                } 
                aiObat = aiObat.substring(0, 1) + b;
            result.close();
            }
            return aiObat;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return aiObat;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
               
    } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int auto_increment_iddetail(String aiObat) throws RemoteException {
        Statement statement = null;
        int a = 0;
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_DETAIL FROM DETAIL_OBAT WHERE ID_OBAT = '"+aiObat+"'");
            
            if(result.last()== false){
                a = 1;
            }
            else {
                result.last();
             a = result.getInt("ID_DETAIL");
            a++;
            
            result.close();
            
            }
            return a;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
               
    } //To change bo //To change body of generated methods, choose Tools | Templates.
    }
    
}