
package trias.klinika.api.sevice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.PasienEntity;
import trias.klinika.api.entitas.PemeriksaanEntitas;

/**
 *
 * @author Sahirul
 */
public interface AntreanServis extends Remote{
 
   
    int getIDPasien() throws RemoteException;
    int nomorAntrean(int na, String tgl, String id_dokter) throws RemoteException;
    List<PasienEntity> getPasienEntitys() throws RemoteException;
    PasienEntity insertIDPasien (PasienEntity a) throws RemoteException;
    PemeriksaanEntitas insertPemeriksaan (PemeriksaanEntitas a) throws RemoteException;
    void updateStatus(PemeriksaanEntitas suparmin, String id_pemeriksaan) throws RemoteException;
    void updateStatus2(PemeriksaanEntitas suparmin, String id_pemeriksaan) throws RemoteException;
    PasienEntity getpasienkanan(String id) throws RemoteException;
    DefaultComboBoxModel getLista(String cadenaEscrita) throws RemoteException;
    List<PemeriksaanEntitas> getpasienkiri(String id, String tgl) throws RemoteException;
    
    List<Dokter> getDokters() throws RemoteException;
    List<PemeriksaanEntitas> getPemeriksaans() throws RemoteException;
    List<PasienEntity> getlistidpasien() throws RemoteException;
    List<PemeriksaanEntitas> buatRefreshing(String tgl, String id_dokter) throws RemoteException;  
    String getIDdokter(String nama_dokter) throws RemoteException;
   
    /**
     *
     * @param ob
     * @return
     * @throws RemoteException
     */
    String[] Dropdownpasien(String [] ob) throws RemoteException;
}
