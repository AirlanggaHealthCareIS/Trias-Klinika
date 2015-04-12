package trias.klinika.server.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.entitas.EntitasPendaftaran;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author Satria
 */
public class QueryPendaftaran extends UnicastRemoteObject implements PendaftaranService{
    
    public QueryPendaftaran() throws RemoteException {
    }
    
    public void Save(EntitasPendaftaran EP) throws RemoteException {
        System.out.println("Reservasi melakukan proses insert");

        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO Pasien (ID_PASIEN, NAMA_PASIEN, TGL_LAHIR_PASIEN, NO_TELP_PASIEN, ALAMAT_PASIEN, GOL_DARAH)"
                    + "values (?, ?, ?, ?, ?, ?)");

            statement.setString(1, EP.getID_PASIEN());
            statement.setString(2, EP.getNAMA_PASIEN());
            statement.setString(3, EP.getTGL_LAHIR_PASIEN());
            statement.setString(4, EP.getNO_TELP_PASIEN());
            statement.setString(5, EP.getALAMAT_PASIEN());
            statement.setString(7, EP.getGOL_DARAH());
            

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
    public String[] pilih_dokter(String [] pd) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_DOKTER, NAMA_DOKTER FROM DOKTER");
            
            result.last();
            pd = new String [result.getRow()];
            result.first();

            for (int i=0;i<pd.length;i++){
                pd [i] = result.getString("ID_DOKTER")+" - "+result.getString("NAMA_DOKTER");
                result.next();
            }

            result.close();
            
            return pd;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return pd;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
               
    }
  
    }}
