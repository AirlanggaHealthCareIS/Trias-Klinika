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
    private String tglmasapakai;
    private String deskripsi;
    private String idobat;
    private String iddetailobat;
    private String idspesialis;
    private String iddokter;
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
    
    public String gettglmasapakai(){
        return tglmasapakai;
    }
    
    public void settglmasapakai(String tglmasapakai){
        this.tglmasapakai = tglmasapakai;
    }
    
    public String getdeskripsi(){
        return deskripsi;
    }
    
    public void setdeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public String getidobat(){
        return idobat;
    }
    
    public void setidobat(String idobat){
        this.idobat = idobat;
    }
    
    public String getiddetailobat(){
        return iddetailobat;
    }
    
    public void setiddetailobat(String iddetailobat){
        this.iddetailobat = iddetailobat;
    }
    
    public String getidspesialis(){
        return idspesialis;
    }
    
    public void setidspesialis(String idspesialis){
        this.idspesialis = idspesialis;
    }
    
    public String getiddokter(){
        return iddokter;
    }
    
    public void setiddokter(String iddokter){
        this.iddokter = iddokter;
    }
    
    public String getruanganobat(){
        return ruanganobat;
    }
    
    public void setruanganobat(String ruanganobat){
        this.ruanganobat = ruanganobat;
    }
    
    public String getidjenisobat(){
        return idjenisobat;
    }
    
    public void setidjenisobat(String idjenisobat){
        this.idjenisobat = idjenisobat;
    }
}
