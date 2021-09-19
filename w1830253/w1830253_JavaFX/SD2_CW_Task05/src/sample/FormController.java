package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class FormController {

    @FXML
    private TextField fname;

    @FXML
    private TextField sname;

    @FXML
    private TextField nic;

    @FXML
    private TextField age;

    @FXML
    private TextField city;

    @FXML
    public RadioButton astra;

    @FXML
    private RadioButton sino;

    @FXML
    private RadioButton pfizer;

    @FXML
    private TextField booth;

    @FXML
    private Button receipt;

    @FXML
    public void go_receipt(ActionEvent event) throws IOException {
        //Loading the 'Receipt' fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
        Stage stage = (Stage) receipt.getScene().getWindow();
        stage.close();
        Parent root = loader.load();
        ReceiptController sceneReceiptController = loader.getController();
        sceneReceiptController.displayInfo(fname.getText(), sname.getText(), nic.getText(), age.getText(), city.getText(), booth.getText());
        stage.setScene(new Scene(root));
        stage.setTitle("Patient Receipt");
        stage.show();
        if (astra.isSelected()) {
            sceneReceiptController.displayVaccine(astra.getText());
        }else if (sino.isSelected()) {
            sceneReceiptController.displayVaccine(sino.getText());
        }else {
            sceneReceiptController.displayVaccine(pfizer.getText());
        }
        sceneReceiptController.displayDate();
        sceneReceiptController.displayTime();
    }

}

