package aeroport;

import java.sql.Time;
import java.sql.Date;

public class Vol {
	private String id, aeroDepart, aeroArrivee;
	private Time heureDepart;
	private Date dateDepart;
	private int duree;
	private float distance;
	private boolean terminer;
	Avion avion;
	
	public Vol(String id, String aeroDepart, String aeroArrivee, Time heureDepart, Date dateDepart, int duree, float distance, boolean terminer, Avion avion){
		this.id=id;
		this.aeroDepart = aeroDepart;
		this.aeroArrivee=aeroArrivee;
		this.heureDepart=heureDepart;
		this.dateDepart=dateDepart;
		this.duree=duree;
		this.distance=distance;
		this.terminer=terminer;
		this.avion = avion;
	}
	
	public void setTerminer(){
		terminer = true;
	}
	
	public String getId() {
		return id;
	}
	public String getAeroDep(){
		return aeroDepart;
	}
	public Avion getAvion(){
		return avion;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}

	public String getAeroArrivee() {
		return aeroArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public int getDuree() {
		return duree;
	}


	public float getDistance() {
		return distance;
	}

	public boolean isTerminer() {
		return terminer;
	}
}
