/*
 * @author BenKröncke
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IModel;
import Datenbankmodels.IModelSuche;
import Datenbankmodels.IObjektModel;
import Steuerung.KundeSucheStrg;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class KundeAendernGUI extends JPanel implements IObjektView{
	private IObjektModel model;
	private KundeSucheStrg controller;
	
	private JTextField variableKnr;
	private JTextField txtKnr;
	private JTextField txtNachname;
	private JTextField txtVorname;
	private JTextField txtEmail;
	private JTable table;
	private String selectedMode = "waiting";
	private String talking;
	private String surf = "N";
	private String motor = "N";
	private String segel = "N";
	private String heimat = "N";

	/**
	 * Create the panel.
	 */
	public KundeAendernGUI(IObjektModel smodel, KundeSucheStrg scontroller) {
		this.model = smodel;
		this.controller = scontroller;
		
		setSize(980,580);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurueck.setBackground(new Color(255, 140, 0));
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHauptmen.setBackground(new Color(255, 140, 0));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 828, Short.MAX_VALUE)
					.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridheight = 2;
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 0;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		comboBox_1.addItem("Wähle");
		comboBox_1.addItem("Kunde");
		comboBox_1.addItem("Adresse");
		
		txtKnr = new JTextField();
		GridBagConstraints gbc_txtKnr = new GridBagConstraints();
		gbc_txtKnr.gridwidth = 5;
		gbc_txtKnr.insets = new Insets(0, 0, 5, 5);
		gbc_txtKnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKnr.gridx = 3;
		gbc_txtKnr.gridy = 0;
		panel_1.add(txtKnr, gbc_txtKnr);
		txtKnr.setColumns(10);
		
		txtNachname = new JTextField();
		GridBagConstraints gbc_txtNachname = new GridBagConstraints();
		gbc_txtNachname.gridwidth = 5;
		gbc_txtNachname.insets = new Insets(0, 0, 5, 5);
		gbc_txtNachname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNachname.gridx = 3;
		gbc_txtNachname.gridy = 1;
		panel_1.add(txtNachname, gbc_txtNachname);
		txtNachname.setColumns(10);
		
		variableKnr = new JTextField();
		GridBagConstraints gbc_variableKnr = new GridBagConstraints();
		gbc_variableKnr.gridheight = 2;
		gbc_variableKnr.gridwidth = 3;
		gbc_variableKnr.insets = new Insets(0, 0, 5, 5);
		gbc_variableKnr.fill = GridBagConstraints.BOTH;
		gbc_variableKnr.gridx = 0;
		gbc_variableKnr.gridy = 2;
		panel_1.add(variableKnr, gbc_variableKnr);
		variableKnr.setColumns(10);
		
		txtVorname = new JTextField();
		GridBagConstraints gbc_txtVorname = new GridBagConstraints();
		gbc_txtVorname.gridwidth = 5;
		gbc_txtVorname.insets = new Insets(0, 0, 5, 5);
		gbc_txtVorname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVorname.gridx = 3;
		gbc_txtVorname.gridy = 2;
		panel_1.add(txtVorname, gbc_txtVorname);
		txtVorname.setColumns(10);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 3;
		panel_1.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
		chckbxSurfschein.setBackground(Color.DARK_GRAY);
		chckbxSurfschein.setForeground(Color.WHITE);
		chckbxSurfschein.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.gridwidth = 2;
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSurfschein.gridx = 0;
		gbc_chckbxSurfschein.gridy = 4;
		panel_1.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		chckbxMotorbootschein.setForeground(Color.WHITE);
		chckbxMotorbootschein.setBackground(Color.DARK_GRAY);
		chckbxMotorbootschein.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.gridwidth = 2;
		gbc_chckbxMotorbootschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMotorbootschein.gridx = 2;
		gbc_chckbxMotorbootschein.gridy = 4;
		panel_1.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		chckbxSegelschein.setForeground(Color.WHITE);
		chckbxSegelschein.setBackground(Color.DARK_GRAY);
		chckbxSegelschein.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.gridwidth = 2;
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSegelschein.gridx = 4;
		gbc_chckbxSegelschein.gridy = 4;
		panel_1.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		JComboBox adresseArtBox = new JComboBox();
		adresseArtBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adresseArtBox.addItem("Heimatadresse");
		adresseArtBox.addItem("Urlaubsadresse");
		GridBagConstraints gbc_adresseArtBox = new GridBagConstraints();
		gbc_adresseArtBox.gridwidth = 2;
		gbc_adresseArtBox.insets = new Insets(0, 0, 5, 5);
		gbc_adresseArtBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_adresseArtBox.gridx = 6;
		gbc_adresseArtBox.gridy = 4;
		panel_1.add(adresseArtBox, gbc_adresseArtBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 14;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		panel_1.add(panel_3, gbc_panel_3);
		
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnDeaktivieren = new JButton("Deaktivieren");
		btnDeaktivieren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeaktivieren.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnDeaktivieren = new GridBagConstraints();
		gbc_btnDeaktivieren.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeaktivieren.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeaktivieren.gridx = 0;
		gbc_btnDeaktivieren.gridy = 0;
		panel_3.add(btnDeaktivieren, gbc_btnDeaktivieren);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuchen.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuchen.gridx = 1;
		gbc_btnSuchen.gridy = 0;
		panel_3.add(btnSuchen, gbc_btnSuchen);
		
		JButton btnLeeren = new JButton("Leeren");
		btnLeeren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLeeren.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnLeeren = new GridBagConstraints();
		gbc_btnLeeren.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLeeren.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeeren.gridx = 2;
		gbc_btnLeeren.gridy = 0;
		panel_3.add(btnLeeren, gbc_btnLeeren);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSpeichern.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 0);
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.gridx = 3;
		gbc_btnSpeichern.gridy = 0;
		panel_3.add(btnSpeichern, gbc_btnSpeichern);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//Funktionen der Button
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendernGUI(), MainFrame.getKundenverwaltungGUI());
			}
		});

		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendernGUI(), MainFrame.getHauptmenueGUI());
			}
		});
		
		btnLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKnr.setText("");
				txtNachname.setText("");
				txtVorname.setText("");
				txtEmail.setText("");
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(selectedMode == "waiting")
						JOptionPane.showMessageDialog(null, "Bitte Suche spezifizieren!");
					else if(selectedMode != "waiting")
					{
						talking = "boss";
						anfrage();
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		
		txtKnr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					talking = "knrplz";
					anfrage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		txtNachname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					talking = "nachnameort";
					anfrage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		txtVorname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					talking = "vornamestrasse";
					anfrage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					talking = "emailhnr";
					anfrage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		adresseArtBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (adresseArtBox.getSelectedItem().equals("Heimatadresse"))
					heimat = "Heimatadresse";
				else if (adresseArtBox.getSelectedItem().equals("Urlaubsadresse"))
					heimat = "Urlaubsadresse";
			}
		});
		
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(selectedMode.equals("Kunde"))
					{
						talking = "kundespeichern";
						anfrage();
					}	
					else if(selectedMode.equals("Adresse"))
					{
						talking = "adressespeichern";
						anfrage();
					}

					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		chckbxSurfschein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxSurfschein.isSelected())
				{
					surf = "J";
				} else {
					surf = "N";
				}
			}
		});
		
		chckbxMotorbootschein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(chckbxMotorbootschein.isSelected())
					{
						motor = "J";
					} else {
						motor = "N";
					}
				}
				
			});
		
		chckbxSegelschein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSegelschein.isSelected())
				{
					segel = "J";
				} else {
					segel = "N";
				}
			}
		});
		
		btnDeaktivieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(selectedMode.equals("waiting") || txtKnr.equals("") || variableKnr.equals("") || txtKnr.equals("Kundennummer...") || txtKnr.equals("PLZ..."))
						JOptionPane.showMessageDialog(null, "Das wird nicht funktionierten!");
					else if(selectedMode.equals("Kunde"))
					{
						talking = "deaktivierenkunde";
						anfrage();
					}
					else if(selectedMode.equals("Adresse"))
					{
						talking = "deaktivierenadresse";
						anfrage();
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					talking = "table";
					int row = table.getSelectedRow();
					if(selectedMode.equals("Kunde"))
					{
						
						String segel = table.getModel().getValueAt(row, 5).toString();
						String surf = table.getModel().getValueAt(row, 7).toString();
						String motor = table.getModel().getValueAt(row, 6).toString();
					
							
						System.out.println(segel + " " + surf + " " + motor);
						
						txtVorname.setText(table.getModel().getValueAt(row, 1).toString());
						txtKnr.setText(table.getModel().getValueAt(row, 0).toString());
						txtEmail.setText(table.getModel().getValueAt(row, 3).toString());
						txtNachname.setText(table.getModel().getValueAt(row, 2).toString());
						
						if(segel.equals("J"))
						{
							chckbxSegelschein.setSelected(true);
							segel = "J";
						}
						else if(segel.equals("N"))
						{
							chckbxSegelschein.setSelected(false);
							segel = "N";
						}
						if(motor.equals("J"))
						{
							chckbxMotorbootschein.setSelected(true);
							motor = "J";
						}
						else if (motor.equals("N"))
						{
							chckbxMotorbootschein.setSelected(false);
							motor = "N";
						}
						if(surf.equals("J"))
						{
							chckbxSurfschein.setSelected(true);
							surf = "J";
						}
						else if (surf.equals("N"))
						{
							chckbxSurfschein.setSelected(false);
							surf = "N";
						}
					}
					else if ( selectedMode.equals("Adresse"))
					{
						txtVorname.setText(table.getModel().getValueAt(row, 2).toString());
						txtKnr.setText(table.getModel().getValueAt(row, 1).toString());
						txtEmail.setText(table.getModel().getValueAt(row, 5).toString());
						txtNachname.setText(table.getModel().getValueAt(row, 3).toString());
						variableKnr.setText(table.getModel().getValueAt(row, 6).toString());
						
						if(table.getModel().getValueAt(row, 4).toString().equals("Heimatadresse"))
						{
							adresseArtBox.setSelectedIndex(0);
							heimat = "Heimatadresse";
						}
						else {
							adresseArtBox.setSelectedIndex(1);
							heimat = "Urlaubsadresse";
						}
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_1.getSelectedItem().equals("Kunde"));
				{
					txtKnr.setText("Kundennummer...");
					txtNachname.setText("Nachname...");
					txtVorname.setText("Vorname...");
					txtEmail.setText("E-Mail...");
					variableKnr.setText("");
					selectedMode = "Kunde";
				}
				if (comboBox_1.getSelectedItem().equals("Adresse"))
				{
					txtKnr.setText("PLZ...");
					txtNachname.setText("Ort...");
					txtVorname.setText("Strasse...");
					txtEmail.setText("Hausnummer...");
					variableKnr.setText("Kundennummer...");
					selectedMode = "Adresse";
				}
			System.out.println("Folgender Modus gewaehlt: " + selectedMode);
			}
		});
		
		variableKnr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					talking = "variableKnr";
					anfrage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
	}
	private void anfrage() {
		
		model.anmelden(MainFrame.getKundeAendernGUI());
		controller.fetchObjekte(txtKnr.getText(), txtNachname.getText(), txtVorname.getText(), txtEmail.getText(), selectedMode, variableKnr.getText(), talking, surf, segel, motor, heimat );
		model.abmelden(MainFrame.getKundeAendernGUI());
	}

	@Override
	public void aktualisieren(IObjektModel model) {
		// TODO Auto-generated method stub
		table.setModel(model.getTableModel());
		
	}
}
	
