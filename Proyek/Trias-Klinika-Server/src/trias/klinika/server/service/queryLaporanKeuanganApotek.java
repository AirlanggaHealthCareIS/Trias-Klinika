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
   public List<LaporanKeuanganApotekEntitas> getobat() throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT id_obat_keluar, jumlah_obat FROM rincian_obat");
            
            List<LaporanKeuanganApotekEntitas> list = new ArrayList<LaporanKeuanganApotekEntitas>();

            while(result.next()){
                LaporanKeuanganApotekEntitas laporanKeuanganApotekEntitas = new LaporanKeuanganApotekEntitas();
                laporanKeuanganApotekEntitas.setID_OBAT_KELUAR(result.getString("id_obat_keluar"));
                laporanKeuanganApotekEntitas.setJUMLAH_OBAT(result.getInt("jumlah_obat"));
                
                
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
   }}
   
