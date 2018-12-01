package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modellhinzufuegen extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Modellhinzufuegen() {
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel("Ger\u00E4tetyp:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label_1 = new JLabel("Ger\u00E4tetypnummer:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label_2 = new JLabel("Modellbezeichnung:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label_3 = new JLabel("F\u00FChrerscheine:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton button = new JButton("abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getModellhinzufuegen(), MainFrame.getGeraeteModellVerwaltung());
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button_1 = new JButton("best\u00E4tigen");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblModellHinzufgen = new JLabel("Modell hinzuf\u00FCgen:");
		lblModellHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(109)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModellHinzufgen, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(78)
					.addComponent(lblModellHinzufgen, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
}
