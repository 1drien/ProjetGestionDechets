/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.iagestiondechets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author phoenix
 */
public class RegisterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("main");
    }
    
        
    @FXML
    private void Login() throws IOException {
        App.setRoot("login");
    }  
    
    
    @FXML
    private void Userdashboard() throws IOException {
        App.setRoot("userdashboard");
    }  
 
   
}
