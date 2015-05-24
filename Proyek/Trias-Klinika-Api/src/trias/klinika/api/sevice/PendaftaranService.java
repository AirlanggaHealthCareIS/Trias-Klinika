package trias.klinika.api.sevice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    String auto_increment_pemeriksaan(String  aiperiksa) throws RemoteException;
    String auto_increment_pasien(String  aipasien) throws RemoteException;
    int nomor_antrian(int na, String tgl, String id_dokter) throws RemoteException;
}
