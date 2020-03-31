package aeroport;
import DAO.QualificationDAO;
import java.util.ArrayList;

public class Pilote extends Personnel{
	private ArrayList<Qualification> qualifications;
	public Pilote(int id, String nom, String prenom, int numRue, String rue, int cp, String ville, String pays){
		super(id,
		nom,
		prenom,
		numRue,
		rue,
		cp,
		ville,
		pays);
		//qualifications = QualificationDAO.getQualifPilote(id);
	}
	
	public ArrayList<Qualification> getQualif(){
		return qualifications;
	}
		
	public int getNbHeureTotale(){
		int res = 0;
		
		for(Qualification q : qualifications){
			res+=q.getNbHeure();
		}
		
		return res;
	}
}
