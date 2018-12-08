/*
 * @author BenKröncke
 */

package GUI;

import java.awt.BorderLayout;
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
import Datenbankmodels.KundeSucheModel;
import Steuerung.KundeSucheStrg;
import TESTPACKAGE.TestController;
import TESTPACKAGE.TestanbindungMVCBEISPIEL;
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

public class KundeAendern extends JPanel implements IObjektView{
	

	
	private JTextField txtKnr;
	private JTextField txtNachname;
	private JTextField txtVorname;
	
	
	private KundeSucheModel model;
	private KundeSucheStrg controller;
	private JList list = new JList();
	private JTextField txtEmail;
	private JTable table;
	private JTextField variableKnr;
	private String selectedMode = "waiting";
	private String talking;
	private String surf = "N";
	private String motor = "N";
	private String segel = "N";
	private String heimat = "N";

	/**
	 * Create the panel.
	 */
	public KundeAendern(KundeSucheModel smodel, KundeSucheStrg scontroller) {
		this.model = smodel;
		this.controller = scontroller;
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		
		JButton btnZurueck = new JButton("Zurück");
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
					.addComponent(btnHauptmen))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHauptmen))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		JPanel panel2 = new JPanel();
		add(panel2, BorderLayout.CENTER);
		
		txtKnr = new JTextField();
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
		txtKnr.setBounds(124, 13, 425, 20);
		txtKnr.setPreferredSize(new Dimension(6, 25));
		txtKnr.setColumns(10);
		
		txtNachname = new JTextField();
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
		txtNachname.setBounds(124, 45, 425, 20);
		txtNachname.setPreferredSize(new Dimension(6, 25));
		txtNachname.setColumns(10);
		
		txtVorname = new JTextField();
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
		txtVorname.setBounds(124, 77, 425, 20);
		txtVorname.setPreferredSize(new Dimension(30, 25));
		txtVorname.setColumns(10);
		
		txtEmail = new JTextField();
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
		txtEmail.setBounds(124, 109, 425, 20);
		txtEmail.setColumns(10);
		
		JComboBox adresseArtBox = new JComboBox();
		adresseArtBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (adresseArtBox.getSelectedItem().equals("Heimatadresse"))
					heimat = "Heimatadresse";
				else if (adresseArtBox.getSelectedItem().equals("Urlaubsadresse"))
					heimat = "Urlaubsadresse";
			}
		});
		adresseArtBox.setBounds(405, 147, 246, 25);
		adresseArtBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adresseArtBox.setMaximumSize(new Dimension(100, 35));
		adresseArtBox.setPreferredSize(new Dimension(80, 35));
		adresseArtBox.addItem("Heimatadresse");
		adresseArtBox.addItem("Urlaubsadresse");
		
		JButton btnLeeren = new JButton("Leeren");
		btnLeeren.setBounds(335, 192, 153, 35);
		btnLeeren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(172, 192, 153, 35);
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuchen.setPreferredSize(new Dimension(120, 35));
		
		JButton btnndern = new JButton("Speichern");
		btnndern.setBounds(498, 192, 160, 35);
		btnndern.addActionListener(new ActionListener() {
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
		btnndern.setPreferredSize(new Dimension(120, 35));
		btnndern.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
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
		chckbxSurfschein.setBounds(77, 150, 93, 23);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
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
		
		chckbxMotorbootschein.setBounds(172, 150, 121, 23);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		chckbxSegelschein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSegelschein.isSelected())
				{
					segel = "J";
				} else {
					segel = "N";
				}
				//System.out.println("" + segel + " " + surf + " " + motor);
			}
		});
		chckbxSegelschein.setBounds(295, 150, 105, 23);
		
		JButton btnDeaktivieren = new JButton("Deaktivieren");
		btnDeaktivieren.setBounds(10, 192, 153, 35);
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
		
		btnDeaktivieren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeaktivieren.setMinimumSize(new Dimension(200, 35));
		btnDeaktivieren.setMaximumSize(new Dimension(150, 35));
		btnDeaktivieren.setPreferredSize(new Dimension(200, 35));
		panel2.setLayout(null);
		panel2.add(chckbxSurfschein);
		panel2.add(chckbxMotorbootschein);
		panel2.add(chckbxSegelschein);
		panel2.add(txtVorname);
		panel2.add(txtNachname);
		panel2.add(txtKnr);
		panel2.add(txtEmail);
		panel2.add(btnDeaktivieren);
		panel2.add(btnSuchen);
		panel2.add(btnLeeren);
		panel2.add(adresseArtBox);
		panel2.add(btnndern);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 237, 648, 291);
		panel2.add(scrollPane);
		
		table = new JTable();
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
		scrollPane.setViewportView(table);
		
		JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.addItem("Wähle");
		comboBox_1.addItem("Kunde");
		comboBox_1.addItem("Adresse");
		
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
		
	
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(10, 13, 104, 52);
		panel2.add(comboBox_1);
		
		variableKnr = new JTextField();
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
		variableKnr.setHorizontalAlignment(SwingConstants.CENTER);
		variableKnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		variableKnr.setBounds(10, 77, 104, 36);
		panel2.add(variableKnr);
		variableKnr.setColumns(10);
		
		

		//Funktionen der Button
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendern(), MainFrame.getKundenverwaltung());
			}
		});

		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendern(), MainFrame.getHauptmenue());
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
		

	}
	
	private void anfrage() {
		
		model.anmelden(MainFrame.getKundeAendern());
		controller.fetchObjekte(txtKnr.getText(), txtNachname.getText(), txtVorname.getText(), txtEmail.getText(), selectedMode, variableKnr.getText(), talking, surf, segel, motor, heimat );
		model.abmelden(MainFrame.getKundeAendern());
	}

	@Override
	public void aktualisieren(IObjektModel model) {
		// TODO Auto-generated method stub
		table.setModel(model.getTableModel());
		
	}
}
