/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.api.entitas;
import java.io.Serializable;

/**
 *
 * @author Azmil
 */
public class InventoryObatApotekEntitas implements Serializable {
    private String id_obat;
    private String nama_obat;
    private int qty;
    private String jenis_obat;
    private int harga_obat;
    private String tgl_masuk;
    private String masa_pakai;
    private int id_detail_obat;
    private String id_spesialis;
    private String ruang_obat;
    private String id_jenisobat;
    private String deskripsi;
    private String nama_spesialis;
    
    
    public String getIdObat (){
        return id_obat;
    }
    public void setIdObat (String id_obat){
        this.id_obat = id_obat;
    }
    public String getNamaSpesialis (){
        return nama_spesialis;
    }
    public void setNamaSpesialis (String nama_spesialis){
        this.nama_spesialis = nama_spesialis;
    }
    public String getNamaObat(){
        return nama_obat;
    }
    public void setNamaObat (String nama_obat){
        this.nama_obat = nama_obat;
    }
    public int getQty (){
        return qty;
    }
    public void setQty (int qty){
        this.qty = qty;
    }
     public String getJenisObat(){
        return jenis_obat;
    }
    public void setJenisObat (String jenis_obat){
        this.jenis_obat = jenis_obat;
    }
    public int getHargaObat (){
        return harga_obat;
    }
    public void setHargaObat (int harga_obat){
        this.harga_obat = harga_obat;
    }
    public String getTglMasuk (){
        return tgl_masuk;
    }
    public void setTglMasuk (String tgl_masuk){
        this.tgl_masuk = tgl_masuk;
    }
    public String getMasaPakai (){
        return masa_pakai;
    }
    public void setMasaPakai (String masa_pakai){
        this.masa_pakai = masa_pakai;
    }
    public int getIdDetailObat (){
        return id_detail_obat;
    }
    public void setIdDetailObat (int id_detail_obat){
        this.id_detail_obat = id_detail_obat;
    }
    public String getIdSpesialis (){
        return id_spesialis;
    }
    public void setIdSpesialis (String id_spesialis){
        this.id_spesialis = id_spesialis;
    }
    
    public String getRuangObat (){
        return ruang_obat;
    }
    public void setRuangObat (String ruang_obat){
        this.ruang_obat = ruang_obat;
    }
    public String getIdJenisObat (){
        return id_jenisobat;
    }
    public void setIdJenisObat (String id_jenisobat){
        this.id_jenisobat = id_jenisobat;
    }
    public String getDeskripsi (){
        return deskripsi;
    }
    public void setDeskripsi (String deskripsi){
        this.deskripsi = deskripsi;
    }
    
}

