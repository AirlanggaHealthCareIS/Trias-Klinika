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
public class ListPembayaranEntitas implements Serializable {
    private String namaPasien;
    private String namaDokter;
    private int biayaDokter;
    private int biayaTindakan;
    private int totalBayar;
    private int biayaKonsultasi;
    private String idPemeriksaan;
    private String tglPemeriksaan;
    
    public String getnamaPasien() {
        return namaPasien;
    }
    public void setnamaPasien(String namaPasien){
        this.namaPasien = namaPasien;
    }
    public String getnamaDokter(){
        return namaDokter;
    }
    public void setnamaDokter(String namaDokter){
        this.namaDokter = namaDokter;
    }
    public int getbiayaDokter(){
        return biayaDokter;
    }
    public void setbiayaDokter(int biayaDokter){
        this.biayaDokter = biayaDokter;
    }
    public int getbiayaTindakan(){
        return biayaTindakan;
    }
    public void setbiayaTindakan(int biayaTindakan){
        this.biayaTindakan = biayaTindakan;
    }
    public int getbiayaKonsultasi(){
        return biayaKonsultasi;
    }
    public void setbiayaKonsultasi(int biayaKonsultasi){
        this.biayaKonsultasi = biayaKonsultasi;
    }
    public int gettotalBayar(){
        return totalBayar;
    }
    public void settotalBayar(int totalBayar){
        this.totalBayar = totalBayar;
    }
    public String getidPemeriksaan(){
        return idPemeriksaan;
    }
    public void setidPemeriksaan(String idPemeriksaan){
        this.idPemeriksaan = idPemeriksaan;
        
    }
    public String gettglPemeriksaan(){
        return tglPemeriksaan;
    }
    public void settglPemeriksaan(String tglPemeriksaan){
        this.tglPemeriksaan = tglPemeriksaan;
    }
    
}
