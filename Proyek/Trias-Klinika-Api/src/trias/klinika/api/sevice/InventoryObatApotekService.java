/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.api.sevice;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author Azmil
 */
public interface InventoryObatApotekService extends Remote{
    List<InventoryObatApotekEntitas> getobat () throws RemoteException;
    
    void insertObatBaru (InventoryObatApotekEntitas inventory) throws RemoteException;
    void updateObat (InventoryObatApotekEntitas inventory) throws RemoteException;
    void deleteObat (InventoryObatApotekEntitas inventory) throws RemoteException;
    List<InventoryObatApotekEntitas> cekKritis () throws RemoteException;
    List<InventoryObatApotekEntitas> cekExpired () throws RemoteException;
    void tambahObat (InventoryObatApotekEntitas inventory) throws RemoteException;
    String [] DropdownJenis (String [] jenis) throws RemoteException;
    String [] DropdownSpesialis (String [] spesialis) throws RemoteException;
    String auto_increment_obat(String  aiObat) throws RemoteException;
    InventoryObatApotekEntitas getIdObat(String id) throws RemoteException;
    
}
