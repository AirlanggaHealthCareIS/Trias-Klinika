/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

import java.io.Serializable;
/**
 *
 * @author iqbal
 */
public class LaporanPasienEntitas {
    private String idpemeriksaan;
    private String idpasien;
    private String idpembayaran;
    private String idrekammedis;
    private String idresep;
    private String iddokter;
    private String idreservasi;
    private String tglpemeriksaan;
    private String noantrian;
    private String namaspesialis;
    
    public String getidpemeriksaan() {
        return idpemeriksaan;
    }
    public void setidpemeriksaan(String idpemeriksaan) {
        this.idpemeriksaan = idpemeriksaan;
    }
    
    public String getidpasien() {
        return idpasien;
    }
    public void setidpasien(String idpasien) {
        this.idpasien = idpasien;
    }
    
    public String getidpembayaran() {
        return idpembayaran;
    }
    public void setidpembayaran(String idpembayaran) {
        this.idpembayaran = idpembayaran;
    }
    
    public String getidrekammedis() {
        return idrekammedis;
    }
    public void setidrekammedis(String idrekammedis) {
        this.idrekammedis = idrekammedis;
    }
    
    public String getidresep() {
        return idresep;
    }
    public void setidresep(String idresep) {
        this.idresep = idresep;
    }
    
    public String getiddokter() {
        return iddokter;
    }
    public void setiddokter(String iddokter) {
        this.idresep = iddokter;
    }
    
    public String getidreservasi() {
        return idreservasi;
    }
    public void setidreservasi(String idreservasi) {
        this.idreservasi = idreservasi;
    }
    
    public String gettglpemeriksaan() {
        return tglpemeriksaan;
    }
    public void settglpemeriksaan(String tglpemeriksaan) {
        this.tglpemeriksaan = tglpemeriksaan;
    }
    
    public String getnoantrian() {
        return noantrian;
    }
    public void setnoantrian(String noantrian) {
        this.noantrian = noantrian;
    }
    
    public String getnamaspesialis() {
        return namaspesialis;
    }
    public void setnamaspesialis(String namaspesialis) {
        this.namaspesialis = namaspesialis;
    }
}
