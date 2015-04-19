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
    private int ID_PEMBAYARAN;
    private String ID_OBAT_DOKTER;
    
    
    public int getID_RINCIAN_PEMBAYARAN() {
        return ID_RINCIAN_PEMBAYARAN;
    }
    
    public void setID_RINCIAN_PEMBAYARAN(int ID_RINCIAN_PEMBAYARAN) {
        this.ID_RINCIAN_PEMBAYARAN = ID_RINCIAN_PEMBAYARAN;
    }
    
    public int getID_PEMBAYARAN() {
        return ID_PEMBAYARAN;
    }
    
    public void setID_PEMBAYARAN(int ID_PEMBAYARAN) {
        this.ID_PEMBAYARAN = ID_PEMBAYARAN;
    }
    
    public String getID_OBAT_DOKTER() {
        return ID_OBAT_DOKTER;
    }
    
    public void setID_OBAT_DOKTER(String ID_OBAT_DOKTER) {
        this.ID_OBAT_DOKTER = ID_OBAT_DOKTER;
    }
     
    
}
