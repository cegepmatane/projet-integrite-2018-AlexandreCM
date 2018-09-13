package modele;

public class Pokemon {
	
	private int id;
	private String nom;
	private TypePokemon typePokemon;
	private double poids;
	private String description;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(String nom, TypePokemon typePokemon, double poids, String description) {
		super();
		this.nom = nom;
		this.typePokemon = typePokemon;
		this.poids = poids;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePokemon getType() {
		return typePokemon;
	}

	public void setType(TypePokemon typePokemon) {
		this.typePokemon = typePokemon;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
