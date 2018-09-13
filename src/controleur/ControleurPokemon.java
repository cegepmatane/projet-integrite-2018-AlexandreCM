package controleur;

import java.util.ArrayList;

import donnee.PokemonDAO;
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
	
	PokemonDAO pokemonDAO = null;
	
	public ControleurPokemon() {
		System.out.println("Initialisation du controleur");
		this.pokemonDAO = new PokemonDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		
		this.vueAjouterPokemon = navigateur.getVueAjouterPokemon();
		this.vuePokemon = navigateur.getVuePokemon();
		this.vueListePokemon= navigateur.getVueListePokemon();
		
		//// TEST ////
		Pokemon pokemon = (new Pokemon("Salameche", 2, 5));
		this.vuePokemon.afficherPokemon(pokemon);
		
		/// TEST ///
		PokemonDAO pokemonDAO = new PokemonDAO();
		ArrayList<Pokemon> listePokemon = pokemonDAO.listePokemon();
		this.vueListePokemon.afficherListePokemon(listePokemon);
		
		//// afficher une vue ////
		//this.navigateur.naviguerVersVuePokemon();
		//this.navigateur.naviguerVersVueListePokemon();
		this.navigateur.naviguerVersVueAjouterPokemon();
	}
	
	// SINGLETON DEBUT
	private static ControleurPokemon instance = null;
	
	public static ControleurPokemon getInstance() {
		if(null == instance) instance = new ControleurPokemon();
		return instance;
	}
	// SINGLETON FINI
	
	public void notifierEnregistrerPokemon()
	{
		System.out.println("ControleurPokemon.notifierEnregistrerPokemon()");
		Pokemon pokemon = this.navigateur.getVueAjouterPokemon().demanderPokemon();
		//this.pokemonDAO.ajouterPokemon(pokemon);
		this.navigateur.naviguerVersVueListePokemon();
	}
	
}
