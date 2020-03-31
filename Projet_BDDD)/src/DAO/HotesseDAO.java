package DAO;

import java.sql.*;
import java.util.ArrayList;

import aeroport.Hotesse;

public class HotesseDAO implements DAOFactory<Hotesse>   {
	
	public void addHotesse(Hotesse hotesse, ArrayList<String> langues)
	{
		try
		{
			int lastInsertedId = 0;
			String []column ={"numHot"};
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into hotesse values ( (select (MAX(numHot)+1) from hotesse),?,?,?,?,?,?,?,?)", column);
			stat.setString(1,hotesse.getNom());
			stat.setString(2,hotesse.getPrenom());
			stat.setInt(3,hotesse.getNumRue());
			stat.setString(4,hotesse.getRue());
			stat.setInt(5,hotesse.getCp());
			stat.setString(6,hotesse.getVille());
			stat.setString(7,hotesse.getPays());
			stat.setInt(8,hotesse.getNbHeure());
			stat.executeUpdate();
			ResultSet r = stat.getGeneratedKeys();
			if(r.next()){
				lastInsertedId = r.getInt(1);
			}
			stat.close();
			for(String l : langues){
				ParlerDAO.addLangue(lastInsertedId, l);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout de l'hotesse");
		}
	}
	
	public Hotesse get(String idHotesse)
	{
		Hotesse h = null;
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from hotesse where numHot = ?");
			stat.setInt(1,Integer.parseInt(idHotesse));
			ResultSet res = stat.executeQuery();
			if(res.next()){
				h = new Hotesse(res.getInt("numHot"),
						res.getString("nomHot"),
						res.getString("prenomHot"),
						res.getInt("numRueHot"),
						res.getString("rueHot"),
						res.getInt("cpHot"),
						res.getString("villeHot"),
						res.getString("paysHot"),
						res.getInt("nbHHot"));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("une erreur s'est produit pendant la récupération de l'hotesse");
		}
		return h;
	}
	public static String getAll()
	{
		String listeHotesses = "num Hotesse | nom Hotesse | prenom Hotesse |num Rue|rue|code postale|ville|pays|nbHeures"+"\n";
		try{
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select * from hotesse");
			while(res.next()){
				listeHotesses +=res.getInt("numHot")+" | ";
				listeHotesses += res.getString("nomHot")+" | ";
				listeHotesses += res.getString("prenomHot")+" | ";
				listeHotesses +=res.getInt("numRueHot")+" | ";
				listeHotesses += res.getString("rueHot")+" | ";
				listeHotesses += res.getInt("cpHot")+" | ";
				listeHotesses +=res.getString("villeHot")+" | ";
				listeHotesses += res.getString("paysHot")+" | ";
				listeHotesses +=res.getInt("nbHHot")+"\n";
				
				
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			listeHotesses = "Une erreur s'est produite pendant la récupération des hotesses";
		}

		return listeHotesses;
	}
	public void update(Hotesse hotesse)
	{
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("UPDATE hotesse SET nbHHot = ? WHERE numHot = ?");
			stat.setInt(1, hotesse.getNbHeure());
			stat.setInt(2,hotesse.getId());
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite durant la mise à jour de l'hotesse");
		}
	}
	
	
	public void delete(String idHotesse)
	{
			try
			{
				PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM Hotesse WHERE numHot = ?");
				stat.setInt(1, Integer.parseInt(idHotesse));
				new ParlerDAO().delete(idHotesse);
				new EquipageDAO().deleteMembreEquip(idHotesse, false);
				stat.executeUpdate();
				stat.close();
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Une erreur s'est produite pendant la suppression de l'hotesse");
			
			
		}
	}

	public void add(Hotesse item) {
		// TODO Auto-generated method stub
		
	}

}
