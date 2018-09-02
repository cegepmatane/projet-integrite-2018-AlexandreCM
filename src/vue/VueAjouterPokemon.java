package vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Pokemon;

public class VueAjouterPokemon extends Scene {
	
	protected TextField nom;
	protected TextField type;
	protected TextField capacite;

	public VueAjouterPokemon() {
		
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grillePokemon = new GridPane();
		
		nom = new TextField();
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		type = new TextField();
		grillePokemon.add(new Label("Type : "), 0, 1);
		grillePokemon.add(type, 1, 1);
		
		capacite = new TextField();
		grillePokemon.add(new Label("Capacité : "), 0, 2);
		grillePokemon.add(capacite, 1, 2);
		
		panneau.getChildren().add(new Label("Ajouter un Pokemon")); 
		panneau.getChildren().add(grillePokemon);
		panneau.getChildren().add(new Button("Enregistrer"));
		
	}
	
	public Pokemon demanderPokemon() {
		// return null;
		Pokemon pokemon = new Pokemon(this.nom.getText(), this.type.getText(), this.capacite.getText());     
		return pokemon;
	}

}
