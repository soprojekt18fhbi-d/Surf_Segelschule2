package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datenbankmodels.DBConnectorSingleton;
import Datenbankmodels.IStandortModel;
import Steuerung.StandortStrg;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.CardLayout;

public class StandortGUI extends JFrame implements IStandortView { //Ben Kröncke
	private Icon logo;
	private boolean correctData;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JTextField idFeld;
	private JTextField nameFeld;
	private JPasswordField pwFeld;
	private JTextField telFeld;
	private JTextField plzFeld;
	private JTextField strFeld;
	private JTextField ortFeld;
	private JTextField hnrFeld;

	private JPanel anmeldenPanel;
	private JPanel registrierenPanel;
	private String talking;

	private IStandortModel model;
	private StandortStrg controller;
	private boolean success = false;

	private MainFrame mainframe;
	
	
	
	public void setMainFrame(MainFrame mf) {
		mainframe = mf;
	}

	/**
	 * Create the frame.
	 */
	public StandortGUI(IStandortModel models, StandortStrg controllers) {
		setResizable(false);
		
		model = models;
		controller = controllers;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		setIconImage(new ImageIcon(getClass().getResource("/GUI/surfen.png")).getImage());
		getContentPane().setLayout(new CardLayout(0, 0));
		
		anmeldenPanel = new JPanel();
		anmeldenPanel.setForeground(Color.DARK_GRAY);
		anmeldenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		anmeldenPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(anmeldenPanel, "name_302209460105541");
		GridBagLayout gbl_anmeldenPanel = new GridBagLayout();
		gbl_anmeldenPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_anmeldenPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_anmeldenPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 4.9E-324, Double.MIN_VALUE};
		gbl_anmeldenPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		anmeldenPanel.setLayout(gbl_anmeldenPanel);
		
		JLabel willkommen = new JLabel("Willkommen im Surf- & Segelcenter!");
		willkommen.setHorizontalAlignment(SwingConstants.CENTER);
		willkommen.setForeground(Color.WHITE);
		willkommen.setFont(new Font("Tahoma", Font.BOLD, 48));
		GridBagConstraints gbc_willkommen = new GridBagConstraints();
		gbc_willkommen.anchor = GridBagConstraints.NORTH;
		gbc_willkommen.gridwidth = 9;
		gbc_willkommen.insets = new Insets(0, 0, 5, 0);
		gbc_willkommen.gridx = 0;
		gbc_willkommen.gridy = 0;
		anmeldenPanel.add(willkommen, gbc_willkommen);
		
		JLabel label_3 = new JLabel((Icon) null);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridheight = 7;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 7;
		gbc_label_3.gridy = 1;
		anmeldenPanel.add(label_3, gbc_label_3);
		
		JLabel lblUser = new JLabel("Standort:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 28));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.fill = GridBagConstraints.VERTICAL;
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.gridwidth = 2;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 2;
		gbc_lblUser.gridy = 2;
		anmeldenPanel.add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtUser.setColumns(10);
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.fill = GridBagConstraints.BOTH;
		gbc_txtUser.gridwidth = 2;
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.gridx = 4;
		gbc_txtUser.gridy = 2;
		anmeldenPanel.add(txtUser, gbc_txtUser);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setMinimumSize(new Dimension(180, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 28));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.gridwidth = 2;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 4;
		anmeldenPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		anmeldenPanel.add(passwordField, gbc_passwordField);
		
		JButton regButtonChange = new JButton("Registrieren");
		regButtonChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				changePanel2();
				
			}
		});
		regButtonChange.setMinimumSize(new Dimension(200, 23));
		regButtonChange.setFont(new Font("Tahoma", Font.PLAIN, 28));
		regButtonChange.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_regButtonChange = new GridBagConstraints();
		gbc_regButtonChange.anchor = GridBagConstraints.EAST;
		gbc_regButtonChange.fill = GridBagConstraints.VERTICAL;
		gbc_regButtonChange.insets = new Insets(0, 0, 5, 5);
		gbc_regButtonChange.gridx = 4;
		gbc_regButtonChange.gridy = 5;
		anmeldenPanel.add(regButtonChange, gbc_regButtonChange);
		
		JButton okButton = new JButton("Best\u00E4tigen");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					talking = "login";
					
					String strPassword = new String(passwordField.getPassword());
					
					anmelden();
					
					controller.registriere(idFeld.getText(), txtUser.getText(), telFeld.getText(), talking, strPassword, plzFeld.getText(), strFeld.getText(), ortFeld.getText(), hnrFeld.getText());
					
					if(success == true)
					{
						
						mainframe.setVisible(true);
						dispose();
						
						
					}
					else if(success == false)
						JOptionPane.showMessageDialog(null, "Falsches Passwort oder falscher User!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					abmelden();
					success = false;
				}
				
			}
		});
		okButton.setMinimumSize(new Dimension(200, 35));
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		okButton.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.fill = GridBagConstraints.VERTICAL;
		gbc_okButton.anchor = GridBagConstraints.EAST;
		gbc_okButton.insets = new Insets(0, 0, 5, 5);
		gbc_okButton.gridx = 5;
		gbc_okButton.gridy = 5;
		anmeldenPanel.add(okButton, gbc_okButton);
		
		registrierenPanel = new JPanel();
		registrierenPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(registrierenPanel, "name_302221623575103");
		GridBagLayout gbl_registrierenPanel = new GridBagLayout();
		gbl_registrierenPanel.columnWidths = new int[]{363, 147, 170, 341, 0};
		gbl_registrierenPanel.rowHeights = new int[]{79, 30, 36, 39, 28, 1, 34, 30, 34, 28, 28, 37, 0};
		gbl_registrierenPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_registrierenPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		registrierenPanel.setLayout(gbl_registrierenPanel);
		
		JLabel label_4 = new JLabel("Willkommen im Surf- & Segelcenter!");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 48));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridwidth = 4;
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		registrierenPanel.add(label_4, gbc_label_4);
		
		JLabel lblStandortname = new JLabel("StandortID:");
		lblStandortname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStandortname.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblStandortname = new GridBagConstraints();
		gbc_lblStandortname.gridwidth = 2;
		gbc_lblStandortname.anchor = GridBagConstraints.EAST;
		gbc_lblStandortname.fill = GridBagConstraints.VERTICAL;
		gbc_lblStandortname.insets = new Insets(0, 0, 5, 5);
		gbc_lblStandortname.gridx = 0;
		gbc_lblStandortname.gridy = 2;
		registrierenPanel.add(lblStandortname, gbc_lblStandortname);
		
		idFeld = new JTextField();
		idFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idFeld.setColumns(10);
		GridBagConstraints gbc_idFeld = new GridBagConstraints();
		gbc_idFeld.fill = GridBagConstraints.BOTH;
		gbc_idFeld.insets = new Insets(0, 0, 5, 5);
		gbc_idFeld.gridx = 2;
		gbc_idFeld.gridy = 2;
		registrierenPanel.add(idFeld, gbc_idFeld);
		
		JLabel label_5 = new JLabel("Standortname:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.gridwidth = 2;
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.fill = GridBagConstraints.VERTICAL;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 3;
		registrierenPanel.add(label_5, gbc_label_5);
		
		nameFeld = new JTextField();
		nameFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameFeld.setColumns(10);
		GridBagConstraints gbc_nameFeld = new GridBagConstraints();
		gbc_nameFeld.fill = GridBagConstraints.BOTH;
		gbc_nameFeld.insets = new Insets(0, 0, 5, 5);
		gbc_nameFeld.gridx = 2;
		gbc_nameFeld.gridy = 3;
		registrierenPanel.add(nameFeld, gbc_nameFeld);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.WHITE);
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.gridwidth = 2;
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.fill = GridBagConstraints.VERTICAL;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 4;
		registrierenPanel.add(lblPasswort, gbc_lblPasswort);
		
		pwFeld = new JPasswordField();
		pwFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_pwFeld = new GridBagConstraints();
		gbc_pwFeld.fill = GridBagConstraints.BOTH;
		gbc_pwFeld.insets = new Insets(0, 0, 5, 5);
		gbc_pwFeld.gridx = 2;
		gbc_pwFeld.gridy = 4;
		registrierenPanel.add(pwFeld, gbc_pwFeld);
		
		JLabel lblTelefonnummer = new JLabel("Tel. Nr.:");
		lblTelefonnummer.setForeground(Color.WHITE);
		lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTelefonnummer = new GridBagConstraints();
		gbc_lblTelefonnummer.gridwidth = 2;
		gbc_lblTelefonnummer.anchor = GridBagConstraints.EAST;
		gbc_lblTelefonnummer.fill = GridBagConstraints.VERTICAL;
		gbc_lblTelefonnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonnummer.gridx = 0;
		gbc_lblTelefonnummer.gridy = 5;
		registrierenPanel.add(lblTelefonnummer, gbc_lblTelefonnummer);
		
		telFeld = new JTextField();
		telFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telFeld.setColumns(10);
		GridBagConstraints gbc_telFeld = new GridBagConstraints();
		gbc_telFeld.fill = GridBagConstraints.BOTH;
		gbc_telFeld.insets = new Insets(0, 0, 5, 5);
		gbc_telFeld.gridx = 2;
		gbc_telFeld.gridy = 5;
		registrierenPanel.add(telFeld, gbc_telFeld);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setForeground(Color.WHITE);
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.gridwidth = 2;
		gbc_lblPlz.anchor = GridBagConstraints.EAST;
		gbc_lblPlz.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 0;
		gbc_lblPlz.gridy = 6;
		registrierenPanel.add(lblPlz, gbc_lblPlz);
		
		plzFeld = new JTextField();
		plzFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		plzFeld.setColumns(10);
		GridBagConstraints gbc_plzFeld = new GridBagConstraints();
		gbc_plzFeld.fill = GridBagConstraints.BOTH;
		gbc_plzFeld.insets = new Insets(0, 0, 5, 5);
		gbc_plzFeld.gridx = 2;
		gbc_plzFeld.gridy = 6;
		registrierenPanel.add(plzFeld, gbc_plzFeld);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setForeground(Color.WHITE);
		lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.gridwidth = 2;
		gbc_lblStrae.anchor = GridBagConstraints.EAST;
		gbc_lblStrae.fill = GridBagConstraints.VERTICAL;
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 0;
		gbc_lblStrae.gridy = 7;
		registrierenPanel.add(lblStrae, gbc_lblStrae);
		
		strFeld = new JTextField();
		strFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		strFeld.setColumns(10);
		GridBagConstraints gbc_strFeld = new GridBagConstraints();
		gbc_strFeld.fill = GridBagConstraints.BOTH;
		gbc_strFeld.insets = new Insets(0, 0, 5, 5);
		gbc_strFeld.gridx = 2;
		gbc_strFeld.gridy = 7;
		registrierenPanel.add(strFeld, gbc_strFeld);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setForeground(Color.WHITE);
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.gridwidth = 2;
		gbc_lblOrt.anchor = GridBagConstraints.EAST;
		gbc_lblOrt.fill = GridBagConstraints.VERTICAL;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 0;
		gbc_lblOrt.gridy = 8;
		registrierenPanel.add(lblOrt, gbc_lblOrt);
		
		ortFeld = new JTextField();
		ortFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ortFeld.setColumns(10);
		GridBagConstraints gbc_ortFeld = new GridBagConstraints();
		gbc_ortFeld.fill = GridBagConstraints.BOTH;
		gbc_ortFeld.insets = new Insets(0, 0, 5, 5);
		gbc_ortFeld.gridx = 2;
		gbc_ortFeld.gridy = 8;
		registrierenPanel.add(ortFeld, gbc_ortFeld);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		lblHausnummer.setForeground(Color.WHITE);
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.gridwidth = 2;
		gbc_lblHausnummer.anchor = GridBagConstraints.EAST;
		gbc_lblHausnummer.fill = GridBagConstraints.VERTICAL;
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 0;
		gbc_lblHausnummer.gridy = 9;
		registrierenPanel.add(lblHausnummer, gbc_lblHausnummer);
		
		hnrFeld = new JTextField();
		hnrFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hnrFeld.setColumns(10);
		GridBagConstraints gbc_hnrFeld = new GridBagConstraints();
		gbc_hnrFeld.fill = GridBagConstraints.BOTH;
		gbc_hnrFeld.insets = new Insets(0, 0, 5, 5);
		gbc_hnrFeld.gridx = 2;
		gbc_hnrFeld.gridy = 9;
		registrierenPanel.add(hnrFeld, gbc_hnrFeld);
		
		JButton abbButton = new JButton("Abbrechen");
		abbButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel();
				
			}
		});
		abbButton.setBackground(new Color(255, 140, 0));
		abbButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_abbButton = new GridBagConstraints();
		gbc_abbButton.insets = new Insets(0, 0, 5, 5);
		gbc_abbButton.fill = GridBagConstraints.BOTH;
		gbc_abbButton.gridx = 1;
		gbc_abbButton.gridy = 10;
		registrierenPanel.add(abbButton, gbc_abbButton);
		
		JButton regButton = new JButton("Registrieren");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(idFeld.getText().equals("") || nameFeld.getText().equals("") || pwFeld.getPassword().equals("") || plzFeld.getText().equals("") || strFeld.getText().equals("") || ortFeld.getText().equals("") || hnrFeld.getText().equals("") || telFeld.getText().equals("") )
						JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!");
					else
					{
						talking = "register";
					
						int abfrage = JOptionPane.showConfirmDialog(null, "Standort wirklich hinzufügen?");
					
						if(abfrage == 0)
						{
							String strPassword = new String(pwFeld.getPassword());
					
							anmelden();
							controller.registriere(idFeld.getText(), nameFeld.getText(), telFeld.getText(), talking, strPassword , plzFeld.getText(), strFeld.getText(), ortFeld.getText(), hnrFeld.getText());
							abmelden();
							changePanel();
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}

			
		});
		regButton.setBackground(new Color(255, 140, 0));
		regButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_regButton = new GridBagConstraints();
		gbc_regButton.insets = new Insets(0, 0, 5, 5);
		gbc_regButton.fill = GridBagConstraints.BOTH;
		gbc_regButton.gridx = 2;
		gbc_regButton.gridy = 10;
		registrierenPanel.add(regButton, gbc_regButton);
		logo = new ImageIcon(getClass().getResource("/GUI/surfLogo.png"));
	}



	protected void anmelden() {

		model.anmelden(this);
		
		
	}

	private void abmelden() {
		
		model.abmelden(this);
	}


	@Override
	public void aktualisieren(IStandortModel model) {
		
		try {
			success = model.pruefen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void changePanel() {
		anmeldenPanel.setVisible(true);
		registrierenPanel.setVisible(false);
	}
	private void changePanel2() {
		anmeldenPanel.setVisible(false);
		registrierenPanel.setVisible(true);
	}

}
