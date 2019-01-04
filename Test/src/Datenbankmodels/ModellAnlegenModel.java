 /*
  *  @author Michael Schmidt
  */

package Datenbankmodels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import GUI.IAnlegenView;

public class ModellAnlegenModel implements IAnlegenModel {

	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();
	private ArrayList<String> mengeAnTypen = new ArrayList<String>();
	private String talking = "first";
	private String[] modell;
	private String name;
	private String typ;
	private int preis;
	private int id;
	
	
	public void anfrage(String talking2, String[] modell) {
		
		this.talking = talking2;
		this.modell = modell;
		
        try {
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewTable(Connection con) throws SQLException {

	    Statement stmtModellHinzufuegenModel = con.createStatement();
	    Statement stmtModellHinzufuegenModel2 = con.createStatement();
	    String query = null;
	    
	    if(talking.equals("first")){
	    	query = "Select * from TYP";
	    	try {
	    		System.out.println(query);
	    		ResultSet rs = stmtModellHinzufuegenModel.executeQuery(query);
			    while (rs.next()){
			    	mengeAnTypen.add(rs.getString("NAME"));
			    }
	    	} catch (SQLException e ) {
	    		e.printStackTrace();
	    	} finally {
	    		if (stmtModellHinzufuegenModel != null) { stmtModellHinzufuegenModel.close(); }
	    	}
	    	 updateObserver();
	    }
		    
	    if(talking.equals("second")){
		    query = "Select * from PREISLISTE";
		    try {
			   	System.out.println(query);
			    ResultSet rs = stmtModellHinzufuegenModel.executeQuery(query);      
			    while (rs.next()){
			    	mengeAnTypen.add(rs.getString("ID"));
			    }    
		    } catch (SQLException e ) {
			   	e.printStackTrace();
			} finally {
				if (stmtModellHinzufuegenModel != null) { stmtModellHinzufuegenModel.close(); }
			}
		    updateObserver();
	    }
	    
		if(talking.equals("hinzufuegen")){
			try {
				werteUebergeben();
					
				query = "select * from TYP WHERE NAME = '" +typ+ "'";
				System.out.println(query);
				ResultSet rs = stmtModellHinzufuegenModel.executeQuery(query);
				
				while (rs.next()){	
					int typID =  Integer.parseInt(rs.getString("ID"));
					String sqlupdate = "INSERT INTO MODELL VALUES (default,'" + name + "','" +typID+ "','" +preis+"')";
					System.out.println(sqlupdate);
					stmtModellHinzufuegenModel2.executeUpdate(sqlupdate);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				if (stmtModellHinzufuegenModel2 != null) { stmtModellHinzufuegenModel2.close(); }
				if (stmtModellHinzufuegenModel != null) { stmtModellHinzufuegenModel.close(); }
			}
		}	
	    
		if(talking.equals("aendern"))
		{
			try {
				werteUebergeben();
				
				query = "select * from TYP WHERE NAME = '"+typ+"'";
				ResultSet rs = stmtModellHinzufuegenModel.executeQuery(query);
				while (rs.next()){
					int typID =  Integer.parseInt(rs.getString("ID"));
					String sqlupdate = "UPDATE MODELL SET NAME = '"+name+"', TYPID = '"+typID+"' , PREISLISTEID = '"+preis+"' WHERE ID = "+id+"";
					stmtModellHinzufuegenModel2.executeUpdate(sqlupdate);		
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				 if (stmtModellHinzufuegenModel2 != null) { stmtModellHinzufuegenModel2.close(); }
				 if (stmtModellHinzufuegenModel != null) { stmtModellHinzufuegenModel.close(); }
			}
		}	 
	}

	private void werteUebergeben() {
		name = modell[0];
		typ = modell[1];
		preis = Integer.parseInt(modell[2]);
		id = Integer.parseInt(modell[3]);
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
