package vue;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Pokemon;

public class VueListePokemon extends Application {
	
	protected GridPane grillePokemon;

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();	
		grillePokemon = new GridPane();
		
		/// TEST ///
		ArrayList<Pokemon> listePokemon = new ArrayList<Pokemon>();
		listePokemon.add(new Pokemon("Carapuce", "Eau", "Bulled'eau"));
		listePokemon.add(new Pokemon("Salameche", "Feu", "Flameche"));
		listePokemon.add(new Pokemon("Bulbizare", "Plante", "Fouet liane"));
		
		this.afficherListePokemon(listePokemon);
		
		panneau.getChildren().add(grillePokemon);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();
		
	}
	
	public void afficherListePokemon(ArrayList<Pokemon> listePokemon) {
		
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
