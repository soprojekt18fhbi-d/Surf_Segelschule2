/**
 * @author Darnel
 */

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.controller.RechnungAnzeigeStrg;
import com.model.IModel;
import com.model.IObjektModel;
import com.view.IObjektView;
import com.view.MainFrame;

import java.awt.FlowLayout;

public class RechungsSucheGUI extends JPanel implements IObjektView{

	private JTable table;
	private RechnungAnzeigeStrg controller;
	private IObjektModel model;
	private String search;
	private JTextField txtRechnungGewaehlt;
	private JTextField txtSearchbar;
	private int rechnungsID;
	private int heim_Urlaub;

	/**
	 * Create the panel.
	 */
	public RechungsSucheGUI(IObjektModel models, RechnungAnzeigeStrg controllers) {
		
		model=models;
		controller=controllers;
		
		setSize(980, 580);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBackground(new Color(255, 140, 0));
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnZeigeAlle = new JButton("Zeige Alle");
		btnZeigeAlle.setBackground(new Color(255, 140, 0));
		btnZeigeAlle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtSearchbar = new JTextField();
		txtSearchbar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearchbar.setText("Kundennummer...");
		txtSearchbar.setColumns(10);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBackground(new Color(255, 140, 0));
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
					.addComponent(btnZeigeAlle, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearchbar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtSearchbar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnZeigeAlle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		txtRechnungGewaehlt = new JTextField();
		txtRechnungGewaehlt.setBackground(new Color(255, 140, 0));
				
		txtSearchbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				txtSearchbar.setText("");
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnREVerschicken = new JButton("Rechnung verschicken");
		btnREVerschicken.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnREVerschicken.setBackground(new Color(255, 140, 0));

		btnREVerschicken.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnTypHinzu = new GridBagConstraints();
		gbc_btnTypHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnTypHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnTypHinzu.gridx = 0;
		gbc_btnTypHinzu.gridy = 0;
		panel_1.add(btnREVerschicken, gbc_btnTypHinzu);
		
		txtRechnungGewaehlt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtRechnungGewaehlt.setHorizontalAlignment(SwingConstants.CENTER);
		txtRechnungGewaehlt.setColumns(15);
		txtRechnungGewaehlt.setEditable(false);
		
		GridBagConstraints gbc_txtRechnungGewählt = new GridBagConstraints();
		gbc_txtRechnungGewählt.fill = GridBagConstraints.BOTH;
		gbc_txtRechnungGewählt.insets = new Insets(0, 0, 5, 0);
		gbc_txtRechnungGewählt.gridx = 1;
		gbc_txtRechnungGewählt.gridy = 0;
		panel_1.add(txtRechnungGewaehlt,gbc_txtRechnungGewählt);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 375));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int row = table.getSelectedRow();
					txtRechnungGewaehlt.setText(table.getModel().getValueAt(row, 0).toString());
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			
		}});
		
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getRechnungSucheGUI(), MainFrame.getBuchungsverwaltungGUI());
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.anmelden(MainFrame.getRechnungSucheGUI());
				System.out.println((txtSearchbar.getText()));
				controller.getRechnungenSuche(txtSearchbar.getText());
				table.setModel(model.getTableModel());
				model.abmelden(MainFrame.getRechnungSucheGUI());
				
			}
		});
		
		btnZeigeAlle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.anmelden(MainFrame.getRechnungSucheGUI());
				controller.getRechnungen();
				table.setModel(model.getTableModel());
				model.abmelden(MainFrame.getRechnungSucheGUI());
			}
		});
		
		// Wenn rechnungsID leer ist, dann wird eine Fehlermeldung ausgeworfen. Das Programme wird auch nicht ausgeführt, wenn heim_Urlaub ==2 (Abbrechen) ist.  

		btnREVerschicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.anmelden(MainFrame.getRechnungSucheGUI());
				
				try {
					rechnungsID = Integer.parseInt(txtRechnungGewaehlt.getText());
					System.out.println(rechnungsID);
					heim_Urlaub = heimOderUrlaubsAdresse();					
					if(heim_Urlaub == 0 || heim_Urlaub == 1) 
						controller.getRechungDruck(rechnungsID, heim_Urlaub);
				}
				catch(NumberFormatException e2){
					keineRechnungGewaehlt();
					e2.printStackTrace();
				}
				model.abmelden(MainFrame.getRechnungSucheGUI());
					
			}
		});
		
	}
	
	public int heimOderUrlaubsAdresse() {
		int testWert = JOptionPane.showConfirmDialog(null, "An die Heimatadresse verschicken?");
		if (testWert == -1)
			testWert = 2;
		if (testWert == 0) {
			System.out.println("Du hast Heimatadresse gewählt");
			return 0;
		}
		if (testWert == 1) {
			System.out.println("Du hast Urlaubsdresse gewählt");
			return 1;
		}
		if (testWert == 2)
			System.out.println("Du hast Abbrechen gewählt");
			return 2;
	}
	
	public void keineRechnungGewaehlt() {
		JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus", "Rechnung wählen", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());
	}
}
