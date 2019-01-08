 /*
  *  @author Michael Schmidt
  */
 
package com.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.GeraetAnlegenStrg;
import com.model.IAnlegenModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GeraetAendernGUI extends JPanel implements IAnlegenView{
	private JLabel lblGeraeteID;
	private JLabel lblModellname;
	private JTextField textAPreis;
	private JTextField textVPreis;
	private JTextField textFarbe;
	private JTextField textBaujahr;
	private JTextField textMakel;
	private JComboBox comboBoxStandort;
	
	private int geraeteID;
	private int modellID;
	private String typ;
	private String modell;
	private String geraet;
	private double anschaffungspreis;
	private double verkaufspreis;
	private String farbe;
	private int baujahr;
	private String makel;
	private int standortID;
	private String standort;
	private String talking = "first";
	
	IAnlegenModel model;
	GeraetAnlegenStrg controller;
	
	
	/**
	 * 
	 * Create the panel.
	 */
	public GeraetAendernGUI(IAnlegenModel models, GeraetAnlegenStrg controllers) {
		model = models;
		controller = controllers;
		
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGeraetAendern = new JLabel("Ger\u00E4t \u00E4ndern:");
		lblGeraetAendern.setForeground(Color.WHITE);
		lblGeraetAendern.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblGeraetAendern = new GridBagConstraints();
		gbc_lblGeraetAendern.anchor = GridBagConstraints.WEST;
		gbc_lblGeraetAendern.gridwidth = 2;
		gbc_lblGeraetAendern.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeraetAendern.gridx = 2;
		gbc_lblGeraetAendern.gridy = 2;
		panel.add(lblGeraetAendern, gbc_lblGeraetAendern);
		
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
		
		JLabel lblAnschaffungspreis = new JLabel("Anschaffungspreis:");
		lblAnschaffungspreis.setForeground(Color.WHITE);
		lblAnschaffungspreis.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblAnschaffungspreis = new GridBagConstraints();
		gbc_lblAnschaffungspreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnschaffungspreis.anchor = GridBagConstraints.WEST;
		gbc_lblAnschaffungspreis.gridx = 2;
		gbc_lblAnschaffungspreis.gridy = 10;
		panel.add(lblAnschaffungspreis, gbc_lblAnschaffungspreis);
		
		textAPreis = new JTextField();
		textAPreis.setPreferredSize(new Dimension(6, 40));
		textAPreis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtAPreis = new GridBagConstraints();
		gbc_txtAPreis.insets = new Insets(0, 0, 5, 5);
		gbc_txtAPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAPreis.gridx = 3;
		gbc_txtAPreis.gridy = 10;
		panel.add(textAPreis, gbc_txtAPreis);
		textAPreis.setColumns(10);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 10;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblVerkaufspreis = new JLabel("Verkaufspreis:");
		lblVerkaufspreis.setForeground(Color.WHITE);
		lblVerkaufspreis.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblVerkaufspreis = new GridBagConstraints();
		gbc_lblVerkaufspreis.anchor = GridBagConstraints.WEST;
		gbc_lblVerkaufspreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblVerkaufspreis.gridx = 2;
		gbc_lblVerkaufspreis.gridy = 11;
		panel.add(lblVerkaufspreis, gbc_lblVerkaufspreis);
		
		textVPreis = new JTextField();
		textVPreis.setPreferredSize(new Dimension(6, 40));
		textVPreis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textVPreis = new GridBagConstraints();
		gbc_textVPreis.insets = new Insets(0, 0, 5, 5);
		gbc_textVPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textVPreis.gridx = 3;
		gbc_textVPreis.gridy = 11;
		panel.add(textVPreis, gbc_textVPreis);
		textVPreis.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 11;
		panel.add(label, gbc_label);
		
		JLabel lblFarbe = new JLabel("Farbe:");
		lblFarbe.setForeground(Color.WHITE);
		lblFarbe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFarbe = new GridBagConstraints();
		gbc_lblFarbe.anchor = GridBagConstraints.WEST;
		gbc_lblFarbe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFarbe.gridx = 2;
		gbc_lblFarbe.gridy = 7;
		panel.add(lblFarbe, gbc_lblFarbe);
		
		textFarbe = new JTextField();
		textFarbe.setPreferredSize(new Dimension(6, 40));
		textFarbe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textFarbe = new GridBagConstraints();
		gbc_textFarbe.insets = new Insets(0, 0, 5, 5);
		gbc_textFarbe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFarbe.gridx = 3;
		gbc_textFarbe.gridy = 7;
		panel.add(textFarbe, gbc_textFarbe);
		textFarbe.setColumns(10);
		
		JLabel lblBaujahr = new JLabel("Baujahr:");
		lblBaujahr.setForeground(Color.WHITE);
		lblBaujahr.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblBaujahr = new GridBagConstraints();
		gbc_lblBaujahr.anchor = GridBagConstraints.WEST;
		gbc_lblBaujahr.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaujahr.gridx = 2;
		gbc_lblBaujahr.gridy = 8;
		panel.add(lblBaujahr, gbc_lblBaujahr);
		
		textBaujahr = new JTextField();
		textBaujahr.setPreferredSize(new Dimension(6, 40));
		textBaujahr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textBaujahr = new GridBagConstraints();
		gbc_textBaujahr.insets = new Insets(0, 0, 5, 5);
		gbc_textBaujahr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBaujahr.gridx = 3;
		gbc_textBaujahr.gridy = 8;
		panel.add(textBaujahr, gbc_textBaujahr);
		textBaujahr.setColumns(10);
		
		JLabel lblMakel = new JLabel("Makel:");
		lblMakel.setForeground(Color.WHITE);
		lblMakel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMakel = new GridBagConstraints();
		gbc_lblMakel.anchor = GridBagConstraints.WEST;
		gbc_lblMakel.insets = new Insets(0, 0, 5, 5);
		gbc_lblMakel.gridx = 2;
		gbc_lblMakel.gridy = 9;
		panel.add(lblMakel, gbc_lblMakel);
		
		textMakel = new JTextField();
		textMakel.setPreferredSize(new Dimension(6, 40));
		textMakel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textMakel = new GridBagConstraints();
		gbc_textMakel.insets = new Insets(0, 0, 5, 5);
		gbc_textMakel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMakel.gridx = 3;
		gbc_textMakel.gridy = 9;
		panel.add(textMakel, gbc_textMakel);
		textMakel.setColumns(10);
		
		JLabel lblStandortid = new JLabel("StandortID:");
		lblStandortid.setForeground(Color.WHITE);
		lblStandortid.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblStandortid = new GridBagConstraints();
		gbc_lblStandortid.anchor = GridBagConstraints.WEST;
		gbc_lblStandortid.insets = new Insets(0, 0, 0, 5);
		gbc_lblStandortid.gridx = 2;
		gbc_lblStandortid.gridy = 12;
		panel.add(lblStandortid, gbc_lblStandortid);
		
		comboBoxStandort = new JComboBox();
		comboBoxStandort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBoxStandort = new GridBagConstraints();
		gbc_comboBoxStandort.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxStandort.fill = GridBagConstraints.BOTH;
		gbc_comboBoxStandort.gridx = 3;
		gbc_comboBoxStandort.gridy = 12;
		panel.add(comboBoxStandort, gbc_comboBoxStandort);
		
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
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		
		

		
		//Funktionen der Button
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				talking = "aendern";
				
				try {
					if(textFarbe.getText().trim().isEmpty() || textBaujahr.getText().trim().isEmpty() || textAPreis.getText().trim().isEmpty() || textVPreis.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Füllen Sie alle Pflichtfelder aus!");
					}
					else{
						geraetAendern();
						
						JOptionPane.showMessageDialog(null, "Das Gerät wurde erfolgreich geändert!");
						MainFrame.change(MainFrame.getGeraetAendernGUI(), MainFrame.getSportgeraeteGUI());
						MainFrame.getSportgeraeteGUI().anfrage();
					}					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Das Gerät konnte nicht geändert werden");
				}
			}		
		}); 
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getSportgeraeteGUI().anfrage();
				MainFrame.change(MainFrame.getGeraetAendernGUI(), MainFrame.getSportgeraeteGUI());			}
		});
	}
	
	private void geraetAendern() {
		farbe = textFarbe.getText();
		makel = textMakel.getText();
		baujahr = Integer.parseInt(textBaujahr.getText());
		anschaffungspreis = Double.parseDouble(textAPreis.getText());
		verkaufspreis = Double.parseDouble(textVPreis.getText());
		standortID = Integer.parseInt(String.valueOf(comboBoxStandort.getSelectedItem()));
		String standort = String.valueOf(standortID);
		geraet = String.valueOf(geraeteID);
		controller.anfrageGeraethinzufuegen(talking, geraet, standort, makel, verkaufspreis, anschaffungspreis, farbe, baujahr);
	}
	
	public void setGeraeteID(int id){
		this.geraeteID = id;
		lblGeraeteID.setText(String.valueOf(geraeteID));
	}
	
	public void setModellID(int id){
		this.modellID = id;
	}
	
	public void setFarbe(String farbe){
		this.farbe = farbe;
		textFarbe.setText(farbe);
	}
	
	public void setMakel(String makel){
		this.makel = makel;
		textMakel.setText(makel);
	}
	
	public void setBaujahr(int baujahr){
		this.baujahr = baujahr;
		textBaujahr.setText(String.valueOf(baujahr));
	}
	
	public void setAnschaffungspreis(double apreis){
		this.anschaffungspreis = apreis;
		textAPreis.setText(String.valueOf(anschaffungspreis));
	}
	
	public void setVerkaufspreis(double vpreis){
		this.verkaufspreis = vpreis;
		textVPreis.setText(String.valueOf(verkaufspreis));
	}

	public void setStandort(int standortID){
		this.standortID = standortID;
		standort = String.valueOf(standortID);
	}

	@Override
	public void aktualisieren(IAnlegenModel model) {
		ArrayList<String> comboboxItems = model.getObertypen();
		if (talking.equals("standortID")){
			for(int i = 0; i < comboboxItems.size(); i++) {
				comboBoxStandort.addItem(comboboxItems.get(i));
			}
			comboBoxStandort.setSelectedItem(standort);
		}
		else if (talking.equals("modellname")){
			lblModellname.setText(comboboxItems.get(0));
		}
		comboboxItems.clear();
	}
	
	public void anfrage() {
		comboBoxStandort.removeAllItems();
		model.anmelden(this);
		talking = "standortID";
		controller.anfrageGeraethinzufuegen(talking, typ, modell, makel, verkaufspreis, anschaffungspreis, farbe, baujahr);
		aktualisieren(model);
		talking = "modellname";
		controller.anfrageGeraethinzufuegen(talking, typ, modell, makel, verkaufspreis, anschaffungspreis, farbe, modellID);
		aktualisieren(model);
		model.abmelden(this);		
	}
}