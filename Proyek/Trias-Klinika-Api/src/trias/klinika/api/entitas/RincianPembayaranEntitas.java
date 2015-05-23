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
public class RincianPembayaranEntitas implements Serializable {
    private int ID_RINCIAN_PEMBAYARAN;
    private String ID_PEMBAYARAN;
    private String ID_OBAT_DOKTER;
    
    
    
    public void setRincianPembayaran(int ID_RINCIAN_PEMBAYARAN, String ID_PEMBAYARAN, String ID_OBAT_DOKTER){
        this.ID_RINCIAN_PEMBAYARAN = ID_RINCIAN_PEMBAYARAN;
        this.ID_PEMBAYARAN = ID_PEMBAYARAN;
        this.ID_OBAT_DOKTER = ID_OBAT_DOKTER;
        
    }
    public int getID_RINCIAN_PEMBAYARAN() {
        return ID_RINCIAN_PEMBAYARAN;
    }
    
       
    public String getID_PEMBAYARAN() {
        return ID_PEMBAYARAN;
    }
    
    
    public String getID_OBAT_DOKTER() {
        return ID_OBAT_DOKTER;
    }
    
     
    
}
