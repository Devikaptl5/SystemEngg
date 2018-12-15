package application;

import java.util.UUID;

import application.PaymentController;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

public class Cancel {

	@FXML // fx:id="BookButton"
	private Button ConfirmButton; // Value injected by FXMLLoader
	@FXML
	private Button BackButton;
	@FXML
	TextField tf;
	
	@FXML 
	void ccancel(ActionEvent event) throws IOException {
		
	    Window owner = ConfirmButton.getScene().getWindow();
	    
        String s = tf.getText();
	    System.out.println(s);
	    
	    
	    //BusSelectionController busSelectionController = loader.<BusSelectionController>getController();
	    
	    //String newBookId1 = pc.paynowButtonAction(event);
	    //System.out.println(newBookId1);
	    
        
	    if(s.length()==14&&s.matches("(BOOKID@).*"))
          {
        	  FXMLLoader loader = new FXMLLoader(
    	    		  getClass().getResource(
    	    		    "Confirmation.fxml"
    	    		  )
    	    		);
    	      
    	      Pane pane = loader.load();   
    	      /*PaymentController pc = loader.<PaymentController>getController();
    	      String newBookId1 = pc.paynowButtonAction(event);
    		  System.out.println(newBookId1);*/
  	        	      
    	      BorderPane border = Main.getRoot();
    	      border.setCenter(pane);
          }
	    else
	    {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    	  errorAlert.setHeaderText("Error");
	    	  errorAlert.setContentText("Incorrect BookingID");
	    	  errorAlert.showAndWait();
	    }
	    	
	    	/** AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
	                "Welcome " + BookButton.getText()); **/

	    }
	
	   @FXML
	   void back(ActionEvent event) throws IOException
	   {
		   FXMLLoader loader = new FXMLLoader(
 	    		  getClass().getResource(
 	    		    "Home.fxml"
 	    		)
 	    	);
		   
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

