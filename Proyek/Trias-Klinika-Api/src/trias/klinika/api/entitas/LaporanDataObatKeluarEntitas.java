/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

import java.io.Serializable;

/**
 *
 * @author Sahirul
 */
public class LaporanDataObatKeluarEntitas implements Serializable{
    
    private String ID_PEMERIKSAAN;
    private String TGL_PEMERIKSAAN;
    private String KODE_OBAT;
    private String NAMA_OBAT;
    private String ID_RESEP;
    private int JUMLAH_OBAT;
    
    
    public void setDataLaporan(String TGL_PEMERIKSAAN, String KODE_OBAT, String NAMA_OBAT, int JUMLAH_OBAT, String ID_PEMERIKSAAN){
        this.KODE_OBAT= KODE_OBAT;
        this.TGL_PEMERIKSAAN= TGL_PEMERIKSAAN;
        this.NAMA_OBAT= NAMA_OBAT;
        this.JUMLAH_OBAT= JUMLAH_OBAT;
        this.ID_PEMERIKSAAN = ID_PEMERIKSAAN;
        
    }
    
    public String getKODE_OBAT() {
        return KODE_OBAT;
    }
    public String getTGL_PEMERIKSAAN() {
        return TGL_PEMERIKSAAN;
    }
    public String getNAMA_OBAT() {
        return NAMA_OBAT;
    }
    public int getJUMLAH_OBAT() {
        return JUMLAH_OBAT;
    }
    public String getID_PEMERIKSAAN() {
        return ID_PEMERIKSAAN;
        
    }
    
    
}
