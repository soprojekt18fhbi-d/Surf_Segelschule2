package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUIBuchungsverwaltung.AbgeschlosseneBuchungen;
import GUIBuchungsverwaltung.AktiveAusleihen;
import GUIBuchungsverwaltung.BuchungsTypAuswahl;
import GUIBuchungsverwaltung.Buchungsverwaltung;
import GUIBuchungsverwaltung.GerätAuswahlAusleihe;
import GUIBuchungsverwaltung.GerätAuswahlVerkauf;
import GUIBuchungsverwaltung.KundeWaehlen;
import GUIBuchungsverwaltung.ModellAuswahl;
import GUIBuchungsverwaltung.Reklamation;
import GUIBuchungsverwaltung.StatusSetzen;
import GUIBuchungsverwaltung.TypAuswahl;
import GUIBuchungsverwaltung.VerkaufFormular;
import GUIBuchungsverwaltung.VerleihFormular;

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
	private static Geraetaendern geraetaendern = new Geraetaendern();
	private static GeraeteModellVerwaltung geraeteModellVerwaltung = new GeraeteModellVerwaltung();
	private static GeraeteTypVerwaltung geraeteTypVerwaltung = new GeraeteTypVerwaltung();
	private static Geraethinzufuegen geraethinzufuegen = new Geraethinzufuegen();
	private static Modellaendern modellaendern = new Modellaendern();
	private static Modellhinzufuegen modellhinzufuegen = new Modellhinzufuegen();
	private static Sportgeraete sportgeraete = new Sportgeraete();
	private static Typaendern typaendern = new Typaendern();
	private static Typhinzufuegen typhinzufuegen = new Typhinzufuegen();
	private static JPanel StandortPanel = new StandortPanel();
	
	//Buchungsverwaltung
	private static Buchungsverwaltung buchungsverwaltung = new Buchungsverwaltung();
	private static KundeWaehlen kundeWaehlen = new KundeWaehlen();
	private static BuchungsTypAuswahl buchungsTypAuswahl = new BuchungsTypAuswahl();
	private static TypAuswahl typAuswahl = new TypAuswahl();
	private static ModellAuswahl modellAuswahl = new ModellAuswahl();
	private static GerätAuswahlAusleihe gerätAuswahlAusleihe = new GerätAuswahlAusleihe();
	private static GerätAuswahlVerkauf gerätAuswahlVerkauf = new GerätAuswahlVerkauf();
	private static VerleihFormular verleihFormular = new VerleihFormular();
	private static VerkaufFormular verkaufFormular = new VerkaufFormular();
	private static AbgeschlosseneBuchungen abgeschlosseneBuchungen = new AbgeschlosseneBuchungen();
	private static AktiveAusleihen aktiveAusleihen = new AktiveAusleihen();
	private static Reklamation reklamation = new Reklamation();
	private static StatusSetzen statusSetzen = new StatusSetzen();
	
	// Kundenverwaltung
	private static KundenverwaltungGUI kundenverwaltung = new KundenverwaltungGUI(); 
	private static KundeAendern kundeAendern = new KundeAendern();
	
	// Wirtschaftlichkeitsrechnung
	private static WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltung = new WirtschaftlichkeitsverwaltungGUI();
	private static WirtschaftlichkeitEinzelnGUI wirtschaftlichkeitEinzeln = new WirtschaftlichkeitEinzelnGUI();
	private static WirtschaftlichkeitGesamtGUI wirtschaftlichkeitGesamt = new WirtschaftlichkeitGesamtGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		
		contentPane.add(StandortPanel, "name_285477213159744");
		StandortPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add(hauptmenue);
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
		contentPane.add(buchungsTypAuswahl);
		contentPane.add(typAuswahl);
		contentPane.add(modellAuswahl);
		contentPane.add(gerätAuswahlAusleihe);
		contentPane.add(gerätAuswahlVerkauf);
		contentPane.add(verleihFormular);
		contentPane.add(verkaufFormular);
		contentPane.add(abgeschlosseneBuchungen);
		contentPane.add(aktiveAusleihen);
		contentPane.add(reklamation);
		contentPane.add(statusSetzen);
		contentPane.add(kundenverwaltung);
		contentPane.add(kundeAendern);
		contentPane.add(wirtschaftlichkeitGesamt);
		contentPane.add(wirtschaftlichkeitEinzeln);
		contentPane.add(wirtschaftlichkeitsverwaltung);

		
		JLabel label = new JLabel("Bitte Standort w\u00E4hlen:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 48));
		
		JButton button = new JButton("\u00DCberspringen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StandortPanel.setVisible(false);
				hauptmenue.setVisible(true);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("Weiter");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		
		
		GroupLayout gl_StandortPanel = new GroupLayout(StandortPanel);
		gl_StandortPanel.setHorizontalGroup(
			gl_StandortPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 984, Short.MAX_VALUE)
				.addGroup(gl_StandortPanel.createSequentialGroup()
					.addGroup(gl_StandortPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
						.addGroup(gl_StandortPanel.createSequentialGroup()
							.addGap(210)
							.addGroup(gl_StandortPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_StandortPanel.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_StandortPanel.setVerticalGroup(
			gl_StandortPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 561, Short.MAX_VALUE)
				.addGroup(gl_StandortPanel.createSequentialGroup()
					.addGap(77)
					.addComponent(label)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addGroup(gl_StandortPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		StandortPanel.setLayout(gl_StandortPanel);
	}
	
	public static void change(JPanel a, JPanel b) { //Ben K.
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public static JPanel getHauptmenue(){
		return hauptmenue;
	}
	
	public static JPanel getGeraeteTypVerwaltung(){
		return geraeteTypVerwaltung;
	}
	
	public static JPanel getGeraethinzufuegen(){
		return geraethinzufuegen;
	}
	
	public static JPanel getModellaendern(){ 	
		return modellaendern;
	}
	
	public static JPanel getModellhinzufuegen(){ 		
		return modellhinzufuegen;
	}
	
	public static JPanel getSportgeraete(){ 		
		return sportgeraete;
	}
	
	public static JPanel getStandortPanel(){		
		return StandortPanel;
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
	
	public static JPanel getBuchungsTypAuswahl(){ 		
		return buchungsTypAuswahl;
	}
	
	public static JPanel getTypAuswahl(){ 		
		return typAuswahl;
	}
	
	public static JPanel getModellAuswahl(){ 		
		return modellAuswahl;
	}
	
	public static JPanel getGerätAuswahlAusleihe(){ 		
		return gerätAuswahlAusleihe;
	}
	
	public static JPanel getGerätAuswahlVerkauf(){ 		
		return gerätAuswahlVerkauf;
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

	public static JPanel getKundenverwaltung() {
		return kundenverwaltung;
	}
	
	public static KundeAendern getKundeAendern() {
		return kundeAendern;
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
	
