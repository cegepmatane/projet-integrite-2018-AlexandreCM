package modele;

public class Pokemon {
	
	private int id;
	private String nom;
	private int type;
	private double poids;
	private String description;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(String nom, int type, double poids) {
		super();
		this.nom = nom;
		this.type = type;
		this.poids = poids;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
