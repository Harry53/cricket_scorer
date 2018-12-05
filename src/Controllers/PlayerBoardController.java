/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author harish
 */
public class PlayerBoardController implements Initializable {

    @FXML
    private JFXListView<HBox> Listview_team1;

    @FXML
    private JFXListView<HBox> Listview_team2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        PlayerListA();
        PlayerListB();
    }    
    
    public void PlayerListA()
    {
        for (int i = 0; i < 11; i++) {
            try {
                //Label lbl = new Label("Item" + i);
                JFXCheckBox JF = new JFXCheckBox("Player: " + i);
                JFXComboBox<String> JC = new JFXComboBox<>();
                JC.setValue("Player Type");
                JC.getItems().addAll("Batsman", "Allrounder", "Bowler");
                //JF.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\harap\\Documents\\NetBeansProjects\\Cricket_Lover\\src\\Images\\Smiley.png"))));
//                JF.setPadding(new Insets(10));
//                JC.setPadding(new Insets(10));
                VBox vBox = new VBox(JF);
                VBox vBox2 = new VBox();
                vBox2.getChildren().add(JC);
                vBox.setPadding(new Insets(10));
                vBox2.setPadding(new Insets(10));
                HBox hBox = new HBox(vBox, vBox2);
                Listview_team1.getItems().add(hBox);
                JF.setOnAction((event) -> {
                    boolean selected = JF.isSelected();
                    String data = JF.getText();
                    System.out.println("CheckBox Action (selected: " + data + ")");
                });
                JC.setOnAction((event) -> {
                    String selectedItem = JC.getSelectionModel().getSelectedItem();
                    System.out.println("ComboBox Action (selected: " + selectedItem.toString() + ")");
                });
            } catch (Exception ex) {
            }
        }
    }
    
    public void PlayerListB()
    {
        for (int i = 0; i < 11; i++) {
            try {
                //Label lbl = new Label("Item" + i);
                JFXCheckBox JF = new JFXCheckBox("Player: " + i);
                JFXComboBox<String> JC = new JFXComboBox<>();
                JC.setValue("Player Type");
                JC.getItems().addAll("Batsman", "Allrounder", "Bowler");
                //JF.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\harap\\Documents\\NetBeansProjects\\Cricket_Lover\\src\\Images\\Smiley.png"))));
//                JF.setPadding(new Insets(10));
//                JC.setPadding(new Insets(10));
                VBox vBox = new VBox(JF);
                VBox vBox2 = new VBox();
                vBox2.getChildren().add(JC);
                vBox.setPadding(new Insets(10));
                vBox2.setPadding(new Insets(10));
                HBox hBox = new HBox(vBox, vBox2);
                Listview_team2.getItems().add(hBox);
                JF.setOnAction((event) -> {
                    boolean selected = JF.isSelected();
                    String data = JF.getText();
                    System.out.println("CheckBox Action (selected: " + data + ")");
                });
                JC.setOnAction((event) -> {
                    String selectedItem = JC.getSelectionModel().getSelectedItem();
                    System.out.println("ComboBox Action (selected: " + selectedItem.toString() + ")");
                });
            } catch (Exception ex) {
            }
        }
    }
}
