/**
 * @author Darnel
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Steuerung.RechnungAnzeigeStrg;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Datenbankmodels.IModel;
import Datenbankmodels.IObjektModel;
import GUI.IObjektView;
import GUI.MainFrame;
import java.awt.FlowLayout;

public class RechungsSucheGUI extends JPanel implements IObjektView{

	private JTable table;
	private RechnungAnzeigeStrg controller;
	private IObjektModel model;
	private String search;
	private JTextField textField_1;
	private JTextField txtSearchbar;


	/**
	 * Create the panel.
	 */
	public RechungsSucheGUI(IObjektModel models, RechnungAnzeigeStrg controllers) {
		
		model=models;
		controller=controllers;
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));

		

		txtSearchbar = new JTextField();
//		txtSearchbar.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				
//				try {
//					
//					
//					anfrage();
//					
//				
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//	
//		});
		txtSearchbar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearchbar.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchbar.setText("Kundennummer...");
		txtSearchbar.setColumns(15);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(15);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnZurck);
		panel.add(txtSearchbar);
		panel.add(btnSuchen);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnREVerschicken = new JButton("Rechnung verschicken");
		btnREVerschicken.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnREVerschicken.setPreferredSize(new Dimension(300, 100));
		GridBagConstraints gbc_btnTypHinzu = new GridBagConstraints();
		gbc_btnTypHinzu.insets = new Insets(0, 0, 5, 5);
		gbc_btnTypHinzu.fill = GridBagConstraints.BOTH;
		gbc_btnTypHinzu.gridx = 0;
		gbc_btnTypHinzu.gridy = 0;
		panel_1.add(btnREVerschicken, gbc_btnTypHinzu);
				
		JButton btnREbezahlen = new JButton("Rechnung bezahlen");
		btnREbezahlen.setPreferredSize(new Dimension(300, 23));
		btnREbezahlen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnTypAendern = new GridBagConstraints();
		gbc_btnTypAendern.fill = GridBagConstraints.BOTH;
		gbc_btnTypAendern.insets = new Insets(0, 0, 5, 0);
		gbc_btnTypAendern.gridx = 1;
		gbc_btnTypAendern.gridy = 0;
		panel_1.add(btnREbezahlen, gbc_btnTypAendern);
		
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
		

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);
		

		
				
		
		//Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getRechnungSucheGUI(), MainFrame.getHauptmenueGUI());
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.anmelden(MainFrame.getRechnungSucheGUI());
				controller.getRechnungen(search);
				model.abmelden(MainFrame.getRechnungSucheGUI());
				
			}
		});
		
		btnREVerschicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getRechnungSucheGUI(), MainFrame.getRechnungDetailGUI());			
			}
		});
		
		btnREbezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getRechnungSucheGUI(), MainFrame.getRechnungDetailGUI());
			}
		});
		
	}

	@Override
public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());
	}
	
	private void anfrage() {
		model.anmelden(MainFrame.getRechnungSucheGUI());
		controller.fetchRechnungen(txtSearchbar.getText() );
		table.setModel(model.getTableModel());
		model.abmelden(MainFrame.getRechnungSucheGUI());
	}
}
