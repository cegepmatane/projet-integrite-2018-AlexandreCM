package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Pokemon;

public class VuePokemon extends Application {
	protected Label nom;
	protected Label type;
	protected Label capacite;

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();
		GridPane grillePokemon = new GridPane();
		
		nom = new Label("Carapuce");
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		type = new Label("Eau");
		grillePokemon.add(new Label("Type : "), 0, 1);
		grillePokemon.add(type, 1, 1);
		
		capacite = new Label("Bulle d'eau");
		grillePokemon.add(new Label("Capacite : "), 0, 2);
		grillePokemon.add(capacite, 1, 2);
			
	
		panneau.getChildren().add(grillePokemon);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();
		
		//// TEST ////
		Pokemon pokemon = new Pokemon("Salameche", "Feu", "Flameche");
		this.afficherPokemon(pokemon);
	}
	
	public void afficherPokemon(Pokemon pokemon) {
		this.nom.setText(pokemon.getNom());
		this.type.setText(pokemon.getType());
		this.capacite.setText(pokemon.getCapacite());
	}
}
