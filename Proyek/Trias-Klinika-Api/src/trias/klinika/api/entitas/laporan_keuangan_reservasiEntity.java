/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class laporan_keuangan_reservasiEntity implements Serializable {
    private String jenis;
    private String id_dokter;
    private String tanggal;
    private String nama_dokter;
    private int jumlah;
    private String id_rincian_pembayaran;
    
    public String getjenis(){
        return jenis;
    }
    public void setjenis(String jenis){
        this.jenis = jenis;
    }
    public String getid_dokter(){
        return id_dokter;
    }
    public void setid_dokter(String id_dokter){
        this.id_dokter = id_dokter;
    }
    public String gettanggaal (){
        return tanggal;
    }
    public void settanggal(String tanggal){
        this.tanggal = tanggal ;
    }
    public String getnama_dokter(){
        return nama_dokter;
    }
    public void setnama_dokter(String nama_dokter){
        this.nama_dokter = nama_dokter;
    }
    public int getjumlah(){
    return jumlah;
}
    public void setjumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public String getid_rincian_pembayaran(){
        return id_rincian_pembayaran;
    }
    public void setid_rincian_pembayaran(String id_rincian_pembayaran){
        this.id_rincian_pembayaran = id_rincian_pembayaran;
    }
}
