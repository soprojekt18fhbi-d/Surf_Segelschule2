package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;

public class KundeRegistrierenGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	

	/**
	 * Create the frame.
	 */
	public KundeRegistrierenGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 50, 15, 15));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnZurueck = new JButton("Zurück");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnHauptmenue = new JButton("Hauptmenü");
		btnHauptmenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();	
			MainFrame.change(MainFrame.getKundenverwaltung(), MainFrame.getHauptmenue());
			}
		});	
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
					.addComponent(btnHauptmenue, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHauptmenue, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnLeeren = new JButton("  Leeren  ");
		panel_1.add(btnLeeren);
		btnLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
			}
		});
		
		
		
		
	
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblKundendatenEingeben = new JLabel("Kundendaten eingeben:");
		lblKundendatenEingeben.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblKundendatenEingeben = new GridBagConstraints();
		gbc_lblKundendatenEingeben.anchor = GridBagConstraints.WEST;
		gbc_lblKundendatenEingeben.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundendatenEingeben.gridx = 2;
		gbc_lblKundendatenEingeben.gridy = 2;
		panel_2.add(lblKundendatenEingeben, gbc_lblKundendatenEingeben);
		
		JLabel lblPersoenlicheAngaben = new JLabel("Persönliche Angaben:");
		lblPersoenlicheAngaben.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblPersoenlicheAngaben = new GridBagConstraints();
		gbc_lblPersoenlicheAngaben.anchor = GridBagConstraints.WEST;
		gbc_lblPersoenlicheAngaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersoenlicheAngaben.gridx = 2;
		gbc_lblPersoenlicheAngaben.gridy = 3;
		panel_2.add(lblPersoenlicheAngaben, gbc_lblPersoenlicheAngaben);
		
		JLabel lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.gridx = 2;
		gbc_lblNachname.gridy = 4;
		panel_2.add(lblNachname, gbc_lblNachname);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 4;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.WEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 2;
		gbc_lblVorname.gridy = 5;
		panel_2.add(lblVorname, gbc_lblVorname);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		GridBagConstraints gbc_lblGeburtsdatum = new GridBagConstraints();
		gbc_lblGeburtsdatum.anchor = GridBagConstraints.WEST;
		gbc_lblGeburtsdatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeburtsdatum.gridx = 2;
		gbc_lblGeburtsdatum.gridy = 6;
		panel_2.add(lblGeburtsdatum, gbc_lblGeburtsdatum);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 6;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHeimatadresse = new JLabel("Heimatadresse:");
		lblHeimatadresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblHeimatadresse = new GridBagConstraints();
		gbc_lblHeimatadresse.anchor = GridBagConstraints.WEST;
		gbc_lblHeimatadresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeimatadresse.gridx = 2;
		gbc_lblHeimatadresse.gridy = 7;
		panel_2.add(lblHeimatadresse, gbc_lblHeimatadresse);
		
		JLabel lblPLZ = new JLabel("PLZ");
		GridBagConstraints gbc_lblPLZ = new GridBagConstraints();
		gbc_lblPLZ.insets = new Insets(0, 0, 5, 5);
		gbc_lblPLZ.anchor = GridBagConstraints.WEST;
		gbc_lblPLZ.gridx = 2;
		gbc_lblPLZ.gridy = 8;
		panel_2.add(lblPLZ, gbc_lblPLZ);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 8;
		panel_2.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.anchor = GridBagConstraints.WEST;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 2;
		gbc_lblOrt.gridy = 9;
		panel_2.add(lblOrt, gbc_lblOrt);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 9;
		panel_2.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblStrasse = new JLabel("Straße");
		GridBagConstraints gbc_lblStrasse = new GridBagConstraints();
		gbc_lblStrasse.anchor = GridBagConstraints.WEST;
		gbc_lblStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse.gridx = 2;
		gbc_lblStrasse.gridy = 10;
		panel_2.add(lblStrasse, gbc_lblStrasse);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 10;
		panel_2.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 2;
		gbc_lblHausnummer.gridy = 11;
		panel_2.add(lblHausnummer, gbc_lblHausnummer);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 11;
		panel_2.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblUrlaubsadresse = new JLabel("Urlaubsadresse:");
		lblUrlaubsadresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblUrlaubsadresse = new GridBagConstraints();
		gbc_lblUrlaubsadresse.anchor = GridBagConstraints.WEST;
		gbc_lblUrlaubsadresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlaubsadresse.gridx = 2;
		gbc_lblUrlaubsadresse.gridy = 12;
		panel_2.add(lblUrlaubsadresse, gbc_lblUrlaubsadresse);
		
		JLabel lblPLZ2 = new JLabel("PLZ");
		GridBagConstraints gbc_lblPLZ2 = new GridBagConstraints();
		gbc_lblPLZ2.anchor = GridBagConstraints.WEST;
		gbc_lblPLZ2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPLZ2.gridx = 2;
		gbc_lblPLZ2.gridy = 13;
		panel_2.add(lblPLZ2, gbc_lblPLZ2);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 13;
		panel_2.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblOrt2 = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt2 = new GridBagConstraints();
		gbc_lblOrt2.anchor = GridBagConstraints.WEST;
		gbc_lblOrt2.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt2.gridx = 2;
		gbc_lblOrt2.gridy = 14;
		panel_2.add(lblOrt2, gbc_lblOrt2);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 14;
		panel_2.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblStrasse2 = new JLabel("Straße");
		GridBagConstraints gbc_lblStrasse2 = new GridBagConstraints();
		gbc_lblStrasse2.anchor = GridBagConstraints.WEST;
		gbc_lblStrasse2.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse2.gridx = 2;
		gbc_lblStrasse2.gridy = 15;
		panel_2.add(lblStrasse2, gbc_lblStrasse2);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 15;
		panel_2.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblHausnummer2 = new JLabel("Hausnummer");
		GridBagConstraints gbc_lblHausnummer2 = new GridBagConstraints();
		gbc_lblHausnummer2.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer2.gridx = 2;
		gbc_lblHausnummer2.gridy = 16;
		panel_2.add(lblHausnummer2, gbc_lblHausnummer2);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 3;
		gbc_textField_10.gridy = 16;
		panel_2.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 17;
		panel_2.add(lblEmail, gbc_lblEmail);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 3;
		gbc_textField_11.gridy = 17;
		panel_2.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSurfschein.gridx = 1;
		gbc_chckbxSurfschein.gridy = 18;
		panel_2.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSegelschein.gridx = 2;
		gbc_chckbxSegelschein.gridy = 18;
		panel_2.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.gridx = 3;
		gbc_chckbxMotorbootschein.gridy = 18;
		panel_2.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		panel_1.add(btnHinzufuegen);
		btnHinzufuegen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				
			
				int plz = Integer.parseInt(textField_3.getText());
				String ort = textField_4.getText();
				String strasse = textField_5.getText();
				String hausnummer = textField_6.getText();
				Adresse heimadresse = new Adresse(strasse, hausnummer, ort, plz, "" );
				//KundeAnlegenSteuerung.AdresseAnlegen(strasse, hausnummer, ort, plz, "" );
				
				
				int plz2 = Integer.parseInt(textField_7.getText());
				String ort2 = textField_8.getText();
				String strasse2 = textField_9.getText();
				String hausnummer2 = textField_10.getText();
				String email = textField_10.getText();
				Adresse urlaubsadresse = new Adresse(strasse2, hausnummer2, ort2, plz2, email);
				//KundeAnlegenSteuerung.AdresseAnlegen(strasse2, hausnummer2, ort2, plz2, email);
						
				String nachname = textField.getText();
				String vorname = textField_1.getText();
				int geburtsdatum = Integer.parseInt(textField_2.getText());
				Boolean surfschein = chckbxSurfschein.isSelected();
				Boolean segelschein = chckbxSegelschein.isSelected();;
				Boolean motorbootschein = chckbxMotorbootschein.isSelected();;
				KundeAnlegenSteuerung.KundeAnlegen(nachname, vorname, heimadresse, urlaubsadresse, surfschein, segelschein, motorbootschein, geburtsdatum);
				
				
				dispose();	
				MainFrame.change(MainFrame.getKundenverwaltung(), MainFrame.getHauptmenue());	
			}
		});
	}
}
