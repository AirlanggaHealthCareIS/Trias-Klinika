/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.laporan_keuangan_reservasiEntity;
import trias.klinika.api.entitas.rekammedisEntyty;

/**
 *
 * @author Acer
 */
public interface laporan_keuanganService extends Remote {
    
  List<laporan_keuangan_reservasiEntity> getlaporan () throws RemoteException;
    
     laporan_keuangan_reservasiEntity getdata(String id) throws RemoteException;
    List<laporan_keuangan_reservasiEntity> getdatarekam (String id) throws RemoteException;
    rekammedisEntyty getdatadetail(String id) throws RemoteException;
    void ok(rekammedisEntyty rekammedisEntyty)throws RemoteException;
}
