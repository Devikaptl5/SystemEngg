package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SeatSelectionController {

	@FXML
	private Pane pane;

	@FXML
	private Button confirmSeatButton;

	@FXML
	private Button backBusSelection;

	private int totalSeats = 10;
	private String[] seatMarkers = { "A", "B" };

	public List<CheckBox> seats = new ArrayList<CheckBox>();

	private BusDto selectedBus;

	public void setSelectedBus(BusDto selectedBus) {
		this.selectedBus = selectedBus;
	}

	@FXML
	void confirmSeatButtonAction(ActionEvent event) throws IOException { // if seat is selected or not
		List<String> selectedSeats = new ArrayList<String>();
		int MAXIMUM_ALLOWED_SELECTION = 4;

		for (CheckBox seat : seats) {
			if (seat.isSelected()) {
				selectedSeats.add(seat.getText());
			}
		}

		int totalSeats = selectedSeats.size();
		String seatsSting = selectedSeats.toString();

		if (totalSeats == 0) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("select atleast 1 seat");
			errorAlert.showAndWait();

		} else if (totalSeats > MAXIMUM_ALLOWED_SELECTION) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Maximum 4 seats");
			errorAlert.showAndWait();
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));

			Pane pane = loader.load();

			PaymentController paymentController = loader.<PaymentController>getController();

			paymentController.selectedSeats = selectedSeats;
			paymentController.selectedSeatsDisplayValue = selectedSeats.stream().map(Object::toString)
					.collect(Collectors.joining(", "));

			paymentController.getSelectedSeatNumber().setText(seatsSting);
			paymentController.getDepartureDate()
					.setText(new SimpleDateFormat("MM-dd-yyyy").format(new Date()).toString());
			paymentController.setSelectedBus(selectedBus);

			String totalFare = Integer.toString(selectedSeats.size() * selectedBus.fare); // calculation of fare
			paymentController.getTotalFare().setText(totalFare);

			paymentController.getDepartureLocation().setText(selectedBus.destination);

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
  	      BusSelectionController busSelectionController = loader.<BusSelectionController>getController();
  	      busSelectionController.populate(pane);
	        	      
  	      BorderPane border = Main.getRoot();
  	      border.setCenter(pane);
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace();
  	    }
	}
	
	
	public void populate(Pane pane) {
		long yOffset = 41, yPosition = 75, leftColumnXOffset = 58, rightColumnXOffset = 247, xOffset = 56, side,
				col = yPosition;
		List<String> occupiedSeats = Main.getPersistData().findOccupiedSeats(selectedBus.id);
		System.out.println(occupiedSeats);
		
		
		for (int i = 1; i <= totalSeats; i++) {
			
			side = i < 6 ? leftColumnXOffset : rightColumnXOffset;
			
			col = i == 6 ? yPosition : col;
			for (String marker : seatMarkers) {
				String id = i + marker;
				CheckBox cb = new CheckBox();
				cb.setText(id);
				cb.setLayoutX(marker.equals("A") ? side : side + xOffset);

				cb.setLayoutY(col);
				col = marker.equals("B") ? col + yOffset : col;
				
				for(int j=0; j<occupiedSeats.size(); j++)
				{
					System.out.println(occupiedSeats.get(j));
					if(occupiedSeats.get(j).contains(id)) {
						
						cb.setDisable(true);
						System.out.println(cb);
						
					}
					
				}
				
				seats.add(cb);
			}
			
		}

		pane.getChildren().addAll(seats);
	}

}
