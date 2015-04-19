/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.ListPetugasService;
import trias.klinika.server.utilitas.Koneksidatabase;

/**
 *
 * @author Faz
 */
public class QueryListPetugas extends UnicastRemoteObject implements ListPetugasService {
    
    public QueryListPetugas() throws RemoteException {
    }
    
    @Override
    public void Ubah_Status_Login (LoginEntitas login) throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "UPDATE "+login.getsebagai()+" SET "+login.getfieldstatus()+" = 1 WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            System.out.println(statement.toString());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryListPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Ubah_Status_Logout (LoginEntitas login) throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = Koneksidatabase.getConnection().prepareStatement(
                    "UPDATE "+login.getsebagai()+" SET "+login.getfieldstatus()+" = 0 WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryListPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
