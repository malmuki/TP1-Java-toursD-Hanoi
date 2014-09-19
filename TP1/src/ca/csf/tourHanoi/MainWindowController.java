package ca.csf.tourHanoi;

import ca.csf.stack.Disk;
import ca.csf.stack.LinkedListStack;
import ca.csf.stack.Tower;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class MainWindowController {
	
	private Tower[] towers = {new Tower(new LinkedListStack()), new Tower(new LinkedListStack()), new Tower(new LinkedListStack())};
	@FXML Rectangle base;
	@FXML Button nouvellePartie;
	@FXML ChoiceBox<?> diskDepart;
	@FXML VBox tour1vBox;
	@FXML VBox tour2vBox;
	@FXML VBox tour3vBox;
	@FXML Button Tour1;
	@FXML Button Tour2;
	@FXML Button Tour3;
    
	@FXML public void nouvelle_Partie() {
		int nbDisk = Integer.parseInt((String) diskDepart.getValue());
		
		tour1vBox.getChildren().clear();
		
		for (int i = 0; i < nbDisk; i++) {
			Rectangle rectangle = new Rectangle(20 + i*7, 40);
			tour1vBox.getChildren().add(rectangle);
			towers[0].addDisk(new Disk(20 + i*7));
		}
	}
	
	@FXML public void deplacementDisk() {
		
	}
}
