
package trias.klinika.api.sevice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.PasienEntity;

/**
 *
 * @author Sahirul
 */
public interface AntreanServis extends Remote{
 
   
    int getIDPasien() throws RemoteException;
    List<PasienEntity> getPasienEntitys() throws RemoteException;
    PasienEntity insertIDPasien (PasienEntity a) throws RemoteException;
    
    List<Dokter> getDokters() throws RemoteException;
    Dokter insertDokter (Dokter a) throws RemoteException;
    Dokter getDokter (int IdDokter) throws RemoteException;
   
    /**
     *
     * @param ob
     * @return
     * @throws RemoteException
     */
    String[] Dropdownpasien(String [] ob) throws RemoteException;
}
