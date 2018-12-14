package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SportgeraeteVerwaltung extends JPanel {
	private JTextField textField;
	private JTable table;
	private int counter = 1;

	/**
	 * Create the panel.
	 */
	public SportgeraeteVerwaltung() {
		
		
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
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnGeraetHinzu = new JButton("Ger\u00E4t hinzuf\u00FCgen");
		btnGeraetHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeraetHinzu.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnGeraetHinzu = new GridBagConstraints();
		gbc_btnGeraetHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnGeraetHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetHinzu.gridx = 0;
		gbc_btnGeraetHinzu.gridy = 0;
		panel_1.add(btnGeraetHinzu, gbc_btnGeraetHinzu);
				
		JButton btnGeraetAendern = new JButton("Ger\u00E4t \u00E4ndern");
		btnGeraetAendern.setPreferredSize(new Dimension(300, 23));
		btnGeraetAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnGeraetAendern = new GridBagConstraints();
		gbc_btnGeraetAendern.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetAendern.insets = new Insets(0, 0, 5, 5);
		gbc_btnGeraetAendern.gridx = 1;
		gbc_btnGeraetAendern.gridy = 0;
		panel_1.add(btnGeraetAendern, gbc_btnGeraetAendern);
		
		JButton btnGeraetDeaktivieren = new JButton("Ger\u00E4t deaktivieren");
		btnGeraetDeaktivieren.setPreferredSize(new Dimension(300, 100));
		btnGeraetDeaktivieren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnGeraetDeaktivieren = new GridBagConstraints();
		gbc_btnGeraetDeaktivieren.fill = GridBagConstraints.BOTH;
		gbc_btnGeraetDeaktivieren.insets = new Insets(0, 0, 5, 0);
		gbc_btnGeraetDeaktivieren.gridx = 2;
		gbc_btnGeraetDeaktivieren.gridy = 0;
		panel_1.add(btnGeraetDeaktivieren, gbc_btnGeraetDeaktivieren);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 375));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		tm.addColumn("GeräteID");
		tm.addColumn("Name");
		tm.addColumn("Verkaufspreis");
		tm.addColumn("Anschaffungspreis");
		tm.addColumn("Status");
		tm.addColumn("Makel");
		tm.addColumn("Farbe");
		
		
		
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);
		
		JButton btnModelle = new JButton("Modelle");
		btnModelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModelle.setMinimumSize(new Dimension(150, 35));
		btnModelle.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnModelle = new GridBagConstraints();
		gbc_btnModelle.fill = GridBagConstraints.VERTICAL;
		gbc_btnModelle.insets = new Insets(0, 0, 0, 5);
		gbc_btnModelle.anchor = GridBagConstraints.WEST;
		gbc_btnModelle.gridx = 0;
		gbc_btnModelle.gridy = 7;
		panel_1.add(btnModelle, gbc_btnModelle);
		
		
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraete(), MainFrame.getGeraeteVerwaltung());
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnGeraetHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraete(), MainFrame.getGeraethinzufuegen());
				
				if(counter == 1)
				{
					MainFrame.getGeraethinzufuegen().anfrage();
					counter--;
				}
			}
		});
		
		btnGeraetAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraete(), MainFrame.getGeraetaendern());
			}
		});
		
		btnGeraetDeaktivieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnModelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getSportgeraete(), MainFrame.getGeraeteModellVerwaltung());
			}
		});
		
	}
}
