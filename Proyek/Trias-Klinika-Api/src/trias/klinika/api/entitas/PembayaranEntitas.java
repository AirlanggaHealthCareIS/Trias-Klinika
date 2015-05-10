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
public class PembayaranEntitas implements Serializable{
    
    private int BIAYA_DOKTER;
    private int TOTAL_BIAYA;
    private int nomer_transaksi;
    
   
    public void setPembayaran (int BIAYA_DOKTER, int TOTAL_BIAYA, int nomer_transaksi){
        this.BIAYA_DOKTER = BIAYA_DOKTER;
        this.TOTAL_BIAYA = TOTAL_BIAYA;
        this.nomer_transaksi = nomer_transaksi;
    }
    
    public int getBIAYA_DOKTER() {
        return BIAYA_DOKTER;
    }
    
   
    
    public int getTOTAL_BIAYA() {
        return TOTAL_BIAYA;
    }
    
   
     
    public int getnomer_transaksi(){
        return nomer_transaksi;
    }
    
   
   
    
    
    
   
    
        
    
}
