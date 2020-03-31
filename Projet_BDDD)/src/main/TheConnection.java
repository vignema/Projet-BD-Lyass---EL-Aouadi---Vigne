package main;
import java.sql.*;
public class TheConnection {
	private static Connection cnx;
	private static final String configurationFile = "src/BD.properties";
	
	private TheConnection(){
		try{
			DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
			cnx = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(),dap.getPassword());
		}
		catch(SQLException e){
			e.printStackTrace(); 
		}
	}
	
	public static Connection getInstance(){
		if(cnx==null){
			new TheConnection();
		}
		return cnx;
	}
	
}
