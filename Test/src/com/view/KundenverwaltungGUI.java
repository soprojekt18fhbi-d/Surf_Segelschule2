// @author Darnel Krause

package com.view;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.KundeAnlegenStrg;
import com.model.KundeAnlegenModel;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class KundenverwaltungGUI extends JPanel {

	public KundenverwaltungGUI() {

		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurck.setBackground(new Color(255, 140, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(300, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnKundeRegistrieren = new JButton("Kunde registrieren");
		btnKundeRegistrieren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnKundeRegistrieren.setBackground(new Color(255, 140, 0));

		GridBagConstraints gbc_btnKundeHinzufgen = new GridBagConstraints();
		gbc_btnKundeHinzufgen.insets = new Insets(0, 0, 5, 0);
		gbc_btnKundeHinzufgen.fill = GridBagConstraints.BOTH;
		gbc_btnKundeHinzufgen.gridx = 0;
		gbc_btnKundeHinzufgen.gridy = 0;
		panel_1.add(btnKundeRegistrieren, gbc_btnKundeHinzufgen);

		JButton btnKundeAendern = new JButton("Kunde \u00E4ndern");
		btnKundeAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnKundeAendern.setBackground(new Color(255, 140, 0));

		GridBagConstraints gbc_btnKundendern = new GridBagConstraints();
		gbc_btnKundendern.fill = GridBagConstraints.BOTH;
		gbc_btnKundendern.gridx = 0;
		gbc_btnKundendern.gridy = 1;
		panel_1.add(btnKundeAendern, gbc_btnKundendern);

		// Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundenverwaltungGUI(), MainFrame.getHauptmenueGUI());
			}
		});

		btnKundeRegistrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainFrame.change(MainFrame.getKundenverwaltungGUI(), MainFrame.getKundeAnlegenGUI());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnKundeAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundenverwaltungGUI(), MainFrame.getKundeAendernGUI());
			}
		});
	}
}
