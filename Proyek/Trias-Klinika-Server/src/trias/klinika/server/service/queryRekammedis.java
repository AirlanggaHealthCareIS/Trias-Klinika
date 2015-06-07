/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public String getIdPasien (String id) throws RemoteException {
         System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_PASIEN FROM pemeriksaan WHERE ID_PEMERIKSAAN = '"+id+"'");

            result.first();
            String pasien = result.getString("ID_PASIEN");
            return pasien;
            
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
     public List<rekammedisEntyty> getdatarekam (String id, String id_pemeriksaan) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_REKAM_MEDIS, TGL_PEMERIKSAAN FROM pemeriksaan WHERE id_pasien = '"+id+"' AND ID_REKAM_MEDIS != '"+id_pemeriksaan+"'");
            
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
                rekammedisEntity.setAlergi(result.getString("ALERGI_OBAT"));
                rekammedisEntity.setTindakan(result.getString("TINDAKAN"));
                rekammedisEntity.setTekanan_darah(result.getInt("TEKANAN_DARAH"));
                rekammedisEntity.setCatatan_lain(result.getString("CATATAN_LAIN"));
                
                
                
                

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

    @Override
    public void ok(rekammedisEntyty rekammedisEntyty) throws RemoteException {
       System.out.println("Reservasi melakukan proses insert");
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO rekam_medis (ID_REKAM_MEDIS, DIAGNOSA, KELUHAN, TINDAKAN, CATATAN_LAIN, ALERGI_OBAT, TEKANAN_DARAH)"
                    + "values (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, rekammedisEntyty.getId_rekam());
            statement.setString(2, rekammedisEntyty.getDiagnosa());
            statement.setString(3, rekammedisEntyty.getKeluhan());
            statement.setString(4, rekammedisEntyty.getTindakan());
            statement.setString(5, rekammedisEntyty.getCatatan_lain());
            statement.setString(6, rekammedisEntyty.getAlergi());
            statement.setInt(7, rekammedisEntyty.getTekanan_darah());
            
            System.out.println(statement.toString());
            statement.executeUpdate();
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(queryRekammedis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }

    public String ai_rekammedis (String  airekam) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_REKAM_MEDIS FROM rekam_medis");
            
            
            result.last();
            airekam = result.getString("ID_REKAM_MEDIS");
            String b = Integer.toString((Integer.parseInt(airekam.substring(2,6)))+1); //memisahkan angka RM dengan 0001
            //menambahkan angka belakang    
            for (int i = b.length(); i < 4; i++ ) {
             b = "0" + b;
        } 
        airekam = airekam.substring(0, 2) + b;
            result.close();
            
            return airekam;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return airekam;
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
    public void Update (String id_pemeriksaan , String id_rekam_medis)throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) Koneksidatabase.getConnection().prepareStatement(
                    "UPDATE `pemeriksaan` SET `ID_REKAM_MEDIS` = '"+id_rekam_medis+"' WHERE `ID_PEMERIKSAAN` = '"+id_pemeriksaan+"'");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryRekammedis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
