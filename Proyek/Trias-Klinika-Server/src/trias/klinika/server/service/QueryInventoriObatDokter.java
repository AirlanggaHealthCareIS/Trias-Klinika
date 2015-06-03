package trias.klinika.server.service;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;
import trias.klinika.api.sevice.InventoriObatDokterService;
import trias.klinika.server.utilitas.Koneksidatabase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iqbal
 */
public class QueryInventoriObatDokter extends UnicastRemoteObject implements InventoriObatDokterService {
    public QueryInventoriObatDokter() throws RemoteException {
        
    }
    
   @Override
   public List<InventoriObatDokterEntitas> getobat(String id_spesialis) throws RemoteException {
        System.out.println("Client melakukan proses get-all");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT o.id_obat, o.nama_obat, o.deskripsi_obat, o.harga_obat, do.QTY_obat, do.tgl_masuk, do.masa_pakai, jo.nama_jenis FROM obat as o, detail_obat as do, jenis_obat as jo where o.id_obat = do.id_obat and o.id_jenis = jo.id_jenis and do.ruangan = 'Dokter' and o.id_spesialis = '"+id_spesialis+"' ");
            
            List<InventoriObatDokterEntitas> list = new ArrayList<InventoriObatDokterEntitas>();

            while(result.next()){
                InventoriObatDokterEntitas inventoriObatDokterEntitas = new InventoriObatDokterEntitas();
                inventoriObatDokterEntitas.setidobat(result.getString("id_obat"));
                inventoriObatDokterEntitas.setnamaobat(result.getString("nama_obat"));
                inventoriObatDokterEntitas.setdeskripsi(result.getString("deskripsi_obat"));
                inventoriObatDokterEntitas.sethargaobat(result.getInt("harga_obat"));
                inventoriObatDokterEntitas.setkuantitiobat(result.getInt("QTY_obat"));
                inventoriObatDokterEntitas.settglmasuk(result.getString("tgl_masuk"));
                inventoriObatDokterEntitas.settglmasapakai(result.getString("masa_pakai"));
                inventoriObatDokterEntitas.setjenisobat(result.getString("nama_jenis"));
                
                list.add(inventoriObatDokterEntitas);
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
   
   @Override
   public String Spesialis(String id_dokter) throws RemoteException {
        System.out.println("Client melakukan proses get ID_spesialis");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_SPESIALIS FROM dokter WHERE ID_DOKTER = '"+id_dokter+"'");
            System.out.println(result.toString());
            
            result.first();
            return result.getString("ID_SPESIALIS");
            
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
   public InventoriObatDokterEntitas dataobat(InventoriObatDokterEntitas IODE) throws RemoteException {
        System.out.println("Client melakukan proses get ID_OBAT");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM obat where ID_OBAT = '"+IODE.getidobat()+"'");
            result.first();
            InventoriObatDokterEntitas inventoriObatDokterEntitas = new InventoriObatDokterEntitas();
                inventoriObatDokterEntitas.setidobat(result.getString("ID_OBAT"));
                inventoriObatDokterEntitas.setidspesialis(result.getString("ID_SPESIALIS"));
                inventoriObatDokterEntitas.setidjenisobat(result.getString("ID_JENIS"));
                inventoriObatDokterEntitas.setnamaobat(result.getString("NAMA_OBAT"));
                inventoriObatDokterEntitas.sethargaobat(result.getInt("HARGA_OBAT"));
                inventoriObatDokterEntitas.setdeskripsi(result.getString("DESKRIPSI_OBAT"));
                
            
            
            return inventoriObatDokterEntitas;
            
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
   public List<InventoriObatDokterEntitas> getobat1() throws RemoteException {
        System.out.println("Client melakukan penambahan obat lama");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT o.id_obat, o.nama_obat, o.deskripsi_obat, o.harga_obat, do.kuantitas_obat, do.tgl_masuk_obat, do.masa_pakai_obat, jo.nama_jenis_obat FROM obat as o, detail_obat as do, jenis_obat as jo, dibagi as d where o.id_obat = do.id_obat and o.id_obat = d.id_obat");
            
            List<InventoriObatDokterEntitas> list = new ArrayList<InventoriObatDokterEntitas>();

            while(result.next()){
                InventoriObatDokterEntitas inventoriObatDokterEntitas = new InventoriObatDokterEntitas();
                inventoriObatDokterEntitas.setnamaobat(result.getString("nama_obat"));
                inventoriObatDokterEntitas.setjenisobat(result.getString("nama_jenis_obat"));
                
                list.add(inventoriObatDokterEntitas);
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
   @Override
   public List<InventoriObatDokterEntitas> getobat2() throws RemoteException {
        System.out.println("Client melakukan pengurangan  obat lama");

        Statement statement = null;
        

        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("UPDATE `detail_obat` SET `KUANTITAS_OBAT`= 100 WHERE `KUANTITAS_OBAT` = 12 ");
            
            List<InventoriObatDokterEntitas> list = new ArrayList<InventoriObatDokterEntitas>();

            while(result.next()){
                InventoriObatDokterEntitas inventoriObatDokterEntitas = new InventoriObatDokterEntitas();
                inventoriObatDokterEntitas.setkuantitiobat(result.getInt("kuantitas_obat"));
                
                list.add(inventoriObatDokterEntitas);
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
   
   public String auto_increment_obat(String  aiobat) throws RemoteException {
        Statement statement = null;
        
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT * FROM obat");
            
            
            result.last();
            aiobat = result.getString("id_obat");
            String b = Integer.toString((Integer.parseInt(aiobat.substring(1,5)))+1);
            //menambahkan angka belakang    
            for (int i = b.length(); i < 4; i++ ) {
                b = "0" + b;
            } 
            aiobat = aiobat.substring(0, 1) + b;
            result.close();
            
            return aiobat;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return aiobat;
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
    public int auto_increment_iddetail(String aiObat) throws RemoteException {
        Statement statement = null;
        int a = 0;
        try {
           
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery
            ("SELECT ID_DETAIL FROM DETAIL_OBAT WHERE ID_OBAT = '"+aiObat+"'");
            
            if(result.last()== false){
                a = 1;
            }
            else {
                result.last();
             a = result.getInt("ID_DETAIL");
            a++;
            
            result.close();
            
            }
            return a;
            
        }catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
               
    } //To change bo //To change body of generated methods, choose Tools | Templates.
    }
   
   
   @Override
    public void insertObatBaru(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException {
        System.out.println("Dokter melakukan proses insert");

        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO obat (ID_OBAT, ID_SPESIALIS, NAMA_OBAT, HARGA_OBAT, DESKRIPSI_OBAT, ID_JENIS)"
                    + "values (?, ?, ?, ?, ?, ?)");

            statement.setString(1, inventoriobatDokterEntitas.getidobat());
            statement.setString(2, inventoriobatDokterEntitas.getidspesialis());
            statement.setString(3, inventoriobatDokterEntitas.getnamaobat());
            statement.setInt(4, inventoriobatDokterEntitas.gethargaobat());
            statement.setString(5, inventoriobatDokterEntitas.getdeskripsi());
            statement.setString(6, inventoriobatDokterEntitas.getidjenisobat());
            System.out.println(statement.toString());
            

            statement.executeUpdate();

            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
        PreparedStatement statement1 = null;
        try {
            statement1 = Koneksidatabase.getConnection().prepareStatement(
                    "INSERT INTO detail_obat (ID_DETAIL, ID_OBAT, QTY_OBAT, TGL_MASUK, MASA_PAKAI, RUANGAN)"
                    + "values (?, ?, ?, ?, ?, ?)");

            statement1.setString(1, inventoriobatDokterEntitas.getiddetailobat());
            statement1.setString(2, inventoriobatDokterEntitas.getidobat());
            statement1.setInt(3, inventoriobatDokterEntitas.getkuantitiobat());
            statement1.setString(4, inventoriobatDokterEntitas.gettglmasuk());
            statement1.setString(5, inventoriobatDokterEntitas.gettglmasapakai());
            statement1.setString(6, inventoriobatDokterEntitas.getruanganobat());
            System.out.println(statement1.toString());

            statement1.executeUpdate();

            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
    }
   
   @Override
    public String[] Dropdownobat(String [] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT ID_OBAT,NAMA_OBAT FROM OBAT WHERE ID_SPESIALIS = 'S0001'");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("id_obat")+" - "+result.getString("nama_obat");
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
    public String[] Dropdownjenis(String[] ob) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * from `jenis_obat`");
            
            result.last();
            ob = new String [result.getRow()];
            result.first();

            for (int i=0;i<ob.length;i++){
                ob [i] = result.getString("id_jenis")+" - "+result.getString("nama_jenis");
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
    public void insertObatLama(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    
}
