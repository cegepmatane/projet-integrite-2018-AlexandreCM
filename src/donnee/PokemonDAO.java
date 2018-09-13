package donnee;

import java.sql.DriverManager;
import java.sql.SQLException;
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
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/pokemon";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "root";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.simulerListePokemon();
	}
}
