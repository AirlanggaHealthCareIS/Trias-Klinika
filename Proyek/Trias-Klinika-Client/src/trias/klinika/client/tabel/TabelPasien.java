
package trias.klinika.client.tabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.PemeriksaanEntitas;

/**
 *
 * @author IMIN
 */
public class TabelPasien extends AbstractTableModel{
    private List<PemeriksaanEntitas> list = new ArrayList<PemeriksaanEntitas>(); 
    
    public TabelPasien(){
        
    }
    public PemeriksaanEntitas get(int row){
        return list.get(row);
    }
    
    public void setData(List<PemeriksaanEntitas> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert (PemeriksaanEntitas Pas){
        list.add(Pas);
        fireTableDataChanged();
    }
    
    public String getColumnName(int column){
        switch (column){
            case 0 :return "No antrean";
            case 1 :return "ID pasien";
            case 2 :return "ID dokter";
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
                return list.get(rowIndex).getNO_ANTRIAN();
            case 1:
                return list.get(rowIndex).getID_PASIEN();
            case 2:
                return list.get(rowIndex).getID_DOKTER();
            default:return null;
        }
    }

    
}
