/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

/**
 *
 * @author ISH
 */
public class LaporanKeuanganApotekEntitas {
    private String NAMA_OBAT;
    private int TOTAL_HARGA;
    private int TGL_PEMERIKSAAN;
    private String ID_OBAT_KELUAR;
    private int HARGA_OBAT;
    private int JUMLAH_OBAT;
  
    
    public String getNAMA_OBAT(){
     return NAMA_OBAT;
 }
 public void setNAMA_OBAT(String NAMA_OBAT){
     this.NAMA_OBAT = NAMA_OBAT;
 }
 
 public int getTOTAL_HARGA(){
     return TOTAL_HARGA;
 }
 public void setTOTAL_HARGA(int TOTAL_HARGA){
     this.TOTAL_HARGA = TOTAL_HARGA;
 }

 public int getTGL_PEMERIKSAAN(){
    return TGL_PEMERIKSAAN;
}
public void setTGL_PEMERIKSAAN(int TGL_PEMERIKSAAN){
     this.TGL_PEMERIKSAAN = TGL_PEMERIKSAAN;
 }

 public String getID_OBAT_KELUAR(){
     return ID_OBAT_KELUAR;
 }
 public void setID_OBAT_KELUAR(String ID_OBAT_KELUAR){
     this.ID_OBAT_KELUAR = ID_OBAT_KELUAR;
 }
 
 public int getHARGA_OBAT(){
     return HARGA_OBAT;
 }
 public void setHARGA_OBAT(int HARGA_OBAT){
     this.HARGA_OBAT = HARGA_OBAT;
 }
 public int getJUMLAH_OBAT(){
     return JUMLAH_OBAT;
 }
 public void setJUMLAH_OBAT(int JUMLAH_OBAT){
     this.JUMLAH_OBAT = JUMLAH_OBAT;
 }
 


    
}
