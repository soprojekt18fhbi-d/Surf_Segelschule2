package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Datenbankmodels.IObjektModel;
import Steuerung.BuchungModellSucheStrg;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GeraeteModellVerwaltungGUI extends JPanel implements IObjektView{
	private BuchungModellSucheStrg controller;
	private IObjektModel model;
	private JTextField textSuchen;
	private JTable table;
	private int counter = 1;
	private int typNr;
	private String talking = "gesamt";
	private String search;
	private Icon lupe;
	
	/**
	 * Create the panel.
	 */
	public GeraeteModellVerwaltungGUI(IObjektModel smodel, BuchungModellSucheStrg scontroller) {
		model = smodel;
		controller = scontroller;
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurck.setBackground(new Color(255, 140, 0));
		
		textSuchen = new JTextField("Suchen...");
		textSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSuchen.setColumns(10);
		
		lupe = new ImageIcon(getClass().getResource("/GUI/suchenLogo.png"));
		JLabel label = new JLabel(lupe);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnModellHinzu = new JButton("Modell hinzuf\u00FCgen");
		btnModellHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnModellHinzu.setBackground(new Color(255, 140, 0));
		btnModellHinzu.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnModellHinzu = new GridBagConstraints();
		gbc_btnModellHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnModellHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnModellHinzu.gridx = 0;
		gbc_btnModellHinzu.gridy = 0;
		panel_1.add(btnModellHinzu, gbc_btnModellHinzu);
				
		JButton btnModellAendern = new JButton("Modell \u00E4ndern");
		btnModellAendern.setPreferredSize(new Dimension(300, 23));
		btnModellAendern.setBackground(new Color(255, 140, 0));
		btnModellAendern.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnModellAendern = new GridBagConstraints();
		gbc_btnModellAendern.fill = GridBagConstraints.BOTH;
		gbc_btnModellAendern.insets = new Insets(0, 0, 5, 0);
		gbc_btnModellAendern.gridx = 1;
		gbc_btnModellAendern.gridy = 0;
		panel_1.add(btnModellAendern, gbc_btnModellAendern);
		
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
		tm.addColumn("ModellID");
		tm.addColumn("Name");
		tm.addColumn("Preiskategorie");
		
		
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);
		
		JButton btnTypen = new JButton("Typen");
		btnTypen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTypen.setBackground(new Color(255, 140, 0));
		btnTypen.setMinimumSize(new Dimension(150, 35));
		btnTypen.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnTypen = new GridBagConstraints();
		gbc_btnTypen.fill = GridBagConstraints.VERTICAL;
		gbc_btnTypen.anchor = GridBagConstraints.WEST;
		gbc_btnTypen.insets = new Insets(0, 0, 0, 5);
		gbc_btnTypen.gridx = 0;
		gbc_btnTypen.gridy = 7; 
		panel_1.add(btnTypen, gbc_btnTypen);
		
		JButton btnGeraete = new JButton("Ger\u00E4te");
		btnGeraete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGeraete.setBackground(new Color(255, 140, 0));
		btnGeraete.setMinimumSize(new Dimension(150, 35));
		btnGeraete.setPreferredSize(new Dimension(150, 35));
		GridBagConstraints gbc_btnGeraete = new GridBagConstraints();
		gbc_btnGeraete.anchor = GridBagConstraints.EAST;
		gbc_btnGeraete.fill = GridBagConstraints.VERTICAL;
		gbc_btnGeraete.gridx = 1;
		gbc_btnGeraete.gridy = 7;
		panel_1.add(btnGeraete, gbc_btnGeraete);
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteModellVerwaltungGUIGUI(), MainFrame.getGeraeteVerwaltungGUI());
				textSuchen.setText("Suchen...");
			}
		});
		
		btnModellHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteModellVerwaltungGUIGUI(), MainFrame.getModellAnlegenGUI());
				
				if(counter == 1)
				{
					MainFrame.getModellAnlegenGUI().anfrage();
					
				}
				textSuchen.setText("Suchen...");
			}
		});
		
		btnModellAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zeile = table.getSelectedRow();
				
				if (zeile < 0)
					JOptionPane.showMessageDialog(null, "Modell ausw�hlen!");
				else{
					String modellID = String.valueOf(table.getValueAt(zeile, 0));
					int mID = Integer.parseInt(modellID);
					String modellName = String.valueOf(table.getValueAt(zeile, 1));
					String typID = String.valueOf(table.getValueAt(zeile, 2));
					int tID = Integer.parseInt(typID);
					String preisID = String.valueOf(table.getValueAt(zeile, 3));
					int pID = Integer.parseInt(preisID);
					
					MainFrame.getModellAendernGUI().setModellID(mID);
					MainFrame.getModellAendernGUI().setTypID(tID);
					MainFrame.getModellAendernGUI().setPreisID(pID);
					MainFrame.getModellAendernGUI().setText(modellName);
					MainFrame.getModellAendernGUI().anfrage();
					MainFrame.change(MainFrame.getGeraeteModellVerwaltungGUIGUI(), MainFrame.getModellAendernGUI());
					textSuchen.setText("Suchen...");
				}	
			}
		});
		
		btnTypen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteModellVerwaltungGUIGUI(), MainFrame.getGeraeteTypVerwaltung());
				MainFrame.getGeraeteTypVerwaltung().anfrage();
				textSuchen.setText("Suchen...");
			}
		});
				
		btnGeraete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getGeraeteModellVerwaltungGUIGUI(), MainFrame.getSportgeraeteGUI());
				MainFrame.getSportgeraeteGUI().anfrage();
				textSuchen.setText("Suchen...");
			}
		});
		
		textSuchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				textSuchen.setText("");
			}
		});
		
		textSuchen.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				talking = "suchen";
				search = textSuchen.getText();
				anfrage();
			}
		});
	}
	
	public void aktualisieren(IObjektModel model) {
		
		table.setModel(model.getTableModel());
		
	}
	
	public void anfrage() {
		model.anmelden(MainFrame.getBuchungModellSucheGUI());
		controller.fetchModelle(talking, typNr, search);
		aktualisieren(model);
		model.abmelden(MainFrame.getBuchungModellSucheGUI());
	}


}

