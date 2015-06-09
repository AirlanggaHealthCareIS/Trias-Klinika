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
                    "INSERT INTO pasien(ID_PASIEN, NAMA_PASIEN, TGL_LAHIR_PASIEN, NO_TELP_PASIEN, ALAMAT_PASIEN, GOL_DARAH, NO_KTP_PASIEN, JENIS_KELAMIN, JENIS_PASIEN)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, EP.getID_PASIEN());
            statement.setString(2, EP.getNAMA_PASIEN());
            statement.setString(3, EP.getTGL_LAHIR_PASIEN());
            statement.setString(4, EP.getNO_TELP_PASIEN());
            statement.setString(5, EP.getALAMAT_PASIEN());
            statement.setString(6, EP.getGOL_DARAH());
            statement.setString(7, EP.getN0_KTP());
            statement.setString(8, EP.getJENIS_KELAMIN());
            statement.setString(9, EP.getJENIS_PASIEN());
            
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
                    "INSERT INTO pemeriksaan(ID_PEMERIKSAAN, ID_RESERVASI, ID_PASIEN, ID_DOKTER, TGL_PEMERIKSAAN, NO_ANTRIAN, STATUS_PEMERIKSAAN, ID_REKAM_MEDIS, ID_RESEP, ID_PEMBAYARAN)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, null, null, null)");

            statement.setString(1, PE.getID_PEMERIKSAAAN());
            statement.setString(2, PE.getID_RESERVASI());
            statement.setString(3, PE.getID_PASIEN());
            statement.setString(4, PE.getID_DOKTER());
            statement.setString(5, PE.getTGL_PEMERIKSAAN());
            statement.setInt(6, PE.getNO_ANTRIAN());
            statement.setInt(7, PE.getSTATUS_PASIEN());
            
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
    public int nomor_antrian(int na, String tgl, String id_dokter) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT NO_ANTRIAN FROM PEMERIKSAAN WHERE ID_DOKTER = '"+id_dokter+"' AND TGL_PEMERIKSAAN = '"+tgl+"'");
            System.out.println(id_dokter);
            System.out.println(tgl);
            if(result.last() == false) {
                na = 1;
            }
            else{
                result.last();
                na = result.getInt("NO_ANTRIAN")+1;
                System.out.println(na);
            }
            
            result.close();
            
            return na;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return na;
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
            String b = Integer.toString((Integer.parseInt(aiperiksa.substring(2,6)))+1); //memisahkan angka D dengan 0001
            //menambahkan angka belakang    
            for (int i = b.length(); i < 4; i++ ) {
                b = "0" + b;
            } 
            aiperiksa = aiperiksa.substring(0, 2) + b;
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
            String b = Integer.toString((Integer.parseInt(aipasien.substring(1,5)))+1); //memisahkan angka D dengan 0001
                //menambahkan angka belakang    
            for (int i = b.length(); i < 4; i++ ) {
                 b = "0" + b;
            } 
            aipasien = aipasien.substring(0, 1) + b;
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
    }
    public String cek_ktp(String  no_ktp_pasien) throws RemoteException {
        Statement statement = null;
        String status = null;
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT * FROM PASIEN WHERE NO_KTP_PASIEN = '"+no_ktp_pasien+"'");
          
            if(result.first() == true){
                status = "sudah ada";
            }
            else {
            status = "tidak ada";
            }
            
            result.close();
            System.out.println(status);
            return status;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return status;
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
 public List<EntitasPendaftaran> search_nama(String nama_pasien_kecil) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT * FROM PASIEN WHERE NAMA_PASIEN LIKE '%"+nama_pasien_kecil+"%'AND JENIS_PASIEN = 'Anak'");
            
            List<EntitasPendaftaran> list = new ArrayList<EntitasPendaftaran>();
            
             while(result.next()){
                EntitasPendaftaran EP = new EntitasPendaftaran();
                EP.setDataPasien(result.getString("ID_PASIEN"), result.getString("NAMA_PASIEN"), result.getString("TGL_lAHIR_PASIEN"), result.getString("NO_TELP_PASIEN"), result.getString("ALAMAT_PASIEN"), result.getString("GOL_DARAH"), result.getString("JENIS_PASIEN"),result.getString("JENIS_KELAMIN"), result.getString("NO_KTP_PASIEN"));
                list.add(EP);
            }
            
            result.close();
            return list;
            
            
        }catch (SQLException exception) {
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
    public List<EntitasPendaftaran> getDataPasien() throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
           ("SELECT * from PASIEN where JENIS_PASIEN = 'Anak'");
            
            List<EntitasPendaftaran> list = new ArrayList<EntitasPendaftaran>();
            
            while(result.next()){
                EntitasPendaftaran EP = new EntitasPendaftaran();
                EP.setDataPasien(result.getString("ID_PASIEN"), result.getString("NAMA_PASIEN"), result.getString("TGL_lAHIR_PASIEN"), result.getString("NO_TELP_PASIEN"), result.getString("ALAMAT_PASIEN"), result.getString("GOL_DARAH"), result.getString("JENIS_PASIEN"),result.getString("JENIS_KELAMIN"), result.getString("NO_KTP_PASIEN"));
                list.add(EP);
            }
            
            result.close();
            
            return list;
            
        }catch (SQLException exception) {
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
