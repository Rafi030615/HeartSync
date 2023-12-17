package app.tubespbo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController extends AccountAbstract{
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton heartfriendRadioButton;
    @FXML
    private RadioButton clientRadioButton;
    private ToggleGroup toggleGroup;

    @FXML
    private void registerButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = heartfriendRadioButton.isSelected() ? "heartfriend" : "Client";

        User newUser = new User(username, password, role);
        // Menutup tampilan registrasi
        ((Stage) usernameField.getScene().getWindow()).close();
        saveUserToFile(newUser);
        showLoginView(usernameField.getScene().getWindow());
    }
    @FXML
    private void loginButtonClicked(ActionEvent event) {
        ((Stage) usernameField.getScene().getWindow()).close();
        showLoginView(usernameField.getScene().getWindow());
    }

    private void saveUserToFile(User user) {
        try {
            FileWriter fileWriter;
            if ("heartfriend".equals(user.getRole())) {
                fileWriter = new FileWriter("heartfriend.txt", true);
            } else {
                fileWriter = new FileWriter("client.txt", true);
            }

            fileWriter.write(user.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginView(Window owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            LoginController loginController = loader.<LoginController>getController();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login Form");
            loginStage.setScene(new Scene(root));
            loginStage.initOwner(owner);
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    @Override
    protected void additionalInitialization(){
    }

}

