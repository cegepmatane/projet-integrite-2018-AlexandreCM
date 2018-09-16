package donnee;

public interface TypePokemonSQL {
	
	public static final String SQL_LISTER_TYPE_POKEMON = "SELECT * FROM \"typePokemon\" ORDER BY id";
	public static final String SQL_LISTER_TYPE_UN_POKEMON = "SELECT * FROM \"typePokemon\" WHERE id = ?";

}
