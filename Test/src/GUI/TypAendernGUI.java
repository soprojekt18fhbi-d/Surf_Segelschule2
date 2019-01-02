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
import Datenbankmodels.TypAnlegenModel;
import Domaenklassen.GeraeteTyp;
import Domaenklassen.IKunde;
import Steuerung.TypAnlegenStrg;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TypAendernGUI extends JPanel  implements IAnlegenView{
	private JTextField txtTyp;
	private JLabel label;
	private GeraeteTyp typ = null;
	JCheckBox chckbxSegelschein;
	JCheckBox chckbxSurfschein;
	JCheckBox chckbxMotorbootschein;
	private String talking = "aendern";
	
	TypAnlegenModel model;
	TypAnlegenStrg controller;


	/**
	 * 
	 * Create the panel.
	 */
	public TypAendernGUI() {
		model = new TypAnlegenModel();
		controller = new TypAnlegenStrg(model);
		model.anmelden(this);
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTypHinzufgen = new JLabel("Typ ändern:");
		lblTypHinzufgen.setForeground(Color.WHITE);
		lblTypHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblTypHinzufgen = new GridBagConstraints();
		gbc_lblTypHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblTypHinzufgen.gridwidth = 2;
		gbc_lblTypHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypHinzufgen.gridx = 2;
		gbc_lblTypHinzufgen.gridy = 2;
		panel.add(lblTypHinzufgen, gbc_lblTypHinzufgen);
		
		JLabel lblTyp_1 = new JLabel("Typ:");
		lblTyp_1.setForeground(Color.WHITE);
		lblTyp_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTyp_1 = new GridBagConstraints();
		gbc_lblTyp_1.anchor = GridBagConstraints.WEST;
		gbc_lblTyp_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyp_1.gridx = 2;
		gbc_lblTyp_1.gridy = 4;
		panel.add(lblTyp_1, gbc_lblTyp_1);
		
		label = new JLabel(""); 
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 1;
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 4;
		panel.add(label, gbc_label);
		
		JLabel lblNeuerTyp = new JLabel("neuer Typname:        ");
		lblNeuerTyp.setForeground(Color.WHITE);
		lblNeuerTyp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblNeuerTyp = new GridBagConstraints();
		gbc_lblNeuerTyp.anchor = GridBagConstraints.WEST;
		gbc_lblNeuerTyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblNeuerTyp.gridx = 2;
		gbc_lblNeuerTyp.gridy = 5;
		panel.add(lblNeuerTyp, gbc_lblNeuerTyp);
		
		txtTyp = new JTextField();
		txtTyp.setPreferredSize(new Dimension(6, 40));
		txtTyp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtTyp2 = new GridBagConstraints();
		gbc_txtTyp2.insets = new Insets(0, 0, 5, 5);
		gbc_txtTyp2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTyp2.gridx = 3;
		gbc_txtTyp2.gridy = 5;
		panel.add(txtTyp, gbc_txtTyp2);
		txtTyp.setColumns(10);
		
		JLabel lblErforderlicherFhrerschein = new JLabel("erforderlicher F\u00FChrerschein:");
		lblErforderlicherFhrerschein.setForeground(Color.WHITE);
		lblErforderlicherFhrerschein.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblErforderlicherFhrerschein = new GridBagConstraints();
		gbc_lblErforderlicherFhrerschein.insets = new Insets(0, 0, 5, 5);
		gbc_lblErforderlicherFhrerschein.anchor = GridBagConstraints.WEST;
		gbc_lblErforderlicherFhrerschein.gridwidth = 2;
		gbc_lblErforderlicherFhrerschein.gridx = 2;
		gbc_lblErforderlicherFhrerschein.gridy = 7;
		panel.add(lblErforderlicherFhrerschein, gbc_lblErforderlicherFhrerschein);
		
		chckbxSegelschein = new JCheckBox("Segelschein");
		chckbxSegelschein.setBackground(Color.DARK_GRAY);
		chckbxSegelschein.setForeground(Color.WHITE);
		chckbxSegelschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSegelschein.gridx = 2;
		gbc_chckbxSegelschein.gridy = 8;
		panel.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		chckbxSurfschein = new JCheckBox("Surfschein       ");
		chckbxSurfschein.setForeground(Color.WHITE);
		chckbxSurfschein.setBackground(Color.DARK_GRAY);
		chckbxSurfschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSurfschein.gridx = 3;
		gbc_chckbxSurfschein.gridy = 8;
		panel.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		chckbxMotorbootschein.setBackground(Color.DARK_GRAY);
		chckbxMotorbootschein.setForeground(Color.WHITE);
		chckbxMotorbootschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMotorbootschein.gridx = 4;
		gbc_chckbxMotorbootschein.gridy = 8;
		panel.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnBestaetigen = new JButton("best\u00E4tigen");
		btnBestaetigen.setBackground(new Color(255, 140, 0));
		btnBestaetigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setBackground(new Color(255, 140, 0));
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
				String name;
				String schein;
				int id = typ.getTypID();
				name = txtTyp.getText();
				
				if(name.equals(""))
					name = label.getText();
				
				if (chckbxSegelschein.isSelected() == true)
					schein = "Segelschein";
				else if(chckbxSurfschein.isSelected() == true)
					schein = "Surfschein";
				else if(chckbxSurfschein.isSelected() == true)
					schein = "Surfschein";
				else
					schein = "Kein";
					
					
				controller.typUebergeben(talking, id, name, schein);
				aktualisieren(model);
				JOptionPane.showMessageDialog(null, "Der Typ wurde erfolgreich geändert!");
				MainFrame.change(MainFrame.getTypAendernGUI(), MainFrame.getGeraeteTypVerwaltung());
				MainFrame.getGeraeteTypVerwaltung().anfrage();
				chckbxSegelschein.setSelected(false);
				chckbxMotorbootschein.setSelected(false);
				chckbxSurfschein.setSelected(false);
				txtTyp.setText("");
			}
		});	
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxSegelschein.setSelected(false);
				chckbxMotorbootschein.setSelected(false);
				chckbxSurfschein.setSelected(false);
				txtTyp.setText("");
				MainFrame.getGeraeteTypVerwaltung().anfrage();
				MainFrame.change(MainFrame.getTypAendernGUI(), MainFrame.getGeraeteTypVerwaltung());			}
		});

		chckbxSegelschein.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				chckbxSurfschein.setSelected(false);
				chckbxMotorbootschein.setSelected(false);
			}
		});
		
		chckbxSurfschein.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				chckbxSegelschein.setSelected(false);
				chckbxMotorbootschein.setSelected(false);
			}
		});
		
		chckbxMotorbootschein.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				chckbxSurfschein.setSelected(false);
				chckbxSegelschein.setSelected(false);
			}
		});
	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
	}
	
	public void setTyp(GeraeteTyp typ) {
		this.typ = typ;
	}
	
	public void setText(String text){
		label.setText(text);
	}
	
	public void setFuehrerschein(String schein){
		if (schein.equals("Segelschein"))
			chckbxSegelschein.setSelected(true);
		else if(schein.equals("Motorbootschein"))
			chckbxMotorbootschein.setSelected(true);
		else if(schein.equals("Surfschein"))
			chckbxSurfschein.setSelected(true);
	}
}
