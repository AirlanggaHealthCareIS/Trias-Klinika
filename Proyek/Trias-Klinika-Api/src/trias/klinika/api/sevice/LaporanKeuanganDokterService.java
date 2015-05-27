/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.LaporanKeuanganDokterEntitas;

/**
 *
 * @author Satria
 */
public interface LaporanKeuanganDokterService extends Remote{
    List<LaporanKeuanganDokterEntitas> getDataLaporan(String tgl_mulai, String tgl_sampai, String id_dokter) throws RemoteException;
}
