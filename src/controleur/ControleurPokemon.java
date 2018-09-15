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
		System.out.println("Initialisation controleurs");
		this.pokemonDAO = new PokemonDAO();
		this.typePokemonDAO = new TypePokemonDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		
		this.vueAjouterPokemon = navigateur.getVueAjouterPokemon();
		this.vueModifierPokemon = navigateur.getVueModifierPokemon();
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
		//this.navigateur.naviguerVersVueModifierPokemon();
	}
	
	// SINGLETON DEBUT
	private static ControleurPokemon instance = null;
	
	public static ControleurPokemon getInstance() {
		if(null == instance) instance = new ControleurPokemon();
		return instance;
	}
	// SINGLETON FINI
	
	public void notifierAjouterPokemon()
	{
		System.out.println("ControleurPokemon.notifierEnregistrerPokemon()");
		Pokemon pokemon = this.navigateur.getVueAjouterPokemon().demanderPokemon();
		this.pokemonDAO.ajouterPokemon(pokemon);
		this.navigateur.naviguerVersVueListePokemon();
	}
	
	public void notifierNaviguerVersModifierPokemon(Pokemon pokemon) {
		System.out.println("ControleurMouton.notifierEditerMouton() : " + pokemon.getNom());
		this.vueModifierPokemon.afficherPokemon(this.pokemonDAO.rapporterPokemon(pokemon.getId()));
		this.navigateur.naviguerVersVueModifierPokemon();
	}
	
	public void notifierEnregistrerModificationPokemon() {
		System.out.println("ControleurPokemon.notifierEnregistrerModificationPokemon()");
		Pokemon pokemon = this.navigateur.getVueModifierPokemon().demanderModificationPokemon();
		this.pokemonDAO.modifierPokemon(pokemon);
		this.navigateur.naviguerVersVueListePokemon();
	}
	
}
