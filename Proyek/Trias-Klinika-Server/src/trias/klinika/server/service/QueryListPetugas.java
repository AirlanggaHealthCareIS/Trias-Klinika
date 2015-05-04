/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Faz
 */
public class QueryListPetugas extends UnicastRemoteObject implements ListPetugasService {
    
    public QueryListPetugas() throws RemoteException {
    }
    
    @Override
    public void Ubah_Status_Login (LoginEntitas login) throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "UPDATE "+login.getsebagai()+" SET "+login.getfieldstatus()+" = 1 WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryListPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Ubah_Status_Logout (LoginEntitas login) throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "UPDATE "+login.getsebagai()+" SET "+login.getfieldstatus()+" = 0 WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryListPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Dokter> AmbilDokterOnline() throws RemoteException {
        Statement statement = null;
        
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            List<Dokter> list;
            ResultSet result = statement.executeQuery("SELECT * FROM DOKTER WHERE STATUS_DOKTER = 1");
                list = new ArrayList<>();
                while(result.next()){
                    Dokter a = new Dokter();
                    a.setid_dokter(result.getString("ID_DOKTER"));
                    a.setid_spesialis(result.getString("ID_SPESIALIS"));
                    a.setpassword_dokter(result.getString("PASSWORD_DOKTER"));
                    a.setstatus_dokter(Integer.parseInt(result.getString("STATUS_DOKTER")));
                    a.setnama_dokter(result.getString("NAMA_DOKTER"));
                    a.setno_telp_dokter(result.getString("NO_TELP_DOKTER"));
                    a.setalamat_dokter(result.getString("ALAMAT_DOKTER"));
                    list.add(a);
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
        }
        
    }
    
    @Override
    public Dokter AmbilData(String Id) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            Dokter dok = new Dokter();
            ResultSet result = statement.executeQuery("SELECT * FROM DOKTER WHERE ID_DOKTER = '"+Id+"'");
            result.first();
            dok.setid_dokter(result.getString("ID_DOKTER"));
            dok.setid_spesialis(result.getString("ID_SPESIALIS"));
            dok.setpassword_dokter(result.getString("PASSWORD_DOKTER"));
            dok.setstatus_dokter(Integer.parseInt(result.getString("STATUS_DOKTER")));
            dok.setnama_dokter(result.getString("NAMA_DOKTER"));
            dok.setno_telp_dokter(result.getString("NO_TELP_DOKTER"));
            dok.setalamat_dokter(result.getString("ALAMAT_DOKTER"));
            return dok;
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
        }
        
    }
}
