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
    private String JENIS_OBAT;
    
    
    public String getID_OBAT() {
        return ID_OBAT;
    }
    public void setID_OBAT(String ID_OBAT) {
        this.ID_OBAT = ID_OBAT;
    }
    public String getID_RINCIAN_OBAT(){
        return ID_RINCIAN_OBAT;
    }
    public void setID_RINCIAN_OBAT(String ID_RINCIAN_OBAT) {
        this.ID_RINCIAN_OBAT = ID_RINCIAN_OBAT;
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
    public void setHARGA_OBAT(int HARGA_OBAT) {
        this.HARGA_OBAT = HARGA_OBAT;
    }
    public int getJUMLAH_OBAT() {
        return JUMLAH_OBAT;
    }
    public void setJUMLAH_OBAT(int JUMLAH_OBAT) {
        this.JUMLAH_OBAT = JUMLAH_OBAT;
    }
    public int getDOSIS_OBAT() {
        return DOSIS_OBAT;
    }
    public void setDOSIS_OBAT(int DOSIS_OBAT) {
        this.DOSIS_OBAT = DOSIS_OBAT;
    }

    public void setJENIS_OBAT(String JENIS_OBAT) {
        this.JENIS_OBAT = JENIS_OBAT; //To change body of generated methods, choose Tools | Templates.
    }
    public String getJENIS_OBAT (){
        return JENIS_OBAT;
    }

}
