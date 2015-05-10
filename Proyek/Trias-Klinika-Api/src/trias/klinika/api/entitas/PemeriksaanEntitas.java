/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

/**
 *
 * @author Satria
 */
public class PemeriksaanEntitas {
    private String ID_PEMERIKSAAN;
    private String ID_REKAM_MEDIS;
    private String ID_RESERVASI;
    private String ID_PASIEN;
    private String ID_DOKTER;
    private String ID_RESEP;
    private String ID_PEMBAYARAN;
    private String TGL_PEMERIKSAAN;
    private String NO_ANTRIAN;  
    
    
   
    public void setDataPemeriksaan(String ID_PEMERIKSAAN, String ID_RESERVASI, String ID_PASIEN, String ID_DOKTER, String TGL_PEMERIKSAAN, String NO_ANTRIAN ) {
        this.ID_PEMERIKSAAN= ID_PEMERIKSAAN;
        this.ID_RESERVASI= ID_RESERVASI;
        this.ID_PASIEN= ID_PASIEN;
        this.ID_DOKTER= ID_DOKTER;
        this.TGL_PEMERIKSAAN= TGL_PEMERIKSAAN;
        this.NO_ANTRIAN= NO_ANTRIAN;
        
    }
    public String getID_PEMERIKSAAN() {
        return ID_PEMERIKSAAN;
    }
    
    public String getID_REKAM_MEDIS() {
        return ID_REKAM_MEDIS;
    }
    
    public void setID_REKAM_MEDIS(){
        this.ID_REKAM_MEDIS= ID_REKAM_MEDIS;
    }
    
    public String getID_RESERVASI() {
        return ID_RESERVASI;
    }
    
    
    public String getID_PASIEN() {
        return ID_PASIEN;
    }
    
    
    public String getID_DOKTER() {
        return ID_DOKTER;
    }
    
    
    public String getID_RESEP() {
        return ID_RESEP;
    }
    
    public void setID_RESEP(){
        this.ID_RESEP= ID_RESEP;
    }
    
    public String getTGL_PEMERIKSAAN() {
        return TGL_PEMERIKSAAN;
    }
    
    
    public String getID_PEMBAYARAN() {
        return ID_PEMBAYARAN;
    }
    
    public void setID_PEMBAYARAN(){
        this.ID_PEMBAYARAN= ID_PEMBAYARAN;
    }
    
    public String getNO_ANTRIAN() {
        return NO_ANTRIAN;
    }
    
}
