package application;

import java.io.IOException;

/**
 * Sample Skeleton for 'Home.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BookingController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="BookButton"
    private Button BookButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="BookButton"
    private Button CancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="BookButton"
    private Button CloseButton;
    
    @FXML
    void booking(ActionEvent event) {
    	
    	try {
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    		    "BusSelection.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();
    	      BusSelectionController busSelectionController = loader.<BusSelectionController>getController();
    	      busSelectionController.populate(pane);
  	        	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
    	
    	/** AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + BookButton.getText()); **/

    }
    @FXML
    void cancellingTicket(ActionEvent event) {
    	
    	try {
    	      FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    		    "Cancel.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   
  	        	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
    	      
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
    	
    	/** AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + BookButton.getText()); **/

    }
    
    @FXML
    int close(ActionEvent event) {
 
    	System.exit(0);
    	return 0;
    	/** AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + BookButton.getText()); **/

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert BookButton != null : "fx:id=\"BookButton\" was not injected: check your FXML file 'Home.fxml'.";
        assert CancelButton != null : "fx:id=\"CancelButton\" was not injected: check your FXML file 'Home.fxml'.";
        assert CloseButton != null : "fx:id=\"CloseButton\" was not injected: check your FXML file 'Home.fxml'.";
    }

    
    
}

