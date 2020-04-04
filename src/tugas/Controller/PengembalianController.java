/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tugas.help.DBConnect;
import tugas.model.tblPengembalianModel;

/**
 * FXML Controller class
 *
 * @author Fadillah
 */
public class PengembalianController implements Initializable {

    @FXML
    private TableView<tblPengembalianModel> table;
    @FXML
    private TextField inpIdTransaksi;
    @FXML
    private Button cari;
    @FXML
    private TableColumn<tblPengembalianModel, String> no;
    @FXML
    private TableColumn<tblPengembalianModel, String> nama_barang;
    @FXML
    private TableColumn<tblPengembalianModel, String> jml_barang;
    
    ObservableList<tblPengembalianModel> oblist = FXCollections.observableArrayList();
    
    @FXML
    private Button kembalikan;
    @FXML
    private Label lblIdTransaksi;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblStatus;
    @FXML
    private Label tglPinjam;
    @FXML
    private Label tglKembali;
    
    @FXML
    private AnchorPane form_data;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        form_data.setVisible(false);    
   }    

    @FXML
    private void cariID(ActionEvent event) {
        
        Connection koneksi = DBConnect.getKoneksi("localhost", "3306", "root", "", "db_sma");
        try{
            Statement stmt = (Statement) koneksi.createStatement();
            String query = "SELECT * FROM t_transaksi WHERE t_transaksi.id_transaksi = '" + inpIdTransaksi.getText() +"'";
            ResultSet rs = stmt.executeQuery(query);
            
            int no = 1;
            if(rs.next()){
                table.getItems().clear();
                oblist.add(new tblPengembalianModel(rs.getString("id_assets"),rs.getString("jmlh_pinjam") ));
                inpIdTransaksi.setText("");
                lblIdTransaksi.setText(rs.getString("id_transaksi"));
                lblUsername.setText(rs.getString("username"));
                lblStatus.setText(rs.getString("status"));
                no++;
                
                if(rs.getString("status").equals("Selesai")){
                    kembalikan.setVisible(false);
                }else{
                    kembalikan.setVisible(true);
                }
                    
            }
            
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        nama_barang.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        jml_barang.setCellValueFactory(new PropertyValueFactory<>("jmlh"));
        
        
        table.setItems(oblist);
        
        form_data.setVisible(true);
    }

    @FXML
    private void kembalikanBarang(ActionEvent event) {
        Connection koneksi = DBConnect.getKoneksi("localhost", "3306", "root", "", "db_sma");
        try{
            Statement stmt = (Statement) koneksi.createStatement();
            String query = "UPDATE t_transaksi SET status = 'Selesai'"+", tgl_kembali = '"+LocalDateTime.now()+"' WHERE id_transaksi = '" + lblIdTransaksi.getText()+"';";  
            stmt.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
}
