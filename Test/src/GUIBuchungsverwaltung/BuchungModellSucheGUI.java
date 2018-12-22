//@author Michi S. Ben Kröncke
package GUIBuchungsverwaltung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableRowSorter;

import Datenbankmodels.IObjektModel;
import Datenbankmodels.BuchungModellSucheModel;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import GUI.MainFrame;
import Steuerung.BuchungModellSucheStrg;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuchungModellSucheGUI extends JPanel implements IObjektView {
	private JTextField txtSearchbar;
	
	private BuchungModellSucheStrg controller;
	private IObjektModel model;
	private int typNr;
	private int kNr;
	private IKunde kunde;
	private JTable table;
	private JTextField txtModellnummer;
	private String talking;
	private String search = "";

	/**
	 * Create the panel.
	 */
	public BuchungModellSucheGUI(IObjektModel smodel, BuchungModellSucheStrg scontroller) {
		model = smodel;
		controller = scontroller;
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtSearchbar = new JTextField();
		txtSearchbar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				talking = "search";
				search = txtSearchbar.getText();
				anfrage();
				
			}
		});
		txtSearchbar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearchbar.setText("Modellname...");
		txtSearchbar.setColumns(10);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtModellnummer = new JTextField();
		txtModellnummer.setHorizontalAlignment(SwingConstants.CENTER);
		txtModellnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtModellnummer.setEditable(false);
		txtModellnummer.setColumns(10);
		
		JLabel lblAusgewhlteModellnummer = new JLabel("Ausgew\u00E4hlte Modellnummer:");
		lblAusgewhlteModellnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAusgewhlteModellnummer, GroupLayout.PREFERRED_SIZE, 261, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtModellnummer, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtSearchbar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
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
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtSearchbar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtModellnummer, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblAusgewhlteModellnummer, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
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
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				talking = "table";
				try {
					
					int row = table.getSelectedRow();
					txtModellnummer.setText(table.getModel().getValueAt(row, 0).toString());
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
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
				MainFrame.change(MainFrame.getBuchungModellSucheGUI(), MainFrame.getBuchungTypSucheGUI());
				
			}
		});
		
		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					if(txtModellnummer.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Bitte Modell auswählen!");
					else 
					{
						MainFrame.getBuchungGeraetSucheGUI().setKunde(kunde);
						MainFrame.getBuchungGeraetSucheGUI().setModellNr(Integer.parseInt(txtModellnummer.getText()));
						MainFrame.getBuchungGeraetSucheGUI().setkNr(kNr);
						MainFrame.change(MainFrame.getBuchungModellSucheGUI(), MainFrame.getBuchungGeraetSucheGUI());
						System.out.println("Kunde: " + kunde.toString() + "Modellnummer: " + MainFrame.getBuchungGeraetSucheGUI().getModellNr() + "Kundennummer: " + kNr);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				talking = "master";
				anfrage();
				
			}

			
		});
		
	}
	


	@Override
	public void aktualisieren(IObjektModel model) {
		
		table.setModel(model.getTableModel());
		
	}



	public IKunde getKunde() {
		return kunde;
	}



	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}



	public int getTypNr() {
		return typNr;
	}



	public void setTypNr(int typNr) {
		this.typNr = typNr;
	}



	public int getkNr() {
		return kNr;
	}



	public void setkNr(int kNr) {
		this.kNr = kNr;
	}
	private void anfrage() {
		model.anmelden(MainFrame.getBuchungModellSucheGUI());
		controller.fetchModelle(talking, typNr, search);
		model.abmelden(MainFrame.getBuchungModellSucheGUI());
	}
}
