/*
 *  @author Michael Schmidt
 */

package com.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controller.BuchungGeraetSucheStrg;
import com.model.IObjektModel;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class SportgeraeteVerwaltungGUI extends JPanel implements IObjektView {
	private BuchungGeraetSucheStrg controller;
	private IObjektModel model;
	private JTextField textSuchen;
	private JTable table;
	private String talking = "gesamt";
	private int kNr;
	private int geraetNr;
	private int modellNr;
	private Icon lupe;
	private int modellID;
	private int geraeteID;
	private String farbe;
	private String makel;
	private double anschaffungspreis;
	private double verkaufspreis;
	private int baujahr;
	private int standortID;

	/**
	 * Create the panel.
	 */
	public SportgeraeteVerwaltungGUI(IObjektModel models, BuchungGeraetSucheStrg controllers) {
		model = models;
		controller = controllers;

		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurck.setBackground(new Color(255, 140, 0));

		textSuchen = new JTextField("Suchen...");
		textSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSuchen.setColumns(10);

		lupe = new ImageIcon(getClass().getResource("suchenLogo.png"));
		JLabel label = new JLabel(lupe);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE).addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
						.addContainerGap(17, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnGeraetHinzu = new JButton("Ger\u00E4t hinzuf\u00FCgen");
		btnGeraetHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeraetHinzu.setBackground(new Color(255, 140, 0));
		btnGeraetHinzu.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnGeraetHinzu = new GridBagConstraints();
		gbc_btnGeraetHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnGeraetHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetHinzu.gridx = 0;
		gbc_btnGeraetHinzu.gridy = 0;
		panel_1.add(btnGeraetHinzu, gbc_btnGeraetHinzu);

		JButton btnGeraetAendern = new JButton("Ger\u00E4t \u00E4ndern");
		btnGeraetAendern.setPreferredSize(new Dimension(300, 100));
		btnGeraetAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeraetAendern.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnGeraetAendern = new GridBagConstraints();
		gbc_btnGeraetAendern.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetAendern.insets = new Insets(0, 0, 5, 5);
		gbc_btnGeraetAendern.gridx = 1;
		gbc_btnGeraetAendern.gridy = 0;
		panel_1.add(btnGeraetAendern, gbc_btnGeraetAendern);

		JButton btnGeraetDeaktivieren = new JButton("Aktivieren/Deaktivieren");
		btnGeraetDeaktivieren.setPreferredSize(new Dimension(300, 100));
		btnGeraetDeaktivieren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeraetDeaktivieren.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnGeraetDeaktivieren = new GridBagConstraints();
		gbc_btnGeraetDeaktivieren.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetDeaktivieren.insets = new Insets(0, 0, 5, 0);
		gbc_btnGeraetDeaktivieren.gridx = 2;
		gbc_btnGeraetDeaktivieren.gridy = 0;
		panel_1.add(btnGeraetDeaktivieren, gbc_btnGeraetDeaktivieren);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 375));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		tm.addColumn("GeräteID");
		tm.addColumn("Name");
		tm.addColumn("Verkaufspreis");
		tm.addColumn("Anschaffungspreis");
		tm.addColumn("Status");
		tm.addColumn("Makel");
		tm.addColumn("Farbe");

		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);

		JButton btnModelle = new JButton("Modelle");
		btnModelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModelle.setBackground(new Color(255, 140, 0));
		btnModelle.setMinimumSize(new Dimension(150, 35));
		btnModelle.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnModelle = new GridBagConstraints();
		gbc_btnModelle.fill = GridBagConstraints.VERTICAL;
		gbc_btnModelle.insets = new Insets(0, 0, 0, 5);
		gbc_btnModelle.anchor = GridBagConstraints.WEST;
		gbc_btnModelle.gridx = 0;
		gbc_btnModelle.gridy = 7;
		panel_1.add(btnModelle, gbc_btnModelle);

		// Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraeteGUI(), MainFrame.getGeraeteVerwaltungGUI());
				textSuchen.setText("Suchen...");

			}
		});

		btnGeraetHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraeteGUI(), MainFrame.getGeraetAnlegenGUI());
				MainFrame.getGeraetAnlegenGUI().anfrage();
				textSuchen.setText("Suchen...");
			}
		});

		btnGeraetAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zeile = table.getSelectedRow();

				if (zeile < 0)
					JOptionPane.showMessageDialog(null, "Gerät auswählen!");
				else {
					werteAuslesen(zeile);
					werteUebergeben();
					MainFrame.getGeraetAendernGUI().anfrage();
					MainFrame.change(MainFrame.getSportgeraeteGUI(), MainFrame.getGeraetAendernGUI());
					textSuchen.setText("Suchen...");
				}
			}

			//Methode die Werte an die View GeraetAendernGUI übergibt
			private void werteUebergeben() {
				MainFrame.getGeraetAendernGUI().setModellID(modellID);
				MainFrame.getGeraetAendernGUI().setGeraeteID(geraeteID);
				MainFrame.getGeraetAendernGUI().setFarbe(farbe);
				MainFrame.getGeraetAendernGUI().setMakel(makel);
				MainFrame.getGeraetAendernGUI().setAnschaffungspreis(anschaffungspreis);
				MainFrame.getGeraetAendernGUI().setVerkaufspreis(verkaufspreis);
				MainFrame.getGeraetAendernGUI().setBaujahr(baujahr);
				MainFrame.getGeraetAendernGUI().setStandort(standortID);
			}
			
			//Methode, die Werte aus der Tabelle ausliest
			private void werteAuslesen(int zeile) {
				modellID = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 4)));
				geraeteID = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 0)));
				farbe = String.valueOf(table.getValueAt(zeile, 7));
				makel = String.valueOf(table.getValueAt(zeile, 1));
				anschaffungspreis = Double.parseDouble(String.valueOf(table.getValueAt(zeile, 9)));
				verkaufspreis = Double.parseDouble(String.valueOf(table.getValueAt(zeile, 2)));
				baujahr = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 8)));
				standortID = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 6)));
			}
		});

		btnGeraetDeaktivieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zeile = table.getSelectedRow();

				if (zeile < 0)
					JOptionPane.showMessageDialog(null, "Gerät auswählen!");
				else {
					int modellID = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 4)));
					int geraeteID = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 0)));
					String status = String.valueOf(table.getValueAt(zeile, 5));
					MainFrame.getGeraeteStatusGUI().setModellID(modellID);
					MainFrame.getGeraeteStatusGUI().setGeraeteID(geraeteID);
					MainFrame.getGeraeteStatusGUI().setStatus(status);
					MainFrame.getGeraeteStatusGUI().anfrage();
					MainFrame.change(MainFrame.getSportgeraeteGUI(), MainFrame.getGeraeteStatusGUI());
					textSuchen.setText("Suchen...");
				}
			}
		});

		btnModelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraeteGUI(), MainFrame.getGeraeteModellVerwaltungGUI());
				MainFrame.getGeraeteModellVerwaltungGUI().anfrage();
				textSuchen.setText("Suchen...");
			}
		});

		textSuchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textSuchen.setText("");
			}
		});

		textSuchen.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				talking = textSuchen.getText();
				modellNr = 123456789; // damit methode "fetchGeräte" nicht geändert werden muss
				anfrage();
				talking = "gesamt";
				modellNr = 0;
			}
		});

	}

	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());
	}

	public void anfrage() {
		model.anmelden(MainFrame.getBuchungGeraetSucheGUI());
		controller.fetchGeraete(talking, modellNr, kNr, geraetNr, 0);
		aktualisieren(model);
		model.abmelden(MainFrame.getBuchungGeraetSucheGUI());
	}

}
