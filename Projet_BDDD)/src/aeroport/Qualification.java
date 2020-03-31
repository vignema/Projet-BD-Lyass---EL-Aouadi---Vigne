package aeroport;

public class Qualification {
	private Modele modele;
	private int nbHeure;
	
	public Qualification(Modele modele, int nbHeure){
		this.modele = modele;
		this.nbHeure = nbHeure;
	}
	
	public void addHeure(int value){
		nbHeure += value;
	}
	
	public Modele getModele(){
		return modele;
	}
	
	public int getNbHeure(){
		return nbHeure;
	}
	
}
