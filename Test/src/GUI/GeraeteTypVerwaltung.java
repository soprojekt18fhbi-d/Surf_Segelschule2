package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeraeteTypVerwaltung extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GeraeteTypVerwaltung() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button = new JButton("Zur\u00FCck");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getHauptmenue());
				
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		textField = new JTextField();
		textField.setText("Artikel suchen...");
		
		JButton button_1 = new JButton("Ger\u00E4tetyp hinzuf\u00FCgen");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTyphinzufuegen());
				
			}
		});
		
		JButton button_2 = new JButton("Ger\u00E4tetyp \u00E4ndern");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTypaendern());
				
			}
		});
		
		JButton button_3 = new JButton("Ausw\u00E4hlen");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getGeraeteModellVerwaltung());
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 974, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 546, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)))
					.addGap(1)
					.addComponent(button_3)
					.addContainerGap())
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
						.addComponent(button_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}

}
