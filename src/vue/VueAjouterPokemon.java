package vue;

import controleur.ControleurPokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	protected TextField poids;
	protected Button actionEnregistrerPokemon = null;
	
	private ControleurPokemon controleur = null;

	public VueAjouterPokemon() {
		
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grillePokemon = new GridPane();
		this.actionEnregistrerPokemon = new Button("Enregistrer");
		
		this.actionEnregistrerPokemon.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierEnregistrerPokemon();
			}
 		});
		
		nom = new TextField();
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		type = new TextField();
		grillePokemon.add(new Label("Type : "), 0, 1);
		grillePokemon.add(type, 1, 1);
		
		poids = new TextField();
		grillePokemon.add(new Label("Poids : "), 0, 2);
		grillePokemon.add(poids, 1, 2);
		
		panneau.getChildren().add(new Label("Ajouter un Pokemon")); 
		panneau.getChildren().add(grillePokemon);
		panneau.getChildren().add(this.actionEnregistrerPokemon);
		
	}
	
	public Pokemon demanderPokemon() {
		Pokemon pokemon = new Pokemon(this.nom.getText(), Integer.parseInt(this.type.getText()), Double.parseDouble(this.poids.getText()));  
		System.out.println(pokemon.getNom() + " de type " + pokemon.getType() + " pese " + pokemon.getPoids() + "kg ");
		return pokemon;
	}
	
	public void setControleur(ControleurPokemon controleur) {
		this.controleur = controleur;
	}

}
