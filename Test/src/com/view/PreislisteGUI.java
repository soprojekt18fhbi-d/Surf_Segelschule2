/**
 * @author Ben Schultz
 */

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.controller.PreislisteAendernStrg;
import com.controller.PreislisteSucheStrg;
import com.model.IAnlegenModel;
import com.model.IModelSuche;
import com.model.IObjektModel;
import com.model.PreislisteSucheModel;

public class PreislisteGUI extends JPanel implements IObjektView {
	private JTextField tfSuche;
	private JTable table;
	private PreislisteSucheStrg sController;
	private IObjektModel oModel;
	private String talking;
	private JTextField tfSuchID;

	public PreislisteGUI(IObjektModel smodel, PreislisteSucheStrg scontroller) {

		this.oModel = smodel;
		this.sController = scontroller;

		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.NORTH);

		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZurck.setBackground(new Color(255, 140, 0));

		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuchen.setBackground(new Color(255, 140, 0));

		tfSuche = new JTextField();
		tfSuche.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSuche.setColumns(10);

		tfSuche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				try {
					talking = "master";
					anfrage();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		tfSuchID = new JTextField();
		tfSuchID.setHorizontalAlignment(SwingConstants.CENTER);
		tfSuchID.setEditable(false);
		tfSuchID.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfSuchID.setColumns(10);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addComponent(tfSuche, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfSuche, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(17, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnPreislisteHinzu = new JButton("Preisliste hinzuf\u00FCgen");
		btnPreislisteHinzu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPreislisteHinzu.setBackground(new Color(255, 140, 0));
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
		btnPreislisteAendern.setBackground(new Color(255, 140, 0));
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

		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				talking = "master";
				try {

					int row = table.getSelectedRow();
					tfSuchID.setText(table.getModel().getValueAt(row, 0).toString());
					JOptionPane.showMessageDialog(null, "Preisliste mit ID: " + table.getModel().getValueAt(table.getSelectedRow(), 0) + " gew�hlt!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setMinimumSize(new Dimension(0, 500));
		tableModel.addColumn("ID");
		tableModel.addColumn("EineStd");
		tableModel.addColumn("ZweiStd");
		tableModel.addColumn("VierStd");
		tableModel.addColumn("EinenTag");
		tableModel.addColumn("ZweiTage");
		tableModel.addColumn("DreiTage");
		tableModel.addColumn("VierTage");
		tableModel.addColumn("FuenfTage");
		tableModel.addColumn("SechsSiebenTage");
		tableModel.addColumn("AchtTage");
		tableModel.addColumn("NeunTage");
		tableModel.addColumn("ZehnTage");
		tableModel.addColumn("ElfTage");
		tableModel.addColumn("ZwoelfVierzehnTage");
		tableModel.addColumn("FuenfzehnTage");
		tableModel.addColumn("SechzehnTage");
		tableModel.addColumn("SiebzehnTage");
		tableModel.addColumn("AchtzehnEinundzwanzigTage");
		tableModel.addColumn("TagVierWochen");
		tableModel.addColumn("VierWochen");

		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		scrollPane.setViewportView(table);

		GridBagConstraints gbc_btnAuswhlen = new GridBagConstraints();
		gbc_btnAuswhlen.anchor = GridBagConstraints.EAST;
		gbc_btnAuswhlen.fill = GridBagConstraints.VERTICAL;
		gbc_btnAuswhlen.gridx = 1;
		gbc_btnAuswhlen.gridy = 7;

		// Funktionen der Button
		btnZurck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getGeraeteVerwaltungGUI());
				tableLeeren();

			}
		});

		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				talking = "master";
				anfrage();

			}

		});

		btnPreislisteHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getPreislisteAnlegenGUI());
				tableLeeren();
			}
		});

		btnPreislisteAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int zeile = table.getSelectedRow();

				if (zeile < 0)
					JOptionPane.showMessageDialog(null, "Bitte eine Preisliste ausw�hlen.");
				else {

					String[] preislistetabelle = tableRowToArray(table);
					MainFrame.getPreislisteAendernGUI().setPreislisteTextfelder(preislistetabelle);

					MainFrame.change(MainFrame.getPreislisteGUI(), MainFrame.getPreislisteAendernGUI());
					tableLeeren();
				}

			}
		});

	}

	@Override
	public void aktualisieren(IObjektModel model) {
		table.setModel(model.getTableModel());

	}

	public void anfrage() {
		oModel.anmelden(MainFrame.getBuchungTypSucheGUI());
		sController.fetchObjekte(talking, tfSuche.getText());
		table.setModel(oModel.getTableModel());
		oModel.abmelden(MainFrame.getBuchungTypSucheGUI());
	}

	public String[] tableRowToArray(JTable table) {
		//Der Inhalt einer aus der Tabelle ausgew�hlten Zeile wird in ein Array �bertragen,
		//um dies unabh�ngig von Typ in der n�chsten GUI weiter zu verwenden.
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		int nCol = dtm.getColumnCount();
		String[] tableData = new String[nCol];
		for (int j = 0; j < nCol; j++)
			tableData[j] = String.valueOf(dtm.getValueAt(selectedRowIndex, j));
		return tableData;
	}

	private void tableLeeren() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		while (dm.getRowCount() > 0) {
			dm.removeRow(0);
		}
	}

}
