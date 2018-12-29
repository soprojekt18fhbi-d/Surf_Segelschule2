/**
 * @author Ben S
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

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Berechnung.DatentypUmwandlung;
import Datenbankmodels.IAnlegenModel;
import Datenbankmodels.PreislisteAnlegenModel;
import Steuerung.PreislisteAnlegenStrg;

public class PreislisteAnlegenGUI extends JPanel implements IAnlegenView {

	PreislisteAnlegenModel model;
	PreislisteAnlegenStrg controller;

	private JTextField tfEineStd;
	private JTextField tfZweiStd;
	private JTextField tfVierStd;
	private JTextField tfEinTag;
	private JTextField tfZweiTage;
	private JTextField tfDreiTage;
	private JTextField tfFuenfTage;
	private JTextField tfVierTage;
	private JTextField tfAchtTage;
	private JTextField tfSechsSiebenTage;
	private JTextField tfZehnTage;
	private JTextField tfNeunTage;
	private JTextField tfElfTage;
	private JTextField tfZwoelfVierzehnTage;
	private JTextField tfFuenfzehnTage;
	private JTextField tfSechzehnTage;
	private JTextField tfSiebzehnTage;
	private JTextField tfAchtzehnEinundZwTage;
	private JTextField tfProTagVierW;
	private JTextField tfVierWochen;
	private JTextField tfAchtWochen;
	private JTextField tfKauf;
	private JTextField textField_19;
	private JTextField textField_20;

	/**
	 * 
	 * Create the panel.
	 */
	public PreislisteAnlegenGUI()  {
		model = new PreislisteAnlegenModel();
		controller = new PreislisteAnlegenStrg(model);
		model.anmelden(this);
		
		setSize(900,550);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 30, 30, 0, 30, 30, 0, 30, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPreislisteHinzufgen = new JLabel("Preisliste hinzuf\u00FCgen:");
		lblPreislisteHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblPreislisteHinzufgen = new GridBagConstraints();
		gbc_lblPreislisteHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblPreislisteHinzufgen.gridwidth = 3;
		gbc_lblPreislisteHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreislisteHinzufgen.gridx = 3;
		gbc_lblPreislisteHinzufgen.gridy = 1;
		panel.add(lblPreislisteHinzufgen, gbc_lblPreislisteHinzufgen);
		
		JLabel lblEineStd = new JLabel("1 Std:");
		lblEineStd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblEineStd = new GridBagConstraints();
		gbc_lblEineStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEineStd.insets = new Insets(0, 0, 5, 5);
		gbc_lblEineStd.gridx = 1;
		gbc_lblEineStd.gridy = 2;
		panel.add(lblEineStd, gbc_lblEineStd);
		
		tfEineStd = new JTextField();
		tfEineStd.setPreferredSize(new Dimension(6, 40));
		tfEineStd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_tfEineStd = new GridBagConstraints();
		gbc_tfEineStd.insets = new Insets(0, 0, 5, 5);
		gbc_tfEineStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEineStd.gridx = 2;
		gbc_tfEineStd.gridy = 2;
		panel.add(tfEineStd, gbc_tfEineStd);
		tfEineStd.setColumns(10);
		
		JLabel lblSechsSiebenTage = new JLabel("6 - 7 Tage:");
		lblSechsSiebenTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblSechsSiebenTage = new GridBagConstraints();
		gbc_lblSechsSiebenTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSechsSiebenTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblSechsSiebenTage.gridx = 4;
		gbc_lblSechsSiebenTage.gridy = 2;
		panel.add(lblSechsSiebenTage, gbc_lblSechsSiebenTage);
		
		tfSechsSiebenTage = new JTextField();
		tfSechsSiebenTage.setPreferredSize(new Dimension(6, 40));
		tfSechsSiebenTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSechsSiebenTage.setColumns(10);
		GridBagConstraints gbc_tfSechsSiebenTage = new GridBagConstraints();
		gbc_tfSechsSiebenTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfSechsSiebenTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSechsSiebenTage.gridx = 5;
		gbc_tfSechsSiebenTage.gridy = 2;
		panel.add(tfSechsSiebenTage, gbc_tfSechsSiebenTage);
		
		JLabel lblSiebzehnTage = new JLabel("17 Tage:");
		lblSiebzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblSiebzehnTage = new GridBagConstraints();
		gbc_lblSiebzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSiebzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblSiebzehnTage.gridx = 7;
		gbc_lblSiebzehnTage.gridy = 2;
		panel.add(lblSiebzehnTage, gbc_lblSiebzehnTage);
		
		tfSiebzehnTage = new JTextField();
		tfSiebzehnTage.setPreferredSize(new Dimension(6, 40));
		tfSiebzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSiebzehnTage.setColumns(10);
		GridBagConstraints gbc_tfSiebzehnTage = new GridBagConstraints();
		gbc_tfSiebzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfSiebzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSiebzehnTage.gridx = 8;
		gbc_tfSiebzehnTage.gridy = 2;
		panel.add(tfSiebzehnTage, gbc_tfSiebzehnTage);
		
		JLabel lblZweiStd = new JLabel("2 Std:");
		lblZweiStd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblZweiStd = new GridBagConstraints();
		gbc_lblZweiStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblZweiStd.insets = new Insets(0, 0, 5, 5);
		gbc_lblZweiStd.gridx = 1;
		gbc_lblZweiStd.gridy = 3;
		panel.add(lblZweiStd, gbc_lblZweiStd);
		
		tfZweiStd = new JTextField();
		tfZweiStd.setPreferredSize(new Dimension(6, 40));
		tfZweiStd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_tfZweiStd = new GridBagConstraints();
		gbc_tfZweiStd.insets = new Insets(0, 0, 5, 5);
		gbc_tfZweiStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfZweiStd.gridx = 2;
		gbc_tfZweiStd.gridy = 3;
		panel.add(tfZweiStd, gbc_tfZweiStd);
		tfZweiStd.setColumns(10);
		
		JLabel lblAchtTage = new JLabel("8 Tage:");
		lblAchtTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblAchtTage = new GridBagConstraints();
		gbc_lblAchtTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAchtTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblAchtTage.gridx = 4;
		gbc_lblAchtTage.gridy = 3;
		panel.add(lblAchtTage, gbc_lblAchtTage);
		
		tfAchtTage = new JTextField();
		tfAchtTage.setPreferredSize(new Dimension(6, 40));
		tfAchtTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfAchtTage.setColumns(10);
		GridBagConstraints gbc_tfAchtTage = new GridBagConstraints();
		gbc_tfAchtTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfAchtTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAchtTage.gridx = 5;
		gbc_tfAchtTage.gridy = 3;
		panel.add(tfAchtTage, gbc_tfAchtTage);
		
		JLabel lblAchtzehnEinundZwTage = new JLabel("18 - 21 Tage:");
		lblAchtzehnEinundZwTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblAchtzehnEinundZwTage = new GridBagConstraints();
		gbc_lblAchtzehnEinundZwTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAchtzehnEinundZwTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblAchtzehnEinundZwTage.gridx = 7;
		gbc_lblAchtzehnEinundZwTage.gridy = 3;
		panel.add(lblAchtzehnEinundZwTage, gbc_lblAchtzehnEinundZwTage);
		
		tfAchtzehnEinundZwTage = new JTextField();
		tfAchtzehnEinundZwTage.setPreferredSize(new Dimension(6, 40));
		tfAchtzehnEinundZwTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfAchtzehnEinundZwTage.setColumns(10);
		GridBagConstraints gbc_tfAchtzehnEinundZwTage = new GridBagConstraints();
		gbc_tfAchtzehnEinundZwTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfAchtzehnEinundZwTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAchtzehnEinundZwTage.gridx = 8;
		gbc_tfAchtzehnEinundZwTage.gridy = 3;
		panel.add(tfAchtzehnEinundZwTage, gbc_tfAchtzehnEinundZwTage);
		
		JLabel lblVierStd = new JLabel("4 Std:");
		lblVierStd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblVierStd = new GridBagConstraints();
		gbc_lblVierStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVierStd.insets = new Insets(0, 0, 5, 5);
		gbc_lblVierStd.gridx = 1;
		gbc_lblVierStd.gridy = 4;
		panel.add(lblVierStd, gbc_lblVierStd);
		
		tfVierStd = new JTextField();
		tfVierStd.setPreferredSize(new Dimension(6, 40));
		tfVierStd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVierStd.setColumns(10);
		GridBagConstraints gbc_tfVierStd = new GridBagConstraints();
		gbc_tfVierStd.insets = new Insets(0, 0, 5, 5);
		gbc_tfVierStd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVierStd.gridx = 2;
		gbc_tfVierStd.gridy = 4;
		panel.add(tfVierStd, gbc_tfVierStd);
		
		JLabel lblNeunTage = new JLabel("9 Tage:");
		lblNeunTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblNeunTage = new GridBagConstraints();
		gbc_lblNeunTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNeunTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblNeunTage.gridx = 4;
		gbc_lblNeunTage.gridy = 4;
		panel.add(lblNeunTage, gbc_lblNeunTage);
		
		tfNeunTage = new JTextField();
		tfNeunTage.setPreferredSize(new Dimension(6, 40));
		tfNeunTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfNeunTage.setColumns(10);
		GridBagConstraints gbc_tfNeunTage = new GridBagConstraints();
		gbc_tfNeunTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfNeunTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNeunTage.gridx = 5;
		gbc_tfNeunTage.gridy = 4;
		panel.add(tfNeunTage, gbc_tfNeunTage);
		
		JLabel lblProTagVierW = new JLabel("+ Pro Tag - 4 W");
		lblProTagVierW.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblProTagVierW = new GridBagConstraints();
		gbc_lblProTagVierW.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProTagVierW.insets = new Insets(0, 0, 5, 5);
		gbc_lblProTagVierW.gridx = 7;
		gbc_lblProTagVierW.gridy = 4;
		panel.add(lblProTagVierW, gbc_lblProTagVierW);
		
		tfProTagVierW = new JTextField();
		tfProTagVierW.setPreferredSize(new Dimension(6, 40));
		tfProTagVierW.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProTagVierW.setColumns(10);
		GridBagConstraints gbc_tfProTagVierW = new GridBagConstraints();
		gbc_tfProTagVierW.insets = new Insets(0, 0, 5, 5);
		gbc_tfProTagVierW.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProTagVierW.gridx = 8;
		gbc_tfProTagVierW.gridy = 4;
		panel.add(tfProTagVierW, gbc_tfProTagVierW);
		
		JLabel lblEinTag = new JLabel("1 Tag:");
		lblEinTag.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblEinTag = new GridBagConstraints();
		gbc_lblEinTag.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEinTag.insets = new Insets(0, 0, 5, 5);
		gbc_lblEinTag.gridx = 1;
		gbc_lblEinTag.gridy = 5;
		panel.add(lblEinTag, gbc_lblEinTag);
		
		tfEinTag = new JTextField();
		tfEinTag.setPreferredSize(new Dimension(6, 40));
		tfEinTag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEinTag.setColumns(10);
		GridBagConstraints gbc_tfEinTag = new GridBagConstraints();
		gbc_tfEinTag.insets = new Insets(0, 0, 5, 5);
		gbc_tfEinTag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEinTag.gridx = 2;
		gbc_tfEinTag.gridy = 5;
		panel.add(tfEinTag, gbc_tfEinTag);
		
		JLabel lblZehnTage = new JLabel("10 Tage:");
		lblZehnTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblZehnTage = new GridBagConstraints();
		gbc_lblZehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblZehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblZehnTage.gridx = 4;
		gbc_lblZehnTage.gridy = 5;
		panel.add(lblZehnTage, gbc_lblZehnTage);
		
		tfZehnTage = new JTextField();
		tfZehnTage.setPreferredSize(new Dimension(6, 40));
		tfZehnTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfZehnTage.setColumns(10);
		GridBagConstraints gbc_tfZehnTage = new GridBagConstraints();
		gbc_tfZehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfZehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfZehnTage.gridx = 5;
		gbc_tfZehnTage.gridy = 5;
		panel.add(tfZehnTage, gbc_tfZehnTage);
		
		JLabel lblVierWochen = new JLabel("4 Wochen:");
		lblVierWochen.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblVierWochen = new GridBagConstraints();
		gbc_lblVierWochen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVierWochen.insets = new Insets(0, 0, 5, 5);
		gbc_lblVierWochen.gridx = 7;
		gbc_lblVierWochen.gridy = 5;
		panel.add(lblVierWochen, gbc_lblVierWochen);
		
		tfVierWochen = new JTextField();
		tfVierWochen.setPreferredSize(new Dimension(6, 40));
		tfVierWochen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVierWochen.setColumns(10);
		GridBagConstraints gbc_tfVierWochen = new GridBagConstraints();
		gbc_tfVierWochen.insets = new Insets(0, 0, 5, 5);
		gbc_tfVierWochen.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVierWochen.gridx = 8;
		gbc_tfVierWochen.gridy = 5;
		panel.add(tfVierWochen, gbc_tfVierWochen);
		
		JLabel lblZweiTage = new JLabel("2 Tage:");
		lblZweiTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblZweiTage = new GridBagConstraints();
		gbc_lblZweiTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblZweiTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblZweiTage.gridx = 1;
		gbc_lblZweiTage.gridy = 6;
		panel.add(lblZweiTage, gbc_lblZweiTage);
		
		tfZweiTage = new JTextField();
		tfZweiTage.setPreferredSize(new Dimension(6, 40));
		tfZweiTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfZweiTage.setColumns(10);
		GridBagConstraints gbc_tfZweiTage = new GridBagConstraints();
		gbc_tfZweiTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfZweiTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfZweiTage.gridx = 2;
		gbc_tfZweiTage.gridy = 6;
		panel.add(tfZweiTage, gbc_tfZweiTage);
		
		JLabel lblElfTage = new JLabel("11 Tage:");
		lblElfTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblElfTage = new GridBagConstraints();
		gbc_lblElfTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblElfTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblElfTage.gridx = 4;
		gbc_lblElfTage.gridy = 6;
		panel.add(lblElfTage, gbc_lblElfTage);
		
		tfElfTage = new JTextField();
		tfElfTage.setPreferredSize(new Dimension(6, 40));
		tfElfTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfElfTage.setColumns(10);
		GridBagConstraints gbc_tfElfTage = new GridBagConstraints();
		gbc_tfElfTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfElfTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfElfTage.gridx = 5;
		gbc_tfElfTage.gridy = 6;
		panel.add(tfElfTage, gbc_tfElfTage);
		
		JLabel lblAchtWochen = new JLabel("8 Wochen:");
		lblAchtWochen.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblAchtWochen = new GridBagConstraints();
		gbc_lblAchtWochen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAchtWochen.insets = new Insets(0, 0, 5, 5);
		gbc_lblAchtWochen.gridx = 7;
		gbc_lblAchtWochen.gridy = 6;
		panel.add(lblAchtWochen, gbc_lblAchtWochen);
		
		tfAchtWochen = new JTextField();
		tfAchtWochen.setPreferredSize(new Dimension(6, 40));
		tfAchtWochen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfAchtWochen.setColumns(10);
		GridBagConstraints gbc_tfAchtWochen = new GridBagConstraints();
		gbc_tfAchtWochen.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_tfAchtWochen.insets = new Insets(0, 0, 5, 5);
		gbc_tfAchtWochen.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAchtWochen.gridx = 8;
		gbc_tfAchtWochen.gridy = 6;
		panel.add(tfAchtWochen, gbc_tfAchtWochen);
		
		JLabel lblDreiTage = new JLabel("3 Tage:");
		lblDreiTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblDreiTage = new GridBagConstraints();
		gbc_lblDreiTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDreiTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDreiTage.gridx = 1;
		gbc_lblDreiTage.gridy = 7;
		panel.add(lblDreiTage, gbc_lblDreiTage);
		
		tfDreiTage = new JTextField();
		tfDreiTage.setPreferredSize(new Dimension(6, 40));
		tfDreiTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfDreiTage.setColumns(10);
		GridBagConstraints gbc_tfDreiTage = new GridBagConstraints();
		gbc_tfDreiTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfDreiTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDreiTage.gridx = 2;
		gbc_tfDreiTage.gridy = 7;
		panel.add(tfDreiTage, gbc_tfDreiTage);
		
		JLabel lblZwoelfVierzehnTage = new JLabel("12 - 14 Tage:");
		lblZwoelfVierzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblZwoelfVierzehnTage = new GridBagConstraints();
		gbc_lblZwoelfVierzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblZwoelfVierzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblZwoelfVierzehnTage.gridx = 4;
		gbc_lblZwoelfVierzehnTage.gridy = 7;
		panel.add(lblZwoelfVierzehnTage, gbc_lblZwoelfVierzehnTage);
		
		tfZwoelfVierzehnTage = new JTextField();
		tfZwoelfVierzehnTage.setPreferredSize(new Dimension(6, 40));
		tfZwoelfVierzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfZwoelfVierzehnTage.setColumns(10);
		GridBagConstraints gbc_tfZwoelfVierzehnTage = new GridBagConstraints();
		gbc_tfZwoelfVierzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfZwoelfVierzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfZwoelfVierzehnTage.gridx = 5;
		gbc_tfZwoelfVierzehnTage.gridy = 7;
		panel.add(tfZwoelfVierzehnTage, gbc_tfZwoelfVierzehnTage);
		
		JLabel lblKauf = new JLabel("Kauf:");
		lblKauf.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblKauf = new GridBagConstraints();
		gbc_lblKauf.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKauf.insets = new Insets(0, 0, 5, 5);
		gbc_lblKauf.gridx = 7;
		gbc_lblKauf.gridy = 7;
		panel.add(lblKauf, gbc_lblKauf);
		
		tfKauf = new JTextField();
		tfKauf.setPreferredSize(new Dimension(6, 40));
		tfKauf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfKauf.setColumns(10);
		GridBagConstraints gbc_tfKauf = new GridBagConstraints();
		gbc_tfKauf.insets = new Insets(0, 0, 5, 5);
		gbc_tfKauf.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKauf.gridx = 8;
		gbc_tfKauf.gridy = 7;
		panel.add(tfKauf, gbc_tfKauf);
		
		JLabel lblVierTage = new JLabel("4 Tage:");
		lblVierTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblVierTage = new GridBagConstraints();
		gbc_lblVierTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVierTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblVierTage.gridx = 1;
		gbc_lblVierTage.gridy = 8;
		panel.add(lblVierTage, gbc_lblVierTage);
		
		tfVierTage = new JTextField();
		tfVierTage.setPreferredSize(new Dimension(6, 40));
		tfVierTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVierTage.setColumns(10);
		GridBagConstraints gbc_tfVierTage = new GridBagConstraints();
		gbc_tfVierTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfVierTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVierTage.gridx = 2;
		gbc_tfVierTage.gridy = 8;
		panel.add(tfVierTage, gbc_tfVierTage);
		
		JLabel lblFuenfzehnTage = new JLabel("15 Tage:");
		lblFuenfzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblFuenfzehnTage = new GridBagConstraints();
		gbc_lblFuenfzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFuenfzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuenfzehnTage.gridx = 4;
		gbc_lblFuenfzehnTage.gridy = 8;
		panel.add(lblFuenfzehnTage, gbc_lblFuenfzehnTage);
		
		tfFuenfzehnTage = new JTextField();
		tfFuenfzehnTage.setPreferredSize(new Dimension(6, 40));
		tfFuenfzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfFuenfzehnTage.setColumns(10);
		GridBagConstraints gbc_tfFuenfzehnTage = new GridBagConstraints();
		gbc_tfFuenfzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfFuenfzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFuenfzehnTage.gridx = 5;
		gbc_tfFuenfzehnTage.gridy = 8;
		panel.add(tfFuenfzehnTage, gbc_tfFuenfzehnTage);
		
		JLabel lblTest = new JLabel("Test");
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTest.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest.gridx = 7;
		gbc_lblTest.gridy = 8;
		panel.add(lblTest, gbc_lblTest);
		
		textField_19 = new JTextField();
		textField_19.setPreferredSize(new Dimension(6, 40));
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_19.setColumns(10);
		GridBagConstraints gbc_textField_19 = new GridBagConstraints();
		gbc_textField_19.insets = new Insets(0, 0, 5, 5);
		gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_19.gridx = 8;
		gbc_textField_19.gridy = 8;
		panel.add(textField_19, gbc_textField_19);
		
		JLabel lblFuenfTage = new JLabel("5 Tage:");
		lblFuenfTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblFuenfTage = new GridBagConstraints();
		gbc_lblFuenfTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFuenfTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuenfTage.gridx = 1;
		gbc_lblFuenfTage.gridy = 9;
		panel.add(lblFuenfTage, gbc_lblFuenfTage);
		
		tfFuenfTage = new JTextField();
		tfFuenfTage.setPreferredSize(new Dimension(6, 40));
		tfFuenfTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfFuenfTage.setColumns(10);
		GridBagConstraints gbc_tfFuenfTage = new GridBagConstraints();
		gbc_tfFuenfTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfFuenfTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFuenfTage.gridx = 2;
		gbc_tfFuenfTage.gridy = 9;
		panel.add(tfFuenfTage, gbc_tfFuenfTage);
		
		JLabel lblSechzehnTage = new JLabel("16 Tage:");
		lblSechzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblSechzehnTage = new GridBagConstraints();
		gbc_lblSechzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSechzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_lblSechzehnTage.gridx = 4;
		gbc_lblSechzehnTage.gridy = 9;
		panel.add(lblSechzehnTage, gbc_lblSechzehnTage);
		
		tfSechzehnTage = new JTextField();
		tfSechzehnTage.setPreferredSize(new Dimension(6, 40));
		tfSechzehnTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSechzehnTage.setColumns(10);
		GridBagConstraints gbc_tfSechzehnTage = new GridBagConstraints();
		gbc_tfSechzehnTage.insets = new Insets(0, 0, 5, 5);
		gbc_tfSechzehnTage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSechzehnTage.gridx = 5;
		gbc_tfSechzehnTage.gridy = 9;
		panel.add(tfSechzehnTage, gbc_tfSechzehnTage);
		
		JLabel lblTest_1 = new JLabel("Test");
		lblTest_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTest_1 = new GridBagConstraints();
		gbc_lblTest_1.anchor = GridBagConstraints.NORTH;
		gbc_lblTest_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTest_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest_1.gridx = 7;
		gbc_lblTest_1.gridy = 9;
		panel.add(lblTest_1, gbc_lblTest_1);
		
		textField_20 = new JTextField();
		textField_20.setPreferredSize(new Dimension(6, 40));
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_20.setColumns(10);
		GridBagConstraints gbc_textField_20 = new GridBagConstraints();
		gbc_textField_20.insets = new Insets(0, 0, 5, 5);
		gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_20.gridx = 8;
		gbc_textField_20.gridy = 9;
		panel.add(textField_20, gbc_textField_20);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAnlegen = new JButton("Anlegen");
		btnAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(573, Short.MAX_VALUE)
					.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnlegen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnlegen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		

		
		
		btnAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				
				try {
					
					PreislisteAnlegen();
					
					aktualisieren(model);
					MainFrame.change(MainFrame.getPreislisteAnlegenGUI(), MainFrame.getPreislisteGUI());

					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			private void PreislisteAnlegen() {

				
				
				String  preisEineStdString = tfEineStd.getText();
				String	preisZweiStdString = tfZweiStd.getText();
				String	preisVierStdString = tfVierStd.getText();
				String	preisEinenTagString = tfEinTag.getText();
				String	preisZweiTageString = tfZweiTage.getText();
				String	preisDreiTageString = tfDreiTage.getText();
				String	preisVierTageString = tfVierTage.getText();
				String	preisFuenfTageString = tfFuenfTage.getText();
				String	preisSechsSiebenTageString = tfAchtTage.getText();
				String	preisAchtTageString = tfSechsSiebenTage.getText();
				String	preisNeunTageString= tfNeunTage.getText();
				String	preisZehnTageString = tfZehnTage.getText();
				String	preisElfTageString = tfElfTage.getText();
				String	preisZwoelfVierzehnTageString = tfZwoelfVierzehnTage.getText();
				String	preisFuenfzehnTageString = tfFuenfzehnTage.getText();
				String	preisSechzehnTageString = tfSechzehnTage.getText();
				String	preisSiebzehnTageString = tfSiebzehnTage.getText();
				String	preisAchtzehnEinundzwanzigTageString = tfAchtzehnEinundZwTage.getText();
				String	preisTagVierWochenString = tfProTagVierW.getText();
				String	presVierWochenString = tfVierWochen.getText();
				String	preisAchtWochenString = tfAchtWochen.getText();
				String	preisKaufString = tfKauf.getText();

				double  preisEineStd = DatentypUmwandlung.stringZuDouble(preisEineStdString);
				double  preisZweiStd = DatentypUmwandlung.stringZuDouble(preisZweiStdString);
				double  preisVierStd = DatentypUmwandlung.stringZuDouble(preisVierStdString);
				double  preisEinenTag = DatentypUmwandlung.stringZuDouble(preisEinenTagString);
				double  preisZweiTage = DatentypUmwandlung.stringZuDouble(preisZweiTageString);
				double  preisDreiTage = DatentypUmwandlung.stringZuDouble(preisDreiTageString);
				double  preisVierTage = DatentypUmwandlung.stringZuDouble(preisVierTageString);
				double  preisFuenfTage = DatentypUmwandlung.stringZuDouble(preisFuenfTageString);
				double  preisSechsSiebenTage = DatentypUmwandlung.stringZuDouble(preisSechsSiebenTageString);
				double  preisAchtTage = DatentypUmwandlung.stringZuDouble(preisAchtTageString);
				double  preisNeunTage= DatentypUmwandlung.stringZuDouble(preisNeunTageString);
				double  preisZehnTage = DatentypUmwandlung.stringZuDouble(preisZehnTageString);
				double  preisElfTage = DatentypUmwandlung.stringZuDouble(preisElfTageString);
				double  preisZwoelfVierzehnTage = DatentypUmwandlung.stringZuDouble(preisZwoelfVierzehnTageString);
				double  preisFuenfzehnTage = DatentypUmwandlung.stringZuDouble(preisFuenfzehnTageString);
				double  preisSechzehnTage = DatentypUmwandlung.stringZuDouble(preisSechzehnTageString);
				double  preisSiebzehnTage = DatentypUmwandlung.stringZuDouble(preisSiebzehnTageString);
				double  preisAchtzehnEinundzwanzigTage = DatentypUmwandlung.stringZuDouble(preisAchtzehnEinundzwanzigTageString);
				double  preisTagVierWochen = DatentypUmwandlung.stringZuDouble(preisTagVierWochenString);
				double  presVierWochen = DatentypUmwandlung.stringZuDouble(presVierWochenString);
				double  preisAchtWochen = DatentypUmwandlung.stringZuDouble(preisAchtWochenString);
				double  preisKauf = DatentypUmwandlung.stringZuDouble(preisKaufString);
				

				controller.preislisteUebergeben(preisEineStd,  preisZweiStd,  preisVierStd, preisEinenTag,
						 preisZweiTage,  preisDreiTage,  preisVierTage,  preisFuenfTage,  preisSechsSiebenTage,
						 preisAchtTage,  preisNeunTage,  preisZehnTage,  preisElfTage,  preisZwoelfVierzehnTage,
						 preisFuenfzehnTage,  preisSechzehnTage,  preisSiebzehnTage,  preisAchtzehnEinundzwanzigTage,
						 preisTagVierWochen,  presVierWochen,  preisAchtWochen,  preisKauf);
			}
		});	
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getPreislisteAnlegenGUI(), MainFrame.getPreislisteGUI());			}
		});

	}

	@Override
	public void aktualisieren(IAnlegenModel model) {
		JOptionPane.showMessageDialog(null, "Die Preisliste wurde angelegt!");
	}
	


}
