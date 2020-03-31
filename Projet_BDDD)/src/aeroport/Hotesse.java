package aeroport;

public class Hotesse extends Personnel{
	private int nbHeure;
	
	public Hotesse(int id, String nom, String prenom, int numRue, String rue, int cp, String ville, String pays, int nbHeure){
		super(id,
		nom,
		prenom,
		numRue,
		rue,
		cp,
		ville,
		pays);
		this.nbHeure = nbHeure;
	}
	
	public void addHeure(int val){
		nbHeure += val;
	}
	
	public int getNbHeure(){
		return nbHeure;
	}
}
