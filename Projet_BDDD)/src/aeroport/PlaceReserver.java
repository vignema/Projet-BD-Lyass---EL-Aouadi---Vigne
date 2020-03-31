package aeroport;

public class PlaceReserver {
	private Vol vol;
	private Place place;
	private float prixPlaRes;
	
	public PlaceReserver(Vol vol,Place place,float prixPlaRes)
	{
		this.vol=vol;
		this.place=place;
		this.prixPlaRes=prixPlaRes;
	}
	
	@Override
	public String toString() {
		return "\t"+"Vol n°" + vol.getId() + " - Place n°" + place.getId() + " - Prix "
				+ prixPlaRes;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public float getPrixPlaRes() {
		return prixPlaRes;
	}

	public void setPrixPlaRes(float prixPlaRes) {
		this.prixPlaRes = prixPlaRes;
	}
	
}
