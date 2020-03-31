package DAO;

import java.sql.*;
import java.util.ArrayList;

import aeroport.Reservation;

public class ReservationDAO implements DAOFactory<Reservation>  {
	
	public void add(Reservation reservation)
	{
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into Reservations values((select (MAX(numReser)+1) from Reservations),"
					+ "  ?"
					+ " ?"
					);
			stat.setInt(1, reservation.getClient().getId());
			stat.setDate(2,reservation.getDateReservation());
			
			
			stat.close();
			
			
		}
		
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout d'une réservation");
		}
	}
	
	public Reservation get(String idReservation)
	{
		return null;
	}
	
	public void update(Reservation reservation)
	{
		
	}
	
	
	public void delete(String idReservation)
	{
		try
		{
			DAOFactory.cnx.setAutoCommit(true);
			PlaceReserverDAO placeResDAO = new PlaceReserverDAO();
			placeResDAO.delete(idReservation);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM Reservations WHERE numReser = ?");
			stat.setInt(1, Integer.parseInt(idReservation));
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression de la reservation");
		}
	}
	public static String getAll()
	{
		String listeReservations = "Num Reservation | numCliReser | dateReser "+"\n";
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select * from Reservations");
			while(res.next()){
				listeReservations +=res.getInt("numReser")+" | ";
				listeReservations += res.getInt("numCliReser")+" | ";
				listeReservations += res.getDate("dateReser")+"\n";
				
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			listeReservations = "Une erreur s'est produite pendant la récupération des réservations";
		}

		return listeReservations;
	}
	
	public static ArrayList<Reservation> getReservationCli(String idCli) {
		int idClient = Integer.parseInt(idCli);
		
		ArrayList<Reservation> liste = new ArrayList<Reservation>();
		
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from Reservations WHERE numCliReser = ?");
			stat.setInt(1,idClient);
			ResultSet res = stat.executeQuery();
			while(res.next()){
				liste.add(new Reservation(res.getInt("numReser"),
						res.getDate("dateReser"),
						new ClientDAO().get(idCli)
						));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des réservations pour ce client");
		}
		
		return liste;
	}
}
