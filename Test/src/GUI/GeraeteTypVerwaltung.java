package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class GeraeteTypVerwaltung extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GeraeteTypVerwaltung() {
		
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
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnTypHinzu = new JButton("Typ hinzuf\u00FCgen");
		btnTypHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTypHinzu.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnTypHinzu = new GridBagConstraints();
		gbc_btnTypHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnTypHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnTypHinzu.gridx = 0;
		gbc_btnTypHinzu.gridy = 0;
		panel_1.add(btnTypHinzu, gbc_btnTypHinzu);
				
		JButton btnTypAendern = new JButton("Typ \u00E4ndern");
		btnTypAendern.setPreferredSize(new Dimension(300, 23));
		btnTypAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnTypAendern = new GridBagConstraints();
		gbc_btnTypAendern.fill = GridBagConstraints.BOTH;
		gbc_btnTypAendern.insets = new Insets(0, 0, 5, 0);
		gbc_btnTypAendern.gridx = 1;
		gbc_btnTypAendern.gridy = 0;
		panel_1.add(btnTypAendern, gbc_btnTypAendern);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 375));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		tm.addColumn("TypID");
		tm.addColumn("Name");
		tm.addColumn("Führerschein");
		
		
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);
		
		JButton btnModelle = new JButton("Modelle");
		btnModelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModelle.setMinimumSize(new Dimension(150, 35));
		btnModelle.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnModelle = new GridBagConstraints();
		gbc_btnModelle.anchor = GridBagConstraints.EAST;
		gbc_btnModelle.fill = GridBagConstraints.VERTICAL;
		gbc_btnModelle.gridx = 1;
		gbc_btnModelle.gridy = 7;
		panel_1.add(btnModelle, gbc_btnModelle);
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getGeraeteVerwaltung());
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnTypHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTyphinzufuegen());			
			}
		});
		
		btnTypAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getTypaendern());
			}
		});
		
		btnModelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteTypVerwaltung(), MainFrame.getGeraeteModellVerwaltung());
			}
		});
		
	}

}
