
package trias.klinika.api.sevice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.PasienEntity;

/**
 *
 * @author Sahirul
 */
public interface PasienService extends Remote{
 
   
    int getIDPasien() throws RemoteException;
    List<PasienEntity> getPasienEntitys() throws RemoteException;
    PasienEntity insertIDPasien (PasienEntity a) throws RemoteException;
    void updatePasien(PasienEntity b) throws RemoteException;
    boolean deletePasien(int IdDokter) throws RemoteException;
    PasienEntity getPasienEntity (int IdDokter) throws RemoteException;
    PasienEntity getLastPasienEntity() throws RemoteException;
//    List<Dokter> getDokters() throws RemoteException;
    List<PasienEntity> getPasienEntitysUrut() throws RemoteException;
    int getDokterID(String nama_bahan) throws RemoteException;
    List<PasienEntity> getPasiensUrut(String id_suplier) throws RemoteException;
    
    /**
     *
     * @param ob
     * @return
     * @throws RemoteException
     */
    String[] Dropdownpasien(String [] ob) throws RemoteException;
}
