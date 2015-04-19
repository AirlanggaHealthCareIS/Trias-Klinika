/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

import java.io.Serializable;

/**
 *
 * @author FazBam
 */
public class LoginEntitas implements Serializable {
    private String username;
    private String password;
    private String sebagai;
    private String fielduser;
    private String fieldpass;
    private String fieldstatus;
    
    public String getsebagai() {
        return sebagai;
    }

    public void setsebagai(String sebagai) {
        this.sebagai= sebagai;
    }
    
    public String getfieldstatus() {
        return fieldstatus;
    }

    public void setfieldstatus(String fieldstatus) {
        this.fieldstatus = fieldstatus;
    }
    
    public String getfielduser() {
        return fielduser;
    }

    public void setfielduser(String fielduser) {
        this.fielduser = fielduser;
    }
    
    public String getfieldpass() {
        return fieldpass;
    }

    public void setfieldpass(String fieldpass) {
        this.fieldpass = fieldpass;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }
    
    public void setpassword(String password) {
        this.password = password;
    }
}
