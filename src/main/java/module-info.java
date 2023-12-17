module app.tubespbo {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.tubespbo to javafx.fxml;
    exports app.tubespbo;
}