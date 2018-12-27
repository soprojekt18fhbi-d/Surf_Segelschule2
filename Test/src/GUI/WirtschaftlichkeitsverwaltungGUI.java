// @author Darnel / Ben Kröncke

package GUI;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;

public class WirtschaftlichkeitsverwaltungGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public WirtschaftlichkeitsverwaltungGUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton zrckButton = new JButton("Zur\u00FCck");
		zrckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					MainFrame.change(MainFrame.getWirtschaftlichkeitsverwaltungGUI(), MainFrame.getHauptmenueGUI());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		zrckButton.setBackground(new Color(255, 140, 0));
		zrckButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(zrckButton, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Unternehmen", "Standort", "Typ", "Modell", "Sportger\u00E4t"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblNewLabel = new JLabel("Kategorie w\u00E4hlen:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblSpezifizieren = new JLabel("Spezifizieren:");
		lblSpezifizieren.setForeground(new Color(255, 255, 255));
		lblSpezifizieren.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JButton btnNewButton = new JButton("Berechne");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblEinnahmen = new JLabel("Einnahmen:");
		lblEinnahmen.setForeground(Color.GREEN);
		lblEinnahmen.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setColumns(10);
		
		JLabel lblAusgaben = new JLabel("Ausgaben:");
		lblAusgaben.setForeground(Color.RED);
		lblAusgaben.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblGewinn = new JLabel("Rohgewinn:");
		lblGewinn.setForeground(Color.BLACK);
		lblGewinn.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		Image photo = new ImageIcon(this.getClass().getResource("Scanner.png")).getImage();
		
		JLabel labelHead = new JLabel("Wirtschaftlichkeit");
		labelHead.setHorizontalAlignment(SwingConstants.CENTER);
		labelHead.setForeground(new Color(255, 140, 0));
		labelHead.setFont(new Font("Tahoma", Font.BOLD, 52));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 455, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblSpezifizieren, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addGap(4)
								.addComponent(comboBox_1, 0, 326, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblEinnahmen, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblAusgaben, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblGewinn, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, 0, 326, Short.MAX_VALUE))
							.addComponent(labelHead, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
					.addGap(172))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(labelHead, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpezifizieren, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEinnahmen, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAusgaben, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGewinn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {lblEinnahmen, textField, lblAusgaben, lblGewinn, textField_1, textField_2});
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {comboBox, lblNewLabel, lblSpezifizieren, comboBox_1});
		panel_1.setLayout(gl_panel_1);
	}
}
