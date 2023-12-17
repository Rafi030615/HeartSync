package app.tubespbo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PaymentController {

    @FXML
    private Label clientNameLabel;

    @FXML
    private Label psikologNameLabel;

    @FXML
    private Label jadwalLabel;

    @FXML
    private Label lokasiLabel;

    @FXML
    private Label hargaLabel;


    public void setPaymentInfo(Counseling selectedCounseling) {
        // Set data pembayaran ke label-label di tampilan
        clientNameLabel.setText(selectedCounseling.getCurhat());
        psikologNameLabel.setText(selectedCounseling.getTeman());
        jadwalLabel.setText("" + selectedCounseling.getSchedule());
        lokasiLabel.setText(selectedCounseling.getLocation());
        hargaLabel.setText("Rp." + selectedCounseling.getPrice());
    }
}

