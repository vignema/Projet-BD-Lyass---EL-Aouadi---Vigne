package DAO;

import aeroport.Client;
import java.sql.*;

public class ClientDAO implements DAOFactory<Client> {
	
	public void add(Client client)
	{
		
	}
	
	public Client get(String idClient)
	{
		Client c = null;
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("select * from clients WHERE numCli = ?");
			stat.setInt(1,Integer.parseInt(idClient));
			ResultSet r = stat.executeQuery();
			if(r.next()){
				c = new Client(r.getInt("numCli"), 
						r.getString("nomCli"),
						r.getString("prenomCli"),
						r.getInt("numRueCli"),
						r.getString("rueCli"),
						r.getInt("cpCli"),
						r.getString("villeCli"),
						r.getString("paysCli"),
						r.getString("numPassCli"),
						r.getInt("nbHCli")
						);
			}
			stat.close();
			r.close();
		}
		catch(SQLException e){
			
		}
		return c;
	}
	
	public void update(Client client)
	{
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("UPDATE Clients SET nbHCli = ? WHERE numCli = ?");
			stat.setInt(1, client.getNbHeure());
			stat.setInt(2,client.getId());
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite durant la mise à jour du client");
		}
	}
	
	
	public void delete(String idClient)
	{
		
	}

	public static String getAll(){
		String listeClients = "num Client| nom Client | prenom Client |num Rue|rue|code postale|ville|pays|numPassCli|nbHeures"+"\n";
		try{
	  	    DAOFactory.cnx.setAutoCommit(true);
			Statement stat = DAOFactory.cnx.createStatement();
			ResultSet res = stat.executeQuery("select * from clients");
			while(res.next()){
				listeClients +=res.getInt("numCli")+" | ";
				listeClients += res.getString("nomCli")+" | ";
				listeClients += res.getString("prenomCli")+" | ";
				listeClients +=res.getInt("numRueCli")+" | ";
				listeClients += res.getString("rueCli")+" | ";
				listeClients += res.getInt("cpCli")+" | ";
				listeClients +=res.getString("villeCli")+" | ";
				listeClients += res.getString("paysCli")+" | ";
				listeClients += res.getString("numPassCli")+" | ";
				listeClients +=res.getInt("nbHCli")+"\n";
				
				
			}
			stat.close();
			res.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			listeClients = "Une erreur s'est produite pendant la récupération des clients";
		}

		return listeClients;
	}
}
