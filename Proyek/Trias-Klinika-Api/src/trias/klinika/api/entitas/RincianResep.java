package trias.klinika.api.entitas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class RincianResep {
    private String ID_RINCIAN_OBAT;
    private String ID_OBAT;
    private String NAMA_OBAT;
    private int HARGA_OBAT;
    private int JUMLAH_OBAT;
    private int DOSIS_OBAT;
    
     public String getID_OBAT() {
        return ID_OBAT;
    }
    
     
     public void setID_OBAT(String ID_OBAT) {
        this.ID_OBAT = ID_OBAT;
    }
    public String getID_RINCIAN_OBAT(){
        return ID_RINCIAN_OBAT;
    }
    
    public String getNAMA_OBAT() {
        return NAMA_OBAT;
    }
    
    public void setNAMA_OBAT(String NAMA_OBAT) {
        this.NAMA_OBAT = NAMA_OBAT;
    }
     
    public int getHARGA_OBAT() {
        return HARGA_OBAT;
    }
    public int getJUMLAH_OBAT() {
        return JUMLAH_OBAT;
    }
    public void setHARGA_OBAT(int HARGA_OBAT) {
        this.HARGA_OBAT = HARGA_OBAT;
    }
    public int getDOSIS_OBAT() {
        return DOSIS_OBAT;
    }
}
