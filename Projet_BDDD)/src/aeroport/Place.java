package aeroport;

public class Place {
	private int numPla;
	private Avion avion ;
	private Classe classes;
	private Position positions;
	
	public Place(int numPla,Avion avion,Classe classes,Position positions)
	{
		this.numPla=numPla;
		this.avion=avion;
		this.classes=classes;
		this.positions=positions;
	}
	
	public int getId(){
		return numPla;
	}

	

	public void setNumPla(int numPla) {
		this.numPla = numPla;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Classe getClasses() {
		return classes;
	}

	public void setClasses(Classe classes) {
		this.classes = classes;
	}

	public Position getPositions() {
		return positions;
	}

	public void setPositions(Position positions) {
		this.positions = positions;
	}
	
	
}
