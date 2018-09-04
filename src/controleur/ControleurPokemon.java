package controleur;

import vue.NavigateurDesVues;
import vue.VueAjouterPokemon;
import vue.VueListePokemon;
import vue.VuePokemon;

public class ControleurPokemon {

	private NavigateurDesVues navigateur;
	
	public ControleurPokemon(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		System.out.println("Initialisation du controleur");
		
		this.navigateur.naviguerVersVuePokemon();
		this.navigateur.naviguerVersVueListePokemon();
		this.navigateur.naviguerVersVueAjouterPokemon();
	}
	
}
