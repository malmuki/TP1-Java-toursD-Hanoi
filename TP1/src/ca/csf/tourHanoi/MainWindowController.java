package ca.csf.tourHanoi;

import ca.csf.stack.Disk;
import ca.csf.stack.LinkedListStack;
import ca.csf.stack.Tower;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class MainWindowController {

	private static final String USEARRAYSTACK = "useArrayStack";
	
	private Tower[] towers;
	@FXML
	Rectangle base;
	@FXML
	Button nouvellePartie;
	@FXML
	ChoiceBox<?> diskDepart;
	@FXML
	VBox tour1vBox;
	@FXML
	VBox tour2vBox;
	@FXML
	VBox tour3vBox;
	@FXML
	Button Tour1;
	@FXML
	Button Tour2;
	@FXML
	Button Tour3;

	private int nbDisk;
	private int buttonSender = -1;

	@FXML
	HBox baseTour;
	@FXML
	BorderPane parent;
	private Stage stage;

	@FXML
	public void nouvelle_Partie() {
		nbDisk = Integer.parseInt((String) diskDepart.getValue());

		for (int i = 0; i < towers.length; i++) {
			towers[i].clear();
		}

		for (int i = nbDisk; i > 0; i--) {
			int rectLength = 20 + i * 7;
			towers[0].addDisk(new Disk(rectLength));
		}
		updateVisual();
	}

	@FXML
	public void button0Click() {
		deplacementDisk(0);
	}

	@FXML
	public void button1Click() {
		deplacementDisk(1);
	}

	@FXML
	public void button2Click() {
		deplacementDisk(2);
	}

	public void deplacementDisk(int buttonClicked) {
		if (buttonSender != -1) {
			if (buttonClicked == buttonSender) {
				buttonSender = -1;
			} else if (towers[buttonClicked].addDisk(towers[buttonSender]
					.getDiskOnTop())) {
				towers[buttonSender].removeDisk();
				buttonSender = -1;

				updateVisual();

			}
		} else if (towers[buttonClicked].getSize() != 0) {
			buttonSender = buttonClicked;
		}

		estVictorieux();
	}

	public void estVictorieux() {

		if (towers[2].getSize() == nbDisk) {
			Stage stage = new Stage();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource(
						"MessageBoxWindow.fxml"));
				BorderPane root = loader.load();
				MessageBoxController controller = loader.getController();
				controller.setStage(stage);
				Scene scene = new Scene(root, 400, 400);
				scene.getStylesheets().add(
						getClass().getResource("application.css")
								.toExternalForm());
				stage.setScene(scene);
				stage.initOwner(parent.getScene().getWindow());
				stage.initModality(Modality.WINDOW_MODAL);
				stage.showAndWait();
				switch (controller.getBoutonAppuyer()) {
				case CONTINUER:
					nouvelle_Partie();
					break;

				default:
					System.exit(0);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void updateVisual() {
		tour1vBox.getChildren().clear();
		tour2vBox.getChildren().clear();
		tour3vBox.getChildren().clear();

		Rectangle rectangle;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < towers[i].getSize(); j++) {
				rectangle = new Rectangle(towers[i].getDiskAt(j).getLongueur(),
						40);
				rectangle.setFill(Color.rgb(towers[i].getDiskAt(j)
						.getLongueur() + 50, 0, 0));
				((VBox) baseTour.getChildren().get(i)).getChildren().add(
						rectangle);
			}
		}
	}

	public void setStage(Stage stage, String useArrayStack) {
		this.stage = stage;
		if(useArrayStack == USEARRAYSTACK) {
			towers = { new ArrayStack(), new ArrayStack(), new ArrayStack() } ;
					
			}
		}
	}
}
