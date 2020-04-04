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
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import tugas.Main;
import tugas.help.DBConnect;
import tugas.model.tblGudangModel;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class GudangAdminController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Circle myCircle;
	
        
    private double xOffset;
    private double yOffset;
    
    @FXML
    private TableView<tblGudangModel> table;
    @FXML
    private TableColumn<tblGudangModel, String> col_id;
    @FXML
    private TableColumn<tblGudangModel, String> col_brand;
    @FXML
    private TableColumn<tblGudangModel, String> col_category;
    @FXML
    private TableColumn<tblGudangModel, String> col_qty;
    @FXML
    private TableColumn<tblGudangModel, String> col_uom;
    @FXML
    private TableColumn<tblGudangModel, String> col_price;
    @FXML
    private TableColumn<tblGudangModel, String> col_amount;
    
    ObservableList<tblGudangModel> oblist = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> col_date;
    @FXML
    private TableColumn<?, ?> col_action;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.moveAnchorPane();
                
        myCircle.setStroke(Color.WHITE);
        Image img1 = new Image("/tugas/css/profil.jpg", false);
        myCircle.setFill(new ImagePattern(img1));
        
        
        Connection koneksi = DBConnect.getKoneksi("localhost", "3306", "root", "", "db_sma");
        try{
            Statement stmt = (Statement) koneksi.createStatement();
            String query = "SELECT * FROM t_assets";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            
            while(rs.next()){
                oblist.add(new tblGudangModel(rs.getString("id_assets"),rs.getString("nama_barang"),rs.getString("kategori"),rs.getString("jmlh_barang"),"pcs",rs.getString("harga"),"-"));
                no++;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        col_uom.setCellValueFactory(new PropertyValueFactory<>("uom"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        table.setItems(oblist);
    }
    
    public void moveAnchorPane()
    {
		anchorPane.setOnMousePressed(event -> {
	            xOffset = Main.getPrimaryStage().getX() - event.getScreenX();
	            yOffset = Main.getPrimaryStage().getY() - event.getScreenY();
	            anchorPane.setCursor(Cursor.CLOSED_HAND);
	        });

		anchorPane.setOnMouseDragged(event -> {
			 Main.getPrimaryStage().setX(event.getScreenX() + xOffset);
			 Main.getPrimaryStage().setY(event.getScreenY() + yOffset);

	        });
		
		anchorPane.setOnMouseReleased(event -> {
			anchorPane.setCursor(Cursor.DEFAULT);
	        });
    }
	
    @FXML
    public void close(ActionEvent event) {
        Main.getPrimaryStage().close();
    }

	

    @FXML
    public void min(ActionEvent event) {
        Main.getPrimaryStage().setIconified(true);
    }    
    
}
