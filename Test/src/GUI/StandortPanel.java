package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StandortPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StandortPanel() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		
		JLabel label = new JLabel("Bitte Standort w\u00E4hlen:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 48));
		
		JButton button = new JButton("\u00DCberspringen");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("Weiter");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 974, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(210)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 551, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(77)
					.addComponent(label)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}

}
