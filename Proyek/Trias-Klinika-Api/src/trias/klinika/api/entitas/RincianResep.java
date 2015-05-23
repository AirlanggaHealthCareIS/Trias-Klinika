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
public class RincianResep implements Serializable{
    private int ID_RINCIAN_OBAT;
    private String ID_OBAT_KELUAR;
    private String ID_RESEP;
    private int JUMLAH_OBAT;
    private String DOSIS_OBAT;

public void setDataRincian(int ID_RINCIAN_RESEP, String ID_OBAT_KELUAR, String ID_RESEP, int JUMLAH_OBAT, String DOSIS_OBAT){
    this.ID_OBAT_KELUAR = ID_OBAT_KELUAR;
    this.ID_RINCIAN_OBAT = ID_RINCIAN_RESEP;
    this.ID_RESEP = ID_RESEP;
    this.JUMLAH_OBAT = JUMLAH_OBAT;
    this.DOSIS_OBAT = DOSIS_OBAT;
}
    
    
    public String getID_OBAT() {
        return ID_OBAT_KELUAR;
    }
    public void setID_OBAT(String ID_OBAT) {
        this.ID_OBAT_KELUAR = ID_OBAT;
    }
    public int getID_RINCIAN_OBAT(){
        return ID_RINCIAN_OBAT;
    }
    public void setID_RINCIAN_OBAT(int ID_RINCIAN_OBAT) {
        this.ID_RINCIAN_OBAT = ID_RINCIAN_OBAT;
    }
    public String getID_RESEP() {
        return ID_RESEP;
    }
    public void setID_RESEP(String ID_RESEP) {
        this.ID_RESEP = ID_RESEP;
    }
    
    public int getJUMLAH_OBAT() {
        return JUMLAH_OBAT;
    }
    public void setJUMLAH_OBAT(int JUMLAH_OBAT) {
        this.JUMLAH_OBAT = JUMLAH_OBAT;
    }
    public String getDOSIS_OBAT() {
        return DOSIS_OBAT;
    }
    public void setDOSIS_OBAT(String DOSIS_OBAT) {
        this.DOSIS_OBAT = DOSIS_OBAT;
    }

}
