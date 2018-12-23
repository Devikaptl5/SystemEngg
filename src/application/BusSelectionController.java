package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BusSelectionController {

	private List<Pane> buses = new ArrayList<Pane>();

	@FXML
	private Button back;

	private BusDto selectedBus;
	
	public void setSelectedBus(BusDto selectedBus) {
		this.selectedBus = selectedBus;
	}
	
	@FXML
	void backAction(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(
	  	    		  getClass().getResource(
	  	    		    "CitySelection.fxml"
	  	    		  )
	  	    		);
	  	      
	  	      Pane pane = loader.load();
	  	      CitySelectionController citySelectionController = loader.<CitySelectionController>getController();
	  	      citySelectionController.populate(pane);
		        	      
	  	      BorderPane border = Main.getRoot();
	  	      border.setCenter(pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Pane createPane(long layoutY) {
		long layoutX = 14, prefHeight = 105, prefWidth = 562;
		Pane p = new Pane();
		p.setLayoutX(layoutX);
		p.setLayoutY(layoutY);
		p.setPrefHeight(prefHeight);
		p.setPrefWidth(prefWidth);

		return p;
	}

	private void handleBusSelection(ActionEvent event) {
		Button button = (Button) event.getTarget();
		String elId = button.getId();
		System.out.println(elId);
		Integer id = Integer.parseInt(elId.split("::")[1]);
		System.out.println("You selected bus" + id);

		BusDto selectedBus = Main.getPersistData().findBus(id);
		if (selectedBus != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("SeatSelection.fxml"));

				Pane pane = loader.load(); // loads the complete page and adds/place it to main root

				SeatSelectionController seatSelectionController = loader.<SeatSelectionController>getController();
				seatSelectionController.setSelectedBus(selectedBus); // selecting bus number 1
				seatSelectionController.populate(pane);

				BorderPane border = Main.getRoot();
				border.setCenter(pane);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private List<Label> createPaneLabels(BusDto bus) {
		List<Label> labels = new ArrayList<Label>();

		Label destination = new Label();
		destination.setText(bus.destination);
		destination.setLayoutX(39L);
		destination.setLayoutY(40L);
		labels.add(destination);

		Label departureTime = new Label();
		departureTime.setText(bus.departureTime);
		departureTime.setLayoutX(193L);
		departureTime.setLayoutY(40L);
		labels.add(departureTime);

		Label fare = new Label();
		fare.setText("" + bus.fare);
		fare.setLayoutX(359L);
		fare.setLayoutY(40L);
		labels.add(fare);

		return labels;
	}

	private Button createSelectButton(BusDto dto) {
		Button select = new Button();
		select.setText("Check Availability");
		select.setId(dto.name + "::" + dto.bid);
		select.setLayoutX(539L);
		select.setLayoutY(35L);

		select.addEventHandler(ActionEvent.ACTION, event -> {
			this.handleBusSelection(event);
		});

		return select;
	}

	public void populate(Pane pane) {
		long layoutY = 66, layoutYOffset = 98;
		for (BusDto bus : Main.getPersistData().buses) {
			Pane p = createPane(layoutY);
			p.getChildren().addAll(createPaneLabels(bus));
			p.getChildren().add(createSelectButton(bus));
			buses.add(p);
			layoutY += layoutYOffset;
		}
		pane.getChildren().addAll(buses);
	}
}
