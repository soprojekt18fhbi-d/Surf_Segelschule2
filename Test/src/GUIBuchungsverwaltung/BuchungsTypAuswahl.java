package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.MainFrame;

import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuchungsTypAuswahl extends JPanel {
	
	static boolean verkauf;
	
	//Methode zur Auswahl ob Verkauf- oder Verleih-Panel geöffnet wird
	public static boolean getBool(){
		return verkauf;
	}	

	/**
	 * Create the panel.
	 * @return 
	 */
	public BuchungsTypAuswahl() {
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
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnGertVerleihen = new JButton("Ger\u00E4t verleihen");
		btnGertVerleihen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnGertVerleihen = new GridBagConstraints();
		gbc_btnGertVerleihen.fill = GridBagConstraints.BOTH;
		gbc_btnGertVerleihen.insets = new Insets(0, 0, 0, 5);
		gbc_btnGertVerleihen.gridx = 0;
		gbc_btnGertVerleihen.gridy = 0;
		panel_1.add(btnGertVerleihen, gbc_btnGertVerleihen);
		
		JButton btnGertVerkaufen = new JButton("Ger\u00E4t verkaufen");
		btnGertVerkaufen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnGertVerkaufen = new GridBagConstraints();
		gbc_btnGertVerkaufen.fill = GridBagConstraints.BOTH;
		gbc_btnGertVerkaufen.gridx = 1;
		gbc_btnGertVerkaufen.gridy = 0;
		panel_1.add(btnGertVerkaufen, gbc_btnGertVerkaufen);

		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsTypAuswahl(), MainFrame.getKundeWaehlen());
			}
		});
		
		btnGertVerleihen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsTypAuswahl(), MainFrame.getTypAuswahl());
				verkauf = false;
			}
		});
		
		btnGertVerkaufen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungsTypAuswahl(), MainFrame.getTypAuswahl());
				verkauf = true;
			}
		});
		
	
		
	}

}
