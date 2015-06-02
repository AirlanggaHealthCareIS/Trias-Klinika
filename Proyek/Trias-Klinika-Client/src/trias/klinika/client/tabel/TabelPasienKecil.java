/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.entitas.EntitasPendaftaran;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.LaporanKeuanganDokterEntitas;

/**
 *
 * @author Satria
 */
public class TabelPasienKecil extends AbstractTableModel{
    List<EntitasPendaftaran> list = new ArrayList<EntitasPendaftaran>();
   public TabelPasienKecil (){
   }
   public EntitasPendaftaran get (int row){
        return list.get(row);
   }
   public void insert (EntitasPendaftaran EP){
        list.add(EP);
        fireTableDataChanged();
    }
   public void setData (List<EntitasPendaftaran>list){
        this.list = list;
        fireTableDataChanged();
    }
   @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "Nama Pasien";
            case 1:
                return "Alamat Pasien";
            default :
                return null;
        }
    }
     @Override
    public int getRowCount(){
        return list.size();
    }
    @Override
    public int getColumnCount(){
        return 2;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getNAMA_PASIEN();
            case 1:
                return list.get(rowIndex).getALAMAT_PASIEN();
            default:
                return null;
        
        }
    }
}
