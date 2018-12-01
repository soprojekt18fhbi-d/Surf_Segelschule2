package GUI;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WirtschaftlichkeitsverwaltungGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public WirtschaftlichkeitsverwaltungGUI() {
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getWirtschaftlichkeitsverwaltung(), MainFrame.getHauptmenue());
			}
		});
		
		JButton btnZusammenfassend = new JButton("Zusammenfassend");
		btnZusammenfassend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getWirtschaftlichkeitsverwaltung(), MainFrame.getWirtschaftlichkeitGesamt());
			}
		});
		
		JButton btnEinzelnBerechnen = new JButton("Einzeln Berechnen");
		btnEinzelnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getWirtschaftlichkeitsverwaltung(), MainFrame.getWirtschaftlichkeitEinzeln());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnZusammenfassend, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
								.addComponent(btnEinzelnBerechnen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnZurck)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(btnZurck)
					.addGap(18)
					.addComponent(btnZusammenfassend, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnEinzelnBerechnen, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
