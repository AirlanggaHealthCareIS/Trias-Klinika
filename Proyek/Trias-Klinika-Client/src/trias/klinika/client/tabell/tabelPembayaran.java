/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabell;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.RincianPembayaran;

/**
 *
 * @author ICUN
 */
public class tabelPembayaran extends AbstractTableModel{
    private List<RincianPembayaran> list = new ArrayList<RincianPembayaran>(); 
    
    public tabelPembayaran(){
        
    }
    public RincianPembayaran get(int row){
        return list.get(row);
    }
    public void insert (RincianPembayaran RP){
        list.add(RP);
        fireTableDataChanged();
    }
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Tindakan";
            case 1:
                return "Biaya";
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
                return list.get(rowIndex).getNAMA_OBAT();
            case 1:
                return list.get(rowIndex).getHARGA_OBAT();
            default:
                return null;
        }
    }
    
    
    
}
