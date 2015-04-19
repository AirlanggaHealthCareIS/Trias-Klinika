/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.api.pesan;
import java.io.Serializable;

/**
 *
 * @author Faz
 */


public class pesan implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public String tipe, pengirim, isi, penerima;
    
    public pesan(String tipe, String pengirim, String isi, String penerima){
        this.tipe = tipe; this.pengirim = pengirim; this.isi = isi; this.penerima = penerima;
    }
    
    @Override
    public String toString(){
        return "{type='"+tipe+"', sender='"+pengirim+"', content='"+isi+"', recipient='"+penerima+"'}";
    }
}
