// @author Darnel / Ben Kröncke

package GUI;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Datenbankmodels.IObjektModel;
import Datenbankmodels.IWirtschaftlichkeitModel;
import Steuerung.IController;
import Steuerung.WirtschaftlichkeitStrg;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
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

public class WirtschaftlichkeitsverwaltungGUI extends JPanel implements IWirtschaftlichkeitView { //Ben Kröncke
	
	
	private String talking = "category";
	private String mode = "Unternehmen";
	private int id;
	private JTextField txtIncome;
	private JTextField txtExpenses;
	private JTextField txtProfit;
	private JComboBox<String> cboxSpec;
	private IWirtschaftlichkeitModel model;
	private WirtschaftlichkeitStrg controller;
	
	
	
	public WirtschaftlichkeitsverwaltungGUI(IWirtschaftlichkeitModel models, WirtschaftlichkeitStrg controllers) {
		
		model = models;
		controller = controllers;
		
		
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton zrckButton = new JButton("Zur\u00FCck");
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
		zrckButton.setBackground(new Color(255, 140, 0));
		zrckButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(zrckButton, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		
		JComboBox cboxKateg = new JComboBox();
		cboxKateg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				try {
					talking = "category";
					mode = cboxKateg.getSelectedItem().toString();
					model.anmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
					controller.holeDaten(talking, mode, id);
					model.abmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
					if(cboxKateg.getSelectedItem().equals("Sportgeraet"))
						try {
							Integer.parseInt(JOptionPane.showInputDialog("Bitte Artikelnummer (ID) eingeben zur genauen Bestimmung!"));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Das ist keine gültige Nummer!");
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		cboxKateg.setModel(new DefaultComboBoxModel(new String[] {"Unternehmen", "Standort", "Typ", "Modell", "Sportgeraet"}));
		cboxKateg.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblNewLabel = new JLabel("Kategorie w\u00E4hlen:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblSpezifizieren = new JLabel("Spezifizieren:");
		lblSpezifizieren.setForeground(new Color(255, 255, 255));
		lblSpezifizieren.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		cboxSpec = new JComboBox();
		cboxSpec.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JButton buttonCalc = new JButton("Berechne");
		buttonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					talking = "calc";
					model.anmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
					controller.holeDaten(talking, mode, id);
					model.abmelden(MainFrame.getWirtschaftlichkeitsverwaltungGUI());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		buttonCalc.setBackground(new Color(255, 140, 0));
		buttonCalc.setForeground(new Color(0, 0, 0));
		buttonCalc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblEinnahmen = new JLabel("Einnahmen:");
		lblEinnahmen.setForeground(Color.GREEN);
		lblEinnahmen.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		txtIncome = new JTextField();
		txtIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtIncome.setForeground(new Color(0, 128, 0));
		txtIncome.setEditable(false);
		txtIncome.setFont(new Font("Tahoma", Font.BOLD, 36));
		txtIncome.setColumns(10);
		
		JLabel lblAusgaben = new JLabel("Ausgaben:");
		lblAusgaben.setForeground(Color.RED);
		lblAusgaben.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblGewinn = new JLabel("Rohgewinn:");
		lblGewinn.setForeground(Color.BLACK);
		lblGewinn.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		txtExpenses = new JTextField();
		txtExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		txtExpenses.setForeground(new Color(128, 0, 0));
		txtExpenses.setFont(new Font("Tahoma", Font.BOLD, 36));
		txtExpenses.setEditable(false);
		txtExpenses.setColumns(10);
		
		txtProfit = new JTextField();
		txtProfit.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfit.setFont(new Font("Tahoma", Font.BOLD, 36));
		txtProfit.setEditable(false);
		txtProfit.setColumns(10);
		Image photo = new ImageIcon(this.getClass().getResource("Scanner.png")).getImage();
		
		JLabel labelHead = new JLabel("Wirtschaftlichkeit");
		labelHead.setHorizontalAlignment(SwingConstants.CENTER);
		labelHead.setForeground(new Color(255, 140, 0));
		labelHead.setFont(new Font("Tahoma", Font.BOLD, 52));
		
		JLabel lblNewLabel_1 = new JLabel("\u20AC");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JLabel label = new JLabel("\u20AC");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonCalc, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(172)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblSpezifizieren, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(cboxSpec, 0, 326, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblEinnahmen, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIncome, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblAusgaben, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtExpenses, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblGewinn, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtProfit, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cboxKateg, 0, 326, Short.MAX_VALUE))
								.addComponent(labelHead, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(122))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(labelHead, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(cboxKateg, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpezifizieren, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboxSpec, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(buttonCalc, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtIncome)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEinnahmen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAusgaben, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtExpenses, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtProfit, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGewinn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(43))
		);
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {cboxKateg, lblNewLabel, lblSpezifizieren, cboxSpec});
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {lblEinnahmen, txtIncome, lblAusgaben, lblGewinn, txtExpenses, txtProfit});
		panel_1.setLayout(gl_panel_1);
	}


	@Override
	public void aktualisieren(IWirtschaftlichkeitModel model) {
		// TODO Auto-generated method stub
		if(talking.equals("category"))
		{
			cboxSpec.removeAllItems();
			
			for(int i = 0; i < model.getStrings().size(); i++)
			{
				cboxSpec.addItem(model.getStrings().get(i));
			}
		}
			
		
		else if(talking.equals("calc"))
			{
				txtIncome.setText("" + roundDouble(model.getIncome()));
				txtExpenses.setText("" + roundDouble(model.getExpenses()));
				txtProfit.setText("" + roundDouble((Double.parseDouble(txtIncome.getText())-(Double.parseDouble(txtExpenses.getText())))));
				
			}
	}
	
	public double roundDouble(double value) {
		
        int r = (int) Math.round(value*100);
        double f = r / 100.0;
        return f;
     }
}
