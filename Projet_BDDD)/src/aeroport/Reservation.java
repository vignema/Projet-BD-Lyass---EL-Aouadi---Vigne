package aeroport;

import java.sql.Date;

public class Reservation {
	private int id;
	private Date dateReservation;
	private Client client;
	
	public Reservation(int id, Date dateReservation, Client client){
		this.id = id;
		this.dateReservation = dateReservation;
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Reservation n° "+id+" du "+dateReservation+" par le client n° "+client.getId()+" ("+client.getNom()+" "+client.getPrenom()+")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
