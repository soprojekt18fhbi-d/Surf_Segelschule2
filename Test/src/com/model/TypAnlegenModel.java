 /*
  *  @author Michael Schmidt
  */

package com.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.view.IAnlegenView;

public class TypAnlegenModel implements IAnlegenModel{
	String talking;
	String name;
	String schein;
	int id;
	
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
	
	public void typAnlegen(String[] typ) {
        try {
			Connection conn = DBConnectorSingleton.getCon();
			Statement statementTypAnlegenModel = conn.createStatement();
			werteUebergeben(typ);
			
			String sqlupdate;			
			if (talking.equals("anlegen"))
				sqlupdate = "INSERT INTO TYP VALUES (default,'" + name + "','"+ schein+ "')";
			else 
				sqlupdate = "UPDATE TYP SET NAME = '"+name+"', FUEHRERSCHEIN = '"+schein+"' WHERE ID = "+id+"";
			
			statementTypAnlegenModel.executeUpdate(sqlupdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        updateObserver();
		}
	}

	private void werteUebergeben(String[] typ) {
		talking = typ[0];
		id = Integer.parseInt(typ[1]);
		name = typ[2];
		schein = typ[3];
	}

	@Override
	public ArrayList<String> getObertypen() {
		// TODO Auto-generated method stub
		return null;
	}

}
