
package trias.klinika.client.tabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.Dokter;
import trias.klinika.api.entitas.PasienEntity;

/**
 *
 * @author IMIN
 */
public class TabelPasien extends AbstractTableModel{
    private List<PasienEntity> list = new ArrayList<PasienEntity>(); 
    
    public TabelPasien(){
        
    }
    public PasienEntity get(int row){
        return list.get(row);
    }
    
    public void setData(List<PasienEntity> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert (PasienEntity Pas){
        list.add(Pas);
        fireTableDataChanged();
    }
    
    public String getColumnName(int column){
        switch (column){
            case 0 :return "No antrean";
            case 1 :return "ID pasien";
            case 2 :return "Nama pasien";
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
                return list.get(rowIndex).getNO_ANTREAN();
            case 1:
                return list.get(rowIndex).getid_pasien();
            case 2:
                return list.get(rowIndex).getNama();
            default:return null;
        }
    }
    
    
}
