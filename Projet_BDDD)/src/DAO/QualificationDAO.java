package DAO;

import java.sql.*;
import java.util.ArrayList;

import aeroport.Qualification;
import aeroport.Modele;

public class QualificationDAO implements DAOFactory<Qualification> {
	
	public static void addQualifPil(Qualification qualification, int idPil)
	{
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("insert into Qualification values (?,?,?)");
			stat.setInt(1,idPil);
			stat.setString(2,qualification.getModele().getId());
			stat.setInt(3,qualification.getNbHeure());
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant l'ajout de la qualification");
		}
	}
	
	public Qualification get(String idQualification)
	{
		return null;
	}
	public void update(Qualification item) {

	}
	
	public static void addHeureQualif(String idMod, int idPil, int dureeVol)
	{
		try{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("UPDATE Qualification SET nbHQual = (nbHQual + ?) WHERE numPiloQual = ? AND numModQual = ?");
			stat.setInt(1, dureeVol);
			stat.setInt(2,idPil);
			stat.setString(3,idMod);
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite durant la mise à jour du client");
		}
	}
	
	
	public void delete(String idPilote)
	{
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("DELETE FROM Qualification WHERE numPiloQual = ?");
			stat.setInt(1, Integer.parseInt(idPilote));
			stat.executeUpdate();
			stat.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la suppression des qualifications du pilote");
		
		
	}
	}

	public static ArrayList<Qualification> getQualifPilote(int idPilote){
		ArrayList<Qualification> qualif = new ArrayList<Qualification>();
		
		try
		{
			PreparedStatement stat = DAOFactory.cnx.prepareStatement("SELECT * FROM qualification WHERE numPiloQual = ?");
			stat.setInt(1, idPilote);
			ResultSet r = stat.executeQuery();
			while(r.next()){
				qualif.add(
						new Qualification(new ModeleDAO().get(r.getString("numModQual")),r.getInt("nbHQual"))
						);
			}
			stat.close();
			r.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Une erreur s'est produite pendant la récupération des qualifactions de ce pilote");
		}
		return qualif;
	}

	public void add(Qualification item) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean modeleIsIn(ArrayList<Qualification> qualifs, Modele mod){
		boolean isIn = false;
		int i = 0;
		
		while(i<qualifs.size() && isIn == false){
			if(qualifs.get(i).getModele().getId().equals(mod.getId())){
				isIn = true;
			}
			i++;
		}
		return isIn;
	}
}
