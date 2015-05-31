/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import trias.klinika.api.entitas.LaporanKeuanganDokterEntitas;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Satria
 */
public class TabelLaporanKeuanganDokter extends AbstractTableModel{
   List<LaporanKeuanganDokterEntitas> list = new ArrayList<LaporanKeuanganDokterEntitas>();
   public TabelLaporanKeuanganDokter (){
   }
   public LaporanKeuanganDokterEntitas get (int row){
        return list.get(row);
   }
   public void setData (List<LaporanKeuanganDokterEntitas>list){
        this.list = list;
        fireTableDataChanged();
    }
   @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "Nomor ID Pemeriksaan";
            case 1:
                return "Tanggal Pemeriksaan";
            case 2:
                return "Nama Pasien";
            case 3:
                return "Jumlah Pemasukkan";
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
        return 8;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
//        switch (columnIndex){
//            case 0:
//                return list.get(rowIndex).getID_PEMERIKSAAN();
//            case 1:
//                return list.get(rowIndex).getTGL_PEMERIKSAAN();
//            case 2:
//                return list.get(rowIndex).getNAMA_PASIEN();
//            case 3:
//                return list.get(rowIndex).getJUMLAH_PEMASUKKAN();
//            default:
//                return null;
//        
//        }
    return null;
    }
}

