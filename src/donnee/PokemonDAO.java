package donnee;

import java.util.ArrayList;

import modele.Pokemon;

public class PokemonDAO {

	private ArrayList<Pokemon> simulerListePokemon() {
		
		ArrayList<Pokemon> listePokemon = new ArrayList<Pokemon>();
		listePokemon.add(new Pokemon("Carapuce", "Eau", "Bulled'eau"));
		listePokemon.add(new Pokemon("Salameche", "Feu", "Flameche"));
		listePokemon.add(new Pokemon("Bulbizare", "Plante", "Fouet liane"));
		
		return listePokemon;
	}
	
	public ArrayList<Pokemon> listePokemon() {
		return this.simulerListePokemon();
	}
}
