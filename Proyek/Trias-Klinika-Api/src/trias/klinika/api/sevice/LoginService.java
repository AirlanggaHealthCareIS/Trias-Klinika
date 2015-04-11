/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;

import trias.klinika.api.entitas.LoginEntitas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Faz
 */
public interface LoginService extends Remote {
    int CheckPassword (LoginEntitas login) throws RemoteException;
}
