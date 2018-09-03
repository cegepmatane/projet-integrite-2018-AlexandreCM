package vue;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Pokemon;

public class NavigateurDesVues extends Application {
	
	private Stage stade;
	
	private VuePokemon vuePokemon;
	private VueListePokemon vueListePokemon;
	private VueAjouterPokemon vueAjouterPokemon;
	
	public NavigateurDesVues() 
	{
		this.vuePokemon = new VuePokemon();
		this.vueListePokemon = new VueListePokemon();
		this.vueAjouterPokemon = new VueAjouterPokemon();
		
		//// TEST ////
		Pokemon pokemon = new Pokemon("Salameche", "Feu", "Flameche");
		this.vuePokemon.afficherPokemon(pokemon);
		
		/// TEST ///
		ArrayList<Pokemon> listePokemon = new ArrayList<Pokemon>();
		listePokemon.add(new Pokemon("Carapuce", "Eau", "Bulled'eau"));
		listePokemon.add(new Pokemon("Salameche", "Feu", "Flameche"));
		listePokemon.add(new Pokemon("Bulbizare", "Plante", "Fouet liane"));
		
		this.vueListePokemon.afficherListePokemon(listePokemon);
	}

	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		//stade.setScene(this.vuePokemon);
		//stade.show();
		
		//// TEST ////
		//this.naviguerVersVuePokemon();
		this.naviguerVersVueListePokemon();
		//this.naviguerVersVueAjouterPokemon();
		
	}
	
	//// getVues
	public VuePokemon getVuePokemon() {
		return vuePokemon;
	}
 	
	public VueListePokemon getVueListePokemon() {
		return vueListePokemon;
	}
	
	public VueAjouterPokemon getVueAjouterPokemon() {
		return vueAjouterPokemon;
	}
 	
	//// naviguerVers
	public void naviguerVersVuePokemon() {
		stade.setScene(this.vuePokemon);
		stade.show();
	}
	
	public void naviguerVersVueListePokemon() {
		stade.setScene(this.vueListePokemon);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterPokemon() {
		stade.setScene(this.vueAjouterPokemon);
		stade.show();				
	}

}
