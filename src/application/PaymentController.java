package application;

import java.io.IOException;
import java.util.Random;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
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
    
    private BusDto selectedBus;
    
    private BusDto selectedBusDto;
    
    public String newBookId;
    
    public List<String> selectedSeats = new ArrayList<String>();
    public String selectedSeatsDisplayValue;
    
    public void setSelectedBusDto(BusDto bus) {
    	selectedBusDto = bus;
    }
    
    public void setSelectedBus(BusDto selectedBus) {
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
    	      
    	      
    	      confirmedSeatBooking.getSelectedSeatNumber().setText(selectedSeatsDisplayValue); // gets payment information and passes on to confirmed booking.  
    	      confirmedSeatBooking.getDepartureDate().setText(departureDate.getText());
    	      confirmedSeatBooking.setSelectedBus(selectedBusDto);
    	      confirmedSeatBooking.getTotalFare().setText(totalFare.getText()); 
    	      Random r = new Random();
    	      Integer num = r.nextInt(9000000) + 1000000;
    	      String id = "BOOKID@"+num;
    	      
    	      System.out.println(id);
    	      
    	      confirmedSeatBooking.getBookingId().setText(id); //generates random system id.
    	      
    	      Alert errorAlert = new Alert(AlertType.CONFIRMATION);
	    	  errorAlert.setHeaderText("BOOKING ID: ");
	    	  errorAlert.setContentText("Your BookingID is: " + id);
	    	  errorAlert.showAndWait();
	    	  String str = selectedSeatNumber.getText();
	    	  String idStr = str.substring(1,str.length() -1);
	    	  
	    	  List<String> selectedSeats = Arrays.asList(idStr.split(","));
	    	  
	    	  BookingDto booking = new BookingDto(selectedBus, id, selectedSeats);
	    	  
	    	  PersistanceData persistence = Main.getPersistData();
	    	  persistence.addConfirmedBooking(booking);
    	      
    	      confirmedSeatBooking.getDepartureLocation().setText(departureLocation.getText());
            	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
		return newBookId;
    }

}

