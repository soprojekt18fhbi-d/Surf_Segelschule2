package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableRowSorter;

import Datenbankmodels.IObjektModel;
import Datenbankmodels.ModellAnzeigeModel;
import GUI.IObjektView;
import GUI.MainFrame;
import Steuerung.ModellAnzeigeStrg;

import java.awt.Component;

public class ModellAuswahl extends JPanel implements IObjektView {
	private JTextField textField;
	JList list = new JList();
	
	private ModellAnzeigeStrg controller;
	private ModellAnzeigeModel model;

	/**
	 * Create the panel.
	 */
	public ModellAuswahl() {
		model = new ModellAnzeigeModel();
		controller = new ModellAnzeigeStrg(model);
		model.anmelden(this);
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane.setViewportView(list);
		
		
		controller.fetchModelle();
	    aktualisieren(model);
		
		
		JLabel lblModelle = new JLabel("Modelle:");
		lblModelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblModelle);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAuswhlen = new JButton("Ausw\u00E4hlen");
		btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(btnAuswhlen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(btnAuswhlen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getModellAuswahl(), MainFrame.getTypAuswahl());
				
			}
		});
		
		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool = BuchungsTypAuswahl.getBool();
				if(bool == false)
					MainFrame.change(MainFrame.getModellAuswahl(), MainFrame.getGerätAuswahlAusleihe());
				else
					MainFrame.change(MainFrame.getModellAuswahl(), MainFrame.getGerätAuswahlVerkauf());
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool = BuchungsTypAuswahl.getBool();
				if(bool == false)
					MainFrame.change(MainFrame.getModellAuswahl(), MainFrame.getGerätAuswahlAusleihe());
				else
					MainFrame.change(MainFrame.getModellAuswahl(), MainFrame.getGerätAuswahlVerkauf());
			}
		});
		
		/*
		//Searchbar
		textField.addFocusListener(new FocusListener(){
		String text = "Suchen";	

			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField.getText().equals(text)){
					textField.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (textField.getText().isEmpty()){
					textField.setText(text);
				}
				
			}
		});
		
		textField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent event){
				String query = textField.getText();
				search(query);
			}
		});
	*/
		
	}
	
	/*
	public void search(String query){
		ListRowSorter<DefaultListModel> rowSorter = new TableRowSorter
	}
	*/

	@Override
	public void aktualisieren(IObjektModel model) {
		DefaultListModel dlm = new DefaultListModel();
		list.removeAll();
		dlm = model.getObjekte();
		list.setModel(dlm);
		
	}
}
