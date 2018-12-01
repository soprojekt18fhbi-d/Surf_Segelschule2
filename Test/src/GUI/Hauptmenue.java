package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hauptmenue extends JPanel {

	/**
	 * Create the panel.
	 */
	public Hauptmenue() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		
		JButton button = new JButton("Kundenverwaltung");
		button.setFont(new Font("Tahoma", Font.PLAIN, 28));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getHauptmenue(), MainFrame.getKundenverwaltung());
			}
		});
		
		JButton button_1 = new JButton("Ger\u00E4teverwaltung");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getHauptmenue(), MainFrame.getGeraeteTypVerwaltung());
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton button_2 = new JButton("Buchungsverwaltung");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getHauptmenue(), MainFrame.getBuchungsverwaltung());
				
			}
		});
		
		JButton button_3 = new JButton("W-Verwaltung");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getHauptmenue(), MainFrame.getWirtschaftlichkeitsverwaltung());
			}
		});
		
		JButton button_4 = new JButton("Rechnungsverwaltung");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label = new JLabel("Hauptmen\u00FC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 48));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 974, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(8))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 551, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addComponent(button_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
					.addGap(8))
		);
		panel.setLayout(gl_panel);

	}

}
