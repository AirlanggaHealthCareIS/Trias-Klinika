/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.InventoriObatDokterEntitas;

/**
 *
 * @author iqbal
 */
public class tabelinventoriobtdokter extends AbstractTableModel {
    private List<InventoriObatDokterEntitas> list = new ArrayList<InventoriObatDokterEntitas>(); 
    
    public tabelinventoriobtdokter(){
        
    }
    public InventoriObatDokterEntitas get(int row){
        return list.get(row);
    }
    public void insert (InventoriObatDokterEntitas IOD){
        list.add(IOD);
        fireTableDataChanged();
    }
    public void setData(List<InventoriObatDokterEntitas> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Nama Obat";
            case 1:
                return "Jenis Obat";
            case 2:
                return "Kuantiti Obat";
            case 3:
                return "Harga Obat";
            case 4:
                return "Tanggal masuk";
            case 5:
                return "Masa Pakai";
            case 6:
                return "Deskripsi";
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getnamaobat();
            case 1:
                return list.get(rowIndex).getjenisobat();
            case 2:
                return list.get(rowIndex).getkuantitiobat();
            case 3:
                return list.get(rowIndex).gethargaobat();
            case 4:
                return list.get(rowIndex).gettglmasuk();
            case 5:
                return list.get(rowIndex).getmasapakai();
            case 6:
                return list.get(rowIndex).deskripsi();
            default:
                return null;
        }
    }
}
