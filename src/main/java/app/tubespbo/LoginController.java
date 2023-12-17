package app.tubespbo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController extends AccountAbstract{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton psikologRadioButton;

    @FXML
    private void loginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = psikologRadioButton.isSelected() ? "Psikolog" : "Client";

        if (validateLogin(username, password, role)) {
            showSuccessAlert();
            if ("Psikolog".equals(role)) {
                showPsikologView(usernameField.getScene().getWindow());
            } else {
                showClientView(usernameField.getScene().getWindow());
            }
        } else {
            showErrorAlert();
        }
    }

    private boolean validateLogin(String username, String password, String role) {
        try {
            BufferedReader bufferedReader;
            if ("Psikolog".equals(role)) {
                bufferedReader = new BufferedReader(new FileReader("psikolog.txt"));
            } else {
                bufferedReader = new BufferedReader(new FileReader("client.txt"));
            }

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password) && data[2].equals(role)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("Selamat datang, " + usernameField.getText() + "!");
        alert.showAndWait();
    }

    private void showErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText("Username atau Password salah. Silahkan Coba Lagi.");
        alert.showAndWait();
    }

    @FXML
    private void registerButtonClicked(ActionEvent event) {
        // Panggil metode untuk pindah ke tampilan registrasi
        showRegistrationView(usernameField.getScene().getWindow());
    }

    private void showRegistrationView(Window owner) {
        try {
            // Load FXML untuk tampilan registrasi
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setTitle("Registration Form");
            registrationStage.setScene(new Scene(loader.load()));

            // Menutup tampilan login sebelum menampilkan tampilan registrasi
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Menampilkan tampilan registrasi
            registrationStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPsikologView(Window psikolog) {
        try {
            // Load FXML untuk tampilan registrasi
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Psikolog.fxml"));
            Stage psikologStage = new Stage();
            psikologStage.setTitle("Menu Psikolog");
            psikologStage.setScene(new Scene(loader.load()));
            psikologStage.initOwner(psikolog);
            PsikologController psikologController = loader.<PsikologController>getController();
            psikologController.displayname(usernameField.getText());
            // Menutup tampilan login sebelum menampilkan tampilan registrasi
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Menampilkan tampilan registrasi
            psikologStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showClientView(Window client) {
        try {
            // Load FXML untuk tampilan registrasi
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Stage clientStage = new Stage();
            clientStage.setTitle("Menu Client");
            clientStage.setScene(new Scene(loader.load()));
            clientStage.initOwner(client);
            ClientController clientController = loader.<ClientController>getController();
            clientController.displayname(usernameField.getText());
            // Menutup tampilan login sebelum menampilkan tampilan registrasi
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Menampilkan tampilan registrasi
            clientStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    @Override
    protected void additionalInitialization(){
    }

}


