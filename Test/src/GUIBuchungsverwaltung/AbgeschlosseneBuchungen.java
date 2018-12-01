package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import GUI.MainFrame;

import javax.swing.JTextField;

public class AbgeschlosseneBuchungen extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AbgeschlosseneBuchungen() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnBuchungEinsehen = new JButton("Buchung einsehen");
		btnBuchungEinsehen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuchungEinsehen.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnBuchungEinsehen = new GridBagConstraints();
		gbc_btnBuchungEinsehen.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuchungEinsehen.fill = GridBagConstraints.BOTH;
		gbc_btnBuchungEinsehen.gridx = 0;
		gbc_btnBuchungEinsehen.gridy = 0;
		panel_1.add(btnBuchungEinsehen, gbc_btnBuchungEinsehen);
		
		JButton btnRechnungEinsehen = new JButton("Rechnung einsehen");
		btnRechnungEinsehen.setPreferredSize(new Dimension(300, 23));
		btnRechnungEinsehen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnRechnungEinsehen = new GridBagConstraints();
		gbc_btnRechnungEinsehen.fill = GridBagConstraints.BOTH;
		gbc_btnRechnungEinsehen.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechnungEinsehen.gridx = 1;
		gbc_btnRechnungEinsehen.gridy = 0;
		panel_1.add(btnRechnungEinsehen, gbc_btnRechnungEinsehen);
		
		JButton btnStornieren = new JButton("Stornieren");
		btnStornieren.setPreferredSize(new Dimension(300, 23));
		btnStornieren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnStornieren = new GridBagConstraints();
		gbc_btnStornieren.fill = GridBagConstraints.BOTH;
		gbc_btnStornieren.insets = new Insets(0, 0, 5, 0);
		gbc_btnStornieren.gridx = 2;
		gbc_btnStornieren.gridy = 0;
		panel_1.add(btnStornieren, gbc_btnStornieren);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblGeräte = new JLabel("Abgeschlossene Buchungen:");
		lblGeräte.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblGeräte);
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getAbgeschlosseneBuchungen(), MainFrame.getBuchungsverwaltung());
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		
		btnBuchungEinsehen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnRechnungEinsehen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnStornieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wert = JOptionPane.showConfirmDialog(null, "Wollen Sie die Buchung stornieren?", "Buchung stornieren:", JOptionPane.YES_NO_OPTION);
				if (wert==0){
					JOptionPane.showMessageDialog(null, "Die Buchung wurde erfolgreich storniert", "Buchungen", JOptionPane.PLAIN_MESSAGE);
				}
				else{ 
					JOptionPane.showMessageDialog(null, "Die Buchung wurde nicht storniert", "Buchungen", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
	}
}
