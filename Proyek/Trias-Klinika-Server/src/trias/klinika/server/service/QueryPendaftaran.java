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
import java.util.Date;
import java.util.List;
import trias.klinika.api.entitas.EntitasPendaftaran;
import trias.klinika.api.entitas.PemeriksaanEntitas;
import trias.klinika.api.sevice.PendaftaranService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author Satria
 */
public class QueryPendaftaran extends UnicastRemoteObject implements PendaftaranService{
    EntitasPendaftaran EP = new EntitasPendaftaran();
    public QueryPendaftaran() throws RemoteException {
    }
    
    public void Save(EntitasPendaftaran EP, PemeriksaanEntitas PE) throws RemoteException {
        System.out.println("Reservasi melakukan proses insert");
        
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO pasien(ID_PASIEN, NAMA_PASIEN, TGL_LAHIR_PASIEN, NO_TELP_PASIEN, ALAMAT_PASIEN, GOL_DARAH)"
                    + "VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, EP.getID_PASIEN());
            statement.setString(2, EP.getNAMA_PASIEN());
            statement.setString(3, EP.getTGL_LAHIR_PASIEN());
            statement.setString(4, EP.getNO_TELP_PASIEN());
            statement.setString(5, EP.getALAMAT_PASIEN());
            statement.setString(6, EP.getGOL_DARAH());
            
            System.out.println(statement.toString());
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
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO pemeriksaan(ID_PEMERIKSAAN, ID_REKAM_MEDIS, ID_RESERVASI, ID_PASIEN, ID_DOKTER, ID_RESEP, ID_PEMBAYARAN, TGL_PEMERIKSAAN, NO_ANTRIAN)"
                    + "VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, PE.getID_PEMERIKSAAAN());
            statement.setString(2, PE.getID_REKAM_MEDIS());
            statement.setString(3, PE.getID_RESERVASI());
            statement.setString(4, PE.getID_PASIEN());
            statement.setString(5, PE.getID_DOKTER());
            statement.setString(6, PE.getID_RESEP());
            statement.setString(7, PE.getID_PEMBAYARAN());
            statement.setString(8, PE.getTGL_PEMERIKSAAN());
            statement.setInt(9, PE.getNO_ANTREAN());
            
            System.out.println(statement.toString());
            statement.executeUpdate();

            
        }catch (SQLException exception) {
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
    
    }   
    public String auto_increment_pemeriksaan(String  aiperiksa) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_PEMERIKSAAN FROM PEMERIKSAAN");
            
            
            result.last();
            aiperiksa = result.getString("ID_PEMERIKSAAN");
            int a = Integer.parseInt(aiperiksa.substring(5));
            a++;
            aiperiksa = aiperiksa.substring(0, 5)+ a ;
            result.close();
            
            return aiperiksa;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return aiperiksa;
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
    public String auto_increment_pasien(String  aipasien) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_PASIEN FROM PASIEN");
            
            
            result.last();
            aipasien = result.getString("ID_PASIEN");
            int a = Integer.parseInt(aipasien.substring(4));
            a++;
            aipasien = aipasien.substring(0, 6)+ a ;
            
            result.close();
            return aipasien;
            
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return aipasien;
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
