
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
    
    public void insert (Dokter Dok){
        list.add(Dok);
        fireTableDataChanged();
    }
    
    public void delete (Dokter Dok) {
        int indek = 0;
        for (int i=0;i<list.size();i++) {
            if (Dok.getid_dokter().equals(list.get(i).getid_dokter())) {
                indek = i;
            }
        }
        list.remove(indek);
        fireTableDataChanged();
    } 
    
    public List<Dokter> getDataDokter(){
    return list;
}
    
    public String getColumnName(int column){
        switch (column){
            case 0 :return "id dokter";
            case 1 :return "nama dokter";
            case 2 :return "status dokter";
            default:return null;
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
                return list.get(rowIndex).getid_dokter();
            case 1:
                return list.get(rowIndex).getnama_dokter();
            case 2:
                return list.get(rowIndex).getstatus_dokter_strink();
            default:return null;
        }
    }
    
    
    
}