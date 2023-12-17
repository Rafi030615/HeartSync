package app.tubespbo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.time.LocalDate;

public class HeartfriendController {

    @FXML
    private TextField temanField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField priceField;

    @FXML
    Label usernameLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button signoutButton;

    @FXML
    private Button deleteButton;

    @FXML
    private DatePicker schedulePicker;


    @FXML
    private TableView<Counseling> counselingTableView;

    @FXML
    private TableColumn<Counseling, String> scheduleColumn;

    @FXML
    private TableColumn<Counseling, String> locationColumn;

    @FXML
    private TableColumn<Counseling, Double> priceColumn;

    @FXML
    private TableColumn<Counseling, String> temanColumn;

    @FXML
    private TableColumn<Counseling, String> curhatColumn;

    @FXML
    private TableColumn<Counseling, String> statusColumn;

    private ObservableList<Counseling> counselingList = FXCollections.observableArrayList();

    private String username;


    @FXML
    public void displayname(String username){
        usernameLabel.setText(username);
    }

    @FXML
    private void initialize() {
        // Inisialisasi tampilan dan data
        counselingTableView.setItems(counselingList);

        // Menghubungkan kolom dengan properti dalam kelas Counseling
        scheduleColumn.setCellValueFactory(new PropertyValueFactory<>("schedule"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        temanColumn.setCellValueFactory(new PropertyValueFactory<>("teman"));
        curhatColumn.setCellValueFactory(new PropertyValueFactory<>("curhat"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadCounselingData();  // Memuat data dari file
    }



    @FXML
    private void updateButtonClicked() {
        Counseling selectedCounseling = counselingTableView.getSelectionModel().getSelectedItem();

        if (selectedCounseling != null) {
            // Implementasi logika pembaruan
            selectedCounseling.setPrice(Double.parseDouble(priceField.getText()));
            selectedCounseling.setTeman(temanField.getText());
            selectedCounseling.setStatus("Diambil");
            counselingTableView.refresh();
            saveCounselingData();  // Menyimpan data ke file
            clearFields();
        }
    }

    @FXML
    private void deleteButtonClicked() {
        Counseling selectedCounseling = counselingTableView.getSelectionModel().getSelectedItem();

        if (selectedCounseling != null) {
            counselingList.remove(selectedCounseling);
            saveCounselingData();  // Menyimpan data ke file
            clearFields();
        }
    }

    private void loadCounselingData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("counseling.txt"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                LocalDate schedule = LocalDate.parse(data[0]);
                String location = data[1];
                double price = Double.parseDouble(data[2]);
                String teman = data[3];
                String curhat = data[4];
                String status = data[5];


                Counseling counseling = new Counseling(schedule, location, price, teman, curhat, status);
                counselingList.add(counseling);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCounselingData() {
        try {
            FileWriter fileWriter = new FileWriter("counseling.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Counseling counseling : counselingList) {
                String line = counseling.getSchedule() + "," +
                        counseling.getLocation() + "," +
                        counseling.getPrice()+ "," +
                        counseling.getTeman()+ "," +
                        counseling.getCurhat()+ "," +
                        counseling.getStatus();

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void signoutButtonClicked(ActionEvent event) {
        ((Stage) usernameLabel.getScene().getWindow()).close();
        showLoginView(usernameLabel.getScene().getWindow());
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


    private void clearFields() {
        locationField.clear();
        priceField.clear();
    }
}
