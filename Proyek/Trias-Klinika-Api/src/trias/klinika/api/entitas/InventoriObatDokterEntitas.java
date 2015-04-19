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
public class InventoriObatDokterEntitas implements Serializable {
    private String namaobat;
    private String jenisobat;
    private int kuantitiobat;
    private int hargaobat;
    private String tglmasuk;
    private String masapakai;
    private String deskripsi;
    private String idobat;
    private String iddetailobat;
    private String idspesialis;
    private String ruanganobat;
    private String idjenisobat;
    
    public String getnamaobat() {
        return namaobat;
    }

    public void setnamaobat(String namaobat) {
        this.namaobat = namaobat;
    }
    
    public String getjenisobat(){
        return jenisobat;
    }
    
    public void setjenisobat(String jenisobat){
        this.jenisobat = jenisobat;
    }
    
    public int getkuantitiobat(){
        return kuantitiobat;
    }
    
    public void setkuantitiobat(int kuantitiobat){
        this.kuantitiobat = kuantitiobat;
    }
    
    public int gethargaobat(){
        return hargaobat;
    }
    
    public void sethargaobat(int hargaobat){
        this.hargaobat = hargaobat;
    }
    
    public String gettglmasuk(){
        return tglmasuk;
    }
    
    public void settglmasuk(String tglmasuk){
        this.tglmasuk = tglmasuk;
    }
    
    public String getmasapakai(){
        return masapakai;
    }
    
    public void setmasapakai(String masapakai){
        this.masapakai = masapakai;
    }
    
    public String deskripsi(){
        return deskripsi;
    }
    
    public void setdeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public String idobat(){
        return idobat;
    }
    
    public void setidobat(String idobat){
        this.idobat = idobat;
    }
    
    public String iddetailobat(){
        return iddetailobat;
    }
    
    public void setiddetailobat(String iddetailobat){
        this.iddetailobat = iddetailobat;
    }
    
    public String idspesialis(){
        return idspesialis;
    }
    
    public void setidspesialis(String idspesialis){
        this.idspesialis = idspesialis;
    }
    
    public String ruanganobat(){
        return ruanganobat;
    }
    
    public void setruanganobat(String ruanganobat){
        this.ruanganobat = ruanganobat;
    }
    
    public String idjenisobat(){
        return idjenisobat;
    }
    
    public void setidjenisobat(String idjenisobat){
        this.idjenisobat = idjenisobat;
    }
}
