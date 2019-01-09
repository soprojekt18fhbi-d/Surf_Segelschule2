/*
 *  @author Michael Schmidt
 */

package com.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controller.ModellAnlegenStrg;
import com.model.IAnlegenModel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModellAendernGUI extends JPanel implements IAnlegenView {
	private JTextField txtModell;

	IAnlegenModel model;
	ModellAnlegenStrg controller;
	private String talking = "second";
	private JComboBox<String> comboBoxTyp;
	private JComboBox comboBoxPreis;
	private String typ;
	private String name;
	private String modellName;
	private int typID;
	private int preisID;
	private int modellID;
	private JLabel lblModell;

	/**
	 * 
	 * Create the panel.
	 */
	public ModellAendernGUI(IAnlegenModel models, ModellAnlegenStrg controllers) {
		model = models;
		controller = controllers;
		;

		setSize(900, 550);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblModellAendern = new JLabel("Modell \u00E4ndern:");
		lblModellAendern.setForeground(Color.WHITE);
		lblModellAendern.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblModellAendern = new GridBagConstraints();
		gbc_lblModellAendern.anchor = GridBagConstraints.WEST;
		gbc_lblModellAendern.gridwidth = 2;
		gbc_lblModellAendern.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellAendern.gridx = 2;
		gbc_lblModellAendern.gridy = 2;
		panel.add(lblModellAendern, gbc_lblModellAendern);

		JLabel lblModell_1 = new JLabel("Modell:");
		lblModell_1.setForeground(Color.WHITE);
		lblModell_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblModell_1 = new GridBagConstraints();
		gbc_lblModell_1.anchor = GridBagConstraints.WEST;
		gbc_lblModell_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblModell_1.gridx = 2;
		gbc_lblModell_1.gridy = 4;
		panel.add(lblModell_1, gbc_lblModell_1);

		lblModell = new JLabel("");
		lblModell.setForeground(Color.WHITE);
		lblModell.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblModell = new GridBagConstraints();
		gbc_lblModell.anchor = GridBagConstraints.WEST;
		gbc_lblModell.insets = new Insets(0, 0, 5, 5);
		gbc_lblModell.gridx = 3;
		gbc_lblModell.gridy = 4;
		panel.add(lblModell, gbc_lblModell);

		JLabel lblModellname = new JLabel("neuer Modellname:");
		lblModellname.setForeground(Color.WHITE);
		lblModellname.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblModellname = new GridBagConstraints();
		gbc_lblModellname.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellname.anchor = GridBagConstraints.WEST;
		gbc_lblModellname.gridx = 2;
		gbc_lblModellname.gridy = 6;
		panel.add(lblModellname, gbc_lblModellname);

		txtModell = new JTextField();
		txtModell.setPreferredSize(new Dimension(6, 40));
		txtModell.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtModell = new GridBagConstraints();
		gbc_txtModell.insets = new Insets(0, 0, 5, 5);
		gbc_txtModell.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModell.gridx = 3;
		gbc_txtModell.gridy = 6;
		panel.add(txtModell, gbc_txtModell);
		txtModell.setColumns(10);

		JLabel lblTyp = new JLabel("Typ:");
		lblTyp.setForeground(Color.WHITE);
		lblTyp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTyp = new GridBagConstraints();
		gbc_lblTyp.anchor = GridBagConstraints.WEST;
		gbc_lblTyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyp.gridx = 2;
		gbc_lblTyp.gridy = 7;
		panel.add(lblTyp, gbc_lblTyp);

		comboBoxTyp = new JComboBox<String>();
		comboBoxTyp.setFont(new Font("Tahoma", Font.PLAIN, 20));

		GridBagConstraints gbc_comboBoxTyp = new GridBagConstraints();
		gbc_comboBoxTyp.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTyp.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTyp.gridx = 3;
		gbc_comboBoxTyp.gridy = 7;
		panel.add(comboBoxTyp, gbc_comboBoxTyp);

		JLabel lblPreiskateg = new JLabel("Preiskategorie:");
		lblPreiskateg.setForeground(Color.WHITE);
		lblPreiskateg.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblPreiskateg = new GridBagConstraints();
		gbc_lblPreiskateg.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreiskateg.anchor = GridBagConstraints.WEST;
		gbc_lblPreiskateg.gridx = 2;
		gbc_lblPreiskateg.gridy = 8;
		panel.add(lblPreiskateg, gbc_lblPreiskateg);

		comboBoxPreis = new JComboBox();
		comboBoxPreis.setFont(new Font("Tahoma", Font.PLAIN, 20));

		GridBagConstraints gbc_comboBoxPreis = new GridBagConstraints();
		gbc_comboBoxPreis.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPreis.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPreis.gridx = 3;
		gbc_comboBoxPreis.gridy = 8;
		panel.add(comboBoxPreis, gbc_comboBoxPreis);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		add(panel_2, BorderLayout.SOUTH);

		JButton btnBestaetigen = new JButton("best\u00E4tigen");
		btnBestaetigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBestaetigen.setBackground(new Color(255, 140, 0));

		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAbbrechen.setBackground(new Color(255, 140, 0));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap(573, Short.MAX_VALUE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGap(17)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		// Funktionen der Button
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				talking = "aendern";

				try {
					modellAendern();
					JOptionPane.showMessageDialog(null, "Das Modell wurde erfolgreich geändert!");
					MainFrame.change(MainFrame.getModellAendernGUI(), MainFrame.getGeraeteModellVerwaltungGUI());
					MainFrame.getGeraeteModellVerwaltungGUI().anfrage();
					txtModell.setText("");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Das Modell konnte nicht geändert werden");
				}
			}
		});

		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getGeraeteModellVerwaltungGUI().anfrage();
				MainFrame.change(MainFrame.getModellAendernGUI(), MainFrame.getGeraeteModellVerwaltungGUI());
			}
		});
	}

	private void modellAendern() {
		name = txtModell.getText();
		if (name == "")
			name = modellName;
		typ = String.valueOf(comboBoxTyp.getSelectedItem());
		String preisKateg = String.valueOf(comboBoxPreis.getSelectedItem());
		preisID = Integer.parseInt(preisKateg);
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID, modellID);
		aktualisieren(model);
	}

	public void setModellID(int id) {
		this.modellID = id;
	}

	public void setText(String text) {
		this.modellName = text;
		lblModell.setText(text);
	}

	public void setPreisID(int id) {
		this.preisID = id;
	}

	public void setTypID(int id) {
		this.typID = id;
	}

	public void aktualisieren(IAnlegenModel model) {
		ArrayList<String> comboboxItems = model.getObertypen();
		if (talking.equals("first")) {
			for (int i = 0; i < comboboxItems.size(); i++) {
				comboBoxTyp.addItem(comboboxItems.get(i));
			}
			comboBoxTyp.setSelectedIndex(typID - 1);
		} else if (talking.equals("second")) {
			for (int i = 0; i < comboboxItems.size(); i++) {
				comboBoxPreis.addItem(comboboxItems.get(i));
			}
			comboBoxPreis.setSelectedIndex(preisID - 1);
		}
		comboboxItems.clear();

	}

	public void anfrage() {
		comboBoxTyp.removeAllItems();
		model.anmelden(this);
		talking = "first";
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID, modellID);
		talking = "second";
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID, modellID);
		model.abmelden(this);

	}

}
