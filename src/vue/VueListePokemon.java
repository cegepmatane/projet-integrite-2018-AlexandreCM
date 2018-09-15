package vue;

import java.util.ArrayList;

import controleur.ControleurPokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Pokemon;

public class VueListePokemon extends Scene {
	
	private ControleurPokemon controleur = null;

	protected GridPane grillePokemon;
	//protected Button actionModifierPokemon = null;

	public void setControleur(ControleurPokemon controleur) {
		this.controleur = controleur;
	}
	
	public VueListePokemon() {
		super(new GridPane(), 400,400);
		System.out.println("VueListePokemon : VueListePokemon()");
		
		grillePokemon = (GridPane) this.getRoot();
	}
	
	public void afficherListePokemon(ArrayList<Pokemon> listePokemon) {
		System.out.println("VueListePokemon : afficherListePokemon()");
		
		this.grillePokemon.getChildren().clear();
		
		int numero = 0;
		this.grillePokemon.add(new Label("Nom"), 0, numero);
		this.grillePokemon.add(new Label("TypePokemon"), 1, numero);			
		this.grillePokemon.add(new Label("Poids"), 2, numero);			
		
		//this.actionModifierPokemon = new Button("Modifier");
		for(Pokemon pokemon : listePokemon) {
			
			Button actionModifierPokemon = new Button("Modifier");
			actionModifierPokemon.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					controleur.notifierNaviguerVersVueModifierPokemon(pokemon);
				}
			});
			
			numero++;
			this.grillePokemon.add(new Label(pokemon.getNom()), 0, numero);
			this.grillePokemon.add(new Label(pokemon.getType().getLibelle()), 1, numero);			
			this.grillePokemon.add(new Label(Double.toString(pokemon.getPoids())), 2, numero);
			this.grillePokemon.add(actionModifierPokemon, 3, numero);
		}
		
	}
}
