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
    public List<LaporanPasienEntitas> gettglpemeriksaan(String tglpemeriksaan) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
           ("SELECT * FROM `pemeriksaan` WHERE `TGL_PEMERIKSAAN` ");
            
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
}
