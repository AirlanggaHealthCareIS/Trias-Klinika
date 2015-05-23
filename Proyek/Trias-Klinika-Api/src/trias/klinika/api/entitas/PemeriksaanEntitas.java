/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;
import java.io.Serializable;
/**
 *
 * @author Satria
 */
public class PemeriksaanEntitas implements Serializable {
    private String ID_PEMERIKSAAAN;
    private String ID_REKAM_MEDIS;
    private String ID_RESERVASI;
    private String ID_PASIEN;
    private String ID_DOKTER;
    private String NAMA_DOKTER;
    private String ID_RESEP;
    private String ID_PEMBAYARAN;
    private String TGL_PEMERIKSAAN;
    private int NO_ANTRIAN;  
    
    public String getID_PEMERIKSAAAN() {
        return ID_PEMERIKSAAAN;
    }
    
    public void setID_PEMERIKSAAAN(String ID_PEMERIKSAAAN) {
        this.ID_PEMERIKSAAAN= ID_PEMERIKSAAAN;
    }
    
    public String getID_REKAM_MEDIS() {
        return ID_REKAM_MEDIS;
    }
    
    public void setID_REKAM_MEDIS(String ID_REKAM_MEDIS) {
        this.ID_REKAM_MEDIS= ID_REKAM_MEDIS;
    }
    
    public String getID_RESERVASI() {
        return ID_RESERVASI;
    }
    
    public void setID_RESERVASI(String ID_RESERVASI) {
        this.ID_RESERVASI= ID_RESERVASI;
    }
    
    public String getID_PASIEN() {
        return ID_PASIEN;
    }
    
    public void setID_PASIEN(String ID_PASIEN) {
        this.ID_PASIEN= ID_PASIEN;
    }
    
    public String getID_DOKTER() {
        return ID_DOKTER;
    }
    
    public void setID_DOKTER(String ID_DOKTER) {
        this.ID_DOKTER= ID_DOKTER;
    }
    
    public String getNAMA_DOKTER() {
        return NAMA_DOKTER;
    }
    
    public void setNAMA_DOKTER(String NAMA_DOKTER) {
        this.NAMA_DOKTER= NAMA_DOKTER;
    }
    
    public String getID_RESEP() {
        return ID_RESEP;
    }
    
    public void setID_RESEP(String ID_RESEP) {
        this.ID_RESEP= ID_RESEP;
    }
    
    public String getTGL_PEMERIKSAAN() {
        return TGL_PEMERIKSAAN;
    }
    
    public void setTGL_PEMERIKSAAN(String TGL_PEMERIKSAAN) {
        this.TGL_PEMERIKSAAN= TGL_PEMERIKSAAN;
    }
    
    public String getID_PEMBAYARAN() {
        return ID_PEMBAYARAN;
    }
    
    public void setID_PEMBAYARAN(String ID_PEMBAYARAN) {
        this.ID_PEMBAYARAN= ID_PEMBAYARAN;
    }
    
    public int getNO_ANTRIAN(){
        return NO_ANTRIAN;
    }
    public void setNO_ANTRIAN(int NO_ANTRIAN){
        this.NO_ANTRIAN = NO_ANTRIAN;
    }

    
    
}
