package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ConfirmedSeatBooking {

    @FXML
    private Button homeButton;

    @FXML
    private Text selectedSeatNumber;
    
    @FXML
    private Text totalFare;

    @FXML
    private Text departureLocation;
    
    @FXML
    private Text departureDate;
    
    private Integer selectedBus;
    
    @FXML
    private Text bookingId;
    
    public Text getBookingId() {
    	return bookingId;
    }
    
    public List<CheckBox> selectedSeats = new ArrayList<>();
    
    public void setSelectedBus(Integer selectedBus) {
    	this.selectedBus = selectedBus;
    }
    
    public Text getSelectedSeatNumber() {
    	return selectedSeatNumber;
    }
    
    public Text getDepartureDate() {
    	return departureDate;
    }
    
    public Text getDepartureLocation() {
    	return departureLocation;
    }
    
    public Text getTotalFare() {
    	return totalFare;
    }

    @FXML
    void homeButtonAction(ActionEvent event) {

    	try {      
  	      FXMLLoader loader = new FXMLLoader(
	    		  getClass().getResource(
	    		    "Home.fxml"
	    		  )
	    		);
	      
	      Pane pane = loader.load();
	      
	      BorderPane border = Main.getRoot();
  	      border.setCenter(pane);      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
    }

 }
