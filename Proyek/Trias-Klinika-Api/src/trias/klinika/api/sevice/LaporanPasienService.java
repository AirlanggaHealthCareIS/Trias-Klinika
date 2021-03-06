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
    List<LaporanPasienEntitas> tglpemeriksaan(String tgl) throws RemoteException;
    List<LaporanPasienEntitas> tglpemeriksaanSpesialis(String tgl, String Spesialis) throws RemoteException;
    public String[] DropdownSpesialis(String[] spesialis) throws RemoteException;
    String[] DropdownTahun(String[] Tahun) throws RemoteException;
}
