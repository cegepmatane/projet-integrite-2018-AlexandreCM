package modele;

public class Pokemon {
	
	private int id;
	private String nom;
	private String type;
	private String poids;
	private String description;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(String nom, String type, String description) {
		super();
		this.nom = nom;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
