package aeroport;

public class Modele {
	private String numMod;
	private int nbrPiloteMod;
	private float rayonActMod;
	
	public Modele(String numMod,int nbrPiloteMod,float rayonActMod)
	{
		this.numMod=numMod;
		this.nbrPiloteMod=nbrPiloteMod;
		this.rayonActMod=rayonActMod;
	}

	public String getId(){
		return numMod;
	}
}
