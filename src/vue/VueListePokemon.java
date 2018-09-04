package vue;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modele.Pokemon;

public class VueListePokemon extends Scene {
	
	protected GridPane grillePokemon;

	public VueListePokemon() {
		
		super(new GridPane(), 400,400);
		grillePokemon = (GridPane) this.getRoot();
		
	}
	
	public void afficherListePokemon(ArrayList<Pokemon> listePokemon) {
		
		this.grillePokemon.getChildren().clear();
		
		int numero = 0;
		this.grillePokemon.add(new Label("Nom"), 0, numero);
		this.grillePokemon.add(new Label("Type"), 1, numero);			
		this.grillePokemon.add(new Label("Capacité"), 2, numero);			
		for(Pokemon pokemon : listePokemon)
		{
			numero++;
			this.grillePokemon.add(new Label(pokemon.getNom()), 0, numero);
			this.grillePokemon.add(new Label(pokemon.getType()), 1, numero);			
			this.grillePokemon.add(new Label(pokemon.getCapacite()), 2, numero);			
		}
		
	}

}
