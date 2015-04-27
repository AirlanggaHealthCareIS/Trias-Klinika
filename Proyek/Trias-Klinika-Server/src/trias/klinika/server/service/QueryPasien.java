
package trias.klinika.server.service;
//import com.sun.javafx.sg.prism.NGCanvas
import trias.klinika.api.entitas.PasienEntity;
import trias.klinika.api.sevice.PasienService;
import trias.klinika.server.utilitas.Koneksidatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QueryPasien extends UnicastRemoteObject implements PasienService{
    public QueryPasien() throws RemoteException {
    }


    @Override
    public List<PasienEntity> getPasienEntitys() throws RemoteException {
        System.out.println("c");
        System.out.println("proses get ALL Pasien");
        Statement statement = null;
        
        try {
            System.out.println("b");
            statement = Koneksidatabase.getConnection().createStatement();
            System.out.println("b.1");
            List<PasienEntity> list;
            try (ResultSet result = statement.executeQuery("SELECT * FROM PASIEN")) {
                System.out.println("b.2");
                list = new ArrayList<>();
                System.out.println("b.3");
                while(result.next()){
                    System.out.println("a");
                    PasienEntity a = new PasienEntity();
                    System.out.println("a.1");
                    a.setid_pasien(result.getString("ID_PASIEN"));
                    System.out.println("a.2");
                    a.setid_pasien(result.getString("NAMA_PASIEN"));
                    System.out.println("a.3");
                    a.setid_pasien(result.getString("TGL_LAHIR_PASIEN"));
                    System.out.println("a.4");
                    a.setid_pasien(result.getString("NO_TELP_PASIEN"));
                    System.out.println("a.5");
                    a.setid_pasien(result.getString("ALAMAT_PASIEN"));
                    System.out.println("a.6");
                    a.setid_pasien(result.getString("GOL_DARAH"));
                    System.out.println("a.7");
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
        }
        
    }

    
    @Override
    public String[] Dropdownpasien(String [] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_PASIEN FROM PASIEN");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("ID_PASIEN");
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
    public PasienEntity getPasienEntity(int IdDokter) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PasienEntity getLastPasienEntity() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PasienEntity> getPasienEntitysUrut() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDokterID(String nama_bahan) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PasienEntity insertPasien(PasienEntity a) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updatePasien(PasienEntity b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletePasien(int IdDokter) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PasienEntity> getPasiensUrut(String id_suplier) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
