// @author Darnel

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IModel;
import Datenbankmodels.IModelSuche;
import Datenbankmodels.KundeSucheModel;
import Steuerung.KundeSucheStrg;
import TESTPACKAGE.TestController;
import TESTPACKAGE.TestanbindungMVCBEISPIEL;

public class KundeAendern extends JPanel implements IView{
	

	
	private JTextField tfKundennummer;
	private JTextField tfNachname;
	private JTextField tfVorname;
	private JTextField tfPLZ;
	private JTextField tfOrt;
	private JTextField tfStrasse;
	private JTextField tfHausNr;
	
	
	private KundeSucheModel model;
	private KundeSucheStrg controller;
	private JList list = new JList();

	/**
	 * Create the panel.
	 */
	public KundeAendern(KundeSucheModel smodel, KundeSucheStrg scontroller) {
		this.model = smodel;
		this.controller = scontroller;
		model.anmelden(this);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		
		JButton btnZurueck = new JButton("Zur�ck");
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
					.addComponent(btnHauptmen))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZurueck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHauptmen))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		JPanel panel2 = new JPanel();
		add(panel2, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel2.setLayout(gbl_panel);
		
		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKundennummer.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblKundennummer = new GridBagConstraints();
		gbc_lblKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennummer.anchor = GridBagConstraints.EAST;
		gbc_lblKundennummer.gridx = 0;
		gbc_lblKundennummer.gridy = 0;
		panel2.add(lblKundennummer, gbc_lblKundennummer);
		
		tfKundennummer = new JTextField();
		tfKundennummer.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel2.add(tfKundennummer, gbc_textField);
		tfKundennummer.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNachname.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.anchor = GridBagConstraints.EAST;
		gbc_lblNachname.gridx = 0;
		gbc_lblNachname.gridy = 1;
		panel2.add(lblNachname, gbc_lblNachname);
		
		tfNachname = new JTextField();
		tfNachname.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel2.add(tfNachname, gbc_textField_1);
		tfNachname.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVorname.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.gridx = 0;
		gbc_lblVorname.gridy = 2;
		panel2.add(lblVorname, gbc_lblVorname);
		
		tfVorname = new JTextField();
		tfVorname.setPreferredSize(new Dimension(30, 25));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel2.add(tfVorname, gbc_textField_2);
		tfVorname.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setMaximumSize(new Dimension(100, 35));
		comboBox.setPreferredSize(new Dimension(80, 35));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		panel2.add(comboBox, gbc_comboBox);
		comboBox.addItem("Heimatadresse");
		comboBox.addItem("Urlaubsadresse");
		
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlz.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.anchor = GridBagConstraints.EAST;
		gbc_lblPlz.gridx = 0;
		gbc_lblPlz.gridy = 4;
		panel2.add(lblPlz, gbc_lblPlz);
		
		tfPLZ = new JTextField();
		tfPLZ.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		panel2.add(tfPLZ, gbc_textField_3);
		tfPLZ.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrt.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.anchor = GridBagConstraints.EAST;
		gbc_lblOrt.gridx = 0;
		gbc_lblOrt.gridy = 5;
		panel2.add(lblOrt, gbc_lblOrt);
		
		tfOrt = new JTextField();
		tfOrt.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		panel2.add(tfOrt, gbc_textField_4);
		tfOrt.setColumns(10);
		
		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStrasse.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblStrasse = new GridBagConstraints();
		gbc_lblStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse.anchor = GridBagConstraints.EAST;
		gbc_lblStrasse.gridx = 0;
		gbc_lblStrasse.gridy = 6;
		panel2.add(lblStrasse, gbc_lblStrasse);
		
		tfStrasse = new JTextField();
		tfStrasse.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 2;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 6;
		panel2.add(tfStrasse, gbc_textField_5);
		tfStrasse.setColumns(10);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHausnummer.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.anchor = GridBagConstraints.EAST;
		gbc_lblHausnummer.gridx = 0;
		gbc_lblHausnummer.gridy = 7;
		panel2.add(lblHausnummer, gbc_lblHausnummer);
		
		tfHausNr = new JTextField();
		tfHausNr.setPreferredSize(new Dimension(6, 25));
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 7;
		panel2.add(tfHausNr, gbc_textField_6);
		tfHausNr.setColumns(10);
		
		JButton btnLeeren = new JButton("Leeren");
		btnLeeren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLeeren.setPreferredSize(new Dimension(120, 35));
		GridBagConstraints gbc_btnLeeren = new GridBagConstraints();
		gbc_btnLeeren.gridheight = 2;
		gbc_btnLeeren.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeeren.gridx = 1;
		gbc_btnLeeren.gridy = 8;
		panel2.add(btnLeeren, gbc_btnLeeren);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuchen.setPreferredSize(new Dimension(120, 35));
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.gridheight = 2;
		gbc_btnSuchen.insets = new Insets(0, 0, 5, 0);
		gbc_btnSuchen.gridx = 2;
		gbc_btnSuchen.gridy = 8;
		panel2.add(btnSuchen, gbc_btnSuchen);
		
		JPanel panel3 = new JPanel();
		add(panel3, BorderLayout.SOUTH);
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel3.rowHeights = new int[]{0, 0, 0};
		gbl_panel3.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel3.rowWeights = new double[]{1.0, 1.0, 0.0};
		panel3.setLayout(gbl_panel3);
		
		JList list = new JList();
		list.setPreferredSize(new Dimension(0, 200));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 11;
		gbc_list.gridheight = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel3.add(list, gbc_list);
		
		JButton btnDeaktivieren = new JButton("Deaktivieren");
		btnDeaktivieren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeaktivieren.setMinimumSize(new Dimension(200, 35));
		btnDeaktivieren.setMaximumSize(new Dimension(150, 35));
		btnDeaktivieren.setPreferredSize(new Dimension(200, 35));
		GridBagConstraints gbc_btnKundeRegistrieren = new GridBagConstraints();
		gbc_btnKundeRegistrieren.gridwidth = 2;
		gbc_btnKundeRegistrieren.anchor = GridBagConstraints.WEST;
		gbc_btnKundeRegistrieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnKundeRegistrieren.gridx = 0;
		gbc_btnKundeRegistrieren.gridy = 2;
		panel3.add(btnDeaktivieren, gbc_btnKundeRegistrieren);
		
		JButton btnAuswaehlen = new JButton("Ausw�hlen");
		btnAuswaehlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAuswaehlen.setMinimumSize(new Dimension(150, 35));
		btnAuswaehlen.setPreferredSize(new Dimension(150, 36));
		GridBagConstraints gbc_btnAuswhlen = new GridBagConstraints();
		gbc_btnAuswhlen.gridx = 10;
		gbc_btnAuswhlen.gridy = 2;
		panel3.add(btnAuswaehlen, gbc_btnAuswhlen);
		
		
		/**
		 * @author Ben S
		**/
		
		//Funktionen der Button
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendern(), MainFrame.getKundenverwaltung());
			}
		});

		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getKundeAendern(), MainFrame.getHauptmenue());
			}
		});
		
		btnLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfKundennummer.setText("");
				tfNachname.setText("");
				tfVorname.setText("");
				tfPLZ.setText("");
				tfOrt.setText("");
				tfStrasse.setText("");
				tfHausNr.setText("");
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.fetchKunde(tfKundennummer.getText(), tfNachname.getText(), tfVorname.getText(), tfPLZ.getText(), tfOrt.getText(), tfStrasse.getText(), tfHausNr.getText());
			}
		});
		
		btnAuswaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAuswaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

	}
	





	public void aktualisierenSuche(IModelSuche model) {
		/*
		 * Hier aktualisiert das Fenster sich nach jeder �nderung im Model
		 */
		
		
	}






	@Override
	public void aktualisieren(IModel model) {
		// TODO Auto-generated method stub
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		dlm = model.holeModel();
		list.setModel(dlm);
	}





}
