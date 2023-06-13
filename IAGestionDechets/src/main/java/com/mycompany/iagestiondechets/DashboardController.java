package com.mycompany.iagestiondechets;

import java.io.IOException;
import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("main");
    }

    @FXML
    private void Strash() throws IOException {
        App.setRoot("strash");
    }

   
}
