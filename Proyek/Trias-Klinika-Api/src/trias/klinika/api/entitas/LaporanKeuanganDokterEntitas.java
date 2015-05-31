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
public class LaporanKeuanganDokterEntitas implements Serializable{
    private String ID_PEMERIKSAAN;
    private String TGL_PEMERIKSAAN;
    private String NAMA_PASIEN;
    private int JUMLAH_PEMASUKKAN;
    
    
    public void setDataLaporan(String ID_PEMERIKSAAN, String TGL_PEMERIKSAAN, String  NAMA_PASIEN, int  JUMLAH_PEMASUKKAN){
        this.ID_PEMERIKSAAN= ID_PEMERIKSAAN;
        this.TGL_PEMERIKSAAN= TGL_PEMERIKSAAN;
        this.NAMA_PASIEN= NAMA_PASIEN;
        this.JUMLAH_PEMASUKKAN= JUMLAH_PEMASUKKAN;
        
    }
    
    public String getID_PEMERIKSAAN() {
        return ID_PEMERIKSAAN;
    }
    public String getTGL_PEMERIKSAAN() {
        return TGL_PEMERIKSAAN;
    }
    public String getNAMA_PASIEN() {
        return NAMA_PASIEN;
    }
    public int getJUMLAH_PEMASUKKAN() {
        return JUMLAH_PEMASUKKAN;
    }
}
