package controleur;

import java.util.ArrayList;

import modele.Pokemon;
import vue.NavigateurDesVues;
import vue.VueAjouterPokemon;
import vue.VueListePokemon;
import vue.VuePokemon;

public class ControleurPokemon {

	private NavigateurDesVues navigateur;
	
	private VuePokemon vuePokemon = null;
	private VueListePokemon vueListePokemon = null;
	private VueAjouterPokemon vueAjouterPokemon = null;
	
	public ControleurPokemon() {
		System.out.println("Initialisation du controleur");
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		
		this.vueAjouterPokemon = navigateur.getVueAjouterPokemon();
		this.vuePokemon = navigateur.getVuePokemon();
		this.vueListePokemon= navigateur.getVueListePokemon();
		
		//// TEST ////
		Pokemon pokemon = new Pokemon("Salameche", "Feu", "Flameche");
		this.vuePokemon.afficherPokemon(pokemon);
		
		/// TEST ///
		ArrayList<Pokemon> listePokemon = new ArrayList<Pokemon>();
		listePokemon.add(new Pokemon("Carapuce", "Eau", "Bulled'eau"));
		listePokemon.add(new Pokemon("Salameche", "Feu", "Flameche"));
		listePokemon.add(new Pokemon("Bulbizare", "Plante", "Fouet liane"));
		this.vueListePokemon.afficherListePokemon(listePokemon);
		
		this.navigateur.naviguerVersVuePokemon();
		// this.navigateur.naviguerVersVueListePokemon();
		// this.navigateur.naviguerVersVueAjouterPokemon();
	}
	
	// SINGLETON DEBUT
	private static ControleurPokemon instance = null;
	
	public static ControleurPokemon getInstance() {
		if(null == instance) instance = new ControleurPokemon();
		return instance;
	}
	// SINGLETON FINI
	
}
