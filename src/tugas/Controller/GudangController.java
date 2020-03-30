/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class GudangController implements Initializable {
    
    @FXML
    private Circle myCircle1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myCircle1.setStroke(Color.BLACK);
        Image img1 = new Image("/tugas/Controller/profil.jpg", false);
        myCircle1.setFill(new ImagePattern(img1));
    }    
    
}
