package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.MainFrame;

import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusSetzen extends JPanel {

	/**
	 * Create the panel.
	 */
	public StatusSetzen() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JCheckBox chckbxAllesOk = new JCheckBox("Alles ok");
		chckbxAllesOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxAllesOk = new GridBagConstraints();
		gbc_chckbxAllesOk.anchor = GridBagConstraints.SOUTHWEST;
		gbc_chckbxAllesOk.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAllesOk.gridx = 2;
		gbc_chckbxAllesOk.gridy = 0;
		panel_1.add(chckbxAllesOk, gbc_chckbxAllesOk);
		
		JCheckBox chckbxReparatur = new JCheckBox("Reparatur");
		chckbxReparatur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxReparatur = new GridBagConstraints();
		gbc_chckbxReparatur.anchor = GridBagConstraints.WEST;
		gbc_chckbxReparatur.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxReparatur.gridx = 2;
		gbc_chckbxReparatur.gridy = 1;
		panel_1.add(chckbxReparatur, gbc_chckbxReparatur);
		
		JCheckBox chckbxAussortieren = new JCheckBox("Aussortieren");
		chckbxAussortieren.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxAussortieren = new GridBagConstraints();
		gbc_chckbxAussortieren.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxAussortieren.gridwidth = 3;
		gbc_chckbxAussortieren.gridx = 2;
		gbc_chckbxAussortieren.gridy = 2;
		panel_1.add(chckbxAussortieren, gbc_chckbxAussortieren);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnBestätigen = new JButton("Best\u00E4tigen");
		btnBestätigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnBestätigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnBestätigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getStatusSetzen(), MainFrame.getAktiveAusleihen());				
			}
		});
		
		btnBestätigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Das Sportgerät wurde erfolgreich reklamiert", "Reklamier-Bestätigung", JOptionPane.PLAIN_MESSAGE);
				MainFrame.change(MainFrame.getStatusSetzen(), MainFrame.getBuchungsverwaltung());			
			}
		});
	}
}
