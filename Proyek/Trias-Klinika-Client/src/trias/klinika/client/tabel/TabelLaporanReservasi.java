/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.laporan_keuangan_reservasiEntity;

/**
 *
 * @author Acer
 */
public class TabelLaporanReservasi extends AbstractTableModel {
    private List<laporan_keuangan_reservasiEntity> list = new ArrayList<laporan_keuangan_reservasiEntity>(); 
    
    public TabelLaporanReservasi(){
        
    }
    public laporan_keuangan_reservasiEntity get(int row){
        return list.get(row);
    }
    public void insert (laporan_keuangan_reservasiEntity LKR){
       list.add(LKR);
       fireTableDataChanged();
    }
    public void setData(List<laporan_keuangan_reservasiEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}