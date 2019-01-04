 /*
  *  @author Michael Schmidt
  */

package GUI;

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
import java.awt.Color;

public class GeraeteVerwaltungGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public GeraeteVerwaltungGUI() {

setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBackground(new Color(255, 140, 0));
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
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnTypen = new JButton("Typen verwalten");
		btnTypen.setBackground(new Color(255, 140, 0));
		btnTypen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnAktiveAusleihen = new GridBagConstraints();
		gbc_btnAktiveAusleihen.fill = GridBagConstraints.BOTH;
		gbc_btnAktiveAusleihen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAktiveAusleihen.gridx = 0;
		gbc_btnAktiveAusleihen.gridy = 0;
		panel_1.add(btnTypen, gbc_btnAktiveAusleihen);
		
		JButton btnModelle = new JButton("Modelle verwalten");
		btnModelle.setBackground(new Color(255, 140, 0));
		btnModelle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnSportgertVerkaufenverleihen = new GridBagConstraints();
		gbc_btnSportgertVerkaufenverleihen.fill = GridBagConstraints.BOTH;
		gbc_btnSportgertVerkaufenverleihen.insets = new Insets(0, 0, 5, 0);
		gbc_btnSportgertVerkaufenverleihen.gridx = 0;
		gbc_btnSportgertVerkaufenverleihen.gridy = 1;
		panel_1.add(btnModelle, gbc_btnSportgertVerkaufenverleihen);
		
		JButton btnGeraete = new JButton("Sportgeräte verwalten");
		btnGeraete.setBackground(new Color(255, 140, 0));
		btnGeraete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnAbgeschlosseneBuchungen = new GridBagConstraints();
		gbc_btnAbgeschlosseneBuchungen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAbgeschlosseneBuchungen.fill = GridBagConstraints.BOTH;
		gbc_btnAbgeschlosseneBuchungen.gridx = 0;
		gbc_btnAbgeschlosseneBuchungen.gridy = 2;
		panel_1.add(btnGeraete, gbc_btnAbgeschlosseneBuchungen);
		
		JButton btnPreisliste = new JButton("Preisliste verwalten");
		btnPreisliste.setBackground(new Color(255, 140, 0));
		btnPreisliste.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnPreisliste = new GridBagConstraints();
		gbc_btnPreisliste.fill = GridBagConstraints.BOTH;
		gbc_btnPreisliste.insets = new Insets(0, 0, 5, 0);
		gbc_btnPreisliste.gridx = 0;
		gbc_btnPreisliste.gridy = 3;
		panel_1.add(btnPreisliste, gbc_btnPreisliste);


		


		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteVerwaltungGUI(), MainFrame.getHauptmenueGUI());
			}
		});
		
		btnTypen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteVerwaltungGUI(), MainFrame.getGeraeteTypVerwaltung());
				MainFrame.getGeraeteTypVerwaltung().anfrage();
			}
		});

		btnModelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteVerwaltungGUI(), MainFrame.getGeraeteModellVerwaltungGUIGUI());
				MainFrame.getGeraeteModellVerwaltungGUIGUI().anfrage();
			}
		});
		
		btnGeraete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteVerwaltungGUI(), MainFrame.getSportgeraeteGUI());
				MainFrame.getSportgeraeteGUI().anfrage();
			}
		});
		
		btnPreisliste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.change(MainFrame.getGeraeteVerwaltungGUI(), MainFrame.getPreislisteGUI());
			}
		});

	}

}

