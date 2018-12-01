package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import GUI.MainFrame;

import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Reklamation extends JPanel {

	/**
	 * Create the panel.
	 */
	public Reklamation() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0,};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblAusleihdaten = new JLabel("Ausleih-Daten:");
		lblAusleihdaten.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblAusleihdaten = new GridBagConstraints();
		gbc_lblAusleihdaten.insets = new Insets(0, 0, 5, 5);
		gbc_lblAusleihdaten.gridx = 0;
		gbc_lblAusleihdaten.gridy = 0;
		panel_1.add(lblAusleihdaten, gbc_lblAusleihdaten);
		
		JLabel lblAusleihid = new JLabel("AusleihID:");
		lblAusleihid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAusleihid = new GridBagConstraints();
		gbc_lblAusleihid.anchor = GridBagConstraints.WEST;
		gbc_lblAusleihid.insets = new Insets(0, 0, 5, 5);
		gbc_lblAusleihid.gridx = 1;
		gbc_lblAusleihid.gridy = 0;
		panel_1.add(lblAusleihid, gbc_lblAusleihid);
		
		JLabel lblGetausleihid = new JLabel("getAusleihID");
		lblGetausleihid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetausleihid = new GridBagConstraints();
		gbc_lblGetausleihid.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGetausleihid.gridwidth = 3;
		gbc_lblGetausleihid.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetausleihid.gridx = 2;
		gbc_lblGetausleihid.gridy = 0;
		panel_1.add(lblGetausleihid, gbc_lblGetausleihid);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
		gbc_lblBezeichnung.anchor = GridBagConstraints.WEST;
		gbc_lblBezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBezeichnung.gridx = 1;
		gbc_lblBezeichnung.gridy = 1;
		panel_1.add(lblBezeichnung, gbc_lblBezeichnung);
		
		JLabel lblGetbezeichnung = new JLabel("getBezeichnung");
		lblGetbezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetbezeichnung = new GridBagConstraints();
		gbc_lblGetbezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGetbezeichnung.gridwidth = 3;
		gbc_lblGetbezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetbezeichnung.gridx = 2;
		gbc_lblGetbezeichnung.gridy = 1;
		panel_1.add(lblGetbezeichnung, gbc_lblGetbezeichnung);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer:");
		lblArtikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblArtikelnummer = new GridBagConstraints();
		gbc_lblArtikelnummer.anchor = GridBagConstraints.WEST;
		gbc_lblArtikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikelnummer.gridx = 1;
		gbc_lblArtikelnummer.gridy = 2;
		panel_1.add(lblArtikelnummer, gbc_lblArtikelnummer);
		
		JLabel lblGetartikelnummer = new JLabel("getArtikelnummer");
		lblGetartikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetartikelnummer = new GridBagConstraints();
		gbc_lblGetartikelnummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGetartikelnummer.gridwidth = 3;
		gbc_lblGetartikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetartikelnummer.gridx = 2;
		gbc_lblGetartikelnummer.gridy = 2;
		panel_1.add(lblGetartikelnummer, gbc_lblGetartikelnummer);
		
		JLabel lblKundenid = new JLabel("KundenID:");
		lblKundenid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblKundenid = new GridBagConstraints();
		gbc_lblKundenid.anchor = GridBagConstraints.WEST;
		gbc_lblKundenid.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundenid.gridx = 1;
		gbc_lblKundenid.gridy = 3;
		panel_1.add(lblKundenid, gbc_lblKundenid);
		
		JLabel lblGetkundenid = new JLabel("getKundenID");
		lblGetkundenid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetkundenid = new GridBagConstraints();
		gbc_lblGetkundenid.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGetkundenid.gridwidth = 3;
		gbc_lblGetkundenid.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetkundenid.gridx = 2;
		gbc_lblGetkundenid.gridy = 3;
		panel_1.add(lblGetkundenid, gbc_lblGetkundenid);
		
		JLabel lblVerliehenSeit = new JLabel("Verliehen seit:");
		lblVerliehenSeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblVerliehenSeit = new GridBagConstraints();
		gbc_lblVerliehenSeit.anchor = GridBagConstraints.WEST;
		gbc_lblVerliehenSeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblVerliehenSeit.gridx = 1;
		gbc_lblVerliehenSeit.gridy = 4;
		panel_1.add(lblVerliehenSeit, gbc_lblVerliehenSeit);
		
		JLabel lblGetanfangsdatum = new JLabel("getAnfangsDatum");
		lblGetanfangsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetanfangsdatum = new GridBagConstraints();
		gbc_lblGetanfangsdatum.anchor = GridBagConstraints.WEST;
		gbc_lblGetanfangsdatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetanfangsdatum.gridx = 2;
		gbc_lblGetanfangsdatum.gridy = 4;
		panel_1.add(lblGetanfangsdatum, gbc_lblGetanfangsdatum);
		
		JLabel lblBis = new JLabel("             bis:");
		lblBis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBis = new GridBagConstraints();
		gbc_lblBis.anchor = GridBagConstraints.WEST;
		gbc_lblBis.insets = new Insets(0, 0, 5, 5);
		gbc_lblBis.gridx = 1;
		gbc_lblBis.gridy = 5;
		panel_1.add(lblBis, gbc_lblBis);
		
		JLabel lblGetenddatum = new JLabel("getEndDatum");
		lblGetenddatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetenddatum = new GridBagConstraints();
		gbc_lblGetenddatum.anchor = GridBagConstraints.WEST;
		gbc_lblGetenddatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetenddatum.gridx = 2;
		gbc_lblGetenddatum.gridy = 5;
		panel_1.add(lblGetenddatum, gbc_lblGetenddatum);
		
		JLabel lblGrundbemerkung = new JLabel("Grund/Bemerkung:");
		lblGrundbemerkung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGrundbemerkung = new GridBagConstraints();
		gbc_lblGrundbemerkung.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblGrundbemerkung.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrundbemerkung.gridx = 1;
		gbc_lblGrundbemerkung.gridy = 6;
		panel_1.add(lblGrundbemerkung, gbc_lblGrundbemerkung);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 120));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 6;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnReklamieren = new JButton("Reklamieren");
		btnReklamieren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnReklamieren, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnReklamieren, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getReklamation(), MainFrame.getAktiveAusleihen());				
			}
		});
		btnReklamieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getReklamation(), MainFrame.getStatusSetzen());				
			}
		});
	}
}
