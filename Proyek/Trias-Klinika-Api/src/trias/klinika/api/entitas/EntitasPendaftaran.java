package trias.klinika.api.entitas;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satria
 */
public class EntitasPendaftaran implements Serializable {
    private String ID_PASIEN;
    private String NAMA_PASIEN;
    private String TGL_LAHIR_PASIEN;
    private String NO_TELP_PASIEN;
    private String ALAMAT_PASIEN;
    private String GOL_DARAH;
    
   
    
    public String getID_PASIEN() {
        return ID_PASIEN;
    }
    
    public void setDataPasien(String ID_PASIEN, String NAMA_PASIEN, String TGL_LAHIR_PASIEN, String NO_TELP_PASIEN, String ALAMAT_PASIEN, String GOL_DARAH) {
        this.ID_PASIEN= ID_PASIEN;
        this.NAMA_PASIEN= NAMA_PASIEN;
        this.TGL_LAHIR_PASIEN= TGL_LAHIR_PASIEN;
        this.NO_TELP_PASIEN= NO_TELP_PASIEN;
        this.ALAMAT_PASIEN= ALAMAT_PASIEN;
        this.GOL_DARAH= GOL_DARAH;
        
    }
    public String getNAMA_PASIEN() {
        return NAMA_PASIEN;
    }
    
    
    public String getTGL_LAHIR_PASIEN() {
        return TGL_LAHIR_PASIEN;
    }
    
    
    public String getNO_TELP_PASIEN() {
        return NO_TELP_PASIEN;
    }
    
   
    public String getALAMAT_PASIEN() {
        return ALAMAT_PASIEN;
    }
    

    public String getGOL_DARAH() {
        return GOL_DARAH;
    }
    

}
