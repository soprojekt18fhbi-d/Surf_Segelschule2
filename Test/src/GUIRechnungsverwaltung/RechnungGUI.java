/*
 * @author Ben S.
 */

package GUIRechnungsverwaltung;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import GUI.Hauptmenue;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;

public class RechnungGUI extends JFrame{

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						RechnungGUI frame = new RechnungGUI();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public RechnungGUI() {
			setTitle("Rechnungsdetails");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			JButton btnZurck = new JButton("Zur\u00FCck");
			btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(824, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			
			
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.CENTER);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			
			//Vertragesschlieﬂende
			//Line 0
			
			
			JLabel lblGetname = new JLabel("getName");
			lblGetname.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetname = new GridBagConstraints();
			gbc_lblGetname.anchor = GridBagConstraints.WEST;
			gbc_lblGetname.insets = new Insets(0, 0, 5, 5);
			gbc_lblGetname.gridx = 1;
			gbc_lblGetname.gridy = 0;
			panel_1.add(lblGetname, gbc_lblGetname);
			
			
			JLabel lblFirmenName = new JLabel("Surf- und Segelcenter");
			lblFirmenName.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblFirmenName = new GridBagConstraints();
			gbc_lblFirmenName.insets = new Insets(0, 0, 5, 0);
			gbc_lblFirmenName.anchor = GridBagConstraints.WEST;
			gbc_lblFirmenName.gridx = 3;
			gbc_lblFirmenName.gridy = 0;
			panel_1.add(lblFirmenName, gbc_lblFirmenName);
			
			
			//Line 1
			
			JLabel lblPlzOrt = new JLabel("getHeimatPLZ+Ort");
			lblPlzOrt.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblPlzOrt = new GridBagConstraints();
			gbc_lblPlzOrt.anchor = GridBagConstraints.WEST;
			gbc_lblPlzOrt.insets = new Insets(0, 0, 5, 5);
			gbc_lblPlzOrt.gridx = 1;
			gbc_lblPlzOrt.gridy = 1;
			panel_1.add(lblPlzOrt, gbc_lblPlzOrt);
			
			JLabel lblGetSee = new JLabel("Ostsee");
			lblGetSee.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetSee = new GridBagConstraints();
			gbc_lblGetSee.anchor = GridBagConstraints.WEST;
			gbc_lblGetSee.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetSee.gridx = 3;
			gbc_lblGetSee.gridy = 1;
			panel_1.add(lblGetSee, gbc_lblGetSee);
			
			//Line 2
			
			JLabel lblGetStrasseNummer = new JLabel("getHeimatStrasse+Nummer");
			lblGetStrasseNummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetStrasseNummer = new GridBagConstraints();
			gbc_lblGetStrasseNummer.anchor = GridBagConstraints.WEST;
			gbc_lblGetStrasseNummer.insets = new Insets(0, 0, 5, 5);
			gbc_lblGetStrasseNummer.gridx = 1;
			gbc_lblGetStrasseNummer.gridy = 2;
			panel_1.add(lblGetStrasseNummer, gbc_lblGetStrasseNummer);
			
			JLabel lblGetStandort = new JLabel("getStandort");
			lblGetStandort.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetStandort = new GridBagConstraints();
			gbc_lblGetStandort.anchor = GridBagConstraints.WEST;
			gbc_lblGetStandort.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetStandort.gridx = 3;
			gbc_lblGetStandort.gridy = 2;
			panel_1.add(lblGetStandort, gbc_lblGetStandort);
			
			
			//Buchungsdetails
			
			//Line 3
			
			JLabel lblGetRechnungsID = new JLabel("Rechnungsnummer: + getRechnungsID");
			lblGetRechnungsID.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetRechnungsID = new GridBagConstraints();
			gbc_lblGetRechnungsID.anchor = GridBagConstraints.WEST;
			gbc_lblGetRechnungsID.insets = new Insets(0, 0, 5, 5);
			gbc_lblGetRechnungsID.gridx = 1;
			gbc_lblGetRechnungsID.gridy = 3;
			panel_1.add(lblGetRechnungsID, gbc_lblGetRechnungsID);
			
			
			// Line 4
			
			JLabel lblArtikel = new JLabel("Artikel");
			lblArtikel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblArtikel = new GridBagConstraints();
			gbc_lblArtikel.anchor = GridBagConstraints.WEST;
			gbc_lblArtikel.insets = new Insets(0, 0, 5, 5);
			gbc_lblArtikel.gridx = 1;
			gbc_lblArtikel.gridy = 4;
			panel_1.add(lblArtikel, gbc_lblArtikel);
			


			JLabel lblBezeichnung = new JLabel("Bezeichnung");
			lblBezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
			gbc_lblBezeichnung.anchor = GridBagConstraints.WEST;
			gbc_lblBezeichnung.insets = new Insets(0, 0, 5, 5);
			gbc_lblBezeichnung.gridx = 2;
			gbc_lblBezeichnung.gridy = 4;
			panel_1.add(lblBezeichnung, gbc_lblBezeichnung);
			
			
			
			JLabel lblPreis = new JLabel("Preis");
			lblPreis.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblPreis = new GridBagConstraints();
			gbc_lblPreis.anchor = GridBagConstraints.WEST;
			gbc_lblPreis.insets = new Insets(0, 0, 5, 0);
			gbc_lblPreis.gridx = 3;
			gbc_lblPreis.gridy = 4;
			panel_1.add(lblPreis, gbc_lblPreis);
			
			
			
			//Line 5
			
			JLabel lblGetArtikelID = new JLabel("getArtikel");
			lblGetArtikelID.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetArtikelID = new GridBagConstraints();
			gbc_lblGetArtikelID.anchor = GridBagConstraints.WEST;
			gbc_lblGetArtikelID.insets = new Insets(0, 0, 5, 5);
			gbc_lblGetArtikelID.gridx = 1;
			gbc_lblGetArtikelID.gridy = 5;
			panel_1.add(lblGetArtikelID, gbc_lblGetArtikelID);
			


			JLabel lblGetBezeichnung = new JLabel("getBezeichnung");
			lblGetBezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetBezeichnung = new GridBagConstraints();
			gbc_lblGetBezeichnung.anchor = GridBagConstraints.WEST;
			gbc_lblGetBezeichnung.insets = new Insets(0, 0, 5, 5);
			gbc_lblGetBezeichnung.gridx = 2;
			gbc_lblGetBezeichnung.gridy = 5;
			panel_1.add(lblGetBezeichnung, gbc_lblGetBezeichnung);
			
			
			
			JLabel lblGetPreis = new JLabel("getPreis");
			lblGetPreis.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetPreis = new GridBagConstraints();
			gbc_lblGetPreis.anchor = GridBagConstraints.WEST;
			gbc_lblGetPreis.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetPreis.gridx = 3;
			gbc_lblGetPreis.gridy = 5;
			panel_1.add(lblGetPreis, gbc_lblGetPreis);
			
		/**
		 * Ab hier muss noch angepasst werden. Line 6 wird zur Zeit noch ohne ersichtlichen Grund ausgeblendet.
		 */
			
			
			//Line 6
		


			
			JLabel lblBetrag = new JLabel("getBezeichnung");
			lblBetrag.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblBetrag = new GridBagConstraints();
			gbc_lblBetrag.anchor = GridBagConstraints.WEST;
			gbc_lblBetrag.insets = new Insets(0, 0, 5, 5);
			gbc_lblBetrag.gridx = 2;
			gbc_lblBetrag.gridy = 6;
			panel_1.add(lblBetrag, gbc_lblBetrag);
			
			
			
			JLabel lblGetBetrag = new JLabel("getPreis");
			lblGetBetrag.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetBetrag = new GridBagConstraints();
			gbc_lblGetBetrag.anchor = GridBagConstraints.WEST;
			gbc_lblGetBetrag.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetBetrag.gridx = 3;
			gbc_lblGetBetrag.gridy = 6;
			panel_1.add(lblGetBetrag, gbc_lblGetBetrag);
			
			
			//Line 8
			
			JLabel lblAusleihid = new JLabel("AusleihID:");
			lblAusleihid.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblAusleihid = new GridBagConstraints();
			gbc_lblAusleihid.anchor = GridBagConstraints.WEST;
			gbc_lblAusleihid.insets = new Insets(0, 0, 5, 5);
			gbc_lblAusleihid.gridx = 1;
			gbc_lblAusleihid.gridy = 8;
			panel_1.add(lblAusleihid, gbc_lblAusleihid);
			
			
			JLabel lblGetausleihid = new JLabel("getAusleihID");
			lblGetausleihid.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetausleihid = new GridBagConstraints();
			gbc_lblGetausleihid.anchor = GridBagConstraints.WEST;
			gbc_lblGetausleihid.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetausleihid.gridx = 3;
			gbc_lblGetausleihid.gridy = 8;
			panel_1.add(lblGetausleihid, gbc_lblGetausleihid);
			
			//Line 9
			
			JLabel lblAusleihbeginn = new JLabel("Ausleih-Beginn:");
			lblAusleihbeginn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblAusleihbeginn = new GridBagConstraints();
			gbc_lblAusleihbeginn.anchor = GridBagConstraints.WEST;
			gbc_lblAusleihbeginn.insets = new Insets(0, 0, 5, 5);
			gbc_lblAusleihbeginn.gridx = 1;
			gbc_lblAusleihbeginn.gridy = 9;
			panel_1.add(lblAusleihbeginn, gbc_lblAusleihbeginn);
			
			
			JLabel lblGetbeginn = new JLabel("getBeginn");
			lblGetbeginn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetbeginn = new GridBagConstraints();
			gbc_lblGetbeginn.anchor = GridBagConstraints.WEST;
			gbc_lblGetbeginn.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetbeginn.gridx = 3;
			gbc_lblGetbeginn.gridy = 9;
			panel_1.add(lblGetbeginn, gbc_lblGetbeginn);
			
			//Line 10

			
			JLabel lblAusleihende = new JLabel("Ausleih-Ende:");
			lblAusleihende.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblAusleihende = new GridBagConstraints();
			gbc_lblAusleihende.anchor = GridBagConstraints.WEST;
			gbc_lblAusleihende.insets = new Insets(0, 0, 5, 5);
			gbc_lblAusleihende.gridx = 1;
			gbc_lblAusleihende.gridy = 10;
			panel_1.add(lblAusleihende, gbc_lblAusleihende);
			
			
			JLabel lblGetende = new JLabel("getEnde");
			lblGetende.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblGetende = new GridBagConstraints();
			gbc_lblGetende.anchor = GridBagConstraints.WEST;
			gbc_lblGetende.insets = new Insets(0, 0, 5, 0);
			gbc_lblGetende.gridx = 3;
			gbc_lblGetende.gridy = 10;
			panel_1.add(lblGetende, gbc_lblGetende);

			

			
			
			//South-Panel
			JPanel panel_2 = new JPanel();
			contentPane.add(panel_2, BorderLayout.SOUTH);
			
			
			//Buttons South
			JButton btnDrucken = new JButton("Drucken");
			btnDrucken.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JButton btnRechnSenden = new JButton("Rechnung Senden");
			btnRechnSenden.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JButton btnFertig = new JButton("Fertig");
			btnFertig.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap(646, Short.MAX_VALUE)
						.addComponent(btnDrucken, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnRechnSenden, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnFertig, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDrucken, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRechnSenden, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFertig, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel_2.setLayout(gl_panel_2);
			
			
			
			//Funktionen der Button
			btnZurck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RechungsverwaltungGUI frame = new RechungsverwaltungGUI();
				}
			});
			
			btnDrucken.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					BuchungsverwaltungGUI frame = new BuchungsverwaltungGUI();
					dispose();
				}
			});
			
			btnRechnSenden.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Die Ausleihe wurde erfasst", "Verleih-Best‰tigung", JOptionPane.PLAIN_MESSAGE);
					Hauptmenue frame = new Hauptmenue();
					dispose();
				}
			});
			
			btnFertig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Die Ausleihe wurde erfasst", "Verleih-Best‰tigung", JOptionPane.PLAIN_MESSAGE);
					Hauptmenue frame = new Hauptmenue();
					dispose();
				}
			});
			
			
			setVisible(true);
		}



	
}
