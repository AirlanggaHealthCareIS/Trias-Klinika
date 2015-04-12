/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.RemoteException;
import trias.klinika.api.entitas.PembayaranEntitas;
import java.rmi.Remote;
import trias.klinika.api.entitas.RincianPembayaran;

/**
 *
 * @author ICUN
 */
public interface pembayaranService extends Remote {
    String [] obat (String [] pk)throws RemoteException;
    void Save (PembayaranEntitas PE)throws RemoteException;
    void save (RincianPembayaran RP,PembayaranEntitas PE, int i)throws RemoteException;
    int biaya (int harga, String id)throws RemoteException;
     
}
