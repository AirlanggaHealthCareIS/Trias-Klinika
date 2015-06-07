/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.entitas;
import java.io.Serializable;
/**
 *
 * @author ICUN
 */
public class PelayananApotekEntitas1 implements Serializable {
 private String ID_PEMERIKSAAN;
     private String ID_RESEP;
    private String ID_APOTEK;
    private String ID_OBAT;
    private String NAMA_OBAT;
    private int HARGA_OBAT;
    private int TOTAL_HARGA;
    private String TGL_PEMERIKSAAN;
    private String NAMA_PASIEN;
    private String NAMA_DOKTER;
  
    public String getID_RESEP(){
     return ID_RESEP;
 }
 public void setID_RESEP(String ID_RESEP){
     this.ID_RESEP = ID_RESEP;
 }
  public String getID_OBAT(){
     return ID_OBAT;
 }
 public void setID_OBAT(String ID_OBAT){
     this.ID_OBAT = ID_OBAT;
 }
 
 public String getNAMA_OBAT(){
     return NAMA_OBAT;
 }
 public void setNAMA_OBAT(String NAMA_OBAT){
     this.NAMA_OBAT = NAMA_OBAT;
 }
 
 public int getHARGA_OBAT(){
     return HARGA_OBAT;
 }
 public void setHARGA_OBAT(int HARGA){
     this.HARGA_OBAT = HARGA_OBAT;
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
 
 
public String getNAMA_PASIEN(){
     return NAMA_PASIEN;
 }
 public void setNAMA_PASIEN(String NAMA_PASIEN){
     this.NAMA_PASIEN = NAMA_PASIEN;
 }
 
 
 public String getID_PEMERIKSAAN(){
     return ID_PEMERIKSAAN ;
 }
 public void setID_PEMERIKSAAN(String ID_PEMERIKSAAN){
     this.ID_PEMERIKSAAN = ID_PEMERIKSAAN;
 }

 public String getNAMA_DOKTER(){
     return NAMA_DOKTER;
 }
 public void setNAMA_DOKTER(String NAMA_DOKTER){
    this.NAMA_DOKTER = NAMA_DOKTER;
 }}