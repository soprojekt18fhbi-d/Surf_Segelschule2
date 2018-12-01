package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import GUI.MainFrame;

public class VerkaufFormular extends JPanel {

	/**
	 * Create the panel.
	 */
	public VerkaufFormular() {
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblKunde = new JLabel("Kunde:");
		lblKunde.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblKunde = new GridBagConstraints();
		gbc_lblKunde.insets = new Insets(0, 0, 5, 5);
		gbc_lblKunde.gridx = 0;
		gbc_lblKunde.gridy = 0;
		panel_1.add(lblKunde, gbc_lblKunde);
		
		JLabel lblGetname = new JLabel("getName");
		lblGetname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetname = new GridBagConstraints();
		gbc_lblGetname.anchor = GridBagConstraints.WEST;
		gbc_lblGetname.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetname.gridx = 1;
		gbc_lblGetname.gridy = 0;
		panel_1.add(lblGetname, gbc_lblGetname);
		
		JLabel lblArtikel = new JLabel("Artikel:");
		lblArtikel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblArtikel = new GridBagConstraints();
		gbc_lblArtikel.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel.gridx = 2;
		gbc_lblArtikel.gridy = 0;
		panel_1.add(lblArtikel, gbc_lblArtikel);
		
		JLabel lblGetbezeichnung = new JLabel("getBezeichnung");
		lblGetbezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetbezeichnung = new GridBagConstraints();
		gbc_lblGetbezeichnung.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetbezeichnung.anchor = GridBagConstraints.WEST;
		gbc_lblGetbezeichnung.gridx = 3;
		gbc_lblGetbezeichnung.gridy = 0;
		panel_1.add(lblGetbezeichnung, gbc_lblGetbezeichnung);
		
		JLabel lblGetadressart = new JLabel("getAdressArt");
		lblGetadressart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetadressart = new GridBagConstraints();
		gbc_lblGetadressart.anchor = GridBagConstraints.WEST;
		gbc_lblGetadressart.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetadressart.gridx = 1;
		gbc_lblGetadressart.gridy = 1;
		panel_1.add(lblGetadressart, gbc_lblGetadressart);
		
		JLabel lblGetartikelnummer = new JLabel("getArtikelNummer");
		lblGetartikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetartikelnummer = new GridBagConstraints();
		gbc_lblGetartikelnummer.anchor = GridBagConstraints.WEST;
		gbc_lblGetartikelnummer.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetartikelnummer.gridx = 3;
		gbc_lblGetartikelnummer.gridy = 1;
		panel_1.add(lblGetartikelnummer, gbc_lblGetartikelnummer);
		
		JLabel lblGetplzort = new JLabel("getPLZ+Ort");
		lblGetplzort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetplzort = new GridBagConstraints();
		gbc_lblGetplzort.anchor = GridBagConstraints.WEST;
		gbc_lblGetplzort.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetplzort.gridx = 1;
		gbc_lblGetplzort.gridy = 2;
		panel_1.add(lblGetplzort, gbc_lblGetplzort);
		
		JLabel lblGetfarbe = new JLabel("getFarbe");
		lblGetfarbe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetfarbe = new GridBagConstraints();
		gbc_lblGetfarbe.anchor = GridBagConstraints.WEST;
		gbc_lblGetfarbe.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetfarbe.gridx = 3;
		gbc_lblGetfarbe.gridy = 2;
		panel_1.add(lblGetfarbe, gbc_lblGetfarbe);
		
		JLabel lblGetstrassenummer = new JLabel("getStrasse+Nummer");
		lblGetstrassenummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetstrassenummer = new GridBagConstraints();
		gbc_lblGetstrassenummer.anchor = GridBagConstraints.WEST;
		gbc_lblGetstrassenummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetstrassenummer.gridx = 1;
		gbc_lblGetstrassenummer.gridy = 3;
		panel_1.add(lblGetstrassenummer, gbc_lblGetstrassenummer);
		
		JLabel lblGetbaujahr = new JLabel("getBaujahr");
		lblGetbaujahr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetbaujahr = new GridBagConstraints();
		gbc_lblGetbaujahr.anchor = GridBagConstraints.WEST;
		gbc_lblGetbaujahr.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetbaujahr.gridx = 3;
		gbc_lblGetbaujahr.gridy = 3;
		panel_1.add(lblGetbaujahr, gbc_lblGetbaujahr);
		
		JLabel lblGetgeburtsdatum = new JLabel("getGeburtsdatum");
		lblGetgeburtsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetgeburtsdatum = new GridBagConstraints();
		gbc_lblGetgeburtsdatum.anchor = GridBagConstraints.WEST;
		gbc_lblGetgeburtsdatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetgeburtsdatum.gridx = 1;
		gbc_lblGetgeburtsdatum.gridy = 4;
		panel_1.add(lblGetgeburtsdatum, gbc_lblGetgeburtsdatum);
		
		JLabel lblGetmakel = new JLabel("getMakel");
		lblGetmakel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetmakel = new GridBagConstraints();
		gbc_lblGetmakel.anchor = GridBagConstraints.WEST;
		gbc_lblGetmakel.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetmakel.gridx = 3;
		gbc_lblGetmakel.gridy = 4;
		panel_1.add(lblGetmakel, gbc_lblGetmakel);
		
		JLabel lblGetfhrerschein = new JLabel("getF\u00FChrerschein");
		lblGetfhrerschein.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetfhrerschein = new GridBagConstraints();
		gbc_lblGetfhrerschein.anchor = GridBagConstraints.WEST;
		gbc_lblGetfhrerschein.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetfhrerschein.gridx = 1;
		gbc_lblGetfhrerschein.gridy = 5;
		panel_1.add(lblGetfhrerschein, gbc_lblGetfhrerschein);
		
		JLabel lblGetbentigterfhrerschein = new JLabel("getBen\u00F6tigterF\u00FChrerschein");
		lblGetbentigterfhrerschein.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetbentigterfhrerschein = new GridBagConstraints();
		gbc_lblGetbentigterfhrerschein.anchor = GridBagConstraints.WEST;
		gbc_lblGetbentigterfhrerschein.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetbentigterfhrerschein.gridx = 3;
		gbc_lblGetbentigterfhrerschein.gridy = 5;
		panel_1.add(lblGetbentigterfhrerschein, gbc_lblGetbentigterfhrerschein);
		
		JLabel lblGetemail = new JLabel("getEmail");
		lblGetemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblGetemail = new GridBagConstraints();
		gbc_lblGetemail.anchor = GridBagConstraints.WEST;
		gbc_lblGetemail.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetemail.gridx = 1;
		gbc_lblGetemail.gridy = 6;
		panel_1.add(lblGetemail, gbc_lblGetemail);
		
		JLabel lblGetpreis = new JLabel("getPreis");
		lblGetpreis.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblGetpreis = new GridBagConstraints();
		gbc_lblGetpreis.anchor = GridBagConstraints.WEST;
		gbc_lblGetpreis.gridx = 3;
		gbc_lblGetpreis.gridy = 7;
		panel_1.add(lblGetpreis, gbc_lblGetpreis);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBesttigen = new JButton("Best\u00E4tigen");
		btnBesttigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBesttigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBesttigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getVerleihFormular(), MainFrame.getGerätAuswahlVerkauf());
			}
		});
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getVerkaufFormular(), MainFrame.getBuchungsverwaltung());
			}
		});
		
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Der Verkauf wurde erfasst", "Verkauf-Bestätigung", JOptionPane.PLAIN_MESSAGE);
				MainFrame.change(MainFrame.getVerkaufFormular(), MainFrame.getHauptmenue());
			}
		});

	}
}
