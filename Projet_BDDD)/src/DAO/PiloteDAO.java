package DAO;

import aeroport.Pilote;
import aeroport.Qualification;

import java.sql.*;
import java.util.ArrayList;
public class PiloteDAO implements DAOFactory<Pilote> {
	
	
	public static String getAll()
	{
		String listePilotes = "num Pilote | nom Pilote | prenom Pilote |num Rue|rue|code postale|ville|pays|nbHeures"+"\n";
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select numPilo, nomPilo, prenomPilo, numRuePilo, ruePilo, cpPilo, villePilo, paysPilo, (select SUM(nbHQual) from qualification where numPiloQual = PIL.numPilo) as nbH from pilote PIL");
			while(res.next()){
				listePilotes +=res.getInt("numPilo")+" | ";
				listePilotes += res.getString("nomPilo")+" | ";
				listePilotes += res.getString("prenomPilo")+" | ";
				listePilotes +=res.getInt("numRuePilo")+" | ";
				listePilotes += res.getString("ruePilo")+" | ";
				listePilotes += res.getInt("cpPilo")+" | ";
				listePilotes +=res.getString("villePilo")+" | ";
				listePilotes += res.getString("paysPilo")+" | ";
				listePilotes +=res.getInt("nbH")+"\n";
				
				
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			listePilotes = "Une erreur s'est produite pendant la récupération des pilotes";
		}

		return listePilotes;
	}
	
	
	public void addPilote(Pilote pilote, ArrayList<Qualification> qualifs)
	{
		int lastInsertedId = 0;
		try
		{
			String []column ={"numPilo"};
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into Pilote values ( (select (MAX(numPilo)+1) from pilote),?,?,?,?,?,?,?)",column);
			stat.setString(1,pilote.getNom());
			stat.setString(2,pilote.getPrenom());
			stat.setInt(3,pilote.getNumRue());
			stat.setString(4,pilote.getRue());
			stat.setInt(5,pilote.getCp());
			stat.setString(6,pilote.getVille());
			stat.setString(7,pilote.getPays());
			stat.executeUpdate();
			ResultSet r = stat.getGeneratedKeys();
			if(r.next()){
				lastInsertedId = r.getInt(1);
			}
			stat.close();
			r.close();
			for(Qualification q : qualifs){
				QualificationDAO.addQualifPil(q, lastInsertedId);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout du pilote");
		}
	}
	
	public Pilote get(String idPilote)
	{
		Pilote p = null;
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * FROM pilote WHERE numPilo = ?");
			stat.setInt(1, Integer.parseInt(idPilote));
			ResultSet res = stat.executeQuery();
			if(res.next()){
				p = new Pilote(res.getInt("numPilo"),
						res.getString("nomPilo"),
						res.getString("prenomPilo"),
						res.getInt("numRuePilo"),
						res.getString("ruePilo"),
						res.getInt("cpPilo"),
						res.getString("villePilo"),
						res.getString("paysPilo"));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération du pilote");
		}
		return p;
	}
	
	public void update(Pilote pilote)
	{
		
	}
	
	
	public void delete(String idPilote)
	{
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM pilote WHERE numPilo = ?");
			stat.setInt(1, Integer.parseInt(idPilote));
			new EquipageDAO().deleteMembreEquip(idPilote, true);
			new QualificationDAO().delete(idPilote);
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression du pilote");
		
		
	}
	}


	public void add(Pilote item) {
		// TODO Auto-generated method stub
		
	}

}
