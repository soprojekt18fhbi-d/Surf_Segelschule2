package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeraeteModellVerwaltung extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GeraeteModellVerwaltung() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button = new JButton("Zur\u00FCck");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteModellVerwaltung(), MainFrame.getGeraeteTypVerwaltung());
				
			}
		});
		
		JButton button_1 = new JButton("Modell hinzuf\u00FCgen");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteModellVerwaltung(), MainFrame.getModellhinzufuegen());
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("Modell \u00E4ndern");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteModellVerwaltung(), MainFrame.getModellaendern());
				
			}
		});
		button_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("Modell deaktivieren");
		button_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		
		textField = new JTextField();
		textField.setText("Artikel suchen...");
		
		JButton button_4 = new JButton("Ausw\u00E4hlen");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteModellVerwaltung(), MainFrame.getSportgeraete());
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 974, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 551, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}

}
