package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iqbal
 */
public interface InventoriObatDokterService extends Remote {
    
    List<InventoriObatDokterEntitas> getobat(String id_spesialis) throws RemoteException;
    List<InventoriObatDokterEntitas> getobat1() throws RemoteException;
    List<InventoriObatDokterEntitas> getobat2() throws RemoteException;
    InventoriObatDokterEntitas dataobat(InventoriObatDokterEntitas IODE) throws RemoteException;
    String Spesialis(String id_dokter) throws RemoteException;
    void insertObatBaru(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException;
    void insertObatLama(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException;
    String[] Dropdownobat(String [] ob, String id_spesialis) throws RemoteException;
    String[] Dropdownjenis(String [] ob) throws RemoteException;
    String auto_increment_obat(String  aiobat) throws RemoteException;
    int auto_increment_iddetail (String aiObat) throws RemoteException;
    void updatekuantitas(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException;
    void deleteobat(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException;
}
