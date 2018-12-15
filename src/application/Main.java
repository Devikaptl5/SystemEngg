package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application { //application starts
	
	private static BorderPane root = new BorderPane(); //root container. As we go to different pages, we add it to the flow
	
	private static PersistanceData persistanceData = new PersistanceData(); // Temporary database, This retrieves the bus price and selected seats in the beginning.
	
	public static PersistanceData getPersistData() {
		return persistanceData;
	}
	
	public static BorderPane getRoot() {
	    return root;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane homePane = FXMLLoader.load(getClass().getResource("Home.fxml"));
			
			root.setCenter(homePane);
			
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
	
	}
}
