
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
    public PasienEntity insertIDPasien(PasienEntity a) throws RemoteException {
        System.out.println("proses insert Pasien");
        PreparedStatement statement = null;
        try{
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO pemeriksaan(ID_PEMERIKSAAN, ID_REKAM_MEDIS, ID_RESERVASI, ID_PASIEN, ID_DOKTER	ID_RESEP, ID_PEMBAYARAN, TGL_PEMERIKSAAN, NO_ANTREAN) values(null,null,null,?,null,null,null,null,null)");
            statement.setString(1, a.getid_pasien());

            
            statement.execute();
            return a;
        }
        catch(SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public int getIDPasien() throws RemoteException{
        System.out.println("melakukan proses get ID_PASIEN");
        
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "SELECT ID_PASIEN FROM PASIEN");
//            statement.setString(1,a);
            ResultSet result = statement.executeQuery();
            
            int a=0;
            
            if(result.next()){
                a = (result.getInt("ID_PASIEN"));
            }
            return a;
            
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
        finally{
            if(statement != null){
                try{
                    statement.close();
                }
                catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            
        }
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
                    System.out.println(a.getid_pasien());
                    a.setNama(result.getString("NAMA_PASIEN"));
                    System.out.println("a.3");
                    a.SetTanggal(result.getString("TGL_LAHIR_PASIEN"));
                    System.out.println("a.4");
                    a.setNoTLP(result.getString("NO_TELP_PASIEN"));
                    System.out.println("a.5");
                    a.setAlamat(result.getString("ALAMAT_PASIEN"));
                    System.out.println("a.6");
                    a.setGolDarah(result.getString("GOL_DARAH"));
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
