package application;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BusSelectionController {

    @FXML
    private Button thirdBusAvailability;

    @FXML
    private Button secondBusAvailability;

    @FXML
    private Button firstBusAvailability;
    
    @FXML
    private Button forthBusAvailability;
    
    @FXML
    private Button fifthBusAvailability;
    
    @FXML
    private Button sixthBusAvailability;
    
    @FXML
    private Button back;
    
    @FXML
    private Text seat1;
    
    @FXML
    public Text seat3;
    
    @FXML
    public Text seat2;

    @FXML
    public Text seat4;
    
    @FXML
    public Text seat5;
    
    @FXML
    public Text seat6;
    
    public Text getSeat1() {
    	return seat1;
    }
    
    public Text getSeat2() {
    	return seat2;
    }
    
    public Text getSeat3() {
    	return seat3;
    }
    
    public Text getSeat4() {
    	return seat4;
    }
    
    public Text getSeat5() {
    	return seat5;
    }
    
    public Text getSeat6() {
    	return seat6;
    }
    
    @FXML
    void firstBusAvailabilityAction(ActionEvent event) {
    	
    	try {      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    			"SeatSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   //loads the complete page and adds/place it to main root 
    	     
    	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
    	      seatSelectionController.setSelectedBus(0);  //selecting bus number 1
    	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }

    }

    @FXML
    void secondBusAvailabilityAction(ActionEvent event) {
    	try {      
    		FXMLLoader loader = new FXMLLoader(
  	    		  getClass().getResource(
  	    			"SeatSelection.fxml"
  	    		  )
  	    		);
  	      
  	      Pane pane = loader.load();   
  	     
  	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
  	      seatSelectionController.setSelectedBus(1); //selecting bus number 2
  	      
  	      BorderPane border = Main.getRoot();
  	      border.setCenter(pane);
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
    }

    @FXML
    void thirdBusAvailabilityAction(ActionEvent event) {
    	try {      
    		FXMLLoader loader = new FXMLLoader(
  	    		  getClass().getResource(
  	    			"SeatSelection.fxml"
  	    		  )
  	    		);
  	      
  	      Pane pane = loader.load();   
  	     
  	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
  	      seatSelectionController.setSelectedBus(2);  //selecting bus number 3
  	      
  	      BorderPane border = Main.getRoot();
  	      border.setCenter(pane);
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
    }
    
    @FXML
    void forthBusAvailabilityAction(ActionEvent event) {
    	
    	try {      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    			"SeatSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   //loads the complete page and adds/place it to main root 
    	     
    	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
    	      seatSelectionController.setSelectedBus(3);  //selecting bus number 1
    	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }

    }
    
    @FXML
    void fifthBusAvailabilityAction(ActionEvent event) {
    	
    	try {      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    			"SeatSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   //loads the complete page and adds/place it to main root 
    	     
    	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
    	      seatSelectionController.setSelectedBus(4);  //selecting bus number 1
    	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }

    }
    
    @FXML
    void sixthBusAvailabilityAction(ActionEvent event) {
    	
    	try {      
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    			"SeatSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   //loads the complete page and adds/place it to main root 
    	     
    	      SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
    	      seatSelectionController.setSelectedBus(5);  //selecting bus number 1
    	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }

    }
    
    @FXML
    void backAction(ActionEvent event) {
    	try {
  	      
  	      URL paneOneUrl = getClass().getResource("Home.fxml");
  	      AnchorPane paneOne = FXMLLoader.load( paneOneUrl );
  	      
  	      BorderPane border = Main.getRoot();
  	      border.setCenter(paneOne);
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
    }
}
