package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeroport.Avion;
import aeroport.Modele;

public class AvionDAO implements DAOFactory<Avion> {
	
	public void add(Avion avion)
	{
		//code de creation davion 
	}
	
	public Avion get(String idAvion)
	{
		Avion avion = null;
		int numAv = Integer.parseInt(idAvion);
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from avions WHERE numAv = ?");
			stat.setInt(1,numAv);
			ResultSet res = stat.executeQuery();
			if(res.next()){
				avion = new Avion(numAv,new ModeleDAO().get(res.getString("numModAv")));
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération de l'avion");
		}
		return avion;
	}
	
	public void update(Avion avion)
	{
		//code de modification davion 
	}
	
	
	public void delete(String idAvion)
	{
		//code de suppression davion 
	}

}
