package com.mycompany.iagestiondechets;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void Register() throws IOException {
        App.setRoot("register");
    }
    
    @FXML
    private void Login() throws IOException {
        App.setRoot("login");
    }
    
      @FXML
    private void Dashboard() throws IOException {
        App.setRoot("dashboard");
    }
    
       @FXML
    private void switchToMain() throws IOException {
        App.setRoot("main");
    }
    
     @FXML
    private void centreTri() throws IOException {
        App.setRoot("strash");
    }
    
      @FXML
    private void poubelle() throws IOException {
        App.setRoot("poubelle");
    }
    
   
}
