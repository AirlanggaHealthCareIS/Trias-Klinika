
package trias.klinika.client.tabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.Dokter;

/**
 *
 * @author IMIN
 */
public class TabelDokter extends AbstractTableModel{
    private List<Dokter> list = new ArrayList<Dokter>(); 
    
    public TabelDokter(){
        
    }
    public Dokter get(int row){
        return list.get(row);
    }
    
    public void setData(List<Dokter> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public String getColumnName(int column){
        switch (column){
            case 0 :return "nama dokter";
            default:return null;
        }
    }

    @Override
    public int getRowCount() {
       return list.size();
        
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getnama_dokter();
            default:return null;
        }
    }
    
    
    
}