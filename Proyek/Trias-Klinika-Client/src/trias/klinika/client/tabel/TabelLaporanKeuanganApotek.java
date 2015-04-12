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
    public void insert (LaporanKeuanganApotekEntitas IOD){
       list.add(IOD);
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
                return "NAMA_OBAT";
            case 2:
                return "ID_OBAT_KELUAR";
            case 3:
                return "JUMLAH_OBAT";
            case 4:
                return "HARGA_OBAT";
            case 5:
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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getTGL_PEMERIKSAAN();
            case 1:
                return list.get(rowIndex).getNAMA_OBAT();
            case 2:
                return list.get(rowIndex).getID_OBAT_KELUAR();
            case 3:
                return list.get(rowIndex).getJUMLAH_OBAT();
            case 4:
                return list.get(rowIndex).getHARGA_OBAT();
            case 5:
                return list.get(rowIndex).getTOTAL_HARGA();
            default:
                return null;
        }
    }
}
