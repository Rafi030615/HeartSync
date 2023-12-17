package app.tubespbo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Window;

import java.io.*;
import java.time.LocalDate;

public class HomeController {

    private String username;

    @FXML
    private Button RegistrationButton;

    @FXML
    private void registerButtonClicked(ActionEvent event) {
        // Panggil metode untuk pindah ke tampilan registrasi
        showRegistrationView(RegistrationButton.getScene().getWindow());
    }

    private void showRegistrationView(Window owner) {
        try {
            // Load FXML untuk tampilan registrasi
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setTitle("Registration Form");
            registrationStage.setScene(new Scene(loader.load()));

            // Menutup tampilan login sebelum menampilkan tampilan registrasi
            Stage loginStage = (Stage) RegistrationButton.getScene().getWindow();
            loginStage.close();

            // Menampilkan tampilan registrasi
            registrationStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
