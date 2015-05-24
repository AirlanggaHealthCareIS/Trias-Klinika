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
public class rekammedisEntyty implements Serializable {
    String id_rekam;
    String diagnosa;
    String keluhan;
    String tindakan;
    String catatan_lain;
    String alergi;
    int tekanan_darah;
    String Tanggal;
    
    public void SetData (String id_rekam, String diagnosa, String keluhan, String tindakan, String catatan_lain, String alergi, int tekanan_darah, String Tanggal){
        this.id_rekam = id_rekam;
        this.diagnosa = diagnosa;
        this.keluhan = keluhan;
        this.tindakan = tindakan;
        this.catatan_lain = catatan_lain;
        this.alergi = alergi;
        this.tekanan_darah = tekanan_darah;
        this.Tanggal = Tanggal;
    }
    
    public void setId_rekam(String id_rekam){
        this.id_rekam = id_rekam;
    } 
    public void setDiagnosa(String diagnosa){
        this.diagnosa = diagnosa;
    }
    public void setKeluhan (String keluhan){
        this.keluhan = keluhan;
    }
    public void setCatatan_lain (String catatan_lain){
        this.catatan_lain = catatan_lain;
    }
    public void setTindakan (String tindakan){
        this.tindakan = tindakan;
    }
    public void setAlergi(String alergi){
        this.alergi = alergi;
    }
    public void setTekanan_darah (int tekanan_darah){
        this.tekanan_darah = tekanan_darah;
    }
    public void setTanggal (String Tanggal){
        this.Tanggal = Tanggal;
    }
    public String getId_rekam(){
        return id_rekam;
    } 
    public String getDiagnosa(){
        return diagnosa;
    }
    public String getKeluhan (){
        return keluhan;
    }
    public String getTindakan (){
        return tindakan;
    }
    public String getCatatan_lain (){
        return catatan_lain;
    }
    public String getAlergi (){
        return alergi;
    }
    public int getTekanan_darah(){
        return tekanan_darah;
    }
    public String getTanggal(){
        return Tanggal;
    }
    
}
 
       
