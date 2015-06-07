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
import trias.klinika.api.entitas.PelayananApotekEntitas;
import trias.klinika.api.entitas.PelayananApotekEntitas1;
import trias.klinika.api.sevice.PelayananApotekService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author ISH
 */

    public class QueryPelayananApotek extends UnicastRemoteObject implements PelayananApotekService {
   public QueryPelayananApotek() throws RemoteException {
       
   }
    public List<PelayananApotekEntitas> getDokters() throws RemoteException {
        System.out.println("c");
        System.out.println("proses get ALL Dokter");
        Statement statement = null;
        
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            List<PelayananApotekEntitas> list;
            try (ResultSet result = statement.executeQuery("SELECT rr.ID_RESEP, p.ID_PEMERIKSAAN,d.NAMA_DOKTER, s.NAMA_PASIEN, o.ID_OBAT FROM RINCIAN_RESEP AS rr, PEMERIKSAAN AS p,OBAT AS o, dokter AS d, pasien AS s WHERE p.ID_DOKTER= d.ID_DOKTER AND rr.ID_RESEP= p.ID_RESEP")) {
                list = new ArrayList<>();
                while(result.next()){
                    PelayananApotekEntitas a = new PelayananApotekEntitas();
                    a.setID_RESEP(result.getString("ID_RESEP"));
                    a.setID_PEMERIKSAAN(result.getString("ID_PEMERIKSAAN"));
                    a.setNAMA_DOKTER(result.getString("NAMA_DOKTER"));
                    a.setNAMA_PASIEN(result.getString("NAMA_PASIENR"));
                    a.setID_OBAT(result.getString("ID_OBAT"));
                    list.add(a);
                }
            }
            return list;
        } 
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException  exception) {
                    exception.printStackTrace();
                }
            }
        }}

    @Override
    public PelayananApotekEntitas getpelayananapotek(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT rr.ID_RESEP, p.ID_PEMERIKSAAN,d.NAMA_DOKTER, s.NAMA_PASIEN, o.ID_OBAT FROM RINCIAN_RESEP AS rr, PEMERIKSAAN AS p,OBAT AS o, dokter AS d, pasien AS s WHERE p.ID_DOKTER= d.ID_DOKTER AND ID_RESEP ='"+id+"'");
            
            
            PelayananApotekEntitas PAE = new PelayananApotekEntitas();
            result.first();
                
                PAE.setID_RESEP(result.getString("ID_RESEP"));
               
                
            result.close();
            
            return PAE;
            
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
            }}}
    
     @Override
     public List<PelayananApotekEntitas> getresepbaru(String id) throws RemoteException {
        System.out.println("Client melakukan proses get-all");
        System.out.println("c");
        Statement statement = null;
        
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            List<PelayananApotekEntitas> list;
            
            ResultSet result = statement.executeQuery("SELECT rr.ID_RESEP, d.NAMA_DOKTER, s.NAMA_PASIEN, o.ID_OBAT, o.NAMA_OBAT, o.HARGA_OBAT FROM OBAT AS o, rincian_resep as rr, PASIEN AS s, DOKTER AS d WHERE   o.id_obat = rr.id_obat_keluar AND rr.ID_RESEP='"+id+"'");
            
            list = new ArrayList<>();
            PelayananApotekEntitas a = new PelayananApotekEntitas();
            result.first();
                a.setID_RESEP(result.getString("ID_RESEP"));
                a.setNAMA_DOKTER(result.getString("NAMA_DOKTER"));
               a.setNAMA_PASIEN(result.getString("NAMA_PASIEN"));
                a.setID_OBAT(result.getString("ID_OBAT"));
                a.setNAMA_OBAT(result.getString("NAMA_OBAT"));
                a.setHARGA_OBAT(result.getInt("HARGA_OBAT"));
                 list.add(a);
           
                
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
   
   
   
   
   
   
   
   
   

//    @Override
//    public List<PelayananApotekEntitas> getpelayananapotek() throws RemoteException {
//        System.out.println("Client melakukan proses get-all");
//
//        Statement statement = null;
//        
//
//        try {
//            
//            statement = Koneksidatabase.getConnection().createStatement();
//            
//            ResultSet result = statement.executeQuery("SELECT rr.ID_RESEP, p.ID_PEMERIKSAAN,d.NAMA_DOKTER, s.NAMA_PASIEN, o.ID_OBAT FROM RINCIAN_RESEP AS rr, PEMERIKSAAN AS p,OBAT AS o, dokter AS d, pasien AS s WHERE p.ID_DOKTER= d.ID_DOKTER AND p.ID_PASIEN= s.ID_PASIEN");
//            
//            List<PelayananApotekEntitas> list = new ArrayList<PelayananApotekEntitas>();
//
//            while(result.next()){
//                PelayananApotekEntitas pelayananapotekentitas = new PelayananApotekEntitas();
//                
//                pelayananapotekentitas.setID_RESEP(result.getString("ID_RESEP"));
//                pelayananapotekentitas.setID_PEMERIKSAAN(result.getString("ID_PEMERIKSAAN"));
//                pelayananapotekentitas.setNAMA_DOKTER(result.getString("NAMA_DOKTER"));
//                 pelayananapotekentitas.setNAMA_PASIEN(result.getString("NAMA_PASIEN"));
//                   pelayananapotekentitas.setID_OBAT(result.getString("ID_OBAT"));
//                
//                
//                list.add(pelayananapotekentitas);
//            }
//
//            result.close();
//            
//            return list;
//            
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//            return null;
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
//   }
    
//      @Override
//    public List<PelayananApotekEntitas> getreseplist(String id) throws RemoteException {
//        System.out.println("c");
//        System.out.println("proses get ALL pasien kiri");
//        Statement statement = null;
//        
//        try {
//            statement = Koneksidatabase.getConnection().createStatement();
//            List<PelayananApotekEntitas> list;
//            try (ResultSet result = statement.executeQuery("SELECT o.ID_OBAT, o.NAMA_OBAT, o.HARGA_OBAT, p.ID_RESEP, p.ID_PEMERIKSAAN,d.NAMA_DOKTER, s.NAMA_PASIEN FROM OBAT AS o, PEMERIKSAAN AS p, dokter AS d, pasien AS s WHERE ID_DOKTER= '"+id+"")) {
//                list = new ArrayList<>();
//                while(result.next()){
//                    PelayananApotekEntitas a = new PelayananApotekEntitas();
//                   a.setID_OBAT(result.getString("ID_OBAT"));
//                   a.setNAMA_PASIEN(result.getString("NAMA_PASIEN"));
//                   a.setNAMA_DOKTER(result.getString("NAMA_DOKTER"));
//                    a.setNAMA_OBAT(result.getString("NAMA_OBAT"));
//                    a.setHARGA_OBAT(result.getInt("HARGA_OBAT"));
//                    a.setID_RESEP(result.getString("ID_RESEP"));
//                    a.setID_PEMERIKSAAN(result.getString("ID_PEMERIKSAAN"));
//                    list.add(a);
//                }
//            }
//            return list;
//        } 
//        catch (SQLException exception) {
//            exception.printStackTrace();
//            return null;
//        }
//        finally{
//            if(statement!=null){
//                try {
//                    statement.close();
//                } catch (SQLException  exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }}
//      
//      
//      
//      
     
          
    }