package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.TypePokemon;

public class TypePokemonDAO {
	String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/pokemon";
	String BASEDEDONNEES_USAGER = "postgres";
	String BASEDEDONNEES_MOTDEPASSE = "root";
	private Connection connection = null;
	
	public TypePokemonDAO() {
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
	
	public ArrayList<TypePokemon> getListeTypesPokemon() {
		
		ArrayList<TypePokemon> listeTypesPokemon =  new ArrayList<TypePokemon>();
		Statement requeteListeTypesPokemon;
		try {
			requeteListeTypesPokemon = connection.createStatement();
			ResultSet curseurListeTypesPokemon = requeteListeTypesPokemon.executeQuery("SELECT * FROM \"typePokemon\"");
			while(curseurListeTypesPokemon.next()) {
				
				int id = curseurListeTypesPokemon.getInt("id");
				String libelle = curseurListeTypesPokemon.getString("libelle");
				
				System.out.println(id + " corespond au type " + libelle);
				
				TypePokemon typePokemon = new TypePokemon(id, libelle);
				listeTypesPokemon.add(typePokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeTypesPokemon;
	}
	
	public TypePokemon getTypeUnPokemon(int idTypePokemon) {
		
		TypePokemon typeDuPokemon = new TypePokemon();
		Statement requeteTypeUnPokemon;
		
		try {
			requeteTypeUnPokemon = connection.createStatement();
			ResultSet curseurTypeUnPokemon = requeteTypeUnPokemon.executeQuery("SELECT * FROM \"typePokemon\" WHERE id = " + idTypePokemon);
			curseurTypeUnPokemon.next();
			
			int id = curseurTypeUnPokemon.getInt("id");
			String libelle = curseurTypeUnPokemon.getString("libelle");
			
			typeDuPokemon = new TypePokemon(id, libelle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return typeDuPokemon;
	}

}
