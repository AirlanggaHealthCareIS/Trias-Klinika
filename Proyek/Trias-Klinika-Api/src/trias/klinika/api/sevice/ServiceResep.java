package trias.klinika.api.sevice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import trias.klinika.api.entitas.ResepEntity;
import java.rmi.RemoteException;
import java.rmi.Remote;
import trias.klinika.api.entitas.RincianResep;

/**
 *
 * @author User
 */
public interface ServiceResep {
    String [] obat (String [] pk)throws RemoteException;
    void Save (ResepEntity RE)throws RemoteException;
    void save (RincianResep RR,ResepEntity RE, int i)throws RemoteException;
    RincianResep getdetail  (RincianResep RR) throws RemoteException;
}
