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

import Datenbankmodels.IAnlegenModel;
import Datenbankmodels.PreislisteAnlegenModel;
import Steuerung.PreislisteAnlegenStrg;

public class PreislisteAnlegenGUI extends JPanel  implements IAnlegenView{

	private JTextField txtPreisliste;
	private JTextField txtID;
	
	PreislisteAnlegenModel model;
	PreislisteAnlegenStrg controller;


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
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPreislisteHinzufgen = new JLabel("Preisliste hinzuf\u00FCgen:");
		lblPreislisteHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblPreislisteHinzufgen = new GridBagConstraints();
		gbc_lblPreislisteHinzufgen.anchor = GridBagConstraints.WEST;
		gbc_lblPreislisteHinzufgen.gridwidth = 2;
		gbc_lblPreislisteHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreislisteHinzufgen.gridx = 2;
		gbc_lblPreislisteHinzufgen.gridy = 2;
		panel.add(lblPreislisteHinzufgen, gbc_lblPreislisteHinzufgen);
		
		JLabel lblPreisliste = new JLabel("Preisliste:");
		lblPreisliste.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblPreisliste = new GridBagConstraints();
		gbc_lblPreisliste.anchor = GridBagConstraints.WEST;
		gbc_lblPreisliste.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreisliste.gridx = 2;
		gbc_lblPreisliste.gridy = 4;
		panel.add(lblPreisliste, gbc_lblPreisliste);
		
		txtPreisliste = new JTextField();
		txtPreisliste.setPreferredSize(new Dimension(6, 40));
		txtPreisliste.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtPreisliste2 = new GridBagConstraints();
		gbc_txtPreisliste2.insets = new Insets(0, 0, 5, 5);
		gbc_txtPreisliste2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreisliste2.gridx = 3;
		gbc_txtPreisliste2.gridy = 4;
		panel.add(txtPreisliste, gbc_txtPreisliste2);
		txtPreisliste.setColumns(10);
		
		JLabel lblPreislisteid = new JLabel("PreislisteID:");
		lblPreislisteid.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblPreislisteid = new GridBagConstraints();
		gbc_lblPreislisteid.anchor = GridBagConstraints.WEST;
		gbc_lblPreislisteid.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreislisteid.gridx = 2;
		gbc_lblPreislisteid.gridy = 5;
		panel.add(lblPreislisteid, gbc_lblPreislisteid);
		
		txtID = new JTextField();
		txtID.setPreferredSize(new Dimension(6, 40));
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtID2 = new GridBagConstraints();
		gbc_txtID2.insets = new Insets(0, 0, 5, 5);
		gbc_txtID2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID2.gridx = 3;
		gbc_txtID2.gridy = 5;
		panel.add(txtID, gbc_txtID2);
		txtID.setColumns(10);
		
		JLabel lblErforderlicherFhrerschein = new JLabel("erforderlicher F\u00FChrerschein:");
		lblErforderlicherFhrerschein.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblErforderlicherFhrerschein = new GridBagConstraints();
		gbc_lblErforderlicherFhrerschein.insets = new Insets(0, 0, 5, 5);
		gbc_lblErforderlicherFhrerschein.anchor = GridBagConstraints.WEST;
		gbc_lblErforderlicherFhrerschein.gridwidth = 2;
		gbc_lblErforderlicherFhrerschein.gridx = 2;
		gbc_lblErforderlicherFhrerschein.gridy = 7;
		panel.add(lblErforderlicherFhrerschein, gbc_lblErforderlicherFhrerschein);
		
		JCheckBox chckbxSegelschein = new JCheckBox("Segelschein");
		chckbxSegelschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSegelschein = new GridBagConstraints();
		gbc_chckbxSegelschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSegelschein.gridx = 2;
		gbc_chckbxSegelschein.gridy = 8;
		panel.add(chckbxSegelschein, gbc_chckbxSegelschein);
		
		JCheckBox chckbxSurfschein = new JCheckBox("Surfschein");
		chckbxSurfschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxSurfschein = new GridBagConstraints();
		gbc_chckbxSurfschein.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSurfschein.gridx = 3;
		gbc_chckbxSurfschein.gridy = 8;
		panel.add(chckbxSurfschein, gbc_chckbxSurfschein);
		
		JCheckBox chckbxMotorbootschein = new JCheckBox("Motorbootschein");
		chckbxMotorbootschein.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_chckbxMotorbootschein = new GridBagConstraints();
		gbc_chckbxMotorbootschein.gridx = 4;
		gbc_chckbxMotorbootschein.gridy = 8;
		panel.add(chckbxMotorbootschein, gbc_chckbxMotorbootschein);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnBestaetigen = new JButton("best\u00E4tigen");
		btnBestaetigen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(573, Short.MAX_VALUE)
					.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbrechen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBestaetigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		

		
		
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				
				
				String eineStdStr;
				String zweiStdStr;
				String vierStdStr;
				String einenTagStr;
				String zweiTageStr;
				String dreiTageStr;
				String vierTageStr;
				String fuenfTageStr;
				String sechsSiebenTageStr;
				String achtTageStr;
				String neunTageStr;
				String zehnTageStr;
				String elfTageStr;
				String zwoelfVierzehnTageStr;
				String fuenfzehnTageStr;
				String sechzehnTageStr;
				String siebzehnTageStr;
				String achtzehnEinundzwanzigTageStr;
				String tagVierWochenStr;
				String vierWochenStr;
				String achtWochenStr;
				String kaufStr;
				
				
				String name;
				String schein;
				
				try {
					
					name = txtPreisliste.getText();
					id  = Integer.parseInt(txtID.getText());	
					
					if(chckbxSegelschein.isSelected() == true)
						schein = "Segelschein";
					else if(chckbxSurfschein.isSelected() == true)
						schein = "Surfschein";
					else if(chckbxMotorbootschein.isSelected() == true)
						schein = "Motorbootschein";
					else
						schein = null;
					

					controller.preislisteUebergeben(eineStd,  zweiStd,  vierStd,  einenTag,
							 zweiTage,  dreiTage,  vierTage,  fuenfTage,  sechsSiebenTage,
							 achtTage,  neunTage,  zehnTage,  elfTage,  zwoelfVierzehnTage,
							 fuenfzehnTage,  sechzehnTage,  siebzehnTage,  achtzehnEinundzwanzigTage,
							 tagVierWochen,  vierWochen,  achtWochen,  kauf);
					aktualisieren(model);
					MainFrame.change(MainFrame.getPreislisteAnlegenGUI(), MainFrame.getPreislisteGUI());
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.change(MainFrame.getPreislisteAnlegenGUI(), MainFrame.getPreislisteGUI());			}
		});

	}


	@Override
	public void aktualisieren(IAnlegenModel model) {
		JOptionPane.showMessageDialog(null, "Der Preisliste wurde angelegt!");
	}
	
}
