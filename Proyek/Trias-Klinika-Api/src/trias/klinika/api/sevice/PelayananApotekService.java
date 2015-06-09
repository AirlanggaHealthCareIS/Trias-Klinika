/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import trias.klinika.api.entitas.PelayananApotekEntitas;
import trias.klinika.api.entitas.PelayananApotekEntitas1;

/**
 *
 * @author TOSHIBA
 */
public interface PelayananApotekService extends Remote{
   PelayananApotekEntitas getpelayananapotek(String id) throws RemoteException; 
  List<PelayananApotekEntitas> getresepbaru(String id) throws RemoteException;
  List<PelayananApotekEntitas> getDokters() throws RemoteException;
  List<PelayananApotekEntitas> XXX() throws RemoteException;
  // PelayananApotekEntitas getresepbaru(String id) throws RemoteException;
    
    
    
    }
   

