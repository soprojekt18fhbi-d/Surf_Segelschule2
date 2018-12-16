package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datenbankmodels.BuchungGeraetAnzeigeModel;
import Datenbankmodels.BuchungKundewaehlenModel;
import Datenbankmodels.BuchungModellAnzeigeModel;
import Datenbankmodels.BuchungTypAnzeigeModel;
import Datenbankmodels.GeraetAnlegenModel;
import Datenbankmodels.KundeSucheModel;
import Datenbankmodels.ModellhinzufuegenModel;
import GUIBuchungsverwaltung.AbgeschlosseneBuchungen;
import GUIBuchungsverwaltung.AktiveAusleihen;
import GUIBuchungsverwaltung.BuchungGerätAuswahl;
import GUIBuchungsverwaltung.Buchungsverwaltung;
import GUIBuchungsverwaltung.KundeWaehlen;
import GUIBuchungsverwaltung.ModellAuswahl;
import GUIBuchungsverwaltung.Reklamation;
import GUIBuchungsverwaltung.StatusSetzen;
import GUIBuchungsverwaltung.TypAuswahl;
import GUIBuchungsverwaltung.VerkaufFormular;
import GUIBuchungsverwaltung.VerleihFormular;
import Steuerung.BuchungGeraetAuswählenStrg;
import Steuerung.BuchungKundeWählenStrg;
import Steuerung.BuchungModellAnzeigeStrg;
import Steuerung.BuchungTypAnzeigeStrg;
import Steuerung.GeraetAnlegenStrg;
import Steuerung.KundeSucheStrg;
import Steuerung.ModellAnlegenStrg;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
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

public class MainFrame extends JFrame {

	
	private JPanel contentPane;
	private static Hauptmenue hauptmenue = new Hauptmenue();
	
	//Models erzeugen:
	private static KundeSucheModel ksucheModel = new KundeSucheModel();
	private static BuchungKundewaehlenModel buchungkwaehlen = new BuchungKundewaehlenModel();
	private static BuchungTypAnzeigeModel buchungtanzeige = new BuchungTypAnzeigeModel();
	private static BuchungModellAnzeigeModel buchungmanzeige = new BuchungModellAnzeigeModel();
	private static BuchungGeraetAnzeigeModel buchungganzeige = new BuchungGeraetAnzeigeModel();
	private static ModellhinzufuegenModel modellHinzufuegen = new ModellhinzufuegenModel();
	private static GeraetAnlegenModel geraetAnlegen = new GeraetAnlegenModel();

	//Controller erzeugen:
	private static KundeSucheStrg ksucheController = new KundeSucheStrg(ksucheModel);
	private static BuchungKundeWählenStrg buchungkwaehlenController = new BuchungKundeWählenStrg(buchungkwaehlen);
	private static BuchungTypAnzeigeStrg buchungtanzeigeController = new BuchungTypAnzeigeStrg(buchungtanzeige);
	private static BuchungModellAnzeigeStrg buchungmanzeigeController = new BuchungModellAnzeigeStrg(buchungmanzeige);
	private static BuchungGeraetAuswählenStrg buchungganzeigeController = new BuchungGeraetAuswählenStrg(buchungganzeige);
	private static ModellAnlegenStrg modellAnlegenStrg = new ModellAnlegenStrg(modellHinzufuegen);
	private static GeraetAnlegenStrg geraetAnlegenStrg = new GeraetAnlegenStrg(geraetAnlegen);	
	
	
	
	
	
	//Geräteverwaltung
	private static GeraeteVerwaltung geraeteVerwaltung = new GeraeteVerwaltung();
	private static GeraeteModellVerwaltung geraeteModellVerwaltung = new GeraeteModellVerwaltung();
	private static GeraeteTypVerwaltung geraeteTypVerwaltung = new GeraeteTypVerwaltung();
	private static Geraethinzufuegen geraethinzufuegen = new Geraethinzufuegen(geraetAnlegen, geraetAnlegenStrg);
	private static Modellaendern modellaendern = new Modellaendern();
	private static Modellhinzufuegen modellhinzufuegen = new Modellhinzufuegen(modellHinzufuegen, modellAnlegenStrg);
	private static SportgeraeteVerwaltung sportgeraete = new SportgeraeteVerwaltung();
	private static Typaendern typaendern = new Typaendern();
	private static Typhinzufuegen typhinzufuegen = new Typhinzufuegen();
	private static Geraetaendern geraetaendern = new Geraetaendern();
	
	
	//Buchungsverwaltung
	private static Buchungsverwaltung buchungsverwaltung = new Buchungsverwaltung();
	private static KundeWaehlen kundeWaehlen = new KundeWaehlen(buchungkwaehlen, buchungkwaehlenController);
	private static TypAuswahl typAuswahl = new TypAuswahl(buchungtanzeige, buchungtanzeigeController);
	private static ModellAuswahl modellAuswahl = new ModellAuswahl(buchungmanzeige, buchungmanzeigeController);
	private static BuchungGerätAuswahl buchungGerätAuswahl = new BuchungGerätAuswahl(buchungganzeige, buchungganzeigeController);
	private static VerleihFormular verleihFormular = new VerleihFormular();
	private static VerkaufFormular verkaufFormular = new VerkaufFormular();
	private static AbgeschlosseneBuchungen abgeschlosseneBuchungen = new AbgeschlosseneBuchungen();
	private static AktiveAusleihen aktiveAusleihen = new AktiveAusleihen();
	private static Reklamation reklamation = new Reklamation();
	private static StatusSetzen statusSetzen = new StatusSetzen();
	
	// Kundenverwaltung
	private static KundenverwaltungGUI kundenverwaltung = new KundenverwaltungGUI(); 
	private static KundeAendern kundeAendern = new KundeAendern(ksucheModel, ksucheController);
	
	
	//Preislistenverwaltung
	private static PreislisteGUI preislisteGUI = new PreislisteGUI(); 
	private static PreislisteAnlegenGUI preislisteAnlegenGUI = new PreislisteAnlegenGUI();
	
	// Rechnungsverwaltung
	private static RechungsverwaltungGUI rechnungsVerwaltung = new RechungsverwaltungGUI(); 
	private static RechnungGUI rechnungDetail = new RechnungGUI();
	
	// Wirtschaftlichkeitsrechnung
	private static WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltung = new WirtschaftlichkeitsverwaltungGUI();
	private static WirtschaftlichkeitEinzelnGUI wirtschaftlichkeitEinzeln = new WirtschaftlichkeitEinzelnGUI();
	private static WirtschaftlichkeitGesamtGUI wirtschaftlichkeitGesamt = new WirtschaftlichkeitGesamtGUI();



	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Boots- & Segelverleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		
		

		
		contentPane.add(hauptmenue);
		contentPane.add(geraeteVerwaltung);
		contentPane.add(typhinzufuegen);
		contentPane.add(typaendern);
		contentPane.add(sportgeraete);
		contentPane.add(modellhinzufuegen);
		contentPane.add(modellaendern);
		contentPane.add(geraethinzufuegen);
		contentPane.add(geraeteTypVerwaltung);
		contentPane.add(geraeteModellVerwaltung);
		contentPane.add(geraetaendern);
		contentPane.add(buchungsverwaltung);
		contentPane.add(kundeWaehlen);
		contentPane.add(typAuswahl);
		contentPane.add(modellAuswahl);
		contentPane.add(buchungGerätAuswahl);
		contentPane.add(verleihFormular);
		contentPane.add(verkaufFormular);
		contentPane.add(abgeschlosseneBuchungen);
		contentPane.add(aktiveAusleihen);
		contentPane.add(reklamation);
		contentPane.add(preislisteGUI);	
		contentPane.add(preislisteAnlegenGUI);	
		contentPane.add(statusSetzen);
		contentPane.add(kundenverwaltung);
		contentPane.add(kundeAendern);
		contentPane.add(rechnungsVerwaltung);
		contentPane.add(rechnungDetail);
		contentPane.add(wirtschaftlichkeitGesamt);
		contentPane.add(wirtschaftlichkeitEinzeln);
		contentPane.add(wirtschaftlichkeitsverwaltung);

		this.hauptmenue.setVisible(true);



	
		
		

	}
	
	public static void change(JPanel a, JPanel b) { //Ben K.
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public static JPanel getHauptmenue(){
		return hauptmenue;
	}
	
	
	public static JPanel getGeraeteVerwaltung(){
		return geraeteVerwaltung;
	}
	
	public static JPanel getGeraeteTypVerwaltung(){
		return geraeteTypVerwaltung;
	}
	
	public static Geraethinzufuegen getGeraethinzufuegen(){
		return geraethinzufuegen;
	}
	
	public static JPanel getModellaendern(){ 	
		return modellaendern;
	}
	
	public static Modellhinzufuegen getModellhinzufuegen(){ 		
		return modellhinzufuegen;
	}
	
	public static JPanel getSportgeraete(){ 		
		return sportgeraete;
	}
	
	public static JPanel getTypaendern(){	
		return typaendern;
	}
	
	public static JPanel getTyphinzufuegen(){		
		return typhinzufuegen;
	}
	
	public static JPanel getGeraeteModellVerwaltung(){ 		
		return geraeteModellVerwaltung;
	}
	
	public static JPanel getGeraetaendern(){ 		
		return geraetaendern;
	}
	
	public static JPanel getBuchungsverwaltung(){ 		
		return buchungsverwaltung;
	}
	
	public static JPanel getKundeWaehlen(){ 		
		return kundeWaehlen;
	}
		
	public static TypAuswahl getTypAuswahl(){ 		
		return typAuswahl;
	}
	
	public static ModellAuswahl getModellAuswahl(){ 		
		return modellAuswahl;
	}
	
	public static BuchungGerätAuswahl getBuchungGerätAuswahl(){ 		
		return buchungGerätAuswahl;
	}
	
	public static JPanel getAbgeschlosseneBuchungen(){ 		
		return abgeschlosseneBuchungen;
	}
	
	public static JPanel getAktiveAusleihen(){ 		
		return aktiveAusleihen;
	}
	
	public static JPanel getReklamation(){ 		
		return reklamation;
	}
	
	public static JPanel getStatusSetzen(){ 		
		return statusSetzen;
	}
		
	public static JPanel getVerleihFormular(){ 		
		return verleihFormular;
	}
	
	public static JPanel getVerkaufFormular(){ 		
		return verkaufFormular;
	}
	
	public static JPanel getPreislisteGUI(){ 		
		return preislisteGUI;
	}
	public static JPanel getPreislisteAnlegenGUI(){ 		
		return preislisteAnlegenGUI;
	}

	public static JPanel getKundenverwaltung() {
		return kundenverwaltung;
	}
	
	public static KundeAendern getKundeAendern() {
		return kundeAendern;
	}
	
	public static JPanel getRechnungsVerwaltung() {
		return rechnungsVerwaltung;
	}
	
	public static JPanel getRechnungDetail() {
		return rechnungDetail;
	}
	

	public static JPanel getWirtschaftlichkeitsverwaltung() {
		return wirtschaftlichkeitsverwaltung;
	}
	
	public static JPanel getWirtschaftlichkeitEinzeln() {
		return wirtschaftlichkeitEinzeln;
	}
	
	public static JPanel getWirtschaftlichkeitGesamt() {
		return wirtschaftlichkeitGesamt;
	}

		
}
	
