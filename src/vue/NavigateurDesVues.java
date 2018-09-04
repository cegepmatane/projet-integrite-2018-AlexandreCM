package vue;

import java.util.ArrayList;

import controleur.ControleurPokemon;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Pokemon;

public class NavigateurDesVues extends Application {
	
	private ControleurPokemon controleur;
	private Stage stade;
	
	private VuePokemon vuePokemon = null;
	private VueListePokemon vueListePokemon = null;
	private VueAjouterPokemon vueAjouterPokemon = null;
	

	
	public NavigateurDesVues() {
		
		this.vuePokemon = new VuePokemon();
		this.vueListePokemon = new VueListePokemon();
		this.vueAjouterPokemon = new VueAjouterPokemon();
	}

	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		//stade.setScene(this.vuePokemon);
		//stade.show();
		
		this.controleur = new ControleurPokemon(this);
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
