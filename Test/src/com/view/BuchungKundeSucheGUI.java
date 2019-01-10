package com.view;

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

import com.controller.BuchungKundeSucheStrg;
import com.entity.IKunde;
import com.model.IObjektModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
	private String talking = "Nachname";
	private TableModel standard = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	/*
	 * @author M. Schmidt / Methoden: B. Kröncke
	 */
	public BuchungKundeSucheGUI(IObjektModel smodel, BuchungKundeSucheStrg scontroller) {
		this.model = smodel;
		this.controller = scontroller;

		setSize(980, 580);
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
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 828, Short.MAX_VALUE)
						.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnHauptmen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 13, 0, 0, 20, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.1, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.025, 0.0, 0.0, 0.04, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblSucheKundeNach = new JLabel("Suche Kunde nach:");
		lblSucheKundeNach.setForeground(Color.WHITE);
		lblSucheKundeNach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSucheKundeNach = new GridBagConstraints();
		gbc_lblSucheKundeNach.anchor = GridBagConstraints.WEST;
		gbc_lblSucheKundeNach.insets = new Insets(0, 0, 5, 5);
		gbc_lblSucheKundeNach.gridx = 0;
		gbc_lblSucheKundeNach.gridy = 1;
		panel_1.add(lblSucheKundeNach, gbc_lblSucheKundeNach);

		txtSearchbar = new JTextField();
		txtSearchbar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearchbar.setText("Suchen...");
		GridBagConstraints gbc_txtSearchbar = new GridBagConstraints();
		gbc_txtSearchbar.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchbar.fill = GridBagConstraints.BOTH;
		gbc_txtSearchbar.gridx = 1;
		gbc_txtSearchbar.gridy = 1;
		panel_1.add(txtSearchbar, gbc_txtSearchbar);
		txtSearchbar.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);

		comboBox.addItem("Nachname");
		comboBox.addItem("Vorname");
		comboBox.addItem("E-Mail");
		comboBox.addItem("PLZ");
		comboBox.addItem("Strasse");
		comboBox.addItem("Ort");

		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setForeground(Color.WHITE);
		lblKundennummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblKundennummer = new GridBagConstraints();
		gbc_lblKundennummer.anchor = GridBagConstraints.WEST;
		gbc_lblKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennummer.gridx = 0;
		gbc_lblKundennummer.gridy = 2;
		panel_1.add(lblKundennummer, gbc_lblKundennummer);

		txtKnr = new JTextField();
		txtKnr.setHorizontalAlignment(SwingConstants.CENTER);
		txtKnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKnr.setEditable(false);
		GridBagConstraints gbc_txtKnr = new GridBagConstraints();
		gbc_txtKnr.insets = new Insets(0, 0, 5, 5);
		gbc_txtKnr.fill = GridBagConstraints.BOTH;
		gbc_txtKnr.gridx = 1;
		gbc_txtKnr.gridy = 2;
		panel_1.add(txtKnr, gbc_txtKnr);
		txtKnr.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBackground(new Color(255, 140, 0));
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuchen.gridx = 0;
		gbc_btnSuchen.gridy = 0;
		panel_2.add(btnSuchen, gbc_btnSuchen);

		JButton btnLeeren = new JButton("Leeren");
		btnLeeren.setBackground(new Color(255, 140, 0));
		btnLeeren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnLeeren = new GridBagConstraints();
		gbc_btnLeeren.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLeeren.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeeren.gridx = 1;
		gbc_btnLeeren.gridy = 0;
		panel_2.add(btnLeeren, gbc_btnLeeren);

		JButton btnAuswhlen = new JButton("Ausw\u00E4hlen");
		btnAuswhlen.setBackground(new Color(255, 140, 0));
		btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAuswhlen = new GridBagConstraints();
		gbc_btnAuswhlen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAuswhlen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAuswhlen.gridx = 2;
		gbc_btnAuswhlen.gridy = 0;
		panel_2.add(btnAuswhlen, gbc_btnAuswhlen);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Funktionen der Button
		txtSearchbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSearchbar.setText("");
			}
		});

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

		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				talking = "master";
				anfrage();
			}
		});

		btnLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchbar.setText("Suchen...");
				txtKnr.setText("");
			}
		});

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				talking = comboBox.getSelectedItem().toString();
				System.out.println(talking);
			}
		});

		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (txtKnr.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Kein Kunde gewählt!");
					else {
						BuchungTypSucheGUI tauswahl = MainFrame.getBuchungTypSucheGUI();
						controller.erstelleKunde(txtKnr.getText());
						MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getBuchungTypSucheGUI());
						MainFrame.getBuchungTypSucheGUI().setKnr(Integer.parseInt(txtKnr.getText()));
						MainFrame.getBuchungTypSucheGUI().setKunde((IKunde) model.getObjekte().get(0));

						System.out.println(MainFrame.getBuchungTypSucheGUI().getKnr());
						txtKnr.setText("");
						table.setModel(standard);
					}
					txtSearchbar.setText("Suchen...");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				talking = "table";
				try {

					int row = table.getSelectedRow();
					txtKnr.setText(table.getModel().getValueAt(row, 0).toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getBuchungsverwaltungGUI());
				txtSearchbar.setText("Suchen...");
			}
		});

		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungKundeSucheGUI(), MainFrame.getHauptmenueGUI());
				txtSearchbar.setText("Suchen...");
			}
		});
	}

	@Override
	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());

	}

	private void anfrage() {
		model.anmelden(MainFrame.getKundeAendernGUI());
		controller.fetchObjekte(talking, txtSearchbar.getText());
		table.setModel(model.getTableModel());
		model.abmelden(MainFrame.getKundeAendernGUI());
	}
}
