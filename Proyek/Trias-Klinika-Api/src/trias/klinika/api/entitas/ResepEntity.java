package trias.klinika.api.entitas;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ResepEntity implements Serializable {
    private String ID_resep;
    private String ID_pasien;
    private String ID_dokter;
    private String ID_obat;
    private String ID_apotek;
    private String ID_Apotek;
    private int jumlah;
    private String nama_pasien;
    private String nama_dokter;
    private String nama_obat;
    private String keterangan;
    private int NO;
    private String jumlah_terpenuhi;
    private String satuan_jenis;
    private int harga;
    private int STATUS_RESEP;
    
    public void setDataResep(String ID_resep, int STATUS_RESEP){
        this.ID_resep = ID_resep;
        this.STATUS_RESEP = STATUS_RESEP;
    }
    public String getID_resep(){
                return ID_resep;
    }
    public void setID_resep(String ID_resep) {
        this.ID_resep = ID_resep;
    }
    public String getID_pasien(){
        return ID_pasien;
    }
    public void setID_pasien(String ID_pasien) {
        this.ID_pasien = ID_pasien;
    }
    public String getID_dokter(){
        return ID_dokter;
    }
    public void setID_dokter(String ID_dokter) {
        this.ID_dokter = ID_dokter;
    }
    public String getID_obat(){
        return ID_obat;
    }
    public void setID_obat(String ID_obat) {
        this.ID_obat = ID_obat;
    }
    public String getID_apotek(){
        return ID_apotek;
    }
    public void setID_apotek(String ID_apotek) {
        this.ID_apotek = ID_apotek;
    }
    public String getID_Apotek(){
        return ID_apotek;
    }
    public void setID_Apotek(String ID_Apotek) {
        this.ID_Apotek = ID_Apotek;
    }
    public int getjumlah(){
        return jumlah;
    }
    public void setjumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public String getnama_pasien(){
        return nama_pasien;
    }
    public void setnama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }
    public String getnama_dokter(){
        return nama_dokter;
    }
    public void setnama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }
    public String getnama_obat(){
        return nama_obat;
    }
    public void setnama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
    public String getketarangan(){
        return keterangan;
    }
    public void setketerangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public int getNO(){
        return NO;
    }
    public void setNO(int NO) {
        this.NO = NO;
    }
    public String getjumlah_terpenuhi(){
        return jumlah_terpenuhi;
    }
    public void setjumlah_terpenuhi(String jumlah_terpenuhi) {
        this.jumlah_terpenuhi = jumlah_terpenuhi;
    }
    public String getsatuan_jenis(){
        return satuan_jenis;
    }
    public void setsatuan_jenis(String satuan_jenis) {
        this.satuan_jenis = satuan_jenis;
    }
    public int getharga(){
        return harga;
    }  
    public void setharga(int harga) {
        this.harga = harga;
    }

    public int getSTATUS_RESEP() {
        return STATUS_RESEP;
    }
    
    
}
