package DAO;

import aeroport.Parler;

import java.sql.*;
import java.util.ArrayList;

public class ParlerDAO implements DAOFactory<Parler> {
	
	public static void addLangue(int idHot, String langue)
	{
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into Parler values (?,?)");
			stat.setInt(1,idHot);
			stat.setString(2, langue);
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout de la langue");
		}
	}
	
	public Parler get(String idParler)
	{
		return null;
	}
	
	public void update(Parler parler)
	{
		
	}
	
	
	public void delete(String idHotesse)
	{
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM Parler WHERE numHotPar = ?");
			stat.setInt(1, Integer.parseInt(idHotesse));
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression des langues de l'hotesse");
		
		
	}
	}

	public void add(Parler item) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean langIsIn(ArrayList<String> langues, String lang){
		boolean isIn = false;
		int i =0;
		while(i<langues.size() && !isIn){
			if(langues.get(i).equals(lang)){
				isIn = true;
			}
			i++;
		}
		
		return isIn;
	}
}
