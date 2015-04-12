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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azmil
 */
public interface InventoryObatApotekService extends Remote{
    List<InventoryObatApotekEntitas> getobat () throws RemoteException;
    
 //   InventoryObatApotekEntitas insertObatLama (InventoryObatApotekEntitas inventory) throws RemoteException;
    void insertObatBaru (InventoryObatApotekEntitas inventory) throws RemoteException;
//    void updateObat (InventoryObatApotekEntitas inventory) throws RemoteException;
//    void deleteObat (InventoryObatApotekEntitas inventory) throws RemoteException;
//    void cekKritis (InventoryObatApotekEntitas inventory) throws RemoteException;
//    void cekExpired (InventoryObatApotekEntitas inventory) throws RemoteException;
//    InventoryObatApotekEntitas getNamaObat (String nama_obat)throws RemoteException;
//    InventoryObatApotekEntitas getIdObat (String id_obat) throws RemoteException;
    
    
//    DefaultTableModel loadTable () throws RemoteException;
    
}
