package GUI;

import javax.swing.JPanel;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Modellhinzufuegen extends JPanel  implements IAnlegenView{
	private JTextField txtModelID;
	private JTextField txtModell;
	
	ModellAnlegenModel model;
	ModellAnlegenStrg controller;

	/**
	 * 
	 * Create the panel.
	 */
	public Modellhinzufuegen() {
		model = new ModellAnlegenModel();
		controller = new ModellAnlegenStrg(model);
		model.anmelden(this);
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		
		String[]typen ={"Segelboot", "Surfboard", "Kajak", "Jetski", "Motorboot"};
		JComboBox <String> comboBoxTyp = new JComboBox<String>(typen);	
		
		
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
		
		JLabel lblModellID = new JLabel("ModellID:");
		lblModellID.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblModellID = new GridBagConstraints();
		gbc_lblModellID.anchor = GridBagConstraints.WEST;
		gbc_lblModellID.insets = new Insets(0, 0, 5, 5);
		gbc_lblModellID.gridx = 2;
		gbc_lblModellID.gridy = 7;
		panel.add(lblModellID, gbc_lblModellID);
		
		txtModelID = new JTextField();
		txtModelID.setPreferredSize(new Dimension(6, 40));
		txtModelID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtModelID = new GridBagConstraints();
		gbc_txtModelID.insets = new Insets(0, 0, 5, 5);
		gbc_txtModelID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModelID.gridx = 3;
		gbc_txtModelID.gridy = 7;
		panel.add(txtModelID, gbc_txtModelID);
		txtModelID.setColumns(10);
		
		JLabel lblPreiskateg = new JLabel("Preiskategorie:");
		lblPreiskateg.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblPreiskateg = new GridBagConstraints();
		gbc_lblPreiskateg.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreiskateg.anchor = GridBagConstraints.EAST;
		gbc_lblPreiskateg.gridx = 2;
		gbc_lblPreiskateg.gridy = 8;
		panel.add(lblPreiskateg, gbc_lblPreiskateg);
		
		JComboBox comboBoxPreis = new JComboBox();
		comboBoxPreis.addItem("1 (Segelboot)");
		comboBoxPreis.addItem("2 (Surfboard - A)");
		comboBoxPreis.addItem("3 (Surfboard - B)");
		comboBoxPreis.addItem("4 (Surfboard - C)");
		comboBoxPreis.addItem("5 (Kajakt)");
		comboBoxPreis.addItem("6 (Jetski)");
		comboBoxPreis.addItem("7 (Motorboot)");
		
		GridBagConstraints gbc_comboBoxPreis = new GridBagConstraints();
		gbc_comboBoxPreis.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPreis.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPreis.gridx = 3;
		gbc_comboBoxPreis.gridy = 8;
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
				String typ;
				int modellID;
				String name;
				int preisKateg;
				
				try {
					typ = String.valueOf(comboBoxTyp.getSelectedItem());
					name = txtModell.getText();
					modellID = Integer.parseInt(txtModelID.getText());
					preisKateg = comboBoxPreis.getSelectedIndex() +1;
					

					controller.modellUebergeben(modellID, name, typ, preisKateg);
					aktualisieren(model);
					JOptionPane.showMessageDialog(null, "Das Modell wurde erfolgreich angelegt!");
					MainFrame.change(MainFrame.getModellhinzufuegen(), MainFrame.getGeraeteModellVerwaltung());
					
					
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

	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
		
	}
}
