/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.sevice;
import trias.klinika.api.entitas.rekammedisEntyty;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import trias.klinika.api.entitas.PasienEntity;
/**
 *
 * @author Acer
 */
public interface serviceRekam extends Remote {
    PasienEntity getdata(String id) throws RemoteException;
    List<rekammedisEntyty> getdatarekam (String id) throws RemoteException;
    rekammedisEntyty getdatadetail(String id) throws RemoteException;
    
}
