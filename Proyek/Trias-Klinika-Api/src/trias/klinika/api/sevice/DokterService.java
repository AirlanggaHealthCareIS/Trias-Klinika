
package trias.klinika.api.sevice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.Dokter;

/**
 *
 * @author Sahirul
 */
public interface DokterService extends Remote{
    /**
     *
     * @return
     * @throws RemoteException
     */
    List<Dokter> getDokters() throws RemoteException;
    Dokter insertDokter (Dokter a) throws RemoteException;
    void updateDokter(Dokter b) throws RemoteException;
    boolean deleteDokter(int IdDokter) throws RemoteException;
    Dokter getDokter (int IdDokter) throws RemoteException;
    Dokter getLastDokter () throws RemoteException;
//    List<Dokter> getDokters() throws RemoteException;
    List<Dokter> getDoktersUrut() throws RemoteException;
    int getDokterID(String nama_bahan) throws RemoteException;
    List<Dokter> getDoktersUrut(String id_suplier) throws RemoteException;
    
    /**
     *
     * @param ob
     * @return
     * @throws RemoteException
     */
    String[] Dropdowndokter(String [] ob) throws RemoteException;
}
