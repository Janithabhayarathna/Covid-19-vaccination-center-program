package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptController {

    @FXML
    private Label fname2;

    @FXML
    private Button close;

    @FXML
    private Label sname2;

    @FXML
    private Label age2;

    @FXML
    private Label city2;

    @FXML
    private Label nic2;

    @FXML
    private Label vaccine2;

    @FXML
    private Label date;

    @FXML
    private Label time;

    @FXML
    private Label booth2;

    public void func_close() {
        //Function to the close button
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void displayInfo(String fname, String sname, String nic, String age, String city, String booth) {
        //Function to pass the entered values to the relevant labels of the receipt
        fname2.setText(fname);
        sname2.setText(sname);
        nic2.setText(nic);
        age2.setText(age);
        city2.setText(city);
        booth2.setText(booth);
    }

    public void displayVaccine(String vaccine) {

        vaccine2.setText(vaccine);
    }

    public void displayDate() {
        //To display the date
        //Referenced from: https://youtu.be/6cp4P4XZ9hE

        Date day = new Date();
        SimpleDateFormat currentTime = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(currentTime.format(day));
    }

    public void displayTime() {
        //To display the time
        //Referenced from: https://youtu.be/6cp4P4XZ9hE

        Date day = new Date();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm");
        time.setText(currentTime.format(day));
    }

}
