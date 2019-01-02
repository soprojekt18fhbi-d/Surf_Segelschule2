

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.TableModel;

import Domaenklassen.IKunde;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;

public class BuchungAnzeigeModel implements IObjektModel { //Ben Kröncke

	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private TableModel table;
	private String talking;
	private String search;
	private String mode;
	private int kNr;
	private int geraetNrloc;
	private int buchungID = 0;
	private String makel = "";
	String patternBerechnung = "yyyy-MM-dd' 'HH:mm";
	private double preis;
	
	public void holeBuchung(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2, String makel2) {

		setVars(talking2, buchungID2, kNr2, geraetNr, search2, mode2, makel2);
		
        try {
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}
	
	
	public void viewTable(Connection con)
		    throws SQLException {

		
				Statement stmtBuchungAnzeigeModel = null;
				String query = null;
				String update = null;
				
				String pattern = "yyyy-MM-dd' 'HH:mm:ss";
				String date = new SimpleDateFormat(pattern).format(new Date());

			try {
				
				stmtBuchungAnzeigeModel = con.createStatement();
				if(mode.equals("Verleih"))
				{
					if(talking.equals("master"))
					{
						alleVerleihe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("search"))
					{
						searchVerleihe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("rckButton"))
					{
						vollendeAusleihe(stmtBuchungAnzeigeModel, date);
					}
					if(talking.equals("stornButton"))
					{
						storniereBuchung(stmtBuchungAnzeigeModel);
					}
				}
				if(mode.equals("Verkauf"))
				{
					if(talking.equals("master"))
					{
						holeVerkaeufe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("search"))
					{
						sucheVerkaeufe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("rckButton"))
					{
						erstelleRechnungVerkauf(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("stornButton"))
					{
						storniereBuchung(stmtBuchungAnzeigeModel);
					}
				}
				
				

			} catch (SQLException e ) {
				e.printStackTrace();
			}

		}


	private void erstelleRechnungVerkauf(Statement stmt) throws SQLException {
		String query;
		String update;
		double verkaufspreis = 0;
		query = "SELECT VERKAUFSPREIS FROM SPORTGERAET WHERE ID = " + geraetNrloc;
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			verkaufspreis = rs.getDouble("VERKAUFSPREIS");
		}
		update = "INSERT INTO RECHNUNG VALUES( default, " + (verkaufspreis/1.19) + ", " + (verkaufspreis/119)*19 + ", " + verkaufspreis + ", " + kNr + ", null, " + buchungID + ")";
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE BUCHUNG SET ART = 'Abgewickelter Verkauf' WHERE ID = " + buchungID;
		stmt.executeUpdate(update);
	}


	private void vollendeAusleihe(Statement stmt, String date) throws SQLException {
		String update;
		String query;
		update = "UPDATE BUCHUNG SET RÜCKGABEDATUM = '" + date + "' WHERE ID = " + buchungID;
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'OK', MAKEL = '" + makel + "' WHERE ID = " + geraetNrloc;
		System.out.println(update);
		stmt.executeUpdate(update);
		
		int stunden = 1;
		String rueckdatum = new SimpleDateFormat(patternBerechnung).format(new Date());
		String verleihdatum = new SimpleDateFormat(patternBerechnung).format(new Date());
		query = "SELECT AUSLEIHDATUM, RÜCKGABEDATUM FROM BUCHUNG WHERE ID = " + buchungID;
		
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			rueckdatum = rs.getString("RÜCKGABEDATUM");
			verleihdatum = rs.getString("AUSLEIHDATUM");
		}
		System.out.println(rueckdatum);
		System.out.println(verleihdatum);
		
		int[] tageStunden = holeTageStunden(rueckdatum, verleihdatum);
			
		pruefepreisSetzen(stmt, tageStunden);
		
		update = "INSERT INTO RECHNUNG VALUES (default," + preis/1.19 + ", " + (preis/1.19)*0.19 + ", " + preis + ", " + kNr + ", null, " + buchungID + ");";

		stmt.executeUpdate(update);
	}


	private void pruefepreisSetzen(Statement stmt, int[] tageStunden) throws SQLException {
		if(tageStunden[1] <= 1)
		{	
			String spalte = "EINESTD";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[1] <= 2 && tageStunden[1] > 1)
		{	
			String spalte = "ZWEISTD";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[1] <= 4 && tageStunden[1] > 2)
		{	
			String spalte = "VIERSTD";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 1)
		{	
			String spalte = "EINENTAG";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 2 && tageStunden[0] > 1)
		{	
			String spalte = "ZWEITAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 3 && tageStunden[0] > 2)
		{	
			String spalte = "DREITAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 4 && tageStunden[0] > 3)
		{	
			String spalte = "VIERTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 5 && tageStunden[0] > 4)
		{	
			String spalte = "FÜNFTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 7 && tageStunden[0] > 5)
		{	
			String spalte = "SECHS-SIEBENTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 8 && tageStunden[0] > 7)
		{	
			String spalte = "ACHTTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 9 && tageStunden[0] > 8)
		{	
			String spalte = "NEUNTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 10 && tageStunden[0] > 9)
		{	
			String spalte = "ZEHNTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 11 && tageStunden[0] > 10)
		{	
			String spalte = "ELFTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 14 && tageStunden[0] > 11)
		{	
			String spalte = "ZWOELF-VIERZEHNTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 15 && tageStunden[0] > 14)
		{	
			String spalte = "FUENFZEHNTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 16 && tageStunden[0] > 15)
		{	
			String spalte = "SECHZENTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 17 && tageStunden[0] > 16)
		{	
			String spalte = "SIEBZEHNTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 21 && tageStunden[0] > 17)
		{	
			String spalte = "ACHTZEHN-EINUNDZWANZIGTAGE";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 27 && tageStunden[0] > 21)
		{	
			String spalte = "TAG-VIERWOCHEN";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] <= 28 && tageStunden[0] > 27)
		{	
			String spalte = "VIERWOCHEN";
			setzePreis(stmt, spalte);
		}
		if(tageStunden[0] >= 56 )
		{	
			String spalte = "ACHTWOCHEN";
			setzePreis(stmt, spalte);
		}
	}


	private void setzePreis(Statement stmt, String spalte) throws SQLException {
		String query;
		ResultSet rs;
		query = "SELECT PREISLISTE." + spalte + " FROM PREISLISTE, MODELL, SPORTGERAET WHERE SPORTGERAET.ID = " + geraetNrloc + " AND SPORTGERAET.MODELLID = MODELL.ID AND MODELL.PREISLISTEID = PREISLISTE.ID";
		
		rs = stmt.executeQuery(query);
		while (rs.next())
		{
			preis = rs.getDouble(spalte);
		}
	}


	private int[] holeTageStunden(String rueckdatum, String verleihdatum) {
		
		
		
		//Splitten der Daten in unterschiedliche Parts, um Integer auslesen zu können, und damit die Dauer des Verleihs zu berechnen.
		String[] alleteileRueck = rueckdatum.split(" ");
		String[] alleteileVerleih = verleihdatum.split(" ");
		
		String[] datumRueck = alleteileRueck[0].split("-");
		String[] uhrzeitRueck = alleteileRueck[1].split(":");
		
		String[] datumVerleih = alleteileVerleih[0].split("-");
		String[] uhrzeitVerleih = alleteileVerleih[1].split(":");

			
		int[] tageStunden = berechneTageStunden(datumRueck, uhrzeitRueck, datumVerleih, uhrzeitVerleih);
		
		return tageStunden;
	}


	private int[] berechneTageStunden(String[] datumRueck, String[] uhrzeitRueck, String[] datumVerleih,
			String[] uhrzeitVerleih) {
		
		int[] tageStunden = new int[2];
		
		int minuten = Integer.parseInt(uhrzeitRueck[1]) - Integer.parseInt(uhrzeitVerleih[1]);
		int stunden = Integer.parseInt(uhrzeitRueck[0]) - Integer.parseInt(uhrzeitVerleih[0]);
		if(minuten > 0 )
		{
			stunden ++; //Wenn die Minuten den Wert 0 übersteigen (eine neue Stunde angefangen wurde, dann wird der Stundencounter um 1 erhöht
		}
			
		int monate = (Integer.parseInt(datumRueck[1]) - Integer.parseInt(datumVerleih[1]));
		if(monate < 0)
			monate = ((12-Integer.parseInt(datumVerleih[1])) + Integer.parseInt(datumRueck[1])); //Überprüfen, ob Monate anständig ausgelesen worden. Wenn nicht, dann wird eine alternative Berechnung verwendet
		System.out.println(12 + " - " + Integer.parseInt(datumVerleih[1]) + " + " + Integer.parseInt(datumRueck[1]) + " + " + 1 + " = " + monate);
		int tage = Integer.parseInt(datumRueck[2]) - Integer.parseInt(datumVerleih[2]);
			if(tage < 0)
			{
				monate --;
				tage = ((30-Integer.parseInt(datumVerleih[2])) + Integer.parseInt(datumRueck[2])); //Überprüfen, ob Tage anständig ausgelesen worden. Wenn nicht, dann wird eine alternative Berechnung verwendet
			}
			tage = tage + monate*30;

			System.out.println("Das Gerät wurde: " + stunden + " Stunden ausgeliehen! (Es zählt jede angebrochene Stunde)");
			System.out.println("Das Gerät wurde: " + tage + " Tage ausgeliehen! (Es zählt jeder angebrochener Tag)");
			
			
			tageStunden[0] = tage;
			tageStunden[1] = stunden;
			
			return tageStunden;
	}


	private void storniereBuchung(Statement stmt) throws SQLException {
		String update;
		update = "DELETE FROM BUCHUNG WHERE ID = " + buchungID;
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'OK' WHERE ID = " + geraetNrloc;
		System.out.println(update);
		stmt.executeUpdate(update);
	}


	private void sucheVerkaeufe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,VERKAUFSDATUM FROM BUCHUNG WHERE ART = 'Verkauf' AND VERKAUFSDATUM LIKE '%" + search + "%'";
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void holeVerkaeufe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,VERKAUFSDATUM FROM BUCHUNG WHERE ART = 'Verkauf' ORDER BY VERKAUFSDATUM DESC";
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void searchVerleihe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,AUSLEIHDATUM,RÜCKGABEDATUM FROM BUCHUNG WHERE ART = 'Verleih' AND AUSLEIHDATUM LIKE '%" + search + "%'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void alleVerleihe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,AUSLEIHDATUM,RÜCKGABEDATUM FROM BUCHUNG WHERE ART = 'Verleih' AND RÜCKGABEDATUM IS NULL ORDER BY AUSLEIHDATUM DESC";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}
	



	private void setVars(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2, String makel2) {
		talking = talking2;
		kNr = kNr2;
		geraetNrloc = geraetNr;
		search = search2;
		mode = mode2;
		buchungID = buchungID2;
		if (makel2.equals(""))
			makel = "Kein";
		else
			makel = makel2;
	}
	
	
	
	@Override
	public void anmelden(IObjektView view) {
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void abmelden(IObjektView view) {
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

	public ArrayList<Object> getObjekte() {
		// TODO Auto-generated method stub
		return null;
	}

	public TableModel getTableModel() {
		// TODO Auto-generated method stub
		return table;
	}

}
