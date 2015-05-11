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
public class PasienEntity implements Serializable {
    String id_pasien;
    String nama;
    String tanggalLahir;
    String alamat;
    String NoTLP;
    String golDarah;
    String tanggal;
    private int NO_ANTREAN;
   
    public void setid_pasien(String id_pasien){
        this.id_pasien = id_pasien;
    } 
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setTanggalLahir (String tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }
    public void setAlamat (String alamat){
        this.alamat = alamat;
    }
    public void setNoTLP(String NoTLP){
        this.NoTLP = NoTLP;
    }
    public void setGolDarah (String golDarah){
        this.golDarah = golDarah;
    }
    public void SetTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public String getid_pasien(){
        return id_pasien;
    } 
    public String getNama(){
        return nama;
    }
    public String getTanggalLahir (){
        return tanggalLahir;
    }
    public String getAlamat (){
        return alamat;
    }
    public String getNoTLP(){
        return NoTLP;
    }
    public String getGolDarah (){
        return golDarah;
    }
    public String getTanggal(){
        return tanggal;
    }
    public int getNO_ANTREAN(){
        return NO_ANTREAN;
    }
    public void setNO_ANTREAN(int NO_ANTREAN){
        this.NO_ANTREAN = NO_ANTREAN;
    }
}
