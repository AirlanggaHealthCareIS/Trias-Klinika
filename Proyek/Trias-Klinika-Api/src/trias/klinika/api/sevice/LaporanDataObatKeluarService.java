/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.LaporanDataObatKeluarEntitas;

/**
 *
 * @author Sahirul
 */
public interface LaporanDataObatKeluarService extends Remote {
    List<LaporanDataObatKeluarEntitas> getDataLaporan(String tgl_mulai, String tgl_sampai, String id_dokter) throws RemoteException;
    String [] DropdownTahun (String [] tahun) throws RemoteException;
    String [] DropdownBulan (String [] bulan, String tahun) throws RemoteException;
}
