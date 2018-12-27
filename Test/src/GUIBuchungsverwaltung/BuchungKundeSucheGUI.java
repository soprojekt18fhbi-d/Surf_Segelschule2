package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import Steuerung.BuchungKundeSucheStrg;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import Datenbankmodels.IObjektModel;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import GUI.MainFrame;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class BuchungKundeSucheGUI extends JPanel implements IObjektView {
	private JTextField txtSearchbar;
	private JTable table;
	private JTextField txtKnr;
	private IObjektModel model;
	private BuchungKundeSucheStrg controller;
	private String talking;
	

	/**
	 * Create the panel.
	 */
	/*
	 * @author M. Schmidt / Methoden: B. Kröncke
	 */
	public BuchungKundeSucheGUI(IObjektModel smodel, BuchungKundeSucheStrg scontroller) {
		setBackground(Color.DARK_GRAY);
		
		this.model = smodel;
		this.controller = scontroller;
		
		
		
		
		setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 668, 539);
		add(panel_1);
		
		txtSearchbar = new JTextField();
		txtSearchbar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
					
					anfrage();
					
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	
		});
		txtSearchbar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearchbar.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchbar.setText("Suche...");
		txtSearchbar.setColumns(10);
		txtSearchbar.setBounds(220, 75, 228, 35);
		panel_1.add(txtSearchbar);
		
		JButton alleButton = new JButton("Suchen");
		alleButton.setBackground(new Color(255, 140, 0));
		alleButton.setForeground(new Color(0, 0, 0));
		alleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				talking = "master";
				anfrage();

			}
		});
		alleButton.setPreferredSize(new Dimension(120, 35));
		alleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		alleButton.setBounds(10, 192, 200, 35);
		panel_1.add(alleButton);
		
		JButton leerButton = new JButton("Leeren");
		leerButton.setBackground(new Color(255, 140, 0));
		leerButton.setForeground(new Color(0, 0, 0));
		leerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchbar.setText("");
				txtKnr.setText("");
			}
		});
		leerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leerButton.setBounds(220, 192, 228, 35);
		panel_1.add(leerButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				talking = comboBox.getSelectedItem().toString();
				System.out.println(talking);
			}
		});
		comboBox.addItem("Nachname");
		comboBox.addItem("Vorname");
		comboBox.addItem("E-Mail");
		comboBox.addItem("PLZ");
		comboBox.addItem("Strasse");
		comboBox.addItem("Ort");
		
		
		comboBox.setPreferredSize(new Dimension(80, 35));
		comboBox.setMaximumSize(new Dimension(100, 35));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(458, 75, 153, 35);
		panel_1.add(comboBox);
		
		JButton waehleButton = new JButton("Ausw\u00E4hlen");
		waehleButton.setBackground(new Color(255, 140, 0));
		waehleButton.setForeground(new Color(0, 0, 0));
		waehleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(txtKnr.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Kein Kunde gewählt!");
					else
					{
						BuchungTypSucheGUI tauswahl = MainFrame.getBuchungTypSucheGUI();
						controller.erstelleKunde(txtKnr.getText());
						MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getBuchungTypSucheGUI());
						MainFrame.getBuchungTypSucheGUI().setKnr(Integer.parseInt(txtKnr.getText()));
						MainFrame.getBuchungTypSucheGUI().setKunde((IKunde) model.getObjekte().get(0));
						
						System.out.println(MainFrame.getBuchungTypSucheGUI().getKnr());
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		waehleButton.setPreferredSize(new Dimension(120, 35));
		waehleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		waehleButton.setBounds(458, 192, 200, 35);
		panel_1.add(waehleButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 648, 291);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				talking = "table";
				try {
					
					int row = table.getSelectedRow();
					txtKnr.setText(table.getModel().getValueAt(row, 0).toString());
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			
		}});
		scrollPane.setViewportView(table);
		
		txtKnr = new JTextField();
		txtKnr.setEditable(false);
		txtKnr.setHorizontalAlignment(SwingConstants.CENTER);
		txtKnr.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtKnr.setColumns(10);
		txtKnr.setBounds(220, 121, 228, 35);
		panel_1.add(txtKnr);
		
		JLabel lblSucheKundeNach = new JLabel("Suche Kunde nach:");
		lblSucheKundeNach.setForeground(Color.WHITE);
		lblSucheKundeNach.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSucheKundeNach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSucheKundeNach.setBounds(24, 75, 184, 35);
		panel_1.add(lblSucheKundeNach);
		
		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setForeground(Color.WHITE);
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKundennummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKundennummer.setBounds(24, 120, 184, 35);
		panel_1.add(lblKundennummer);
		
		JButton button = new JButton("Zur\u00FCck");
		button.setBackground(new Color(255, 140, 0));
		button.setForeground(new Color(0, 0, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getBuchungsverwaltungGUI());
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(0, 0, 150, 35);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Hauptmen\u00FC");
		button_1.setBackground(new Color(255, 140, 0));
		button_1.setForeground(new Color(0, 0, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getHauptmenueGUI());
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(545, 2, 123, 31);
		panel_1.add(button_1);
		

	}

	@Override
	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());
		
	}
	
	private void anfrage() {
		model.anmelden(MainFrame.getKundeAendernGUI());
		controller.fetchObjekte(talking, txtSearchbar.getText() );
		table.setModel(model.getTableModel());
		model.abmelden(MainFrame.getKundeAendernGUI());
	}
}
