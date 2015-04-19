package trias.klinika.server.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import trias.klinika.api.sevice.ServiceResep;
import trias.klinika.server.utilitas.Koneksidatabase;
import trias.klinika.api.entitas.ResepEntity;
import trias.klinika.api.entitas.RincianResep;
import trias.klinika.api.sevice.ServiceResep;
/**
 *
 * @author User
 */
public class QueryResep extends UnicastRemoteObject implements ServiceResep{
    
    public QueryResep() throws RemoteException {
        
    }
    
    
    public String[] obat(String [] pk) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_OBAT, NAMA_OBAT FROM OBAT WHERE ID_SPESIALIS = 'S0001'");
            
            result.last();
            pk = new String [result.getRow()];
            result.first();

            for (int i=0;i<pk.length;i++){
                pk [i] = result.getString("ID_OBAT")+" - "+result.getString("NAMA_OBAT");
                result.next();
            }

            result.close();
            
            return pk;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return pk;
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
    
    public void save (ResepEntity RE) throws RemoteException, SQLException {
        Statement statement = null;
        
        statement = Koneksidatabase.getConnection().createStatement();
        ResultSet result = statement.executeQuery
                    ("INSERT INTO `resep`(`ID_RESEP`, `ID_APOTEK`, `TOTAL_HARGA`, `STATUS_RESEP`) VALUES (["+RE.getID_resep()+"],["+RE.getID_apotek()+"],["+RE.getharga()+"],["+RE.getSTATUS_RESEP()+"]) ");
    }
    
    public void save (ResepEntity RE, String ID) throws RemoteException, SQLException {
        Statement statement = null;
        
        statement = Koneksidatabase.getConnection().createStatement();
        ResultSet result = statement.executeQuery
                            ("INSERT INTO `rincian_resep`(`ID_RINCIAN_OBAT`, `ID_RESEP`, `ID_OBAT_KELUAR`, `JUMLAH_OBAT`, `DOSIS_OBAT`) VALUES (["+RE.getID_obat()+"],["+RE.getID_resep()+"],["+RE.getID_obat()+"],["+RE.getjumlah()+"],["+RE.getjumlah_terpenuhi()+"]) ");
        }

    @Override
    public void Save(ResepEntity RE) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(RincianResep RR, ResepEntity RE, int i) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public RincianResep getdetail  (RincianResep RR) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT o.HARGA_OBAT FROM OBAT as o WHERE ID_OBAT = '"+RR.getID_OBAT()+"'");
            
            
            
           result.first();
           RR.setHARGA_OBAT(result.getInt("HARGA_OBAT"));
          
        }catch (SQLException exception) {
            exception.printStackTrace();
           
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
    }
        return RR;
        
    }
}
