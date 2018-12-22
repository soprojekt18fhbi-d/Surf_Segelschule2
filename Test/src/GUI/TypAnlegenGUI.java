package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IAnlegenModel;
import Datenbankmodels.IModel;
import Datenbankmodels.KundeAnlegenModel;
import Datenbankmodels.TypAnlegenModel;
import Steuerung.KundeAnlegenStrg;
import Steuerung.TypAnlegenStrg;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class TypAnlegenGUI extends JPanel  implements IAnlegenView{
	private JTextField txtTyp;
	
	TypAnlegenModel model;
	TypAnlegenStrg controller;


	/**
	 * 
	 * Create the panel.
	 */
	public TypAnlegenGUI() {
		model = new TypAnlegenModel();
		controller = new TypAnlegenStrg(model);
		model.anmelden(this);
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTypHinzufgen = new JLabel("Typ hinzuf\u00FCgen:");
		lblTypHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblTypHinzufgen = new GridBagConstraints();
		gbc_lblTypHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblTypHinzufgen.gridwidth = 2;
		gbc_lblTypHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypHinzufgen.gridx = 2;
		gbc_lblTypHinzufgen.gridy = 2;
		panel.add(lblTypHinzufgen, gbc_lblTypHinzufgen);
		
		JLabel lblTyp = new JLabel("Typ:");
		lblTyp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTyp = new GridBagConstraints();
		gbc_lblTyp.anchor = GridBagConstraints.WEST;
		gbc_lblTyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyp.gridx = 2;
		gbc_lblTyp.gridy = 4;
		panel.add(lblTyp, gbc_lblTyp);
		
		txtTyp = new JTextField();
		txtTyp.setPreferredSize(new Dimension(6, 40));
		txtTyp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtTyp2 = new GridBagConstraints();
		gbc_txtTyp2.insets = new Insets(0, 0, 5, 5);
		gbc_txtTyp2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTyp2.gridx = 3;
		gbc_txtTyp2.gridy = 4;
		panel.add(txtTyp, gbc_txtTyp2);
		txtTyp.setColumns(10);
		
		JLabel lblErforderlicherFhrerschein = new JLabel("erforderlicher F\u00FChrerschein:");
		lblErforderlicherFhrerschein.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblErforderlicherFhrerschein = new GridBagConstraints();
		gbc_lblErforderlicherFhrerschein.insets = new Insets(0, 0, 5, 5);
		gbc_lblErforderlicherFhrerschein.anchor = GridBagConstraints.WEST;
		gbc_lblErforderlicherFhrerschein.gridwidth = 2;
		gbc_lblErforderlicherFhrerschein.gridx = 2;
		gbc_lblErforderlicherFhrerschein.gridy = 6;
		panel.add(lblErforderlicherFhrerschein, gbc_lblErforderlicherFhrerschein);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		chckbxSegelschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSegelschein.gridx = 2;
		gbc_chckbxSegelschein.gridy = 7;
		panel.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
		chckbxSurfschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSurfschein.gridx = 3;
		gbc_chckbxSurfschein.gridy = 7;
		panel.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		chckbxMotorbootschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.gridx = 4;
		gbc_chckbxMotorbootschein.gridy = 7;
		panel.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
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
				int id;
				String name;
				String schein;
				
				try {
					
					name = txtTyp.getText();					
					
					if(chckbxSegelschein.isSelected() == true)
						schein = "Segelschein";
					else if(chckbxSurfschein.isSelected() == true)
						schein = "Surfschein";
					else if(chckbxMotorbootschein.isSelected() == true)
						schein = "Motorbootschein";
					else
						schein = null;
					

					controller.typUebergeben(name, schein);
					aktualisieren(model);
					MainFrame.change(MainFrame.getTypAnlegenGUI(), MainFrame.getGeraeteTypVerwaltung());
					MainFrame.getGeraeteTypVerwaltung().anfrage();
					
					chckbxSegelschein.setSelected(false);
					chckbxSurfschein.setSelected(false);
					chckbxMotorbootschein.setSelected(false);
					txtTyp.setText("");
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getTypAnlegenGUI(), MainFrame.getGeraeteTypVerwaltung());			}
		});

	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
		JOptionPane.showMessageDialog(null, "Der Gerätetyp wurde angelegt!");
	}
}
