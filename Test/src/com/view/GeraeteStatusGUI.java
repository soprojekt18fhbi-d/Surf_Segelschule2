/*
 *  @author Michael Schmidt
 */

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controller.GeraetAnlegenStrg;
import com.model.IAnlegenModel;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;

public class GeraeteStatusGUI extends JPanel implements IAnlegenView {
	IAnlegenModel model;
	GeraetAnlegenStrg controller;

	private int modellID;
	private int geraeteID;
	private String status;
	private String neuerStatus;
	private String talking;
	private JLabel lblModellname;
	private JLabel lblGeraeteID;
	private String modell;
	private String makel;
	private String farbe;
	private String typ;
	private String geraet;
	private int baujahr;
	private double anschaffungspreis;
	private double verkaufspreis;
	private JRadioButton radioButtonOK;
	private JRadioButton radioButtonVerliehen;
	private JRadioButton radioButtonReparatur;
	private JRadioButton radioButtonDeaktiviert;
	private ButtonGroup radioButton = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public GeraeteStatusGUI(IAnlegenModel models, GeraetAnlegenStrg controllers) {
		model = models;
		controller = controllers;

		setSize(980, 580);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.1, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblStatusAendern = new JLabel("Status \u00E4ndern:");
		lblStatusAendern.setForeground(Color.WHITE);
		lblStatusAendern.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblStatusAendern = new GridBagConstraints();
		gbc_lblStatusAendern.anchor = GridBagConstraints.WEST;
		gbc_lblStatusAendern.gridwidth = 2;
		gbc_lblStatusAendern.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatusAendern.gridx = 2;
		gbc_lblStatusAendern.gridy = 2;
		panel.add(lblStatusAendern, gbc_lblStatusAendern);

		JLabel lblGeraet = new JLabel("Ger\u00E4teID:");
		lblGeraet.setForeground(Color.WHITE);
		lblGeraet.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblGeraet = new GridBagConstraints();
		gbc_lblGeraet.anchor = GridBagConstraints.WEST;
		gbc_lblGeraet.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeraet.gridx = 2;
		gbc_lblGeraet.gridy = 5;
		panel.add(lblGeraet, gbc_lblGeraet);

		lblModellname = new JLabel();
		lblModellname.setForeground(Color.WHITE);
		lblModellname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblModellname = new GridBagConstraints();
		gbc_lblModellname.anchor = GridBagConstraints.WEST;
		gbc_lblModellname.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellname.gridx = 3;
		gbc_lblModellname.gridy = 4;
		panel.add(lblModellname, gbc_lblModellname);

		JLabel lblModell = new JLabel("Modell:");
		lblModell.setForeground(Color.WHITE);
		lblModell.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblModell = new GridBagConstraints();
		gbc_lblModell.insets = new Insets(0, 0, 5, 5);
		gbc_lblModell.anchor = GridBagConstraints.WEST;
		gbc_lblModell.gridx = 2;
		gbc_lblModell.gridy = 4;
		panel.add(lblModell, gbc_lblModell);

		lblGeraeteID = new JLabel();
		lblGeraeteID.setForeground(Color.WHITE);
		lblGeraeteID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblGeraeteID = new GridBagConstraints();
		gbc_lblGeraeteID.anchor = GridBagConstraints.WEST;
		gbc_lblGeraeteID.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeraeteID.gridx = 3;
		gbc_lblGeraeteID.gridy = 5;
		panel.add(lblGeraeteID, gbc_lblGeraeteID);

		radioButtonOK = new JRadioButton("OK");
		radioButtonOK.setForeground(Color.WHITE);
		radioButtonOK.setBackground(Color.DARK_GRAY);
		radioButtonOK.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxOK = new GridBagConstraints();
		gbc_chckbxOK.anchor = GridBagConstraints.WEST;
		gbc_chckbxOK.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxOK.gridx = 3;
		gbc_chckbxOK.gridy = 7;
		panel.add(radioButtonOK, gbc_chckbxOK);

		radioButtonVerliehen = new JRadioButton("Verliehen");
		radioButtonVerliehen.setForeground(Color.WHITE);
		radioButtonVerliehen.setBackground(Color.DARK_GRAY);
		radioButtonVerliehen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxVerliehen = new GridBagConstraints();
		gbc_chckbxVerliehen.anchor = GridBagConstraints.WEST;
		gbc_chckbxVerliehen.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerliehen.gridx = 3;
		gbc_chckbxVerliehen.gridy = 8;
		panel.add(radioButtonVerliehen, gbc_chckbxVerliehen);

		radioButtonReparatur = new JRadioButton("Reparatur");
		radioButtonReparatur.setBackground(Color.DARK_GRAY);
		radioButtonReparatur.setForeground(Color.WHITE);
		radioButtonReparatur.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxReparatur = new GridBagConstraints();
		gbc_chckbxReparatur.anchor = GridBagConstraints.WEST;
		gbc_chckbxReparatur.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxReparatur.gridx = 3;
		gbc_chckbxReparatur.gridy = 9;
		panel.add(radioButtonReparatur, gbc_chckbxReparatur);

		radioButtonDeaktiviert = new JRadioButton("Deaktiviert");
		radioButtonDeaktiviert.setForeground(Color.WHITE);
		radioButtonDeaktiviert.setBackground(Color.DARK_GRAY);
		radioButtonDeaktiviert.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxDeaktiviert = new GridBagConstraints();
		gbc_chckbxDeaktiviert.anchor = GridBagConstraints.WEST;
		gbc_chckbxDeaktiviert.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDeaktiviert.gridx = 3;
		gbc_chckbxDeaktiviert.gridy = 10;
		panel.add(radioButtonDeaktiviert, gbc_chckbxDeaktiviert);
		
		radioButton.add(radioButtonOK);
		radioButton.add(radioButtonVerliehen);
		radioButton.add(radioButtonReparatur);
		radioButton.add(radioButtonDeaktiviert);

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
		gl_panel_2
				.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup().addContainerGap(580, Short.MAX_VALUE)
								.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBestaetigen,
										GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))));
		panel_2.setLayout(gl_panel_2);

		// Funktionen der Button
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				talking = "status";

				try {
					if (status.equals("Reparatur")) {
						MainFrame.getGeraeteReparaturGUI().setModellID(modellID);
						MainFrame.getGeraeteReparaturGUI().setGeraeteID(geraeteID);
						holeStatus();
						MainFrame.getGeraeteReparaturGUI().setStatus(neuerStatus);
						MainFrame.getGeraeteReparaturGUI().anfrage();
						JOptionPane.showMessageDialog(null, "Die Reparatur wird erfasst");
						MainFrame.change(MainFrame.getGeraeteStatusGUI(), MainFrame.getGeraeteReparaturGUI());
					} else {
						statusAendern();
						JOptionPane.showMessageDialog(null, "Der Status wurde erfolgreich geändert!");
						MainFrame.change(MainFrame.getGeraeteStatusGUI(), MainFrame.getSportgeraeteGUI());
						MainFrame.getSportgeraeteGUI().anfrage();
					}
					radioButtonOK.setSelected(false);
					radioButtonVerliehen.setSelected(false);
					radioButtonReparatur.setSelected(false);
					radioButtonDeaktiviert.setSelected(false);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Der Status konnte nicht geändert werden");
				}
			}
		});

		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getSportgeraeteGUI().anfrage();
				MainFrame.change(MainFrame.getGeraeteStatusGUI(), MainFrame.getSportgeraeteGUI());
				radioButtonOK.setSelected(false);
				radioButtonVerliehen.setSelected(false);
				radioButtonReparatur.setSelected(false);
				radioButtonDeaktiviert.setSelected(false);
			}
		});
	}

	private void holeStatus() {
		if (radioButtonOK.isSelected() == true)
			neuerStatus = "OK";
		else if (radioButtonVerliehen.isSelected() == true)
			neuerStatus = "Verliehen";
		else if (radioButtonReparatur.isSelected() == true)
			neuerStatus = "Reparatur";
		else if (radioButtonDeaktiviert.isSelected() == true)
			neuerStatus = "Deaktiviert";
	}

	private void statusAendern() {
		holeStatus();

		geraet = String.valueOf(geraeteID);
		controller.anfrageGeraethinzufuegen(talking, geraet, neuerStatus, makel, verkaufspreis, anschaffungspreis,
				farbe, baujahr);
	}

	public void setGeraeteID(int id) {
		this.geraeteID = id;
		lblGeraeteID.setText(String.valueOf(geraeteID));
	}

	public void setModellID(int id) {
		this.modellID = id;
	}

	public void setStatus(String status) {
		this.status = status;
		if (status.equals("OK"))
			radioButtonOK.setSelected(true);
		if (status.equals("Verliehen"))
			radioButtonVerliehen.setSelected(true);
		if (status.equals("Reparatur"))
			radioButtonReparatur.setSelected(true);
		if (status.equals("Deaktiviert"))
			radioButtonDeaktiviert.setSelected(true);
	}

	@Override
	public void aktualisieren(IAnlegenModel model) {
		ArrayList<String> comboboxItems = model.getObertypen();
		lblModellname.setText(comboboxItems.get(0));
		comboboxItems.clear();
	}

	public void anfrage() {
		model.anmelden(this);
		talking = "modellname";
		controller.anfrageGeraethinzufuegen(talking, typ, modell, makel, verkaufspreis, anschaffungspreis, farbe,
				modellID);
		aktualisieren(model);
		model.abmelden(this);
	}
}
