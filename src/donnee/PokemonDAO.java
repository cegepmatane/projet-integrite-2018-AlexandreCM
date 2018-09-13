package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Pokemon;
import modele.TypePokemon;

public class PokemonDAO {
	
	String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/pokemon";
	String BASEDEDONNEES_USAGER = "postgres";
	String BASEDEDONNEES_MOTDEPASSE = "root";
	private Connection connection = null;
	
	public PokemonDAO() {
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Pokemon> listePokemon() {
		
		ArrayList<Pokemon> listePokemon =  new ArrayList<Pokemon>();
		TypePokemonDAO typePokemonDAO = new TypePokemonDAO();
		TypePokemon typeDuPokemon = new TypePokemon();
		
		Statement requeteListePokemon;
		try {
			
			requeteListePokemon = connection.createStatement();
			ResultSet curseurListePokemon = requeteListePokemon.executeQuery("SELECT * FROM pokemon");
			while(curseurListePokemon.next()) {
				
				String nom = curseurListePokemon.getString("nom");
				float poids = curseurListePokemon.getFloat("poids");
				String description = curseurListePokemon.getString("description");
				
				int idTypePokemon = curseurListePokemon.getInt("idTypePokemon");
				typeDuPokemon = typePokemonDAO.getTypeUnPokemon(idTypePokemon);
				
				Pokemon pokemon = new Pokemon(nom, typeDuPokemon, poids, description);
				System.out.println(pokemon.getNom() + "est de type " + pokemon.getType().getLibelle());
				listePokemon.add(pokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listePokemon;
	}
	
	
	public void ajouterPokemon(Pokemon pokemon) {
		System.out.println("PokemonDAO.ajouterPokemon()");
		try {
			Statement requeteAjouterPokemon = connection.createStatement();
			// TODO changer pour requete preparee
			String sqlAjouterPokemon = "INSERT INTO pokemon(nom, type, poids, description) VALUES('"+pokemon.getNom()+"','"+pokemon.getType()+"','"+pokemon.getPoids()+"','"+pokemon.getDescription()+"')";
			System.out.println("SQL : " + sqlAjouterPokemon);
			requeteAjouterPokemon.execute(sqlAjouterPokemon);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
