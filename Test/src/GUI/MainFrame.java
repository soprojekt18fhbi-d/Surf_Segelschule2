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
import Datenbankmodels.GeraetAnlegenModel;
import Datenbankmodels.KundeAnlegenModel;
import Datenbankmodels.KundeSucheModel;
import Datenbankmodels.ModellHinzufuegenModel;
import Datenbankmodels.RechnungAnzeigenModel;
import GUIBuchungsverwaltung.AbgeschlosseneBuchungenGUI;
import GUIBuchungsverwaltung.AktiveBuchungenGUI;
import GUIBuchungsverwaltung.BuchungGeraetSucheGUI;
import GUIBuchungsverwaltung.BuchungsverwaltungGUI;
import GUIBuchungsverwaltung.BuchungKundeSucheGUI;
import GUIBuchungsverwaltung.BuchungModellSucheGUI;
import GUIBuchungsverwaltung.ReklamationGUI;
import GUIBuchungsverwaltung.StatusSetzenGUI;
import GUIBuchungsverwaltung.BuchungTypSucheGUI;
import GUIBuchungsverwaltung.VerkaufFormularGUI;
import GUIBuchungsverwaltung.VerleihFormularGUI;
import Steuerung.BuchungBuchungAnzeigenStrg;
import Steuerung.BuchungGeraetSucheStrg;
import Steuerung.BuchungKundeSucheStrg;
import Steuerung.BuchungModellSucheStrg;
import Steuerung.BuchungTypSucheStrg;
import Steuerung.GeraetAnlegenStrg;
import Steuerung.KundeAnlegenStrg;
import Steuerung.KundeSucheStrg;
import Steuerung.ModellAnlegenStrg;
import Steuerung.RechnungAnzeigeStrg;

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

public class MainFrame extends JFrame {

	
	private JPanel contentPane;
	private static Hauptmenue hauptmenue = new Hauptmenue();
	
	//Models erzeugen:
	private static KundeSucheModel kundeSucheModel = new KundeSucheModel();
	private static KundeAnlegenModel kundeAnlegenModel = new KundeAnlegenModel();
	private static BuchungKundeSucheModel buchungKundeSucheModel = new BuchungKundeSucheModel();
	private static BuchungTypSucheModel buchungTypSucheModel = new BuchungTypSucheModel();
	private static BuchungModellSucheModel buchungModellSucheModel = new BuchungModellSucheModel();
	private static BuchungGeraetSucheModel buchungGeraetSucheModel = new BuchungGeraetSucheModel();
	private static ModellHinzufuegenModel modellHinzufuegenModel = new ModellHinzufuegenModel();
	private static GeraetAnlegenModel geraetAnlegenModel = new GeraetAnlegenModel();
	private static BuchungAnzeigeModel buchungAnzeigeModel = new BuchungAnzeigeModel();
	private static RechnungAnzeigenModel rechnungAnzeigeModel = new RechnungAnzeigenModel();
	
	
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
	
	
	
	//Ger�teverwaltung
	private static GeraeteVerwaltungGUI geraeteVerwaltung = new GeraeteVerwaltungGUI();
	private static GeraeteModellVerwaltung geraeteModellVerwaltung = new GeraeteModellVerwaltung(buchungModellSucheModel, buchungModellSucheStrg);
	private static GeraeteTypVerwaltungGUI geraeteTypVerwaltungGUI = new GeraeteTypVerwaltungGUI(buchungTypSucheModel, buchungTypSucheStrg);
	private static GeraetAnlegenGUI geraetAnlegenGUI = new GeraetAnlegenGUI(geraetAnlegenModel, geraetAnlegenStrg);
	private static ModellAnedernGUI modellAnedernGUI = new ModellAnedernGUI();
	private static ModellAnlegenGUI modellAnlegenGUI = new ModellAnlegenGUI(modellHinzufuegenModel, modellAnlegenStrg);
	private static SportgeraeteGUI sportgeraete = new SportgeraeteGUI(buchungGeraetSucheModel, buchungGeraetSucheStrg);
	private static TypAendernGUI typAendernGUI = new TypAendernGUI();
	private static TypAnlegenGUI typAnlegenGUI = new TypAnlegenGUI();
	private static GeraetAendernGUI geraetAendernGUI = new GeraetAendernGUI();
	
	
	//BuchungsverwaltungGUI
	private static BuchungsverwaltungGUI buchungsverwaltungGUI = new BuchungsverwaltungGUI();
	private static BuchungKundeSucheGUI buchungKundeSucheGUI = new BuchungKundeSucheGUI(buchungKundeSucheModel, buchungKundeWaehlenStrg);
	private static BuchungTypSucheGUI buchungTypSucheGUI = new BuchungTypSucheGUI(buchungTypSucheModel, buchungTypSucheStrg);
	private static BuchungModellSucheGUI buchungModellSucheGUI = new BuchungModellSucheGUI(buchungModellSucheModel, buchungModellSucheStrg);
	private static BuchungGeraetSucheGUI buchungGeraetSucheGUI = new BuchungGeraetSucheGUI(buchungGeraetSucheModel, buchungGeraetSucheStrg);
	private static VerleihFormularGUI verleihFormularGUI = new VerleihFormularGUI();
	private static VerkaufFormularGUI verkaufFormularGUI = new VerkaufFormularGUI();
	private static AbgeschlosseneBuchungenGUI abgeschlosseneBuchungenGUI = new AbgeschlosseneBuchungenGUI();
	private static AktiveBuchungenGUI aktiveBuchungenGUI = new AktiveBuchungenGUI(buchungAnzeigeModel, buchungBuchungAnzeigenStrg);
	private static ReklamationGUI reklamationGUI = new ReklamationGUI();
	private static StatusSetzenGUI statusSetzenGUI = new StatusSetzenGUI();
	
	// Kundenverwaltung
	private static KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI(); 
	private static KundeAnlegenGUI kundeAnlegenGUI = new KundeAnlegenGUI(kundeAnlegenModel, kundeAnlegenStrg);
	private static KundeAendernGUI kundeAendernGUIGUI = new KundeAendernGUI(kundeSucheModel, kundeSucheStrg);
	
	
	//Preislistenverwaltung
	private static PreislisteGUI preislisteGUI = new PreislisteGUI(); 
	private static PreislisteAnlegenGUI preislisteAnlegenGUI = new PreislisteAnlegenGUI();
	
	// Rechnungsverwaltung
	private static RechungsSucheGUI rechnungSucheGUI = new RechungsSucheGUI(rechnungAnzeigeModel, rechnungAnzeigenStrg); 
	private static RechnungDetailGUI rechnungDetailGUI = new RechnungDetailGUI();
	
	// Wirtschaftlichkeitsrechnung
	private static WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltungGUI = new WirtschaftlichkeitsverwaltungGUI();
	private static WirtschaftlichkeitEinzelnGUI wirtschaftlichkeitEinzelnGUI = new WirtschaftlichkeitEinzelnGUI();
	private static WirtschaftlichkeitGesamtGUI wirtschaftlichkeitGesamtGUI = new WirtschaftlichkeitGesamtGUI();



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
		setIconImage(new ImageIcon(getClass().getResource("/GUI/surfen.png")).getImage());
		
		

		
		contentPane.add(hauptmenue);
		contentPane.add(geraeteVerwaltung);
		contentPane.add(typAnlegenGUI);
		contentPane.add(typAendernGUI);
		contentPane.add(sportgeraete);
		contentPane.add(modellAnlegenGUI);
		contentPane.add(modellAnedernGUI);
		contentPane.add(geraetAnlegenGUI);
		contentPane.add(geraeteTypVerwaltungGUI);
		contentPane.add(geraeteModellVerwaltung);
		contentPane.add(geraetAendernGUI);
		contentPane.add(buchungsverwaltungGUI);
		contentPane.add(buchungKundeSucheGUI);
		contentPane.add(buchungTypSucheGUI);
		contentPane.add(buchungModellSucheGUI);
		contentPane.add(buchungGeraetSucheGUI);
		contentPane.add(verleihFormularGUI);
		contentPane.add(verkaufFormularGUI);
		contentPane.add(abgeschlosseneBuchungenGUI);
		contentPane.add(aktiveBuchungenGUI);
		contentPane.add(reklamationGUI);
		contentPane.add(preislisteGUI);	
		contentPane.add(preislisteAnlegenGUI);	
		contentPane.add(statusSetzenGUI);
		contentPane.add(kundenverwaltungGUI);
		contentPane.add(kundeAnlegenGUI);
		contentPane.add(kundeAendernGUIGUI);
		contentPane.add(rechnungSucheGUI);
		contentPane.add(rechnungDetailGUI);
		contentPane.add(wirtschaftlichkeitGesamtGUI);
		contentPane.add(wirtschaftlichkeitEinzelnGUI);
		contentPane.add(wirtschaftlichkeitsverwaltungGUI);

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
	
	public static GeraeteTypVerwaltungGUI getGeraeteTypVerwaltung(){
		return geraeteTypVerwaltungGUI;
	}
	
	public static GeraetAnlegenGUI getGeraethinzufuegen(){
		return geraetAnlegenGUI;
	}
	
	public static JPanel getModellaendern(){ 	
		return modellAnedernGUI;
	}
	
	public static ModellAnlegenGUI getModellhinzufuegen(){ 		
		return modellAnlegenGUI;
	}
	
	public static SportgeraeteGUI getSportgeraete(){ 		
		return sportgeraete;
	}
	
	public static JPanel getTypaendern(){	
		return typAendernGUI;
	}
	
	public static JPanel getTyphinzufuegen(){		
		return typAnlegenGUI;
	}
	
	public static GeraeteModellVerwaltung getGeraeteModellVerwaltung(){ 		
		return geraeteModellVerwaltung;
	}
	
	public static JPanel getGeraetaendern(){ 		
		return geraetAendernGUI;
	}
	
	public static JPanel getBuchungsverwaltung(){ 		
		return buchungsverwaltungGUI;
	}
	
	public static JPanel getKundeWaehlen(){ 		
		return buchungKundeSucheGUI;
	}
		
	public static BuchungTypSucheGUI getTypAuswahl(){ 		
		return buchungTypSucheGUI;
	}
	
	public static BuchungModellSucheGUI getModellAuswahl(){ 		
		return buchungModellSucheGUI;
	}
	
	public static BuchungGeraetSucheGUI getBuchungGer�tAuswahl(){ 		
		return buchungGeraetSucheGUI;
	}
	
	public static JPanel getAbgeschlosseneBuchungen(){ 		
		return abgeschlosseneBuchungenGUI;
	}
	
	public static AktiveBuchungenGUI getAktiveBuchung(){ 		
		return aktiveBuchungenGUI;
	}
	
	public static JPanel getReklamation(){ 		
		return reklamationGUI;
	}
	
	public static JPanel getStatusSetzen(){ 		
		return statusSetzenGUI;
	}
		
	public static JPanel getVerleihFormular(){ 		
		return verleihFormularGUI;
	}
	
	public static JPanel getVerkaufFormular(){ 		
		return verkaufFormularGUI;
	}
	
	public static JPanel getPreislisteGUI(){ 		
		return preislisteGUI;
	}
	public static JPanel getPreislisteAnlegenGUI(){ 		
		return preislisteAnlegenGUI;
	}

	public static JPanel getKundenverwaltung() {
		return kundenverwaltungGUI;
	}
	
	public static JPanel getKundeRegistrieren() {
		return kundeAnlegenGUI;
	}
	
	public static KundeAendernGUI getKundeAendernGUI() {
		return kundeAendernGUIGUI;
	}
	
	public static RechungsSucheGUI getRechnungsVerwaltung() {
		return rechnungSucheGUI;
	}
	
	public static JPanel getRechnungDetail() {
		return rechnungDetailGUI;
	}
	

	public static JPanel getWirtschaftlichkeitsverwaltung() {
		return wirtschaftlichkeitsverwaltungGUI;
	}
	
	public static JPanel getWirtschaftlichkeitEinzeln() {
		return wirtschaftlichkeitEinzelnGUI;
	}
	
	public static JPanel getWirtschaftlichkeitGesamt() {
		return wirtschaftlichkeitGesamtGUI;
	}

		
}
	
