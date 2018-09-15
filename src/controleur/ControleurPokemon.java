package controleur;

import java.util.ArrayList;

import donnee.PokemonDAO;
import donnee.TypePokemonDAO;
import modele.Pokemon;
import modele.TypePokemon;
import vue.NavigateurDesVues;
import vue.VueAjouterPokemon;
import vue.VueListePokemon;
import vue.VueModifierPokemon;
import vue.VuePokemon;

public class ControleurPokemon {

	private NavigateurDesVues navigateur;
	
	private VuePokemon vuePokemon = null;
	private VueListePokemon vueListePokemon = null;
	private VueAjouterPokemon vueAjouterPokemon = null;
	private VueModifierPokemon vueModifierPokemon = null;
	
	PokemonDAO pokemonDAO = null;
	TypePokemonDAO typePokemonDAO = null;
	
	public ControleurPokemon() {
		System.out.println("ControleurPokemon : Initialisation controleurs");
		this.pokemonDAO = new PokemonDAO();
		this.typePokemonDAO = new TypePokemonDAO();
	}
	
	// SINGLETON DEBUT
	private static ControleurPokemon instance = null;
	
	public static ControleurPokemon getInstance() {
		if(null == instance) instance = new ControleurPokemon();
		return instance;
	}
	// SINGLETON FINI
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		
		this.vueAjouterPokemon = navigateur.getVueAjouterPokemon();
		this.vueModifierPokemon = navigateur.getVueModifierPokemon();
		this.vuePokemon = navigateur.getVuePokemon();
		this.vueListePokemon= navigateur.getVueListePokemon();
		
		//// TEST ////
		TypePokemon typePokemon = new TypePokemon(1, "feu");
		Pokemon pokemon = (new Pokemon("Salameche", typePokemon, 5.2, "pokemon terrestre"));
		this.vuePokemon.afficherPokemon(pokemon);
		
		/// TEST ///
		PokemonDAO pokemonDAO = new PokemonDAO();
		ArrayList<Pokemon> listePokemon = pokemonDAO.getListePokemon();
		this.vueListePokemon.afficherListePokemon(listePokemon);
		
		//// afficher une vue ////
		//this.navigateur.naviguerVersVuePokemon();
		this.navigateur.naviguerVersVueListePokemon();
		//this.navigateur.naviguerVersVueAjouterPokemon();
		//this.navigateur.naviguerVersVueModifierPokemon();
	}
	
	public void notifierAjouterPokemon()
	{
		System.out.println("ControleurPokemon : notifierAjouterPokemon()");
		Pokemon pokemon = this.navigateur.getVueAjouterPokemon().demanderPokemon();
		this.pokemonDAO.ajouterPokemon(pokemon);
		this.vueListePokemon.afficherListePokemon(this.pokemonDAO.getListePokemon()); // TODO optimiser
		this.navigateur.naviguerVersVueListePokemon();
	}
	
	public void notifierNaviguerVersVueModifierPokemon(Pokemon pokemon) {
		System.out.println("ControleurPokemon : notifierNaviguerVersVueModifierPokemon(Pokemon pokemon) => " + pokemon.getNom());
		this.vueModifierPokemon.afficherPokemon(this.pokemonDAO.getUnPokemon(pokemon.getId()));
		this.navigateur.naviguerVersVueModifierPokemon();
	}
	
	public void notifierEnregistrerModificationPokemon() {
		System.out.println("ControleurPokemon : notifierEnregistrerModificationPokemon()");
		Pokemon pokemon = this.navigateur.getVueModifierPokemon().demanderModificationPokemon();
		this.pokemonDAO.modifierPokemon(pokemon);
		this.vueListePokemon.afficherListePokemon(this.pokemonDAO.getListePokemon()); // TODO optimiser
		this.navigateur.naviguerVersVueListePokemon();
	}

	public void notifierNaviguerVersVueAjouterPokemon() {
		System.out.println("ControleurPokemon : notifierNaviguerVersVueAjouterPokemon()");
		this.navigateur.naviguerVersVueAjouterPokemon();
	}

	public void notifierRetourVersVueListePokemon() {
		System.out.println("ControleurPokemon : notifierRetourVersVueListePokemon()");
		this.navigateur.naviguerVersVueListePokemon();
	}
	
}
