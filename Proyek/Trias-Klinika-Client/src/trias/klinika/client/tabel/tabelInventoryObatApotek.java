/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trias.klinika.client.tabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trias.klinika.api.entitas.InventoryObatApotekEntitas;

/**
 *
 * @author Azmil
 */
public class tabelInventoryObatApotek extends AbstractTableModel{
    private List<InventoryObatApotekEntitas> list = new ArrayList<InventoryObatApotekEntitas>();
    
    public tabelInventoryObatApotek(){
        
    }
    
    public InventoryObatApotekEntitas get (int row){
        return list.get(row);
    }
    public void insert (InventoryObatApotekEntitas inventory){
        list.add(inventory);
        fireTableDataChanged();
    }
    public void setData (List<InventoryObatApotekEntitas>list){
        this.list = list;
        fireTableDataChanged();
    }
    public void tambah (InventoryObatApotekEntitas inventory){
        list.add(inventory);
        fireTableDataChanged();
    }
    public void delete (InventoryObatApotekEntitas inventory){
//        int indek = 0;
//        for (int i=0;i<list.size();i++) {
//            if (Dok.getid_dokter().equals(list.get(i).getid_dokter())) {
//                indek = i;
//            }
//        }
//        list.remove(indek);
//        fireTableDataChanged();
    }
    public void update (InventoryObatApotekEntitas inventory){
        list.add(inventory);
        fireTableDataChanged();
    }
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "Nama Obat";
            case 1:
                return "Deskripsi";
            case 2:
                return "Harga";
            case 3:
                return "QTY";
            case 4:
                return "Tanggal Masuk";
            case 5:
                return "Masa Pakai";
            case 6:
                return "Jenis";
            case 7:
                return "Spesialis";
            default :
                return null;
        }
    }
    @Override
    public int getRowCount(){
        return list.size();
    }
    @Override
    public int getColumnCount(){
        return 8;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getNamaObat();
            case 1:
                return list.get(rowIndex).getDeskripsi();
            case 2:
                return list.get(rowIndex).getHargaObat();
            case 3:
                return list.get(rowIndex).getQty();
            case 4:
                return list.get(rowIndex).getTglMasuk();
            case 5:
                return list.get(rowIndex).getMasaPakai();
            case 6:
                return list.get(rowIndex).getJenisObat();
            case 7:
                return list.get(rowIndex).getNamaSpesialis();
            default:
                return null;
        
        }
    }
}
