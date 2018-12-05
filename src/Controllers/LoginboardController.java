/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author harish
 */
public class LoginboardController implements Initializable {

    @FXML
    private JFXComboBox<String> txt_comboAction;

    @FXML
    private JFXPasswordField txt_password;

    @FXML
    private JFXTextField txt_username;

    ObservableList<String> list = FXCollections.observableArrayList(
            "Super Admin", "Normal Admin", "Manager");

    @FXML
    void comboAction(ActionEvent event) {
        txt_username.setText(txt_comboAction.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_comboAction.setItems(list);
    }

}
