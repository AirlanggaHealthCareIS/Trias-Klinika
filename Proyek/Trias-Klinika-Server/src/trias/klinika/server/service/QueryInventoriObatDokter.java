package trias.klinika.server.service;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;
import trias.klinika.api.sevice.InventoriObatDokterService;
import trias.klinika.server.utilitas.Koneksidatabase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iqbal
 */
public class QueryInventoriObatDokter extends UnicastRemoteObject implements InventoriObatDokterService {
    public QueryInventoriObatDokter() throws RemoteException {
        
    }
    
   @Override
   public List<InventoriObatDokterEntitas> getobat() throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT o.id_obat, o.nama_obat, o.deskripsi_obat, o.harga_obat, do.kuantitas_obat, do.tgl_masuk_obat, do.masa_pakai_obat, jo.nama_jenis_obat FROM obat as o, detail_obat as do, jenis_obat as jo, dibagi as d where o.id_obat = do.id_obat and o.id_obat = d.id_obat");
            
            List<InventoriObatDokterEntitas> list = new ArrayList<InventoriObatDokterEntitas>();

            while(result.next()){
                InventoriObatDokterEntitas inventoriObatDokterEntitas = new InventoriObatDokterEntitas();
                inventoriObatDokterEntitas.setnamaobat(result.getString("nama_obat"));
                inventoriObatDokterEntitas.setjenisobat(result.getString("nama_jenis_obat"));
                inventoriObatDokterEntitas.setkuantitiobat(result.getInt("kuantitas_obat"));
                inventoriObatDokterEntitas.sethargaobat(result.getInt("harga_obat"));
                inventoriObatDokterEntitas.settglmasuk(result.getString("tgl_masuk_obat"));
                inventoriObatDokterEntitas.setmasapakai(result.getString("masa_pakai_obat"));
                inventoriObatDokterEntitas.setdeskripsi(result.getString("deskripsi_obat"));;
                inventoriObatDokterEntitas.setidobat(result.getString("id_obat"));
                
                list.add(inventoriObatDokterEntitas);
            }

            result.close();
            
            return list;
            
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
   
   @Override
    public void insertObatBaru(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException {
        System.out.println("Dokter melakukan proses insert");

        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO obat (id_obat, id_spesialis, nama_obat, harga_obat, deskripsi_obat)"
                    + "values (?, ?, ?, ?, ?)");

            statement.setString(1, inventoriobatDokterEntitas.idobat());
            statement.setString(2, inventoriobatDokterEntitas.idspesialis());
            statement.setString(3, inventoriobatDokterEntitas.getnamaobat());
            statement.setInt(4, inventoriobatDokterEntitas.gethargaobat());
            statement.setString(5, inventoriobatDokterEntitas.deskripsi());
            

            statement.executeUpdate();

            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
        PreparedStatement statement1 = null;
        try {
            statement1 = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO detail_obat (id_detail_obat, id_obat, kuantitas_obat, tgl_masuk_obat, masa_pakai_obat, ruangan_obat)"
                    + "values (?, ?, ?, ?, ?, ?)");

            statement1.setString(1, inventoriobatDokterEntitas.iddetailobat());
            statement1.setString(2, inventoriobatDokterEntitas.idobat());
            statement1.setInt(3, inventoriobatDokterEntitas.getkuantitiobat());
            statement1.setString(4, inventoriobatDokterEntitas.gettglmasuk());
            statement1.setString(5, inventoriobatDokterEntitas.getmasapakai());
            statement1.setString(6, inventoriobatDokterEntitas.ruanganobat());

            statement.executeUpdate();

            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
        PreparedStatement statement2 = null;
        try {
            statement2 = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO jenis_obat (id_jenis_obat, nama_jenis_obat)"
                    + "values (?, ?)");

            statement2.setString(1, inventoriobatDokterEntitas.idjenisobat());
            statement2.setString(2, inventoriobatDokterEntitas.getjenisobat());
            

            statement.executeUpdate();

            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
    }
   
   @Override
    public String[] Dropdownobat(String [] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT o.id_obat, o.nama_obat FROM obat as o , detail_obat as do where do.id_obat  = o.id_obat and do.ruangan_obat = 'Ruang 2' ORDER BY id_obat");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("id_obat")+" - "+result.getString("nama_obat");
                result.next();
            }

            result.close();
            
            return ob;
            
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
    
}
