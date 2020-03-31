package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import aeroport.Personnel;

public class EquipageDAO implements DAOFactory<Personnel> {

	public void add(Personnel item) {
		// TODO Auto-generated method stub
		
	}

	public Personnel get(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Personnel item) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String item) {
	
	}

	public void deleteMembreEquip(String id,boolean isPilote){
		try
		{
			String att = "";
			if(isPilote){
				att = "numPiloEqui";
			}
			else{
				att = "numHotEqui";
			}
			
			if(!att.equals("")){
				PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM Equipages WHERE "+att+" = ?");
				stat.setInt(1, Integer.parseInt(id));
				stat.executeUpdate();
				stat.close();
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression d'un personnel de vol dans les équipages");
		
		
	}
	}

}
