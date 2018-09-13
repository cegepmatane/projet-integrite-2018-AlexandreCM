package vue;

import controleur.ControleurPokemon;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Pokemon;

public class VuePokemon extends Scene {
	
	protected Label nom;
	protected Label type;
	protected Label description;
	
	private ControleurPokemon controleur = null;

	public VuePokemon() {
		
		super(new GridPane(),400,400);
		GridPane grillePokemon = (GridPane) this.getRoot();
		
		nom = new Label("Carapuce");
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		type = new Label("Eau");
		grillePokemon.add(new Label("TypePokemon : "), 0, 1);
		grillePokemon.add(type, 1, 1);
		
		description = new Label("Bulle d'eau");
		grillePokemon.add(new Label("Description : "), 0, 2);
		grillePokemon.add(description, 1, 2);
		
	}
	
	public void afficherPokemon(Pokemon pokemon) {
		this.nom.setText(pokemon.getNom());
		//this.type.setText(pokemon.getType());
		this.description.setText(pokemon.getDescription());
	}
	
	public void setControleur(ControleurPokemon controleur) {
		this.controleur = controleur;
	}
}
