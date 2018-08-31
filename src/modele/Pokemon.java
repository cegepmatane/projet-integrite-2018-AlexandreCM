package modele;

public class Pokemon {
	
	private String nom;
	private String type;
	private String capacite;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(String nom, String type, String capacite) {
		super();
		this.nom = nom;
		this.type = type;
		this.capacite = capacite;
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

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	
}
