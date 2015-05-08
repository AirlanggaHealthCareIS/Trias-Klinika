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
    private String namauser;
    private String fielduser;
    private String fieldpass;
    private String fieldstatus;
    private String fieldnama;
    
    public void SetData (String username, String password, String sebagai, String fielduser, String fieldpass, String fieldstatus, String fieldnama) {
        this.username = username;
        this.password = password;
        this.sebagai = sebagai;
        this.fielduser = fielduser;
        this.fieldpass = fieldpass;
        this.fieldstatus = fieldstatus;
        this.fieldnama = fieldnama;
    }
    
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
    
    public String getfieldnama() {
        return fieldnama;
    }

    public void setfieldnama(String fieldnama) {
        this.fieldnama = fieldnama;
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
    
    public String getnamauser() {
        return namauser;
    }

    public void setnamauser(String namauser) {
        this.namauser = namauser;
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
