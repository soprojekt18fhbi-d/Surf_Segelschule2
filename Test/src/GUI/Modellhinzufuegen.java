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

public class Modellhinzufuegen extends JPanel implements IAnlegenView{
	private JTextField txtModell;
	
	IAnlegenModel model;
	ModellAnlegenStrg controller;
	private String talking = "first";
	private JComboBox<String> comboBoxTyp;
	private JComboBox comboBoxPreis;
	private String typ;
	private String name;
	private String preisKateg;
	private int preisID;
	
	
	/**
	 * 
	 * Create the panel.
	 */
	public Modellhinzufuegen(IAnlegenModel models, ModellAnlegenStrg controllers) {
		
		model = models;
		controller = controllers;
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblModellHinzufgen = new JLabel("Modell hinzuf\u00FCgen:");
		lblModellHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblModellHinzufgen = new GridBagConstraints();
		gbc_lblModellHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblModellHinzufgen.gridwidth = 2;
		gbc_lblModellHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellHinzufgen.gridx = 2;
		gbc_lblModellHinzufgen.gridy = 2;
		panel.add(lblModellHinzufgen, gbc_lblModellHinzufgen);
		
		JLabel lblTyp = new JLabel("Typ:");
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
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnBestaetigen = new JButton("best\u00E4tigen");
		btnBestaetigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
					preisKateg = String.valueOf(comboBoxPreis.getSelectedItem());
					int preisID;
					if (preisKateg == "1 (Kayak)")
						preisID = 1;
					else if (preisKateg == "2 (Segelboot)")
						preisID = 2;	
					else if (preisKateg == "3 (Motorboot)")
						preisID = 3;
					else if (preisKateg == "4 (Surfboard - A)")
						preisID = 4;
					else if (preisKateg == "5 (Surfboard - B)")
						preisID = 5;
					else if (preisKateg == "6 (Surfboard - C)")
						preisID = 6;
					else 
						preisID = 7;
					
					
					controller.anfrageModellhinzufuegen(talking, name, typ, preisID);						
					aktualisieren(model);
					JOptionPane.showMessageDialog(null, "Das Modell wurde erfolgreich angelegt!");
					MainFrame.change(MainFrame.getModellhinzufuegen(), MainFrame.getGeraeteModellVerwaltung());
					
					txtModell.setText("");
					comboBoxTyp.setSelectedIndex(0);
					comboBoxPreis.setSelectedIndex(0);
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Modell konnte nicht angelegt werden");
				}
				
			}
		}); 
		
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getModellhinzufuegen(), MainFrame.getGeraeteModellVerwaltung());			}
		});
		
		comboBoxTyp.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0) {
				String value = String.valueOf(comboBoxTyp.getSelectedItem());
				comboBoxPreis.removeAllItems();
				switch(value){
					case "Kayak": {
						comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("1 (Kayak)");
						break;
					}
					case "Segelboot": {
						comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("2 (Segelboot)");
						break;
					}
					case "Motorboot": {
						comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("3 (Motorboot)");
						break;
					}
					case "Surfboard": {
						comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("4 (Surfboard - A)");
						comboBoxPreis.addItem("5 (Surfboard - B)");
						comboBoxPreis.addItem("6 (Surfboard - C)");
						break;
					}
					case "Jetski": {
						comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("7 (Jetski)");
						break;
					}
					default: {
					    comboBoxPreis.removeAllItems();
						comboBoxPreis.addItem("1 (Kayak)");
						comboBoxPreis.addItem("2 (Segelboot)");
						comboBoxPreis.addItem("3 (Motorboot)");
						comboBoxPreis.addItem("4 (Surfboard - A)");
						comboBoxPreis.addItem("5 (Surfboard - B)");
						comboBoxPreis.addItem("6 (Surfboard - C)");
						comboBoxPreis.addItem("7 (Jetski)");
						break;
					}
				
				}
			}
			
		});
		
	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
		
		ArrayList<String> comboboxItems = model.getObertypen();
		
		for(int i = 0; i < comboboxItems.size(); i++) {
			comboBoxTyp.addItem(comboboxItems.get(i));
		}
		comboboxItems.clear();
	}
	
	public void anfrage() {
		comboBoxTyp.removeAllItems();
		model.anmelden(this);
		controller.anfrageModellhinzufuegen(talking, name, typ, preisID);
		model.abmelden(this);
		
	}
	
}
