/*
 *  @author Michael Schmidt
 */

package com.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controller.BuchungTypSucheStrg;
import com.entity.GeraeteTyp;
import com.entity.IKunde;
import com.model.IObjektModel;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GeraeteTypVerwaltungGUI extends JPanel implements IObjektView {

	private BuchungTypSucheStrg controller;
	private IObjektModel model;
	private int knr;
	private String talking = "gesamt";
	private IKunde kunde;
	private JTextField textSuchen;
	private JTable table;
	private Icon lupe;
	private GeraeteTyp typ;
	private int id;
	private String name;
	private String fuehrerschein;

	/**
	 * Create the panel.
	 */
	public GeraeteTypVerwaltungGUI(IObjektModel smodel, BuchungTypSucheStrg scontroller) {
		model = smodel;
		controller = scontroller;

		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurck.setBackground(new Color(255, 140, 0));

		textSuchen = new JTextField("Suchen...");
		textSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSuchen.setColumns(10);

		lupe = new ImageIcon(getClass().getResource("suchenLogo.png"));
		JLabel label = new JLabel(lupe);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE).addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
						.addContainerGap(17, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnTypHinzu = new JButton("Typ hinzuf\u00FCgen");
		btnTypHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTypHinzu.setBackground(new Color(255, 140, 0));
		btnTypHinzu.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnTypHinzu = new GridBagConstraints();
		gbc_btnTypHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnTypHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnTypHinzu.gridx = 0;
		gbc_btnTypHinzu.gridy = 0;
		panel_1.add(btnTypHinzu, gbc_btnTypHinzu);

		JButton btnTypAendern = new JButton("Typ \u00E4ndern");
		btnTypAendern.setBackground(new Color(255, 140, 0));
		btnTypAendern.setPreferredSize(new Dimension(300, 23));
		btnTypAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnTypAendern = new GridBagConstraints();
		gbc_btnTypAendern.fill = GridBagConstraints.BOTH;
		gbc_btnTypAendern.insets = new Insets(0, 0, 5, 0);
		gbc_btnTypAendern.gridx = 1;
		gbc_btnTypAendern.gridy = 0;
		panel_1.add(btnTypAendern, gbc_btnTypAendern);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setPreferredSize(new Dimension(2, 375));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Typ mit ID: " + table.getModel().getValueAt(table.getSelectedRow(), 0) + " gewählt!");
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setGridColor(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		tm.addColumn("TypID");
		tm.addColumn("Name");
		tm.addColumn("Führerschein");

		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);

		JButton btnModelle = new JButton("Modelle");
		btnModelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModelle.setBackground(new Color(255, 140, 0));
		btnModelle.setMinimumSize(new Dimension(150, 35));
		btnModelle.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnModelle = new GridBagConstraints();
		gbc_btnModelle.anchor = GridBagConstraints.EAST;
		gbc_btnModelle.fill = GridBagConstraints.VERTICAL;
		gbc_btnModelle.gridx = 1;
		gbc_btnModelle.gridy = 7;
		panel_1.add(btnModelle, gbc_btnModelle);

		// Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getGeraeteVerwaltungGUI());
				textSuchen.setText("Suchen...");

			}
		});

		btnTypHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTypAnlegenGUI());
				textSuchen.setText("Suchen...");
			}
		});

		btnTypAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zeile = table.getSelectedRow();

				if (zeile < 0)
					JOptionPane.showMessageDialog(null, "Typen auswählen!");
				else {
					werteAuslesen(zeile);
					werteUebergeben();
					MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTypAendernGUI());
					textSuchen.setText("Suchen...");
					System.out.println(fuehrerschein);
				}
			}
			
			//Methode die Werte an die View TypAendernGUI übergibt
			private void werteUebergeben() {
				MainFrame.getTypAendernGUI().setTyp(typ);
				MainFrame.getTypAendernGUI().setText(name);
				MainFrame.getTypAendernGUI().setFuehrerschein(fuehrerschein);
			}

			//Methode, die Werte aus der Tabelle ausliest
			private void werteAuslesen(int zeile) {
				id = Integer.parseInt(String.valueOf(table.getValueAt(zeile, 0)));
				name = String.valueOf(table.getValueAt(zeile, 1));
				fuehrerschein = String.valueOf(table.getValueAt(zeile, 2));
				typ = new GeraeteTyp(id, name, fuehrerschein);
			}
		});

		btnModelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getGeraeteModellVerwaltungGUI());
				MainFrame.getGeraeteModellVerwaltungGUI().anfrage();
				textSuchen.setText("Suchen...");
			}
		});

		textSuchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textSuchen.setText("");
			}
		});

		textSuchen.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				talking = "suchen";
				anfrage();
				talking = "gesamt";
			}
		});

	}

	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());

	}

	public void anfrage() {
		model.anmelden(MainFrame.getBuchungTypSucheGUI());
		controller.fetchTypen(knr, talking, textSuchen.getText(), kunde);
		aktualisieren(model);
		model.abmelden(MainFrame.getBuchungTypSucheGUI());
	}

	public void setTalking(String talking) {
		this.talking = talking;
	}

}
