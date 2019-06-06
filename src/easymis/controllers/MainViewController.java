/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXToolbar;
import easymis.utils.Constants;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author RashidKP
 */
public class MainViewController implements Initializable {
    
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private JFXToolbar toolbar;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane contentPane;
    
    public static AnchorPane temporatyPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        temporatyPane = contentPane;
        initDrawer();
    }    
    
    private void initDrawer(){
        
        try {
            VBox menu = FXMLLoader.load(getClass().getResource(Constants.SIDE_MENU_VIEW));
            drawer.setSidePane(menu);
            drawer.setMinWidth(130);
            drawer.open();
            temporatyPane.getChildren().clear();
            StackPane stackPane = FXMLLoader.load(getClass().getResource(Constants.DASHBOARD_VIEW));
            ObservableList<Node> elements = stackPane.getChildren();
            temporatyPane.getChildren().setAll(elements);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
