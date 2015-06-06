/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.ListPembayaranEntitas;

/**
 *
 * @author Sahirul
 */
public class TabelListPembayaran extends AbstractTableModel {
     private List<ListPembayaranEntitas> list = new ArrayList<ListPembayaranEntitas>();
    
     public TabelListPembayaran(){
        
    }
     public ListPembayaranEntitas get(int row){
        return list.get(row);
    }
     public void insert (ListPembayaranEntitas LPE){
        list.add(LPE);
        fireTableDataChanged();
     }
     public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
     public void setData(List<ListPembayaranEntitas> list) {
        this.list = list;
        fireTableDataChanged();
    }
     @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Nama Pasien";
            case 1:
                return "Nama Dokter";
            case 2:
                return "ID Pemeriksaan";
            default :
                return null;
        }
    }
    @Override
    public int getRowCount() {
       return list.size();
        
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getnamaPasien();
            case 1:
                return list.get(rowIndex).getnamaDokter();
            case 2:
                return list.get(rowIndex).getidPemeriksaan();
            default:
                return null;
        }
    }
                
                
}
