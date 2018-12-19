package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ConfirmationController {
	
	public BookingDto booking;

	@FXML // fx:id="BookButton"
	private Button okButton;
	
	@FXML
	void home(ActionEvent event) {
		// TODO Auto-generated constructor stub
		
		Main.getPersistData().cancelBooking(booking);
    	
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
    	
    	/** AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + BookButton.getText()); **/

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'Home.fxml'.";
    }


}
