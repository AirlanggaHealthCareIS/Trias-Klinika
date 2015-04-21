/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;
import java.io.Serializable;
/**
 *
 * @author ICUN
 */
public class Dokter implements Serializable {
    private String id_dokter;
    private String id_spesialis;
    private String password_dokter;
    private int status_dokter;
    private String nama_dokter;
    private String no_telp_dokter;
    private String alamat_dokter;   
    
   
    public String getid_dokter() {
        return id_dokter;
    }

        public void setid_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }
        public String getid_spesialis() {
        return id_spesialis;
    }

        public void setid_spesialis(String id_spesialis) {
        this.id_spesialis = id_spesialis;
    }
        public String getpassword_dokter() {
        return password_dokter;
    }

        public void setpassword_dokter(String password_dokter) {
        this.password_dokter = password_dokter;
    }
    public int getstatus_dokter() {
        return status_dokter;
    }

    public void setstatus_dokter(int status_dokter) {
        this.status_dokter = status_dokter;
    }
        public String getnama_dokter() {
        return nama_dokter;
    }

        public void setnama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }
    
       public String getno_telp_dokter() {
        return no_telp_dokter;
    }

        public void setno_telp_dokter(String no_telp_dokter) {
        this.no_telp_dokter = no_telp_dokter;
    }
        public String getalamat_dokter() {
        return alamat_dokter;
    }

        public void setalamat_dokter(String alamat_dokter) {
        this.alamat_dokter = alamat_dokter;
    }
        
   
}
