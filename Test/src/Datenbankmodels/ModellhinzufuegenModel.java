package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Domaenklassen.IAdresse;
import GUI.IAnlegenView;
import GUI.IObjektView;

public class ModellhinzufuegenModel implements IAnlegenModel {

	
	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();

	private ArrayList<Object> mengeAnModellen = new ArrayList<Object>();
	private ArrayList<String> mengeAnTypen = new ArrayList<String>();
	private String talking = "first";
	private String[] modell;
	
	public void anfrage(String talking2, String[] modell) {
		
		this.talking = talking2;
		this.modell = modell;
		//System.out.println();
		
        try {
        	
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here
			viewTable(conn);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	public void viewTable(Connection con)
		    throws SQLException {

			
		
		    Statement stmt = con.createStatement();
		    Statement stmt2 = con.createStatement();
		    String query = null;
		    
		    if(talking.equals("first"))
		    {
		    	query = "Select * from TYP";
		    	 try {
				    	System.out.println(query);
				        ResultSet rs = stmt.executeQuery(query);
				        
				        while (rs.next()){
				        	
				        	mengeAnTypen.add(rs.getString("NAME"));
				        	
				        }
				        
				        
				    } catch (SQLException e ) {
				    	e.printStackTrace();
				    } finally {
				        if (stmt != null) { stmt.close(); }
				    }
		    	 updateObserver();
		    }
		   	

			if(talking.equals("hinzufuegen"))
			{
				try {
					
					String name = modell[0];
					String typ = modell[1];
					int preis = Integer.parseInt(modell[2]);
				
							
					query = "select * from TYP WHERE NAME = '" +typ+ "'";
					System.out.println(query);
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next())
						{	
							int typID =  Integer.parseInt(rs.getString("ID"));
							String sqlupdate = "INSERT INTO MODELL VALUES (default,'" + name + "','" +typID+ "','" +preis+"')";
							System.out.println(sqlupdate);
						
							stmt2.executeUpdate(sqlupdate);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						 if (stmt2 != null) { stmt2.close(); }
						 if (stmt != null) { stmt.close(); }
					}
			}	
		    
		    
		    
		    
		    try {
		    	System.out.println(query);
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        
		        
		        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    
		    
		}
	
	
	
	
	
	@Override
	public void anmelden(IAnlegenView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void abmelden(IAnlegenView view) {
		// TODO Auto-generated method stub
		try {
			if(observers.contains(view));
				observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < observers.size(); ++i) 
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> getObertypen() {
		// TODO Auto-generated method stub
		return mengeAnTypen;
	}

}
