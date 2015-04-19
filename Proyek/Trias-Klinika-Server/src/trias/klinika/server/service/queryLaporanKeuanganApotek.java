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
            
            ResultSet result = statement.executeQuery("SELECT r.ID_RESEP, r.ID_APOTEK, r.TOTAL_HARGA,pm.TGL_PEMERIKSAAN FROM RESEP as r, PEMERIKSAAN as pm WHERE r.ID_RESEP= pm.ID_RESEP AND pm.TGL_PEMERIKSAAN = '2015-03-10' ");
            
            List<LaporanKeuanganApotekEntitas> list = new ArrayList<LaporanKeuanganApotekEntitas>();

            while(result.next()){
                LaporanKeuanganApotekEntitas laporanKeuanganApotekEntitas = new LaporanKeuanganApotekEntitas();
                 laporanKeuanganApotekEntitas.setID_RESEP(result.getInt("ID_RESEP"));
                laporanKeuanganApotekEntitas.setID_APOTEK(result.getString("ID_APOTEK"));
                laporanKeuanganApotekEntitas.setTOTAL_HARGA(result.getInt("TOTAL_HARGA"));
                laporanKeuanganApotekEntitas.setTGL_PEMERIKSAAN(result.getString("TGL_PEMERIKSAAN"));
                
                
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

    



   
    
    
   
}