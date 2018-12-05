/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author harish
 */
public class TestingController implements Initializable {

    @FXML
    private JFXListView<HBox> list1_view;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXPopup Popup;
    @FXML
    private TableView<CustomImage> table1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initPopup();
        //Tabledata();
        for (int i = 0; i < 4; i++) {
            try {
                //Label lbl = new Label("Item" + i);
                JFXCheckBox JF = new JFXCheckBox("Player: " + i);
                JFXComboBox<String> JC = new JFXComboBox<String>();
                JC.setValue("Test");
                JC.getItems().addAll("Test", "Test2", "Test3");
                //JF.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\harap\\Documents\\NetBeansProjects\\Cricket_Lover\\src\\Images\\Smiley.png"))));
//                JF.setPadding(new Insets(10));
//                JC.setPadding(new Insets(10));
                VBox vBox = new VBox(JF);
                VBox vBox2 = new VBox();
                vBox2.getChildren().add(JC);
                vBox.setPadding(new Insets(10));
                vBox2.setPadding(new Insets(10));
                HBox hBox = new HBox(vBox, vBox2);
                list1_view.getItems().add(hBox);
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
        // 

    }

    @FXML
    private void load(ActionEvent event) {
        if (!list1_view.isExpanded()) {
            list1_view.setExpanded(true);
            list1_view.depthProperty().set(1);
        } else {
            list1_view.setExpanded(false);
            list1_view.depthProperty().set(0);
        }

    }

    public void Tabledata() {
        ObservableList<CustomImage> imgList = FXCollections.observableArrayList();
        CustomImage item_1 = new CustomImage(new ImageView(new Image("/Images/Smiley.png")), "hello");
        CustomImage item_2 = new CustomImage(new ImageView(new Image("/Images/Smiley.png")), "world");
        imgList.addAll(item_1, item_2);

        /* initialize and specify table column */
        TableColumn tcC1 = new TableColumn<>("Picture");
        tcC1.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcC1.setPrefWidth(130);//set this to what you prefer.

        TableColumn tcX = new TableColumn<>("Text");
        tcX.setCellValueFactory(new PropertyValueFactory<>("string"));

        /* add column to the tableview and set its items */
        table1.getColumns().add(tcC1);
        table1.getColumns().add(tcX);
        table1.setItems(imgList);
    }

    @FXML
    private void addNew(ActionEvent event) {
        //list1_view.getItems().add(new Label("Node I"));
    }

    private void initPopup() {
        JFXButton b1 = new JFXButton("Task 1");
        JFXButton b2 = new JFXButton("Task 2");
        JFXButton b3 = new JFXButton("Task 3");
        b1.setPadding(new Insets(10));
        b2.setPadding(new Insets(10));
        b3.setPadding(new Insets(10));
        VBox vBox = new VBox(b1, b2, b3);
        Popup.setPopupContent(vBox);
        Popup.setPopupContent(list1_view);

    }

    @FXML
    private void loadPopup(MouseEvent event) {
        Popup.show(list1_view, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, event.getX(), event.getY());

    }

    public class CustomImage {

        private ImageView image;
        private String string;

        CustomImage(ImageView img, String string) {
            this.image = img;
            this.string = string;
        }

        public void setImage(ImageView value) {
            image = value;
        }

        public ImageView getImage() {
            return image;
        }

        public void setSring(String string) {
            this.string = string;
        }

        public String getString() {
            return this.string;
        }
    }
}
