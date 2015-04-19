 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.LaporanKeuanganApotekEntitas;

/**
 *
 * @author iqbal
 */
public class TabelLaporanKeuanganApotek extends AbstractTableModel {
    private List<LaporanKeuanganApotekEntitas> list = new ArrayList<LaporanKeuanganApotekEntitas>(); 
    
    public TabelLaporanKeuanganApotek(){
        
    }
    public LaporanKeuanganApotekEntitas get(int row){
        return list.get(row);
    }
    public void insert (LaporanKeuanganApotekEntitas LKAE){
       list.add(LKAE);
       fireTableDataChanged();
    }
    public void setData(List<LaporanKeuanganApotekEntitas> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "TGL_PEMERIKSAAN";
            case 1:
                return "ID_RESEP";
            case 2:
                return "ID_APOTEK";
            case 3:
                return "TOTAL_HARGA";
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getTGL_PEMERIKSAAN();
            case 1:
                return list.get(rowIndex).getID_RESEP();
            case 2:
                return list.get(rowIndex).getID_APOTEK();
            case 3:
                return list.get(rowIndex).getTOTAL_HARGA();
            default :
                return null;
   
                
        }
    }
}
