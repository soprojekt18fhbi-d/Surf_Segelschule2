package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.MainFrame;

import javax.swing.GroupLayout.Alignment;

public class GerätAuswahlAusleihe extends JPanel {

	/**
	 * Create the panel.
	 */
	public GerätAuswahlAusleihe() {
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
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnVerleihen = new JButton("Verleihen");
		btnVerleihen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnVerleihen.setPreferredSize(new Dimension(77, 100));
		GridBagConstraints gbc_btnVerleihen = new GridBagConstraints();
		gbc_btnVerleihen.gridwidth = 2;
		gbc_btnVerleihen.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerleihen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerleihen.gridx = 0;
		gbc_btnVerleihen.gridy = 0;
		panel_1.add(btnVerleihen, gbc_btnVerleihen);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblGeräte = new JLabel("Sportgeräte:");
		lblGeräte.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblGeräte);
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGerätAuswahlAusleihe(), MainFrame.getModellAuswahl());
				
			}
		});
		
		btnVerleihen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGerätAuswahlAusleihe(), MainFrame.getVerleihFormular());
				
			}
		});
		
	}

}
