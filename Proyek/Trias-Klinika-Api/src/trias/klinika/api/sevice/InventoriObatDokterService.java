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
    
    List<InventoriObatDokterEntitas> getobat() throws RemoteException;
    void insertObatBaru(InventoriObatDokterEntitas inventoriobatDokterEntitas) throws RemoteException;
    String[] Dropdownobat(String [] ob) throws RemoteException;
    
}
