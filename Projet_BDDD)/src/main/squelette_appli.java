package main;
import java.sql.*;
import java.util.ArrayList;

import aeroport.*;
import DAO.*;
public class squelette_appli {
	
	static final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";

// Ne pas oublier d'anomymiser le PASSWD avant de rendre votre travail

	private static VolDAO volDAO = new VolDAO();
	private static ReservationDAO resDAO = new ReservationDAO();
	private static ClientDAO clientDAO = new ClientDAO();
	private static HotesseDAO hotesseDAO = new HotesseDAO();
	private static PiloteDAO piloteDAO = new PiloteDAO();
	
    public static void main(String args[]) {
    	try{
    		int choix = 0;
    		do{
    			System.out.println("Choisissez une fonctionnalité en tapant de 1 à 5 dans la liste suivante, pour quitter choisissez un numéro ne correspondant à aucune fonctionnalité :");
    			System.out.println("1 - Ajouter d'un personnel de vol");
    			System.out.println("2 - Supression d'un personnel de vol");
    			System.out.println("3 - Confirmation de la terminaison d'un vol");
    			System.out.println("4 - Consultations des réservations d'un client");
    			System.out.println("5 - Suppression d'une réservation");
    			choix = LectureClavier.lireEntier("Faites votre choix : ");
    			
    			switch(choix){
	    			case 1:
	    				System.out.println("Souhaitez-vous ajouter un pilote ou une hotesse ?");
	    				int pilOrHotAdd = LectureClavier.lireEntier("Pour ajouter un pilote tapez 1 \nPour ajouter une hotesse tapez 2\nTout autre choix vous redirigera au menu");
	    				String nom, prenom, rue, ville,pays;
	    				int numRue, cp;
	    				if(pilOrHotAdd == 1 || pilOrHotAdd ==2){
	    					System.out.println("Saisissez son nom :");
	    					nom = LectureClavier.lireChaine();
	    					System.out.println("Saisissez son prenom :");
	    					prenom = LectureClavier.lireChaine();
	    					numRue = LectureClavier.lireEntier("Saisissez son numéro de rue");
	    					System.out.println("Saisissez sa rue :");
	    					rue = LectureClavier.lireChaine();
	    					cp = LectureClavier.lireEntier("Saisissez son code postal");
	    					System.out.println("Saisissez sa ville :");
	    					ville = LectureClavier.lireChaine();
	    					System.out.println("Saisissez son pays :");
	    					pays = LectureClavier.lireChaine();
	    				
	    				if(pilOrHotAdd == 1){
	    					Pilote pilote = new Pilote(0,nom,prenom,numRue,rue,cp,ville,pays);
	    					System.out.println(ModeleDAO.getAll());
		    				ArrayList<Qualification> qualifPil = new ArrayList<Qualification>();
		    				int autreQualif = 0;
		    				boolean firstQualif = true;
		    				while(qualifPil.size()==0 || autreQualif ==0){
		    					if(qualifPil.size()==0 && !firstQualif){
		    						System.out.println("Le pilote doit être qualifié pour au moins 1 modèle");
		    					}
		    					firstQualif = false;
		    					System.out.println("Saisissez un numéro de modèle d'avion pour lequel ce pilote est qualifié");
		    					String modeleQualif = LectureClavier.lireChaine();
		    					Modele mod = new ModeleDAO().get(modeleQualif);
		    					if(mod == null){
		    						System.out.println("Ce modèle n'existe pas !");
		    					}
		    					else{
		    						if(!QualificationDAO.modeleIsIn(qualifPil,mod)){
		    							qualifPil.add(new Qualification(mod,0));
		    						}
		    						else {
		    							System.out.println("Ce pilote a déjà cette qualification");
		    						}
		    					}
		    					autreQualif = LectureClavier.lireEntier("Si vous souhaitez ajouter une autre qualification tapez 0, sinon tapez un autre numéro");
		    				}
		    				piloteDAO.addPilote(pilote, qualifPil);
		    				System.out.println(PiloteDAO.getAll());
	    				}
	    				else if(pilOrHotAdd == 2){
	    					Hotesse hotesse = new Hotesse(0,nom,prenom,numRue,rue,cp,ville,pays,0);
	    					int autreLang = 0;
	    					boolean firstLang = true;
	    					ArrayList<String> langues = new ArrayList<String>();
	    					while(autreLang == 0){
	    						if(langues.size()==0 && !firstLang){
	    							System.out.println("L'hotesse doit parler au moins 1 langue");
	    						}
	    						firstLang = false;
	    						System.out.println("Saisissez une langue que cette hotesse parle :");
	    						String lang = LectureClavier.lireChaine();
	    						if(!ParlerDAO.langIsIn(langues, lang)){
	    							langues.add(lang);
	    						}
	    						else{
	    							System.out.println("Cette langue est déjà renseignée");
	    						}
	    						autreLang = LectureClavier.lireEntier("Si vous souhaitez ajouter une autre langue tapez 0, sinon tapez un autre numéro");
	    					}
	    					hotesseDAO.addHotesse(hotesse,langues);
	    					System.out.println(HotesseDAO.getAll());
	    				}
	    				
	    				
	    				}
	    				break;
	    			case 2:
	    				System.out.println("Souhaitez-vous supprimer un pilote ou une hotesse ?");
	    				int pilOrHotDel = LectureClavier.lireEntier("Pour suprimer un pilote tapez 1 \nPour supprimer une hotesse tapez 2\nTout autre choix vous redirigera au menu");
	    				if(pilOrHotDel == 1){
	    					System.out.println(PiloteDAO.getAll());
		    				int idPil = LectureClavier.lireEntier("Saisissez le pilote que vous souhaitez supprimer :");
		    				Pilote pil = piloteDAO.get(Integer.toString(idPil));
		    				if(pil == null){
		    					throw new SQLException("Ce pilote n'existe pas !");
		    				}
		    				piloteDAO.delete(Integer.toString(idPil));
		    				System.out.println(PiloteDAO.getAll());
	    				}
	    				else if(pilOrHotDel == 2){
	    					System.out.println(HotesseDAO.getAll());
	    					int idHot = LectureClavier.lireEntier("Saisissez l'hotesse que vous souhaitez supprimer :");
	    					Hotesse hot = hotesseDAO.get(Integer.toString(idHot));
	    					if(hot == null){
		    					throw new SQLException("Cette hotesse n'existe pas !");
		    				}
	    					hotesseDAO.delete(Integer.toString(idHot));
	    					System.out.println(HotesseDAO.getAll());
	    				}
	    				
	    				break;
    				case 3:
    					System.out.println(VolDAO.getAll());
    					System.out.println("Choisissez le vol que vous souhaitez terminer");
    					String terminatedVol = LectureClavier.lireChaine();
    					/*System.out.println("Clients :"+"\n"+ClientDAO.getAll());
    					System.out.println("Hotesses :"+"\n"+HotesseDAO.getAll());
    					System.out.println("Pilotes :"+"\n"+PiloteDAO.getAll());*/
    					Vol v = volDAO.get(terminatedVol);
    					if(v == null){
    						throw new SQLException("Ce vol n'existe pas !");
    					}
    					if(v.isTerminer()){
    						throw new SQLException("Ce vol est déjà terminé !");
    					}
    					ArrayList<Personnel> equipage = VolDAO.getEquipage(v.getId());
    					ArrayList<Client> passagers = VolDAO.getPassagers(v.getId());
    					
    					for(Client c : passagers){
    							c.addHeure(v.getDuree());
    							clientDAO.update(c);
    					}
    					for(Personnel p : equipage){
    						if(p instanceof Hotesse){
    							((Hotesse) p).addHeure(v.getDuree());
    							hotesseDAO.update((Hotesse)p);
    						}
    						else if(p instanceof Pilote){
    							QualificationDAO.addHeureQualif(v.getAvion().getModele().getId(),p.getId(),v.getDuree());
    						}
    					}
    					v.setTerminer();		
    					volDAO.update(v);
    					/*System.out.println(VolDAO.getAll());
    					System.out.println("Clients :"+"\n"+ClientDAO.getAll());
    					System.out.println("Hotesses :"+"\n"+HotesseDAO.getAll());
    					System.out.println("Pilotes :"+"\n"+PiloteDAO.getAll());*/
    					
    					break;
    				case 4:
    					System.out.println(ClientDAO.getAll());
    					int idCli = LectureClavier.lireEntier("Choisissez le clients dont vous voulez consulter les réservations :");
    					ArrayList<Reservation> reservations = ReservationDAO.getReservationCli(Integer.toString(idCli));
    					for(Reservation r : reservations){
    						System.out.println(r);
    						ArrayList<PlaceReserver> placesReserver = PlaceReserverDAO.getPlacesReser(Integer.toString(r.getId()));
    						for(PlaceReserver pr : placesReserver){
    							System.out.println(pr);
    						}
    					}
    					break;
    				case 5:
    					System.out.println(ReservationDAO.getAll());
    					int idRes = LectureClavier.lireEntier("Choisissez la réservation que vous souhaitez supprimer");
    					resDAO.delete(Integer.toString(idRes));
    					System.out.println(ReservationDAO.getAll());
    					
    					break;
    				
    				default:
    					System.out.println("Vous avez choisi de quitter l'application");
    			}
    			
    		}while(choix>=1 && choix<=8);
    		
    		DAOFactory.cnx.close();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    	
     }
	

}