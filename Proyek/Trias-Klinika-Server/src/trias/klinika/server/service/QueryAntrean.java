
package trias.klinika.server.service;
//import com.sun.javafx.sg.prism.NGCanvas
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.sevice.DokterService;
import trias.klinika.server.utilitas.Koneksidatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QueryAntrean extends UnicastRemoteObject implements DokterService{
    public QueryAntrean() throws RemoteException {
    }

//    @Override
//    public Dokter insertDokter(Dokter a) throws RemoteException {
//        System.out.println("proses insert Dokter");
//        PreparedStatement statement = null;
//        try{
//            statement = Koneksidatabase.getConnection().prepareStatement(
//                    "INSERT INTO bahan(ID_BAHAN,ID_SATUAN,ID_SUPLIER, NAMA_BAHAN, BATAS_KRITIS) values(null,?,?,?,?)");
//            statement.setString(1, a.getId_Satuan());
//            statement.setString(2, a.getId_Supplier());
//            statement.setString(3, a.getNama_Bahan());
//            statement.setInt(4, a.getBahan_Kritis());
//            statement.execute();
//            return a;
//        }
//        catch(SQLException exception){
//            exception.printStackTrace();
//            return null;
//        }
//        finally{
//            if(statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException exception) {
//                }
//            }
//        }
//    }

//    @Override
//    public void updateBahan(Bahan b) throws RemoteException {
//        System.out.println("proses update barang");
//        
//        PreparedStatement statement = null;
//        try {
//            statement = DatabaseUtilities.getConnection().prepareStatement(
//                    "UPDATE bahan SET ID_SATUAN=?, ID_SUPLIER=?, NAMA_BAHAN=?, BATAS_KRITIS=? WHERE ID_BAHAN=?");
//            statement.setString(1, b.getId_Satuan());
//            statement.setString(2, b.getId_Supplier());
//            statement.setString(3, b.getNama_Bahan());
//            statement.setInt(4, b.getBahan_Kritis());
//            statement.setInt(5, b.getId_Bahan());
//            statement.executeUpdate();  
//        }
//        catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        finally{
//            if(statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
//    }

//    @Override
//    public boolean deleteBahan(int IdBahan) throws RemoteException {
//        System.out.println("proses delete bahan");        
//        PreparedStatement statement = null;
//        try {
//            statement = DatabaseUtilities.getConnection().prepareStatement(
//                    "DELETE FROM bahan WHERE ID_BAHAN =?");
//            statement.setInt(1, IdBahan);
//            statement.executeUpdate();
//            return true;
//        } 
//        catch (SQLException exception) {
//            exception.printStackTrace();
//            return false;
//        }
//        finally{
//            if(statement != null){
//                try {
//                    statement.close();
//                } 
//                catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    public Dokter getDokter(int IdDokter) throws RemoteException {
//        System.out.println("melakukan proses getby ID_Dokter");
//        
//        PreparedStatement statement = null;
//        try {
//            statement = Koneksidatabase.getConnection().prepareStatement(
//                    "SELECT b.ID_BAHAN, b.ID_SATUAN, b.ID_SUPLIER, b.NAMA_BAHAN, b.BATAS_KRITIS, s.NAMA_SUPLIER FROM bahan AS b, supplier AS s WHERE b.ID_SUPLIER = s.ID_SUPLIER AND b.ID_BAHAN=?");
//            statement.setInt(1, IdDokter);
//            ResultSet result = statement.executeQuery();
//            
//            Dokter a = null;
//            
//            if(result.next()){
//                a = new Dokter();
//                a.setId_Bahan(Integer.parseInt(result.getString("Id_Bahan")));
//                a.setId_Satuan(result.getString("ID_SATUAN"));
//                a.setId_Supplier(result.getString("ID_SUPLIER"));
//                a.setNama_Supplier(result.getString("NAMA_SUPLIER"));
//                a.setNama_Bahan(result.getString("NAMA_BAHAN"));
//                a.setBahan_Kritis(result.getInt("BATAS_KRITIS"));
//            }
//            return a;
//            
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//            return null;
//        }
//        finally{
//            if(statement != null){
//                try{
//                    statement.close();
//                }
//                catch(SQLException exception){
//                    exception.printStackTrace();
//                }
//            }
//            
//        }
//    }
//        
//     @Override
//    public int getDokterID(String namaDokter) throws RemoteException {
//        System.out.println("melakukan proses getby ID_Dokter");
//        
//        PreparedStatement statement = null;
//        try {
//            statement = Koneksidatabase.getConnection().prepareStatement(
//                    "SELECT ID_BAHAN FROM  `bahan`  WHERE NAMA_Dokter =?");
//            statement.setString(1, namaDokter);
//            ResultSet result = statement.executeQuery();
//            
//            int a = 0;
//            
//            if(result.next()){
//                a =Integer.parseInt(result.getString("ID_Dokter"));
//            }
//            return a;
//            
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//            return 0;
//        }
//        finally{
//            if(statement != null){
//                try{
//                    statement.close();
//                }
//                catch(SQLException exception){
//                    exception.printStackTrace();
//                }
//            }
//            
//        }
//    }

    @Override
    public List<Dokter> getDokters() throws RemoteException {
        System.out.println("c");
        System.out.println("proses get ALL Dokter");
        Statement statement = null;
        
        try {
            System.out.println("b");
            statement = Koneksidatabase.getConnection().createStatement();
            System.out.println("b.1");
            List<Dokter> list;
            try (ResultSet result = statement.executeQuery("SELECT * FROM DOKTER")) {
                System.out.println("b.2");
                list = new ArrayList<>();
                System.out.println("b.3");
                while(result.next()){
                    System.out.println("a");
                    Dokter a = new Dokter();
                    System.out.println("a.1");
                    a.setid_dokter(result.getString("ID_DOKTER"));
                    System.out.println("a.2");
                    a.setid_spesialis(result.getString("ID_SPESIALIS"));
                    System.out.println("a.3");
                    a.setpassword_dokter(result.getString("PASSWORD_DOKTER"));
                    System.out.println("a.4");
                    a.setstatus_dokter(Integer.parseInt(result.getString("STATUS_DOKTER")));
                    System.out.println("a.5");
                    a.setnama_dokter(result.getString("NAMA_DOKTER"));
                    System.out.println("a.6");
                    a.setno_telp_dokter(result.getString("NO_TELP_DOKTER"));
                    System.out.println("a.7");
                    a.setalamat_dokter(result.getString("ALAMAT_DOKTER"));
                    System.out.println("a.8");
    //                a.setId_Bahan(Integer.parseInt(result.getString("ID_BAHAN")));
    //                a.setId_Satuan(result.getString("ID_SATUAN"));
    //                a.setId_Supplier(result.getString("ID_SUPLIER"));
    //                a.setNama_Bahan(result.getString("NAMA_BAHAN"));
    //                a.setNama_Supplier(result.getString("NAMA_SUPLIER"));
    //                a.setBahan_Kritis(result.getInt("BATAS_KRITIS"));
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
//    @Override
//    public List<Dokter> getDoktersUrut() throws RemoteException {
//        System.out.println("proses get ALL Bahan");
//        Statement statement = null;
//        
//        try {
//            statement = Koneksidatabase.getConnection().createStatement();
//            ResultSet result = statement.executeQuery("SELECT B.ID_BAHAN, B.NAMA_BAHAN, B.ID_SATUAN, B.ID_SUPLIER, S.NAMA_SUPLIER, B.BATAS_KRITIS FROM bahan AS B, supplier AS S WHERE S.ID_SUPLIER = B.ID_SUPLIER ORDER BY B.NAMA_BAHAN");
//            List<Dokter> list = new ArrayList<Dokter>();
//            
//            while(result.next()){
//                Dokter a = new Dokter();
//                a.setId_Bahan(Integer.parseInt(result.getString("ID_BAHAN")));
//                a.setId_Satuan(result.getString("ID_SATUAN"));
//                a.setId_Supplier(result.getString("ID_SUPLIER"));
//                a.setNama_Supplier(result.getString("NAMA_SUPLIER"));
//                a.setNama_Bahan(result.getString("NAMA_BAHAN"));
//                a.setBahan_Kritis(result.getInt("BATAS_KRITIS"));
//                list.add(a);
//            }
//            result.close();
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
//        }        
//        
//    }
//    
//    @Override
//    public List<Dokter> getBahansUrut(String ID_SUPPLIER) throws RemoteException {
//        System.out.println("proses get ALL Bahan");
//        PreparedStatement statement = null;
//        try {
//            statement = Koneksidatabase.getConnection().prepareStatement(
//                    "SELECT B.ID_BAHAN,B.NAMA_BAHAN,B.ID_SATUAN,B.ID_SUPLIER,S.NAMA_SUPLIER,B.BATAS_KRITIS FROM bahan AS B,supplier AS S WHERE B.ID_SUPLIER=? AND S.ID_SUPLIER=B.ID_SUPLIER ORDER BY B.NAMA_BAHAN ASC ");
//            statement.setString(1,ID_SUPPLIER);
//            ResultSet result = statement.executeQuery();
//            List<Dokter> list = new ArrayList<Dokter>();
//            
//            while(result.next()){
//                Dokter a = new Dokter();
//                a.setId_Bahan(Integer.parseInt(result.getString("ID_BAHAN")));
//                a.setId_Satuan(result.getString("ID_SATUAN"));
//                a.setId_Supplier(result.getString("ID_SUPLIER"));
//                a.setNama_Supplier(result.getString("NAMA_SUPLIER"));
//                a.setNama_Bahan(result.getString("NAMA_BAHAN"));
//                a.setBahan_Kritis(result.getInt("BATAS_KRITIS"));
//                list.add(a);
//            }
//            result.close();
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
//        }        
//    }
//    @Override
//    public Dokter getLastBahan() throws RemoteException {
//        System.out.println("melakukan proses getby ID_TRANSAKSI_USER");
//        
//        PreparedStatement statement = null;
//        try {
//            statement = Koneksidatabase.getConnection().prepareStatement(
//                    "SELECT * FROM bahan WHERE id_bahan = ( SELECT MAX( id_bahan ) FROM bahan )");
//            ResultSet result = statement.executeQuery();
//            
//            Dokter a = null;
//            
//            if(result.next()){
//                a = new Dokter();
//                a.setId_Bahan(result.getInt("ID_BAHAN"));
//                a.setId_Satuan(result.getString("ID_SATUAN"));
//                a.setBahan_Kritis(result.getInt("BATAS_KRITIS"));
//                a.setId_Supplier(result.getString("ID_SUPLIER"));
//                a.setNama_Bahan(result.getString("NAMA_BAHAN"));
//            }
//            return a;
//            
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//            return null;
//        }
//        finally{
//            if(statement != null){
//                try{
//                    statement.close();
//                }
//                catch(SQLException exception){
//                    exception.printStackTrace();
//                }
//            }
//            
//        }
//    }

//    @Override
//    public List<Dokter> getDokters() throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

//    @Override
//    public Dokter insertDokter(Dokter a) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void updateDokter(Dokter b) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public boolean deleteDokter(int IdDokter) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    
    @Override
    public String[] Dropdowndokter(String [] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT NAMA_DOKTER FROM DOKTER");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("NAMA_DOKTER");
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
    public Dokter getDokter(int IdDokter) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dokter getLastDokter() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Dokter> getDoktersUrut() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDokterID(String nama_bahan) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Dokter> getDoktersUrut(String id_suplier) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dokter insertDokter(Dokter a) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateDokter(Dokter b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteDokter(int IdDokter) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
