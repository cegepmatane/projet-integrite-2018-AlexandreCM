package vue;

import java.util.ArrayList;

import controleur.ControleurPokemon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Pokemon;

public class VueListePokemon extends Scene {
	
	protected GridPane grillePokemon;
	private ControleurPokemon controleur = null;

	public VueListePokemon() {
		
		super(new GridPane(), 400,400);
		grillePokemon = (GridPane) this.getRoot();
		
	}
	
	public void afficherListePokemon(ArrayList<Pokemon> listePokemon) {
		
		this.grillePokemon.getChildren().clear();
		
		int numero = 0;
		this.grillePokemon.add(new Label("Nom"), 0, numero);
		this.grillePokemon.add(new Label("TypePokemon"), 1, numero);			
		this.grillePokemon.add(new Label("Poids"), 2, numero);			
		for(Pokemon pokemon : listePokemon) {
			numero++;
			this.grillePokemon.add(new Label(pokemon.getNom()), 0, numero);
			this.grillePokemon.add(new Label(pokemon.getType().getLibelle()), 1, numero);			
			this.grillePokemon.add(new Label(Double.toString(pokemon.getPoids())), 2, numero);
			this.grillePokemon.add(new Button("Modifier"), 3, numero);
		}
		
	}
	
	public void setControleur(ControleurPokemon controleur) {
		this.controleur = controleur;
	}

}
