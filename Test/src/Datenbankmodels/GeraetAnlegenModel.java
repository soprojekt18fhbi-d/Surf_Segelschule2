package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;

public class GeraetAnlegenModel implements IAnlegenModel{
	
	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();

	private ArrayList<String> mengeAnModellen = new ArrayList<String>();
	private ArrayList<String> mengeAnTypen = new ArrayList<String>();
	private String talking = "first";
	private String[] geraet;
	
		
	public void anfrage (String talking2, String[] geraet) {
		this.talking = talking2;
		this.geraet = geraet;
		
        try {
        	
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	
	
	
	public void viewTable(Connection con)
			throws SQLException {

			
		
		    Statement stmtGeraetAnlegenModel = con.createStatement();
		    Statement stmtGeraetAnlegenModel2 = con.createStatement();
		    Statement stmtGeraetAnlegenModel3 = con.createStatement();
		    String query = null;
		    String query2 = null;
		
		    
		    if(talking.equals("first"))
		    {
		    	query = "Select * from TYP";
		    	 try {
				    	System.out.println(query);
				        ResultSet rs = stmtGeraetAnlegenModel.executeQuery(query);
				        
				        while (rs.next()){
				        	
				        	mengeAnTypen.add(rs.getString("NAME"));
				        	
				        }
				        
				        
				    } catch (SQLException e ) {
				    	e.printStackTrace();
				    }
		    	 updateObserver();
		    }
		    
		   if(talking.equals("second"))
		   {
			   
			   
		   try {
			   String typ = geraet[0];
			   
			   query = "Select * from TYP WHERE NAME = '" +typ+ "'";
			   System.out.println(query);
			   
			   ResultSet rs = stmtGeraetAnlegenModel.executeQuery(query);
				
				while (rs.next()){	
					int typID =  Integer.parseInt(rs.getString("ID"));
					
					query2 = "select * from MODELL WHERE TYPID = '" +typID+ "'";
					ResultSet rs2 = stmtGeraetAnlegenModel2.executeQuery(query2);
					while (rs2.next()){
				        	
						mengeAnModellen.add(rs2.getString("NAME"));
					}      	
				      
				}      
				    } catch (SQLException e ) {
				    	e.printStackTrace();
				    } finally {
				        if (stmtGeraetAnlegenModel != null) { stmtGeraetAnlegenModel.close(); }
				    }
		    	 updateObserver();
		    }
		   
		   	

			if(talking.equals("hinzufuegen"))
			{
				try {
					
					String typ = geraet[0];
					String modell = geraet[1];
					String makel = geraet[2];
					double verkaufspreis = Double.parseDouble(geraet[3]);
					double anschaffungspreis = Double.parseDouble(geraet[4]);
					String farbe = geraet[5];
					int baujahr = Integer.parseInt(geraet[6]);
					String status = "OK";
					int standortID = 1;
					
				
							
					query = "select * from TYP WHERE NAME = '" +typ+ "'";
					System.out.println(query);
					query2 = "select * from MODELL WHERE NAME = '" +modell+ "'";
					ResultSet rs = stmtGeraetAnlegenModel.executeQuery(query);
					
					while (rs.next()){	
						int typID =  Integer.parseInt(rs.getString("ID"));
						ResultSet rs2 = stmtGeraetAnlegenModel2.executeQuery(query2);
						
						while(rs2.next()){
							int modellID = Integer.parseInt(rs2.getString("ID"));
						
							String sqlupdate = "INSERT INTO SPORTGERAET VALUES (default,'" + makel + "','" +verkaufspreis+ "','" +typID+"','" +modellID+ "','" +status+"','" +standortID+ "','" +farbe+"','" +baujahr+ "','" +anschaffungspreis+"')";
							System.out.println(sqlupdate);
							int ergebnis = stmtGeraetAnlegenModel3.executeUpdate(sqlupdate);
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						 if (stmtGeraetAnlegenModel2 != null) { stmtGeraetAnlegenModel2.close(); }
						 if (stmtGeraetAnlegenModel != null) { stmtGeraetAnlegenModel.close(); }
					}
				updateObserver();
			}	
		    
		    
		    
		    /*
		    try {
		    	System.out.println(query);
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        
		        
		        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    */
		    
		}
	
	public void anfrageTyp(String typ){
		
	}
	
	@Override
	public void anmelden(IAnlegenView view) {
		
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			if(observers.contains(view));
				observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void abmelden(IAnlegenView view) {

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
		if (talking == "first")
			return mengeAnTypen;
		else
			return mengeAnModellen;
	}
	
	
	

	

}