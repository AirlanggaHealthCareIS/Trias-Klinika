/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.service;

import trias.klinika.api.entitas.LoginEntitas;
import trias.klinika.api.sevice.LoginService;
import trias.klinika.server.utilitas.Koneksidatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FazBam
 */
public class QueryLogin extends UnicastRemoteObject implements LoginService{
    
    public QueryLogin() throws RemoteException {
    }

    @Override
    public int CheckPassword(LoginEntitas login) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
   
            if (login.getfielduser() == null) {
                return 1;
            }
            
            ResultSet result = statement.executeQuery("SELECT "+login.getfieldpass()+" FROM "+login.getsebagai()+" WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            
            result.first();
            if (result.last() == false) {;
                return 1;
            }
            String pass = result.getString(login.getfieldpass());
            result.close();
            
            if (!pass.equals(login.getpassword())) {
                return 2;
            }
            
            else {
                return 3;
            }
            
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public LoginEntitas getNama(LoginEntitas login) throws RemoteException {
        Statement statement = null;
        
        try {
            
            statement = Koneksidatabase.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT "+login.getfieldnama()+" FROM "+login.getsebagai()+" WHERE "+login.getfielduser()+" = '"+login.getusername()+"'");
            
            result.first();
            
            login.setnamauser(result.getString(login.getfieldnama()));
            
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return login;
    }
    
}
