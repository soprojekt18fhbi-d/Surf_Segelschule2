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



	/**
	 * Create the frame.
	 */
	public StandortGUI(IStandortModel models, StandortStrg controllers) {
		
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
						MainFrame frame = new MainFrame();
						frame.setVisible(true);
						dispose();
						
						frame.addWindowListener(new WindowAdapter() {
				            @Override
				            public void windowClosing(WindowEvent e) {
				                try {
									DBConnectorSingleton.closeCon();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				                System.exit(0);
				            }
				        });
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
		
		JLabel label_4 = new JLabel("Willkommen im Surf- & Segelcenter!");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 48));
		
		JLabel lblStandortname = new JLabel("StandortID:");
		lblStandortname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStandortname.setForeground(new Color(255, 255, 255));
		
		idFeld = new JTextField();
		idFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idFeld.setColumns(10);
		
		JLabel label_5 = new JLabel("Standortname:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		nameFeld = new JTextField();
		nameFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameFeld.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.WHITE);
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		pwFeld = new JPasswordField();
		pwFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTelefonnummer = new JLabel("Tel. Nr.:");
		lblTelefonnummer.setForeground(Color.WHITE);
		lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		telFeld = new JTextField();
		telFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telFeld.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setForeground(Color.WHITE);
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		plzFeld = new JTextField();
		plzFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		plzFeld.setColumns(10);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setForeground(Color.WHITE);
		lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		strFeld = new JTextField();
		strFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		strFeld.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setForeground(Color.WHITE);
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		ortFeld = new JTextField();
		ortFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ortFeld.setColumns(10);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		lblHausnummer.setForeground(Color.WHITE);
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		hnrFeld = new JTextField();
		hnrFeld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hnrFeld.setColumns(10);
		
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
		
		JButton abbButton = new JButton("Abbrechen");
		abbButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel();
				
			}
		});
		abbButton.setBackground(new Color(255, 140, 0));
		abbButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_registrierenPanel = new GroupLayout(registrierenPanel);
		gl_registrierenPanel.setHorizontalGroup(
			gl_registrierenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registrierenPanel.createSequentialGroup()
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 979, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_registrierenPanel.createSequentialGroup()
							.addGap(270)
							.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(nameFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblStandortname, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pwFeld))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblTelefonnummer, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(telFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblPlz, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(plzFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblStrae, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(strFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblOrt, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(ortFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(lblHausnummer, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(hnrFeld, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_registrierenPanel.createSequentialGroup()
									.addComponent(abbButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(regButton)))))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_registrierenPanel.setVerticalGroup(
			gl_registrierenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registrierenPanel.createSequentialGroup()
					.addComponent(label_4)
					.addGap(45)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(idFeld, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(lblStandortname, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameFeld, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pwFeld, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(lblPasswort, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTelefonnummer, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(telFeld, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlz, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(plzFeld, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrae, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(strFeld, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOrt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ortFeld, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblHausnummer, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(hnrFeld, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registrierenPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_registrierenPanel.createSequentialGroup()
							.addComponent(regButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(73, Short.MAX_VALUE))
						.addGroup(gl_registrierenPanel.createSequentialGroup()
							.addComponent(abbButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		registrierenPanel.setLayout(gl_registrierenPanel);
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
