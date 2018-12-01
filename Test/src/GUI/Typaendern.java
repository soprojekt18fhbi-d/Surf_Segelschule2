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

public class Typaendern extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Typaendern() {
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel("Typ:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label_1 = new JLabel("Nummer:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton button = new JButton("abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getTypaendern(), MainFrame.getGeraeteTypVerwaltung());
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button_1 = new JButton("best\u00E4tigen");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblTypndern = new JLabel("Typ \u00E4ndern:");
		lblTypndern.setFont(new Font("Tahoma", Font.BOLD, 32));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(84)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypndern, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(252, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(124)
					.addComponent(lblTypndern, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}

}
