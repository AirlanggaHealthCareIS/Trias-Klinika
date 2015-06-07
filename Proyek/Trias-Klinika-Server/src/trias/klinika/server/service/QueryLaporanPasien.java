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
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import trias.klinika.api.entitas.LaporanPasienEntitas;
import trias.klinika.api.sevice.LaporanPasienService;
import trias.klinika.server.utilitas.Koneksidatabase;
/**
 *
 * @author iqbal
 */

public class QueryLaporanPasien extends UnicastRemoteObject implements LaporanPasienService {
    public QueryLaporanPasien ()throws RemoteException{
    }
    @Override
    public List<LaporanPasienEntitas> tglpemeriksaan(String tgl_awal, String tgl_akhir) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
           ("SELECT * FROM pemeriksaan WHERE TGL_PEMERIKSAAN >='"+tgl_awal+"' AND TGL_PEMERIKSAAN <='"+tgl_akhir+"'");
            
            List<LaporanPasienEntitas> list = new ArrayList<LaporanPasienEntitas>();
            
            while(result.next()){
                LaporanPasienEntitas LPE = new LaporanPasienEntitas();
                LPE.settglpemeriksaan(result.getString("TGL_PEMERIKSAAN"));
                
                list.add(LPE);
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
    
    @Override
    public String[] DropdownSpesialis(String[] spesialis) throws RemoteException {
        Statement statement = null;
        try {
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select * from spesialis");
            result.last();
            spesialis = new String [result.getRow()];
            result.first();
            
            for (int i=0;i<spesialis.length;i++){
                spesialis [i] = result.getString("id_spesialis")+"-"+result.getString("nama_spesialis");
                result.next();
            }
            result.close();
            return spesialis;
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    
}
