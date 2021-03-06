package trias.klinika.server.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.regexp.internal.RE;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.server.utilitas.Koneksidatabase;
import trias.klinika.api.entitas.ResepEntity;
import trias.klinika.api.entitas.RincianResep;
import trias.klinika.api.sevice.ServiceResep;

/**
 *
 * @author User
 */
public class QueryResep extends UnicastRemoteObject implements ServiceResep {

    public QueryResep() throws RemoteException {

    }

    public String[] obat(String[] pk) throws RemoteException {
        Statement statement = null;

        try {

            statement = Koneksidatabase.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT ID_OBAT, NAMA_OBAT FROM OBAT WHERE ID_SPESIALIS = 'S0001'");

            result.last();
            pk = new String[result.getRow()];
            result.first();

            for (int i = 0; i < pk.length; i++) {
                pk[i] = result.getString("ID_OBAT") + " - " + result.getString("NAMA_OBAT");
                System.out.println(pk[i]+"ini id");
                result.next();
            }

            result.close();

            return pk;

        } catch (SQLException exception) {
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
    
     public String pasien(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_PASIEN FROM pemeriksaan WHERE ID_PEMERIKSAAN = '"+id+"'");
            
            
            ResepEntity ResepEntity = new ResepEntity();
            result.first();
                
                String idp = result.getString("ID_PASIEN");
                
            result.close();
            
            return idp;
            
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
    public ResepEntity getdetail(ResepEntity RE) throws RemoteException {
        Statement statement = null;

        try {

            statement = Koneksidatabase.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT o.HARGA_OBAT FROM OBAT as o WHERE ID_OBAT = '" + RE.getID_obat() + "'");

            result.first();
            RE.setharga(result.getInt("HARGA_OBAT"));

        } catch (SQLException exception) {
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
        return RE;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Save(ResepEntity RE) throws RemoteException{
        PreparedStatement statement = null;

        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
            "INSERT INTO `resep`(`ID_RESEP`, `TOTAL_HARGA`, `STATUS_RESEP`) VALUES ('" + RE.getID_resep() + "','0','" + RE.getSTATUS_RESEP() + "') ");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryResep.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(statement.toString());
                    //statement.executeUpdate(re)
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(RincianResep RR) throws RemoteException{
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement("INSERT INTO `rincian_resep`(`ID_RINCIAN_OBAT`, `ID_RESEP`, `ID_OBAT_KELUAR`, `JUMLAH_OBAT`, `DOSIS_OBAT`) VALUES ('" + RR.getID_RINCIAN_OBAT() + "','" + RR.getID_RESEP()+ "','" + RR.getID_OBAT() + "','" + RR.getJUMLAH_OBAT() + "','" + RR.getDOSIS_OBAT() + "') ");

            statement.executeUpdate();

        } catch (Exception e) {
        }

        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RincianResep getdetail(RincianResep RR) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String auto_increment_NoResep(String  airesep) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT * FROM RESEP");
            
            
            result.last();
            airesep = result.getString("ID_RESEP");
            String b = Integer.toString((Integer.parseInt(airesep.substring(2,6)))+1); //memisahkan angka D dengan 0001
                //menambahkan angka belakang    
            for (int i = b.length(); i < 4; i++ ) {
                b = "0" + b;
            } 
            airesep = airesep.substring(0, 2) + b;
            result.close();
            
            return airesep;
            
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return airesep;
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
    public ResepEntity ID_Pasien(ResepEntity RE) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Update (String id_pemeriksaan , String id_resep ) throws RemoteException {
        PreparedStatement statement = null;
        
        try{
        statement = (PreparedStatement)Koneksidatabase.getConnection().prepareStatement("UPDATE pemeriksaan SET ID_RESEP = '"+id_resep+"' WHERE ID_PEMERIKSAAN = '"+id_pemeriksaan+"'");
        statement.executeUpdate();        
    } catch (SQLException ex) {
        Logger.getLogger(QueryResep.class.getName()).log(Level.SEVERE, null, ex);
    }

}}
