package vue;

import controleur.ControleurPokemon;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application {
	
	private ControleurPokemon controleur = null;
	private Stage stade;
	
	private VuePokemon vuePokemon = null;
	private VueListePokemon vueListePokemon = null;
	private VueAjouterPokemon vueAjouterPokemon = null;
	private VueModifierPokemon vueModifierPokemon = null;
	

	
	public NavigateurDesVues() {
		
		this.vuePokemon = new VuePokemon();
		this.vueListePokemon = new VueListePokemon();
		this.vueAjouterPokemon = new VueAjouterPokemon();
		this.vueModifierPokemon = new VueModifierPokemon();
	}

	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		stade.setTitle("Pokemon");
		//this.stade.setScene(null);
		//stade.show();
		
		this.controleur = ControleurPokemon.getInstance();
		this.controleur.activerVues(this);
		
		this.vueListePokemon.setControleur(controleur);
		this.vuePokemon.setControleur(controleur);
		this.vueAjouterPokemon.setControleur(controleur);
		this.vueModifierPokemon.setControleur(controleur);
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
	
	public VueModifierPokemon getVueModifierPokemon() {
		return vueModifierPokemon;
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
	
	public void naviguerVersVueModifierPokemon() {
		stade.setScene(this.vueModifierPokemon);
		stade.show();				
	}

}
