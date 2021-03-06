package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.controller.BuchungTypSucheStrg;
import com.entity.IKunde;
import com.model.BuchungTypSucheModel;
import com.model.IModel;
import com.model.IObjektModel;

import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
 
public class BuchungTypSucheGUI extends JPanel implements IObjektView { //Ben Kr�ncke
	private JTextField tfSuche;

	private BuchungTypSucheStrg controller;
	private IObjektModel model;
	private int knr;
	private JTable table;
	private String talking = "master";
	private JTextField txtTypID;
	private IKunde kunde;
	private TableModel standard = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public BuchungTypSucheGUI(IObjektModel smodel, BuchungTypSucheStrg scontroller) {
		model = smodel;
		controller = scontroller;

		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBackground(new Color(255, 140, 0));
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));

		tfSuche = new JTextField();
		tfSuche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				talking = "name";
				anfrage();
			}
		});
		tfSuche.setColumns(10);

		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBackground(new Color(255, 140, 0));
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtTypID = new JTextField();
		txtTypID.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypID.setEditable(false);
		txtTypID.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTypID.setColumns(10);

		JLabel lblAusgewhlteTypennummer = new JLabel("Ausgew\u00E4hlte Typennummer:");
		lblAusgewhlteTypennummer.setForeground(Color.WHITE);
		lblAusgewhlteTypennummer.setBackground(Color.WHITE);
		lblAusgewhlteTypennummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAusgewhlteTypennummer)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTypID, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
						.addComponent(tfSuche, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAusgewhlteTypennummer)
								.addComponent(txtTypID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfSuche, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel infoLabel = new JLabel(
				"Folgende Ger\u00E4tetypen k\u00F6nnen aufgrund vorhandener F\u00FChrerscheine ausgeliehen werden:");
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.anchor = GridBagConstraints.SOUTH;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_infoLabel.gridx = 0;
		gbc_infoLabel.gridy = 0;
		panel_1.add(infoLabel, gbc_infoLabel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				talking = "table";
				try {

					int row = table.getSelectedRow();
					txtTypID.setText(table.getModel().getValueAt(row, 0).toString());
					JOptionPane.showMessageDialog(null, "Typ mit ID: " + txtTypID.getText() + " gew�hlt!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		add(panel_2, BorderLayout.SOUTH);

		JButton btnAuswhlen = new JButton("Ausw\u00E4hlen");
		btnAuswhlen.setBackground(new Color(255, 140, 0));
		btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap(300, Short.MAX_VALUE)
						.addComponent(btnAuswhlen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addComponent(btnAuswhlen,
						GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)));
		panel_2.setLayout(gl_panel_2);

		// Funktionen der Button @author Ben Kr�ncke
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getBuchungTypSucheGUI(), MainFrame.getBuchungKundeSucheGUI());
				txtTypID.setText("");
				table.setModel(standard);
			}
		});

		btnAuswhlen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					if (txtTypID.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Keinen Typ gew�hlt!");
					else {
						MainFrame.getBuchungModellSucheGUI().setKunde(kunde);
						MainFrame.getBuchungModellSucheGUI().setTypNr(Integer.parseInt(txtTypID.getText()));
						MainFrame.getBuchungModellSucheGUI().setkNr(knr);
						System.out.println(MainFrame.getBuchungModellSucheGUI().getTypNr());
						MainFrame.change(MainFrame.getBuchungTypSucheGUI(), MainFrame.getBuchungModellSucheGUI());
						txtTypID.setText("");
						table.setModel(standard);
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

	private void anfrage() {
		model.anmelden(MainFrame.getBuchungTypSucheGUI());
		controller.fetchTypen(knr, talking, tfSuche.getText(), kunde);
		model.abmelden(MainFrame.getBuchungTypSucheGUI());
	}

	public int getKnr() {
		return knr;
	}

	public void setKnr(int knr) {
		this.knr = knr;
	}

	public IKunde getKunde() {
		return kunde;
	}

	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}
}
