/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.RemoteException;
import trias.klinika.api.entitas.EntitasPendaftaran;
import java.rmi.Remote;
import trias.klinika.api.entitas.PemeriksaanEntitas;
/**
 *
 * @author Satria
 */
public  interface PendaftaranService extends Remote  {
    String [] pilih_dokter (String [] pd)throws RemoteException;
    void Save(EntitasPendaftaran EP, PemeriksaanEntitas PE) throws RemoteException;
}
