package vue;

import java.util.ArrayList;

import controleur.ControleurPokemon;
import donnee.TypePokemonDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Pokemon;
import modele.TypePokemon;

public class VueAjouterPokemon extends Scene {
	
	protected TextField nom;
	protected ComboBox<TypePokemon> typePokemon;
	protected TextField poids;
	protected TextField description;
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
				controleur.notifierAjouterPokemon();
			}
 		});
		
		nom = new TextField();
		grillePokemon.add(new Label("Nom : "), 0, 0);
		grillePokemon.add(nom, 1, 0);
		
		TypePokemonDAO typePokemonDAO = new TypePokemonDAO();
		ArrayList<TypePokemon> listeTypes = new ArrayList<TypePokemon>();
		listeTypes = typePokemonDAO.getListeTypesPokemon();
		
		typePokemon = new ComboBox<TypePokemon>();
		typePokemon.getItems().addAll(listeTypes);
		typePokemon.setMinWidth(200);
		grillePokemon.add(new Label("Type : "), 0, 1);
		grillePokemon.add(typePokemon, 1, 1);
		
		poids = new TextField();
		grillePokemon.add(new Label("Poids : "), 0, 2);
		grillePokemon.add(poids, 1, 2);
		
		description = new TextField();
		grillePokemon.add(new Label("Description : "), 0, 3);
		grillePokemon.add(description, 1, 3);		
		
		panneau.getChildren().add(new Label("Ajouter un Pokemon")); 
		panneau.getChildren().add(grillePokemon);
		panneau.getChildren().add(this.actionEnregistrerPokemon);
		
	}
	
	public Pokemon demanderPokemon() {

		Pokemon pokemon = new Pokemon(
				this.nom.getText(), 
				this.typePokemon.getValue(),
				Double.parseDouble(this.poids.getText()), 
				this.description.getText()
		);
		System.out.println(pokemon.getNom() + " de type " + pokemon.getType() + " pese " + pokemon.getPoids() + "kg ");
		return pokemon;
	}
	
	public void setControleur(ControleurPokemon controleur) {
		this.controleur = controleur;
	}

}
