package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.StandortStrg;
import com.model.DBConnectorSingleton;
import com.model.IStandortModel;

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
		
		setBounds(350,200,450,450);
		setIconImage(new ImageIcon(getClass().getResource("surfen.png")).getImage());
		
		getContentPane().setLayout(new CardLayout(0, 0));
		
		anmeldenPanel = new JPanel();
		anmeldenPanel.setForeground(Color.DARK_GRAY);
		anmeldenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		anmeldenPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(anmeldenPanel, "name_302209460105541");
		
		

		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.5, 0.0, 0.0, 0.4, 0.1, 0.1, 0.5, 0.25, Double.MIN_VALUE};
		anmeldenPanel.setLayout(gridBagLayout);
		
		JLabel lblWillkommenImSscenter = new JLabel("Willkommen im");
		lblWillkommenImSscenter.setForeground(Color.WHITE);
		lblWillkommenImSscenter.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblWillkommenImSscenter = new GridBagConstraints();
		gbc_lblWillkommenImSscenter.gridwidth = 6;
		gbc_lblWillkommenImSscenter.insets = new Insets(0, 0, 5, 0);
		gbc_lblWillkommenImSscenter.gridx = 0;
		gbc_lblWillkommenImSscenter.gridy = 1;
		anmeldenPanel.add(lblWillkommenImSscenter, gbc_lblWillkommenImSscenter);
		
		JLabel lblSurfUndSegelcenter = new JLabel("Surf- und Segelcenter");
		lblSurfUndSegelcenter.setForeground(Color.WHITE);
		lblSurfUndSegelcenter.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblSurfUndSegelcenter = new GridBagConstraints();
		gbc_lblSurfUndSegelcenter.gridwidth = 6;
		gbc_lblSurfUndSegelcenter.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfUndSegelcenter.gridx = 0;
		gbc_lblSurfUndSegelcenter.gridy = 2;
		anmeldenPanel.add(lblSurfUndSegelcenter, gbc_lblSurfUndSegelcenter);
		
		JLabel lblUser = new JLabel("Standort:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 4;
		anmeldenPanel.add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.gridwidth = 2;
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 2;
		gbc_txtUser.gridy = 4;
		anmeldenPanel.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 5;
		anmeldenPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 5;
		anmeldenPanel.add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		JButton regButtonChange = new JButton("Registrieren");
		regButtonChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		regButtonChange.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_regButtonChange = new GridBagConstraints();
		gbc_regButtonChange.anchor = GridBagConstraints.NORTH;
		gbc_regButtonChange.fill = GridBagConstraints.HORIZONTAL;
		gbc_regButtonChange.insets = new Insets(0, 0, 0, 5);
		gbc_regButtonChange.gridx = 2;
		gbc_regButtonChange.gridy = 6;
		anmeldenPanel.add(regButtonChange, gbc_regButtonChange);
		
		regButtonChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				changePanel2();
				
			}
		});
		
		JButton okButton = new JButton("Best\u00E4tigen");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		okButton.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.NORTH;
		gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 3;
		gbc_okButton.gridy = 6;
		anmeldenPanel.add(okButton, gbc_okButton);
		
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
		

		
		registrierenPanel = new JPanel();
		registrierenPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(registrierenPanel, "name_302221623575103");
		GridBagLayout gbl_registrierenPanel = new GridBagLayout();
		gbl_registrierenPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_registrierenPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_registrierenPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_registrierenPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		registrierenPanel.setLayout(gbl_registrierenPanel);
		
		JLabel lblWillkommenIm = new JLabel("Willkommen im");
		lblWillkommenIm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWillkommenIm.setForeground(Color.WHITE);
		lblWillkommenIm.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblWillkommenIm = new GridBagConstraints();
		gbc_lblWillkommenIm.insets = new Insets(0, 0, 5, 0);
		gbc_lblWillkommenIm.gridwidth = 6;
		gbc_lblWillkommenIm.gridx = 0;
		gbc_lblWillkommenIm.gridy = 1;
		registrierenPanel.add(lblWillkommenIm, gbc_lblWillkommenIm);
		
		JLabel lblSurfUndSegelcenter_1 = new JLabel("Surf- und Segelcenter");
		lblSurfUndSegelcenter_1.setForeground(Color.WHITE);
		lblSurfUndSegelcenter_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblSurfUndSegelcenter_1 = new GridBagConstraints();
		gbc_lblSurfUndSegelcenter_1.gridwidth = 6;
		gbc_lblSurfUndSegelcenter_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfUndSegelcenter_1.gridx = 0;
		gbc_lblSurfUndSegelcenter_1.gridy = 2;
		registrierenPanel.add(lblSurfUndSegelcenter_1, gbc_lblSurfUndSegelcenter_1);
		
		JLabel lblStandortname = new JLabel("StandortID:");
		lblStandortname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStandortname.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblStandortname = new GridBagConstraints();
		gbc_lblStandortname.anchor = GridBagConstraints.WEST;
		gbc_lblStandortname.fill = GridBagConstraints.VERTICAL;
		gbc_lblStandortname.insets = new Insets(0, 0, 5, 5);
		gbc_lblStandortname.gridx = 1;
		gbc_lblStandortname.gridy = 4;
		registrierenPanel.add(lblStandortname, gbc_lblStandortname);
		
		idFeld = new JTextField();
		idFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idFeld.setColumns(10);
		GridBagConstraints gbc_idFeld = new GridBagConstraints();
		gbc_idFeld.gridwidth = 2;
		gbc_idFeld.fill = GridBagConstraints.BOTH;
		gbc_idFeld.insets = new Insets(0, 0, 5, 5);
		gbc_idFeld.gridx = 2;
		gbc_idFeld.gridy = 4;
		registrierenPanel.add(idFeld, gbc_idFeld);
		
		JLabel label_5 = new JLabel("Standortname:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.fill = GridBagConstraints.VERTICAL;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 5;
		registrierenPanel.add(label_5, gbc_label_5);
		
		nameFeld = new JTextField();
		nameFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameFeld.setColumns(10);
		GridBagConstraints gbc_nameFeld = new GridBagConstraints();
		gbc_nameFeld.gridwidth = 2;
		gbc_nameFeld.fill = GridBagConstraints.BOTH;
		gbc_nameFeld.insets = new Insets(0, 0, 5, 5);
		gbc_nameFeld.gridx = 2;
		gbc_nameFeld.gridy = 5;
		registrierenPanel.add(nameFeld, gbc_nameFeld);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.WHITE);
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblPasswort.fill = GridBagConstraints.VERTICAL;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 6;
		registrierenPanel.add(lblPasswort, gbc_lblPasswort);
		
		pwFeld = new JPasswordField();
		pwFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_pwFeld = new GridBagConstraints();
		gbc_pwFeld.gridwidth = 2;
		gbc_pwFeld.fill = GridBagConstraints.BOTH;
		gbc_pwFeld.insets = new Insets(0, 0, 5, 5);
		gbc_pwFeld.gridx = 2;
		gbc_pwFeld.gridy = 6;
		registrierenPanel.add(pwFeld, gbc_pwFeld);
		
		JLabel lblTelefonnummer = new JLabel("Tel. Nr.:");
		lblTelefonnummer.setForeground(Color.WHITE);
		lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTelefonnummer = new GridBagConstraints();
		gbc_lblTelefonnummer.anchor = GridBagConstraints.WEST;
		gbc_lblTelefonnummer.fill = GridBagConstraints.VERTICAL;
		gbc_lblTelefonnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonnummer.gridx = 1;
		gbc_lblTelefonnummer.gridy = 7;
		registrierenPanel.add(lblTelefonnummer, gbc_lblTelefonnummer);
		
		telFeld = new JTextField();
		telFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telFeld.setColumns(10);
		GridBagConstraints gbc_telFeld = new GridBagConstraints();
		gbc_telFeld.gridwidth = 2;
		gbc_telFeld.fill = GridBagConstraints.BOTH;
		gbc_telFeld.insets = new Insets(0, 0, 5, 5);
		gbc_telFeld.gridx = 2;
		gbc_telFeld.gridy = 7;
		registrierenPanel.add(telFeld, gbc_telFeld);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setForeground(Color.WHITE);
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.anchor = GridBagConstraints.WEST;
		gbc_lblPlz.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 1;
		gbc_lblPlz.gridy = 8;
		registrierenPanel.add(lblPlz, gbc_lblPlz);
		
		plzFeld = new JTextField();
		plzFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		plzFeld.setColumns(10);
		GridBagConstraints gbc_plzFeld = new GridBagConstraints();
		gbc_plzFeld.gridwidth = 2;
		gbc_plzFeld.fill = GridBagConstraints.BOTH;
		gbc_plzFeld.insets = new Insets(0, 0, 5, 5);
		gbc_plzFeld.gridx = 2;
		gbc_plzFeld.gridy = 8;
		registrierenPanel.add(plzFeld, gbc_plzFeld);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setForeground(Color.WHITE);
		lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.anchor = GridBagConstraints.WEST;
		gbc_lblStrae.fill = GridBagConstraints.VERTICAL;
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 1;
		gbc_lblStrae.gridy = 10;
		registrierenPanel.add(lblStrae, gbc_lblStrae);
		
		strFeld = new JTextField();
		strFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		strFeld.setColumns(10);
		GridBagConstraints gbc_strFeld = new GridBagConstraints();
		gbc_strFeld.gridwidth = 2;
		gbc_strFeld.fill = GridBagConstraints.BOTH;
		gbc_strFeld.insets = new Insets(0, 0, 5, 5);
		gbc_strFeld.gridx = 2;
		gbc_strFeld.gridy = 10;
		registrierenPanel.add(strFeld, gbc_strFeld);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setForeground(Color.WHITE);
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.anchor = GridBagConstraints.WEST;
		gbc_lblOrt.fill = GridBagConstraints.VERTICAL;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 1;
		gbc_lblOrt.gridy = 9;
		registrierenPanel.add(lblOrt, gbc_lblOrt);
		
		ortFeld = new JTextField();
		ortFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ortFeld.setColumns(10);
		GridBagConstraints gbc_ortFeld = new GridBagConstraints();
		gbc_ortFeld.gridwidth = 2;
		gbc_ortFeld.fill = GridBagConstraints.BOTH;
		gbc_ortFeld.insets = new Insets(0, 0, 5, 5);
		gbc_ortFeld.gridx = 2;
		gbc_ortFeld.gridy = 9;
		registrierenPanel.add(ortFeld, gbc_ortFeld);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		lblHausnummer.setForeground(Color.WHITE);
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer.fill = GridBagConstraints.VERTICAL;
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 1;
		gbc_lblHausnummer.gridy = 11;
		registrierenPanel.add(lblHausnummer, gbc_lblHausnummer);
		
		hnrFeld = new JTextField();
		hnrFeld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hnrFeld.setColumns(10);
		GridBagConstraints gbc_hnrFeld = new GridBagConstraints();
		gbc_hnrFeld.gridwidth = 2;
		gbc_hnrFeld.fill = GridBagConstraints.BOTH;
		gbc_hnrFeld.insets = new Insets(0, 0, 5, 5);
		gbc_hnrFeld.gridx = 2;
		gbc_hnrFeld.gridy = 11;
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
		gbc_abbButton.insets = new Insets(0, 0, 0, 5);
		gbc_abbButton.fill = GridBagConstraints.BOTH;
		gbc_abbButton.gridx = 2;
		gbc_abbButton.gridy = 12;
		registrierenPanel.add(abbButton, gbc_abbButton);
		
		JButton regButton = new JButton("Registrieren");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					boolean umwandlung = true;
					umwandlung = checkInteger(umwandlung);
					
					
					if(idFeld.getText().equals("") || nameFeld.getText().equals("") || pwFeld.getPassword().equals("") || plzFeld.getText().equals("") || strFeld.getText().equals("") || ortFeld.getText().equals("") || hnrFeld.getText().equals("") || telFeld.getText().equals("") || umwandlung == false )
						JOptionPane.showMessageDialog(null, "Bitte die Felder überprüfen!");
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

			private boolean checkInteger(boolean umwandlung) {
				try {
					int plz = Integer.parseInt(plzFeld.getText());
					int stdID = Integer.parseInt(idFeld.getText());
				} catch (NumberFormatException e) {
					umwandlung = false;
					JOptionPane.showMessageDialog(null, "Sie haben falsche Werte für StandortID oder PLZ eingegeben!");
				}
				return umwandlung;
				
			}

			
		});
		regButton.setBackground(new Color(255, 140, 0));
		regButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_regButton = new GridBagConstraints();
		gbc_regButton.insets = new Insets(0, 0, 0, 5);
		gbc_regButton.fill = GridBagConstraints.BOTH;
		gbc_regButton.gridx = 3;
		gbc_regButton.gridy = 12;
		registrierenPanel.add(regButton, gbc_regButton);
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
