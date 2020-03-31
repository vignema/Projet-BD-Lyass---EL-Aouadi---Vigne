package DAO;

import java.sql.*;

import aeroport.*;
import main.TheConnection;
public interface DAOFactory <T> {
	
	public static final Connection cnx = TheConnection.getInstance();
	//public static DAO getClasseDAO(){ return new ClasseDAO(conn); }
	
	    public abstract void add (T item);
	    public abstract T get (String item);
	    public abstract void update (T item);
	    public abstract void delete (String item);
	    /* Avion : 
	     public abstract void add(Avion avion);
		 public abstract Avion get(int idAvion);
		 public abstract void update(Avion avion);
		 public abstract void delete(int idAvion);
	
		 // Catalogue : 
	     public abstract void add(Catalogue catalogue);
		 public abstract Avion get(int idcatalogue);
		 public abstract void update(Catalogue catalogue);
		 public abstract void delete(int idcatalogue);
		 
		 // Classe : 
	     public abstract void add(Classe classe);
		 public abstract Avion get(int idClasse);
		 public abstract void update(Classe classe);
		 public abstract void delete(int idClasse);
		 
		// Client : 
	     public abstract void add(Client client);
		 public abstract Avion get(int idClient);
		 public abstract void update(Client client);
		 public abstract void delete(int idClient);
		 
		// Hotesse : 
	     public abstract void add(Hotesse hotesse);
		 public abstract Avion get(int idHotesse);
		 public abstract void update(Hotesse hotesse);
		 public abstract void delete(int idHotesse);
		 
		// Modele : 
	     public abstract void add(Modele modele);
		 public abstract Avion get(int idModele);
		 public abstract void update(Modele modele);
		 public abstract void delete(int Modele);
		 
		// Parler : 
	     public abstract void add(Parler parler);
		 public abstract Avion get(int idParler);
		 public abstract void update(Parler parler);
		 public abstract void delete(int idParler);
		 
		// Personne : 
	     public abstract void add(Personne personne);
		 public abstract Avion get(int idPersonne);
		 public abstract void update(Personne personne);
		 public abstract void delete(int idPersonne);
		 
		// Personnel : 
	     public abstract void add(Personnel personne);
		 public abstract Avion get(int idPersonnel);
		 public abstract void update(Personnel personne);
		 public abstract void delete(int idPersonnel);
		 
		// Pilote : 
	     public abstract void add(Pilote pilote);
		 public abstract Avion get(int idPilote);
		 public abstract void update(Pilote pilote);
		 public abstract void delete(int idPilote);
		 
		// Place : 
	     public abstract void add(Place place);
		 public abstract Avion get(int idPlace);
		 public abstract void update(Place place);
		 public abstract void delete(int idPlace);
		 
		// PlaceReserver : 
	     public abstract void add(PlaceReserver placer);
		 public abstract Avion get(int idPlaceReserver);
		 public abstract void update(PlaceReserver placer);
		 public abstract void delete(int idPlaceReserver);
		 
		// PlacesMini : 
	     public abstract void add(PlacesMini placesmini);
		 public abstract Avion get(int idPlacesMini);
		 public abstract void update(PlacesMini placesmini);
		 public abstract void delete(int idPlacesMini);
		 
		// Position : 
	     public abstract void add(Position position);
		 public abstract Avion get(int idPosition);
		 public abstract void update(Position idPosition);
		 public abstract void delete(int idPosition);
		 
			// Qualification  : 
	     public abstract void add(Qualification qualification);
		 public abstract Avion get(int idQualification);
		 public abstract void update(Qualification qualification);
		 public abstract void delete(int idQualification);
		 
		// Reservation  : 
	     public abstract void add(Reservation reservation);
		 public abstract Avion get(int idReservation);
		 public abstract void update(Reservation reservation);
		 public abstract void delete(int idReservation);
		 
		// Vol  : 
	     public abstract void add(Vol vol);
		 public abstract Avion get(int idVol);
		 public abstract void update(Vol idVol);
		 public abstract void delete(int idVol);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	/*public static DAO getAvionDAO(){ return new AvionDAO(conn); }
	public static DAO getCatalogueDAO(){ return new CatalogueDAO(conn); }
	public static DAO getClasseDAO(){ return new ClasseDAO(conn); } 
	public static DAO getClientDAO(){ return new ClientDAO(conn); } 
	
	public static DAO getHotesseDAO(){ return new HotesseDAO(conn); } 
	public static DAO getModeleDAO(){ return new ModeleDAO(conn); } 
	public static DAO getParlerDAO(){ return new ParlerDAO(conn); } 
	public static DAO getPersonneDAO(){ return new PersonneDAO(conn); } 
	public static DAO getPersonnelDAO(){ return new PersonnelDAO(conn); } 
	public static DAO getPiloteDAO(){ return new PiloteDAO(conn); } 
	public static DAO getPlaceDAO(){ return new PlaceDAO(conn); } 
	public static DAO getPlaceReserverDAO(){ return new PlaceReserverDAO(conn); } 
	public static DAO getPlacesMiniDAO(){ return new PlacesMiniDAO(conn); } 
	public static DAO getPositionDAO(){ return new PositionDAO(conn); } 
	public static DAO getQualificationDAO(){ return new QualificationDAO(conn); } 
	public static DAO getReservationDAO(){ return new ReservationDAO(conn); } 
	public static DAO getVolDAO(){ return new VolDAO(conn); } */

}
