package application;

import java.io.IOException;
import java.util.Random;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PaymentController {

	@FXML
    private Button backButton;

    @FXML
    private Button paynowButton;
    
    @FXML
    private Text selectedSeatNumber;
    
    @FXML
    private Text totalFare;

    @FXML
    private Text departureLocation;
    
    @FXML
    private Text departureDate;
    
    public Text cancellationID;
    
    private Integer selectedBus;
    
    public String newBookId;
    
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
    void backButtonAction(ActionEvent event) { 
    	try {      
  	      FXMLLoader loader = new FXMLLoader(
	    		  getClass().getResource(
	    		    "SeatSelection.fxml"
	    		  )
	    		);
	      
	      Pane pane = loader.load();   
	     
	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
	      seatSelectionController.setSelectedBus(selectedBus);
	      seatSelectionController.getSeat1().setSelected(selectedSeats.get(0).isSelected());
	      seatSelectionController.getSeat2().setSelected(selectedSeats.get(1).isSelected());
	      seatSelectionController.getSeat3().setSelected(selectedSeats.get(2).isSelected());
	      seatSelectionController.getSeat4().setSelected(selectedSeats.get(3).isSelected());
	      seatSelectionController.getSeat5().setSelected(selectedSeats.get(4).isSelected());
	      seatSelectionController.getSeat6().setSelected(selectedSeats.get(5).isSelected());
	      
	      BorderPane border = Main.getRoot();
  	      border.setCenter(pane);
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
    }

    @FXML
    String paynowButtonAction(ActionEvent event) {
    	
    	try {      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    		    "ConfirmedSeatBooking.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   
    	     
    	      ConfirmedSeatBooking confirmedSeatBooking = loader.<ConfirmedSeatBooking>getController();
    	      
    	      
    	      confirmedSeatBooking.getSelectedSeatNumber().setText(selectedSeatNumber.getText()); // gets payment information and passes on to confirmed booking.  
    	      confirmedSeatBooking.getDepartureDate().setText(departureDate.getText());
    	      confirmedSeatBooking.setSelectedBus(selectedBus);
    	      confirmedSeatBooking.getTotalFare().setText(totalFare.getText()); 
    	      Random r = new Random();
    	      Integer num = r.nextInt(9000000) + 1000000;
    	      
    	      //BusDto bus = new BusDto(selectedBus, departureLocation.getText(), Integer.parseInt(totalFare.getText()));
    	      
    	      confirmedSeatBooking.getBookingId().setText("BOOKID@"+num); //generates random system id.
    	      
    	      Text bookid = confirmedSeatBooking.getBookingId();
    	      String nbid = bookid.toString();
    	      newBookId = nbid.substring(25, 39);
    	      System.out.println(newBookId);
    	      
    	      Alert errorAlert = new Alert(AlertType.CONFIRMATION);
	    	  errorAlert.setHeaderText("BOOKING ID: ");
	    	  errorAlert.setContentText("Your BookingID is: BOOKID@"+num);
	    	  errorAlert.showAndWait();
    	      
    	      confirmedSeatBooking.getDepartureLocation().setText(departureLocation.getText());
            	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
		return newBookId;
    }

}

