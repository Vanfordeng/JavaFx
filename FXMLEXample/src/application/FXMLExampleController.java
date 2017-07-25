/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author Doctor
 */
public class FXMLExampleController implements Initializable {
    
    @FXML
    private Text actiontarget;
    
    @FXML
    private Button button;
    
    
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
       actiontarget.setText("Sign in button pressed");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
