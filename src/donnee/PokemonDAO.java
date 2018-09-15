package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Pokemon;
import modele.TypePokemon;

public class PokemonDAO {
	
	private Connection connection = null;
	
	public PokemonDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public ArrayList<Pokemon> getListePokemon() {
		System.out.println("PokemonDAO : listePokemon()");
		
		ArrayList<Pokemon> listePokemon =  new ArrayList<Pokemon>();
		TypePokemonDAO typePokemonDAO = new TypePokemonDAO();
		TypePokemon typeDuPokemon = new TypePokemon();
		
		Statement requeteListePokemon;
		
		try {
			requeteListePokemon = connection.createStatement();
			ResultSet curseurListePokemon = requeteListePokemon.executeQuery("SELECT * FROM pokemon ORDER BY id");
			while(curseurListePokemon.next()) {
				
				int id = curseurListePokemon.getInt("id");
				String nom = curseurListePokemon.getString("nom");
				float poids = curseurListePokemon.getFloat("poids");
				String description = curseurListePokemon.getString("description");
				
				int idTypePokemon = curseurListePokemon.getInt("idTypePokemon");
				typeDuPokemon = typePokemonDAO.getTypeUnPokemon(idTypePokemon);
				
				Pokemon pokemon = new Pokemon(nom, typeDuPokemon, poids, description);
				pokemon.setId(id);
				//System.out.println(pokemon.getNom() + "est de type " + pokemon.getType().getLibelle());
				listePokemon.add(pokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listePokemon;
	}
	
	public Pokemon getUnPokemon(int idPokemon) {
		System.out.println("PokemonDAO : rapporterPokemon(int idPokemon) => idPokemon = " + idPokemon);
		
		TypePokemonDAO typePokemonDAO = new TypePokemonDAO();
		TypePokemon typeDuPokemon = new TypePokemon();

		PreparedStatement requeteLePokemon;
		
		try {
			// TODO factoriser chaines magiques dans des constantes - si possible interfaces
			
			String SQL_RAPPORTER_POKEMON = "SELECT * FROM pokemon WHERE id = ?";
			requeteLePokemon = connection.prepareStatement(SQL_RAPPORTER_POKEMON);
			requeteLePokemon.setInt(1, idPokemon);
			
			ResultSet curseurPokemon = requeteLePokemon.executeQuery();
			curseurPokemon.next();
			
			int id = curseurPokemon.getInt("id");
			String nom = curseurPokemon.getString("nom");
			float poids = curseurPokemon.getFloat("poids");
			String description = curseurPokemon.getString("description");
			int idTypePokemon = curseurPokemon.getInt("idTypePokemon");
			typeDuPokemon = typePokemonDAO.getTypeUnPokemon(idTypePokemon);
			
			Pokemon pokemon = new Pokemon(nom, typeDuPokemon, poids, description);
			pokemon.setId(id);
			return pokemon;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void ajouterPokemon(Pokemon pokemon) {
		System.out.println("PokemonDAO : ajouterPokemon(Pokemon pokemon) => pokemon = " + pokemon.getNom());
		
		try {
			String sqlAjouterPokemon = "INSERT INTO pokemon(nom, \"idTypePokemon\", poids, description) VALUES(?, ?, ?, ?)";
			PreparedStatement requeteAjouterPokemon = connection.prepareStatement(sqlAjouterPokemon);
			
			requeteAjouterPokemon.setString(1, pokemon.getNom());
			requeteAjouterPokemon.setInt(2, pokemon.getType().getId());
			requeteAjouterPokemon.setDouble(3, pokemon.getPoids());
			requeteAjouterPokemon.setString(4, pokemon.getDescription());
			
			requeteAjouterPokemon.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifierPokemon(Pokemon pokemon) {
		System.out.println("PokemonDAO : modifierPokemon(Pokemon pokemon) => pokemon = " + pokemon.getNom());
		
		try {
			String sqlModifierPokemon = "UPDATE public.pokemon SET nom= ?, \"idTypePokemon\"= ?, poids= ?, description= ? WHERE id =  ?;";
			PreparedStatement requeteModifierPokemon = connection.prepareStatement(sqlModifierPokemon);

			requeteModifierPokemon.setString(1, pokemon.getNom());
			requeteModifierPokemon.setInt(2, pokemon.getType().getId());
			requeteModifierPokemon.setDouble(3, pokemon.getPoids());
			requeteModifierPokemon.setString(4, pokemon.getDescription());
			requeteModifierPokemon.setInt(5, pokemon.getId());
			
			requeteModifierPokemon.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
