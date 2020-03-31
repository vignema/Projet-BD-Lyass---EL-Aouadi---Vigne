package DAO;

import aeroport.Place;
import aeroport.Classe;
import aeroport.Position;
import java.sql.*;
public class PlaceDAO implements DAOFactory<Place>{
	
	public void add(Place place)
	{
		
	}
	
	public Place get(String idPlace)
	{
		Place p = null;
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("SELECT * FROM Places WHERE numPla = ?");
			stat.setInt(1, Integer.parseInt(idPlace));
			ResultSet r = stat.executeQuery();
			if(r.next()){
				p = new Place(r.getInt("numPla"),new AvionDAO().get(r.getString("numAvPla")),Classe.valueOf(r.getString("idClassPla")),Position.valueOf(r.getString("positionPla")));
			}
			r.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produit lors de la récupération de la place");
		}
		return p;
	}
	
	public void update(Place place)
	{
		
	}
	
	
	public void delete(String idPlace)
	{
		
	}

}
