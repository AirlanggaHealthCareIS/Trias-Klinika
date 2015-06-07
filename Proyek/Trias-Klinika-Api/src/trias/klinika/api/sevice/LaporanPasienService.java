/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.LaporanPasienEntitas;

/**
 *
 * @author iqbal
 */
public interface LaporanPasienService extends Remote {
    List<LaporanPasienEntitas> tglpemeriksaan(String tgl_awal, String tgl_akhir) throws RemoteException;
    public String[] DropdownSpesialis(String[] spesialis) throws RemoteException;
}
