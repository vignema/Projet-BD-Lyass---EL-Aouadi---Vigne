package DAO;


import java.sql.*;
import java.util.ArrayList;

import aeroport.PlaceReserver;

public class PlaceReserverDAO implements DAOFactory<PlaceReserver>{
	
	public void add(PlaceReserver placeReserver)
	{
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into Reservations values((select (MAX(numReserPlaRes)+1) from Reservations) ,?,?,?");
			
			stat.setString(1, placeReserver.getVol().getId());
			stat.setInt(2,placeReserver.getPlace().getId());
			stat.setFloat(3, placeReserver.getPrixPlaRes());
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout d'une place");
		}
		
	}
	
	public PlaceReserver get(String idPlaceReserver)
	{
		return null;
	}
	
	public void update(PlaceReserver placeReserver)
	{
		
	}
	
	
	public void delete(String idReservation)
	{
		try
		{
			DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM PlaceReserver WHERE numReserPlaRes = ?");
			stat.setInt(1, Integer.parseInt(idReservation));
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression des places réserver");
		}
	}
	
public static ArrayList<PlaceReserver> getPlacesReser(String idReservation){
		
		int idReserv = Integer.parseInt(idReservation);
		
		ArrayList<PlaceReserver> liste = new ArrayList<PlaceReserver>();
		
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from PlaceReserver WHERE numReserPlaRes = ?");
			stat.setInt(1,idReserv);
			ResultSet res = stat.executeQuery();
			while(res.next()){
				liste.add(new PlaceReserver(
						new VolDAO().get(res.getString("numVolPlaRes")),
						new PlaceDAO().get(res.getString("numPlaPlacRes")),
						res.getInt("prixPlaRes")
						));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des places d'une réservation");
		}
		
		return liste;
	}

}
