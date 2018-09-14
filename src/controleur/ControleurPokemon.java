package controleur;

import java.util.ArrayList;

import donnee.PokemonDAO;
import donnee.TypePokemonDAO;
import modele.Pokemon;
import modele.TypePokemon;
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
	TypePokemonDAO typePokemonDAO = null;
	
	public ControleurPokemon() {
		System.out.println("Initialisation du controleur");
		this.pokemonDAO = new PokemonDAO();
		this.typePokemonDAO = new TypePokemonDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		
		this.vueAjouterPokemon = navigateur.getVueAjouterPokemon();
		this.vuePokemon = navigateur.getVuePokemon();
		this.vueListePokemon= navigateur.getVueListePokemon();
		
		//// TEST ////
		TypePokemon typePokemon = new TypePokemon(1, "Normal");
		Pokemon pokemon = (new Pokemon("Salameche", typePokemon, 5, "pokemon terrestre"));
		this.vuePokemon.afficherPokemon(pokemon);
		
		/// TEST ///
		PokemonDAO pokemonDAO = new PokemonDAO();
		ArrayList<Pokemon> listePokemon = pokemonDAO.listePokemon();
		this.vueListePokemon.afficherListePokemon(listePokemon);
		
		//// afficher une vue ////
		//this.navigateur.naviguerVersVuePokemon();
		this.navigateur.naviguerVersVueListePokemon();
		//this.navigateur.naviguerVersVueAjouterPokemon();
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
		this.pokemonDAO.ajouterPokemon(pokemon);
		this.navigateur.naviguerVersVueListePokemon();
	}
	
	public void notifierNaviguerEditerMouton() {
		System.out.println("ControleurMouton.notifierEditerMouton()");
		this.navigateur.naviguerVersVueModifierPokemon();
		
	}
	
}
