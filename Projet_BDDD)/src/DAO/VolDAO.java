package DAO;


import java.sql.*;
import java.util.ArrayList;

import aeroport.Modele;
import aeroport.Vol;
import aeroport.Personnel;
import aeroport.Pilote;
import aeroport.Hotesse;
import aeroport.Client;
import aeroport.Personne;

public class VolDAO implements DAOFactory<Vol> {
	
	public void add(Vol vol)
	{
		
	}
	
	public Vol get(String idVol)
	{
		Vol vol = null;
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from vols WHERE numVol = ?");
			stat.setString(1,idVol);
			ResultSet res = stat.executeQuery();
			if(res.next()){
				vol = new Vol(res.getString("numVol"),
						res.getString("aeroDepVol"),
						res.getString("aeroArrVol"),
						res.getTime("heureDepVol"),
						res.getDate("dateDepVol"),
						res.getInt("dureeVol"),
						res.getFloat("distVol"),
						res.getBoolean("terminVol")
						,new AvionDAO().get(Integer.toString(res.getInt("numAvVol"))));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération du vol");
		}
		return vol;
	}
	
	public void update(Vol vol)
	{
		try
		{
			DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("update vols set "
					+ "aeroDepVol = ? ,"
					+ "aeroArrVol = ? ,"
					+ "heureDepVol = ? ,"
					+ "dateDepVol = ? ,"
					+ "dureeVol = ? ,"
					+ "distVol = ? ,"
					+ "terminVol = ? ,"
					+ "numAvVol = ? "
					+ " WHERE numVol = ?");
			stat.setString(1, vol.getAeroDep());
			stat.setString(2, vol.getAeroArrivee());
			stat.setTime(3, vol.getHeureDepart());
			stat.setDate(4, vol.getDateDepart());
			stat.setInt(5,vol.getDuree());
			stat.setFloat(6, vol.getDistance());
			stat.setBoolean(7, vol.isTerminer());
			stat.setInt(8,vol.getAvion().getNumAv());
			stat.setString(9, vol.getId());
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la mise à jour du vol");
		}
	}
	
	
	public void delete(String idVol)
	{
		
	}
	
	public static String getAll(){
		String listeVol = "ID | Aero. Dep. | Aero. Arr. | Heure Dep. | Duree | Distance | Terminer ? | Avion"+"\n";
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select * from vols");
			while(res.next()){
				
				listeVol +=res.getString("numVol")+" | ";
				listeVol += res.getString("aeroDepVol")+" | ";
				listeVol += res.getString("aeroArrVol")+" | ";
				listeVol += res.getTime("heureDepVol")+" | ";
				listeVol+= res.getDate("dateDepVol")+" | ";
				listeVol+= res.getInt("dureeVol")+" | ";
				listeVol+= res.getInt("distVol")+" | ";
				boolean terminer = res.getBoolean("terminVol");
				if(!terminer){
					listeVol +="Non terminé | ";
				}
				else{
					listeVol +="Terminé | ";
				}
				listeVol+=res.getInt("numAvVol")+"\n";
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			listeVol = "Une erreur s'est produite pendant la récupération des vols";
		}

		return listeVol;
	}
	
	public static ArrayList<Personnel> getEquipage(String id){
		ArrayList<Personnel> equip = new ArrayList<Personnel>();
		equip.addAll(getHotessesVol(id));
		equip.addAll(getPilotesVol(id));
		return equip;
	}
	
	public static ArrayList<Hotesse> getHotessesVol(String idVol){
		ArrayList<Hotesse> list = new ArrayList<Hotesse>();
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from Equipages INNER JOIN Hotesse ON numHotEqui = numHot where numVolEqui = ?");
			stat.setString(1, idVol);
			ResultSet r = stat.executeQuery();
			while(r.next()){
				list.add(new Hotesse(r.getInt("numHot"),
						r.getString("nomHot"),
						r.getString("prenomHot"),
						r.getInt("numRueHot"),
						r.getString("rueHot"),
						r.getInt("cpHot"),
						r.getString("villeHot"),
						r.getString("paysHot"),
						r.getInt("nbHHot")
						));
			}
			stat.close();
			r.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des hotesse du vol");
		}
		return list;
	}
	
	public static ArrayList<Pilote> getPilotesVol(String idVol){
		ArrayList<Pilote> list = new ArrayList<Pilote>();
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from Equipages INNER JOIN Pilote ON numPiloEqui = numPilo where numVolEqui = ?");
			stat.setString(1, idVol);
			ResultSet r = stat.executeQuery();
			while(r.next()){
				list.add(new Pilote(r.getInt("numPilo"),
						r.getString("nomPilo"),
						r.getString("prenomPilo"),
						r.getInt("numRuePilo"),
						r.getString("ruePilo"),
						r.getInt("cpPilo"),
						r.getString("villePilo"),
						r.getString("paysPilo")));
			}
			stat.close();
			r.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des pilotes du vol");
		}
		return list;
	}

	public static ArrayList<Client> getPassagers(String id){
		ArrayList<Client> c = new ArrayList<Client>();
		
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from clients INNER JOIN Reservations ON numCli = numCliReser INNER JOIN PlaceReserver ON numReser = numReserPlaRes WHERE numVolPlaRes = ?");
			stat.setString(1,id);
			ResultSet r = stat.executeQuery();
			while(r.next()){
				c.add(new Client(r.getInt("numCli"),
								r.getString("nomCli"),
								r.getString("prenomCli"),
								r.getInt("numRueCli"),
								r.getString("rueCli"),
								r.getInt("cpCli"),
								r.getString("villeCli"),
								r.getString("paysCli"),
								r.getString("numPassCli"),
								r.getInt("nbHCli")));
			}
			stat.close();
			r.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des passagers du vol");
		}
		return c;
	}
}

	
