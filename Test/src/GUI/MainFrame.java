package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datenbankmodels.BuchungAnzeigeModel;
import Datenbankmodels.BuchungGeraetSucheModel;
import Datenbankmodels.BuchungKundeSucheModel;
import Datenbankmodels.BuchungModellSucheModel;
import Datenbankmodels.BuchungTypSucheModel;
import Datenbankmodels.DBConnectorSingleton;
import Datenbankmodels.GeraetAnlegenModel;
import Datenbankmodels.KundeAnlegenModel;
import Datenbankmodels.KundeSucheModel;
import Datenbankmodels.ModellAnlegenModel;
import Datenbankmodels.PreislisteSucheModel;
import Datenbankmodels.RechnungAnzeigenModel;
import Datenbankmodels.WirtschaftlichkeitModel;
import GUIBuchungsverwaltung.AktiveBuchungenGUI;
import GUIBuchungsverwaltung.BuchungGeraetSucheGUI;
import GUIBuchungsverwaltung.BuchungsverwaltungGUI;
import GUIBuchungsverwaltung.BuchungKundeSucheGUI;
import GUIBuchungsverwaltung.BuchungModellSucheGUI;
import GUIBuchungsverwaltung.BuchungTypSucheGUI;
import Steuerung.BuchungBuchungAnzeigenStrg;
import Steuerung.BuchungGeraetSucheStrg;
import Steuerung.BuchungKundeSucheStrg;
import Steuerung.BuchungModellSucheStrg;
import Steuerung.BuchungTypSucheStrg;
import Steuerung.GeraetAnlegenStrg;
import Steuerung.KundeAnlegenStrg;
import Steuerung.KundeSucheStrg;
import Steuerung.ModellAnlegenStrg;
import Steuerung.PreislisteSucheStrg;
import Steuerung.RechnungAnzeigeStrg;
import Steuerung.WirtschaftlichkeitStrg;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame {

	
	private static int standort;
	
	private JPanel contentPane;
	private static Hauptmenue hauptmenueGUI = new Hauptmenue();
	
	
	//Models erzeugen:
	private static KundeSucheModel kundeSucheModel = new KundeSucheModel();
	private static KundeAnlegenModel kundeAnlegenModel = new KundeAnlegenModel();
	private static BuchungKundeSucheModel buchungKundeSucheModel = new BuchungKundeSucheModel();
	private static BuchungTypSucheModel buchungTypSucheModel = new BuchungTypSucheModel();
	private static BuchungModellSucheModel buchungModellSucheModel = new BuchungModellSucheModel();
	private static BuchungGeraetSucheModel buchungGeraetSucheModel = new BuchungGeraetSucheModel();
	private static ModellAnlegenModel modellHinzufuegenModel = new ModellAnlegenModel();
	private static GeraetAnlegenModel geraetAnlegenModel = new GeraetAnlegenModel();
	private static BuchungAnzeigeModel buchungAnzeigeModel = new BuchungAnzeigeModel();
	private static RechnungAnzeigenModel rechnungAnzeigeModel = new RechnungAnzeigenModel();
	private static WirtschaftlichkeitModel wModel = new WirtschaftlichkeitModel();
	private static PreislisteSucheModel preislisteSucheModel = new PreislisteSucheModel();
	
	
	//Controller erzeugen:
	private static KundeSucheStrg kundeSucheStrg = new KundeSucheStrg(kundeSucheModel);
	private static KundeAnlegenStrg kundeAnlegenStrg = new KundeAnlegenStrg(kundeAnlegenModel);
	private static BuchungKundeSucheStrg buchungKundeWaehlenStrg = new BuchungKundeSucheStrg(buchungKundeSucheModel);
	private static BuchungTypSucheStrg buchungTypSucheStrg = new BuchungTypSucheStrg(buchungTypSucheModel);
	private static BuchungModellSucheStrg buchungModellSucheStrg = new BuchungModellSucheStrg(buchungModellSucheModel);
	private static BuchungGeraetSucheStrg buchungGeraetSucheStrg = new BuchungGeraetSucheStrg(buchungGeraetSucheModel);
	private static ModellAnlegenStrg modellAnlegenStrg = new ModellAnlegenStrg(modellHinzufuegenModel);
	private static GeraetAnlegenStrg geraetAnlegenStrg = new GeraetAnlegenStrg(geraetAnlegenModel);	
	private static BuchungBuchungAnzeigenStrg buchungBuchungAnzeigenStrg = new BuchungBuchungAnzeigenStrg(buchungAnzeigeModel);
	private static RechnungAnzeigeStrg rechnungAnzeigenStrg = new RechnungAnzeigeStrg(rechnungAnzeigeModel);
	private static WirtschaftlichkeitStrg wStrg = new WirtschaftlichkeitStrg(wModel);
	private static PreislisteSucheStrg preislisteSucheStrg = new PreislisteSucheStrg(preislisteSucheModel);
	
	
	//Geräteverwaltung
	private static GeraeteVerwaltungGUI geraeteVerwaltungGUI = new GeraeteVerwaltungGUI();
	private static GeraeteModellVerwaltungGUI geraeteModellVerwaltungGUI = new GeraeteModellVerwaltungGUI(buchungModellSucheModel, buchungModellSucheStrg);
	private static GeraeteTypVerwaltungGUI geraeteTypVerwaltungGUI = new GeraeteTypVerwaltungGUI(buchungTypSucheModel, buchungTypSucheStrg);
	private static GeraetAnlegenGUI geraetAnlegenGUI = new GeraetAnlegenGUI(geraetAnlegenModel, geraetAnlegenStrg);
	private static ModellAendernGUI modellAnedernGUI = new ModellAendernGUI(modellHinzufuegenModel, modellAnlegenStrg);
	private static ModellAnlegenGUI modellAnlegenGUI = new ModellAnlegenGUI(modellHinzufuegenModel, modellAnlegenStrg);
	private static SportgeraeteVerwaltungGUI sportgeraeteGUI = new SportgeraeteVerwaltungGUI(buchungGeraetSucheModel, buchungGeraetSucheStrg);
	private static TypAendernGUI typAendernGUI = new TypAendernGUI();
	private static TypAnlegenGUI typAnlegenGUI = new TypAnlegenGUI();
	private static GeraetAendernGUI geraetAendernGUI = new GeraetAendernGUI();
	
	
	//BuchungsverwaltungGUI
	private static BuchungsverwaltungGUI buchungsverwaltungGUI = new BuchungsverwaltungGUI();
	private static BuchungKundeSucheGUI buchungKundeSucheGUI = new BuchungKundeSucheGUI(buchungKundeSucheModel, buchungKundeWaehlenStrg);
	private static BuchungTypSucheGUI buchungTypSucheGUI = new BuchungTypSucheGUI(buchungTypSucheModel, buchungTypSucheStrg);
	private static BuchungModellSucheGUI buchungModellSucheGUI = new BuchungModellSucheGUI(buchungModellSucheModel, buchungModellSucheStrg);
	private static BuchungGeraetSucheGUI buchungGeraetSucheGUI = new BuchungGeraetSucheGUI(buchungGeraetSucheModel, buchungGeraetSucheStrg);
	private static AktiveBuchungenGUI aktiveBuchungenGUI = new AktiveBuchungenGUI(buchungAnzeigeModel, buchungBuchungAnzeigenStrg);
	
	
	// Kundenverwaltung
	private static KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI(); 
	private static KundeAnlegenGUI kundeAnlegenGUI = new KundeAnlegenGUI(kundeAnlegenModel, kundeAnlegenStrg);
	private static KundeAendernGUI kundeAendernGUI = new KundeAendernGUI(kundeSucheModel, kundeSucheStrg);
	
	
	//Preislistenverwaltung
	private static PreislisteGUI preislisteGUI = new PreislisteGUI(preislisteSucheModel, preislisteSucheStrg); 
	private static PreislisteAnlegenGUI preislisteAnlegenGUI = new PreislisteAnlegenGUI();
	
	// Rechnungsverwaltung
	private static RechungsSucheGUI rechnungSucheGUI = new RechungsSucheGUI(rechnungAnzeigeModel, rechnungAnzeigenStrg); 
	
	// Wirtschaftlichkeitsrechnung
	private static WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltungGUI = new WirtschaftlichkeitsverwaltungGUI(wModel, wStrg);




	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(Color.DARK_GRAY);
		setTitle("Boots- & Segelverleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setIconImage(new ImageIcon(getClass().getResource("/GUI/surfen.png")).getImage());
		
		

		
		contentPane.add(hauptmenueGUI);
		contentPane.add(geraeteVerwaltungGUI);
		contentPane.add(typAnlegenGUI);
		contentPane.add(typAendernGUI);
		contentPane.add(sportgeraeteGUI);
		contentPane.add(modellAnlegenGUI);
		contentPane.add(modellAnedernGUI);
		contentPane.add(geraetAnlegenGUI);
		contentPane.add(geraeteTypVerwaltungGUI);
		contentPane.add(geraeteModellVerwaltungGUI);
		contentPane.add(geraetAendernGUI);
		contentPane.add(buchungsverwaltungGUI);
		contentPane.add(buchungKundeSucheGUI);
		contentPane.add(buchungTypSucheGUI);
		contentPane.add(buchungModellSucheGUI);
		contentPane.add(buchungGeraetSucheGUI);
		contentPane.add(aktiveBuchungenGUI);
		contentPane.add(preislisteGUI);	
		contentPane.add(preislisteAnlegenGUI);	
		contentPane.add(kundenverwaltungGUI);
		contentPane.add(kundeAnlegenGUI);
		contentPane.add(kundeAendernGUI);
		contentPane.add(rechnungSucheGUI);;
		contentPane.add(wirtschaftlichkeitsverwaltungGUI);

		this.hauptmenueGUI.setVisible(true);



	
		
		

	}
	
	public static void change(JPanel a, JPanel b) { //Ben K.
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public static JPanel getHauptmenueGUI(){
		return hauptmenueGUI;
	}
	
	
	public static JPanel getGeraeteVerwaltungGUI(){
		return geraeteVerwaltungGUI;
	}
	
	public static GeraeteTypVerwaltungGUI getGeraeteTypVerwaltung(){
		return geraeteTypVerwaltungGUI;
	}
	
	public static GeraetAnlegenGUI getGeraetAnlegenGUI(){
		return geraetAnlegenGUI;
	}
	
	public static ModellAendernGUI getModellAendernGUI(){ 	
		return modellAnedernGUI;
	}
	
	public static ModellAnlegenGUI getModellAnlegenGUI(){ 		
		return modellAnlegenGUI;
	}
	
	public static SportgeraeteVerwaltungGUI getSportgeraeteGUI(){ 		
		return sportgeraeteGUI;
	}
	
	public static TypAendernGUI getTypAendernGUI(){	
		return typAendernGUI;
	}
	
	public static JPanel getTypAnlegenGUI(){		
		return typAnlegenGUI;
	}
	
	public static GeraeteModellVerwaltungGUI getGeraeteModellVerwaltungGUIGUI(){ 		
		return geraeteModellVerwaltungGUI;
	}
	
	public static JPanel getGeraetAendernGUI(){ 		
		return geraetAendernGUI;
	}
	
	public static JPanel getBuchungsverwaltungGUI(){ 		
		return buchungsverwaltungGUI;
	}
	
	public static JPanel getBuchungKundeSucheGUI(){ 		
		return buchungKundeSucheGUI;
	}
		
	public static BuchungTypSucheGUI getBuchungTypSucheGUI(){ 		
		return buchungTypSucheGUI;
	}
	
	public static BuchungModellSucheGUI getBuchungModellSucheGUI(){ 		
		return buchungModellSucheGUI;
	}
	
	public static BuchungGeraetSucheGUI getBuchungGeraetSucheGUI(){ 		
		return buchungGeraetSucheGUI;
	}
	
	public static AktiveBuchungenGUI getAktiveBuchungenGUI(){ 		
		return aktiveBuchungenGUI;
	}
	
	public static JPanel getPreislisteGUI(){ 		
		return preislisteGUI;
	}
	public static JPanel getPreislisteAnlegenGUI(){ 		
		return preislisteAnlegenGUI;
	}

	public static JPanel getKundenverwaltungGUI() {
		return kundenverwaltungGUI;
	}
	
	public static JPanel getKundeAnlegenGUI() {
		return kundeAnlegenGUI;
	}
	
	public static KundeAendernGUI getKundeAendernGUI() {
		return kundeAendernGUI;
	}
	
	public static RechungsSucheGUI getRechnungSucheGUI() {
		return rechnungSucheGUI;
	}
	

	public static WirtschaftlichkeitsverwaltungGUI getWirtschaftlichkeitsverwaltungGUI() {
		return wirtschaftlichkeitsverwaltungGUI;
	}

	public static void setStandort(int standort2) {
		// TODO Auto-generated method stub
		standort = standort2;
		System.out.println("Sie sind im Standort mit der ID: " + standort + " eingeloggt.");
	}

	public static int getStandort() {
		// TODO Auto-generated method stub
		return standort;
	}
	
		
}
	
