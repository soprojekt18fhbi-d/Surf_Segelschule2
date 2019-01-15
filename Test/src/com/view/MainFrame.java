package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.BuchungBuchungAnzeigenStrg;
import com.controller.BuchungGeraetSucheStrg;
import com.controller.BuchungKundeSucheStrg;
import com.controller.BuchungModellSucheStrg;
import com.controller.BuchungTypSucheStrg;
import com.controller.GeraetAnlegenStrg;
import com.controller.KundeAnlegenStrg;
import com.controller.KundeSucheStrg;
import com.controller.ModellAnlegenStrg;
import com.controller.PreislisteSucheStrg;
import com.controller.RechnungAnzeigeStrg;
import com.controller.WirtschaftlichkeitStrg;
import com.model.BuchungAnzeigeModel;
import com.model.BuchungGeraetSucheModel;
import com.model.BuchungKundeSucheModel;
import com.model.BuchungModellSucheModel;
import com.model.BuchungTypSucheModel;
import com.model.DBConnectorSingleton;
import com.model.GeraetAnlegenModel;
import com.model.KundeAnlegenModel;
import com.model.KundeSucheModel;
import com.model.ModellAnlegenModel;
import com.model.PreislisteSucheModel;
import com.model.RechnungAnzeigenModel;
import com.model.WirtschaftlichkeitModel;

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

public class MainFrame extends JFrame { //Ben Kröncke

	private static int standort;

	private JPanel contentPane;
	private static Hauptmenue hauptmenueGUI = new Hauptmenue();

	// Geräteverwaltung
	private static GeraeteVerwaltungGUI geraeteVerwaltungGUI;
	private static GeraeteModellVerwaltungGUI geraeteModellVerwaltungGUI;
	private static GeraeteTypVerwaltungGUI geraeteTypVerwaltungGUI;
	private static GeraetAnlegenGUI geraetAnlegenGUI;
	private static GeraetAendernGUI geraetAendernGUI;
	private static GeraeteStatusGUI geraeteStatusGUI;
	private static GeraeteReparaturGUI geraeteReparaturGUI;
	private static ModellAendernGUI modellAnedernGUI;
	private static ModellAnlegenGUI modellAnlegenGUI;
	private static SportgeraeteVerwaltungGUI sportgeraeteGUI;
	private static TypAendernGUI typAendernGUI;
	private static TypAnlegenGUI typAnlegenGUI;

	// BuchungsverwaltungGUI
	private static BuchungsverwaltungGUI buchungsverwaltungGUI;
	private static BuchungKundeSucheGUI buchungKundeSucheGUI;
	private static BuchungTypSucheGUI buchungTypSucheGUI;
	private static BuchungModellSucheGUI buchungModellSucheGUI;
	private static BuchungGeraetSucheGUI buchungGeraetSucheGUI;
	private static AktiveBuchungenGUI aktiveBuchungenGUI;

	// Kundenverwaltung
	private static KundenverwaltungGUI kundenverwaltungGUI;
	private static KundeAnlegenGUI kundeAnlegenGUI;
	private static KundeAendernGUI kundeAendernGUI;

	// Preislistenverwaltung
	private static PreislisteGUI preislisteGUI;
	private static PreislisteAnlegenGUI preislisteAnlegenGUI;
	private static PreislisteAendernGUI preislisteAendernGUI;

	// Rechnungsverwaltung
	private static RechungsSucheGUI rechnungSucheGUI;

	// Wirtschaftlichkeitsrechnung
	private static WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltungGUI;

	/**
	 * Create the frame.
	 */
	public MainFrame(GeraeteVerwaltungGUI geraeteVerwaltungGUI, GeraeteModellVerwaltungGUI geraeteModellVerwaltungGUI,
			GeraeteTypVerwaltungGUI geraeteTypVerwaltungGUI, GeraetAnlegenGUI geraetAnlegenGUI,
			GeraetAendernGUI geraetAendernGUI, GeraeteStatusGUI geraeteStatusGUI,
			GeraeteReparaturGUI geraeteReparaturGUI, ModellAendernGUI modellAnedernGUI,
			ModellAnlegenGUI modellAnlegenGUI, SportgeraeteVerwaltungGUI sportgeraeteGUI, TypAendernGUI typAendernGUI,
			TypAnlegenGUI typAnlegenGUI, BuchungsverwaltungGUI buchungsverwaltungGUI,
			BuchungKundeSucheGUI buchungKundeSucheGUI, BuchungTypSucheGUI buchungTypSucheGUI,
			BuchungModellSucheGUI buchungModellSucheGUI, BuchungGeraetSucheGUI buchungGeraetSucheGUI,
			AktiveBuchungenGUI aktiveBuchungenGUI, KundenverwaltungGUI kundenverwaltungGUI,
			KundeAnlegenGUI kundeAnlegenGUI, KundeAendernGUI kundeAendernGUI, PreislisteGUI preislisteGUI,
			PreislisteAnlegenGUI preislisteAnlegenGUI, PreislisteAendernGUI preislisteAendernGUI,
			RechungsSucheGUI rechnungSucheGUI, WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltungGUI) {

		MainFrame.geraeteVerwaltungGUI = geraeteVerwaltungGUI;
		MainFrame.geraeteModellVerwaltungGUI = geraeteModellVerwaltungGUI;
		MainFrame.geraeteTypVerwaltungGUI = geraeteTypVerwaltungGUI;
		MainFrame.geraetAnlegenGUI = geraetAnlegenGUI;
		MainFrame.geraetAendernGUI = geraetAendernGUI;
		MainFrame.geraeteStatusGUI = geraeteStatusGUI;
		MainFrame.geraeteReparaturGUI = geraeteReparaturGUI;
		MainFrame.modellAnedernGUI = modellAnedernGUI;
		MainFrame.modellAnlegenGUI = modellAnlegenGUI;
		MainFrame.sportgeraeteGUI = sportgeraeteGUI;
		MainFrame.typAendernGUI = typAendernGUI;
		MainFrame.typAnlegenGUI = typAnlegenGUI;
		MainFrame.buchungsverwaltungGUI = buchungsverwaltungGUI;
		MainFrame.buchungKundeSucheGUI = buchungKundeSucheGUI;
		MainFrame.buchungTypSucheGUI = buchungTypSucheGUI;
		MainFrame.buchungModellSucheGUI = buchungModellSucheGUI;
		MainFrame.buchungGeraetSucheGUI = buchungGeraetSucheGUI;
		MainFrame.aktiveBuchungenGUI = aktiveBuchungenGUI;
		MainFrame.kundenverwaltungGUI = kundenverwaltungGUI;
		MainFrame.kundeAnlegenGUI = kundeAnlegenGUI;
		MainFrame.kundeAendernGUI = kundeAendernGUI;
		MainFrame.preislisteGUI = preislisteGUI;
		MainFrame.preislisteAnlegenGUI = preislisteAnlegenGUI;
		MainFrame.preislisteAendernGUI = preislisteAendernGUI;
		MainFrame.rechnungSucheGUI = rechnungSucheGUI;
		MainFrame.wirtschaftlichkeitsverwaltungGUI = wirtschaftlichkeitsverwaltungGUI;

		setBackground(Color.DARK_GRAY);
		setTitle("Surf- & Segelcenter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setIconImage(new ImageIcon(getClass().getResource("surfen.png")).getImage());

		contentPane.add(hauptmenueGUI);
		contentPane.add(geraeteVerwaltungGUI);
		contentPane.add(typAnlegenGUI);
		contentPane.add(typAendernGUI);
		contentPane.add(sportgeraeteGUI);
		contentPane.add(modellAnlegenGUI);
		contentPane.add(modellAnedernGUI);
		contentPane.add(geraetAnlegenGUI);
		contentPane.add(geraeteStatusGUI);
		contentPane.add(geraeteReparaturGUI);
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
		contentPane.add(preislisteAendernGUI);
		contentPane.add(kundenverwaltungGUI);
		contentPane.add(kundeAnlegenGUI);
		contentPane.add(kundeAendernGUI);
		contentPane.add(rechnungSucheGUI);
		;
		contentPane.add(wirtschaftlichkeitsverwaltungGUI);

		this.hauptmenueGUI.setVisible(true);

	}

	public static void change(JPanel a, JPanel b) { // Ben K.

		a.setVisible(false);
		b.setVisible(true);

	}

	public static JPanel getHauptmenueGUI() {
		return hauptmenueGUI;
	}

	public static JPanel getGeraeteVerwaltungGUI() {
		return geraeteVerwaltungGUI;
	}

	public static GeraeteTypVerwaltungGUI getGeraeteTypVerwaltung() {
		return geraeteTypVerwaltungGUI;
	}

	public static GeraetAnlegenGUI getGeraetAnlegenGUI() {
		return geraetAnlegenGUI;
	}

	public static ModellAendernGUI getModellAendernGUI() {
		return modellAnedernGUI;
	}

	public static ModellAnlegenGUI getModellAnlegenGUI() {
		return modellAnlegenGUI;
	}

	public static SportgeraeteVerwaltungGUI getSportgeraeteGUI() {
		return sportgeraeteGUI;
	}

	public static TypAendernGUI getTypAendernGUI() {
		return typAendernGUI;
	}

	public static JPanel getTypAnlegenGUI() {
		return typAnlegenGUI;
	}

	public static GeraeteModellVerwaltungGUI getGeraeteModellVerwaltungGUI() {
		return geraeteModellVerwaltungGUI;
	}

	public static GeraetAendernGUI getGeraetAendernGUI() {
		return geraetAendernGUI;
	}

	public static GeraeteStatusGUI getGeraeteStatusGUI() {
		return geraeteStatusGUI;
	}

	public static GeraeteReparaturGUI getGeraeteReparaturGUI() {
		return geraeteReparaturGUI;
	}

	public static JPanel getBuchungsverwaltungGUI() {
		return buchungsverwaltungGUI;
	}

	public static JPanel getBuchungKundeSucheGUI() {
		return buchungKundeSucheGUI;
	}

	public static BuchungTypSucheGUI getBuchungTypSucheGUI() {
		return buchungTypSucheGUI;
	}

	public static BuchungModellSucheGUI getBuchungModellSucheGUI() {
		return buchungModellSucheGUI;
	}

	public static BuchungGeraetSucheGUI getBuchungGeraetSucheGUI() {
		return buchungGeraetSucheGUI;
	}

	public static AktiveBuchungenGUI getAktiveBuchungenGUI() {
		return aktiveBuchungenGUI;
	}

	public static PreislisteGUI getPreislisteGUI() {
		return preislisteGUI;
	}

	public static PreislisteAnlegenGUI getPreislisteAnlegenGUI() {
		return preislisteAnlegenGUI;
	}

	public static PreislisteAendernGUI getPreislisteAendernGUI() {
		return preislisteAendernGUI;
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
