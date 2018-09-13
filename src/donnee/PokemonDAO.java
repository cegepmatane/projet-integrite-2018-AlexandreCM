package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Pokemon;

public class PokemonDAO {
	
	double test = 4.3;

	private ArrayList<Pokemon> simulerListePokemon() {
		
		ArrayList<Pokemon> listePokemon = new ArrayList<Pokemon>();
		listePokemon.add(new Pokemon("Carapuce", 4, 5));
		listePokemon.add(new Pokemon("Salameche", 2, 5));
		listePokemon.add(new Pokemon("Bulbizare", 3, 4.3));
		
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
		
		ArrayList<Pokemon> listePokemon =  new ArrayList<Pokemon>();
		try {
			Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			
			Statement requeteListePokemon = connection.createStatement();
			ResultSet curseurListePokemon = requeteListePokemon.executeQuery("SELECT * FROM pokemon");
			while(curseurListePokemon.next()) {
				
				String nom = curseurListePokemon.getString("nom");
				int type = curseurListePokemon.getInt("type");
				float poids = curseurListePokemon.getFloat("poids");
				
				System.out.println(nom + " de type " + type + " pese " + poids + "kg ");
				
				Pokemon pokemon = new Pokemon(nom, type, poids);
				listePokemon.add(pokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.simulerListePokemon();
	}
}
