package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Datenbankmodels.IAnlegenModel;
import Datenbankmodels.IModel;
import Datenbankmodels.KundeRegistrierenModel;
import Datenbankmodels.TypAnlegenModel;
import Datenbankmodels.TypAnzeigeModel;
import Steuerung.KundeAnlegenSteuerung;
import Steuerung.TypAnlegenStrg;
import Steuerung.TypAnzeigeStrg;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Typhinzufuegen extends JPanel  implements IAnlegenView{
	private JTextField txtID;
	private JTextField txtTyp;
	
	TypAnlegenModel model;
	TypAnlegenStrg controller;

	/**
	 * 
	 * Create the panel.
	 */
	public Typhinzufuegen() {
		model = new TypAnlegenModel();
		controller = new TypAnlegenStrg(model);
		model.anmelden(this);
		
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel("Typ:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel label_1 = new JLabel("Nummer:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton button = new JButton("abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.change(MainFrame.getTyphinzufuegen(), MainFrame.getGeraeteTypVerwaltung());
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button_1 = new JButton("best\u00E4tigen");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				String name;
				String schein;
				
				try {
					
					id  = Integer.parseInt(txtID.getText());	
					name = txtTyp.getText();
					
					//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					//!!!Label und Textfeld für Führerschein müssen noch implementiert werden!!!!!!!
					//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					schein = null;
					

					controller.typUebergeben(id, name, schein);
					aktualisieren(model);
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
			
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		txtTyp = new JTextField();
		txtTyp.setColumns(10);
		
		JLabel lblTypHinzufgen = new JLabel("Typ hinzuf\u00FCgen:");
		lblTypHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 32));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(84)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypHinzufgen, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTyp, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(252, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(124)
					.addComponent(lblTypHinzufgen, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtTyp, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}

	@Override
	public void aktualisieren(IAnlegenModel model) {
		JOptionPane.showMessageDialog(null, "Der Gerätetyp wurde angelegt!");
	}
}
