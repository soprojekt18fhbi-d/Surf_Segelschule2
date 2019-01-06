 /*
  *  @author Michael Schmidt
  */

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IAnlegenModel;
import Steuerung.GeraetAnlegenStrg;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GeraeteReparaturGUI extends JPanel implements IAnlegenView{
	IAnlegenModel model;
	GeraetAnlegenStrg controller;

	private JLabel lblModellname;
	private JLabel lblGeraeteID;
	private JTextField txtKosten;
	
	private int modellID;
	private int geraeteID;
	private String status;
	private String talking;
	private String modell;
	private String makel;
	private String farbe;
	private String typ;
	private int baujahr;
	private double anschaffungspreis;
	private double verkaufspreis;	
	private JTextField txtBeschreibung;

	/**
	 * Create the panel.
	 */
	public GeraeteReparaturGUI(IAnlegenModel models, GeraetAnlegenStrg controllers) {
		model = models;
		controller = controllers;		
		
		setSize(980,580);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.1, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblReparatur = new JLabel("Reparatur erfassen:");
		lblReparatur.setForeground(Color.WHITE);
		lblReparatur.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblReparatur = new GridBagConstraints();
		gbc_lblReparatur.anchor = GridBagConstraints.WEST;
		gbc_lblReparatur.gridwidth = 2;
		gbc_lblReparatur.insets = new Insets(0, 0, 5, 5);
		gbc_lblReparatur.gridx = 2;
		gbc_lblReparatur.gridy = 2;
		panel.add(lblReparatur, gbc_lblReparatur);
		
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
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBeschreibung.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.anchor = GridBagConstraints.WEST;
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 2;
		gbc_lblBeschreibung.gridy = 7;
		panel.add(lblBeschreibung, gbc_lblBeschreibung);
		
		txtBeschreibung = new JTextField();
		txtBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtBeschreibung = new GridBagConstraints();
		gbc_txtBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_txtBeschreibung.fill = GridBagConstraints.BOTH;
		gbc_txtBeschreibung.gridx = 3;
		gbc_txtBeschreibung.gridy = 7;
		panel.add(txtBeschreibung, gbc_txtBeschreibung);
		txtBeschreibung.setColumns(10);
		
		JLabel lblKosten = new JLabel("Kosten:");
		lblKosten.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblKosten.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblKosten = new GridBagConstraints();
		gbc_lblKosten.anchor = GridBagConstraints.WEST;
		gbc_lblKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten.gridx = 2;
		gbc_lblKosten.gridy = 8;
		panel.add(lblKosten, gbc_lblKosten);
		
		txtKosten = new JTextField();
		txtKosten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtKosten = new GridBagConstraints();
		gbc_txtKosten.insets = new Insets(0, 0, 5, 5);
		gbc_txtKosten.fill = GridBagConstraints.BOTH;
		gbc_txtKosten.gridx = 3;
		gbc_txtKosten.gridy = 8;
		panel.add(txtKosten, gbc_txtKosten);
		txtKosten.setColumns(10);
		
		JLabel lblE = new JLabel("\u20AC");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 4;
		gbc_lblE.gridy = 8;
		panel.add(lblE, gbc_lblE);
		
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
				try {
					if(txtBeschreibung.getText().trim().isEmpty() || txtKosten.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Füllen Sie alle Felder aus!");
					}
					else{
						statusAendern();
						reparaturAnlegen();
											
						JOptionPane.showMessageDialog(null, "Der Status wurde geändert und die Reparatur wurde erfolgreich angelegt!");
						MainFrame.change(MainFrame.getGeraeteReparaturGUI(), MainFrame.getSportgeraeteGUI());
						MainFrame.getSportgeraeteGUI().anfrage();
					}		
					txtBeschreibung.setText("");
					txtKosten.setText("");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Geben Sie einen gültigen Wert für die Kosten ein!");
				}
			}

			
		}); 
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getSportgeraeteGUI().anfrage();
				MainFrame.change(MainFrame.getGeraeteReparaturGUI(), MainFrame.getSportgeraeteGUI());
				txtBeschreibung.setText("");
				txtKosten.setText("");
			}
		});

		
	}
	private void statusAendern() {
		talking = "status"; 		
		String geraet = String.valueOf(geraeteID);
		controller.anfrageGeraethinzufuegen(talking, geraet, status, makel, verkaufspreis, anschaffungspreis, farbe, baujahr);
	}
	
	private void reparaturAnlegen() {
		talking = "reparatur";
		String beschreibung = String.valueOf(txtBeschreibung.getText());
		double kosten = Double.parseDouble(String.valueOf(txtKosten.getText()));
		String geraet = String.valueOf(geraeteID);										
		controller.anfrageGeraethinzufuegen(talking, typ, geraet, beschreibung, kosten, anschaffungspreis, farbe, modellID);
	}
	
	public void setGeraeteID(int id){
		this.geraeteID = id;
		lblGeraeteID.setText(String.valueOf(geraeteID));
	}
	
	public void setModellID(int id){
		this.modellID = id;
	}
	
	public void setStatus(String status){
		this.status = status;
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
		controller.anfrageGeraethinzufuegen(talking, typ, modell, makel, verkaufspreis, anschaffungspreis, farbe, modellID);
		aktualisieren(model);
		model.abmelden(this);		
	}

}
