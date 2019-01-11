package com.view;

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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.controller.BuchungGeraetSucheStrg;
import com.controller.BuchungModellSucheStrg;
import com.controller.BuchungTypSucheStrg;
import com.entity.IKunde;
import com.model.BuchungModellSucheModel;
import com.model.BuchungTypSucheModel;
import com.model.IModel;
import com.model.IObjektModel;

import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class BuchungGeraetSucheGUI extends JPanel implements IObjektView {

	private BuchungGeraetSucheStrg controller;
	private IObjektModel model;
	private JTable table;
	private IKunde kunde;
	private int modellNr;
	private String selectedMode = "Wähle";
	private String talking = "master";
	private int kNr;
	private int geraetNr = 0;
	private TableModel standard = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public BuchungGeraetSucheGUI(IObjektModel models, BuchungGeraetSucheStrg controllers) {
		setBackground(Color.DARK_GRAY);

		model = models;
		controller = controllers;

		setLayout(null);

		JButton btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setBackground(new Color(255, 140, 0));
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungGeraetSucheGUI(), MainFrame.getBuchungModellSucheGUI());
			}
		});
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnZurueck.setBounds(0, 0, 120, 40);
		add(btnZurueck);

		JButton btnHauptmenue = new JButton("Hauptmen\u00FC");
		btnHauptmenue.setBackground(new Color(255, 140, 0));
		btnHauptmenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.change(MainFrame.getBuchungGeraetSucheGUI(), MainFrame.getHauptmenueGUI());

			}
		});
		btnHauptmenue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHauptmenue.setBounds(855, 0, 120, 40);
		add(btnHauptmenue);

		JComboBox comboVerkauf = new JComboBox();
		comboVerkauf.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				selectedMode = comboVerkauf.getSelectedItem().toString();
				System.out.println(selectedMode);
			}
		});
		comboVerkauf.setFont(new Font("Tahoma", Font.BOLD, 24));
		comboVerkauf.setBounds(155, 13, 690, 60);
		add(comboVerkauf);
		comboVerkauf.addItem("Wähle");
		comboVerkauf.addItem("Verleih");
		comboVerkauf.addItem("Verkauf");

		JButton btnBestaetigen = new JButton("Best\u00E4tigen");
		btnBestaetigen.setBackground(new Color(255, 140, 0));
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				talking = comboVerkauf.getSelectedItem().toString();
				System.out.println(talking);

				if (selectedMode.equals("Wähle"))
					JOptionPane.showMessageDialog(null, "Bitte wähle einen Modus und ein Sportgerät!");
				else if (geraetNr == 0)
					JOptionPane.showMessageDialog(null, "Bitte wähle einen Modus und ein Sportgerät!");
				else if (selectedMode.equals("Verleih") || selectedMode.equals("Verkauf")) {

					int result = JOptionPane.showConfirmDialog(null,
							comboVerkauf.getSelectedItem() + " wirklich erfassen?");
					System.out.println(result);
					if (result == 0) {
						anfrage();
						JOptionPane.showMessageDialog(null, "Die Buchung wurde erfasst!");
						geraetNr = 0;
						table.setModel(standard);
					} else if (result != 0)
						JOptionPane.showMessageDialog(null, "Der Vorgang wurde abgebrochen!");

				}

			}
		});
		btnBestaetigen.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBestaetigen.setBounds(155, 84, 690, 53);
		add(btnBestaetigen);

		JLabel lblFrDieseAktion = new JLabel("Zur Verf\u00FCgung stehende Sportger\u00E4te:");
		lblFrDieseAktion.setForeground(new Color(255, 255, 255));
		lblFrDieseAktion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFrDieseAktion.setBounds(155, 148, 485, 53);
		add(lblFrDieseAktion);

		JButton btnAktualisieren = new JButton("Aktualisieren");
		btnAktualisieren.setBackground(new Color(255, 140, 0));
		btnAktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				talking = "master";

				anfrage();
				JOptionPane.showMessageDialog(null, "Es werden alle Sportgeräte des hiesigen Standortes angezeigt!");
			}

		});
		btnAktualisieren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAktualisieren.setBounds(650, 151, 195, 53);
		add(btnAktualisieren);

		JPanel panel = new JPanel();
		panel.setBounds(155, 225, 690, 353);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				talking = "table";
				try {

					int row = table.getSelectedRow();
					geraetNr = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					JOptionPane.showMessageDialog(null, "Gerät mit ID: " + table.getModel().getValueAt(row, 0) + " gewählt!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(table);

	}

	@Override
	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());

	}

	public int getModellNr() {
		return modellNr;
	}

	public void setModellNr(int modellNr) {
		this.modellNr = modellNr;
	}

	public IKunde getKunde() {
		return kunde;
	}

	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}

	public int getkNr() {
		return kNr;
	}

	public void setkNr(int kNr) {
		this.kNr = kNr;
	}

	private void anfrage() {
		model.anmelden(MainFrame.getBuchungGeraetSucheGUI());
		controller.fetchGeraete(talking, modellNr, kNr, geraetNr, MainFrame.getStandort());
		model.abmelden(MainFrame.getBuchungGeraetSucheGUI());
	}

}
