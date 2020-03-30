/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tugas.help.DBConnect;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TambahController implements Initializable {

    @FXML
    private Circle myCircle1;
    @FXML
    private TextField txtIdBarang;
    @FXML
    private TextField txtKategori;
    @FXML
    private TextField txtJumlah;
    @FXML
    private TextArea txtKeterangan;
    @FXML
    private TextField txtNama;
    @FXML
    private ComboBox<String> cmbLokasi;
    @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox<String> cmbKondisi;
    @FXML
    private DatePicker dtpTanggal;
    @FXML
    private ComboBox<String> cmbJenis;
    @FXML
    private JFXButton btnSimpan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> itemKondisi = FXCollections.observableArrayList(
            "Baik",
            "Rusak"
        );
        
        ObservableList<String> itemJenis = FXCollections.observableArrayList(
            "Barang Tetap",
            "Barang Untuk Dipinjam"
        );
        
        ObservableList<String> itemLokasi = FXCollections.observableArrayList(
            "TU",
            "Ruang Guru",
            "Dll"
        );
        
        
        cmbKondisi.getItems().removeAll(cmbKondisi.getItems());
        cmbKondisi.getItems().addAll(itemKondisi);
        
        cmbJenis.getItems().removeAll(cmbJenis.getItems());
        cmbJenis.getItems().addAll(itemJenis);
        
        cmbLokasi.getItems().removeAll(cmbLokasi.getItems());
        cmbLokasi.getItems().addAll(itemLokasi);
        
    }    

    @FXML
    private void simpanBarang(ActionEvent event) throws IOException {
        Connection connection = DBConnect.getKoneksi("localhost", "3306", "root", "", "db_sma");
        
        try {
            String id = txtIdBarang.getText();
            String namaBarang = txtNama.getText();
            String kategori = txtKategori.getText();
            String jmlBarang = txtJumlah.getText();
            String harga = txtHarga.getText();
            LocalDate tanggal = dtpTanggal.getValue();
            String kondisi = cmbKondisi.getSelectionModel().getSelectedItem(); 
            String jenis = cmbJenis.getSelectionModel().getSelectedItem(); 
            String lokasi = cmbLokasi.getSelectionModel().getSelectedItem();
            String Keterangan = txtKeterangan.getText();
            
            if(id.equals(null)){
                Statement statement = connection.createStatement();
            
                String query = "INSERT INTO t_assets("
                        + "id_assets,nama_barang,jmlh_barang,lokasi_barang,jenis,kategori,harga,kondisi,tanggal_terima,keterangan,foto) " 
                        +"VALUES('"+id+"','"+namaBarang+"','"+jmlBarang+"','"+lokasi+"','"+jenis+"','"+kategori+"','"+harga+"','"+kondisi+"','"+tanggal+"','"+Keterangan+"','"+"-"+"')";

                int status = statement.executeUpdate(query);

                if(status > 0){
                    System.out.println("Barang Berhasil Ditambah");
                    JOptionPane.showMessageDialog(null, "Barang Berhasil Ditambah");
                    Parent root =   FXMLLoader.load(getClass().getResource("/tugas/View/v_tambah.fxml"));

                    Node node = (Node) event.getSource();

                    Stage stage = (Stage) node.getScene().getWindow();

                    stage.setScene(new Scene(root));
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Input Data Dengan Benar!!!");
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
