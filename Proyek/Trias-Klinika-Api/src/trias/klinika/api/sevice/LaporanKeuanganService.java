/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.LaporanKeuanganApotekEntitas;

/**
 *
 * @author TOSHIBA
 */
public interface LaporanKeuanganService extends Remote{
  
   
    List<LaporanKeuanganApotekEntitas> getlkeuangan() throws RemoteException;
    
}  
