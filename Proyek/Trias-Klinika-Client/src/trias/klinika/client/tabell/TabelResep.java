package trias.klinika.client.tabell;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.ResepEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TabelResep extends AbstractTableModel {
    private List<ResepEntity> list = new ArrayList<ResepEntity>(); 
    
    public TabelResep(){
        
    }
    public ResepEntity get(int row){
        return list.get(row);
    }
    public void insert (ResepEntity RE){
        list.add(RE);
        fireTableDataChanged();
    }
  
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "No";
            case 1:
                return "ID_obat";
            case 2:
                return "nama_obat";
            case 3:
                return "jumlah_terpenuhi";
            case 4:
                return "satuan_jenis";
            case 5:
                return "harga";
            case 6:
                return "keterangan";
            default :
                return null;
        }
    }

   
    public int getRowCount() {
       return list.size();
        
    }

    
    public int getColumnCount() {
        return 7;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getNO();
            case 1:
                return list.get(rowIndex).getID_obat();
            case 2:
                return list.get(rowIndex).getnama_obat();
            case 3:
                return list.get(rowIndex).getjumlah_terpenuhi();
            case 4:
                return list.get(rowIndex).getsatuan_jenis();
            case 5:
                return list.get(rowIndex).getharga();
            case 6:
                return list.get(rowIndex).getketarangan();
            default:
                return null;
        }
}

    @Override
    public void fireTableDataChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[] jComboBox1(String[] i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
