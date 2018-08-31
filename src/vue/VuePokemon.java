package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VuePokemon extends Application {
	protected Label nom;
	protected Label type;
	protected Label copacite;

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();
		GridPane grillePokemon = new GridPane();
		
		Label nom = new Label("Carapuce");
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		Label type = new Label("Eau");
		grillePokemon.add(new Label("Type : "), 0, 1);
		grillePokemon.add(type, 1, 1);
		
		Label capacite = new Label("Bulle d'eau");
		grillePokemon.add(new Label("Capacite : "), 0, 2);
		grillePokemon.add(capacite, 1, 2);
			
	
		panneau.getChildren().add(grillePokemon);
		stade.setScene(new Scene(panneau, 400, 400));
		
		stade.show();
	}
}
