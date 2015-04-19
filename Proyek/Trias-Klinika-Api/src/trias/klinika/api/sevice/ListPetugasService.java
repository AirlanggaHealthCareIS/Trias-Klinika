/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import java.rmi.Remote;
import trias.klinika.api.entitas.LoginEntitas;
import java.rmi.RemoteException;

/**
 *
 * @author Faz
 */
public interface ListPetugasService extends Remote {
    void Ubah_Status_Login (LoginEntitas login) throws RemoteException;
    void Ubah_Status_Logout (LoginEntitas login) throws RemoteException;
}
