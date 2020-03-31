package DAO;

import java.sql.*;

import aeroport.Modele;

public class ModeleDAO implements DAOFactory<Modele>  {
	
	public void add(Modele modele)
	{
		
	}
	
	public Modele get(String idModele)
	{
		Modele modele = null;
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from modeles WHERE numMod = ?");
			stat.setString(1,idModele);
			ResultSet res = stat.executeQuery();
			if(res.next()){
				String num = res.getString("numMod");
				int nbPil = res.getInt("nbPilotMod");
				float rayonAct = res.getFloat("rayonActMod");
				modele = new Modele(num,nbPil,rayonAct);
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération du modèle");
			System.out.println(e.getMessage());
		}
		return modele;
	}
	
	public void update(Modele modele)
	{
		
	}
	
	
	public void delete(String idModele)
	{
		
	}
	
	public static String getAll(){
		String s = "Numéro | Nbr. Pilotes | Rayon d'action"+"\n";
		try{
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select * from modeles");
			while(res.next()){
				s += res.getString("numMod")+" | ";
				s += res.getInt("nbPilotMod")+" | ";
				s += res.getFloat("rayonActMod")+"\n";
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des modèles");
		}
		return s;
	}


}
