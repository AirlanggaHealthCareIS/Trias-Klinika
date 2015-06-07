/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.LaporanDataObatKeluarEntitas;

/**
 *
 * @author Sahirul
 */

public class TabelLaporanDataObatKeluar extends AbstractTableModel{
    List<LaporanDataObatKeluarEntitas> list = new ArrayList<LaporanDataObatKeluarEntitas>();
    public LaporanDataObatKeluarEntitas get (int row){
        return list.get(row);
    }
    public void setData (List<LaporanDataObatKeluarEntitas>list){
        this.list = list;
        fireTableDataChanged();
    }
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "Tanggal Pemeriksaan";
            case 1:
                return "Kode Obat";
            case 2:
                return "Nama Obat";
            case 3:
                return "Jumlah Obat";
            case 4:
                return "ID Pemeriksaan";
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
        return 5;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
       switch (columnIndex){
            case 0:
                return list.get(rowIndex).getTGL_PEMERIKSAAN();
            case 1:
                return list.get(rowIndex).getKODE_OBAT();
            case 2:
                return list.get(rowIndex).getNAMA_OBAT();
            case 3:
                return list.get(rowIndex).getJUMLAH_OBAT();
            case 4:
                return list.get(rowIndex).getID_PEMERIKSAAN();
            default:
                return null;
        
        }
   
    }

}
