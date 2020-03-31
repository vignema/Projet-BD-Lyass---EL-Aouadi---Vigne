package aeroport;

public class Client extends Personne{
	int nbHeure;
	String numPass;
	
	public Client(int id, String nom, String prenom, int numRue, String rue, int cp, String ville, String pays, String numPass, int nbHeure){
		super(id,
		nom,
		prenom,
		numRue,
		rue,
		cp,
		ville,
		pays);
		this.numPass = numPass;
		this.nbHeure = nbHeure;
	}
	
	public void addHeure(int value){
		nbHeure += value;
	}
		
	public int getNbHeure(){
		return nbHeure;
	}
}
