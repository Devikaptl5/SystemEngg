package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CitySelectionController {

	private List<Pane> buses = new ArrayList<Pane>();
	private List<Pane> cities = new ArrayList<Pane>();

	@FXML
	private Button back;

	@FXML
	void backAction(ActionEvent event) {
		try {

			URL paneOneUrl = getClass().getResource("Home.fxml");
			AnchorPane paneOne = FXMLLoader.load(paneOneUrl);

			BorderPane border = Main.getRoot();
			border.setCenter(paneOne);

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

	private void handleBusSelection(ActionEvent event) throws IOException {
		Button button = (Button) event.getTarget();
		
		String elId = button.getId();
		System.out.println(elId);
		Integer id = Integer.parseInt(elId.split("::")[1]);
		String sname = elId.split("::")[0];
		System.out.println("You selected city : " + id + " " + sname);
       
        	BusDto selectedBus = Main.getPersistData().findBus(id);
    		
    		System.out.println(selectedBus);
    		if (selectedBus.destination.matches(sname) && selectedBus.id==id /*&& selectedBus != null*/) {
    			try {

    				FXMLLoader loader = new FXMLLoader(getClass().getResource("BusSelection.fxml"));

    				Pane pane = loader.load(); // loads the complete page and adds/place it to main root

    				BusSelectionController busSelectionController = loader.<BusSelectionController>getController();
    				busSelectionController.setSelectedBus(selectedBus); // selecting bus number 1
    				busSelectionController.populate(pane);

    				BorderPane border = Main.getRoot();
    				border.setCenter(pane);


    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			
    		}
	
	}
    		

	private List<Label> createPaneLabels(CityDto city) {
		List<Label> labels = new ArrayList<Label>();

		Label destination = new Label();
		destination.setText(city.cname);
		destination.setLayoutX(39L);
		destination.setLayoutY(40L);
		labels.add(destination);

		/*Label departureTime = new Label();
		departureTime.setText(bus.departureTime);
		departureTime.setLayoutX(193L);
		departureTime.setLayoutY(40L);
		labels.add(departureTime);

		Label fare = new Label();
		fare.setText("" + bus.fare);
		fare.setLayoutX(359L);
		fare.setLayoutY(40L);
		labels.add(fare);*/

		return labels;
	}

	private Button createSelectButton(CityDto cto) {
		Button select = new Button();
		select.setText("Check Availability");
		
		select.setId(cto.cname + "::" + cto.cid);
		select.setLayoutX(539L);
		select.setLayoutY(35L);

		select.addEventHandler(ActionEvent.ACTION, event -> {
			try {
				this.handleBusSelection(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        System.out.println("Select : " + select);
		return select;
	}
	
	public void populate(Pane pane) {
		long layoutY = 66, layoutYOffset = 98;
		for (CityDto city : Main.getPersistData().cities) {
			Pane p = createPane(layoutY);
			p.getChildren().addAll(createPaneLabels(city));
			p.getChildren().add(createSelectButton(city));
			cities.add(p);
			layoutY += layoutYOffset;
		}
		pane.getChildren().addAll(cities);
	}
}
