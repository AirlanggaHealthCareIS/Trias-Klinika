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
public interface laporankeuanganReservasiService extends Remote {
  public List<laporan_keuangan_reservasiEntity> getlaporan(String date1, String date2, String id_dokter) throws RemoteException; 
  public List <laporan_keuangan_reservasiEntity> getdata(String date1) throws RemoteException;
}
