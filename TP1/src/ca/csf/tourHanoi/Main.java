package ca.csf.tourHanoi;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private static final String TITLE = "Tours de Hanoi - 1234304_1167559";
	
	@Override
	public void start(Stage primaryStage) {
		Stage stage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"MainWindow.fxml"));
			BorderPane root = loader.load();
			MainWindowController controller = loader.getController();
			String useArrayStack = getParameters().getNamed().get("useArrayStack");
			controller.setStage(stage, useArrayStack);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle(TITLE);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
