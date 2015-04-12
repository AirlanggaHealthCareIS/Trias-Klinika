/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.sevice.serviceRekam;
import trias.klinika.api.entitas.PasienEntity;
import trias.klinika.api.entitas.rekammedisEntyty;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Acer
 */
public class queryRekammedis extends UnicastRemoteObject implements serviceRekam {
    public queryRekammedis () throws RemoteException {
        
    }
    
    public PasienEntity getdata(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM pasien WHERE id_pasien = '"+id+"'");

            
           PasienEntity pasienEntity = new PasienEntity();
            result.first();
                pasienEntity.setNama(result.getString("NAMA_PASIEN"));
                pasienEntity.setTanggalLahir(result.getString("TGL_LAHIR_PASIEN"));
                pasienEntity.setNoTLP(result.getString("NO_TELP_PASIEN"));
                pasienEntity.setAlamat(result.getString("ALAMAT_PASIEN"));
                pasienEntity.setGolDarah(result.getString("GOL_DARAH"));

            result.close();
            
            return pasienEntity;
            
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
     public List<rekammedisEntyty> getdatarekam (String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_REKAM_MEDIS, TGL_PEMERIKSAAN FROM pemeriksaan WHERE id_pasien = '"+id+"'");
            
            List<rekammedisEntyty> list = new ArrayList<rekammedisEntyty>();

            while(result.next()){
                rekammedisEntyty rekammedisEntity = new rekammedisEntyty();
                rekammedisEntity.setId_rekam(result.getString("ID_REKAM_MEDIS"));
                rekammedisEntity.setTanggal(result.getString("TGL_PEMERIKSAAN"));
               
                
                list.add(rekammedisEntity);
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
     public rekammedisEntyty getdatadetail(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM rekam_medis WHERE id_rekam_medis = '"+id+"'");
            
            
            rekammedisEntyty rekammedisEntity = new rekammedisEntyty();
            result.first();
                
                rekammedisEntity.setDiagnosa(result.getString("DIAGNOSA"));
                rekammedisEntity.setKeluhan(result.getString("KELUHAN"));
                rekammedisEntity.setTindakan(result.getString("TINDAKAN"));
                rekammedisEntity.setCatatan_lain(result.getString("CATATAN_LAIN"));
                rekammedisEntity.setAlergi(result.getString("ALERGI_OBAT"));
                rekammedisEntity.setTekanan_darah(result.getInt("TEKANAN_DARAH"));
                
                

            result.close();
            
            return rekammedisEntity;
            
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
