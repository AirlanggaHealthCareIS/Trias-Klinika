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
import trias.klinika.api.entitas.LaporanKeuanganApotekEntitas;
import trias.klinika.api.sevice.LaporanKeuanganService;
import trias.klinika.server.utilitas.Koneksidatabase;

public class queryLaporanKeuanganApotek extends UnicastRemoteObject implements LaporanKeuanganService {
   public queryLaporanKeuanganApotek() throws RemoteException {
       
   }


    @Override
    public List<LaporanKeuanganApotekEntitas> getlkeuangan() throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT r.TOTAL_HARGA, p.TGL_PEMERIKSAAN FROM resep AS r, pemeriksaan AS p WHERE r.ID_RESEP = p.ID_RESEP");
            
            List<LaporanKeuanganApotekEntitas> list = new ArrayList<LaporanKeuanganApotekEntitas>();

            while(result.next()){
                LaporanKeuanganApotekEntitas laporanKeuanganApotekEntitas = new LaporanKeuanganApotekEntitas();
                laporanKeuanganApotekEntitas.setTGL_PEMERIKSAAN(result.getString("TGL_PEMERIKSAAN"));
                laporanKeuanganApotekEntitas.setID_RESEP(result.getInt("ID_RESEP"));
                laporanKeuanganApotekEntitas.setTOTAL_HARGA(result.getInt("TOTAL_HARGA"));
                
                
                
                list.add(laporanKeuanganApotekEntitas);
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
    public String[] Tahun(String[] ob) throws RemoteException {
         Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT `TGL_PEMERIKSAAN`FROM `pemeriksaan`");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("TGL_PEMERIKSAAN").substring(0, 4);
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

    @Override
    public String[] Bulan(String[] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT `TGL_PEMERIKSAAN`FROM `pemeriksaan`");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("TGL_PEMERIKSAAN").substring(5, 7);
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

    @Override
    public String[] Tanggal(String[] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT `TGL_PEMERIKSAAN`FROM `pemeriksaan`");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("TGL_PEMERIKSAAN").substring(8, 10);
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



   
    
    
   
