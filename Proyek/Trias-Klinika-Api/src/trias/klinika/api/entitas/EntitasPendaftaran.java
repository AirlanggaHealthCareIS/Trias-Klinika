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
    
    public void setID_PASIEN(String ID_PASIEN) {
        this.ID_PASIEN= ID_PASIEN;
    }
    
    public String getNAMA_PASIEN() {
        return NAMA_PASIEN;
    }
    
    public void setNAMA_PASIEN(String NAMA_PASIEN) {
        this.NAMA_PASIEN= NAMA_PASIEN;
    }
    
    public String getTGL_LAHIR_PASIEN() {
        return TGL_LAHIR_PASIEN;
    }
    
    public void setTGL_LAHIR_PASIEN(String TGL_LAHIR_PASIEN) {
        this.TGL_LAHIR_PASIEN= TGL_LAHIR_PASIEN;
    }
    
    public String getNO_TELP_PASIEN() {
        return NO_TELP_PASIEN;
    }
    
    public void setNO_TELP_PASIEN(String NO_TELP_PASIEN) {
        this.ID_PASIEN= NO_TELP_PASIEN;
    }
    
    public String getALAMAT_PASIEN() {
        return ALAMAT_PASIEN;
    }
    
    public void setALAMAT_PASIEN(String ALAMAT_PASIEN) {
        this.ID_PASIEN= ALAMAT_PASIEN;
    }
    
    public String getGOL_DARAH() {
        return GOL_DARAH;
    }
    
    public void setGOL_DARAH(String GOL_DARAH) {
        this.GOL_DARAH= GOL_DARAH;
    }
}
