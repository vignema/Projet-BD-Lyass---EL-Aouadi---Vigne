package aeroport;

public class Avion {
	private int numAv;
	private Modele modele;
	
	public Avion(int numAv,Modele modele)
	{
		this.numAv=numAv;
		this.modele=modele;
	}
	 public int getNumAv(){
		 return numAv;
	 }
	 public Modele getModele(){
		 return modele;
	 }
}
