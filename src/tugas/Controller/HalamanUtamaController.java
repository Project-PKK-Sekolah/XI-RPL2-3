/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.Controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Roshan
 */
public class HalamanUtamaController implements Initializable {
    
    @FXML
    private AnchorPane paneslide;

    @FXML
    private JFXButton bar2;

    @FXML
    private JFXButton bar1;
    
    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;
    
    @FXML
    private Circle myCircle1;
    
    @FXML
    private Circle myCircle2;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // TODO
       paneslide.setTranslateX(-222);
       bar1.setVisible(true);
       bar2.setVisible(false);
       
        myCircle1.setStroke(Color.BLACK);
        Image img1 = new Image("/tugas/Controller/profil.jpg", false);
        myCircle1.setFill(new ImagePattern(img1));
        
        myCircle2.setStroke(Color.BLACK);
        Image img2 = new Image("/tugas/Controller/profil.jpg", false);
        myCircle2.setFill(new ImagePattern(img2));
       
    } 

    @FXML
    private void run2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(paneslide);
        
        slide.setToX(-222);
        slide.play();
        
        paneslide.setTranslateX(0);
        
        slide.setOnFinished((ActionEvent e)->{
            bar1.setVisible(true);
            bar2.setVisible(false);
            btn1.setVisible(true);
            btn2.setVisible(true);
        });
    }

    @FXML
    private void run1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(paneslide);
        
        slide.setToX(0);
        slide.play();
        
        paneslide.setTranslateX(-222);
        
        slide.setOnFinished((ActionEvent e)->{
            bar1.setVisible(false);
            bar2.setVisible(true);
            btn1.setVisible(false);
            btn2.setVisible(false);
        });
    }
}
