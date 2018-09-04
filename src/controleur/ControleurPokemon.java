package controleur;

import vue.NavigateurDesVues;

public class ControleurPokemon {

	private NavigateurDesVues navigateur;
	
	public ControleurPokemon(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		System.out.println("Initialisation du controleur");
		
	}
	
}
