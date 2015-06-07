/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.LaporanPasienEntitas;

/**
 *
 * @author iqbal
 */
public interface LaporanPasienService {
    List<LaporanPasienEntitas> gettglpemeriksaan(String tglpemeriksaan) throws RemoteException;
}
