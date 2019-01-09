// @author Darnel / Ben Kröncke

package com.view;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controller.IController;
import com.controller.WirtschaftlichkeitStrg;
import com.model.IObjektModel;
import com.model.IWirtschaftlichkeitModel;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;

public class WirtschaftlichkeitsverwaltungGUI extends JPanel implements IWirtschaftlichkeitView { // Ben Kröncke

	private String talking = "category";
	private String mode = "Unternehmen";
	private int id;
	private String giveString = "";
	private JTextField txtIncome;
	private JTextField txtExpenses;
	private JTextField txtProfit;
	private JComboBox<String> cboxSpec;
	private IWirtschaftlichkeitModel model;
	private WirtschaftlichkeitStrg controller;

	public WirtschaftlichkeitsverwaltungGUI(IWirtschaftlichkeitModel models, WirtschaftlichkeitStrg controllers) {

		model = models;
		controller = controllers;

		setSize(980, 580);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton zrckButton = new JButton("Zur\u00FCck");
		zrckButton.setBackground(new Color(255, 140, 0));
		zrckButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(zrckButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(300, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addComponent(zrckButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.1, 0.5, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblWirtschaftlichkeit = new JLabel("Wirtschaftlichkeit");
		lblWirtschaftlichkeit.setForeground(new Color(255, 140, 0));
		lblWirtschaftlichkeit.setFont(new Font("Tahoma", Font.BOLD, 52));
		GridBagConstraints gbc_lblWirtschaftlichkeit = new GridBagConstraints();
		gbc_lblWirtschaftlichkeit.gridwidth = 5;
		gbc_lblWirtschaftlichkeit.insets = new Insets(0, 0, 5, 0);
		gbc_lblWirtschaftlichkeit.gridx = 0;
		gbc_lblWirtschaftlichkeit.gridy = 1;
		panel_1.add(lblWirtschaftlichkeit, gbc_lblWirtschaftlichkeit);

		JLabel lblKategorieWhlen = new JLabel("Kategorie w\u00E4hlen:");
		lblKategorieWhlen.setForeground(Color.WHITE);
		lblKategorieWhlen.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblKategorieWhlen = new GridBagConstraints();
		gbc_lblKategorieWhlen.insets = new Insets(0, 0, 5, 5);
		gbc_lblKategorieWhlen.anchor = GridBagConstraints.WEST;
		gbc_lblKategorieWhlen.gridx = 1;
		gbc_lblKategorieWhlen.gridy = 3;
		panel_1.add(lblKategorieWhlen, gbc_lblKategorieWhlen);

		JComboBox cboxKateg = new JComboBox();
		cboxKateg.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_cboxKateg = new GridBagConstraints();
		gbc_cboxKateg.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboxKateg.insets = new Insets(0, 0, 5, 5);
		gbc_cboxKateg.gridx = 2;
		gbc_cboxKateg.gridy = 3;
		panel_1.add(cboxKateg, gbc_cboxKateg);
		cboxKateg.setModel(
				new DefaultComboBoxModel(new String[] { "Unternehmen", "Standort", "Typ", "Modell", "Sportgeraet" }));

		JLabel lblSpezifizieren = new JLabel("Spezifizieren:");
		lblSpezifizieren.setForeground(Color.WHITE);
		lblSpezifizieren.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblSpezifizieren = new GridBagConstraints();
		gbc_lblSpezifizieren.anchor = GridBagConstraints.WEST;
		gbc_lblSpezifizieren.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpezifizieren.gridx = 1;
		gbc_lblSpezifizieren.gridy = 4;
		panel_1.add(lblSpezifizieren, gbc_lblSpezifizieren);

		cboxSpec = new JComboBox();
		cboxSpec.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_cboxSpec = new GridBagConstraints();
		gbc_cboxSpec.insets = new Insets(0, 0, 5, 5);
		gbc_cboxSpec.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboxSpec.gridx = 2;
		gbc_cboxSpec.gridy = 4;
		panel_1.add(cboxSpec, gbc_cboxSpec);

		JButton buttonCalc = new JButton("Berechnen");
		buttonCalc.setBackground(new Color(255, 140, 0));
		buttonCalc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_buttonCalc = new GridBagConstraints();
		gbc_buttonCalc.anchor = GridBagConstraints.EAST;
		gbc_buttonCalc.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCalc.gridx = 2;
		gbc_buttonCalc.gridy = 5;
		panel_1.add(buttonCalc, gbc_buttonCalc);

		JLabel lblEinnahmen = new JLabel("Einnahmen:");
		lblEinnahmen.setForeground(Color.GREEN);
		lblEinnahmen.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblEinnahmen = new GridBagConstraints();
		gbc_lblEinnahmen.anchor = GridBagConstraints.WEST;
		gbc_lblEinnahmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblEinnahmen.gridx = 1;
		gbc_lblEinnahmen.gridy = 7;
		panel_1.add(lblEinnahmen, gbc_lblEinnahmen);

		txtIncome = new JTextField();
		txtIncome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_txtIncome = new GridBagConstraints();
		gbc_txtIncome.insets = new Insets(0, 0, 5, 5);
		gbc_txtIncome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIncome.gridx = 2;
		gbc_txtIncome.gridy = 7;
		panel_1.add(txtIncome, gbc_txtIncome);
		txtIncome.setColumns(10);
		txtIncome.setEditable(false);

		JLabel label = new JLabel("\u20AC");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 7;
		panel_1.add(label, gbc_label);

		JLabel lblAusgaben = new JLabel("Ausgaben:");
		lblAusgaben.setForeground(Color.RED);
		lblAusgaben.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblAusgaben = new GridBagConstraints();
		gbc_lblAusgaben.anchor = GridBagConstraints.WEST;
		gbc_lblAusgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAusgaben.gridx = 1;
		gbc_lblAusgaben.gridy = 8;
		panel_1.add(lblAusgaben, gbc_lblAusgaben);

		txtExpenses = new JTextField();
		txtExpenses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_txtExpenses = new GridBagConstraints();
		gbc_txtExpenses.insets = new Insets(0, 0, 5, 5);
		gbc_txtExpenses.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtExpenses.gridx = 2;
		gbc_txtExpenses.gridy = 8;
		panel_1.add(txtExpenses, gbc_txtExpenses);
		txtExpenses.setColumns(10);
		txtExpenses.setEditable(false);

		JLabel label_1 = new JLabel("\u20AC");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 8;
		panel_1.add(label_1, gbc_label_1);

		JLabel lblRohgewinn = new JLabel("Rohgewinn:");
		lblRohgewinn.setForeground(Color.WHITE);
		lblRohgewinn.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblRohgewinn = new GridBagConstraints();
		gbc_lblRohgewinn.anchor = GridBagConstraints.WEST;
		gbc_lblRohgewinn.insets = new Insets(0, 0, 5, 5);
		gbc_lblRohgewinn.gridx = 1;
		gbc_lblRohgewinn.gridy = 9;
		panel_1.add(lblRohgewinn, gbc_lblRohgewinn);

		txtProfit = new JTextField();
		txtProfit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_txtProfit = new GridBagConstraints();
		gbc_txtProfit.insets = new Insets(0, 0, 5, 5);
		gbc_txtProfit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProfit.gridx = 2;
		gbc_txtProfit.gridy = 9;
		panel_1.add(txtProfit, gbc_txtProfit);
		txtProfit.setColumns(10);
		txtProfit.setEditable(false);

		JLabel label_2 = new JLabel("\u20AC");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 9;
		panel_1.add(label_2, gbc_label_2);

		cboxKateg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) throws NumberFormatException {

				try {
					talking = "category";
					mode = cboxKateg.getSelectedItem().toString();
					anfrage();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		zrckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					MainFrame.change(MainFrame.getWirtschaftlichkeitsverwaltungGUI(), MainFrame.getHauptmenueGUI());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		buttonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (mode.equals("Unternehmen") == false && mode.equals("Sportgeraet") == false)
						giveString = cboxSpec.getSelectedItem().toString();

					if (mode.equals("Sportgeraet")) {
						boolean number = false;
						number = getSportID(cboxKateg, number);
					}
					talking = "calc";
					anfrage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private boolean getSportID(JComboBox cboxKateg, boolean number) {
				while (number == false) {
					try {
						if (cboxKateg.getSelectedItem().equals("Sportgeraet")) {
							id = Integer.parseInt(JOptionPane.showInputDialog("Bitte Artikelnummer (ID) eingeben!"));
							number = true;
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Das ist keine gültige Zahl!");
					}
				}
				return number;
			}
		});
	}

	@Override
	public void aktualisieren(IWirtschaftlichkeitModel model) {
		// TODO Auto-generated method stub
		if (talking.equals("category")) {
			cboxSpec.removeAllItems();

			for (int i = 0; i < model.getStrings().size(); i++) {
				cboxSpec.addItem(model.getStrings().get(i));
			}
		}

		else if (talking.equals("calc")) {
			txtIncome.setText("" + roundDouble(model.getIncome()));
			txtExpenses.setText("" + roundDouble(model.getExpenses()));
			txtProfit.setText("" + roundDouble(
					(Double.parseDouble(txtIncome.getText()) - (Double.parseDouble(txtExpenses.getText())))));

		}
	}

	public double roundDouble(double value) {

		try {
			int r = (int) Math.round(value * 100);
			value = r / 100.00;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	private void anfrage() {
		model.anmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
		controller.holeDaten(talking, mode, id, giveString);
		model.abmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
	}

}
