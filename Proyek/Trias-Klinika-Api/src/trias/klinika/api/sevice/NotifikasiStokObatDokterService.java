/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;
/**
 *
 * @author User
 */
public interface NotifikasiStokObatDokterService extends Remote{
    String[] StokObatDokter(String[] IdObat) throws RemoteException;
    String[] StokObatDokter(String[] IdObat, String tanggal ) throws RemoteException;
}
