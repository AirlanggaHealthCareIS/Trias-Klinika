/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.rekammedisEntyty;

/**
 *
 * @author Acer
 */
public class tabelrekammedis extends AbstractTableModel {
     private List<rekammedisEntyty> list = new ArrayList<rekammedisEntyty>(); 
    
    public tabelrekammedis(){
        
    }
    public rekammedisEntyty get(int row){
        return list.get(row);
    }
    public void insert (rekammedisEntyty RM){
        list.add(RM);
        fireTableDataChanged();
    }
    public void setData(List<rekammedisEntyty> list) {
        this.list = list;
        fireTableDataChanged();
    }
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Id";
            case 1:
                return "Tanggal";
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getId_rekam();
            case 1:
                return list.get(rowIndex).getTanggal();
            default:
                return null;
        }
    }
    
    
}
