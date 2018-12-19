package application;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Cancel {

	@FXML // fx:id="BookButton"
	private Button ConfirmButton; // Value injected by FXMLLoader
	@FXML
	private Button BackButton;
	@FXML
	TextField tf;

	@FXML
	void ccancel(ActionEvent event) throws IOException {

		String s = tf.getText();
		System.out.println(s);

		BookingDto booking = Main.getPersistData().findBooking(s);

		if (booking != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmation.fxml"));

			Pane pane = loader.load();
			ConfirmationController confirmationController = loader.<ConfirmationController>getController();
			confirmationController.booking = booking;
			

			BorderPane border = Main.getRoot();
			border.setCenter(pane);

		} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Incorrect BookingID");
			errorAlert.showAndWait();
		}

	}

	@FXML
	void back(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));

		Pane pane = loader.load();

		BorderPane border = Main.getRoot();
		border.setCenter(pane);
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert ConfirmButton != null : "fx:id=\"CancelButton\" was not injected: check your FXML file 'Home.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'Home.fxml'.";
	}

}
