package donnee;

public interface PokemonSQL {
	
	public static final String SQL_LISTER_POKEMON = "SELECT * FROM pokemon ORDER BY id";
	public static final String SQL_SELECT_POKEMON = "SELECT * FROM pokemon WHERE id = ?;";
	public static final String SQL_INSERT_POKEMON = "INSERT INTO pokemon(nom, \"idTypePokemon\", poids, description) VALUES(?, ?, ?, ?);";
	public static final String SQL_UPDATE_POKEMON = "UPDATE public.pokemon SET nom= ?, \"idTypePokemon\"= ?, poids= ?, description= ? WHERE id =  ?;";

}
