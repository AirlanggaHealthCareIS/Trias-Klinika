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
public class ResepEntity {
    private int NO_resep;
    private String ID_pasien;
    private String ID_dokter;
    private String ID_obat;
    private String ID_apotek;
    private int jumlah;
    private String nama_pasien;
    private String nama_dokter;
    private String nama_obat;
    private String keterangan;
    private int NO;
    private String jumlah_terpenuhi;
    private String satuan_jenis;
    private int harga;
    
    
    public int getNO_resep(){
        return NO_resep;
    }
    public String getID_pasien(){
        return ID_pasien;
    }
    public String getID_dokter(){
        return ID_dokter;
    }
    public String getID_obat(){
        return ID_obat;
    }
    public String getID_apotek(){
        return ID_apotek;
    }
    public int getjumlah(){
        return jumlah;
    }
    public String getnama_pasien(){
        return nama_pasien;
    }
    public String getnama_dokter(){
        return nama_dokter;
    }
    public String getnama_obat(){
        return nama_obat;
    }
    public String getketarangan(){
        return keterangan;
    }
    public int getNO(){
        return NO;
    }
    public String getjumlah_terpenuhi(){
        return jumlah_terpenuhi;
    }
    public String getsatuan_jenis(){
        return satuan_jenis;
    }
    public int getharga(){
        return harga;
    }  

    public String getSTATUS_RESEP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
