/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.PelayananApotekEntitas;

/**
 *
 * @author TOSHIBA
 */

   
 
public class TabelPelayananApotek extends AbstractTableModel {
    private List<PelayananApotekEntitas> list = new ArrayList<PelayananApotekEntitas>(); 
    
    public TabelPelayananApotek(){
        
    }
    public PelayananApotekEntitas get(int row){
        return list.get(row);
    }
    public void insert (PelayananApotekEntitas PAE){
       list.add(PAE);
       fireTableDataChanged();
    }
    public void setData(List<PelayananApotekEntitas> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            
            case 0:
                return "ID_RESEP";
            case 1:
                return "NAMA_OBAT";
            case 2:
                return "HARGA_OBAT";
            
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
                return list.get(rowIndex).getID_RESEP();
            case 1:
                return list.get(rowIndex).getNAMA_OBAT();
            case 2:
                return list.get(rowIndex).getHARGA_OBAT();
            default :
                return null;
   
                
        }
    }
}
