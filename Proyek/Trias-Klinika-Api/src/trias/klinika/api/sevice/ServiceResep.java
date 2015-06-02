package trias.klinika.api.sevice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import trias.klinika.api.entitas.ResepEntity;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.sql.SQLException;
import trias.klinika.api.entitas.RincianResep;

/**
 *
 * @author User
 */
public interface ServiceResep extends Remote{
    String [] obat (String [] pk)throws RemoteException;
    void Save (ResepEntity RE)throws RemoteException;
    void save(RincianResep RR) throws RemoteException;
    RincianResep getdetail  (RincianResep RR) throws RemoteException;
    ResepEntity getdetail (ResepEntity RE) throws RemoteException;
    ResepEntity ID_Pasien (ResepEntity RE) throws RemoteException;
    String auto_increment_NoResep(String  airesep) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    ResepEntity pasien(String id) throws RemoteException;
}
