/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;

/**
 *
 * @author Satria
 */
public interface NotifikasiStokObatApotekService extends Remote{
  public String[] StokObatAokter(String[] IdObat) throws RemoteException, SQLException;
  public InventoryObatApotekEntitas getobat(String IdObat) throws RemoteException;
}
