package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import GUI.MainFrame;
import java.awt.Color;
import javax.swing.UIManager;

public class BuchungsverwaltungGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuchungsverwaltungGUI() {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBackground(new Color(255, 140, 0));
		btnZurck.setForeground(UIManager.getColor("Button.background"));
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnAktiveAusleihen = new JButton("Aktive Buchungen");
		btnAktiveAusleihen.setBackground(new Color(255, 140, 0));
		btnAktiveAusleihen.setForeground(new Color(0, 0, 0));
		btnAktiveAusleihen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnAktiveAusleihen = new GridBagConstraints();
		gbc_btnAktiveAusleihen.fill = GridBagConstraints.BOTH;
		gbc_btnAktiveAusleihen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAktiveAusleihen.gridx = 0;
		gbc_btnAktiveAusleihen.gridy = 0;
		panel_1.add(btnAktiveAusleihen, gbc_btnAktiveAusleihen);
		
		JButton btnSportgertVerkaufenverleihen = new JButton("Sportger\u00E4t verkaufen/verleihen");
		btnSportgertVerkaufenverleihen.setBackground(new Color(255, 140, 0));
		btnSportgertVerkaufenverleihen.setForeground(new Color(0, 0, 0));
		btnSportgertVerkaufenverleihen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnSportgertVerkaufenverleihen = new GridBagConstraints();
		gbc_btnSportgertVerkaufenverleihen.fill = GridBagConstraints.BOTH;
		gbc_btnSportgertVerkaufenverleihen.insets = new Insets(0, 0, 5, 0);
		gbc_btnSportgertVerkaufenverleihen.gridx = 0;
		gbc_btnSportgertVerkaufenverleihen.gridy = 1;
		panel_1.add(btnSportgertVerkaufenverleihen, gbc_btnSportgertVerkaufenverleihen);
		
		JButton btnAbgeschlosseneBuchungen = new JButton("Rechnungsverwaltung");
		btnAbgeschlosseneBuchungen.setBackground(new Color(255, 140, 0));
		btnAbgeschlosseneBuchungen.setForeground(new Color(0, 0, 0));
		btnAbgeschlosseneBuchungen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnAbgeschlosseneBuchungen = new GridBagConstraints();
		gbc_btnAbgeschlosseneBuchungen.fill = GridBagConstraints.BOTH;
		gbc_btnAbgeschlosseneBuchungen.gridx = 0;
		gbc_btnAbgeschlosseneBuchungen.gridy = 2;
		panel_1.add(btnAbgeschlosseneBuchungen, gbc_btnAbgeschlosseneBuchungen);


		


		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsverwaltungGUI(), MainFrame.getHauptmenueGUI());
			}
		});
		
		btnAktiveAusleihen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsverwaltungGUI(), MainFrame.getAktiveBuchungenGUI());
			}
		});

		btnSportgertVerkaufenverleihen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsverwaltungGUI(), MainFrame.getBuchungKundeSucheGUI());
			}
		});
		
		btnAbgeschlosseneBuchungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsverwaltungGUI(), MainFrame.getRechnungSucheGUI());
			}
		});

	}

}
