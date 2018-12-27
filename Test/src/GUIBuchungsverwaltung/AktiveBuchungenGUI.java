package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IObjektModel;
import GUI.IObjektView;
import GUI.MainFrame;
import Steuerung.BuchungBuchungAnzeigenStrg;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AktiveBuchungenGUI extends JPanel implements IObjektView { //Ben Kröncke
	private JTextField searchField;
	private JTable table;
	private String talking;
	private String mode = "Verleih";
	private String search;
	private String makel = "";
	private JButton btnRueck;
	private IObjektModel model;
	private int kNr;
	private int geraetNr;
	private int buchungID = 0;
	private BuchungBuchungAnzeigenStrg controller;
	

	/**
	 * Create the panel.
	 */
	public AktiveBuchungenGUI(IObjektModel models, BuchungBuchungAnzeigenStrg controllers) {
		setBackground(Color.DARK_GRAY);
		
		model = models;
		controller = controllers;
		
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBackground(new Color(255, 140, 0));
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBackground(new Color(255, 140, 0));
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				talking = "search";
				search = searchField.getText();
				anfrage();
				
			}
		});
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchField.setColumns(10);
		
		JComboBox modusBox = new JComboBox();
		modusBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				mode = modusBox.getSelectedItem().toString();
				talking = "master";
				anfrage();
				
				if(mode.equals("Verkauf"))
					btnRueck.setText("Rechnung erstellen");
				if(mode.equals("Verleih"))
					btnRueck.setText("Rückgabe");
			}
		});
		modusBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		modusBox.setModel(new DefaultComboBoxModel(new String[] {"Verleih", "Verkauf"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(modusBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnZurck, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSuchen, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(searchField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
						.addComponent(modusBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnRueck = new JButton("R\u00FCckgabe");
		btnRueck.setBackground(new Color(255, 140, 0));
		btnRueck.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRueck.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnRueck = new GridBagConstraints();
		gbc_btnRueck.insets = new Insets(0, 0, 5, 5);
		gbc_btnRueck.fill = GridBagConstraints.BOTH;
		gbc_btnRueck.gridx = 0;
		gbc_btnRueck.gridy = 0;
		panel_1.add(btnRueck, gbc_btnRueck);
				
		JButton btnStorn = new JButton("Stornieren");
		btnStorn.setBackground(new Color(255, 140, 0));
		btnStorn.setPreferredSize(new Dimension(300, 23));
		btnStorn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnStorn = new GridBagConstraints();
		gbc_btnStorn.fill = GridBagConstraints.BOTH;
		gbc_btnStorn.insets = new Insets(0, 0, 5, 0);
		gbc_btnStorn.gridx = 1;
		gbc_btnStorn.gridy = 0;
		panel_1.add(btnStorn, gbc_btnStorn);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					int row = table.getSelectedRow();
					buchungID = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					kNr = Integer.parseInt(table.getModel().getValueAt(row, 1).toString());
					geraetNr = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getAktiveBuchungenGUI(), MainFrame.getBuchungsverwaltungGUI());
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				talking ="master";
				anfrage();
			}
		});
		
		btnRueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				talking = "rckButton";
				
				try {
					if(buchungID == 0 && kNr == 0)
						JOptionPane.showMessageDialog(null, "Bitte Buchung zum Verändern auswählen!");
					else if(buchungID != 0 && kNr != 0)
					{
						if(mode.equals("Verkauf"))
							JOptionPane.showConfirmDialog(null, "Rechnung wirklich erstellen? Sie wird dann nicht mehr als aktive Buchung angezeigt!");
						if(mode.equals("Verleih"))
							makel = JOptionPane.showInputDialog("Gibt es Makel bei der Rückgabe? Bitte eintragen!");
						System.out.println("" + kNr + " " + talking);
						anfrage();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					zuruecksetzen();
				}
				
			}

			
		});
		
		btnStorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				talking = "stornButton";
				
				try {
					if(buchungID == 0 && kNr == 0)
						JOptionPane.showMessageDialog(null, "Bitte Buchung zum Verändern auswählen!");
					else if(buchungID != 0 && kNr != 0)
					{
						System.out.println("" + kNr + " " + talking);
						int ergebnis = nachfrage(modusBox);
						if(ergebnis == 0)
							anfrage();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					zuruecksetzen();
				}
				
			}

			private int nachfrage(JComboBox modusBox) {
				int wert = JOptionPane.showConfirmDialog(null, modusBox.getSelectedItem().toString() + " stornieren?", "Warnung!", JOptionPane.YES_NO_OPTION);
				if (wert==0){
					
					JOptionPane.showMessageDialog(null, modusBox.getSelectedItem().toString() + " wurde erfolgreich storniert", "Warnung!", JOptionPane.PLAIN_MESSAGE);
				}
				else{ 
					JOptionPane.showMessageDialog(null, modusBox.getSelectedItem().toString() + " wurde nicht storniert", "Warnung!", JOptionPane.PLAIN_MESSAGE);
				}
				return wert;
			}
		});
		
	}

	@Override
	public void aktualisieren(IObjektModel model) {
		// TODO Auto-generated method stub
		table.setModel(model.getTableModel());
	}

	private void anfrage() {
		model.anmelden(MainFrame.getAktiveBuchungenGUI());
		controller.fetchBuchung(talking, buchungID, kNr, geraetNr, search, mode, makel);
		model.abmelden(MainFrame.getAktiveBuchungenGUI());
	}
	
	private void zuruecksetzen() {
		kNr = 0;
		buchungID = 0;
		geraetNr = 0;
		talking = "master";
		anfrage();
	}
}
