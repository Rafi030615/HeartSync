package app.tubespbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        showHomeView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showHomeView(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showRegistrationView(Stage primaryStage) throws Exception {
        Stage registrationStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        registrationStage.setTitle("Registration Form");
        registrationStage.setScene(new Scene(root));
        registrationStage.show();
    }

    public void showLoginView(Window owner) throws Exception {
        Stage loginStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        loginStage.setTitle("Login Form");
        loginStage.setScene(new Scene(root));
        loginStage.initOwner(owner);
        loginStage.show();
    }

    public void showHeartfriendView(Window heartfriend) throws Exception {
        Stage heartfriendStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Heartfriend.fxml"));
        heartfriendStage.setTitle("Menu Heartfriend");
        heartfriendStage.setScene(new Scene(root));
        heartfriendStage.initOwner(heartfriend);
        heartfriendStage.show();
    }

    public void showClientView(Window client) throws Exception {
        Stage clientStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        clientStage.setTitle("Menu client");
        clientStage.setScene(new Scene(root));
        clientStage.initOwner(client);
        clientStage.show();
    }
}

