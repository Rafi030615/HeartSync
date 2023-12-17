package app.tubespbo;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public abstract class AccountAbstract implements AccountInterface {
    @FXML
    protected TextField usernameField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected RadioButton heartfriendRadioButton;

    @FXML
    protected RadioButton clientRadioButton;

    protected ToggleGroup toggleGroup;

    protected abstract void additionalInitialization();

    @FXML
    @Override
    public void initialize(){
        // Inisialisasi ToggleGroup
        toggleGroup = new ToggleGroup();

        // Hubungkan RadioButton dengan ToggleGroup
        heartfriendRadioButton.setToggleGroup(toggleGroup);
        clientRadioButton.setToggleGroup(toggleGroup);

        // Pilih default RadioButton (jika perlu)
        clientRadioButton.setSelected(true);
        additionalInitialization();
    }
}
