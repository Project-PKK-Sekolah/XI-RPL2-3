/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tugas.help.DBConnect;

/**
 *
 * @author Roshan
 */
public class LoginController implements Initializable {
    
    
    @FXML 
    private TextField tf_username;
    
    @FXML
    private PasswordField pf_password;
    
    
    @FXML
     void sign_up(MouseEvent event) {
        Connection connection = DBConnect.getInstance().getKoneksi("localhost", "3306", "root", "", "");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
