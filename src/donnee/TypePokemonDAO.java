package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.TypePokemon;

public class TypePokemonDAO {

	private Connection connection = null;
	
	public TypePokemonDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public ArrayList<TypePokemon> getListeTypesPokemon() {
		System.out.println("TypePokemonDAO : getListeTypesPokemon()");
		
		ArrayList<TypePokemon> listeTypesPokemon =  new ArrayList<TypePokemon>();
		Statement requeteListeTypesPokemon;
		
		try {
			requeteListeTypesPokemon = connection.createStatement();
			ResultSet curseurListeTypesPokemon = requeteListeTypesPokemon.executeQuery("SELECT * FROM \"typePokemon\"");
			while(curseurListeTypesPokemon.next()) {
				
				int id = curseurListeTypesPokemon.getInt("id");
				String libelle = curseurListeTypesPokemon.getString("libelle");
				//System.out.println(id + " corespond au type " + libelle);
				
				TypePokemon typePokemon = new TypePokemon(id, libelle);
				listeTypesPokemon.add(typePokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeTypesPokemon;
	}
	
	public TypePokemon getTypeUnPokemon(int idTypePokemon) {
		//System.out.println("TypePokemonDAO : getTypeUnPokemon()");
		
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
