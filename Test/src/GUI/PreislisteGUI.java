package GUI;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class PreislisteGUI extends JPanel {
	private JTextField textField;
	private JTable table;
	
	public PreislisteGUI() {
	
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
	
	JButton btnPreislisteHinzu = new JButton("Preisliste hinzuf\u00FCgen");
	btnPreislisteHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
	btnPreislisteHinzu.setPreferredSize(new Dimension(300, 100));
	GridBagConstraints gbc_btnPreislisteHinzu = new GridBagConstraints();
	gbc_btnPreislisteHinzu.insets = new Insets(0, 0, 5, 5);
	gbc_btnPreislisteHinzu.fill = GridBagConstraints.BOTH;
	gbc_btnPreislisteHinzu.gridx = 0;
	gbc_btnPreislisteHinzu.gridy = 0;
	panel_1.add(btnPreislisteHinzu, gbc_btnPreislisteHinzu);
			
	JButton btnPreislisteAendern = new JButton("Preisliste \u00E4ndern");
	btnPreislisteAendern.setPreferredSize(new Dimension(300, 23));
	btnPreislisteAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
	GridBagConstraints gbc_btnPreislisteAendern = new GridBagConstraints();
	gbc_btnPreislisteAendern.fill = GridBagConstraints.BOTH;
	gbc_btnPreislisteAendern.insets = new Insets(0, 0, 5, 0);
	gbc_btnPreislisteAendern.gridx = 1;
	gbc_btnPreislisteAendern.gridy = 0;
	panel_1.add(btnPreislisteAendern, gbc_btnPreislisteAendern);
	
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
	tm.addColumn("ID");
	tm.addColumn("EineStd");
	tm.addColumn("ZweiStd");
	tm.addColumn("VierStd");
	tm.addColumn("EinenTag");
	tm.addColumn("ZweiTage");
	tm.addColumn("DreiTage");
	tm.addColumn("VierTage");
	tm.addColumn("FuenfTage");
	tm.addColumn("SechsSiebenTage");
	tm.addColumn("AchtTage");
	tm.addColumn("NeunTage");
	tm.addColumn("ZehnTage");
	tm.addColumn("ElfTage");
	tm.addColumn("ZwoelfVierzehnTage");
	tm.addColumn("FuenfzehnTage");
	tm.addColumn("SechzehnTage");
	tm.addColumn("SiebzehnTage");
	tm.addColumn("AchtzehnEinundzwanzigTage");
	tm.addColumn("TagVierWochen");
	tm.addColumn("VierWochen");
	
	
	table.setPreferredScrollableViewportSize(new Dimension(450, 600));
	scrollPane.setViewportView(table);
	
	JButton btnAuswhlen = new JButton("Ausw\u00E4hlen");
	btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnAuswhlen.setMinimumSize(new Dimension(150, 35));
	btnAuswhlen.setPreferredSize(new Dimension(150, 35));
	GridBagConstraints gbc_btnAuswhlen = new GridBagConstraints();
	gbc_btnAuswhlen.anchor = GridBagConstraints.EAST;
	gbc_btnAuswhlen.fill = GridBagConstraints.VERTICAL;
	gbc_btnAuswhlen.gridx = 1;
	gbc_btnAuswhlen.gridy = 7;
	panel_1.add(btnAuswhlen, gbc_btnAuswhlen);
			
	
	//Funktionen der Button
	btnZurck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getGeraeteVerwaltung());
			
		}
	});
	
	btnSuchen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		}
	});
	
	btnPreislisteHinzu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getPreislisteAnlegenGUI());
		}
	});
	
	btnPreislisteAendern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getTypaendern());
		}
	});
	
	btnAuswhlen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getGeraeteModellVerwaltung());
		}
	});
	
}
	
	 
}
