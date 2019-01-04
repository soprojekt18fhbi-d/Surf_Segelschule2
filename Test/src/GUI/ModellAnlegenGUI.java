 /*
  *  @author Michael Schmidt
  */

package GUI;

import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IAnlegenModel;
import Datenbankmodels.ModellAnlegenModel;
import Datenbankmodels.TypAnlegenModel;
import Steuerung.ModellAnlegenStrg;
import Steuerung.TypAnlegenStrg;
import javafx.scene.control.ComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class ModellAnlegenGUI extends JPanel implements IAnlegenView{
	private JTextField txtModell;
	
	IAnlegenModel model;
	ModellAnlegenStrg controller;
	private String talking = "first";
	private JComboBox<String> comboBoxTyp;
	private JComboBox comboBoxPreis;
	private String typ;
	private String name;
	private int preisID;
	int id;
	
	
	/**
	 * 
	 * Create the panel.
	 */
	public ModellAnlegenGUI(IAnlegenModel models, ModellAnlegenStrg controllers) {
		
		model = models;
		controller = controllers;
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblModellHinzufgen = new JLabel("Modell hinzuf\u00FCgen:");
		lblModellHinzufgen.setForeground(Color.WHITE);
		lblModellHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblModellHinzufgen = new GridBagConstraints();
		gbc_lblModellHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblModellHinzufgen.gridwidth = 2;
		gbc_lblModellHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellHinzufgen.gridx = 2;
		gbc_lblModellHinzufgen.gridy = 2;
		panel.add(lblModellHinzufgen, gbc_lblModellHinzufgen);
		
		JLabel lblTyp = new JLabel("Typ:");
		lblTyp.setForeground(Color.WHITE);
		lblTyp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTyp = new GridBagConstraints();
		gbc_lblTyp.anchor = GridBagConstraints.WEST;
		gbc_lblTyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyp.gridx = 2;
		gbc_lblTyp.gridy = 4;
		panel.add(lblTyp, gbc_lblTyp);
		
		
		comboBoxTyp = new JComboBox<String>();
		comboBoxTyp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		

				
		
		GridBagConstraints gbc_comboBoxTyp = new GridBagConstraints();
		gbc_comboBoxTyp.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTyp.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTyp.gridx = 3;
		gbc_comboBoxTyp.gridy = 4;
		panel.add(comboBoxTyp, gbc_comboBoxTyp);
		
		JLabel lblModellname = new JLabel("Modellname:");
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
		
		JLabel lblPreiskateg = new JLabel("Preiskategorie:");
		lblPreiskateg.setForeground(Color.WHITE);
		lblPreiskateg.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblPreiskateg = new GridBagConstraints();
		gbc_lblPreiskateg.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreiskateg.anchor = GridBagConstraints.EAST;
		gbc_lblPreiskateg.gridx = 2;
		gbc_lblPreiskateg.gridy = 7;
		panel.add(lblPreiskateg, gbc_lblPreiskateg);
		
		comboBoxPreis = new JComboBox();
		comboBoxPreis.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		GridBagConstraints gbc_comboBoxPreis = new GridBagConstraints();
		gbc_comboBoxPreis.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPreis.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPreis.gridx = 3;
		gbc_comboBoxPreis.gridy = 7;
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
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(573, Short.MAX_VALUE)
					.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		

		
		
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				talking = "hinzufuegen";
				
				try {
					typ = String.valueOf(comboBoxTyp.getSelectedItem());
					name = txtModell.getText();
					preisID = Integer.parseInt(String.valueOf(comboBoxPreis.getSelectedItem()));
										
					
					controller.anfrageModellhinzufuegen(talking, name, typ, preisID, id);						
					aktualisieren(model);
					JOptionPane.showMessageDialog(null, "Das Modell wurde erfolgreich angelegt!");
					MainFrame.change(MainFrame.getModellAnlegenGUI(), MainFrame.getGeraeteModellVerwaltungGUIGUI());
					MainFrame.getGeraeteModellVerwaltungGUIGUI().anfrage();
					
					txtModell.setText("");
					comboBoxTyp.setSelectedIndex(0);
					comboBoxPreis.setSelectedIndex(0);
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Das Modell konnte nicht angelegt werden");
				}
				
			}
		}); 
		
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getGeraeteModellVerwaltungGUIGUI().anfrage();
				MainFrame.change(MainFrame.getModellAnlegenGUI(), MainFrame.getGeraeteModellVerwaltungGUIGUI());			}
		});
		
		
	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
		
		ArrayList<String> comboboxItems = model.getObertypen();
		if (talking == "first"){
			for(int i = 0; i < comboboxItems.size(); i++) {
				comboBoxTyp.addItem(comboboxItems.get(i));
			}
		}
		else if (talking == "second"){
			for(int i = 0; i < comboboxItems.size(); i++) {
				comboBoxPreis.addItem(comboboxItems.get(i));
			}
		}
		comboboxItems.clear();
	}
	
	public void anfrage() {
		talking = "first";
		comboBoxTyp.removeAllItems();
		model.anmelden(this);
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID, id);
		talking = "second";
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID, id);
		model.abmelden(this);
		
	}
	
}
