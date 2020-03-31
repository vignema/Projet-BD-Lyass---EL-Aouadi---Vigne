package aeroport;

public enum Classe {
	ECO("Classe Economique"),
	PREMIERE("1ére Classe"),
	AFFAIRE("Classe Affaire");
String nom;
	
	Classe(String nom)
	{
		this.nom=nom;
	};
    public String getNom()
	{
		return this.nom;
	}
}