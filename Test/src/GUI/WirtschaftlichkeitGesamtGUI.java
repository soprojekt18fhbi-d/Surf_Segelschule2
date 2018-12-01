package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class WirtschaftlichkeitGesamtGUI extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public WirtschaftlichkeitGesamtGUI() {
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getWirtschaftlichkeitGesamt(), MainFrame.getWirtschaftlichkeitsverwaltung());
			}
		});
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getWirtschaftlichkeitGesamt(), MainFrame.getHauptmenue());
			}
		});
		
		JLabel lblBitteKategorieAuswhlen = new JLabel("Bitte Kategorie ausw\u00E4hlen:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblWirtschaftlichkeit = new JLabel("Wirtschaftlichkeit:");
		
		JLabel lblEinnahmen = new JLabel("Einnahmen:");
		
		JLabel lblAusgaben = new JLabel("Ausgaben:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Gewinn:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(btnZurck)
					.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
					.addComponent(btnHauptmen)
					.addGap(41))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblBitteKategorieAuswhlen, Alignment.LEADING))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWirtschaftlichkeit)
								.addComponent(lblEinnahmen)
								.addComponent(lblAusgaben)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurck)
						.addComponent(btnHauptmen))
					.addGap(49)
					.addComponent(lblBitteKategorieAuswhlen)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblWirtschaftlichkeit)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEinnahmen)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAusgaben)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
