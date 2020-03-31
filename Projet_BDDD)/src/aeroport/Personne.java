package aeroport;

public class Personne {

	private int id, numRue, cp;
	private String nom, prenom, rue, ville, pays;
	
	public Personne(int id, String nom, String prenom, int numRue, String rue, int cp, String ville, String pays){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numRue = numRue;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}
	
	public int getId(){
		return id;
	}
	public int getNumRue() {
		return numRue;
	}

	

	public int getCp() {
		return cp;
	}

	

	public String getNom() {
		return nom;
	}

	

	public String getPrenom() {
		return prenom;
	}

	

	public String getRue() {
		return rue;
	}

	

	public String getVille() {
		return ville;
	}

	

	public String getPays() {
		return pays;
	}
}
