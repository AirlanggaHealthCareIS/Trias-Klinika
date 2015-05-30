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
public class TabelLaporanKeuanganReservasi extends AbstractTableModel{
    private List<laporan_keuangan_reservasiEntity> list = new ArrayList<laporan_keuangan_reservasiEntity>(); 
    
    public TabelLaporanKeuanganReservasi(){
        
    }
    public laporan_keuangan_reservasiEntity get(int row){
        return list.get(row);
    }
    public void insert (laporan_keuangan_reservasiEntity LKAE){
       list.add(LKAE);
       fireTableDataChanged();
    }
    public void setData(List<laporan_keuangan_reservasiEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
      return list.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "TGL_PEMERIKSAAN";
            case 1:
                return "ID_DOKTER";
            case 2:
                return "TOTAL_HARGA";
            default :
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex){
            case 0:
                return list.get(rowIndex).gettanggaal();
            case 1:
                return list.get(rowIndex).getid_dokter();
            case 2:
                return list.get(rowIndex).getjumlah();
            default :
                return null;
    }
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    
}
