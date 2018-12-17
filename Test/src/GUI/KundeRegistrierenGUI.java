// @author Darnel

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datenbankmodels.IModel;
import Datenbankmodels.IModelSuche;
import Datenbankmodels.KundeRegistrierenModel;
import Domaenklassen.Adresse;
import Steuerung.KundeAnlegenSteuerung;


import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class KundeRegistrierenGUI extends JPanel implements IView{
	private JTextField txtNname;
	private JTextField txtVname;
	private JTextField txtPlzH;
	private JTextField txtOrtH;
	private JTextField txtStrasseH;
	private JTextField txtHnrH;
	private JTextField txtPlzU;
	private JTextField txtOrtU;
	private JTextField txtStrasseU;
	private JTextField txtHnrU;
	private JTextField emailTextField;
	
	KundeRegistrierenModel model;
	KundeAnlegenSteuerung controller;
	

	/**
	 * Create the panel.
	 */
	public KundeRegistrierenGUI(KundeRegistrierenModel smodel, KundeAnlegenSteuerung scontroller) {
		this.model = smodel;
		this.controller = scontroller;
		model.anmelden(this);
		
		setLayout(new BorderLayout(0, 0));
		setSize(1000,600);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 700, Short.MAX_VALUE)
					.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblKundendatenEingeben = new JLabel("Kundendaten eingeben:");
		lblKundendatenEingeben.setMinimumSize(new Dimension(100, 14));
		lblKundendatenEingeben.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblKundendatenEingeben = new GridBagConstraints();
		gbc_lblKundendatenEingeben.gridheight = 2;
		gbc_lblKundendatenEingeben.gridwidth = 2;
		gbc_lblKundendatenEingeben.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblKundendatenEingeben.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundendatenEingeben.gridx = 2;
		gbc_lblKundendatenEingeben.gridy = 1;
		panel_1.add(lblKundendatenEingeben, gbc_lblKundendatenEingeben);
		
		JLabel lblPersoenlicheAngaben = new JLabel("Persönliche Angaben:");
		lblPersoenlicheAngaben.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblPersoenlicheAngaben = new GridBagConstraints();
		gbc_lblPersoenlicheAngaben.anchor = GridBagConstraints.WEST;
		gbc_lblPersoenlicheAngaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersoenlicheAngaben.gridx = 2;
		gbc_lblPersoenlicheAngaben.gridy = 3;
		panel_1.add(lblPersoenlicheAngaben, gbc_lblPersoenlicheAngaben);
		
		JLabel lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.gridx = 2;
		gbc_lblNachname.gridy = 4;
		panel_1.add(lblNachname, gbc_lblNachname);
		
		txtNname = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 4;
		panel_1.add(txtNname, gbc_textField);
		txtNname.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.WEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 2;
		gbc_lblVorname.gridy = 5;
		panel_1.add(lblVorname, gbc_lblVorname);
		
		txtVname = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		panel_1.add(txtVname, gbc_textField_1);
		txtVname.setColumns(10);
		
		JLabel lblHeimatadresse = new JLabel("Heimatadresse:");
		lblHeimatadresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblHeimatadresse = new GridBagConstraints();
		gbc_lblHeimatadresse.anchor = GridBagConstraints.WEST;
		gbc_lblHeimatadresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeimatadresse.gridx = 2;
		gbc_lblHeimatadresse.gridy = 8;
		panel_1.add(lblHeimatadresse, gbc_lblHeimatadresse);
		
		JLabel lblPLZ = new JLabel("PLZ");
		GridBagConstraints gbc_lblPLZ = new GridBagConstraints();
		gbc_lblPLZ.insets = new Insets(0, 0, 5, 5);
		gbc_lblPLZ.anchor = GridBagConstraints.WEST;
		gbc_lblPLZ.gridx = 2;
		gbc_lblPLZ.gridy = 9;
		panel_1.add(lblPLZ, gbc_lblPLZ);
		
		txtPlzH = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 9;
		panel_1.add(txtPlzH, gbc_textField_3);
		txtPlzH.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.anchor = GridBagConstraints.WEST;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 2;
		gbc_lblOrt.gridy = 10;
		panel_1.add(lblOrt, gbc_lblOrt);
		
		txtOrtH = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 10;
		panel_1.add(txtOrtH, gbc_textField_4);
		txtOrtH.setColumns(10);
		
		JLabel lblStrasse = new JLabel("Straße");
		GridBagConstraints gbc_lblStrasse = new GridBagConstraints();
		gbc_lblStrasse.anchor = GridBagConstraints.WEST;
		gbc_lblStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse.gridx = 2;
		gbc_lblStrasse.gridy = 11;
		panel_1.add(lblStrasse, gbc_lblStrasse);
		
		txtStrasseH = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 11;
		panel_1.add(txtStrasseH, gbc_textField_5);
		txtStrasseH.setColumns(10);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 2;
		gbc_lblHausnummer.gridy = 12;
		panel_1.add(lblHausnummer, gbc_lblHausnummer);
		
		txtHnrH = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 12;
		panel_1.add(txtHnrH, gbc_textField_6);
		txtHnrH.setColumns(10);
		
		JLabel lblUrlaubsadresse = new JLabel("Urlaubsadresse:");
		lblUrlaubsadresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblUrlaubsadresse = new GridBagConstraints();
		gbc_lblUrlaubsadresse.anchor = GridBagConstraints.WEST;
		gbc_lblUrlaubsadresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlaubsadresse.gridx = 2;
		gbc_lblUrlaubsadresse.gridy = 13;
		panel_1.add(lblUrlaubsadresse, gbc_lblUrlaubsadresse);
		
		JLabel lblPLZ2 = new JLabel("PLZ");
		GridBagConstraints gbc_lblPLZ2 = new GridBagConstraints();
		gbc_lblPLZ2.anchor = GridBagConstraints.WEST;
		gbc_lblPLZ2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPLZ2.gridx = 2;
		gbc_lblPLZ2.gridy = 14;
		panel_1.add(lblPLZ2, gbc_lblPLZ2);
		
		txtPlzU = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 14;
		panel_1.add(txtPlzU, gbc_textField_7);
		txtPlzU.setColumns(10);
		
		JLabel lblOrt2 = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt2 = new GridBagConstraints();
		gbc_lblOrt2.anchor = GridBagConstraints.WEST;
		gbc_lblOrt2.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt2.gridx = 2;
		gbc_lblOrt2.gridy = 15;
		panel_1.add(lblOrt2, gbc_lblOrt2);
		
		txtOrtU = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 15;
		panel_1.add(txtOrtU, gbc_textField_8);
		txtOrtU.setColumns(10);
		
		JLabel lblStrasse2 = new JLabel("Straße");
		GridBagConstraints gbc_lblStrasse2 = new GridBagConstraints();
		gbc_lblStrasse2.anchor = GridBagConstraints.WEST;
		gbc_lblStrasse2.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse2.gridx = 2;
		gbc_lblStrasse2.gridy = 16;
		panel_1.add(lblStrasse2, gbc_lblStrasse2);
		
		txtStrasseU = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 16;
		panel_1.add(txtStrasseU, gbc_textField_9);
		txtStrasseU.setColumns(10);
		
		JLabel lblHausnummer2 = new JLabel("Hausnummer");
		GridBagConstraints gbc_lblHausnummer2 = new GridBagConstraints();
		gbc_lblHausnummer2.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer2.gridx = 2;
		gbc_lblHausnummer2.gridy = 17;
		panel_1.add(lblHausnummer2, gbc_lblHausnummer2);
		
		txtHnrU = new JTextField();
		GridBagConstraints gbc_hnrTextField = new GridBagConstraints();
		gbc_hnrTextField.insets = new Insets(0, 0, 5, 5);
		gbc_hnrTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_hnrTextField.gridx = 3;
		gbc_hnrTextField.gridy = 17;
		panel_1.add(txtHnrU, gbc_hnrTextField);
		txtHnrU.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 6;
		panel_1.add(lblEmail, gbc_lblEmail);
		
		emailTextField = new JTextField();
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 3;
		gbc_emailTextField.gridy = 6;
		panel_1.add(emailTextField, gbc_emailTextField);
		emailTextField.setColumns(10);
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.anchor = GridBagConstraints.EAST;
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSurfschein.gridx = 1;
		gbc_chckbxSurfschein.gridy = 18;
		panel_1.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.anchor = GridBagConstraints.EAST;
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSegelschein.gridx = 2;
		gbc_chckbxSegelschein.gridy = 18;
		panel_1.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxMotorbootschein.gridwidth = 3;
		gbc_chckbxMotorbootschein.gridx = 3;
		gbc_chckbxMotorbootschein.gridy = 18;
		panel_1.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
		

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnLeeren = new JButton("Leeren");
		btnLeeren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnLeeren, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnHinzufgen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(323))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLeeren, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHinzufgen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		//Funktionen der Button
		
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.change(MainFrame.getKundeRegistrieren(), MainFrame.getKundenverwaltung());
			}
		});
		
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeRegistrieren(), MainFrame.getHauptmenue());
			}
		});	
		
		btnLeeren.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNname.setText("");
				txtVname.setText("");
				emailTextField.setText("");
				txtPlzH.setText("");
				txtOrtH.setText("");
				txtStrasseH.setText("");
				txtHnrH.setText("");
				txtPlzU.setText("");
				txtOrtU.setText("");
				txtStrasseU.setText("");
				txtHnrU.setText("");
				chckbxSurfschein.setSelected(false);
				chckbxSegelschein.setSelected(false);
				chckbxMotorbootschein.setSelected(false);
			}
		});

		
		btnHinzufgen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				
				String email;
				String nachname;
				String vorname;
				Boolean surfschein;
				Boolean segelschein;
				Boolean motorbootschein;
				
				int plz;
				String ort;
				String strasse;
				String hausnummer;
				String art;
				
				int plz2;
				String ort2;
				String strasse2;
				String hausnummer2;
				String art2;
				
				try {
					
					
					//KundeAnlegenSteuerung.AdresseAnlegen(strasse, hausnummer, ort, plz, "" );
					
					/**
					int plz2 = Integer.parseInt(textField_7.getText());
					String ort2 = textField_8.getText();
					String strasse2 = textField_9.getText();
					String hausnummer2 = textField_10.getText();
					**/

					email = emailTextField.getText();		
					nachname = txtNname.getText();
					vorname = txtVname.getText();
					surfschein = chckbxSurfschein.isSelected();
					segelschein = chckbxSegelschein.isSelected();
					motorbootschein = chckbxMotorbootschein.isSelected();
					controller.KundeAnlegen(nachname, vorname, email, surfschein, segelschein, motorbootschein);
					
					
					plz = Integer.parseInt(txtPlzH.getText());
					ort = txtOrtH.getText();
					strasse = txtStrasseH.getText();
					hausnummer = txtHnrH.getText();
					art = "Heimadresse";
					controller.AdresseAnlegen(strasse, hausnummer, ort, plz, art);
					
					plz2 = Integer.parseInt(txtPlzH.getText());
					ort2 = txtOrtH.getText();
					strasse2 = txtStrasseH.getText();
					hausnummer2 = txtHnrH.getText();
					art2 = "Urlaubsadresse";
					controller.AdresseAnlegen(strasse2, hausnummer2, ort2, plz2, art2);
					
					/**
					 * Achtung, hier muss noch besseres exeption handling umgesetzt werden, DK
					 */
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				MainFrame.change(MainFrame.getKundeRegistrieren(), MainFrame.getHauptmenue());	
				}
			});
		}


		@Override
		public void aktualisieren(IModel model) {
		// TODO Auto-generated method stub
			JFrame frame = new JFrame("Kunde angelegt");
			JOptionPane.showMessageDialog(null, "Der Kunde wurde angelegt!");
		}


		@Override
		public void aktualisierenSuche(IModelSuche model) {
		// TODO Auto-generated method stub
		
		}

	
}


