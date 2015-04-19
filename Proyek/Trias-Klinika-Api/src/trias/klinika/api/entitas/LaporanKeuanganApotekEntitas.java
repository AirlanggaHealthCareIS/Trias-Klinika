/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;

import java.io.Serializable;

/**
 *
 * @author ISH
 */
public class LaporanKeuanganApotekEntitas implements Serializable {
   
     private int ID_RESEP;
    private String ID_APOTEK;
    private int TOTAL_HARGA;
    private String TGL_PEMERIKSAAN;
  
    public int getID_RESEP(){
     return ID_RESEP;
 }
 public void setID_RESEP(int ID_RESEP){
     this.ID_RESEP = ID_RESEP;
 }
   
 public String getID_APOTEK(){
    return ID_APOTEK;
}
public void setID_APOTEK(String ID_APOTEK){
     this.ID_APOTEK = ID_APOTEK;
 }


 public int getTOTAL_HARGA(){
     return TOTAL_HARGA;
 }
 public void setTOTAL_HARGA(int TOTAL_HARGA){
     this.TOTAL_HARGA = TOTAL_HARGA;
 }
 public String getTGL_PEMERIKSAAN(){
     return TGL_PEMERIKSAAN;
 }
 public void setTGL_PEMERIKSAAN(String TGL_PEMERIKSAAN){
     this.TGL_PEMERIKSAAN = TGL_PEMERIKSAAN;
 }


}
