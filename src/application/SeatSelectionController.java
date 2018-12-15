package application;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SeatSelectionController {

    @FXML
    private Button confirmSeatButton;

    @FXML
    private Button backBusSelection;
    
    @FXML
    private CheckBox seat1; //checkboxes for seats
    
    @FXML
    private CheckBox seat2;
    
    @FXML
    private CheckBox seat4;

    @FXML
    private CheckBox seat3;
    
    @FXML
    private CheckBox seat5;
    
    @FXML
    private CheckBox seat6;
    
    @FXML
    private CheckBox seat7;
    
    @FXML
    private CheckBox seat8;
    
    @FXML
    private CheckBox seat9;
    
    @FXML
    private CheckBox seat10;
    
    @FXML
    private CheckBox seat11;
    
    @FXML
    private CheckBox seat12;
    
    @FXML
    private CheckBox seat13;
    
    @FXML
    private CheckBox seat14;
    
    @FXML
    private CheckBox seat15;
    
    @FXML
    private CheckBox seat16;
    
    @FXML
    private CheckBox seat17;
    
    @FXML
    private CheckBox seat18;
    
    @FXML
    private CheckBox seat19;
    
    @FXML
    private CheckBox seat20;
    
    private Integer selectedBus;
    
    public void setSelectedBus(Integer selectedBus) {
    	this.selectedBus = selectedBus;
    }
    
    public CheckBox getSeat1() {
    	return seat1;
    }
    
    public CheckBox getSeat2() {
    	return seat2;
    }
    
    public CheckBox getSeat3() {
    	return seat3;
    }
    
    public CheckBox getSeat4() {
    	return seat4;
    }
    
    public CheckBox getSeat5() {
    	return seat5;
    }
    
    public CheckBox getSeat6() {
    	return seat6;
    }
    
    public CheckBox getSeat7() {
    	return seat7;
    }
    
    public CheckBox getSeat8() {
    	return seat8;
    }
    
    public CheckBox getSeat9() {
    	return seat9;
    }
    
    public CheckBox getSeat10() {
    	return seat10;
    }
    
    public CheckBox getSeat11() {
    	return seat11;
    }
    
    public CheckBox getSeat12() {
    	return seat12;
    }
    
    public CheckBox getSeat13() {
    	return seat13;
    }
    
    public CheckBox getSeat14() {
    	return seat14;
    }
    
    public CheckBox getSeat15() {
    	return seat15;
    }
    
    public CheckBox getSeat16() {
    	return seat16;
    }
    
    public CheckBox getSeat17() {
    	return seat17;
    }
    
    public CheckBox getSeat18() {
    	return seat18;
    }
    
    public CheckBox getSeat19() {
    	return seat19;
    }
    
    public CheckBox getSeat20() {
    	return seat20;
    }
    
    @FXML
    void confirmSeatButtonAction(ActionEvent event) throws IOException { //if seat is selcted or not
    	 
    	String seatNumber = ""; //saves the seat number to be displayed in the next screen
	      
	      Integer totalSelectedSeat = 0;
	      Integer i;
	      
	      if(seat1.isSelected()) {
	    	  seatNumber = seat1.getText();
	    	  totalSelectedSeat++;
	      }
	      if(seat2.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat2.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat3.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat3.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat4.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat4.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat5.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat5.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat6.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat6.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat7.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat7.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat8.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat8.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat9.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat9.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat10.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat10.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat11.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat11.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat12.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat12.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat13.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat13.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat14.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat14.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat15.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat15.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat16.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat16.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat17.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat17.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat18.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat18.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat19.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat19.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(seat20.isSelected()) {
	    	  seatNumber = seatNumber + "," + seat20.getText();
	    	  totalSelectedSeat++;
	      }
	      
	      if(!seat1.isSelected()&&!seat2.isSelected()&&!seat3.isSelected()&&!seat4.isSelected()&&!seat5.isSelected()&&!seat6.isSelected()&&!seat7.isSelected()&&!seat8.isSelected()&&!seat9.isSelected()&&!seat10.isSelected()&&!seat11.isSelected()&&!seat12.isSelected()&&!seat13.isSelected()&&!seat14.isSelected()&&!seat15.isSelected()&&!seat16.isSelected()&&!seat17.isSelected()&&!seat18.isSelected()&&!seat19.isSelected()&&!seat20.isSelected()) {
	    	  totalSelectedSeat=0;          
	      }
	      
	      if(totalSelectedSeat==0)
	      {
	    	  Alert errorAlert = new Alert(AlertType.ERROR);
	    	  errorAlert.setHeaderText("Error");
	    	  errorAlert.setContentText("select atleast 1 seat");
	    	  errorAlert.showAndWait();
	    	  
	      }
	      else if(totalSelectedSeat>4)
	      {
	    	  Alert errorAlert = new Alert(AlertType.ERROR);
	    	  errorAlert.setHeaderText("Error");
	    	  errorAlert.setContentText("Maximum 4 seats");
	    	  errorAlert.showAndWait();
	      }
	      
	      else
	      {
	    	  FXMLLoader loader = new FXMLLoader(
		    		  getClass().getResource(
		    		    "Payment.fxml"
		    		  )
		    		);
		      
		      Pane pane = loader.load();   
		     
		      PaymentController paymentController = loader.<PaymentController>getController();
	    		
	    		

		      
		      BusDto busDto = Main.getPersistData().buses.get(selectedBus);
		      
		      paymentController.selectedSeats.add(seat1); //bus information is stored in the selected seats
		      paymentController.selectedSeats.add(seat2);
		      paymentController.selectedSeats.add(seat3);
		      paymentController.selectedSeats.add(seat4);
		      paymentController.selectedSeats.add(seat5);
		      paymentController.selectedSeats.add(seat6);
		      paymentController.selectedSeats.add(seat7);
		      paymentController.selectedSeats.add(seat8);
		      paymentController.selectedSeats.add(seat9);
		      paymentController.selectedSeats.add(seat10);
		      paymentController.selectedSeats.add(seat11);
		      paymentController.selectedSeats.add(seat12);
		      paymentController.selectedSeats.add(seat13);
		      paymentController.selectedSeats.add(seat14);
		      paymentController.selectedSeats.add(seat15);
		      paymentController.selectedSeats.add(seat16);
		      paymentController.selectedSeats.add(seat17);
		      paymentController.selectedSeats.add(seat18);
		      paymentController.selectedSeats.add(seat19);
		      paymentController.selectedSeats.add(seat20);
		      
		      paymentController.getSelectedSeatNumber().setText(seatNumber);
		      paymentController.getDepartureDate().setText(new SimpleDateFormat("MM-dd-yyyy").format(new Date()).toString());
		      paymentController.setSelectedBus(selectedBus);
		      
		      String totalFare = Integer.toString(totalSelectedSeat * busDto.fare); //calculation of fare
		      paymentController.getTotalFare().setText(totalFare);    
		      
		      paymentController.getDepartureLocation().setText(busDto.departureLocation); 
	        	      
		      BorderPane border = Main.getRoot();
		      border.setCenter(pane);
		      
	      }
	      
    }

    @FXML
    void backBusSelectionAction(ActionEvent event) {
    	try {
    	      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    		    "BusSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   
    	     
    	      BusDto bus1 = Main.getPersistData().buses.get(0); 
    	      BusDto bus2 = Main.getPersistData().buses.get(1);
    	      BusDto bus3 = Main.getPersistData().buses.get(2);
    	      BusDto bus4 = Main.getPersistData().buses.get(3);
    	      BusDto bus5 = Main.getPersistData().buses.get(4);
    	      BusDto bus6 = Main.getPersistData().buses.get(5);
    	      
    	      
    	      BusSelectionController busSelectionController = loader.<BusSelectionController>getController();
    	      /*busSelectionController.getSeat1().setText(Integer.toString(bus1.seats.size()));
    	      busSelectionController.getSeat1().setText(Integer.toString(bus2.seats.size()));
    	      busSelectionController.getSeat1().setText(Integer.toString(bus3.seats.size()));
    	      busSelectionController.getSeat1().setText(Integer.toString(bus4.seats.size()));
    	      busSelectionController.getSeat1().setText(Integer.toString(bus5.seats.size()));
    	      busSelectionController.getSeat1().setText(Integer.toString(bus6.seats.size()));*/
  	        	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
    }

}

