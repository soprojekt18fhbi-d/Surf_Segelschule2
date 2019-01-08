package com.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

public class Hauptmenue extends JPanel {

	private Icon iconKundenverwaltung;
	private Icon iconBuchungsverwaltung;
	private Icon iconGeraeteverwaltung;
	private Icon iconWirtschaftlichkeit; 
	
	/**
	 * Create the panel.
	 */
	
	public Hauptmenue() {
		
		setSize(980,580);	
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblHauptmen = new JLabel("Hauptmen\u00FC");
		lblHauptmen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHauptmen.setFont(new Font("Tahoma", Font.BOLD, 72));
		lblHauptmen.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblHauptmen, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHauptmen, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{494, 487};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnKundenverwaltung = new JButton("Kundenverwaltung");
		btnKundenverwaltung.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnKundenverwaltung.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnKundenverwaltung = new GridBagConstraints();
		gbc_btnKundenverwaltung.fill = GridBagConstraints.BOTH;
		gbc_btnKundenverwaltung.insets = new Insets(0, 0, 5, 5);
		gbc_btnKundenverwaltung.gridx = 0;
		gbc_btnKundenverwaltung.gridy = 0;
		panel_1.add(btnKundenverwaltung, gbc_btnKundenverwaltung);
		iconKundenverwaltung = new ImageIcon(getClass().getResource("icon_kunde.png"));
		btnKundenverwaltung.setIcon(iconKundenverwaltung);
		
		JButton btnGerteverwaltung = new JButton("Ger\u00E4teverwaltung");
		btnGerteverwaltung.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnGerteverwaltung.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnGerteverwaltung = new GridBagConstraints();
		gbc_btnGerteverwaltung.fill = GridBagConstraints.BOTH;
		gbc_btnGerteverwaltung.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerteverwaltung.gridx = 1;
		gbc_btnGerteverwaltung.gridy = 0;
		panel_1.add(btnGerteverwaltung, gbc_btnGerteverwaltung);
		iconGeraeteverwaltung = new ImageIcon(getClass().getResource("icon_geraete.png"));
		btnGerteverwaltung.setIcon(iconGeraeteverwaltung);
		
		JButton btnBuchungsverwaltung = new JButton("Buchungsverwaltung");
		btnBuchungsverwaltung.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnBuchungsverwaltung.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnBuchungsverwaltung = new GridBagConstraints();
		gbc_btnBuchungsverwaltung.fill = GridBagConstraints.BOTH;
		gbc_btnBuchungsverwaltung.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuchungsverwaltung.gridx = 0;
		gbc_btnBuchungsverwaltung.gridy = 1;
		panel_1.add(btnBuchungsverwaltung, gbc_btnBuchungsverwaltung);
		iconBuchungsverwaltung = new ImageIcon(getClass().getResource("icon_buchung.png"));
		btnBuchungsverwaltung.setIcon(iconBuchungsverwaltung);
		
		JButton btnWirtschaftlichkeit = new JButton("Wirtschaftlichkeit");
		btnWirtschaftlichkeit.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnWirtschaftlichkeit.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnWirtschaftlichkeit = new GridBagConstraints();
		gbc_btnWirtschaftlichkeit.fill = GridBagConstraints.BOTH;
		gbc_btnWirtschaftlichkeit.gridx = 1;
		gbc_btnWirtschaftlichkeit.gridy = 1;
		panel_1.add(btnWirtschaftlichkeit, gbc_btnWirtschaftlichkeit);
		iconWirtschaftlichkeit = new ImageIcon(getClass().getResource("icon_wirtschaftlichkeit.png"));
		btnWirtschaftlichkeit.setIcon(iconWirtschaftlichkeit);
		
		//Funktionen der Button
		btnKundenverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getHauptmenueGUI(), MainFrame.getKundenverwaltungGUI());
			}
		});
		
		btnGerteverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				MainFrame.change(MainFrame.getHauptmenueGUI(), MainFrame.getGeraeteVerwaltungGUI());
				
			}
		});
		
		btnBuchungsverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				MainFrame.change(MainFrame.getHauptmenueGUI(), MainFrame.getBuchungsverwaltungGUI());
			}
		});
		
		btnWirtschaftlichkeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getHauptmenueGUI(), MainFrame.getWirtschaftlichkeitsverwaltungGUI());
			}
		});
		
		
	}
}
