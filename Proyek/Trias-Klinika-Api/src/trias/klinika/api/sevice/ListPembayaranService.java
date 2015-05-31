/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.ListPembayaranEntitas;

/**
 *
 * @author Sahirul
 */
public interface ListPembayaranService extends Remote{
    
    
    List<ListPembayaranEntitas> getBayar() throws RemoteException;
    ListPembayaranEntitas getdatadetail(String id) throws RemoteException;
    List<ListPembayaranEntitas> getTelat() throws RemoteException;
    ListPembayaranEntitas AmbilData(String Id) throws RemoteException;
}
